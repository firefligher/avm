package org.fir3.avm.environment.dalvik;

import com.googlecode.d2j.Method;
import com.googlecode.d2j.converter.IR2JConverter;
import com.googlecode.d2j.dex.*;
import com.googlecode.d2j.node.DexFileNode;
import com.googlecode.d2j.node.DexMethodNode;
import com.googlecode.d2j.reader.BaseDexFileReader;
import com.googlecode.d2j.reader.DexFileReader;
import com.googlecode.d2j.reader.MultiDexFileReader;
import com.googlecode.dex2jar.ir.IrMethod;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.io.InputStream;

public class DexClassLoader extends ClassLoader {
    private final BaseDexFileReader dexReader;

    public DexClassLoader(InputStream... sources) throws IOException {
        this.dexReader = MultiDexFileReader.from(sources);
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        // TODO: Make this method more lightweight

        DexFileNode fileNode = new DexFileNode();

        try {
            this.dexReader.accept(fileNode, DexFileReader.SKIP_DEBUG | DexFileReader.IGNORE_READ_EXCEPTION);
        } catch (Exception ex) {
            throw new IllegalStateException("Failed reading dex", ex);
        }

        final Class[] result = new Class[1];

        ClassVisitorFactory cvf = new ClassVisitorFactory() {
            @Override
            public ClassVisitor create(final String classInternalName) {
                final ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                final LambadaNameSafeClassAdapter adapter = new LambadaNameSafeClassAdapter(writer);

                return new ClassVisitor(Opcodes.ASM5, adapter) {
                    @Override
                    public void visitEnd() {
                        super.visitEnd();

                        String className = adapter.getClassName();
                        byte[] data;

                        // Ignore this class, if it is not the requested one

                        if (!name.equals(className.replace('/', '.'))) {
                            return;
                        }

                        try {
                            data = writer.toByteArray();
                        } catch (Exception ex) {
                            throw new IllegalStateException("Failed generating byte code for " + className);
                        }

                        // TODO: Maybe use a ProtectionDomain? (Missing security concept...)

                        result[0] = DexClassLoader.super.defineClass(name, data, 0, data.length);
                    }
                };
            }
        };

        new ExDex2Asm(new DexExceptionHandler() {
            @Override
            public void handleFileException(Exception e) {
                throw new IllegalStateException(e);
            }

            @Override
            public void handleMethodTranslateException(Method method, DexMethodNode methodNode, MethodVisitor mv,
                                                       Exception e) {
                throw new IllegalStateException(e);

            }
        }) {
            @Override
            public void optimize(IrMethod irMethod) {
                T_cleanLabel.transform(irMethod);
                T_deadCode.transform(irMethod);
                T_removeLocal.transform(irMethod);
                T_removeConst.transform(irMethod);
                T_zero.transform(irMethod);

                if (T_npe.transformReportChanged(irMethod)) {
                    T_deadCode.transform(irMethod);
                    T_removeLocal.transform(irMethod);
                    T_removeConst.transform(irMethod);
                }

                T_new.transform(irMethod);
                T_fillArray.transform(irMethod);
                T_agg.transform(irMethod);
                T_multiArray.transform(irMethod);
                T_voidInvoke.transform(irMethod);
                T_type.transform(irMethod);
                T_unssa.transform(irMethod);
                T_ir2jRegAssign.transform(irMethod);
                T_trimEx.transform(irMethod);
            }

            @Override
            public void ir2j(IrMethod irMethod, MethodVisitor mv) {
                new IR2JConverter(true).convert(irMethod, mv);
            }
        }.convertDex(fileNode, cvf);

        if (result[0] != null) {
            return result[0];
        }

        return super.findClass(name);
    }
}
