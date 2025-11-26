package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2521l;
import com.sec.chaton.util.C3250y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DownloadableCounter.java */
/* renamed from: com.sec.chaton.settings.downloads.aw */
/* loaded from: classes.dex */
class C2556aw {

    /* renamed from: a */
    static final String f9708a = C2556aw.class.getSimpleName();

    /* renamed from: b */
    public static int f9709b = 8000;

    /* renamed from: c */
    public static int f9710c = 0;

    /* renamed from: d */
    public static int f9711d = 1;

    /* renamed from: e */
    Handler f9712e;

    /* renamed from: f */
    private HashMap<String, EnumC2558ay> f9713f = new HashMap<>();

    /* renamed from: a */
    public void m9498a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("clear()", f9708a);
        }
        if (this.f9713f != null) {
            this.f9713f.clear();
        }
    }

    /* renamed from: a */
    public void m9499a(Handler handler) {
        this.f9712e = handler;
    }

    /* renamed from: a */
    public boolean m9500a(C2521l c2521l) {
        if (c2521l == null) {
            return false;
        }
        EnumC2558ay enumC2558ay = EnumC2558ay.STATUS_NOT_INSTALLED;
        String strM9454c = c2521l.m9454c();
        switch (c2521l.m9455d()) {
            case 0:
            case 1:
            case 2:
            case 6:
                enumC2558ay = EnumC2558ay.STATUS_INSTALL_PROGRESSING;
                break;
            case 3:
            case 5:
                enumC2558ay = EnumC2558ay.STATUS_NOT_INSTALLED;
                break;
            case 4:
                enumC2558ay = EnumC2558ay.STATUS_INSTALLED;
                break;
        }
        return m9497a(strM9454c, enumC2558ay, false);
    }

    /* renamed from: a */
    public boolean m9502a(String str, EnumC2558ay enumC2558ay) {
        return m9497a(str, enumC2558ay, false);
    }

    /* renamed from: b */
    public boolean m9504b(String str, EnumC2558ay enumC2558ay) {
        return m9497a(str, enumC2558ay, true);
    }

    /* renamed from: a */
    private boolean m9497a(String str, EnumC2558ay enumC2558ay, boolean z) {
        if (this.f9713f == null) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("setStatus(), mItems is (null)", f9708a);
            return false;
        }
        EnumC2558ay enumC2558ayPut = this.f9713f.put(str, enumC2558ay);
        boolean z2 = enumC2558ayPut == null || !enumC2558ayPut.equals(enumC2558ay);
        if (C3250y.f11734b) {
        }
        if (z && z2) {
            m9503b();
        }
        return z2;
    }

    /* renamed from: b */
    public void m9503b() {
        if (this.f9712e != null) {
            Message.obtain(this.f9712e, f9709b, m9505c() ? f9711d : f9710c, 0, null).sendToTarget();
        }
    }

    /* renamed from: c */
    public boolean m9505c() {
        if (C3250y.f11734b) {
            C3250y.m11450b("hasDownloadable()", f9708a);
        }
        Iterator<Map.Entry<String, EnumC2558ay>> it = this.f9713f.entrySet().iterator();
        while (it.hasNext()) {
            if (m9501a(it.next().getValue())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m9501a(EnumC2558ay enumC2558ay) {
        switch (enumC2558ay) {
            case STATUS_NOT_INSTALLED:
                return true;
            default:
                return false;
        }
    }
}
