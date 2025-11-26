package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p035io.entry.SSOUserInformationEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bd */
/* loaded from: classes.dex */
class HandlerC2342bd extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC2339ba f8795a;

    HandlerC2342bd(DialogC2339ba dialogC2339ba) {
        this.f8795a = dialogC2339ba;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 2003) {
            if (this.f8795a.f8789o != null && this.f8795a.f8789o.isShowing()) {
                this.f8795a.f8789o.dismiss();
            }
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0267d.m1354e();
                C3250y.m11450b("userInfo : " + sSOUserInformationEntry, getClass().getSimpleName());
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    MainActivity.m8733a(this.f8795a.f8787m, EnumC2335ax.normal);
                    return;
                }
                C3159aa.m10966a("samsung_account_email", sSOUserInformationEntry.loginID);
                C3159aa.m10966a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C3159aa.m10966a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                this.f8795a.f8788n.clearCache(true);
                this.f8795a.dismiss();
                this.f8795a.f8784j.mo8678a(sSOUserInformationEntry.countryCode);
                return;
            }
            C3250y.m11450b("fail to get to user information", getClass().getSimpleName());
            if (GlobalApplication.m11493l() != null) {
                AbstractC3271a.m11494a(this.f8795a.f8787m).mo11500a(this.f8795a.f8787m.getResources().getString(R.string.toast_error)).mo11509b(this.f8795a.f8787m.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2344bf(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2343be(this)).mo11505a().show();
                return;
            }
            return;
        }
        if (message.what == 2002) {
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                if (this.f8795a.f8789o != null && this.f8795a.f8789o.isShowing()) {
                    this.f8795a.f8789o.dismiss();
                }
                C3250y.m11450b("fail to get to access token", getClass().getSimpleName());
                if (GlobalApplication.m11493l() != null) {
                    AbstractC3271a.m11494a(this.f8795a.f8787m).mo11500a(this.f8795a.f8787m.getResources().getString(R.string.toast_error)).mo11509b(this.f8795a.f8787m.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2346bh(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2345bg(this)).mo11505a().show();
                    return;
                }
                return;
            }
            SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0267d.m1354e();
            C3250y.m11450b("accessToken : " + sSOAccessTokenEntry, getClass().getSimpleName());
            if (TextUtils.isEmpty(sSOAccessTokenEntry.access_token) || TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                if (this.f8795a.f8789o != null && this.f8795a.f8789o.isShowing()) {
                    this.f8795a.f8789o.dismiss();
                }
                MainActivity.m8733a(this.f8795a.f8787m, EnumC2335ax.normal);
                return;
            }
            this.f8795a.f8782h = sSOAccessTokenEntry.access_token;
            this.f8795a.f8783i = sSOAccessTokenEntry.userId;
            C3159aa.m10966a("samsung_account_token", this.f8795a.f8782h);
            this.f8795a.f8785k.m5619b(this.f8795a.f8782h, "fs24s8z0hh", this.f8795a.f8783i);
        }
    }
}
