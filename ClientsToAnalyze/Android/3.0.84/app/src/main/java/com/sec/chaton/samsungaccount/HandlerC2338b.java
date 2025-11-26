package com.sec.chaton.samsungaccount;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p035io.entry.SSOUserInformationEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.b */
/* loaded from: classes.dex */
class HandlerC2338b extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f8774a;

    HandlerC2338b(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f8774a = fragmentSamsungAccountLogin;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 2003) {
            if (this.f8774a.f8638e != null && this.f8774a.f8638e.isShowing()) {
                this.f8774a.f8638e.dismiss();
            }
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0267d.m1354e();
                C3250y.m11450b("userInfo : " + sSOUserInformationEntry, getClass().getSimpleName());
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    MainActivity.m8733a(this.f8774a.f8637d, EnumC2335ax.normal);
                    return;
                }
                C3159aa.m10966a("samsung_account_email", sSOUserInformationEntry.loginID);
                C3159aa.m10966a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C3159aa.m10966a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                Intent intent = new Intent();
                intent.putExtra("country_code", sSOUserInformationEntry.countryCode);
                this.f8774a.f8647n.setResult(-1, intent);
                this.f8774a.f8636c.clearCache(true);
                this.f8774a.f8647n.finish();
                return;
            }
            C3250y.m11450b("fail to get to user information", getClass().getSimpleName());
            if (CommonApplication.m11493l() != null) {
                AbstractC3271a.m11494a(this.f8774a.f8637d).mo11500a(this.f8774a.getResources().getString(R.string.toast_error)).mo11509b(this.f8774a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2356d(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2355c(this)).mo11505a().show();
                return;
            }
            return;
        }
        if (message.what == 2002) {
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                if (this.f8774a.f8638e != null && this.f8774a.f8638e.isShowing()) {
                    this.f8774a.f8638e.dismiss();
                }
                C3250y.m11450b("fail to get to access token", getClass().getSimpleName());
                if (CommonApplication.m11493l() != null) {
                    AbstractC3271a.m11494a(this.f8774a.f8637d).mo11500a(this.f8774a.getResources().getString(R.string.toast_error)).mo11509b(this.f8774a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2358f(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2357e(this)).mo11505a().show();
                    return;
                }
                return;
            }
            SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0267d.m1354e();
            C3250y.m11450b("accessToken : " + sSOAccessTokenEntry, getClass().getSimpleName());
            if (TextUtils.isEmpty(sSOAccessTokenEntry.access_token) || TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                if (this.f8774a.f8638e != null && this.f8774a.f8638e.isShowing()) {
                    this.f8774a.f8638e.dismiss();
                }
                MainActivity.m8733a(this.f8774a.f8637d, EnumC2335ax.normal);
                return;
            }
            this.f8774a.f8641h = sSOAccessTokenEntry.access_token;
            this.f8774a.f8642i = sSOAccessTokenEntry.userId;
            C3159aa.m10966a("samsung_account_token", this.f8774a.f8641h);
            this.f8774a.f8640g.m5619b(this.f8774a.f8641h, "fs24s8z0hh", this.f8774a.f8642i);
        }
    }
}
