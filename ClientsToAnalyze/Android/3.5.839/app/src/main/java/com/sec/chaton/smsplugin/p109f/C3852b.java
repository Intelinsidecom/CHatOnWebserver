package com.sec.chaton.smsplugin.p109f;

import android.content.Context;
import android.content.res.Configuration;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: LayoutManager.java */
/* renamed from: com.sec.chaton.smsplugin.f.b */
/* loaded from: classes.dex */
public class C3852b {

    /* renamed from: b */
    private static C3852b f13851b;

    /* renamed from: a */
    private InterfaceC3853c f13852a;

    private C3852b(Context context) {
        m14739a(context.getResources().getConfiguration());
    }

    /* renamed from: a */
    private void m14739a(Configuration configuration) {
        this.f13852a = m14737a(configuration.orientation == 1 ? 11 : 10);
    }

    /* renamed from: a */
    private static InterfaceC3853c m14737a(int i) {
        switch (i) {
            case 10:
                return new C3851a(10);
            case 11:
                return new C3851a(11);
            default:
                throw new IllegalArgumentException("Unsupported display type: " + i);
        }
    }

    /* renamed from: a */
    public static void m14738a(Context context) {
        if (f13851b != null) {
            C3890m.m14997c("LayoutManager", "Already initialized.");
        }
        f13851b = new C3852b(context);
    }

    /* renamed from: a */
    public static C3852b m14736a() {
        if (f13851b == null) {
            throw new IllegalStateException("Uninitialized.");
        }
        return f13851b;
    }

    /* renamed from: b */
    public InterfaceC3853c m14740b() {
        return this.f13852a;
    }
}
