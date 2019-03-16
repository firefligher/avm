package org.fir3.avm.environment.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtil {
    public static <Element> Element getFirst(Collection<Element> collection) {
        Iterator<Element> iterator = collection.iterator();

        if (!iterator.hasNext()) {
            throw new IllegalStateException("Specified collection is empty!");
        }

        return iterator.next();
    }
}
