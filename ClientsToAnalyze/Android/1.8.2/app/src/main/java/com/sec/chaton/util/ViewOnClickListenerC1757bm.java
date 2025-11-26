package com.sec.chaton.util;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p022h.C0809s;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bm */
/* loaded from: classes.dex */
class ViewOnClickListenerC1757bm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6395a;

    ViewOnClickListenerC1757bm(ScreenOnNotification screenOnNotification) {
        this.f6395a = screenOnNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6395a.f6308r.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6395a.f6308r.setText("");
            return;
        }
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            this.f6395a.f6310t.cancel();
            this.f6395a.f6310t.setText(R.string.toast_network_unable);
            this.f6395a.f6310t.setDuration(0);
            this.f6395a.f6310t.show();
            return;
        }
        if (TextUtils.isEmpty(this.f6395a.f6303m) || "null".equals(this.f6395a.f6303m)) {
            this.f6395a.f6296c.m2941a(this.f6395a.f6299i, EnumC0699n.TEXT, EnumC0695j.m3145a(this.f6395a.f6300j), new String[]{this.f6395a.f6302l}, this.f6395a.f6308r.getText().toString());
        } else {
            this.f6395a.f6296c.m2938a(EnumC0699n.TEXT, EnumC0695j.m3145a(this.f6395a.f6300j), this.f6395a.f6303m, new String[]{this.f6395a.f6302l}, this.f6395a.f6308r.getText().toString());
        }
        C1788t.m6070a(GlobalApplication.m3260b()).m6073a(this.f6395a.f6293D);
        this.f6395a.m5845a();
        this.f6395a.f6309s.setVisibility(8);
        this.f6395a.f6311u.setVisibility(0);
        this.f6395a.f6291B = false;
    }
}
