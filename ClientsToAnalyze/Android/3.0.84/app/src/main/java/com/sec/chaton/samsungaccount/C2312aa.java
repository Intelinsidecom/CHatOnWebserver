package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.aa */
/* loaded from: classes.dex */
class C2312aa extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8735a;

    C2312aa(MainActivity mainActivity) {
        this.f8735a = mainActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (!C1493a.m6463a("auto_regi_feature") || !GlobalApplication.f5516g) {
            int intExtra = intent.getIntExtra("version", 2);
            this.f8735a.f8724u = intent.getStringExtra("authcode");
            String stringExtra = intent.getStringExtra("auth_token");
            if (C3250y.f11734b) {
                C3250y.m11450b("ver : " + intExtra + " authcode : " + this.f8735a.f8724u + " authToken : " + stringExtra, this.f8735a.f8672W);
            }
            switch (intExtra) {
                case 1:
                    if (!TextUtils.isEmpty(this.f8735a.f8724u)) {
                        this.f8735a.f8716m.m5616a(this.f8735a.f8724u, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                        break;
                    } else if (intent.getBooleanExtra("self_update", false)) {
                        this.f8735a.m8806u();
                        break;
                    } else {
                        this.f8735a.m8799r();
                        break;
                    }
                case 2:
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.f8735a.f8691am = intent.getStringExtra("email_id");
                        this.f8735a.f8692an = intent.getStringExtra("user_id");
                        String stringExtra2 = intent.getStringExtra("mcc");
                        String stringExtra3 = intent.getStringExtra("api_server_url");
                        String stringExtra4 = intent.getStringExtra("birthday");
                        C3159aa.m10966a("samsung_account_token", stringExtra);
                        C3159aa.m10966a("samsung_account_email", this.f8735a.f8691am);
                        C3159aa.m10966a("samsung_account_user_id", this.f8735a.f8692an);
                        C3159aa.m10966a("samsung_account_api_server", stringExtra3);
                        C3159aa.m10966a("samsung_account_birthday", stringExtra4);
                        this.f8735a.m8743a(this.f8735a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8735a.f8650A, this.f8735a.f8651B);
                        if (this.f8735a.f8727x) {
                            C3214cb.m11251a(this.f8735a.f8714k, stringExtra2);
                            MainActivity.m8764c();
                            this.f8735a.m8765c(false);
                            break;
                        } else if (!C1493a.m6463a("mum_enable_feature") || this.f8735a.f8666Q) {
                            C3214cb.m11251a(this.f8735a.f8714k, stringExtra2);
                            this.f8735a.m8755b(R.string.auto_regi_checking_push);
                            this.f8735a.f8721r.mo5479a(this.f8735a.f8678aC);
                            this.f8735a.f8678aC.m11091a(1001, 30000);
                            break;
                        } else {
                            this.f8735a.m8778g();
                            this.f8735a.f8663N = stringExtra2;
                            break;
                        }
                    } else if (intent.getIntExtra("check_list", 0) > 0) {
                        if (this.f8735a.f8713j != null && this.f8735a.f8713j.isShowing()) {
                            this.f8735a.f8713j.dismiss();
                        }
                        if (this.f8735a.f8729z != null && this.f8735a.f8729z.isShowing()) {
                            this.f8735a.f8729z.dismiss();
                            this.f8735a.f8696ar = null;
                        }
                        C3214cb.m11249a(context, intent);
                        break;
                    } else {
                        this.f8735a.m8799r();
                        break;
                    }
                    break;
            }
        }
    }
}
