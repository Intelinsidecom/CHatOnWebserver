package com.sec.chaton.registration;

import android.accounts.AccountManager;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.TabActivity;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ar */
/* loaded from: classes.dex */
class RunnableC2140ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8414a;

    RunnableC2140ar(AuthenticatorActivity authenticatorActivity) {
        this.f8414a = authenticatorActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f8414a.f8147f) {
            if (AccountManager.get(CommonApplication.m11493l()).getAccountsByType("com.sec.chaton").length <= 0 && C3159aa.m10962a().m10987b("uid")) {
                String strM10979a = C3159aa.m10962a().m10979a("msisdn", "");
                String strM10979a2 = C3159aa.m10962a().m10979a("samsung_account_email", "");
                String strM10979a3 = C3159aa.m10962a().m10979a("uid", "");
                if (!TextUtils.isEmpty(strM10979a)) {
                    C3214cb.m11254a(strM10979a, strM10979a3, true);
                } else if (!TextUtils.isEmpty(strM10979a2)) {
                    C3214cb.m11254a(strM10979a2, strM10979a3, false);
                }
            }
            if (!C3159aa.m10962a().m10987b("uid")) {
                if (this.f8414a.f8160s && !C3159aa.m10962a().m10979a("provisioning_disclaimer_status", "").equals("DONE")) {
                    Intent intent = new Intent(this.f8414a, (Class<?>) MainActivity.class);
                    if (!C1493a.m6463a("for_wifi_only_device")) {
                        intent.putExtra("is_ready_to_sa", true);
                    }
                    intent.putExtra("is_before_regi", true);
                    this.f8414a.startActivityForResult(intent, 8);
                    this.f8414a.overridePendingTransition(0, 0);
                } else {
                    C3159aa.m10966a("provisioning_account_login", "PHONE");
                    C3250y.m11450b("[PHONE SMS]", "ChatON");
                    if (!C3159aa.m10962a().m10979a("provisioning_disclaimer_status", "").equals("DONE")) {
                        if (C3171am.m11068h() != null || C3159aa.m10962a().m10979a("selected_country", "").equals("DONE")) {
                            this.f8414a.m8460g();
                        } else {
                            this.f8414a.startActivityForResult(new Intent(this.f8414a, (Class<?>) SelectCountry.class), 5);
                        }
                    } else if (!C3159aa.m10962a().m10979a("provisioning_selfsms_status", "").equals("DONE")) {
                        Intent intent2 = new Intent(this.f8414a, (Class<?>) ActivityRegist.class);
                        intent2.putExtra(FragmentRegist.f8259a, true);
                        intent2.putExtra(FragmentRegist.f8260b, true);
                        this.f8414a.startActivityForResult(intent2, 1);
                    } else if (!C3159aa.m10962a().m10979a("provisioning_pushname_status", "").equals("DONE")) {
                        this.f8414a.m8457e();
                    }
                }
            } else {
                if (C1493a.m6463a("auto_regi_feature")) {
                    if (C3159aa.m10962a().m10987b("back_regi_status")) {
                        this.f8414a.startActivity(TabActivity.m1226a(this.f8414a.f8154m));
                    } else {
                        C3641ai.m13210a(this.f8414a, R.string.regist_already_regist, 0).show();
                    }
                }
                this.f8414a.finish();
            }
            this.f8414a.f8147f = false;
        }
    }
}
