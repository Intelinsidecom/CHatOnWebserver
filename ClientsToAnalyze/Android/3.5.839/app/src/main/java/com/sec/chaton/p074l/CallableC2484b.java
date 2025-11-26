package com.sec.chaton.p074l;

import android.content.Context;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1006ae;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: DeleteChatProfileWorker.java */
/* renamed from: com.sec.chaton.l.b */
/* loaded from: classes.dex */
class CallableC2484b implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8909a = CallableC2484b.class.getSimpleName();

    /* renamed from: b */
    private Context f8910b;

    /* renamed from: c */
    private String f8911c;

    /* renamed from: d */
    private boolean f8912d;

    public CallableC2484b(Context context, String str, boolean z) {
        this.f8910b = context;
        this.f8911c = str;
        this.f8912d = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.DeleteChatProfileWorker", f8909a);
        }
        File fileM10771b = C2496n.m10771b(this.f8910b, this.f8911c);
        if (fileM10771b.exists() && !fileM10771b.delete()) {
            throw new IOException("Can't delete chat profile image. inbox no: " + this.f8911c);
        }
        if (this.f8912d) {
            C0991aa.m6037a().m18962d(new C1006ae(new String[]{this.f8911c}));
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
