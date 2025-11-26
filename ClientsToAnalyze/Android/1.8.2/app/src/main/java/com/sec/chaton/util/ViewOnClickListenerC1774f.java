package com.sec.chaton.util;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p022h.C0809s;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC1774f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6433a;

    ViewOnClickListenerC1774f(BlackScreenNotification blackScreenNotification) {
        this.f6433a = blackScreenNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6433a.f6254t.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6433a.f6254t.setText("");
            return;
        }
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            this.f6433a.f6256v.cancel();
            this.f6433a.f6256v.setText(R.string.toast_network_unable);
            this.f6433a.f6256v.setDuration(0);
            this.f6433a.f6256v.show();
            return;
        }
        if (TextUtils.isEmpty(this.f6433a.f6249o) || "null".equals(this.f6433a.f6249o)) {
            this.f6433a.f6240c.m2941a(this.f6433a.f6243i, EnumC0699n.TEXT, EnumC0695j.m3145a(this.f6433a.f6244j), new String[]{this.f6433a.f6248n}, this.f6433a.f6254t.getText().toString());
        } else {
            this.f6433a.f6240c.m2938a(EnumC0699n.TEXT, EnumC0695j.m3145a(this.f6433a.f6244j), this.f6433a.f6249o, new String[]{this.f6433a.f6248n}, this.f6433a.f6254t.getText().toString());
        }
        C1788t.m6070a(GlobalApplication.m3260b()).m6073a(this.f6433a.f6236B);
        this.f6433a.m5815a();
        this.f6433a.f6255u.setVisibility(8);
        this.f6433a.f6257w.setVisibility(0);
        this.f6433a.f6238D = false;
    }
}
