package com.sec.chaton.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;

/* compiled from: STranslatorPlugIn.java */
/* renamed from: com.sec.chaton.plugin.i */
/* loaded from: classes.dex */
public class C1956i implements InterfaceC1950c {

    /* renamed from: a */
    private static final String f7484a = C1956i.class.getSimpleName();

    /* renamed from: b */
    private boolean f7485b;

    public C1956i() {
        m7921i(GlobalApplication.m11493l());
    }

    /* renamed from: a */
    private boolean m7920a(Context context) {
        return C3347i.m11778a(CommonApplication.m11493l(), "com.sec.android.app.translator");
    }

    /* renamed from: i */
    private void m7921i(Context context) {
        if (m7920a(context)) {
            try {
                int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.sec.android.app.translator");
                if (applicationEnabledSetting == 3) {
                    if (C3330f.f12033a.f11972b) {
                        C3330f.f12033a.m11651a(f7484a, "STranslator is disabled by user.");
                    }
                    this.f7485b = false;
                    return;
                }
                if (applicationEnabledSetting == 2) {
                    if (C3330f.f12033a.f11972b) {
                        C3330f.f12033a.m11651a(f7484a, "STranslator is disabled by developer.");
                    }
                    this.f7485b = false;
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.sec.android.app.translator.TRANSLATE");
                    ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                    if (resolveInfoResolveActivity != null) {
                        if (C3330f.f12033a.f11972b) {
                            C3330f.f12033a.m11651a(f7484a, "STranslator is available.");
                            C3330f.f12033a.m11651a(f7484a, resolveInfoResolveActivity.toString());
                        }
                        this.f7485b = true;
                        return;
                    }
                    this.f7485b = false;
                    return;
                } catch (Exception e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f7484a);
                    }
                    this.f7485b = false;
                    return;
                }
            } catch (IllegalArgumentException e2) {
                this.f7485b = false;
                return;
            }
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslator isn't installed.");
        }
        this.f7485b = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC1951d
    /* renamed from: b */
    public boolean mo7906b(Context context) {
        return this.f7485b;
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: c */
    public void mo7907c(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslatorPlugIn.onInstalled()");
        }
        m7921i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: d */
    public void mo7908d(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslatorPlugIn.onUnInstalled()");
        }
        m7921i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: e */
    public void mo7909e(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslatorPlugIn.onReplaced()");
        }
        m7921i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: f */
    public void mo7910f(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslatorPlugIn.onEnabled()");
        }
        m7921i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: g */
    public void mo7911g(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslatorPlugIn.onDisabled()");
        }
        m7921i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: h */
    public void mo7912h(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7484a, "STranslatorPlugIn.onDataCleared()");
        }
    }
}
