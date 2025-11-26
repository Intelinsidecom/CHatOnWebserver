package com.sec.chaton.p022h.p025c;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.AsyncTaskC0608x;
import com.sec.chaton.p015d.p016a.C0533aa;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.util.C1786r;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.h.c.a */
/* loaded from: classes.dex */
public class C0777a {

    /* renamed from: b */
    private static C0777a f2852b = null;

    /* renamed from: a */
    public Map f2853a = new HashMap();

    /* renamed from: a */
    public static C0777a m3326a() {
        if (f2852b == null) {
            f2852b = new C0777a();
        }
        return f2852b;
    }

    /* renamed from: a */
    public boolean m3328a(long j) {
        return ((C0778b) this.f2853a.get(Long.valueOf(j))) != null;
    }

    /* renamed from: b */
    public AsyncTaskC0608x m3330b(long j) {
        C0778b c0778b = (C0778b) this.f2853a.get(Long.valueOf(j));
        if (c0778b == null) {
            return null;
        }
        return c0778b.m3334b();
    }

    /* renamed from: a */
    public void m3327a(View view, ChatFragment chatFragment, Handler handler, int i, String str, boolean z, String str2, long j, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str3) {
        String[] strArrSplit = str.split("\n");
        C1786r.m6061b("[downloadFile2]", getClass().getName());
        AsyncTaskC0608x asyncTaskC0608xM2722a = new C0533aa().m2720a(strArrSplit[2]).m2715a(handler).m2719a(enumC0699n).m2716a(view).m2723b(strArrSplit[4]).m2724c(strArrSplit[3]).m2721a(z).m2725d(str2).m2714a(j).m2718a(enumC0695j).m2713a(i).m2717a(chatFragment).m2726e(str3).m2722a();
        if (Build.VERSION.SDK_INT < 11) {
            asyncTaskC0608xM2722a.execute(new String[0]);
        } else {
            asyncTaskC0608xM2722a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
        this.f2853a.put(Long.valueOf(j), new C0778b(this, str2, asyncTaskC0608xM2722a));
        C1786r.m6061b("msdid : " + j + ", keyset=" + this.f2853a.keySet(), getClass().getName());
        C1786r.m6061b("fileDownloadInProgress : " + this.f2853a + ", addr=" + this.f2853a.hashCode(), getClass().getName());
    }

    /* renamed from: c */
    public void m3331c(long j) {
        if (this.f2853a.containsKey(Long.valueOf(j)) && ((C0778b) this.f2853a.get(Long.valueOf(j))).m3334b().cancel(true)) {
            C0665i.m3068b(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(j));
        }
    }

    /* renamed from: a */
    public boolean m3329a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f2853a.size() == 0) {
            return true;
        }
        for (Long l : this.f2853a.keySet()) {
            C0778b c0778b = (C0778b) this.f2853a.get(l);
            if (c0778b != null && str.equals(c0778b.m3333a())) {
                c0778b.m3334b().cancel(true);
                this.f2853a.remove(l);
            }
        }
        return true;
    }

    /* renamed from: d */
    public boolean m3332d(long j) {
        return (this.f2853a.size() != 0 && this.f2853a.containsKey(Long.valueOf(j)) && ((C0778b) this.f2853a.remove(Long.valueOf(j))) == null) ? false : true;
    }
}
