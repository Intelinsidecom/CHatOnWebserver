package org.jboss.netty.util.internal;

/* loaded from: classes.dex */
public class ThreadLocalBoolean extends ThreadLocal {
    private final boolean defaultValue;

    public ThreadLocalBoolean() {
        this(false);
    }

    public ThreadLocalBoolean(boolean z) {
        this.defaultValue = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public Boolean initialValue() {
        return this.defaultValue ? Boolean.TRUE : Boolean.FALSE;
    }
}
