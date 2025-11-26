package com.sec.common.p125c;

import android.text.TextUtils;
import android.util.Log;
import com.sec.common.util.C5052r;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: LogcatLogger.java */
/* renamed from: com.sec.common.c.b */
/* loaded from: classes.dex */
public class C4974b extends AbstractC4973a {
    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: a */
    protected void mo18648a(String str, String str2) {
        Log.v("ChatON", C5052r.m19199a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: b */
    public void mo18651b(String str, String str2) {
        Log.d("ChatON", C5052r.m19199a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: c */
    public void mo18653c(String str, String str2) {
        Log.i("ChatON", C5052r.m19199a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: d */
    public void mo18654d(String str, String str2) {
        Log.w("ChatON", C5052r.m19199a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2));
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: b */
    public void mo18652b(String str, String str2, Throwable th) throws IOException {
        String strM18896a = m18896a(th);
        if ((!TextUtils.isEmpty(str2) && str2.contains("imei=")) || strM18896a.contains("imei=")) {
            Log.w("ChatON", C5052r.m19199a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2 + "\n" + strM18896a));
        } else {
            Log.e("ChatON", C5052r.m19199a("[", Long.valueOf(Thread.currentThread().getId()), "][", str, "] ", str2), th);
        }
    }

    /* renamed from: a */
    public String m18896a(Throwable th) throws IOException {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        try {
            String string = stringWriter.toString();
            try {
                stringWriter.close();
                return string;
            } catch (IOException e) {
                e.printStackTrace();
                return string;
            }
        } catch (Throwable th2) {
            try {
                stringWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw th2;
        }
    }
}
