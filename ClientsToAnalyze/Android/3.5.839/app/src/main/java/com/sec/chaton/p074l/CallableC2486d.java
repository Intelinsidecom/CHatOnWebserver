package com.sec.chaton.p074l;

import android.content.Context;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1047as;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: DeleteMyProfileWorker.java */
/* renamed from: com.sec.chaton.l.d */
/* loaded from: classes.dex */
class CallableC2486d implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8917a = CallableC2486d.class.getSimpleName();

    /* renamed from: b */
    private Context f8918b;

    /* renamed from: c */
    private boolean f8919c;

    public CallableC2486d(Context context, boolean z) {
        this.f8918b = context;
        this.f8919c = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws IOException {
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.DeleteMyProfileWorker", f8917a);
        }
        File fileM10770b = C2496n.m10770b(this.f8918b);
        if (fileM10770b.exists() && !fileM10770b.delete()) {
            throw new IOException("Can't delete my profile image. " + fileM10770b);
        }
        File fileM10756a = C2496n.m10756a(this.f8918b, 0);
        if (fileM10756a.exists() && !fileM10756a.delete()) {
            throw new IOException("Can't delete my profile image. " + fileM10756a);
        }
        if (this.f8919c) {
            C0991aa.m6037a().m18962d(new C1047as());
            return null;
        }
        return null;
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return EnumC2508z.DELETE.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }
}
