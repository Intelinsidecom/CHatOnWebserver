package com.sec.chaton.push.util;

import android.util.Log;

/* compiled from: LogcatLogger.java */
/* renamed from: com.sec.chaton.push.util.c */
/* loaded from: classes.dex */
public class C0917c extends AbstractC0923i {
    public C0917c() {
    }

    public C0917c(AbstractC0923i abstractC0923i) {
        super(abstractC0923i);
    }

    @Override // com.sec.chaton.push.util.AbstractC0923i
    /* renamed from: a */
    public void mo3615a(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.sec.chaton.push.util.AbstractC0923i
    /* renamed from: b */
    public void mo3617b(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.sec.chaton.push.util.AbstractC0923i
    /* renamed from: c */
    public void mo3618c(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.sec.chaton.push.util.AbstractC0923i
    /* renamed from: a */
    public void mo3616a(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
