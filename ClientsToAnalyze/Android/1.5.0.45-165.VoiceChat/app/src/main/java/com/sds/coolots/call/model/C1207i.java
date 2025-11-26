package com.sds.coolots.call.model;

import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.call.model.i */
/* loaded from: classes.dex */
public class C1207i {

    /* renamed from: a */
    private static int f2688a = 0;

    /* renamed from: b */
    private int f2689b = m2637b();

    public C1207i() {
        m2638b("created a call instance id: " + this.f2689b);
    }

    /* renamed from: a */
    private void m2636a(String str) {
        Log.m2958e("[TranslationController]" + str);
    }

    /* renamed from: b */
    private int m2637b() {
        int i = f2688a + 1;
        f2688a = i;
        return i;
    }

    /* renamed from: b */
    private void m2638b(String str) {
        Log.m2963i("[TranslationController]" + str);
    }

    /* renamed from: a */
    public int m2639a() {
        return this.f2689b;
    }
}
