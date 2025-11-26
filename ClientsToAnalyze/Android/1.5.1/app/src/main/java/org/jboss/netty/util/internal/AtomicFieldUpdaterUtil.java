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

    private AtomicFieldUpdaterUtil() {
    }

    static boolean isAvailable() {
        return AVAILABLE;
    }

    static AtomicIntegerFieldUpdater newIntUpdater(Class cls, String str) {
        if (AVAILABLE) {
            return AtomicIntegerFieldUpdater.newUpdater(cls, str);
        }
        return null;
    }

    static AtomicReferenceFieldUpdater newRefUpdater(Class cls, Class cls2, String str) {
        if (AVAILABLE) {
            return AtomicReferenceFieldUpdater.newUpdater(cls, cls2, str);
        }
        return null;
    }
}
