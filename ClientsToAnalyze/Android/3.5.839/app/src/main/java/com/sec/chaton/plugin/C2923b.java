package com.sec.chaton.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.C1071bk;
import com.sec.chaton.R;
import com.sec.chaton.account.C1004k;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.ChatONVService;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4820al;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;

/* compiled from: ChatONVPlugIn.java */
/* renamed from: com.sec.chaton.plugin.b */
/* loaded from: classes.dex */
public class C2923b implements InterfaceC2938d {

    /* renamed from: a */
    private static final String f10793a = C2923b.class.getSimpleName();

    /* renamed from: b */
    private C0416a f10794b = new C0416a();

    /* renamed from: c */
    private boolean f10795c;

    public C2923b() {
        m12154i(CommonApplication.m18732r());
    }

    /* renamed from: h */
    public static boolean m12153h(Context context) {
        boolean zBooleanValue = C4809aa.m18104a().m18119a("chatonv_available", (Boolean) false).booleanValue();
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "isSupportedDevice : " + zBooleanValue);
        }
        return zBooleanValue;
    }

    /* renamed from: a */
    private void m12152a() {
        C4809aa.m18104a().m18126b("chatonVUpdateStatus", (Integer) 0);
        C4809aa.m18104a().m18124a("last_chatonv_upgrade_check", (Long) (-1L));
        C4809aa.m18104a().m18123a("chatonv_critical_update");
        C4809aa.m18104a().m18123a("chatonv_update_version");
    }

    /* renamed from: i */
    private void m12154i(Context context) {
        int applicationEnabledSetting;
        C0416a c0416a = this.f10794b;
        if (C0416a.m1477b(context)) {
            try {
                applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.coolots.chaton");
            } catch (IllegalArgumentException e) {
                try {
                    applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.coolots.chatonforcanada");
                } catch (IllegalArgumentException e2) {
                    if (C4996f.f18229a.f18174f) {
                        C4996f.f18229a.mo18649a(f10793a, "Can't retrieve application enabled setting.", e2);
                    }
                    this.f10795c = false;
                    return;
                }
            }
            if (applicationEnabledSetting == 3) {
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f10793a, "ChatONV is disabled by user.");
                }
                this.f10795c = false;
                return;
            } else if (applicationEnabledSetting == 2) {
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f10793a, "ChatONV is disabled by developer.");
                }
                this.f10795c = false;
                return;
            } else {
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f10793a, "ChatONV is available.");
                }
                this.f10795c = true;
                return;
            }
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONV isn't installed.");
        }
        this.f10795c = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2941e
    /* renamed from: a */
    public boolean mo12145a(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.isAvailable() : " + this.f10795c);
        }
        return this.f10795c;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: b */
    public void mo12146b(Context context) throws Resources.NotFoundException {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.onInstalled()");
        }
        m12154i(context);
        if (C2349a.m10301a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 1);
            GlobalApplication.m18732r().startService(intent);
            m12152a();
        }
        m12155j(GlobalApplication.m18732r());
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: c */
    public void mo12147c(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.onUnInstalled()");
        }
        m12154i(context);
        if (C2349a.m10301a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 0);
            GlobalApplication.m18732r().startService(intent);
            m12152a();
        }
        C1004k.m6081b();
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: d */
    public void mo12148d(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.onReplaced()");
        }
        m12154i(context);
        if (C2349a.m10301a("chatonv_feature")) {
            m12152a();
        }
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: e */
    public void mo12149e(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.onEnabled()");
        }
        m12154i(context);
        if (C2349a.m10301a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 1);
            GlobalApplication.m18732r().startService(intent);
        }
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: f */
    public void mo12150f(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.onDisabled()");
        }
        m12154i(context);
        if (C2349a.m10301a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 0);
            GlobalApplication.m18732r().startService(intent);
        }
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: g */
    public void mo12151g(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10793a, "ChatONVPlugIn.onDataCleared()");
        }
        if (C2349a.m10301a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 0);
            GlobalApplication.m18732r().startService(intent);
        }
        C1004k.m6081b();
    }

    /* renamed from: j */
    private void m12155j(Context context) throws Resources.NotFoundException {
        String string = context.getResources().getString(R.string.noti_welcome_chaton_voice_video_chat);
        String string2 = context.getResources().getString(R.string.chaton_voice_video_chat);
        C4820al c4820alM18181a = C4820al.m18181a();
        c4820alM18181a.m18185a(string2);
        c4820alM18181a.m18187b(C1071bk.f3375i);
        c4820alM18181a.m18184a(context, string, C4820al.f17594g, C4820al.f17589b);
    }
}
