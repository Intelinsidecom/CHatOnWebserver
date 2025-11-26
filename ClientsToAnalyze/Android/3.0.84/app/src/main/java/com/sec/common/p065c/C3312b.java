package com.sec.common.p065c;

import android.text.TextUtils;
import android.util.Log;
import com.sec.common.util.C3364o;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: LogcatLogger.java */
/* renamed from: com.sec.common.c.b */
/* loaded from: classes.dex */
public class C3312b extends AbstractC3311a {
    @Override // com.sec.common.p065c.AbstractC3311a
    /* renamed from: d */
    public void mo11657d(String str, String str2) {
        Log.d("ChatON", C3364o.m11849a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p065c.AbstractC3311a
    /* renamed from: e */
    public void mo11658e(String str, String str2) {
        Log.i("ChatON", C3364o.m11849a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p065c.AbstractC3311a
    /* renamed from: f */
    public void mo11659f(String str, String str2) {
        Log.w("ChatON", C3364o.m11849a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p065c.AbstractC3311a
    /* renamed from: b */
    public void mo11655b(String str, String str2, Throwable th) throws IOException {
        String strM11660a = m11660a(th);
        if ((!TextUtils.isEmpty(str2) && str2.contains("imei=")) || strM11660a.contains("imei=")) {
            Log.w("ChatON", C3364o.m11849a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2 + "\n" + strM11660a));
        } else {
            Log.e("ChatON", C3364o.m11849a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2), th);
        }
    }

    /* renamed from: a */
    public String m11660a(Throwable th) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
}
