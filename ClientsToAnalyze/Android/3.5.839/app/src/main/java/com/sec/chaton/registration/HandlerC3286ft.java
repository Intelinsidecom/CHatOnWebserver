package com.sec.chaton.registration;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentSelectLanguage.java */
/* renamed from: com.sec.chaton.registration.ft */
/* loaded from: classes.dex */
class HandlerC3286ft extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentSelectLanguage f12054a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3286ft(FragmentSelectLanguage fragmentSelectLanguage, Looper looper) {
        super(looper);
        this.f12054a = fragmentSelectLanguage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 1303) {
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                this.f12054a.f11814b = (GetSMSAuthToken) c0778b.m3110e();
                if (this.f12054a.f11814b != null) {
                    C4904y.m18639b("mToken=" + this.f12054a.f11814b.token, getClass().getSimpleName());
                    this.f12054a.f11828p = this.f12054a.f11814b.token;
                    C4809aa.m18108a("acstoken", this.f12054a.f11828p);
                    C4809aa.m18104a().m18123a("ACSSaveCountInterval");
                    this.f12054a.m13002c();
                    return;
                }
            } else if (c0778b.m3111f() == 31001) {
                C4904y.m18645d("server sent error cause by GET_ACS_AUTHTOKEN_INVALID", getClass().getSimpleName());
                AbstractC4932a.m18733a(this.f12054a.getActivity()).mo18740a(this.f12054a.getResources().getString(R.string.toast_error)).mo18749b(this.f12054a.getResources().getString(R.string.error_code_common) + " " + this.f12054a.getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3287fu(this)).mo18745a().show();
                if (this.f12054a.getActivity() != null) {
                    this.f12054a.f11823k.dismiss();
                }
            } else if (c0778b.m3111f() == 31003) {
                C4904y.m18645d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                FragmentNonSelfSMS.m12864a(this.f12054a.getActivity());
                if (this.f12054a.getActivity() != null) {
                    this.f12054a.f11823k.dismiss();
                }
            } else if (c0778b.m3111f() == 31001) {
                C4904y.m18645d("server sent error cause by GET_ACS_AUTHTOKEN_INVALID", getClass().getSimpleName());
                if (this.f12054a.getActivity() != null) {
                    AbstractC4932a.m18733a(this.f12054a.getActivity()).mo18740a(this.f12054a.getResources().getString(R.string.toast_error)).mo18749b(this.f12054a.getResources().getString(R.string.error_code_common) + " " + this.f12054a.getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3288fv(this)).mo18745a().show();
                    if (this.f12054a.getActivity() != null) {
                        this.f12054a.f11823k.dismiss();
                    }
                } else {
                    return;
                }
            } else if (this.f12054a.getActivity() != null) {
                AbstractC4932a.m18733a(this.f12054a.getActivity()).mo18740a(this.f12054a.getResources().getString(R.string.toast_error)).mo18749b(this.f12054a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3289fw(this)).mo18745a().show();
                C4904y.m18645d("Token for ACS failed becuase netwrok error", getClass().getSimpleName());
            } else {
                return;
            }
            if (this.f12054a.getActivity() != null) {
                this.f12054a.f11823k.dismiss();
            }
        }
        if (message.what == 1304) {
            C4904y.m18645d("entry.getFaultCode()" + c0778b.m3111f(), getClass().getSimpleName());
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                if (this.f12054a.getActivity() != null) {
                    this.f12054a.f11823k.dismiss();
                    C4809aa.m18105a("over_acs_request", (Boolean) false);
                    this.f12054a.getActivity().setResult(-1);
                    this.f12054a.getActivity().finish();
                } else {
                    return;
                }
            } else if (c0778b.m3111f() == 41004) {
                C4904y.m18645d("server sent error cause by REQUEST_ACS_REQUEST_LIMIT", getClass().getSimpleName());
            } else if (c0778b.m3111f() == 41002) {
                C4904y.m18645d("You have reached your daily ACS limit", getClass().getSimpleName());
                this.f12054a.m13003d();
                C4809aa.m18105a("over_acs_request", (Boolean) true);
            } else if (this.f12054a.getActivity() != null) {
                AbstractC4932a.m18733a(this.f12054a.getActivity()).mo18740a(this.f12054a.getResources().getString(R.string.toast_error)).mo18749b(this.f12054a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3290fx(this)).mo18745a().show();
                C4904y.m18645d("Requesting ACS failed becuase netwrok error", getClass().getSimpleName());
            } else {
                return;
            }
            if (this.f12054a.getActivity() != null) {
                this.f12054a.f11823k.dismiss();
            }
        }
    }
}
