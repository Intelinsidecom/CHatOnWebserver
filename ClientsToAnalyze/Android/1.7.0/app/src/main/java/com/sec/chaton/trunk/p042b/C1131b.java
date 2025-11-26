package com.sec.chaton.trunk.p042b;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.trunk.b.b */
/* loaded from: classes.dex */
public class C1131b {

    /* renamed from: a */
    private static final String f3954a = C1131b.class.getSimpleName();

    /* renamed from: b */
    private static C1131b f3955b;

    /* renamed from: c */
    private Map f3956c = new HashMap();

    private C1131b() {
    }

    /* renamed from: a */
    public static C1131b m4159a() {
        if (f3955b == null) {
            f3955b = new C1131b();
        }
        return f3955b;
    }

    /* renamed from: b */
    public Map m4161b() {
        return this.f3956c;
    }

    /* renamed from: a */
    public AsyncTaskC1130a m4160a(Handler handler, String str, String str2, String str3, Object obj) {
        AsyncTaskC1130a asyncTaskC1130a = new AsyncTaskC1130a(handler, str, str2, str3, false, obj);
        asyncTaskC1130a.execute(new Void[0]);
        return asyncTaskC1130a;
    }
}
