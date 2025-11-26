package com.sec.chaton.plugin;

import android.content.Context;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;

/* compiled from: SStreamPlugIn.java */
/* renamed from: com.sec.chaton.plugin.j */
/* loaded from: classes.dex */
public class C2950j implements InterfaceC2938d {

    /* renamed from: a */
    private static final String f10862a = C2950j.class.getSimpleName();

    /* renamed from: b */
    private boolean f10863b;

    public C2950j() {
        m12195i(GlobalApplication.m18732r());
    }

    /* renamed from: h */
    private boolean m12194h(Context context) {
        return C5034k.m19095a(CommonApplication.m18732r(), "sstream.app");
    }

    /* renamed from: i */
    private void m12195i(Context context) {
        if (m12194h(context)) {
            try {
                int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("sstream.app");
                if (applicationEnabledSetting == 3) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10862a, "SStream is disabled by user.");
                    }
                    this.f10863b = false;
                    return;
                } else {
                    if (applicationEnabledSetting == 2) {
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f10862a, "SStream is disabled by developer.");
                        }
                        this.f10863b = false;
                        return;
                    }
                    try {
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f10862a, "SStream is available.");
                        }
                        this.f10863b = true;
                        return;
                    } catch (Exception e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f10862a);
                        }
                        this.f10863b = false;
                        return;
                    }
                }
            } catch (IllegalArgumentException e2) {
                this.f10863b = false;
                return;
            }
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStream isn't installed.");
        }
        this.f10863b = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2941e
    /* renamed from: a */
    public boolean mo12145a(Context context) {
        return this.f10863b;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: b */
    public void mo12146b(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStreamPlugIn.onInstalled()");
        }
        m12195i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: c */
    public void mo12147c(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStreamPlugIn.onUnInstalled()");
        }
        m12195i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: d */
    public void mo12148d(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStreamPlugIn.onReplaced()");
        }
        m12195i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: e */
    public void mo12149e(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStreamPlugIn.onEnabled()");
        }
        m12195i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: f */
    public void mo12150f(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStreamPlugIn.onDisabled()");
        }
        m12195i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: g */
    public void mo12151g(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10862a, "SStreamPlugIn.onDataCleared()");
        }
    }
}
