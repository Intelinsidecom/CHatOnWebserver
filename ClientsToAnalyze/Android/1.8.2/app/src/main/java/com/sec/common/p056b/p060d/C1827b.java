package com.sec.common.p056b.p060d;

import android.util.Log;

/* compiled from: LogcatLogger.java */
/* renamed from: com.sec.common.b.d.b */
/* loaded from: classes.dex */
public class C1827b extends AbstractC1826a {
    @Override // com.sec.common.p056b.p060d.AbstractC1826a
    /* renamed from: d */
    public void mo6205d(String str, String str2) {
        Log.d("ChatON", str + " " + str2);
    }

    @Override // com.sec.common.p056b.p060d.AbstractC1826a
    /* renamed from: e */
    public void mo6206e(String str, String str2) {
        Log.w("ChatON", str + " " + str2);
    }

    @Override // com.sec.common.p056b.p060d.AbstractC1826a
    /* renamed from: b */
    public void mo6203b(String str, String str2, Throwable th) {
        Log.e("ChatON", str + " " + str2, th);
    }
}
