package com.android.p029ex.editstyledtext;

import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.k */
/* loaded from: classes.dex */
public class C0400k {

    /* renamed from: a */
    private Object[] f985a;

    /* renamed from: b */
    final /* synthetic */ C0392c f986b;

    public C0400k(C0392c c0392c) {
        this.f986b = c0392c;
    }

    /* renamed from: b */
    protected boolean mo1305b() {
        return false;
    }

    /* renamed from: e */
    protected boolean mo1465e() {
        return mo1305b();
    }

    /* renamed from: d */
    protected boolean mo1304d() {
        return mo1465e();
    }

    /* renamed from: a */
    protected boolean mo1303a() {
        return mo1304d();
    }

    /* renamed from: c */
    protected boolean mo1462c() {
        return mo1304d();
    }

    /* renamed from: f */
    protected boolean m1466f() {
        this.f986b.f953b.m1282w();
        this.f986b.f954c.m1369g(3);
        return true;
    }

    /* renamed from: a */
    protected void m1464a(Object[] objArr) {
        this.f985a = objArr;
    }

    /* renamed from: a */
    protected Object m1463a(int i) {
        if (this.f985a != null && i <= this.f985a.length) {
            return this.f985a[i];
        }
        Log.d("EditModeActions", "--- Number of the parameter is out of bound.");
        return null;
    }
}
