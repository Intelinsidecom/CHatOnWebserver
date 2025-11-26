package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.CheckInRegisterParamEntry;
import com.sec.chaton.p035io.entry.GetSSMServerAddress4;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ea */
/* loaded from: classes.dex */
class HandlerC2231ea extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8526a;

    HandlerC2231ea(FragmentRegist fragmentRegist) {
        this.f8526a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f8526a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 104) {
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    GetSSMServerAddress4 getSSMServerAddress4 = (GetSSMServerAddress4) c0267d.m1354e();
                    try {
                        if (!TextUtils.isEmpty(getSSMServerAddress4.msisdn)) {
                            C3250y.m11450b("msisnd =" + getSSMServerAddress4.msisdn, getClass().getSimpleName());
                            this.f8526a.f8289c = getSSMServerAddress4.msisdn;
                            if (this.f8526a.f8268H.equals("AR") || this.f8526a.f8268H.equals("MX") || this.f8526a.f8268H.equals("BR")) {
                                C3159aa.m10966a("phonenumber", this.f8526a.f8312z.getText().toString() + this.f8526a.f8261A.m11463a().toString());
                            } else {
                                C3159aa.m10966a("phonenumber", this.f8526a.f8261A.m11463a().toString());
                            }
                            C3159aa.m10966a("msisdn_temp", this.f8526a.f8289c);
                            C3250y.m11450b("authType=" + this.f8526a.f8280T, getClass().getSimpleName());
                            this.f8526a.f8275O.m5602a(this.f8526a.f8289c, false);
                        }
                    } catch (Exception e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                    }
                } else if (c0267d.m1355f() != 44002 && c0267d.m1355f() != 44001) {
                    this.f8526a.m8579b(c0267d.m1356g());
                } else {
                    C3250y.m11455d("server sent error cause by WRONG_PARAMETER_VALUE", getClass().getSimpleName());
                    if (this.f8526a.getActivity() != null) {
                        if (this.f8526a.f8269I != null && this.f8526a.f8269I.isShowing()) {
                            this.f8526a.f8269I.dismiss();
                        }
                        this.f8526a.f8276P = AbstractC3271a.m11494a(this.f8526a.getActivity()).mo11500a(this.f8526a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8526a.getResources().getString(R.string.registration_check_phone_number)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2232eb(this)).mo11505a();
                        if (this.f8526a.getActivity() != null) {
                            this.f8526a.f8276P.show();
                        }
                    }
                }
            } else if (message.what == 205) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8526a.m8579b(c0267d.m1356g());
                } else {
                    CheckInRegisterParamEntry checkInRegisterParamEntry = (CheckInRegisterParamEntry) c0267d.m1354e();
                    if (checkInRegisterParamEntry == null) {
                        this.f8526a.m8579b(c0267d.m1356g());
                        if (C3250y.f11734b) {
                            C3250y.m11450b("result is null", getClass().getSimpleName());
                        }
                    } else if (checkInRegisterParamEntry.update_msisdn_result == null || !checkInRegisterParamEntry.update_msisdn_result.booleanValue()) {
                        if (this.f8526a.f8286Z) {
                            if (C3250y.f11734b) {
                                C3250y.m11450b("Already checked update MSISDN", getClass().getSimpleName());
                            }
                            this.f8526a.m8586e();
                            this.f8526a.f8286Z = false;
                            return;
                        }
                        if (checkInRegisterParamEntry.exist_msisdn != null && checkInRegisterParamEntry.exist_msisdn.booleanValue()) {
                            if (this.f8526a.getActivity() != null && this.f8526a.f8269I != null && this.f8526a.f8269I.isShowing()) {
                                this.f8526a.f8269I.dismiss();
                            }
                            this.f8526a.f8276P = AbstractC3271a.m11494a(this.f8526a.getActivity()).mo11500a(this.f8526a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8526a.getResources().getString(R.string.alert_phone_number_already_registered)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2235ee(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2234ed(this)).mo11505a();
                            if (this.f8526a.getActivity() != null) {
                                this.f8526a.f8276P.show();
                            }
                        } else if (checkInRegisterParamEntry.exist_imei != null && checkInRegisterParamEntry.exist_imei.booleanValue()) {
                            if (!C3171am.m11080r()) {
                                this.f8526a.m8586e();
                            } else if (this.f8526a.getActivity() != null) {
                                this.f8526a.f8275O.m5602a(this.f8526a.f8289c, true);
                                this.f8526a.f8286Z = true;
                            }
                        } else if (!C3171am.m11080r()) {
                            this.f8526a.m8586e();
                        } else if (this.f8526a.getActivity() != null) {
                            this.f8526a.f8275O.m5602a(this.f8526a.f8289c, true);
                            this.f8526a.f8286Z = true;
                        }
                    } else {
                        if (this.f8526a.getActivity() != null && this.f8526a.f8269I != null && this.f8526a.f8269I.isShowing()) {
                            this.f8526a.f8269I.dismiss();
                        }
                        this.f8526a.f8276P = AbstractC3271a.m11494a(this.f8526a.getActivity()).mo11500a(this.f8526a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f8526a.getResources().getString(R.string.registration_pop_up_skip_verify)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2233ec(this)).mo11505a();
                        this.f8526a.f8276P.setCancelable(false);
                        if (this.f8526a.getActivity() != null) {
                            this.f8526a.f8276P.show();
                        }
                    }
                }
            }
            if (this.f8526a.f8280T.equals("SMS")) {
            }
        }
    }
}
