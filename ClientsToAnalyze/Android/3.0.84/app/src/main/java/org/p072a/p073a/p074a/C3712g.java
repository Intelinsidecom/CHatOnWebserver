package org.p072a.p073a.p074a;

/* compiled from: PoolUtils.java */
/* renamed from: org.a.a.a.g */
/* loaded from: classes.dex */
public final class C3712g {
    /* renamed from: a */
    public static void m13379a(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }
}
