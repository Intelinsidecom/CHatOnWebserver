package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.sec.chaton.samsungaccount.EnumC2335ax;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fi */
/* loaded from: classes.dex */
class C2266fi extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f8562a;

    C2266fi(FragmentRegistPushName fragmentRegistPushName) {
        this.f8562a = fragmentRegistPushName;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        String stringExtra = intent.getStringExtra("auth_token");
        if (TextUtils.isEmpty(stringExtra)) {
            this.f8562a.m8622d();
            if (intent.getIntExtra("check_list", 0) > 0) {
                C3214cb.m11249a(context, intent);
            } else {
                MainActivity.m8733a(this.f8562a.f8314b, EnumC2335ax.normal);
            }
        } else {
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
            this.f8562a.m8617b(stringExtra4);
            this.f8562a.f8323k.m5615a(this.f8562a.f8313a.getText().toString());
        }
        C3250y.m11450b("authToken : " + stringExtra, getClass().getSimpleName());
    }
}
