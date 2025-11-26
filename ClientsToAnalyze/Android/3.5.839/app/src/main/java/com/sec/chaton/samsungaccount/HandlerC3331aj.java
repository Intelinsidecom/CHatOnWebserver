package com.sec.chaton.samsungaccount;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p065io.entry.SSOUserInformationEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.aj */
/* loaded from: classes.dex */
class HandlerC3331aj extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f12266a;

    HandlerC3331aj(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f12266a = fragmentSamsungAccountLogin;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 2003) {
            if (this.f12266a.f12182e != null && this.f12266a.f12182e.isShowing()) {
                this.f12266a.f12182e.dismiss();
            }
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0778b.m3110e();
                C4904y.m18639b("userInfo : " + sSOUserInformationEntry, getClass().getSimpleName());
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    MainActivity.m13076a(this.f12266a.f12181d, EnumC3327af.normal);
                    return;
                }
                C4809aa.m18108a("samsung_account_email", sSOUserInformationEntry.loginID);
                C4809aa.m18108a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C4809aa.m18108a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                Intent intent = new Intent();
                intent.putExtra("country_code", sSOUserInformationEntry.countryCode);
                this.f12266a.f12190m.setResult(-1, intent);
                this.f12266a.f12180c.clearCache(true);
                this.f12266a.f12190m.finish();
                return;
            }
            C4904y.m18639b("fail to get to user information", getClass().getSimpleName());
            if (CommonApplication.m18732r() != null) {
                AbstractC4932a.m18733a(this.f12266a.f12181d).mo18740a(this.f12266a.getResources().getString(R.string.toast_error)).mo18749b(this.f12266a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3333al(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3332ak(this)).mo18745a().show();
                return;
            }
            return;
        }
        if (message.what == 2002) {
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                if (this.f12266a.f12182e != null && this.f12266a.f12182e.isShowing()) {
                    this.f12266a.f12182e.dismiss();
                }
                C4904y.m18639b("fail to get to access token", getClass().getSimpleName());
                if (CommonApplication.m18732r() != null) {
                    AbstractC4932a.m18733a(this.f12266a.f12181d).mo18740a(this.f12266a.getResources().getString(R.string.toast_error)).mo18749b(this.f12266a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3335an(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3334am(this)).mo18745a().show();
                    return;
                }
                return;
            }
            SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0778b.m3110e();
            C4904y.m18639b("accessToken : " + sSOAccessTokenEntry, getClass().getSimpleName());
            if (TextUtils.isEmpty(sSOAccessTokenEntry.access_token) || TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                if (this.f12266a.f12182e != null && this.f12266a.f12182e.isShowing()) {
                    this.f12266a.f12182e.dismiss();
                }
                MainActivity.m13076a(this.f12266a.f12181d, EnumC3327af.normal);
                return;
            }
            this.f12266a.f12185h = sSOAccessTokenEntry.access_token;
            this.f12266a.f12186i = sSOAccessTokenEntry.userId;
            C4809aa.m18108a("samsung_account_token", this.f12266a.f12185h);
            this.f12266a.f12184g.m9392b(this.f12266a.f12185h, "fs24s8z0hh", this.f12266a.f12186i);
        }
    }
}
