package org.fir3.avm.environment.resource;

import org.fir3.avm.environment.util.CollectionUtil;

import java.util.HashSet;
import java.util.Set;

public interface IdProvider {
    class Util {
        public static <E extends IdProvider> Set<E> find(E[] haystack, int id) {
            Set<E> result = new HashSet<>();

            for (E element : haystack) {
                if (element.getId() != id) {
                    continue;
                }

                result.add(element);
            }

            return result;
        }

        public static <E extends IdProvider> E findOne(E[] haystack, int id) {
            return CollectionUtil.getFirst(Util.find(haystack, id));
        }
    }

    int getId();
}
