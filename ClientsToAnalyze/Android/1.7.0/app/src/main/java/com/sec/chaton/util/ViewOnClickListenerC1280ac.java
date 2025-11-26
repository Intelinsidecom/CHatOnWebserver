package com.sec.chaton.util;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC1280ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4461a;

    ViewOnClickListenerC1280ac(BlackScreenNotification blackScreenNotification) {
        this.f4461a = blackScreenNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4461a.f4395r.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4461a.f4395r.setText("");
            return;
        }
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            this.f4461a.f4397t.setText(R.string.toast_network_unable);
            this.f4461a.f4397t.setDuration(0);
            this.f4461a.f4397t.show();
        } else {
            if (!C1327bw.m4597c()) {
                this.f4461a.f4397t.setText(R.string.popup_not_enough_memory);
                this.f4461a.f4397t.setDuration(0);
                this.f4461a.f4397t.show();
                return;
            }
            if (TextUtils.isEmpty(this.f4461a.f4390m) || "null".equals(this.f4461a.f4390m)) {
                this.f4461a.f4381c.m839a(this.f4461a.f4384f, EnumC0651d.TEXT, EnumC0665r.m3011a(this.f4461a.f4385g), new String[]{this.f4461a.f4389l}, this.f4461a.f4395r.getText().toString());
            } else {
                this.f4461a.f4381c.m832a(EnumC0651d.TEXT, EnumC0665r.m3011a(this.f4461a.f4385g), this.f4461a.f4390m, new String[]{this.f4461a.f4389l}, this.f4461a.f4395r.getText().toString());
            }
            C1332g.m4605a(GlobalApplication.m3100a()).m4610a(this.f4461a.f4392o);
            this.f4461a.m4434a();
            this.f4461a.f4396s.setVisibility(8);
            this.f4461a.f4398u.setVisibility(0);
        }
    }
}
