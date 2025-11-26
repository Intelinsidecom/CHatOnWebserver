package org.p138a.p139a.p140a;

/* compiled from: PoolUtils.java */
/* renamed from: org.a.a.a.g */
/* loaded from: classes.dex */
public final class C5224g {
    /* renamed from: a */
    public static void m19907a(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }
}
