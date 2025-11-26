package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetSMSAuthToken;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.registration.ActivitySelectLanguage;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivitySelectLanguage.java */
/* renamed from: com.sec.chaton.registration.ar */
/* loaded from: classes.dex */
class HandlerC1164ar extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySelectLanguage.SelectLanguageFragment f4366a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1164ar(ActivitySelectLanguage.SelectLanguageFragment selectLanguageFragment, Looper looper) {
        super(looper);
        this.f4366a = selectLanguageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 1303) {
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                this.f4366a.f4274b = (GetSMSAuthToken) c0101b.m671d();
                if (this.f4366a.f4274b != null) {
                    C1786r.m6061b("mToken=" + this.f4366a.f4274b.token, getClass().getSimpleName());
                    this.f4366a.f4290r = this.f4366a.f4274b.token;
                    C1789u.m6079a("acstoken", this.f4366a.f4290r);
                    this.f4366a.m4411c();
                    return;
                }
            } else if (c0101b.m673f() == 31003) {
                C1786r.m6065d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                ActivityNonSelfSMS.NonSelfSMSFragment.m4334a(this.f4366a.getActivity());
                if (this.f4366a.getActivity() != null) {
                    this.f4366a.f4284l.dismiss();
                }
            } else {
                new AlertDialogBuilderC2120a(this.f4366a.getActivity()).setTitle(this.f4366a.getResources().getString(R.string.toast_error)).setMessage(this.f4366a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1165as(this)).create().show();
                C1786r.m6065d("Token for ACS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f4366a.getActivity() != null) {
                this.f4366a.f4284l.dismiss();
            }
        }
        if (message.what == 1304) {
            C1786r.m6065d("entry.getFaultCode()" + c0101b.m673f(), getClass().getSimpleName());
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                this.f4366a.f4284l.dismiss();
                if (this.f4366a.getActivity() != null) {
                    this.f4366a.getActivity().setResult(-1);
                    this.f4366a.getActivity().finish();
                    C1789u.m6076a("over_acs_request", (Boolean) false);
                }
            } else if (c0101b.m673f() == 41004) {
                C1786r.m6065d("server sent error cause by REQUEST_ACS_REQUEST_LIMIT", getClass().getSimpleName());
            } else if (c0101b.m673f() == 41002) {
                C1786r.m6065d("You have reached your daily ACS limit", getClass().getSimpleName());
                this.f4366a.m4414d();
                C1789u.m6076a("over_acs_request", (Boolean) true);
            } else if (this.f4366a.getActivity() != null) {
                new AlertDialogBuilderC2120a(this.f4366a.getActivity()).setTitle(this.f4366a.getResources().getString(R.string.toast_error)).setMessage(this.f4366a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1166at(this)).show();
                C1786r.m6065d("Requesting ACS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f4366a.getActivity() != null) {
                this.f4366a.f4284l.dismiss();
            }
        }
    }
}
