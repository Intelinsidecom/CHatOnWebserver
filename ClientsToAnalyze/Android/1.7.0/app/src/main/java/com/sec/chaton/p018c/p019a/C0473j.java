package com.sec.chaton.p018c.p019a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1341p;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.c.a.j */
/* loaded from: classes.dex */
public class C0473j {

    /* renamed from: b */
    private static C0473j f1507b = null;

    /* renamed from: a */
    public Map f1508a = new HashMap();

    /* renamed from: a */
    public static C0473j m2410a() {
        if (f1507b == null) {
            f1507b = new C0473j();
        }
        return f1507b;
    }

    /* renamed from: a */
    public boolean m2412a(long j) {
        return ((C0467d) this.f1508a.get(Long.valueOf(j))) != null;
    }

    /* renamed from: b */
    public AsyncTaskC0466c m2414b(long j) {
        C0467d c0467d = (C0467d) this.f1508a.get(Long.valueOf(j));
        if (c0467d == null) {
            return null;
        }
        return c0467d.m2388b();
    }

    /* renamed from: a */
    public void m2411a(View view, ChatFragment chatFragment, Handler handler, int i, String str, boolean z, String str2, long j, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str3) {
        String[] strArrSplit = str.split("\n");
        C1341p.m4658b("[downloadFile2]", getClass().getName());
        AsyncTaskC0466c asyncTaskC0466cM2396a = new C0469f().m2404a(strArrSplit[2]).m2399a(handler).m2402a(enumC0651d).m2400a(view).m2406b(strArrSplit[4]).m2407c(strArrSplit[3]).m2405a(z).m2408d(str2).m2398a(j).m2403a(enumC0665r).m2397a(i).m2401a(chatFragment).m2409e(str3).m2396a();
        if (Build.VERSION.SDK_INT < 11) {
            asyncTaskC0466cM2396a.execute(new String[0]);
        } else {
            asyncTaskC0466cM2396a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
        this.f1508a.put(Long.valueOf(j), new C0467d(this, str2, asyncTaskC0466cM2396a));
        C1341p.m4658b("msdid : " + j + ", keyset=" + this.f1508a.keySet(), getClass().getName());
        C1341p.m4658b("fileDownloadInProgress : " + this.f1508a + ", addr=" + this.f1508a.hashCode(), getClass().getName());
    }

    /* renamed from: c */
    public void m2415c(long j) {
        if (this.f1508a.containsKey(Long.valueOf(j)) && ((C0467d) this.f1508a.get(Long.valueOf(j))).m2388b().cancel(true)) {
            C0635o.m2942b(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(j));
        }
    }

    /* renamed from: a */
    public boolean m2413a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f1508a.size() == 0) {
            return true;
        }
        for (Long l : this.f1508a.keySet()) {
            C0467d c0467d = (C0467d) this.f1508a.get(l);
            if (c0467d != null && str.equals(c0467d.m2387a())) {
                c0467d.m2388b().cancel(true);
                this.f1508a.remove(l);
            }
        }
        return true;
    }

    /* renamed from: d */
    public boolean m2416d(long j) {
        return (this.f1508a.size() != 0 && this.f1508a.containsKey(Long.valueOf(j)) && ((C0467d) this.f1508a.remove(Long.valueOf(j))) == null) ? false : true;
    }
}
