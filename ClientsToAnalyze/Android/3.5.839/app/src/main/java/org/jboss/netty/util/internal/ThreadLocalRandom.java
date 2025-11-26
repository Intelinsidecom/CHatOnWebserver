package org.jboss.netty.util.internal;

import java.util.Random;

/* loaded from: classes.dex */
final class ThreadLocalRandom extends Random {
    private static final ThreadLocal<ThreadLocalRandom> localRandom = new ThreadLocal<ThreadLocalRandom>() { // from class: org.jboss.netty.util.internal.ThreadLocalRandom.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom();
        }
    };
    private boolean initialized;
    private long rnd;

    ThreadLocalRandom() {
    }

    static ThreadLocalRandom current() {
        return localRandom.get();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.initialized = true;
        this.rnd = (25214903917L ^ j) & 281474976710655L;
    }

    @Override // java.util.Random
    protected int next(int i) {
        this.rnd = ((this.rnd * 25214903917L) + 11) & 281474976710655L;
        return (int) (this.rnd >>> (48 - i));
    }
}
