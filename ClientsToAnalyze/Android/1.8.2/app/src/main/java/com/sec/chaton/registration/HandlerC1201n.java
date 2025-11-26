package com.sec.chaton.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0621ak;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetSMSAuthToken;
import com.sec.chaton.registration.ActivityNonSelfSMS;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.n */
/* loaded from: classes.dex */
class HandlerC1201n extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f4417a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1201n(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment, Looper looper) {
        super(looper);
        this.f4417a = nonSelfSMSFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 1301) {
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                this.f4417a.f4181a = (GetSMSAuthToken) c0101b.m671d();
                if (this.f4417a.f4181a != null) {
                    C1786r.m6061b("mToken=" + this.f4417a.f4181a.token, getClass().getSimpleName());
                    this.f4417a.f4173A = this.f4417a.f4181a.token;
                    C1789u.m6079a("token", this.f4417a.f4181a.token);
                    C1789u.m6075a().edit().remove("SMSSaveCountInterval").commit();
                    this.f4417a.m4354g();
                } else if (this.f4417a.getActivity() != null) {
                    new AlertDialogBuilderC2120a(this.f4417a.getActivity()).setTitle(this.f4417a.getResources().getString(R.string.toast_error)).setMessage(this.f4417a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1202o(this)).show();
                }
                if (this.f4417a.getActivity() != null && this.f4417a.f4196q != null) {
                    this.f4417a.f4196q.dismiss();
                }
            } else if (c0101b.m673f() == 30002) {
                C1786r.m6065d("server sent error cause by GET_SMS_AUTHTOKEN_GENERATED_RIGHT_BEFORE", getClass().getSimpleName());
                ActivityNonSelfSMS.NonSelfSMSFragment.m4334a(this.f4417a.getActivity());
                this.f4417a.m4368a("SMS");
                if (this.f4417a.getActivity() != null && this.f4417a.f4196q != null) {
                    this.f4417a.f4196q.dismiss();
                }
            } else if (this.f4417a.getActivity() != null) {
                new AlertDialogBuilderC2120a(this.f4417a.getActivity()).setTitle(this.f4417a.getResources().getString(R.string.toast_error)).setMessage(this.f4417a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1203p(this)).show();
                C1786r.m6054a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f4417a.getActivity() != null && this.f4417a.f4196q != null) {
                this.f4417a.f4196q.dismiss();
            }
        }
        if (message.what == 1302) {
            if (!C1789u.m6075a().getBoolean("was_get_version", false)) {
                new C0629as(this.f4417a.f4187g).m2834c();
                C1789u.m6076a("was_get_version", (Boolean) true);
            }
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                if (this.f4417a.getActivity() != null && this.f4417a.f4196q != null) {
                    this.f4417a.f4196q.dismiss();
                }
                this.f4417a.f4176D = true;
                this.f4417a.m4368a("SMS");
                C1789u.m6076a("over_sms_request", (Boolean) false);
            } else if (c0101b.m673f() == 40003) {
                C1786r.m6065d("server sent error cause by SEND_SMS_REQUEST_LIMIT", getClass().getSimpleName());
                this.f4417a.m4368a("SMS");
            } else if (c0101b.m673f() == 40005) {
                this.f4417a.f4176D = true;
                this.f4417a.m4349e();
                C1789u.m6076a("over_sms_request", (Boolean) true);
            } else if (this.f4417a.getActivity() != null) {
                new AlertDialogBuilderC2120a(this.f4417a.getActivity()).setTitle(this.f4417a.getResources().getString(R.string.toast_error)).setMessage(this.f4417a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1204q(this)).show();
                C1786r.m6054a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
            if (this.f4417a.getActivity() != null && this.f4417a.f4196q != null) {
                this.f4417a.f4196q.dismiss();
            }
        }
        int i = message.what;
        C0621ak unused = this.f4417a.f4202w;
        if (i == 203) {
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                Intent intent = new Intent();
                C1789u.m6079a("authnum", this.f4417a.f4205z);
                if (this.f4417a.getActivity() != null) {
                    this.f4417a.getActivity().setResult(-1, intent);
                    this.f4417a.getActivity().finish();
                }
            } else if (c0101b.m673f() == 12007 || c0101b.m673f() == 12000) {
                C1786r.m6065d("verification code was wrong", getClass().getSimpleName());
                this.f4417a.f4188h.setText("");
                ActivityNonSelfSMS.NonSelfSMSFragment.m4335a((Activity) this.f4417a.getActivity(), false);
            } else if (c0101b.m673f() == 12008) {
                this.f4417a.f4188h.setText("");
                ActivityNonSelfSMS.NonSelfSMSFragment.m4343b((Activity) this.f4417a.getActivity(), false);
            } else if (this.f4417a.getActivity() != null) {
                if (this.f4417a.f4196q != null) {
                    this.f4417a.f4196q.dismiss();
                }
                new AlertDialogBuilderC2120a(this.f4417a.getActivity()).setTitle(this.f4417a.getResources().getString(R.string.toast_error)).setMessage(this.f4417a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1205r(this)).show();
                C1786r.m6054a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
            }
        }
        if (this.f4417a.getActivity() != null) {
            this.f4417a.f4196q.dismiss();
        }
    }
}
