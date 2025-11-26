package com.sec.chaton.plugin.p084c;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.smsplugin.p102b.C3790i;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: SMSUtils.java */
/* renamed from: com.sec.chaton.plugin.c.a */
/* loaded from: classes.dex */
public class C2934a {

    /* renamed from: a */
    public static final String f10821a = C2934a.class.getSimpleName();

    /* renamed from: b */
    private C2937d f10822b;

    /* renamed from: c */
    private Context f10823c;

    /* renamed from: d */
    private Handler f10824d;

    /* renamed from: e */
    private Collection<Long> f10825e;

    public C2934a(Handler handler, Context context, ArrayList<String> arrayList) {
        this.f10824d = handler;
        this.f10823c = context;
        this.f10822b = new C2937d(this, this.f10823c.getContentResolver());
        this.f10825e = m12169a(arrayList);
    }

    /* renamed from: a */
    public void m12171a(boolean z) {
        if (this.f10825e == null) {
            if (this.f10824d != null) {
                this.f10824d.sendEmptyMessage(3);
            }
        } else if (z) {
            new AsyncTaskC2935b(this).execute(this.f10825e.toArray(new Long[0]));
        } else {
            new AsyncTaskC2936c(this).execute(this.f10825e.toArray(new Long[0]));
        }
    }

    /* renamed from: a */
    private Collection<Long> m12169a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(Long.valueOf(Long.parseLong(arrayList.get(i))));
        }
        return arrayList2;
    }

    /* renamed from: a */
    public void m12170a() {
        C3790i.m14328a(this.f10822b, this.f10825e, 1802);
    }
}
