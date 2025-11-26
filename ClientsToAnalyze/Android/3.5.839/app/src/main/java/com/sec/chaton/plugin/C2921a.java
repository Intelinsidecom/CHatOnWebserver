package com.sec.chaton.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.io.File;

/* compiled from: AnimessagePlugIn.java */
/* renamed from: com.sec.chaton.plugin.a */
/* loaded from: classes.dex */
public class C2921a implements InterfaceC2938d {

    /* renamed from: a */
    private static final String f10791a = C2921a.class.getSimpleName();

    /* renamed from: b */
    private boolean f10792b;

    public C2921a() {
        m12144l(GlobalApplication.m18732r());
    }

    /* renamed from: k */
    private boolean m12143k(Context context) {
        return C5034k.m19095a(CommonApplication.m18732r(), "com.sec.animessage");
    }

    /* renamed from: l */
    private void m12144l(Context context) {
        if (m12143k(context)) {
            try {
                int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.sec.animessage");
                if (applicationEnabledSetting == 3) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn is disabled by user.");
                    }
                    this.f10792b = false;
                    return;
                } else {
                    if (applicationEnabledSetting == 2) {
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn is disabled by developer.");
                        }
                        this.f10792b = false;
                        return;
                    }
                    try {
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn is available.");
                        }
                        this.f10792b = true;
                        return;
                    } catch (Exception e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f10791a);
                        }
                        this.f10792b = false;
                        return;
                    }
                }
            } catch (IllegalArgumentException e2) {
                this.f10792b = false;
                return;
            }
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn isn't installed.");
        }
        this.f10792b = false;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2941e
    /* renamed from: a */
    public boolean mo12145a(Context context) {
        return this.f10792b;
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: b */
    public void mo12146b(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn.onInstalled()");
        }
        m12144l(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: c */
    public void mo12147c(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn.onUnInstalled()");
        }
        m12144l(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: d */
    public void mo12148d(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn.onReplaced()");
        }
        m12144l(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: e */
    public void mo12149e(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn.onEnabled()");
        }
        m12144l(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: f */
    public void mo12150f(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn.onDisabled()");
        }
        m12144l(context);
    }

    @Override // com.sec.chaton.plugin.InterfaceC2938d
    /* renamed from: g */
    public void mo12151g(Context context) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10791a, "AnimessagePlugIn.onDataCleared()");
        }
    }

    /* renamed from: h */
    public static Intent m12140h(Context context) {
        return new Intent("com.sec.animessage.LAUNCH_AMS_PLUGIN");
    }

    /* renamed from: a */
    public static Intent m12139a(Context context, String str) {
        Intent intent = new Intent("com.sec.animessage.LAUNCH_AMS_PLAYER", FileProvider.m313a(context, "com.sec.chaton.provider.file", new File(str)));
        intent.putExtra("VIEWER_MODE", 1002);
        intent.addFlags(1);
        return intent;
    }

    /* renamed from: a */
    public static Intent m12138a(Context context, Uri uri) {
        Intent intent = new Intent("com.sec.animessage.LAUNCH_AMS_PLAYER", uri);
        intent.putExtra("VIEWER_MODE", 1002);
        intent.addFlags(1);
        return intent;
    }

    /* renamed from: i */
    public static Intent m12141i(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(335544352);
        intent.setData(Uri.parse("market://details?id=com.sec.animessage"));
        return intent;
    }

    /* renamed from: j */
    public static Intent m12142j(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://www.chaton.com/androidamsapk"));
        return intent;
    }
}
