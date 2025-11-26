package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.c */
/* loaded from: classes.dex */
class HandlerC4768c extends Handler {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f17486a;

    HandlerC4768c(BirthdayFragment birthdayFragment) {
        this.f17486a = birthdayFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17486a.getActivity() != null && !this.f17486a.getActivity().isFinishing()) {
            if (this.f17486a.f17093r.isShowing()) {
                this.f17486a.f17093r.dismiss();
            }
            if (this.f17486a.f17094s.isShowing()) {
                this.f17486a.f17094s.dismiss();
            }
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 401:
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        if (this.f17486a.f17080e.length() != 0) {
                            this.f17486a.f17082g.setClickable(true);
                            this.f17486a.f17084i.setEnabled(true);
                            this.f17486a.f17100y.setTextColor(this.f17486a.getResources().getColor(R.color.color2));
                            this.f17486a.f17085j.setClickable(true);
                            if (this.f17486a.f17081f != null) {
                                this.f17486a.f17096u.setText(this.f17486a.f17081f);
                            }
                            this.f17486a.f17087l.setEnabled(true);
                        }
                    } else {
                        Toast.makeText(this.f17486a.getActivity(), R.string.toast_setting_profile_update_failed, 0).show();
                    }
                    if (this.f17486a.f17082g.isClickable()) {
                        this.f17486a.f17099x.setTextColor(this.f17486a.getActivity().getResources().getColor(R.color.color2));
                        break;
                    } else {
                        this.f17486a.f17099x.setTextColor(this.f17486a.getActivity().getResources().getColor(R.color.setting_explain_text));
                        break;
                    }
                    break;
                case 411:
                    if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("ProfileControl.METHOD_GET_PROFILE_ALL Success", getClass().getSimpleName());
                        }
                        this.f17486a.m17787f();
                        break;
                    } else {
                        Toast.makeText(this.f17486a.getActivity(), R.string.popup_no_network_connection, 0).show();
                        break;
                    }
                    break;
            }
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("is Finishing ", getClass().getSimpleName());
        }
    }
}
