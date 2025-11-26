package com.sec.chaton.p074l;

import android.content.Context;
import android.graphics.Bitmap;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1006ae;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5048n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: SaveChatProfileWorker.java */
/* renamed from: com.sec.chaton.l.ac */
/* loaded from: classes.dex */
class CallableC2482ac implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8899a = CallableC2482ac.class.getSimpleName();

    /* renamed from: b */
    private Context f8900b;

    /* renamed from: c */
    private String f8901c;

    /* renamed from: d */
    private Bitmap f8902d;

    /* renamed from: e */
    private boolean f8903e;

    public CallableC2482ac(Context context, String str, Bitmap bitmap, boolean z) {
        this.f8900b = context;
        this.f8901c = str;
        this.f8902d = bitmap;
        this.f8903e = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Throwable {
        FileOutputStream fileOutputStream = null;
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.SaveChatProfileWorker", f8899a);
        }
        new CallableC2484b(this.f8900b, this.f8901c, false).call();
        File fileM10771b = C2496n.m10771b(this.f8900b, this.f8901c);
        try {
            if (!fileM10771b.exists() && !fileM10771b.createNewFile()) {
                throw new IOException("Can't create new profile file. " + fileM10771b.getCanonicalPath());
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileM10771b);
            try {
                this.f8902d.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                fileOutputStream2.flush();
                C5048n.m19195a(fileOutputStream2);
                if (this.f8903e) {
                    C0991aa.m6037a().m18962d(new C1006ae(new String[]{this.f8901c}));
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                C5048n.m19195a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return EnumC2508z.SAVE.m10808a();
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
