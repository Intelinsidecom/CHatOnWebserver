package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.sec.chaton.samsungaccount.EnumC3327af;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fr */
/* loaded from: classes.dex */
class C3284fr extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f12052a;

    C3284fr(FragmentRegistPushName fragmentRegistPushName) {
        this.f12052a = fragmentRegistPushName;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        String stringExtra = intent.getStringExtra("auth_token");
        if (TextUtils.isEmpty(stringExtra)) {
            this.f12052a.m12975d();
            if (intent.getIntExtra("check_list", 0) > 0) {
                C4859bx.m18379a(context, intent);
            } else {
                MainActivity.m13076a(this.f12052a.f11788b, EnumC3327af.normal);
            }
        } else {
            String stringExtra2 = intent.getStringExtra("email_id");
            String stringExtra3 = intent.getStringExtra("user_id");
            String stringExtra4 = intent.getStringExtra("mcc");
            String stringExtra5 = intent.getStringExtra("api_server_url");
            String stringExtra6 = intent.getStringExtra("birthday");
            C4809aa.m18108a("samsung_account_token", stringExtra);
            C4809aa.m18108a("samsung_account_email", stringExtra2);
            C4809aa.m18108a("samsung_account_user_id", stringExtra3);
            C4809aa.m18108a("samsung_account_api_server", stringExtra5);
            C4809aa.m18108a("samsung_account_birthday", stringExtra6);
            this.f12052a.m12970b(stringExtra4);
            this.f12052a.f11797k.m9388a(this.f12052a.f11787a.getText().toString());
        }
        C4904y.m18639b("authToken : " + stringExtra, getClass().getSimpleName());
    }
}
