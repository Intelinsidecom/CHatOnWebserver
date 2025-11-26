package com.sec.chaton.p037j.p040c;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.j.c.a */
/* loaded from: classes.dex */
public class C1555a {

    /* renamed from: b */
    private static C1555a f5739b = null;

    /* renamed from: a */
    public Map<Long, C1556b> f5740a = new HashMap();

    /* renamed from: a */
    public static C1555a m6596a() {
        if (f5739b == null) {
            f5739b = new C1555a();
        }
        return f5739b;
    }

    /* renamed from: a */
    public boolean m6598a(long j) {
        return this.f5740a.get(Long.valueOf(j)) != null;
    }

    /* renamed from: a */
    public boolean m6599a(long j, boolean z) {
        C1556b c1556b = this.f5740a.get(Long.valueOf(j));
        if (c1556b == null || c1556b.m6605b() == null) {
            return false;
        }
        return z == c1556b.m6605b().m6613a();
    }

    /* renamed from: b */
    public AsyncTaskC1557c m6601b(long j) {
        C1556b c1556b = this.f5740a.get(Long.valueOf(j));
        if (c1556b == null) {
            return null;
        }
        return c1556b.m6605b();
    }

    /* renamed from: a */
    public void m6597a(View view, ChatFragment chatFragment, Handler handler, int i, String str, boolean z, String str2, long j, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str3) {
        String[] strArrSplit = str.split("\n");
        C3250y.m11450b("[downloadFile2]", getClass().getName());
        C1560f c1560f = new C1560f();
        if (strArrSplit.length >= 5) {
            AsyncTaskC1557c asyncTaskC1557cM6614a = c1560f.m6622a(strArrSplit[2]).m6617a(handler).m6621a(enumC1455w).m6618a(view).m6624b(strArrSplit[4]).m6625c(strArrSplit[3]).m6623a(z).m6626d(str2).m6616a(j).m6620a(enumC1450r).m6615a(i).m6619a(chatFragment).m6627e(str3).m6614a();
            if (Build.VERSION.SDK_INT < 11 || z) {
                asyncTaskC1557cM6614a.execute(new String[0]);
            } else {
                asyncTaskC1557cM6614a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
            this.f5740a.put(Long.valueOf(j), new C1556b(this, str2, asyncTaskC1557cM6614a));
            C3250y.m11450b("msdid : " + j + ", keyset=" + this.f5740a.keySet(), getClass().getName());
            C3250y.m11450b("fileDownloadInProgress : " + this.f5740a + ", addr=" + this.f5740a.hashCode(), getClass().getName());
            return;
        }
        if (CommonApplication.m11493l() != null) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.media_download_fail, 0);
        }
    }

    /* renamed from: c */
    public void m6602c(long j) {
        if (this.f5740a.containsKey(Long.valueOf(j)) && this.f5740a.get(Long.valueOf(j)).m6605b().cancel(true)) {
            C1373q.m6193c(CommonApplication.m11493l().getContentResolver(), Long.valueOf(j));
        }
    }

    /* renamed from: a */
    public boolean m6600a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f5740a.size() == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, C1556b> entry : this.f5740a.entrySet()) {
            C1556b value = entry.getValue();
            if (value != null && str.equals(value.m6604a())) {
                value.m6605b().cancel(true);
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5740a.remove((Long) it.next());
        }
        return true;
    }

    /* renamed from: d */
    public boolean m6603d(long j) {
        return (this.f5740a.size() != 0 && this.f5740a.containsKey(Long.valueOf(j)) && this.f5740a.remove(Long.valueOf(j)) == null) ? false : true;
    }
}
