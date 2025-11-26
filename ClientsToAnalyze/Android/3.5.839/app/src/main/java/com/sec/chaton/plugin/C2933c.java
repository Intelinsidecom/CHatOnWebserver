package com.sec.chaton.plugin;

import android.content.Context;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;

/* compiled from: CommonPushPlugIn.java */
/* renamed from: com.sec.chaton.plugin.c */
/* loaded from: classes.dex */
public class C2933c implements InterfaceC2938d {

    /* renamed from: a */
    private static final String f10819a = C2933c.class.getSimpleName();

    /* renamed from: b */
    private boolean f10820b;

    public C2933c() {
        m12167i(GlobalApplication.m18732r());
    }

    /* renamed from: a */
    private void m12165a() {
        C4809aa.m18104a().m18123a("spp_update_is");
    }

    /* renamed from: h */
    private boolean m12166h(Context context) {
        return C5034k.m19095a(CommonApplication.m18732r(), "com.sec.spp.push");
    }

    /* renamed from: i */
    private void m12167i(Context context) {
        if (m12166h(context)) {
            try {
                int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.sec.spp.push");
                if (applicationEnabledSetting == 3) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10819a, "CommonPush is disabled by user.");
                    }
                    this.f10820b = false;
                    return;
                } else if (applicationEnabledSetting == 2) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10819a, "CommonPush is disabled by developer.");
                    }
                    this.f10820b = false;
                    return;
                } else {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10819a, "CommonPush is available.");
                    }
                    this.f10820b = true;
                    return;
                }
            } catch (IllegalArgumentException e) {
                this.f10820b = false;
                return;
            }
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPush isn't installed.");
        }
        this.f10820b = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2941e
    /* renamed from: a */
    public boolean mo12145a(Context context) {
        return this.f10820b;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: b */
    public void mo12146b(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPushPlugIn.onInstalled()");
        }
        m12167i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: c */
    public void mo12147c(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPushPlugIn.onUnInstalled()");
        }
        m12165a();
        m12167i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: d */
    public void mo12148d(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPushPlugIn.onReplaced()");
        }
        m12165a();
        m12167i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: e */
    public void mo12149e(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPushPlugIn.onEnabled()");
        }
        m12167i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: f */
    public void mo12150f(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPushPlugIn.onDisabled()");
        }
        m12167i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: g */
    public void mo12151g(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10819a, "CommonPushPlugIn.onDataCleared()");
        }
    }
}
