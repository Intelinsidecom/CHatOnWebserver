package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.l */
/* loaded from: classes.dex */
class HandlerC1262l extends Handler {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f4359a;

    HandlerC1262l(BirthdayActivity birthdayActivity) {
        this.f4359a = birthdayActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f4359a.isFinishing()) {
            if (this.f4359a.f4092m.isShowing()) {
                this.f4359a.f4092m.dismiss();
            }
            switch (message.what) {
                case 401:
                    C0259g c0259g = (C0259g) message.obj;
                    if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                        C1341p.m4662e("is Finishing : " + this.f4359a.isFinishing(), getClass().getSimpleName());
                        if (((C0260h) c0259g.m933e()).m942c() != null) {
                            if (this.f4359a.f4093n) {
                                this.f4359a.f4088i.setText(this.f4359a.f4094o);
                            } else {
                                this.f4359a.f4088i.setTextColor(Color.parseColor("#9A9A9A"));
                            }
                        }
                        this.f4359a.m4272e();
                        this.f4359a.finish();
                        break;
                    } else {
                        C1619g.m5888a(this.f4359a.f4083c, R.string.toast_setting_profile_update_failed, 0).show();
                        break;
                    }
            }
        }
        C1341p.m4662e("is Finishing : " + this.f4359a.isFinishing(), getClass().getSimpleName());
    }
}
