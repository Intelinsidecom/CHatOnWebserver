package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class SSOAccountBackgroundReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f12235a = SSOAccountBackgroundReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4859bx.m18407f(context) && intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            Intent intent2 = new Intent();
            if (C4904y.f17872b) {
                C4904y.m18639b("action : " + action, this.f12235a);
            }
            if (action.equals("com.msc.action.samsungaccount.response.BackGroundSignin")) {
                if (TextUtils.isEmpty(intent.getStringExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID))) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("client_id is empty", this.f12235a);
                    }
                    intent2.putExtra("self_update", true);
                }
                String stringExtra = intent.getStringExtra("authcode");
                int intExtra = intent.getIntExtra("bg_result", -999);
                if (C4904y.f17872b) {
                    C4904y.m18639b("authcode : " + stringExtra + ", result : " + intExtra, this.f12235a);
                }
                intent2.putExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, 1);
                intent2.putExtra("authcode", stringExtra);
                intent2.setAction("action_sso_receive_code");
            } else if (action.equals("com.msc.action.ACCESSTOKEN_V02_RESPONSE")) {
                int intExtra2 = intent.getIntExtra("result_code", -999);
                intent2.putExtra("result_code", intExtra2);
                if (intExtra2 == -1) {
                    String stringExtra2 = intent.getStringExtra("access_token");
                    String stringExtra3 = intent.getStringExtra("email_id");
                    String stringExtra4 = intent.getStringExtra("user_id");
                    String stringExtra5 = intent.getStringExtra("mcc");
                    String stringExtra6 = intent.getStringExtra("api_server_url");
                    String stringExtra7 = intent.getStringExtra("birthday");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("result : " + intExtra2 + "authToken : " + stringExtra2 + " emailID : " + stringExtra3 + " userId : " + stringExtra4 + " mcc : " + stringExtra5 + " birthday : " + stringExtra7, this.f12235a);
                    }
                    intent2.putExtra("auth_token", stringExtra2);
                    intent2.putExtra("email_id", stringExtra3);
                    intent2.putExtra("user_id", stringExtra4);
                    intent2.putExtra("mcc", stringExtra5);
                    intent2.putExtra("api_server_url", stringExtra6);
                    intent2.putExtra("birthday", stringExtra7);
                } else {
                    if (intExtra2 == 1) {
                        String stringExtra8 = intent.getStringExtra("error_message");
                        int intExtra3 = intent.getIntExtra("check_list", 0);
                        String stringExtra9 = intent.getStringExtra("REQUIRED_PROCESS_ACTION");
                        intent.setComponent(null);
                        intent.putExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, 2);
                        intent.setAction("action_sso_receive_code");
                        context.sendBroadcast(intent);
                        if (C4904y.f17872b) {
                            C4904y.m18639b("FAIL, errorMessage : " + stringExtra8 + " checklist : " + intExtra3 + " requireAction : " + stringExtra9, this.f12235a);
                            return;
                        }
                        return;
                    }
                    String stringExtra10 = intent.getStringExtra("error_message");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("FAIL, errorMessage : " + stringExtra10, this.f12235a);
                    }
                }
                intent2.putExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, 2);
                intent2.setAction("action_sso_receive_code");
            } else if (action.equals("com.msc.action.VALIDATION_CHECK_RESPONSE")) {
                if (intent.getIntExtra("result_code", -999) == -1) {
                    Boolean boolValueOf = Boolean.valueOf(intent.getBooleanExtra("validation_result", false));
                    if (!boolValueOf.booleanValue()) {
                        int intExtra4 = intent.getIntExtra("check_list", 0);
                        if (C4904y.f17872b) {
                            C4904y.m18639b("checkList : " + intExtra4, this.f12235a);
                        }
                    }
                    intent2.putExtra("validation_result", boolValueOf);
                } else {
                    String stringExtra11 = intent.getStringExtra("error_message");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("errorMessage : " + stringExtra11, this.f12235a);
                    }
                    intent2.putExtra("validation_result", false);
                }
                intent2.setAction("action_sso_check_validation");
            }
            context.sendBroadcast(intent2);
        }
    }
}
