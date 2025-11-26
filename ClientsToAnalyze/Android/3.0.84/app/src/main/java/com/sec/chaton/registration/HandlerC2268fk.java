package com.sec.chaton.registration;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetSMSAuthToken;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentSelectLanguage.java */
/* renamed from: com.sec.chaton.registration.fk */
/* loaded from: classes.dex */
class HandlerC2268fk extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentSelectLanguage f8564a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2268fk(FragmentSelectLanguage fragmentSelectLanguage, Looper looper) {
        super(looper);
        this.f8564a = fragmentSelectLanguage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 1303) {
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                this.f8564a.f8340b = (GetSMSAuthToken) c0267d.m1354e();
                if (this.f8564a.f8340b != null) {
                    C3250y.m11450b("mToken=" + this.f8564a.f8340b.token, getClass().getSimpleName());
                    this.f8564a.f8354p = this.f8564a.f8340b.token;
                    C3159aa.m10966a("acstoken", this.f8564a.f8354p);
                    C3159aa.m10962a().m10981a("ACSSaveCountInterval");
                    this.f8564a.m8649c();
                    return;
                }
            } else if (c0267d.m1355f() == 31001) {
                C3250y.m11455d("server sent error cause by GET_ACS_AUTHTOKEN_INVALID", getClass().getSimpleName());
                AbstractC3271a.m11494a(this.f8564a.getActivity()).mo11500a(this.f8564a.getResources().getString(R.string.toast_error)).mo11509b(this.f8564a.getResources().getString(R.string.registration_check_phone_number)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2269fl(this)).mo11505a().show();
                if (this.f8564a.getActivity() != null) {
                    this.f8564a.f8349k.dismiss();
                }
            } else if (c0267d.m1355f() == 31003) {
                C3250y.m11455d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                FragmentNonSelfSMS.m8533a(this.f8564a.getActivity());
                if (this.f8564a.getActivity() != null) {
                    this.f8564a.f8349k.dismiss();
                }
            } else if (c0267d.m1355f() == 31001) {
                C3250y.m11455d("server sent error cause by GET_ACS_AUTHTOKEN_INVALID", getClass().getSimpleName());
                if (this.f8564a.getActivity() != null) {
                    AbstractC3271a.m11494a(this.f8564a.getActivity()).mo11500a(this.f8564a.getResources().getString(R.string.toast_error)).mo11509b(this.f8564a.getResources().getString(R.string.registration_check_phone_number)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2270fm(this)).mo11505a().show();
                    if (this.f8564a.getActivity() != null) {
                        this.f8564a.f8349k.dismiss();
                    }
                } else {
                    return;
                }
            } else if (this.f8564a.getActivity() != null) {
                AbstractC3271a.m11494a(this.f8564a.getActivity()).mo11500a(this.f8564a.getResources().getString(R.string.toast_error)).mo11509b(this.f8564a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2271fn(this)).mo11505a().show();
                C3250y.m11455d("Token for ACS failed becuase netwrok error", getClass().getSimpleName());
            } else {
                return;
            }
            if (this.f8564a.getActivity() != null) {
                this.f8564a.f8349k.dismiss();
            }
        }
        if (message.what == 1304) {
            C3250y.m11455d("entry.getFaultCode()" + c0267d.m1355f(), getClass().getSimpleName());
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                if (this.f8564a.getActivity() != null) {
                    this.f8564a.f8349k.dismiss();
                    C3159aa.m10963a("over_acs_request", (Boolean) false);
                    this.f8564a.getActivity().setResult(-1);
                    this.f8564a.getActivity().finish();
                } else {
                    return;
                }
            } else if (c0267d.m1355f() == 41004) {
                C3250y.m11455d("server sent error cause by REQUEST_ACS_REQUEST_LIMIT", getClass().getSimpleName());
            } else if (c0267d.m1355f() == 41002) {
                C3250y.m11455d("You have reached your daily ACS limit", getClass().getSimpleName());
                this.f8564a.m8650d();
                C3159aa.m10963a("over_acs_request", (Boolean) true);
            } else if (this.f8564a.getActivity() != null) {
                AbstractC3271a.m11494a(this.f8564a.getActivity()).mo11500a(this.f8564a.getResources().getString(R.string.toast_error)).mo11509b(this.f8564a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2272fo(this)).mo11505a().show();
                C3250y.m11455d("Requesting ACS failed becuase netwrok error", getClass().getSimpleName());
            } else {
                return;
            }
            if (this.f8564a.getActivity() != null) {
                this.f8564a.f8349k.dismiss();
            }
        }
    }
}
