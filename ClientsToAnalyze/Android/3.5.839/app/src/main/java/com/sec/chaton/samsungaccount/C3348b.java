package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.b */
/* loaded from: classes.dex */
class C3348b extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12286a;

    C3348b(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12286a = abstractMultiDeviceActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        if (this.f12286a.f12151aq) {
            this.f12286a.f12151aq = false;
            this.f12286a.f12109A.m18261a();
            if (!C2349a.m10301a("auto_regi_feature") || !GlobalApplication.f8361h) {
                int intExtra = intent.getIntExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, 2);
                this.f12286a.f12127S = intent.getStringExtra("authcode");
                String stringExtra = intent.getStringExtra("auth_token");
                if (C4904y.f17872b) {
                    C4904y.m18639b("ver : " + intExtra + " authcode : " + this.f12286a.f12127S + " authToken : " + stringExtra, this.f12286a.f12139ae);
                }
                switch (intExtra) {
                    case 1:
                        if (!TextUtils.isEmpty(this.f12286a.f12127S)) {
                            this.f12286a.f12119K.m9389a(this.f12286a.f12127S, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                            break;
                        } else if (!intent.getBooleanExtra("self_update", false)) {
                            this.f12286a.m13061E();
                            break;
                        } else {
                            this.f12286a.m13148q();
                            break;
                        }
                    case 2:
                        if (!TextUtils.isEmpty(stringExtra)) {
                            this.f12286a.f12143ai = intent.getStringExtra("email_id");
                            this.f12286a.f12144aj = intent.getStringExtra("user_id");
                            String stringExtra2 = intent.getStringExtra("mcc");
                            String stringExtra3 = intent.getStringExtra("api_server_url");
                            String stringExtra4 = intent.getStringExtra("birthday");
                            C4809aa.m18108a("samsung_account_token", stringExtra);
                            C4809aa.m18108a("samsung_account_email", this.f12286a.f12143ai);
                            C4809aa.m18108a("samsung_account_user_id", this.f12286a.f12144aj);
                            C4809aa.m18108a("samsung_account_api_server", stringExtra3);
                            C4809aa.m18108a("samsung_account_birthday", stringExtra4);
                            this.f12286a.m13086a(this.f12286a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12286a.f12130V, this.f12286a.f12131W);
                            if (this.f12286a.f12163q) {
                                C4859bx.m18381a(this.f12286a.f12118J, stringExtra2);
                                AbstractMultiDeviceActivity.m13124r();
                                this.f12286a.m13112g(false);
                                break;
                            } else if (!C2349a.m10301a("mum_enable_feature") || this.f12286a.f12138ad) {
                                C4859bx.m18381a(this.f12286a.f12118J, stringExtra2);
                                this.f12286a.m13075a(R.string.auto_regi_checking_push);
                                if (this.f12286a.f12166t || !C4859bx.m18387a(C4809aa.m18104a().m18121a("temp_account_country_code", ""), this.f12286a)) {
                                    this.f12286a.f12120L.m9552a();
                                    break;
                                } else {
                                    this.f12286a.m13148q();
                                    break;
                                }
                            } else {
                                this.f12286a.m13135x();
                                this.f12286a.f12135aa = stringExtra2;
                                break;
                            }
                        } else if (intent.getIntExtra("check_list", 0) > 0) {
                            if (this.f12286a.f12117I != null && this.f12286a.f12117I.isShowing()) {
                                this.f12286a.f12117I.dismiss();
                            }
                            if (this.f12286a.f12129U != null && this.f12286a.f12129U.isShowing()) {
                                this.f12286a.f12129U.dismiss();
                                this.f12286a.f12145ak = null;
                            }
                            C4859bx.m18379a(context, intent);
                            break;
                        } else {
                            this.f12286a.m13061E();
                            break;
                        }
                        break;
                }
            }
        }
    }
}
