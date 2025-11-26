package com.sec.chaton.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.C2310s;
import com.sec.chaton.R;
import com.sec.chaton.account.C0425k;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.service.ChatONVService;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3169ak;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;

/* compiled from: ChatONVPlugIn.java */
/* renamed from: com.sec.chaton.plugin.a */
/* loaded from: classes.dex */
public class C1948a implements InterfaceC1950c {

    /* renamed from: a */
    private static final String f7463a = C1948a.class.getSimpleName();

    /* renamed from: b */
    private C0045a f7464b = new C0045a();

    /* renamed from: c */
    private boolean f7465c;

    public C1948a() {
        m7904i(CommonApplication.m11493l());
    }

    /* renamed from: a */
    public static boolean m7903a(Context context) {
        return C3159aa.m10962a().m10977a("chatonv_available", (Boolean) false).booleanValue();
    }

    /* renamed from: a */
    private void m7902a() {
        C3159aa.m10962a().m10984b("chatonVUpdateStatus", (Integer) 0);
        C3159aa.m10962a().m10982a("last_chatonv_upgrade_check", (Long) (-1L));
        C3159aa.m10962a().m10981a("chatonv_critical_update");
        C3159aa.m10962a().m10981a("chatonv_update_version");
    }

    /* renamed from: i */
    private void m7904i(Context context) {
        int applicationEnabledSetting;
        C0045a c0045a = this.f7464b;
        if (C0045a.m37b(context)) {
            try {
                applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.coolots.chaton");
            } catch (IllegalArgumentException e) {
                try {
                    applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.coolots.chatonforcanada");
                } catch (IllegalArgumentException e2) {
                    if (C3330f.f12033a.f11975e) {
                        C3330f.f12033a.m11652a(f7463a, "Can't retrieve application enabled setting.", e2);
                    }
                    this.f7465c = false;
                    return;
                }
            }
            if (applicationEnabledSetting == 3) {
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f7463a, "ChatONV is disabled by user.");
                }
                this.f7465c = false;
                return;
            } else if (applicationEnabledSetting == 2) {
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f7463a, "ChatONV is disabled by developer.");
                }
                this.f7465c = false;
                return;
            } else {
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f7463a, "ChatONV is available.");
                }
                this.f7465c = true;
                return;
            }
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONV isn't installed.");
        }
        this.f7465c = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC1951d
    /* renamed from: b */
    public boolean mo7906b(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.isAvailable()");
        }
        return this.f7465c;
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: c */
    public void mo7907c(Context context) throws Resources.NotFoundException {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.onInstalled()");
        }
        m7904i(context);
        if (C1493a.m6463a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 1);
            GlobalApplication.m11493l().startService(intent);
            m7902a();
        }
        m7905j(GlobalApplication.m11493l());
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: d */
    public void mo7908d(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.onUnInstalled()");
        }
        m7904i(context);
        if (C1493a.m6463a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 0);
            GlobalApplication.m11493l().startService(intent);
            m7902a();
        }
        C0425k.m3062d();
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: e */
    public void mo7909e(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.onReplaced()");
        }
        m7904i(context);
        if (C1493a.m6463a("chatonv_feature")) {
            m7902a();
        }
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: f */
    public void mo7910f(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.onEnabled()");
        }
        m7904i(context);
        if (C1493a.m6463a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 1);
            GlobalApplication.m11493l().startService(intent);
        }
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: g */
    public void mo7911g(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.onDisabled()");
        }
        m7904i(context);
        if (C1493a.m6463a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 0);
            GlobalApplication.m11493l().startService(intent);
        }
    }

    @Override // com.sec.chaton.plugin.InterfaceC1950c
    /* renamed from: h */
    public void mo7912h(Context context) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7463a, "ChatONVPlugIn.onDataCleared()");
        }
        if (C1493a.m6463a("chatonv_feature")) {
            Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVService.class);
            intent.putExtra("request_type", 0);
            GlobalApplication.m11493l().startService(intent);
        }
        C0425k.m3062d();
    }

    /* renamed from: j */
    private void m7905j(Context context) throws Resources.NotFoundException {
        String string = context.getResources().getString(R.string.noti_welcome_chaton_voice_video_chat);
        String string2 = context.getResources().getString(R.string.chaton_voice_video_chat);
        C3169ak c3169akM11035a = C3169ak.m11035a();
        c3169akM11035a.m11038a(string2);
        c3169akM11035a.m11040b(C2310s.f8623g);
        c3169akM11035a.m11037a(context, string, C3169ak.f11484e, C3169ak.f11481b);
    }
}
