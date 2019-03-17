package org.fir3.avm.environment.resource;

import lombok.Data;

import java.util.Collections;
import java.util.Set;

@Data
public class StringPool implements ResourceTypeProvider {
    private static final long NULL_REFERENCE = 0xFFFFFFFFL;

    private final String[] pool;

    public String getReference(long index) {
        // NOTE: It looks like that 0xFFFFFFFF (2 ^ 32 - 1) is the null reference. Although this has not been documented
        //       anywhere (or am I wrong?), we implement this behaviour here.

        if (index == StringPool.NULL_REFERENCE) {
            return null;
        }

        if (index > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Indices greater than signed integer are not allowed!");
        }

        return this.pool[(int) index];
    }

    @Override
    public Set<ResourceType> getResourceTypes() {
        return Collections.singleton(ResourceType.StringPool);
    }
}
