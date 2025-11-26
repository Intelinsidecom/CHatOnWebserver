package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p065io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p065io.entry.SSOUserInformationEntry;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.u */
/* loaded from: classes.dex */
class HandlerC3401u extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12362a;

    HandlerC3401u(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12362a = abstractMultiDeviceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (!this.f12362a.f12166t || message.what == 2006) {
            if (message.what == 150) {
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mGldHandler getGLDFeaturePolicy Success", this.f12362a.f12139ae);
                    }
                } else if (C4904y.f17872b) {
                    C4904y.m18639b("mGldHandler getGLDFeaturePolicy Fail >>> Set to default(false)", this.f12362a.f12139ae);
                }
                if (C2349a.m10301a("sms_feature")) {
                    C3847e.m14665aP();
                }
                C3892o.m15036j();
                if (C2349a.m10301a("mum_enable_feature") && this.f12362a.f12136ab) {
                    this.f12362a.f12136ab = false;
                    this.f12362a.m13140b(true);
                    return;
                } else if (C2349a.m10301a("chatonv_feature")) {
                    this.f12362a.f12125Q.m9483a(EnumC2463n.UI);
                    return;
                } else {
                    this.f12362a.f12123O.m9471b();
                    return;
                }
            }
            if (message.what == 104) {
                C0778b c0778b2 = (C0778b) message.obj;
                if (!c0778b2.m18954n() || c0778b2.m3107b() == EnumC2464o.ERROR) {
                    this.f12362a.m13085a(EnumC3328ag.get_server_address, c0778b2 != null ? c0778b2.m3112g() : "");
                    return;
                } else {
                    this.f12362a.f12120L.m9557c();
                    return;
                }
            }
            if (message.what == 1101) {
                C0784h c0784h = (C0784h) message.obj;
                int iM = c0784h.m18953m();
                if (!c0784h.m18954n() || (iM != 200 && iM != 204 && iM != 0)) {
                    this.f12362a.m13085a(EnumC3328ag.chaton_v, (String) null);
                    return;
                } else {
                    this.f12362a.m13075a(R.string.auto_regi_checking_version);
                    this.f12362a.f12123O.m9471b();
                    return;
                }
            }
            if (message.what == 1104) {
                C0778b c0778b3 = (C0778b) message.obj;
                if (!c0778b3.m18954n() || c0778b3.m3107b() == EnumC2464o.ERROR) {
                    this.f12362a.m13085a(EnumC3328ag.version_for_upgrade, c0778b3 != null ? c0778b3.m3112g() : "");
                    return;
                }
                GetVersionNotice getVersionNotice = (GetVersionNotice) c0778b3.m3110e();
                if (getVersionNotice != null) {
                    if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                        if (this.f12362a.f12132X) {
                            this.f12362a.m13059D();
                            return;
                        } else {
                            if (!this.f12362a.f12164r) {
                                this.f12362a.m13075a(R.string.auto_regi_checking_account);
                                this.f12362a.f12124P.mo9077a(this.f12362a.f12160az);
                                this.f12362a.f12160az.m18263a(1001, 30000);
                                return;
                            }
                            this.f12362a.m13146o();
                            return;
                        }
                    }
                    if (C4859bx.m18393b()) {
                        this.f12362a.f12146al = getVersionNotice;
                        this.f12362a.f12123O.m9472c();
                        return;
                    } else {
                        this.f12362a.m13148q();
                        C4822an.m18213a(getVersionNotice, this.f12362a.f12118J, false, "NO");
                        this.f12362a.f12150ap = true;
                        return;
                    }
                }
                return;
            }
            if (message.what == 1106) {
                C0778b c0778b4 = (C0778b) message.obj;
                AvaliableApps avaliableApps = (AvaliableApps) c0778b4.m3110e();
                this.f12362a.m13148q();
                this.f12362a.f12150ap = true;
                if (!c0778b4.m18954n() || c0778b4.m3107b() == EnumC2464o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                    C4822an.m18213a(this.f12362a.f12146al, this.f12362a.f12118J, false, "NO");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Samsung apps is NOT ready to upgrade chaton", this.f12362a.f12139ae);
                        return;
                    }
                    return;
                }
                C4809aa.m18104a().m18128b("UpdateAppsReady", "YES");
                C4822an.m18213a(this.f12362a.f12146al, this.f12362a.f12118J, false, "YES");
                if (C4904y.f17872b) {
                    C4904y.m18639b("Samsung apps is ready to upgrade chaton", this.f12362a.f12139ae);
                    return;
                }
                return;
            }
            if (message.what == 2003) {
                C0778b c0778b5 = (C0778b) message.obj;
                if (!c0778b5.m18954n() || c0778b5.m3107b() == EnumC2464o.ERROR) {
                    this.f12362a.m13085a(EnumC3328ag.SA_user_info, c0778b5 != null ? c0778b5.m3112g() : "");
                    return;
                }
                SSOUserInformationEntry sSOUserInformationEntry = (SSOUserInformationEntry) c0778b5.m3110e();
                C4904y.m18639b("userInfo : " + sSOUserInformationEntry, this.f12362a.f12139ae);
                if (TextUtils.isEmpty(sSOUserInformationEntry.loginID) || TextUtils.isEmpty(sSOUserInformationEntry.countryCode)) {
                    this.f12362a.m13148q();
                    this.f12362a.m13078a(this.f12362a.f12118J, EnumC3327af.normal, this.f12362a.f12165s);
                    return;
                }
                C4809aa.m18108a("samsung_account_email", sSOUserInformationEntry.loginID);
                C4809aa.m18108a("samsung_account_faimly_name", sSOUserInformationEntry.familyName);
                C4809aa.m18108a("samsung_account_given_name", sSOUserInformationEntry.givenName);
                C4809aa.m18108a("samsung_account_birthday", sSOUserInformationEntry.birthDate);
                if (!this.f12362a.f12163q) {
                    C4859bx.m18384a(sSOUserInformationEntry.countryCode, this.f12362a.f12118J, false);
                    if (this.f12362a.f12166t || !C4859bx.m18387a(C4809aa.m18104a().m18121a("temp_account_country_code", ""), this.f12362a)) {
                        this.f12362a.f12120L.m9552a();
                        return;
                    } else {
                        this.f12362a.m13148q();
                        return;
                    }
                }
                this.f12362a.m13148q();
                C4859bx.m18384a(sSOUserInformationEntry.countryCode, this.f12362a.f12118J, true);
                this.f12362a.m13086a(this.f12362a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12362a.f12130V, this.f12362a.f12131W);
                this.f12362a.m13112g(false);
                return;
            }
            if (message.what == 2005) {
                C0778b c0778b6 = (C0778b) message.obj;
                if ((c0778b6.m18954n() && c0778b6.m3107b() != EnumC2464o.ERROR) || c0778b6.m3111f() == 50003) {
                    String strM18121a = C4809aa.m18104a().m18121a("temp_account_country_code", "");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Final account ISO : " + strM18121a, getClass().getSimpleName());
                    }
                    C4809aa.m18105a("did_samsung_account_mapping", (Boolean) true);
                    C4809aa.m18104a().m18123a("account_mapping_fail");
                    if (this.f12362a.f12163q) {
                        this.f12362a.f12140af = 0;
                        C4859bx.m18410g();
                        C2417af.m10456c();
                        if (!C4822an.m18224b(strM18121a)) {
                            C4809aa.m18108a("account_country_code", strM18121a);
                            new C2122ca(this.f12362a.f12153as).m9471b();
                        } else {
                            C4809aa.m18108a("account_country_code", strM18121a);
                            if (C4859bx.m18386a(this.f12362a.f12118J)) {
                                this.f12362a.m13093b(this.f12362a.getResources().getString(R.string.synchronising_chatonv));
                                if (this.f12362a.f12142ah != null) {
                                    this.f12362a.f12148an.m9312c(null);
                                } else {
                                    this.f12362a.m13093b(this.f12362a.getResources().getString(R.string.auto_regi_buddy_sync));
                                    C2186al.m9763a();
                                    this.f12362a.f12122N.m9495a();
                                    this.f12362a.f12122N.m9515c();
                                }
                            } else {
                                this.f12362a.m13093b(this.f12362a.getResources().getString(R.string.auto_regi_buddy_sync));
                                C2186al.m9763a();
                                this.f12362a.f12122N.m9495a();
                                this.f12362a.f12122N.m9515c();
                            }
                        }
                        C2417af.m10456c();
                        C2198l.m9940b();
                        return;
                    }
                    return;
                }
                if (c0778b6.m3111f() == 50006) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("SSO token validaion was finished", getClass().getSimpleName());
                    }
                    if (this.f12362a.f12147am >= 13001) {
                        this.f12362a.m13052A();
                        return;
                    }
                    this.f12362a.m13148q();
                    C4809aa.m18104a().m18123a("samsung_account_email");
                    this.f12362a.m13133w();
                    return;
                }
                if (c0778b6.m3111f() == 50002) {
                    this.f12362a.m13148q();
                    C4904y.m18639b("aucode was expired", this.f12362a.f12139ae);
                    C4809aa.m18104a().m18123a("samsung_account_email");
                    this.f12362a.m13133w();
                    return;
                }
                if (c0778b6.m3111f() != 50004) {
                    this.f12362a.m13085a(EnumC3328ag.mapping, c0778b6 != null ? c0778b6.m3112g() : "");
                    return;
                }
                this.f12362a.m13148q();
                C4904y.m18639b("device over max of limitation", this.f12362a.f12139ae);
                this.f12362a.f12141ag = AbstractC4932a.m18733a(this.f12362a.f12118J).mo18740a(this.f12362a.getResources().getString(R.string.pop_up_attention)).mo18751b(false).mo18749b(this.f12362a.getResources().getString(R.string.account_max_device_alert4, 5)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3402v(this)).mo18745a();
                if (!this.f12362a.f12166t) {
                    this.f12362a.f12141ag.show();
                    return;
                }
                return;
            }
            if (message.what == 2002) {
                C0778b c0778b7 = (C0778b) message.obj;
                if (!c0778b7.m18954n() || c0778b7.m3107b() == EnumC2464o.ERROR) {
                    this.f12362a.m13085a(EnumC3328ag.SA_access_token, c0778b7 != null ? c0778b7.m3112g() : "");
                    return;
                }
                SSOAccessTokenEntry sSOAccessTokenEntry = (SSOAccessTokenEntry) c0778b7.m3110e();
                C4904y.m18639b("accessToken : " + sSOAccessTokenEntry, this.f12362a.f12139ae);
                if (!TextUtils.isEmpty(sSOAccessTokenEntry.access_token) && !TextUtils.isEmpty(sSOAccessTokenEntry.userId)) {
                    this.f12362a.f12128T = sSOAccessTokenEntry.access_token;
                    this.f12362a.f12144aj = sSOAccessTokenEntry.userId;
                    C4809aa.m18108a("samsung_account_user_id", this.f12362a.f12144aj);
                    C4809aa.m18108a("samsung_account_token", this.f12362a.f12128T);
                    this.f12362a.f12119K.m9392b(this.f12362a.f12128T, "fs24s8z0hh", this.f12362a.f12144aj);
                    return;
                }
                this.f12362a.m13148q();
                this.f12362a.m13078a(this.f12362a.f12118J, EnumC3327af.normal, this.f12362a.f12165s);
                return;
            }
            if (message.what == 2006) {
                C0778b c0778b8 = (C0778b) message.obj;
                if (c0778b8.m18954n() && c0778b8.m3107b() != EnumC2464o.ERROR) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Fianlly register was success with SA automatically", this.f12362a.f12139ae);
                    }
                    this.f12362a.f12140af = 0;
                    String strM18121a2 = C4809aa.m18104a().m18121a("temp_account_country_code", "");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Final account ISO : " + strM18121a2, getClass().getSimpleName());
                    }
                    C4809aa.m18105a("did_samsung_account_mapping", (Boolean) true);
                    C4859bx.m18410g();
                    C4809aa.m18108a("account_country_code", strM18121a2);
                    if (!this.f12362a.f12166t) {
                        this.f12362a.m13063F();
                        return;
                    }
                    return;
                }
                if (c0778b8.m3111f() == 50006) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("SSO token validaion was finished", this.f12362a.f12139ae);
                    }
                    if (!this.f12362a.f12166t) {
                        this.f12362a.m13052A();
                        return;
                    }
                    return;
                }
                if (c0778b8.m3111f() == 50004) {
                    if (!this.f12362a.f12166t) {
                        this.f12362a.m13148q();
                        C4904y.m18639b("device over max of limitation", getClass().getSimpleName());
                        this.f12362a.f12141ag = AbstractC4932a.m18733a(this.f12362a.f12118J).mo18740a(this.f12362a.getResources().getString(R.string.pop_up_attention)).mo18751b(false).mo18749b(this.f12362a.getResources().getString(R.string.account_max_device_alert4, 5)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3403w(this)).mo18745a();
                        this.f12362a.f12141ag.setCancelable(false);
                        if (!this.f12362a.f12166t) {
                            this.f12362a.f12141ag.show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!this.f12362a.f12166t) {
                    this.f12362a.m13085a(EnumC3328ag.auto_regi, c0778b8 != null ? c0778b8.m3112g() : "");
                }
            }
        }
    }
}
