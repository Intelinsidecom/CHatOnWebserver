package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BirthdayImpl.java */
/* renamed from: com.sec.chaton.userprofile.i */
/* loaded from: classes.dex */
class HandlerC3140i extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3137f f11396a;

    HandlerC3140i(C3137f c3137f) {
        this.f11396a = c3137f;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11396a.f11390s.isFinishing()) {
            C3250y.m11456e("is Finishing : " + this.f11396a.f11390s.isFinishing(), getClass().getSimpleName());
        }
        if (this.f11396a.f11388q.isShowing()) {
            this.f11396a.f11388q.dismiss();
        }
        switch (message.what) {
            case HttpResponseCode.UNAUTHORIZED /* 401 */:
                C0267d c0267d = (C0267d) message.obj;
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    Toast.makeText(this.f11396a.f11390s, R.string.toast_setting_profile_update_failed, 0).show();
                    break;
                } else if (this.f11396a.f11376e.length() != 0) {
                    this.f11396a.f11378g.setClickable(true);
                    this.f11396a.f11380i.setEnabled(true);
                    break;
                }
                break;
        }
    }
}
