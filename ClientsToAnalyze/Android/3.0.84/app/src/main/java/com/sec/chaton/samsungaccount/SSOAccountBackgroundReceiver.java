package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class SSOAccountBackgroundReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f8730a = SSOAccountBackgroundReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.osp.app.signin", 64).signatures;
            if (C3250y.f11734b) {
                C3250y.m11450b("sigs: " + signatureArr[0].hashCode(), this.f8730a);
            }
            if (signatureArr[0].hashCode() == 384506773 && intent != null) {
                String action = intent.getAction();
                Intent intent2 = new Intent();
                if (C3250y.f11734b) {
                    C3250y.m11450b("action : " + action, this.f8730a);
                }
                if (action.equals("com.msc.action.samsungaccount.response.BackGroundSignin")) {
                    if (TextUtils.isEmpty(intent.getStringExtra("client_id"))) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("client_id is empty", this.f8730a);
                        }
                        intent2.putExtra("self_update", true);
                    }
                    String stringExtra = intent.getStringExtra("authcode");
                    int intExtra = intent.getIntExtra("bg_result", -999);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("authcode : " + stringExtra + ", result : " + intExtra, this.f8730a);
                    }
                    intent2.putExtra("version", 1);
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
                        if (C3250y.f11734b) {
                            C3250y.m11450b("result : " + intExtra2 + "authToken : " + stringExtra2 + " emailID : " + stringExtra3 + " userId : " + stringExtra4 + " mcc : " + stringExtra5 + " birthday : " + stringExtra7, this.f8730a);
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
                            intent.putExtra("version", 2);
                            intent.setAction("action_sso_receive_code");
                            context.sendBroadcast(intent);
                            if (C3250y.f11734b) {
                                C3250y.m11450b("FAIL, errorMessage : " + stringExtra8 + " checklist : " + intExtra3 + " requireAction : " + stringExtra9, this.f8730a);
                                return;
                            }
                            return;
                        }
                        String stringExtra10 = intent.getStringExtra("error_message");
                        if (C3250y.f11734b) {
                            C3250y.m11450b("FAIL, errorMessage : " + stringExtra10, this.f8730a);
                        }
                    }
                    intent2.putExtra("version", 2);
                    intent2.setAction("action_sso_receive_code");
                } else if (action.equals("com.msc.action.VALIDATION_CHECK_RESPONSE")) {
                    if (intent.getIntExtra("result_code", -999) == -1) {
                        Boolean boolValueOf = Boolean.valueOf(intent.getBooleanExtra("validation_result", false));
                        if (!boolValueOf.booleanValue()) {
                            int intExtra4 = intent.getIntExtra("check_list", 0);
                            if (C3250y.f11734b) {
                                C3250y.m11450b("checkList : " + intExtra4, this.f8730a);
                            }
                        }
                        intent2.putExtra("validation_result", boolValueOf);
                    } else {
                        String stringExtra11 = intent.getStringExtra("error_message");
                        if (C3250y.f11734b) {
                            C3250y.m11450b("errorMessage : " + stringExtra11, this.f8730a);
                        }
                        intent2.putExtra("validation_result", false);
                    }
                    intent2.setAction("action_sso_check_validation");
                }
                context.sendBroadcast(intent2);
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Samsung Account was NOT installed", this.f8730a);
            }
        }
    }
}
