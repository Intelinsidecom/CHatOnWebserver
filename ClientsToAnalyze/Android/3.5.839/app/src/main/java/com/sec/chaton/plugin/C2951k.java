package com.sec.chaton.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;

/* compiled from: STranslatorPlugIn.java */
/* renamed from: com.sec.chaton.plugin.k */
/* loaded from: classes.dex */
public class C2951k implements InterfaceC2938d {

    /* renamed from: a */
    private static final String f10864a = C2951k.class.getSimpleName();

    /* renamed from: b */
    private boolean f10865b;

    public C2951k() {
        m12197i(GlobalApplication.m18732r());
    }

    /* renamed from: h */
    private boolean m12196h(Context context) {
        return C5034k.m19095a(CommonApplication.m18732r(), "com.sec.android.app.translator");
    }

    /* renamed from: i */
    private void m12197i(Context context) {
        if (m12196h(context)) {
            try {
                int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.sec.android.app.translator");
                if (applicationEnabledSetting == 3) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10864a, "STranslator is disabled by user.");
                    }
                    this.f10865b = false;
                    return;
                }
                if (applicationEnabledSetting == 2) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10864a, "STranslator is disabled by developer.");
                    }
                    this.f10865b = false;
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.sec.android.app.translator.TRANSLATE");
                    ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                    if (resolveInfoResolveActivity != null) {
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f10864a, "STranslator is available.");
                            C4996f.f18229a.m18892f(f10864a, resolveInfoResolveActivity.toString());
                        }
                        this.f10865b = true;
                        return;
                    }
                    this.f10865b = false;
                    return;
                } catch (Exception e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f10864a);
                    }
                    this.f10865b = false;
                    return;
                }
            } catch (IllegalArgumentException e2) {
                this.f10865b = false;
                return;
            }
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslator isn't installed.");
        }
        this.f10865b = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2941e
    /* renamed from: a */
    public boolean mo12145a(Context context) {
        return this.f10865b;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: b */
    public void mo12146b(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslatorPlugIn.onInstalled()");
        }
        m12197i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: c */
    public void mo12147c(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslatorPlugIn.onUnInstalled()");
        }
        m12197i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: d */
    public void mo12148d(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslatorPlugIn.onReplaced()");
        }
        m12197i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: e */
    public void mo12149e(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslatorPlugIn.onEnabled()");
        }
        m12197i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: f */
    public void mo12150f(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslatorPlugIn.onDisabled()");
        }
        m12197i(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: g */
    public void mo12151g(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10864a, "STranslatorPlugIn.onDataCleared()");
        }
    }
}
