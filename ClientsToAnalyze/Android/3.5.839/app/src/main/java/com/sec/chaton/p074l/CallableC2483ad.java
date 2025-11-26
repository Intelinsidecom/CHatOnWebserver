package com.sec.chaton.p074l;

import android.content.Context;
import android.graphics.Bitmap;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1012ak;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5048n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: SaveGroupProfileWorker.java */
/* renamed from: com.sec.chaton.l.ad */
/* loaded from: classes.dex */
class CallableC2483ad implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8904a = CallableC2483ad.class.getSimpleName();

    /* renamed from: b */
    private Context f8905b;

    /* renamed from: c */
    private String f8906c;

    /* renamed from: d */
    private Bitmap f8907d;

    /* renamed from: e */
    private boolean f8908e;

    public CallableC2483ad(Context context, String str, Bitmap bitmap, boolean z) {
        this.f8905b = context;
        this.f8906c = str;
        this.f8907d = bitmap;
        this.f8908e = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Throwable {
        FileOutputStream fileOutputStream = null;
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.SaveGroupProfileWorker", f8904a);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f8906c);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        new CallableC2485c(this.f8905b, listUnmodifiableList, false).call();
        File fileM10780c = C2496n.m10780c(this.f8905b, this.f8906c);
        try {
            if (!fileM10780c.exists() && !fileM10780c.createNewFile()) {
                throw new IOException("Can't create new profile file. " + fileM10780c.getCanonicalPath());
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileM10780c);
            try {
                this.f8907d.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                fileOutputStream2.flush();
                C5048n.m19195a(fileOutputStream2);
                if (this.f8908e) {
                    C0991aa.m6037a().m18962d(new C1012ak(listUnmodifiableList));
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
