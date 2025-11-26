package com.sec.chaton.p074l;

import android.content.Context;
import android.graphics.Bitmap;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0992ab;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5048n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: SaveBuddyProfileWorker.java */
/* renamed from: com.sec.chaton.l.ab */
/* loaded from: classes.dex */
class CallableC2481ab implements InterfaceC2493k, Callable<Void> {

    /* renamed from: a */
    private static final String f8894a = CallableC2481ab.class.getSimpleName();

    /* renamed from: b */
    private Context f8895b;

    /* renamed from: c */
    private String f8896c;

    /* renamed from: d */
    private Bitmap f8897d;

    /* renamed from: e */
    private boolean f8898e;

    public CallableC2481ab(Context context, String str, Bitmap bitmap, boolean z) {
        this.f8895b = context;
        this.f8896c = str;
        this.f8897d = bitmap;
        this.f8898e = z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Throwable {
        FileOutputStream fileOutputStream = null;
        if (C4904y.f17872b) {
            C4904y.m18639b("ProfileImageManager.SaveBuddyProfileWorker", f8894a);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f8896c);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        new CallableC2479a(this.f8895b, listUnmodifiableList, false).call();
        File fileM10757a = C2496n.m10757a(this.f8895b, this.f8896c);
        try {
            if (!fileM10757a.exists() && !fileM10757a.createNewFile()) {
                throw new IOException("Can't create new profile file. " + fileM10757a.getCanonicalPath());
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileM10757a);
            try {
                this.f8897d.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                fileOutputStream2.flush();
                C5048n.m19195a(fileOutputStream2);
                if (this.f8898e) {
                    C0991aa.m6037a().m18962d(new C0992ab(listUnmodifiableList));
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
