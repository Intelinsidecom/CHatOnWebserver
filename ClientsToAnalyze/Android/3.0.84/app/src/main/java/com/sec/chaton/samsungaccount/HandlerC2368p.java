package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p035io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p035io.entry.SSOUserInformationEntry;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.p */
/* loaded from: classes.dex */
class HandlerC2368p extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8826a;

    HandlerC2368p(MainActivity mainActivity) {
        this.f8826a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (!this.f8826a.f8695aq || message.what == 2006) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 104) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8826a.m8741a(EnumC2337az.get_server_address, c0267d.m1356g());
                    return;
                }
                if (C1493a.m6463a("mum_enable_feature") && this.f8826a.f8664O) {
                    this.f8826a.f8664O = false;
                    this.f8826a.m8744a(true);
                    return;
                } else if (C1493a.m6463a("chatonv_feature")) {
                    this.f8826a.f8722s.m5710a(EnumC1172b.UI);
                    return;
                } else {
                    this.f8826a.f8720q.m5694b();
                    return;
                }
            }
            if (message.what == 1101) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8826a.m8741a(EnumC2337az.chaton_v, c0267d.m1356g());
                    return;
                } else {
                    this.f8826a.m8755b(R.string.auto_regi_checking_version);
                    this.f8826a.f8720q.m5694b();
                    return;
                }
            }
            if (message.what == 1104) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8826a.m8741a(EnumC2337az.version_for_upgrade, c0267d.m1356g());
                    return;
                }
                GetVersionNotice getVersionNotice = (GetVersionNotice) c0267d.m1354e();
                if (getVersionNotice != null) {
                    if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                        if (this.f8826a.f8652C) {
                            this.f8826a.m8795p();
                            return;
                        } else if (this.f8826a.f8728y) {
                            this.f8826a.m8797q();
                            return;
                        } else {
                            this.f8826a.m8755b(R.string.auto_regi_checking_account);
                            this.f8826a.m8773e();
                            return;
                        }
                    }
                    if (C3214cb.m11261b()) {
                        this.f8826a.f8697as = getVersionNotice;
                        this.f8826a.f8720q.m5695c();
                        return;
                    } else {
                        this.f8826a.m8806u();
                        C3171am.m11049a(getVersionNotice, this.f8826a.f8714k, false, "NO");
                        return;
                    }
                }
                return;
            }
            if (message.what == 1106) {
                AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals("2")) {
                    C3171am.m11049a(this.f8826a.f8697as, this.f8826a.f8714k, false, "NO");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Samsung apps is NOT ready to upgrade chaton", this.f8826a.f8672W);
                        return;
                    }
                    return;
                }
                C3159aa.m10962a().m10986b("UpdateAppsReady", "YES");
                C3171am.m11049a(this.f8826a.f8697as, this.f8826a.f8714k, false, "YES");
                if (C3250y.f11734b) {
                    C3250y.m11450b("Samsung apps is ready to upgrade chaton", this.f8826a.f8672W);
                    return;
                }
                return;
            }
            if (message.what == 2003) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8826a.m8741a(EnumC2337az.SA_user_info, c0267d.m1356g());
                    return;
                }
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0267d.m1354e();
                C3250y.m11450b("userInfo : " + sSOUserInformationEntry, this.f8826a.f8672W);
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    this.f8826a.m8806u();
                    this.f8826a.m8734a(this.f8826a.f8714k, EnumC2335ax.normal, this.f8826a.f8693ao);
                    return;
                }
                C3159aa.m10966a("samsung_account_email", sSOUserInformationEntry.loginID);
                C3159aa.m10966a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C3159aa.m10966a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                C3159aa.m10966a("samsung_account_birthday", sSOUserInformationEntry.birthDate);
                if (this.f8826a.f8727x) {
                    this.f8826a.m8806u();
                    C3214cb.m11253a(sSOUserInformationEntry.countryCode, this.f8826a.f8714k, true);
                    this.f8826a.m8743a(this.f8826a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8826a.f8650A, this.f8826a.f8651B);
                    this.f8826a.m8765c(false);
                    return;
                }
                C3214cb.m11253a(sSOUserInformationEntry.countryCode, this.f8826a.f8714k, false);
                this.f8826a.f8721r.mo5479a(this.f8826a.f8678aC);
                this.f8826a.f8678aC.m11091a(1001, 30000);
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
                    if (this.f8826a.f8727x) {
                        this.f8826a.f8681ac = 0;
                        MainActivity.m8754b();
                        C1596x.m6758c();
                        if (!C3171am.m11052a(strM10979a)) {
                            C1464f.m6387a();
                            C3159aa.m10966a("account_country_code", strM10979a);
                            new C1324bj(this.f8826a.f8700av).m5694b();
                        } else {
                            C3159aa.m10966a("account_country_code", strM10979a);
                            if (C3214cb.m11256a(this.f8826a.f8714k)) {
                                this.f8826a.m8742a(this.f8826a.getResources().getString(R.string.synchronising_chatonv));
                                if (this.f8826a.f8690al == null || C3214cb.m11245a(this.f8826a.f8714k, this.f8826a.f8690al) != 0) {
                                    this.f8826a.m8742a(this.f8826a.getResources().getString(R.string.auto_regi_buddy_sync));
                                    C1357af.m5988a();
                                    this.f8826a.f8719p.m5717a();
                                    this.f8826a.f8719p.m5736c();
                                }
                            } else {
                                this.f8826a.m8742a(this.f8826a.getResources().getString(R.string.auto_regi_buddy_sync));
                                C1357af.m5988a();
                                this.f8826a.f8719p.m5717a();
                                this.f8826a.f8719p.m5736c();
                            }
                        }
                        C1596x.m6758c();
                        C1370n.m6124a();
                        return;
                    }
                    return;
                }
                if (c0267d.m1355f() == 50006) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("SSO token validaion was finished", getClass().getSimpleName());
                    }
                    if (this.f8826a.f8671V) {
                        this.f8826a.m8788l();
                        return;
                    }
                    this.f8826a.m8806u();
                    C3159aa.m10962a().m10981a("samsung_account_email");
                    this.f8826a.m8773e();
                    return;
                }
                if (c0267d.m1355f() == 50002) {
                    this.f8826a.m8806u();
                    C3250y.m11450b("aucode was expired", this.f8826a.f8672W);
                    C3159aa.m10962a().m10981a("samsung_account_email");
                    this.f8826a.m8773e();
                    return;
                }
                if (c0267d.m1355f() == 50004) {
                    this.f8826a.m8806u();
                    C3250y.m11450b("device over max of limitation", this.f8826a.f8672W);
                    this.f8826a.f8689ak = AbstractC3271a.m11494a(this.f8826a.f8714k).mo11500a(this.f8826a.getResources().getString(R.string.toast_error)).mo11509b(this.f8826a.getResources().getString(R.string.account_max_device_alert3, 5)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2369q(this)).mo11505a();
                    if (!this.f8826a.f8695aq) {
                        this.f8826a.f8689ak.show();
                        return;
                    }
                    return;
                }
                this.f8826a.m8741a(EnumC2337az.mapping, c0267d.m1356g());
                return;
            }
            if (message.what == 2002) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8826a.m8741a(EnumC2337az.SA_access_token, c0267d.m1356g());
                    return;
                }
                SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0267d.m1354e();
                C3250y.m11450b("accessToken : " + sSOAccessTokenEntry, this.f8826a.f8672W);
                if (TextUtils.isEmpty(sSOAccessTokenEntry.access_token) || TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                    this.f8826a.m8806u();
                    this.f8826a.m8734a(this.f8826a.f8714k, EnumC2335ax.normal, this.f8826a.f8693ao);
                    return;
                }
                this.f8826a.f8725v = sSOAccessTokenEntry.access_token;
                this.f8826a.f8692an = sSOAccessTokenEntry.userId;
                C3159aa.m10966a("samsung_account_user_id", this.f8826a.f8692an);
                C3159aa.m10966a("samsung_account_token", this.f8826a.f8725v);
                this.f8826a.f8716m.m5619b(this.f8826a.f8725v, "fs24s8z0hh", this.f8826a.f8692an);
                return;
            }
            if (message.what == 2006) {
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Fianlly register was success with SA automatically", this.f8826a.f8672W);
                    }
                    this.f8826a.f8681ac = 0;
                    String strM10979a2 = C3159aa.m10962a().m10979a("temp_account_country_code", "");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Final account ISO : " + strM10979a2, getClass().getSimpleName());
                    }
                    C3159aa.m10963a("did_samsung_account_mapping", (Boolean) true);
                    MainActivity.m8754b();
                    C3159aa.m10966a("account_country_code", strM10979a2);
                    if (!this.f8826a.f8695aq) {
                        this.f8826a.m8808v();
                        return;
                    }
                    return;
                }
                if (c0267d.m1355f() == 50006) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("SSO token validaion was finished", this.f8826a.f8672W);
                    }
                    if (!this.f8826a.f8695aq) {
                        this.f8826a.m8788l();
                        return;
                    }
                    return;
                }
                if (c0267d.m1355f() == 50004) {
                    if (!this.f8826a.f8695aq) {
                        this.f8826a.m8806u();
                        C3250y.m11450b("device over max of limitation", getClass().getSimpleName());
                        this.f8826a.f8689ak = AbstractC3271a.m11494a(this.f8826a.f8714k).mo11500a(this.f8826a.getResources().getString(R.string.toast_error)).mo11509b(this.f8826a.getResources().getString(R.string.account_max_device_alert3, 5)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2370r(this)).mo11505a();
                        this.f8826a.f8689ak.setCancelable(false);
                        if (!this.f8826a.f8695aq) {
                            this.f8826a.f8689ak.show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!this.f8826a.f8695aq) {
                    this.f8826a.m8741a(EnumC2337az.auto_regi, c0267d.m1356g());
                }
            }
        }
    }
}
