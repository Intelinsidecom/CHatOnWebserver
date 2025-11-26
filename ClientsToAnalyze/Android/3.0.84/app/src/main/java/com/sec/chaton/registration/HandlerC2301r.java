package com.sec.chaton.registration;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p035io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p035io.entry.SSOUserInformationEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.samsungaccount.EnumC2335ax;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import java.io.UnsupportedEncodingException;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.r */
/* loaded from: classes.dex */
class HandlerC2301r extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8608a;

    HandlerC2301r(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8608a = activitySyncSignInPopup;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (!this.f8608a.f8101F) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 2003) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8608a.m8398a(EnumC2124ab.SA_user_info, c0267d.m1356g());
                    return;
                }
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0267d.m1354e();
                C3250y.m11450b("userInfo : " + sSOUserInformationEntry, this.f8608a.f8113b);
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    if (this.f8608a.f8124m != null && this.f8608a.f8124m.isShowing()) {
                        this.f8608a.f8124m.dismiss();
                    }
                    MainActivity.m8733a(this.f8608a.f8118g, EnumC2335ax.normal);
                    return;
                }
                C3159aa.m10966a("samsung_account_email", sSOUserInformationEntry.loginID);
                C3159aa.m10966a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C3159aa.m10966a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                if (this.f8608a.f8124m != null && this.f8608a.f8124m.isShowing()) {
                    this.f8608a.f8124m.dismiss();
                }
                C3214cb.m11253a(sSOUserInformationEntry.countryCode, this.f8608a.f8118g, true);
                this.f8608a.m8400a(this.f8608a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8608a.f8136y, this.f8608a.f8137z);
                this.f8608a.m8407b(false);
                return;
            }
            if (message.what == 2005) {
                if ((c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) || c0267d.m1355f() == 50003) {
                    String strM10979a = C3159aa.m10962a().m10979a("temp_account_country_code", "");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Final account ISO : " + strM10979a, getClass().getSimpleName());
                    }
                    C3159aa.m10963a("did_samsung_account_mapping", (Boolean) true);
                    C3159aa.m10962a().m10981a("account_mapping_fail");
                    this.f8608a.f8100E = 0;
                    MainActivity.m8754b();
                    if (!C3171am.m11052a(strM10979a)) {
                        C1464f.m6387a();
                        C3159aa.m10966a("account_country_code", strM10979a);
                        new C1324bj(this.f8608a.f8108M).m5694b();
                        return;
                    }
                    C3159aa.m10966a("account_country_code", strM10979a);
                    if (C3214cb.m11256a(this.f8608a.f8118g)) {
                        this.f8608a.m8399a(this.f8608a.getResources().getString(R.string.synchronising_chatonv));
                        if (this.f8608a.f8104I != null) {
                            if (C3214cb.m11245a(this.f8608a.f8118g, this.f8608a.f8104I) != 0) {
                                this.f8608a.m8399a(this.f8608a.getResources().getString(R.string.auto_regi_buddy_sync));
                                C1357af.m5988a();
                                this.f8608a.f8128q.m5717a();
                                this.f8608a.f8128q.m5736c();
                                return;
                            }
                            return;
                        }
                        this.f8608a.m8399a(this.f8608a.getResources().getString(R.string.auto_regi_buddy_sync));
                        C1357af.m5988a();
                        this.f8608a.f8128q.m5717a();
                        this.f8608a.f8128q.m5736c();
                        return;
                    }
                    this.f8608a.m8399a(this.f8608a.getResources().getString(R.string.auto_regi_buddy_sync));
                    C1357af.m5988a();
                    this.f8608a.f8128q.m5717a();
                    this.f8608a.f8128q.m5736c();
                    return;
                }
                if (c0267d.m1355f() == 50006) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("SSO token validaion was finished", getClass().getSimpleName());
                    }
                    if (!this.f8608a.f8132u) {
                        if (this.f8608a.f8125n != null && this.f8608a.f8125n.isShowing()) {
                            this.f8608a.f8125n.dismiss();
                            this.f8608a.f8102G = null;
                        }
                        C3159aa.m10962a().m10981a("samsung_account_email");
                        this.f8608a.m8393a();
                        return;
                    }
                    ActivitySyncSignInPopup.m8425n(this.f8608a);
                    if ((TextUtils.isEmpty(this.f8608a.f8134w) || this.f8608a.f8100E >= 2) && this.f8608a.f8125n != null && this.f8608a.f8125n.isShowing()) {
                        this.f8608a.f8125n.dismiss();
                        this.f8608a.f8102G = null;
                    }
                    if (this.f8608a.f8100E < 2) {
                        this.f8608a.m8401a(true);
                        return;
                    } else {
                        this.f8608a.f8100E = 0;
                        MainActivity.m8733a(this.f8608a.f8118g, EnumC2335ax.normal);
                        return;
                    }
                }
                if (c0267d.m1355f() == 50002) {
                    if (this.f8608a.f8125n != null && this.f8608a.f8125n.isShowing()) {
                        this.f8608a.f8125n.dismiss();
                        this.f8608a.f8102G = null;
                    }
                    C3250y.m11450b("aucode was expired", this.f8608a.f8113b);
                    C3159aa.m10962a().m10981a("samsung_account_email");
                    this.f8608a.m8393a();
                    return;
                }
                if (c0267d.m1355f() == 50004) {
                    if (this.f8608a.f8125n != null && this.f8608a.f8125n.isShowing()) {
                        this.f8608a.f8125n.dismiss();
                        this.f8608a.f8102G = null;
                    }
                    if (this.f8608a.f8124m != null && this.f8608a.f8124m.isShowing()) {
                        this.f8608a.f8124m.dismiss();
                    }
                    C3250y.m11450b("device over max of limitation", this.f8608a.f8113b);
                    AbstractC3271a.m11494a(this.f8608a.f8118g).mo11500a(this.f8608a.getResources().getString(R.string.toast_error)).mo11509b(this.f8608a.getResources().getString(R.string.account_max_device_alert2, 5, "www.chaton.com")).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2302s(this)).mo11505a().show();
                    return;
                }
                this.f8608a.m8398a(EnumC2124ab.mapping, c0267d.m1356g());
                return;
            }
            if (message.what == 2002) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8608a.m8398a(EnumC2124ab.SA_access_token, c0267d.m1356g());
                    return;
                }
                SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0267d.m1354e();
                C3250y.m11450b("accessToken : " + sSOAccessTokenEntry, this.f8608a.f8113b);
                if (TextUtils.isEmpty(sSOAccessTokenEntry.access_token) || TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                    if (this.f8608a.f8124m != null && this.f8608a.f8124m.isShowing()) {
                        this.f8608a.f8124m.dismiss();
                    }
                    MainActivity.m8733a(this.f8608a.f8118g, EnumC2335ax.normal);
                    return;
                }
                this.f8608a.f8097B = sSOAccessTokenEntry.access_token;
                this.f8608a.f8098C = sSOAccessTokenEntry.userId;
                C3159aa.m10966a("samsung_account_user_id", this.f8608a.f8098C);
                C3159aa.m10966a("samsung_account_token", this.f8608a.f8097B);
                this.f8608a.f8127p.m5619b(this.f8608a.f8097B, "fs24s8z0hh", this.f8608a.f8098C);
            }
        }
    }
}
