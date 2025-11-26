package com.sec.chaton.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p065io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p065io.entry.GetSSMServerAddress4;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ee */
/* loaded from: classes.dex */
class HandlerC3244ee extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12011a;

    HandlerC3244ee(FragmentRegist fragmentRegist) {
        this.f12011a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f12011a.getActivity() != null) {
            if (message.what == 104) {
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (this.f12011a.f11767az) {
                        if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                            this.f12011a.f11729R.dismiss();
                        }
                        this.f12011a.getActivity().setResult(3, new Intent());
                        this.f12011a.getActivity().finish();
                        return;
                    }
                    GetSSMServerAddress4 getSSMServerAddress4 = (GetSSMServerAddress4) c0778b.m3110e();
                    if (this.f12011a.f11764aw) {
                        if (C2349a.m10301a("chatonv_feature")) {
                            this.f12011a.f11736Y.m9483a(EnumC2463n.UI);
                            return;
                        } else if (this.f12011a.f11760as) {
                            this.f12011a.f11737Z.m9470a("FIRST");
                            return;
                        } else {
                            this.f12011a.f11737Z.m9471b();
                            return;
                        }
                    }
                    try {
                        if (!TextUtils.isEmpty(getSSMServerAddress4.msisdn)) {
                            C4904y.m18639b("msisnd =" + getSSMServerAddress4.msisdn, getClass().getSimpleName());
                            this.f12011a.f11768h = getSSMServerAddress4.msisdn;
                            if (this.f12011a.f11728Q.equals("AR") || this.f12011a.f11728Q.equals("MX") || this.f12011a.f11728Q.equals("BR")) {
                                C4809aa.m18108a("phonenumber", this.f12011a.f11719H.getText().toString() + this.f12011a.f11720I.m18658a().toString());
                            } else {
                                C4809aa.m18108a("phonenumber", this.f12011a.f11720I.m18658a().toString());
                            }
                            C4809aa.m18108a("msisdn_temp", this.f12011a.f11768h);
                            C4904y.m18639b("authType=" + this.f12011a.f11747af, getClass().getSimpleName());
                            if (this.f12011a.f11752ak == null) {
                                this.f12011a.f11735X.m9355a(this.f12011a.f11768h, false);
                                return;
                            } else if (C2349a.m10301a("chatonv_feature")) {
                                this.f12011a.f11736Y.m9483a(EnumC2463n.UI);
                                return;
                            } else {
                                this.f12011a.f11737Z.m9470a("FIRST");
                                return;
                            }
                        }
                        return;
                    } catch (Exception e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                        return;
                    }
                }
                if (c0778b.m3111f() != 44002 && c0778b.m3111f() != 44001 && c0778b.m3111f() != 12002) {
                    this.f12011a.m12922b(c0778b.m3112g());
                    return;
                }
                C4904y.m18645d("server sent error cause by WRONG_PARAMETER_VALUE", getClass().getSimpleName());
                if (this.f12011a.f11764aw) {
                    if (C2349a.m10301a("chatonv_feature")) {
                        this.f12011a.f11736Y.m9483a(EnumC2463n.UI);
                        return;
                    } else if (this.f12011a.f11760as) {
                        this.f12011a.f11737Z.m9470a("FIRST");
                        return;
                    } else {
                        this.f12011a.f11737Z.m9471b();
                        return;
                    }
                }
                if (this.f12011a.getActivity() != null) {
                    if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                        this.f12011a.f11729R.dismiss();
                    }
                    this.f12011a.f11743ab = AbstractC4932a.m18733a(this.f12011a.getActivity()).mo18740a(this.f12011a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12011a.getResources().getString(R.string.error_code_common) + " " + this.f12011a.getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3245ef(this)).mo18745a();
                    if (this.f12011a.getActivity() != null) {
                        this.f12011a.f11743ab.show();
                        return;
                    }
                    return;
                }
                return;
            }
            if (message.what == 1101) {
                C0784h c0784h = (C0784h) message.obj;
                int iM = c0784h.m18953m();
                if (!c0784h.m18954n() || (iM != 200 && iM != 204 && iM != 0)) {
                    this.f12011a.m12922b((String) null);
                    return;
                } else if (this.f12011a.f11760as) {
                    this.f12011a.f11737Z.m9470a("FIRST");
                    return;
                } else {
                    this.f12011a.f11737Z.m9471b();
                    return;
                }
            }
            if (message.what == 1105) {
                C0778b c0778b2 = (C0778b) message.obj;
                if ((!c0778b2.m18954n() || c0778b2.m3107b() == EnumC2464o.ERROR) && c0778b2.m3111f() != 42001) {
                    this.f12011a.m12922b(c0778b2.m3112g());
                    return;
                }
                C4809aa.m18108a("first_disclaimer_status", "DONE");
                C4809aa.m18104a().m18128b("provisioning_disclaimer_status", "DONE");
                if (this.f12011a.f11764aw) {
                    if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                        this.f12011a.f11729R.dismiss();
                    }
                    this.f12011a.getActivity().setResult(6, new Intent());
                    this.f12011a.getActivity().finish();
                    return;
                }
                this.f12011a.f11735X.m9355a(this.f12011a.f11768h, false);
                return;
            }
            if (message.what == 1104) {
                C0778b c0778b3 = (C0778b) message.obj;
                if (!c0778b3.m18954n() || c0778b3.m3107b() == EnumC2464o.ERROR) {
                    this.f12011a.m12922b(c0778b3.m3112g());
                    return;
                }
                GetVersionNotice getVersionNotice = (GetVersionNotice) c0778b3.m3110e();
                if (getVersionNotice == null) {
                    this.f12011a.m12922b(c0778b3.m3112g());
                    return;
                }
                if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                    this.f12011a.f11737Z.m9470a("FIRST");
                    return;
                }
                if (C4859bx.m18393b()) {
                    this.f12011a.f11766ay = getVersionNotice;
                    this.f12011a.f11737Z.m9472c();
                    return;
                } else {
                    if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                        this.f12011a.f11729R.dismiss();
                    }
                    C4822an.m18213a(getVersionNotice, this.f12011a.getActivity(), false, "NO");
                    return;
                }
            }
            if (message.what == 1106) {
                C0778b c0778b4 = (C0778b) message.obj;
                AvaliableApps avaliableApps = (AvaliableApps) c0778b4.m3110e();
                if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                    this.f12011a.f11729R.dismiss();
                }
                if (!c0778b4.m18954n() || c0778b4.m3107b() == EnumC2464o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                    C4822an.m18213a(this.f12011a.f11766ay, this.f12011a.getActivity(), false, "NO");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Samsung apps is NOT ready to upgrade chaton", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                C4822an.m18213a(this.f12011a.f11766ay, this.f12011a.getActivity(), false, "YES");
                if (C4904y.f17872b) {
                    C4904y.m18639b("Samsung apps is ready to upgrade chaton", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if (message.what == 205) {
                C0778b c0778b5 = (C0778b) message.obj;
                if (c0778b5.m18954n() && c0778b5.m3107b() != EnumC2464o.ERROR) {
                    CheckInRegisterParamEntry checkInRegisterParamEntry = (CheckInRegisterParamEntry) c0778b5.m3110e();
                    if (checkInRegisterParamEntry == null) {
                        this.f12011a.m12922b(c0778b5.m3112g());
                        if (C4904y.f17872b) {
                            C4904y.m18639b("result is null", getClass().getSimpleName());
                            return;
                        }
                        return;
                    }
                    if (checkInRegisterParamEntry.update_msisdn_result == null || !checkInRegisterParamEntry.update_msisdn_result.booleanValue()) {
                        if (this.f12011a.f11754am) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("Already checked update MSISDN", getClass().getSimpleName());
                            }
                            this.f12011a.m12929e();
                            this.f12011a.f11754am = false;
                            return;
                        }
                        if (checkInRegisterParamEntry.exist_msisdn != null && checkInRegisterParamEntry.exist_msisdn.booleanValue()) {
                            if (this.f12011a.getActivity() != null && this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                                this.f12011a.f11729R.dismiss();
                            }
                            this.f12011a.f11743ab = AbstractC4932a.m18733a(this.f12011a.getActivity()).mo18740a(this.f12011a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12011a.getResources().getString(R.string.alert_phone_number_already_registered)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3248ei(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3247eh(this)).mo18745a();
                            if (this.f12011a.getActivity() != null) {
                                this.f12011a.f11743ab.show();
                                return;
                            }
                            return;
                        }
                        if (checkInRegisterParamEntry.exist_imei != null && checkInRegisterParamEntry.exist_imei.booleanValue()) {
                            if (!C4822an.m18255w()) {
                                this.f12011a.m12929e();
                                return;
                            } else {
                                if (this.f12011a.getActivity() != null) {
                                    this.f12011a.f11735X.m9355a(this.f12011a.f11768h, true);
                                    this.f12011a.f11754am = true;
                                    return;
                                }
                                return;
                            }
                        }
                        if (!C4822an.m18255w()) {
                            this.f12011a.m12929e();
                            return;
                        } else {
                            if (this.f12011a.getActivity() != null) {
                                this.f12011a.f11735X.m9355a(this.f12011a.f11768h, true);
                                this.f12011a.f11754am = true;
                                return;
                            }
                            return;
                        }
                    }
                    if (this.f12011a.getActivity() != null && this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                        this.f12011a.f11729R.dismiss();
                    }
                    this.f12011a.f11743ab = AbstractC4932a.m18733a(this.f12011a.getActivity()).mo18740a(this.f12011a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12011a.getResources().getString(R.string.registration_pop_up_skip_verify)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3246eg(this)).mo18745a();
                    this.f12011a.f11743ab.setCancelable(false);
                    if (this.f12011a.getActivity() != null) {
                        this.f12011a.f11743ab.show();
                        return;
                    }
                    return;
                }
                if (c0778b5.m3111f() != 12002) {
                    this.f12011a.m12922b(c0778b5.m3112g());
                    return;
                }
                if (this.f12011a.getActivity() != null) {
                    if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                        this.f12011a.f11729R.dismiss();
                    }
                    this.f12011a.f11743ab = AbstractC4932a.m18733a(this.f12011a.getActivity()).mo18740a(this.f12011a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12011a.getResources().getString(R.string.error_code_common) + " " + this.f12011a.getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3249ej(this)).mo18745a();
                    this.f12011a.f11743ab.show();
                    return;
                }
                return;
            }
            if (message.what == 211) {
                C0778b c0778b6 = (C0778b) message.obj;
                if (this.f12011a.f11729R != null && this.f12011a.f11729R.isShowing()) {
                    this.f12011a.f11729R.dismiss();
                }
                if (this.f12011a.getActivity() != null && this.f12011a.f11730S != null && this.f12011a.f11730S.isShowing()) {
                    this.f12011a.f11730S.dismiss();
                }
                if (c0778b6.m18954n() && c0778b6.m3107b() != EnumC2464o.ERROR) {
                    this.f12011a.m12931f();
                    return;
                }
                if (c0778b6.m3111f() == 12007) {
                    this.f12011a.f11743ab = AbstractC4932a.m18733a(this.f12011a.getActivity()).mo18740a(this.f12011a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f12011a.getResources().getString(R.string.error_code_common) + " " + this.f12011a.getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3250ek(this)).mo18745a();
                    if (this.f12011a.getActivity() != null) {
                        this.f12011a.f11743ab.show();
                        return;
                    }
                    return;
                }
                if (c0778b6.m3111f() != 12008) {
                    this.f12011a.m12922b(c0778b6.m3112g());
                } else {
                    FragmentNonSelfSMS.m12873b((Activity) this.f12011a.getActivity(), true);
                }
            }
        }
    }
}
