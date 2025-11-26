package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0989u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f3385a;

    ViewOnClickListenerC0989u(ActivityRegist.RegistFragment registFragment) {
        this.f3385a = registFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = view.getTag() == null ? 0 : Integer.parseInt((String) view.getTag());
        C1341p.m4658b("Click Title " + i, getClass().getSimpleName());
        if (i == 9) {
            view.setTag(null);
            if (C1341p.m4655a(this.f3385a.f3220o.getText().toString())) {
                this.f3385a.f3220o.setText("");
                if (this.f3385a.f3229x != null) {
                    this.f3385a.f3229x.setVisibility(0);
                }
                C1341p.m4648a(1);
                C1619g.m5889a(this.f3385a.f3231z, "Log On", 1).show();
                return;
            }
            if (this.f3385a.f3229x != null && this.f3385a.f3229x.getVisibility() == 0) {
                if (this.f3385a.f3229x != null) {
                    this.f3385a.f3229x.setVisibility(8);
                }
                C1341p.m4648a(0);
                return;
            }
            return;
        }
        view.setTag(Integer.toString(i + 1));
    }
}
