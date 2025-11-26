package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.service.BackGroundRegiService;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3169ak;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class SSOAccountSyncReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final int f8731a = 0;

    /* renamed from: b */
    private final int f8732b = 1;

    /* renamed from: c */
    private final String f8733c = getClass().getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        if (intent != null) {
            String action = intent.getAction();
            if (C3250y.f11734b) {
                C3250y.m11450b("Action: " + action, this.f8733c);
            }
            String strM11257b = C3214cb.m11257b(GlobalApplication.m11493l());
            if (C3250y.f11734b) {
                C3250y.m11450b("accountID : " + strM11257b, this.f8733c);
            }
            if (action.equals("android.intent.action.SAMSUNGACCOUNT_SIGNIN_COMPLETED")) {
                if (!TextUtils.isEmpty(strM11257b)) {
                    String stringExtra = intent.getStringExtra("signUpInfo");
                    boolean zM10987b = C3159aa.m10962a().m10987b("uid");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("SAMSUNGACCOUNT_SIGNIN_COMPLETED, signUpInfo : " + stringExtra + " signInSAFromChatON : " + MainActivity.f8649a + " hasUID : " + zM10987b, this.f8733c);
                    }
                    if (!zM10987b && !MainActivity.f8649a) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (C3171am.m11071i(GlobalApplication.m11493l())) {
                                if (C3250y.f11734b) {
                                    C3250y.m11450b("This is owner", this.f8733c);
                                }
                                m8814a(context);
                                return;
                            } else {
                                if (C3250y.f11734b) {
                                    C3250y.m11450b("isCurrentUserOwner is falser", this.f8733c);
                                    return;
                                }
                                return;
                            }
                        }
                        if (C3250y.f11734b) {
                            C3250y.m11450b("android OS is lower than jelly bean MR1", this.f8733c);
                        }
                        m8814a(context);
                        return;
                    }
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.SAMSUNGACCOUNT_SIGNOUT_COMPLETED")) {
                C3250y.m11450b("android.intent.action.SAMSUNGACCOUNT_SIGNOUT_COMPLETED", this.f8733c);
                if (TextUtils.isEmpty(strM11257b)) {
                    switch (m8815b(context)) {
                        case 0:
                            if (C1156ak.m5507a(true) != 0) {
                                C3214cb.m11266d();
                            }
                            GlobalApplication.m6452b(context);
                            break;
                        case 1:
                            if (C1493a.m6463a("auto_regi_feature")) {
                                Intent intent2 = new Intent(GlobalApplication.m11493l(), (Class<?>) BackGroundRegiService.class);
                                intent2.putExtra("request_type", 0);
                                intent2.putExtra("request_on_chaton", false);
                                GlobalApplication.m11493l().startService(intent2);
                                break;
                            }
                            break;
                        default:
                            C3250y.m11450b("don't need to deregi ChatON", this.f8733c);
                            break;
                    }
                }
                return;
            }
            if (action.equals("android.intent.action.REGISTRATION_CANCELED")) {
                C3250y.m11450b("REGISTRATION_CANCELED", this.f8733c);
            } else if (action.equals("com.osp.app.signin.action.EMAIL_VALIDATION_COMPLETED")) {
                C3250y.m11450b("EMAIL_VALIDATION_COMPLETED", this.f8733c);
            }
        }
    }

    /* renamed from: a */
    private void m8814a(Context context) throws Resources.NotFoundException {
        String string = context.getResources().getString(R.string.noti_welcome_chaton3);
        C3169ak c3169akM11035a = C3169ak.m11035a();
        c3169akM11035a.m11039b();
        c3169akM11035a.m11037a(context, string, C3169ak.f11483d, C3169ak.f11480a);
    }

    /* renamed from: b */
    private int m8815b(Context context) {
        if (C3159aa.m10962a().m10987b("uid")) {
            if (C3171am.m11080r()) {
                C3250y.m11450b("Regi : true, Mapping : true", this.f8733c);
                return 1;
            }
        } else if (m8816c(context) && !TextUtils.isEmpty(C3159aa.m10962a().m10979a("samsung_account_email", ""))) {
            C3250y.m11450b("Regi : false, Suppoted account Sign in : true", this.f8733c);
            return 0;
        }
        return -1;
    }

    /* renamed from: c */
    private boolean m8816c(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11455d(e.toString(), this.f8733c);
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 12005;
    }
}
