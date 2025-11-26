package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetSMSAuthToken;
import com.sec.chaton.registration.ActivitySelectLanguage;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: ActivitySelectLanguage.java */
/* renamed from: com.sec.chaton.registration.au */
/* loaded from: classes.dex */
class HandlerC0949au extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySelectLanguage.SelectLanguageFragment f3340a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0949au(ActivitySelectLanguage.SelectLanguageFragment selectLanguageFragment, Looper looper) {
        super(looper);
        this.f3340a = selectLanguageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 1303) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                this.f3340a.f3249b = (GetSMSAuthToken) c0259g.m932d();
                if (this.f3340a.f3249b != null) {
                    C1341p.m4658b("mToken=" + this.f3340a.f3249b.token, getClass().getSimpleName());
                    this.f3340a.f3264q = this.f3340a.f3249b.token;
                    C1323bs.m4579a("acstoken", this.f3340a.f3264q);
                    this.f3340a.m3722b();
                    return;
                }
            } else {
                new AlertDialog.Builder(this.f3340a.getActivity()).setTitle(this.f3340a.getResources().getString(R.string.toast_error)).setMessage(this.f3340a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0929aa(this)).create().show();
                C1341p.m4661d("Token for ACS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f3340a.getActivity() != null) {
                this.f3340a.f3259l.dismiss();
            }
        }
        if (message.what == 1304) {
            C1341p.m4661d("entry.getFaultCode()" + c0259g.m934f(), getClass().getSimpleName());
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                if (this.f3340a.getActivity() != null) {
                    this.f3340a.f3259l.dismiss();
                }
                this.f3340a.getActivity().setResult(-1);
                this.f3340a.getActivity().finish();
            } else if (c0259g.m934f() == 41002) {
                C1341p.m4661d("You have reached your daily ACS limit", getClass().getSimpleName());
                this.f3340a.m3723c();
            } else {
                new AlertDialog.Builder(this.f3340a.getActivity()).setTitle(this.f3340a.getResources().getString(R.string.toast_error)).setMessage(this.f3340a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0994z(this)).create().show();
                C1341p.m4661d("Requesting ACS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f3340a.getActivity() != null) {
                this.f3340a.f3259l.dismiss();
            }
        }
    }
}
