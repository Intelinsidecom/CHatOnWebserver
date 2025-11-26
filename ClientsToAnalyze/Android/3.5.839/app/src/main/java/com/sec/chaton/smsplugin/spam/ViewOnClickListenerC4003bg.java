package com.sec.chaton.smsplugin.spam;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.R;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC4003bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4017bu f14449a;

    /* renamed from: b */
    final /* synthetic */ C4000bd f14450b;

    ViewOnClickListenerC4003bg(C4000bd c4000bd, C4017bu c4017bu) {
        this.f14450b = c4000bd;
        this.f14449a = c4017bu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14450b.f14441a.f14370u == 0) {
            this.f14450b.f14441a.m15378c("id = " + this.f14449a.m15454a() + " number = " + this.f14449a.m15458c());
            this.f14450b.f14441a.m15378c("View id : " + String.format("%08X", Integer.valueOf(view.getId())));
            this.f14449a.m15456a(this.f14449a.m15457b() ? false : true);
            ((CheckBox) view.findViewById(R.id.autoreject_item_checkbox)).setChecked(this.f14449a.m15457b());
            if (this.f14449a.m15454a() == -1) {
                this.f14450b.f14441a.f14350G.m18125b("pref_key_spam_option_unknown_num", Boolean.valueOf(this.f14449a.m15457b()));
            } else {
                this.f14450b.f14441a.m15368a(this.f14449a.m15458c(), this.f14449a.m15457b(), this.f14449a.m15454a());
            }
        }
    }
}
