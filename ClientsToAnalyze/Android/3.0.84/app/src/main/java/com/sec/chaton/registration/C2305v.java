package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.samsungaccount.EnumC2335ax;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import java.io.UnsupportedEncodingException;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.v */
/* loaded from: classes.dex */
class C2305v extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8612a;

    C2305v(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8612a = activitySyncSignInPopup;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException, UnsupportedEncodingException {
        int intExtra = intent.getIntExtra("version", 2);
        this.f8612a.f8096A = intent.getStringExtra("authcode");
        String stringExtra = intent.getStringExtra("auth_token");
        if (C3250y.f11734b) {
            C3250y.m11450b("ver : " + intExtra + " authcode : " + this.f8612a.f8096A + " authToken : " + stringExtra, this.f8612a.f8113b);
        }
        switch (intExtra) {
            case 1:
                if (!TextUtils.isEmpty(this.f8612a.f8096A)) {
                    this.f8612a.f8127p.m5616a(this.f8612a.f8096A, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                    break;
                } else {
                    if (this.f8612a.f8124m != null && this.f8612a.f8124m.isShowing()) {
                        this.f8612a.f8124m.dismiss();
                    }
                    MainActivity.m8733a(this.f8612a.f8118g, EnumC2335ax.normal);
                    break;
                }
                break;
            case 2:
                if (!TextUtils.isEmpty(stringExtra)) {
                    String stringExtra2 = intent.getStringExtra("email_id");
                    String stringExtra3 = intent.getStringExtra("user_id");
                    String stringExtra4 = intent.getStringExtra("mcc");
                    String stringExtra5 = intent.getStringExtra("api_server_url");
                    String stringExtra6 = intent.getStringExtra("birthday");
                    C3159aa.m10966a("samsung_account_token", stringExtra);
                    C3159aa.m10966a("samsung_account_email", stringExtra2);
                    C3159aa.m10966a("samsung_account_user_id", stringExtra3);
                    C3159aa.m10966a("samsung_account_api_server", stringExtra5);
                    C3159aa.m10966a("samsung_account_birthday", stringExtra6);
                    this.f8612a.m8400a(this.f8612a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8612a.f8136y, this.f8612a.f8137z);
                    C3214cb.m11251a(this.f8612a.f8118g, stringExtra4);
                    MainActivity.m8764c();
                    this.f8612a.m8407b(false);
                    break;
                } else if (intent.getIntExtra("check_list", 0) > 0) {
                    if (this.f8612a.f8124m != null && this.f8612a.f8124m.isShowing()) {
                        this.f8612a.f8124m.dismiss();
                    }
                    if (this.f8612a.f8125n != null && this.f8612a.f8125n.isShowing()) {
                        this.f8612a.f8125n.dismiss();
                        this.f8612a.f8102G = null;
                    }
                    C3214cb.m11249a(context, intent);
                    break;
                } else {
                    if (this.f8612a.f8124m != null && this.f8612a.f8124m.isShowing()) {
                        this.f8612a.f8124m.dismiss();
                    }
                    MainActivity.m8733a(this.f8612a.f8118g, EnumC2335ax.normal);
                    break;
                }
                break;
        }
    }
}
