package com.sec.chaton.trunk.p060b;

import android.os.Handler;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.trunk.b.a */
/* loaded from: classes.dex */
public class C2987a {

    /* renamed from: a */
    private static final String f10813a = C2987a.class.getSimpleName();

    /* renamed from: b */
    private static C2987a f10814b;

    /* renamed from: c */
    private Map<String, AsyncTaskC2988b> f10815c = new HashMap();

    private C2987a() {
    }

    /* renamed from: a */
    public static C2987a m10482a() {
        if (f10814b == null) {
            f10814b = new C2987a();
        }
        return f10814b;
    }

    /* renamed from: b */
    public Map<String, AsyncTaskC2988b> m10484b() {
        return this.f10815c;
    }

    /* renamed from: a */
    public AsyncTaskC2988b m10483a(Handler handler, String str, String str2, String str3, Object obj, boolean z) {
        if (str3 == null) {
            C3250y.m11450b("File name is null", getClass().getSimpleName());
            return null;
        }
        this.f10815c.get(str2 + File.separator + str3);
        try {
            AsyncTaskC2988b asyncTaskC2988b = new AsyncTaskC2988b(handler, str, str2, str3, false, obj, z);
            asyncTaskC2988b.execute(new Void[0]);
            return asyncTaskC2988b;
        } catch (RejectedExecutionException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            return null;
        }
    }
}
