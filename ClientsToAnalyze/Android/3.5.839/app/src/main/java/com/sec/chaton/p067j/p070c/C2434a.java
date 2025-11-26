package com.sec.chaton.p067j.p070c;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.j.c.a */
/* loaded from: classes.dex */
public class C2434a {

    /* renamed from: b */
    private static C2434a f8692b = null;

    /* renamed from: a */
    public Map<Long, C2435b> f8693a = new HashMap();

    /* renamed from: a */
    public static C2434a m10540a() {
        if (f8692b == null) {
            f8692b = new C2434a();
        }
        return f8692b;
    }

    /* renamed from: a */
    public boolean m10542a(long j) {
        return this.f8693a.get(Long.valueOf(j)) != null;
    }

    /* renamed from: a */
    public boolean m10543a(long j, boolean z) {
        C2435b c2435b = this.f8693a.get(Long.valueOf(j));
        if (c2435b == null || c2435b.m10549b() == null) {
            return false;
        }
        return z == c2435b.m10549b().m10557a();
    }

    /* renamed from: b */
    public AsyncTaskC2436c m10545b(long j) {
        C2435b c2435b = this.f8693a.get(Long.valueOf(j));
        if (c2435b == null) {
            return null;
        }
        return c2435b.m10549b();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m10541a(View view, ChatFragment chatFragment, Handler handler, int i, String str, boolean z, String str2, long j, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str3) {
        String[] strArrSplit = str.split("\n");
        if (C4904y.f17872b) {
            C4904y.m18639b("[downloadFile2]", getClass().getName());
        }
        C2437d c2437d = new C2437d();
        if (strArrSplit.length >= 5) {
            AsyncTaskC2436c asyncTaskC2436cM10558a = c2437d.m10566a(strArrSplit[2]).m10561a(handler).m10564a(enumC2214ab).m10562a(view).m10568b(strArrSplit[4]).m10569c(strArrSplit[3]).m10567a(z).m10570d(str2).m10560a(j).m10565a(enumC2300t).m10559a(i).m10563a(chatFragment).m10571e(str3).m10558a();
            if (Build.VERSION.SDK_INT < 11 || z) {
                asyncTaskC2436cM10558a.execute(new String[0]);
            } else {
                asyncTaskC2436cM10558a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
            this.f8693a.put(Long.valueOf(j), new C2435b(this, str2, asyncTaskC2436cM10558a));
            return;
        }
        if (CommonApplication.m18732r() != null) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.media_download_fail, 0);
        }
    }

    /* renamed from: c */
    public void m10546c(long j) {
        if (this.f8693a.containsKey(Long.valueOf(j))) {
            this.f8693a.get(Long.valueOf(j)).m10549b().cancel(false);
        }
    }

    /* renamed from: a */
    public boolean m10544a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f8693a.size() == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, C2435b> entry : this.f8693a.entrySet()) {
            C2435b value = entry.getValue();
            if (value != null && str.equals(value.m10548a())) {
                value.m10549b().cancel(true);
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f8693a.remove((Long) it.next());
        }
        return true;
    }

    /* renamed from: d */
    public boolean m10547d(long j) {
        return (this.f8693a.size() != 0 && this.f8693a.containsKey(Long.valueOf(j)) && this.f8693a.remove(Long.valueOf(j)) == null) ? false : true;
    }
}
