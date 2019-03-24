package org.fir3.avm.environment.classloader;

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
import com.googlecode.dex2jar.ir.IrMethod;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;

public class DexClassPool implements BinaryClassPool {
    private final BaseDexFileReader dexReader;
    private final Map<String, byte[]> classData;
    private boolean initialized;

    public DexClassPool(byte[] dexData) {
        this.dexReader = new DexFileReader(dexData);
        this.classData = new HashMap<>();
    }

    @Override
    public byte[] getBinaryClass(String className) {
        this.initialize();
        return this.classData.get(className);
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

                        DexClassPool.this.classData.put(className, data);
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
}
