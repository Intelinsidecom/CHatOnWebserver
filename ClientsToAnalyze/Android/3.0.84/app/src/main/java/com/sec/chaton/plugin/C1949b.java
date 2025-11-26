package com.sec.chaton.plugin;

import android.content.Context;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;

/* compiled from: CommonPushPlugIn.java */
/* renamed from: com.sec.chaton.plugin.b */
/* loaded from: classes.dex */
public class C1949b implements InterfaceC1950c {

    /* renamed from: a */
    private static final String f7466a = C1949b.class.getSimpleName();

    /* renamed from: b */
    private boolean f7467b;

    public C1949b() {
        m7915i(GlobalApplication.m11493l());
    }

    /* renamed from: a */
    private void m7913a() {
        C3159aa.m10962a().m10981a("spp_update_is");
    }

    /* renamed from: a */
    private boolean m7914a(Context context) {
        return C3347i.m11778a(CommonApplication.m11493l(), "com.sec.spp.push");
    }

    /* renamed from: i */
    private void m7915i(Context context) {
        if (m7914a(context)) {
            try {
                int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.sec.spp.push");
                if (applicationEnabledSetting == 3) {
                    if (C3330f.f12033a.f11972b) {
                        C3330f.f12033a.m11651a(f7466a, "CommonPush is disabled by user.");
                    }
                    this.f7467b = false;
                    return;
                } else if (applicationEnabledSetting == 2) {
                    if (C3330f.f12033a.f11972b) {
                        C3330f.f12033a.m11651a(f7466a, "CommonPush is disabled by developer.");
                    }
                    this.f7467b = false;
                    return;
                } else {
                    if (C3330f.f12033a.f11972b) {
                        C3330f.f12033a.m11651a(f7466a, "CommonPush is available.");
                    }
                    this.f7467b = true;
                    return;
                }
            } catch (IllegalArgumentException e) {
                this.f7467b = false;
                return;
            }
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPush isn't installed.");
        }
        this.f7467b = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC1951d
    /* renamed from: b */
    public boolean mo7906b(Context context) {
        return this.f7467b;
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: c */
    public void mo7907c(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPushPlugIn.onInstalled()");
        }
        m7915i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: d */
    public void mo7908d(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPushPlugIn.onUnInstalled()");
        }
        m7913a();
        m7915i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: e */
    public void mo7909e(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPushPlugIn.onReplaced()");
        }
        m7913a();
        m7915i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: f */
    public void mo7910f(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPushPlugIn.onEnabled()");
        }
        m7915i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: g */
    public void mo7911g(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPushPlugIn.onDisabled()");
        }
        m7915i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: h */
    public void mo7912h(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7466a, "CommonPushPlugIn.onDataCleared()");
        }
    }
}
