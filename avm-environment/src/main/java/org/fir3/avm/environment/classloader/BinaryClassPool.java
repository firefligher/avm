package org.fir3.avm.environment.classloader;

/**
 * A data pool that contains binary (JVM-encoded) class data.
 */
public interface BinaryClassPool {
    /**
     * Gets the class from this pool that corresponds to the specified <code>className</code>.
     *
     * @param className The binary name of the class (e.g. <code>javax.swing.JSpinner$DefaultEditor</code>)
     * @return
     * Either the binary representation of the class that corresponds to the specified <code>className</code> or
     * <code>null</code>, if this pool does not contain a class that corresponds to the specified
     * <code>className</code>.
     */
    byte[] getBinaryClass(String className);
}
