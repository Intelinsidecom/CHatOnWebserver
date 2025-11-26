package org.jboss.netty.util.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
class AtomicFieldUpdaterUtil {
    private static final boolean AVAILABLE;

    final class Node {
        volatile Node next;

        Node() {
        }
    }

    static {
        Node node;
        boolean z = false;
        try {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");
            node = new Node();
            atomicReferenceFieldUpdaterNewUpdater.set(node, node);
        } catch (Throwable th) {
        }
        if (node.next != node) {
            throw new Exception();
        }
        z = true;
        AVAILABLE = z;
    }

    static <T, V> AtomicReferenceFieldUpdater<T, V> newRefUpdater(Class<T> cls, Class<V> cls2, String str) {
        if (AVAILABLE) {
            return AtomicReferenceFieldUpdater.newUpdater(cls, cls2, str);
        }
        return null;
    }

    static <T> AtomicIntegerFieldUpdater<T> newIntUpdater(Class<T> cls, String str) {
        if (AVAILABLE) {
            return AtomicIntegerFieldUpdater.newUpdater(cls, str);
        }
        return null;
    }

    static boolean isAvailable() {
        return AVAILABLE;
    }
}
