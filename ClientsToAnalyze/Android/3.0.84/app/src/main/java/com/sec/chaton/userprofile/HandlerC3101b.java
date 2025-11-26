package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.b */
/* loaded from: classes.dex */
class HandlerC3101b extends Handler {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f11314a;

    HandlerC3101b(BirthdayFragment birthdayFragment) {
        this.f11314a = birthdayFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f11314a.getActivity().isFinishing()) {
            if (this.f11314a.f11037m.isShowing()) {
                this.f11314a.f11037m.dismiss();
            }
            switch (message.what) {
                case HttpResponseCode.UNAUTHORIZED /* 401 */:
                    C0267d c0267d = (C0267d) message.obj;
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        if (this.f11314a.f11029e.length() != 0) {
                            this.f11314a.f11031g.setClickable(true);
                            this.f11314a.f11033i.setEnabled(true);
                            break;
                        }
                    } else {
                        Toast.makeText(this.f11314a.getActivity(), R.string.toast_setting_profile_update_failed, 0).show();
                        break;
                    }
                    break;
            }
        }
        C3250y.m11456e("is Finishing : " + this.f11314a.getActivity().isFinishing(), getClass().getSimpleName());
    }
}
