package com.sec.chaton.p074l;

import android.content.Context;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1012ak;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: DeleteGroupProfileWorker.java */
/* renamed from: com.sec.chaton.l.c */
/* loaded from: classes.dex */
class CallableC2485c implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8913a = CallableC2485c.class.getSimpleName();

    /* renamed from: b */
    private Context f8914b;

    /* renamed from: c */
    private List<String> f8915c;

    /* renamed from: d */
    private boolean f8916d;

    public CallableC2485c(Context context, List<String> list, boolean z) {
        this.f8914b = context;
        this.f8915c = list;
        this.f8916d = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.DeleteGroupProfileWorker", f8913a);
        }
        Iterator<String> it = this.f8915c.iterator();
        while (it.hasNext()) {
            File fileM10780c = C2496n.m10780c(this.f8914b, it.next());
            if (fileM10780c.exists() && !fileM10780c.delete()) {
                throw new IOException("Can't delete group profile image. " + fileM10780c);
            }
        }
        if (this.f8916d) {
            C0991aa.m6037a().m18962d(new C1012ak(this.f8915c));
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
