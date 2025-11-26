package com.sec.chaton.trunk.p120b;

import android.os.Handler;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.chaton.trunk.b.a */
/* loaded from: classes.dex */
public class C4603a {

    /* renamed from: a */
    private static final String f16734a = C4603a.class.getSimpleName();

    /* renamed from: b */
    private static C4603a f16735b;

    /* renamed from: c */
    private Map<String, AsyncTaskC4604b> f16736c = new HashMap();

    private C4603a() {
    }

    /* renamed from: a */
    public static C4603a m17553a() {
        if (f16735b == null) {
            f16735b = new C4603a();
        }
        return f16735b;
    }

    /* renamed from: b */
    public Map<String, AsyncTaskC4604b> m17555b() {
        return this.f16736c;
    }

    /* renamed from: a */
    public AsyncTaskC4604b m17554a(Handler handler, String str, String str2, String str3, Object obj, boolean z) {
        if (str3 == null) {
            C4904y.m18639b("File name is null", getClass().getSimpleName());
            return null;
        }
        this.f16736c.get(str2 + File.separator + str3);
        try {
            AsyncTaskC4604b asyncTaskC4604b = new AsyncTaskC4604b(handler, str, str2, str3, false, obj, z);
            asyncTaskC4604b.execute(new Void[0]);
            return asyncTaskC4604b;
        } catch (RejectedExecutionException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            return null;
        }
    }
}
