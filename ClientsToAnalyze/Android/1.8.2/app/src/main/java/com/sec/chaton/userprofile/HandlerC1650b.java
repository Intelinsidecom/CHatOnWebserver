package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.b */
/* loaded from: classes.dex */
class HandlerC1650b extends Handler {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f6141a;

    HandlerC1650b(BirthdayActivity birthdayActivity) {
        this.f6141a = birthdayActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f6141a.isFinishing()) {
            if (this.f6141a.f5785p.isShowing()) {
                this.f6141a.f5785p.dismiss();
            }
            switch (message.what) {
                case HttpResponseCode.UNAUTHORIZED /* 401 */:
                    C0101b c0101b = (C0101b) message.obj;
                    if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                        C1786r.m6066e("is Finishing : " + this.f6141a.isFinishing(), getClass().getSimpleName());
                        C0107h c0107h = (C0107h) c0101b.m672e();
                        if (c0107h != null && c0107h.m686c() != null) {
                            if (this.f6141a.f5786q) {
                                this.f6141a.f5781l.setText(this.f6141a.f5787r);
                            } else {
                                this.f6141a.f5781l.setTextColor(Color.parseColor("#9A9A9A"));
                            }
                        }
                        this.f6141a.m5545e();
                        this.f6141a.finish();
                        break;
                    } else {
                        Toast.makeText(this.f6141a.f5775c, R.string.toast_setting_profile_update_failed, 0).show();
                        break;
                    }
                    break;
            }
        }
        C1786r.m6066e("is Finishing : " + this.f6141a.isFinishing(), getClass().getSimpleName());
    }
}
