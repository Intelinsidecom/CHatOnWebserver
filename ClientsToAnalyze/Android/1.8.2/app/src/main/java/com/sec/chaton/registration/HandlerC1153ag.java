package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetSSMServerAddress3;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.ag */
/* loaded from: classes.dex */
class HandlerC1153ag extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f4355a;

    HandlerC1153ag(ActivityRegist.RegistFragment registFragment) {
        this.f4355a = registFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 103) {
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                GetSSMServerAddress3 getSSMServerAddress3 = (GetSSMServerAddress3) c0101b.m671d();
                try {
                    if (!TextUtils.isEmpty(getSSMServerAddress3.msisdn) && this.f4355a.getActivity() != null) {
                        C1786r.m6061b("msisnd =" + getSSMServerAddress3.msisdn, getClass().getSimpleName());
                        ActivityRegist.f4213a = getSSMServerAddress3.msisdn;
                        C1789u.m6079a("phonenumber", this.f4355a.f4245o.getText().toString());
                        C1789u.m6079a("msisdn", ActivityRegist.f4213a);
                        C1786r.m6061b("authType=" + this.f4355a.f4228N, getClass().getSimpleName());
                        if (this.f4355a.f4228N.equals("SMS")) {
                            this.f4355a.m4373a(this.f4355a.getActivity(), "SMS");
                        } else {
                            Intent intent = new Intent(this.f4355a.getActivity(), (Class<?>) ActivitySelectLanguage.class);
                            if (GlobalApplication.m3265f()) {
                                intent.setFlags(67108864);
                            }
                            this.f4355a.startActivityForResult(intent, 48);
                        }
                    }
                    if (!TextUtils.isEmpty(getSSMServerAddress3.selfsmspn)) {
                        C1786r.m6061b("selfsmspn =" + getSSMServerAddress3.selfsmspn, getClass().getSimpleName());
                        ActivityRegist.f4214b = getSSMServerAddress3.selfsmspn;
                    } else {
                        C1786r.m6061b("invalid phone number server return result empty", getClass().getSimpleName());
                    }
                } catch (Exception e) {
                    C1786r.m6056a(e, getClass().getSimpleName());
                }
            } else if (c0101b.m673f() == 44002 || c0101b.m673f() == 44001) {
                C1786r.m6065d("server sent error cause by WRONG_PARAMETER_VALUE", getClass().getSimpleName());
                if (this.f4355a.getActivity() != null) {
                    C2153y.m7535a(this.f4355a.getActivity(), R.string.registration_check_phone_number, 0).show();
                }
            } else if (this.f4355a.getActivity() != null) {
                TextView textView = new TextView(this.f4355a.getActivity());
                textView.setText(R.string.toast_network_unable);
                textView.setTextSize(18.0f);
                textView.setTextColor(this.f4355a.getResources().getColor(R.color.ics_main_font_color_2));
                textView.setPadding(0, 30, 8, 30);
                textView.setGravity(17);
                new AlertDialogBuilderC2120a(this.f4355a.getActivity()).setTitle(this.f4355a.getResources().getString(R.string.toast_error)).setView(textView).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1154ah(this)).show();
                C1786r.m6054a("[Dev]GLD failed. httpStatus: " + c0101b.m675h() + ", FaultCode: " + c0101b.m673f() + ", Message: " + c0101b.m674g(), getClass().getSimpleName());
            }
        }
        if (this.f4355a.f4228N == "SMS") {
            if (this.f4355a.f4249s != null) {
                this.f4355a.f4249s.setEnabled(true);
            }
            if (this.f4355a.f4250t != null) {
                this.f4355a.f4250t.setEnabled(true);
            }
        } else if (this.f4355a.f4251u != null) {
            this.f4355a.f4251u.setEnabled(true);
        }
        if (this.f4355a.getActivity() != null) {
            this.f4355a.f4256z.dismiss();
        }
    }
}
