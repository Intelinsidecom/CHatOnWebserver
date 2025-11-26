package com.sec.chaton.push.util;

import android.util.Log;

/* compiled from: LogcatLogger.java */
/* renamed from: com.sec.chaton.push.util.c */
/* loaded from: classes.dex */
public class C3111c extends AbstractC3109a {
    @Override // com.sec.chaton.push.util.AbstractC3109a
    /* renamed from: e */
    public void mo12680e(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.sec.chaton.push.util.AbstractC3109a
    /* renamed from: f */
    public void mo12681f(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.sec.chaton.push.util.AbstractC3109a
    /* renamed from: g */
    public void mo12682g(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.sec.chaton.push.util.AbstractC3109a
    /* renamed from: b */
    public void mo12677b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
