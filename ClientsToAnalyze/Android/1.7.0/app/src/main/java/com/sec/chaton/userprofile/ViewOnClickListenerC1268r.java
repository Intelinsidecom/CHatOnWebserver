package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC1268r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f4365a;

    ViewOnClickListenerC1268r(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f4365a = profileRegistStatusMessage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1341p.m4655a(this.f4365a.f4183b.getText().toString())) {
            this.f4365a.f4183b.setText("");
            C1341p.m4648a(1);
            C1619g.m5889a(this.f4365a.f4182a, "Log On", 1).show();
        } else {
            C0260h c0260h = new C0260h();
            if (this.f4365a.f4183b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                c0260h.m941b("");
            } else {
                c0260h.m941b(this.f4365a.f4183b.getText().toString());
            }
            this.f4365a.f4184c.m873a(c0260h, "");
            this.f4365a.f4185d.show();
        }
    }
}
