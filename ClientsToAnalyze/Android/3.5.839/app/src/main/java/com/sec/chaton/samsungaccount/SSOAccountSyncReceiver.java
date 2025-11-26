package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.service.BackGroundRegiService;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4820al;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class SSOAccountSyncReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final int f12236a = 0;

    /* renamed from: b */
    private final int f12237b = 1;

    /* renamed from: c */
    private final String f12238c = getClass().getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        if (C4859bx.m18407f(context) && intent != null) {
            String action = intent.getAction();
            if (C4904y.f17872b) {
                C4904y.m18639b("Action: " + action, this.f12238c);
            }
            String strM18389b = C4859bx.m18389b(GlobalApplication.m18732r());
            if (C4904y.f17872b) {
                C4904y.m18639b("accountID : " + strM18389b, this.f12238c);
            }
            if (action.equals("android.intent.action.SAMSUNGACCOUNT_SIGNIN_COMPLETED")) {
                if (!TextUtils.isEmpty(strM18389b)) {
                    String stringExtra = intent.getStringExtra("signUpInfo");
                    boolean zM18129b = C4809aa.m18104a().m18129b("uid");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("SAMSUNGACCOUNT_SIGNIN_COMPLETED, signUpInfo : " + stringExtra + " signInSAFromChatON : " + MainActivity.f12108n + " hasUID : " + zM18129b, this.f12238c);
                    }
                    if (!zM18129b && !MainActivity.f12108n) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (C4822an.m18239h(GlobalApplication.m18732r())) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("This is owner", this.f12238c);
                                }
                                m13192a(context);
                                return;
                            } else {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("isCurrentUserOwner is falser", this.f12238c);
                                    return;
                                }
                                return;
                            }
                        }
                        if (C4904y.f17872b) {
                            C4904y.m18639b("android OS is lower than jelly bean MR1", this.f12238c);
                        }
                        m13192a(context);
                        return;
                    }
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.SAMSUNGACCOUNT_SIGNOUT_COMPLETED")) {
                C4904y.m18639b("android.intent.action.SAMSUNGACCOUNT_SIGNOUT_COMPLETED", this.f12238c);
                if (TextUtils.isEmpty(strM18389b)) {
                    switch (m13193b(context)) {
                        case 0:
                            if (C1907ag.m9089a(true) != 0) {
                                C4859bx.m18398d();
                            }
                            C0991aa.m6037a().m18962d(new C1058ba());
                            break;
                        case 1:
                            if (C2349a.m10301a("auto_regi_feature")) {
                                Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) BackGroundRegiService.class);
                                intent2.putExtra("request_type", 0);
                                intent2.putExtra("request_on_chaton", false);
                                GlobalApplication.m18732r().startService(intent2);
                                break;
                            }
                            break;
                        default:
                            C4809aa.m18104a().m18123a("chaton_sa_is_valid");
                            C4904y.m18639b("don't need to deregi ChatON", this.f12238c);
                            break;
                    }
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.REGISTRATION_CANCELED")) {
                C4904y.m18639b("REGISTRATION_CANCELED", this.f12238c);
            } else if (action.equals("com.osp.app.signin.action.EMAIL_VALIDATION_COMPLETED")) {
                C4904y.m18639b("EMAIL_VALIDATION_COMPLETED", this.f12238c);
            }
        }
    }

    /* renamed from: a */
    private void m13192a(Context context) throws Resources.NotFoundException {
        String strM18257y = C4822an.m18257y();
        if (TextUtils.isEmpty(strM18257y)) {
            strM18257y = C4822an.m18236g();
            if (!TextUtils.isEmpty(strM18257y)) {
                strM18257y = strM18257y.toUpperCase();
            }
        }
        if ("US".equals(strM18257y) || "VI".equals(strM18257y) || "PR".equals(strM18257y)) {
            C4820al.m18181a().m18184a(context, context.getResources().getString(R.string.noti_welcome_chaton3), C4820al.f17593f, C4820al.f17588a);
        }
    }

    /* renamed from: b */
    private int m13193b(Context context) {
        if (C4809aa.m18104a().m18129b("uid")) {
            if (C4822an.m18255w()) {
                C4904y.m18639b("Regi : true, Mapping : true", this.f12238c);
                return 1;
            }
        } else if (m13194c(context) && !TextUtils.isEmpty(C4809aa.m18104a().m18121a("samsung_account_email", ""))) {
            C4904y.m18639b("Regi : false, Suppoted account Sign in : true", this.f12238c);
            return 0;
        }
        return -1;
    }

    /* renamed from: c */
    private boolean m13194c(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C4904y.m18645d(e.toString(), this.f12238c);
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 12005;
    }
}
