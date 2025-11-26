package com.sec.chaton.registration;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C1786r;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC1150ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f4352a;

    ViewOnClickListenerC1150ad(ActivityRegist.RegistFragment registFragment) {
        this.f4352a = registFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = view.getTag() == null ? 0 : Integer.parseInt((String) view.getTag());
        C1786r.m6061b("Click Title " + i, getClass().getSimpleName());
        if (i == 9) {
            view.setTag(null);
            if (C1786r.m6058a(this.f4352a.f4245o.getText().toString())) {
                this.f4352a.f4245o.setText("");
                if (this.f4352a.f4254x != null) {
                    this.f4352a.f4254x.setVisibility(0);
                }
                if (this.f4352a.f4255y != null) {
                    this.f4352a.f4255y.setVisibility(0);
                }
                C1786r.m6051a(1);
                Toast.makeText(this.f4352a.f4215A, "Log On", 1).show();
                return;
            }
            if (this.f4352a.f4255y != null && this.f4352a.f4255y.getVisibility() == 0) {
                if (this.f4352a.f4254x != null) {
                    this.f4352a.f4254x.setVisibility(8);
                }
                if (this.f4352a.f4255y != null) {
                    this.f4352a.f4255y.setVisibility(8);
                }
                C1786r.m6051a(0);
                return;
            }
            return;
        }
        view.setTag(Integer.toString(i + 1));
    }
}
