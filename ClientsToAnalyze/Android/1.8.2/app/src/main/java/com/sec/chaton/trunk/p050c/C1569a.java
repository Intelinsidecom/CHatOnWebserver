package com.sec.chaton.trunk.p050c;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.trunk.c.a */
/* loaded from: classes.dex */
public class C1569a {

    /* renamed from: a */
    private static final String f5649a = C1569a.class.getSimpleName();

    /* renamed from: b */
    private static C1569a f5650b;

    /* renamed from: c */
    private Map f5651c = new HashMap();

    private C1569a() {
    }

    /* renamed from: a */
    public static C1569a m5430a() {
        if (f5650b == null) {
            f5650b = new C1569a();
        }
        return f5650b;
    }

    /* renamed from: b */
    public Map m5432b() {
        return this.f5651c;
    }

    /* renamed from: a */
    public AsyncTaskC1570b m5431a(Handler handler, String str, String str2, String str3, Object obj) {
        AsyncTaskC1570b asyncTaskC1570b = new AsyncTaskC1570b(handler, str, str2, str3, false, obj);
        asyncTaskC1570b.execute(new Void[0]);
        return asyncTaskC1570b;
    }
}
