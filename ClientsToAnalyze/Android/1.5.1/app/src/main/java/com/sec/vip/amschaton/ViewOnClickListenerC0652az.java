package com.sec.vip.amschaton;

import android.view.View;
import android.widget.CheckBox;

/* renamed from: com.sec.vip.amschaton.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC0652az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0648av f4266a;

    ViewOnClickListenerC0652az(C0648av c0648av) {
        this.f4266a = c0648av;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) view;
            int id = checkBox.getId();
            if (this.f4266a.f4260c[id]) {
                checkBox.setChecked(false);
                this.f4266a.f4260c[id] = false;
            } else {
                checkBox.setChecked(true);
                this.f4266a.f4260c[id] = true;
            }
            this.f4266a.m4224d();
        }
    }
}
