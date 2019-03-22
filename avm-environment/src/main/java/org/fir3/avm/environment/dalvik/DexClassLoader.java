package org.fir3.avm.environment.dalvik;

import com.googlecode.d2j.Method;
import com.googlecode.d2j.converter.IR2JConverter;
import com.googlecode.d2j.dex.ClassVisitorFactory;
import com.googlecode.d2j.dex.DexExceptionHandler;
import com.googlecode.d2j.dex.ExDex2Asm;
import com.googlecode.d2j.dex.LambadaNameSafeClassAdapter;
import com.googlecode.d2j.node.DexFileNode;
import com.googlecode.d2j.node.DexMethodNode;
import com.googlecode.d2j.reader.BaseDexFileReader;
import com.googlecode.d2j.reader.DexFileReader;
import com.googlecode.d2j.reader.MultiDexFileReader;
import com.googlecode.dex2jar.ir.IrMethod;
import lombok.extern.java.Log;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

@Log
public class DexClassLoader extends ClassLoader {
    private final BaseDexFileReader dexReader;
    private final Map<String, Class<?>> definedClasses;
    private boolean initialized;

    public DexClassLoader(InputStream... sources) throws IOException {
        this.dexReader = MultiDexFileReader.from(sources);
        this.definedClasses = new HashMap<>();
    }

    private void initialize() {
        if (this.initialized) {
            return;
        }

        this.initialized = true;

        // TODO: Make this method more lightweight

        DexFileNode fileNode = new DexFileNode();

        try {
            this.dexReader.accept(fileNode, DexFileReader.SKIP_DEBUG | DexFileReader.IGNORE_READ_EXCEPTION);
        } catch (Exception ex) {
            throw new IllegalStateException("Failed reading dex", ex);
        }

        ClassVisitorFactory cvf = new ClassVisitorFactory() {
            @Override
            public ClassVisitor create(final String classInternalName) {
                final ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                final LambadaNameSafeClassAdapter adapter = new LambadaNameSafeClassAdapter(writer);

                return new ClassVisitor(Opcodes.ASM5, adapter) {
                    @Override
                    public void visitEnd() {
                        super.visitEnd();

                        String className = adapter.getClassName().replace('/', '.');
                        byte[] data;

                        try {
                            data = writer.toByteArray();
                        } catch (Exception ex) {
                            throw new IllegalStateException("Failed generating byte code for " + className);
                        }

                        // TODO: Maybe use a ProtectionDomain? (Missing security concept...)

                        DexClassLoader.this.definedClasses.put(className, DexClassLoader.super.defineClass(
                                className, data, 0, data.length));

                        log.log(Level.INFO, "Defined class: {0}", className);
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
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        this.initialize();

        if (this.definedClasses.containsKey(name)) {
            return this.definedClasses.get(name);
        }

        return super.findClass(name);
    }
}
