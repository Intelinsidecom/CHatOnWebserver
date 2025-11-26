package com.sec.chaton.p022h.p025c;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0665i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileUploadManager.java */
/* renamed from: com.sec.chaton.h.c.c */
/* loaded from: classes.dex */
public class C0779c {

    /* renamed from: b */
    private static C0779c f2857b = null;

    /* renamed from: a */
    private Map f2858a = new HashMap();

    /* renamed from: a */
    public static synchronized C0779c m3335a() {
        if (f2857b == null) {
            f2857b = new C0779c();
        }
        return f2857b;
    }

    /* renamed from: a */
    public RunnableC0781e m3336a(long j) {
        C0780d c0780d = (C0780d) this.f2858a.get(Long.valueOf(j));
        if (c0780d == null) {
            return null;
        }
        return c0780d.m3344b();
    }

    /* renamed from: a */
    public void m3337a(Handler handler, String str, File file, long j, String str2, EnumC0695j enumC0695j, EnumC0699n enumC0699n, String[] strArr, String str3, boolean z, String str4) {
        m3338a(handler, str, file, j, str2, enumC0695j, enumC0699n, strArr, str3, z, str4, true);
    }

    /* renamed from: a */
    public void m3338a(Handler handler, String str, File file, long j, String str2, EnumC0695j enumC0695j, EnumC0699n enumC0699n, String[] strArr, String str3, boolean z, String str4, boolean z2) {
        RunnableC0781e runnableC0781e = new RunnableC0781e();
        runnableC0781e.m3354a(handler, str, file, j, str2, enumC0695j, enumC0699n, strArr, str3, z, str4);
        this.f2858a.put(Long.valueOf(j), new C0780d(this, str2, runnableC0781e));
        new Thread(runnableC0781e).start();
    }

    /* renamed from: b */
    public void m3340b(long j) {
        if (this.f2858a.containsKey(Long.valueOf(j))) {
            ((C0780d) this.f2858a.get(Long.valueOf(j))).m3344b().m3363j();
        }
        C0665i.m3049a(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(j));
    }

    /* renamed from: a */
    public boolean m3339a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f2858a.size() == 0) {
            return true;
        }
        for (Long l : this.f2858a.keySet()) {
            C0780d c0780d = (C0780d) this.f2858a.get(l);
            if (c0780d != null && str.equals(c0780d.m3343a())) {
                c0780d.m3344b().m3363j();
                this.f2858a.remove(l);
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m3341c(long j) {
        C0780d c0780d;
        if (this.f2858a.size() != 0 && this.f2858a.containsKey(Long.valueOf(j)) && (c0780d = (C0780d) this.f2858a.get(Long.valueOf(j))) != null) {
            return c0780d.m3345c();
        }
        return false;
    }

    /* renamed from: d */
    public boolean m3342d(long j) {
        return (this.f2858a.size() != 0 && this.f2858a.containsKey(Long.valueOf(j)) && ((C0780d) this.f2858a.remove(Long.valueOf(j))) == null) ? false : true;
    }
}
