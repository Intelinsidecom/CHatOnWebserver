package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetSSMServerAddress3;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.y */
/* loaded from: classes.dex */
class HandlerC0993y extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f3389a;

    HandlerC0993y(ActivityRegist.RegistFragment registFragment) {
        this.f3389a = registFragment;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009a -> B:52:0x004d). Please report as a decompilation issue!!! */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 1105) {
            if ((c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) || c0259g.m934f() == 42001) {
                try {
                    C1323bs.m4579a("first_disclaimer_status", "RUN");
                    if (this.f3389a.f3201K.equals("SMS")) {
                        this.f3389a.m3688a(this.f3389a.getActivity(), "SMS");
                    } else {
                        this.f3389a.startActivityForResult(new Intent(this.f3389a.getActivity(), (Class<?>) ActivitySelectLanguage.class), 48);
                    }
                } catch (Exception e) {
                    C1341p.m4653a(e, getClass().getSimpleName());
                }
            } else if (this.f3389a.getActivity() != null) {
                new AlertDialogBuilderC1625m(this.f3389a.getActivity()).setTitle(this.f3389a.getResources().getString(R.string.toast_error)).setMessage(this.f3389a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0984p(this)).create().show();
                C1341p.m4651a("[Dev]Accept Disclaimer failed. httpStatus: " + c0259g.m936h() + ", FaultCode: " + c0259g.m934f() + ", Message: " + c0259g.m935g(), getClass().getSimpleName());
            }
        } else if (message.what == 103) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                GetSSMServerAddress3 getSSMServerAddress3 = (GetSSMServerAddress3) c0259g.m932d();
                try {
                    if (!TextUtils.isEmpty(getSSMServerAddress3.msisdn)) {
                        C1341p.m4658b("msisnd =" + getSSMServerAddress3.msisdn, getClass().getSimpleName());
                        ActivityRegist.f3189a = getSSMServerAddress3.msisdn;
                        C1323bs.m4579a("phonenumber", this.f3389a.f3220o.getText().toString());
                        C1323bs.m4579a("msisdn", ActivityRegist.f3189a);
                        C1341p.m4658b("authType=" + this.f3389a.f3201K, getClass().getSimpleName());
                        if (this.f3389a.f3201K.equals("SMS")) {
                            this.f3389a.m3688a(this.f3389a.getActivity(), "SMS");
                        } else {
                            this.f3389a.startActivityForResult(new Intent(this.f3389a.getActivity(), (Class<?>) ActivitySelectLanguage.class), 48);
                        }
                    }
                    if (!TextUtils.isEmpty(getSSMServerAddress3.selfsmspn)) {
                        C1341p.m4658b("selfsmspn =" + getSSMServerAddress3.selfsmspn, getClass().getSimpleName());
                        ActivityRegist.f3190b = getSSMServerAddress3.selfsmspn;
                    } else {
                        C1341p.m4658b("invalid phone number server return result empty", getClass().getSimpleName());
                    }
                } catch (Exception e2) {
                    C1341p.m4653a(e2, getClass().getSimpleName());
                }
            } else if (this.f3389a.getActivity() != null) {
                new AlertDialogBuilderC1625m(this.f3389a.getActivity()).setTitle(this.f3389a.getResources().getString(R.string.toast_error)).setMessage(this.f3389a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0983o(this)).create().show();
                C1341p.m4651a("[Dev]GLD failed. httpStatus: " + c0259g.m936h() + ", FaultCode: " + c0259g.m934f() + ", Message: " + c0259g.m935g(), getClass().getSimpleName());
            }
        }
        if (this.f3389a.f3201K == "SMS") {
            this.f3389a.f3224s.setEnabled(true);
            this.f3389a.f3225t.setEnabled(true);
            this.f3389a.f3202L.setButtonEnabled(true);
        } else {
            this.f3389a.f3226u.setEnabled(true);
        }
        if (this.f3389a.getActivity() != null) {
            this.f3389a.f3230y.dismiss();
        }
    }
}
