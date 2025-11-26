package com.sec.chaton.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0203b;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetSMSAuthToken;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.bf */
/* loaded from: classes.dex */
class HandlerC0961bf extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3353a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0961bf(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment, Looper looper) {
        super(looper);
        this.f3353a = nonSelfSMSFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 1301) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                this.f3353a.f3155a = (GetSMSAuthToken) c0259g.m932d();
                if (this.f3353a.f3155a != null) {
                    C1341p.m4658b("mToken=" + this.f3353a.f3155a.token, getClass().getSimpleName());
                    this.f3353a.f3179y = this.f3353a.f3155a.token;
                    C1323bs.m4579a("token", this.f3353a.f3155a.token);
                    this.f3353a.m3671e();
                } else if (this.f3353a.getActivity() != null) {
                    new AlertDialogBuilderC1625m(this.f3353a.getActivity()).setTitle(this.f3353a.getResources().getString(R.string.toast_error)).setMessage(this.f3353a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0972d(this)).create().show();
                }
                if (this.f3353a.getActivity() != null) {
                    this.f3353a.f3168n.dismiss();
                }
            } else if (c0259g.m934f() == 30002) {
                C1341p.m4661d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                this.f3353a.m3665b();
                if (this.f3353a.getActivity() != null) {
                    this.f3353a.f3168n.dismiss();
                }
            } else if (this.f3353a.getActivity() != null) {
                new AlertDialogBuilderC1625m(this.f3353a.getActivity()).setTitle(this.f3353a.getResources().getString(R.string.toast_error)).setMessage(this.f3353a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0955b(this)).create().show();
                C1341p.m4651a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f3353a.getActivity() != null) {
                this.f3353a.f3168n.dismiss();
            }
        }
        if (message.what == 1302) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                if (this.f3353a.getActivity() != null) {
                    this.f3353a.f3168n.dismiss();
                }
                this.f3353a.f3153B = true;
            } else if (c0259g.m934f() == 40003) {
                this.f3353a.f3179y = null;
                C1323bs.m4579a("token", (String) null);
                C1341p.m4661d("server sent error cause by SEND_SMS_REQUEST_LIMIT", getClass().getSimpleName());
                this.f3353a.m3670d();
            } else if (c0259g.m934f() == 40005) {
                this.f3353a.f3179y = null;
                C1323bs.m4579a("token", (String) null);
                this.f3353a.m3667c();
            } else if (this.f3353a.getActivity() != null) {
                new AlertDialogBuilderC1625m(this.f3353a.getActivity()).setTitle(this.f3353a.getResources().getString(R.string.toast_error)).setMessage(this.f3353a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0971c(this)).create().show();
                C1341p.m4651a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f3353a.getActivity() != null) {
                this.f3353a.f3168n.dismiss();
            }
        }
        int i = message.what;
        C0203b unused = this.f3353a.f3175u;
        if (i == 203) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR && this.f3353a.getActivity() != null) {
                Intent intent = new Intent();
                C1323bs.m4579a("authnum", this.f3353a.f3178x);
                if (this.f3353a.getActivity() != null) {
                    this.f3353a.getActivity().setResult(-1, intent);
                    this.f3353a.getActivity().finish();
                }
            } else if (c0259g.m934f() == 12007 || c0259g.m934f() == 12000) {
                C1341p.m4661d("verification code was wrong", getClass().getSimpleName());
                this.f3353a.f3160f.setText("");
                ActivityNonSelfSMS.NonSelfSMSFragment.m3660a((Activity) this.f3353a.getActivity(), false);
            } else if (c0259g.m934f() == 12008) {
                this.f3353a.f3160f.setText("");
                ActivityNonSelfSMS.NonSelfSMSFragment.m3666b((Activity) this.f3353a.getActivity(), false);
            } else if (this.f3353a.getActivity() != null) {
                if (this.f3353a.getActivity() != null) {
                    this.f3353a.f3168n.dismiss();
                }
                new AlertDialogBuilderC1625m(this.f3353a.getActivity()).setTitle(this.f3353a.getResources().getString(R.string.toast_error)).setMessage(this.f3353a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0928a(this)).create().show();
                C1341p.m4651a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
                this.f3353a.f3162h.setButtonEnabled(true);
            }
        }
        this.f3353a.f3161g.setEnabled(true);
        if (this.f3353a.getActivity() != null) {
            this.f3353a.f3168n.dismiss();
        }
    }
}
