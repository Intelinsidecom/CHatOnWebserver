package com.sec.chaton.util;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC1320bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4539a;

    ViewOnClickListenerC1320bp(ScreenOnNotification screenOnNotification) {
        this.f4539a = screenOnNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4539a.f4447p.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4539a.f4447p.setText("");
            return;
        }
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            this.f4539a.f4449r.setText(R.string.popup_no_network_connection);
            this.f4539a.f4449r.setDuration(0);
            this.f4539a.f4449r.show();
        } else {
            if (!C1327bw.m4597c()) {
                this.f4539a.f4449r.setText(R.string.popup_not_enough_memory);
                this.f4539a.f4449r.setDuration(0);
                this.f4539a.f4449r.show();
                return;
            }
            if (TextUtils.isEmpty(this.f4539a.f4442k) || "null".equals(this.f4539a.f4442k)) {
                this.f4539a.f4435c.m839a(this.f4539a.f4438f, EnumC0651d.TEXT, EnumC0665r.m3011a(this.f4539a.f4439g), new String[]{this.f4539a.f4441j}, this.f4539a.f4447p.getText().toString());
            } else {
                this.f4539a.f4435c.m832a(EnumC0651d.TEXT, EnumC0665r.m3011a(this.f4539a.f4439g), this.f4539a.f4442k, new String[]{this.f4539a.f4441j}, this.f4539a.f4447p.getText().toString());
            }
            C1332g.m4605a(GlobalApplication.m3100a()).m4610a(this.f4539a.f4444m);
            this.f4539a.m4464a();
            this.f4539a.f4448q.setVisibility(8);
            this.f4539a.f4450s.setVisibility(0);
        }
    }
}
