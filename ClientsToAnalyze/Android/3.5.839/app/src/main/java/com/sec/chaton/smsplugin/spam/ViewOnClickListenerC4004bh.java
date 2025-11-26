package com.sec.chaton.smsplugin.spam;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC4004bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4017bu f14451a;

    /* renamed from: b */
    final /* synthetic */ C4000bd f14452b;

    ViewOnClickListenerC4004bh(C4000bd c4000bd, C4017bu c4017bu) {
        this.f14452b = c4000bd;
        this.f14451a = c4017bu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 0;
        if (this.f14451a.m15454a() != -1) {
            while (true) {
                i = i2;
                if (i >= this.f14452b.f14441a.f14366p.size() || (((C4017bu) this.f14452b.f14441a.f14366p.get(i)).m15458c().equals(this.f14451a.m15458c()) && ((C4017bu) this.f14452b.f14441a.f14366p.get(i)).m15459d() == this.f14451a.m15459d())) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            this.f14452b.f14441a.f14371v = i;
            return;
        }
        if (C3847e.m14672ad()) {
            this.f14451a.m15456a(this.f14451a.m15457b() ? false : true);
            ((CheckBox) this.f14452b.f14441a.f14373x.getChildAt(this.f14452b.f14441a.f14344A).findViewById(R.id.autoreject_item_checkbox)).setChecked(this.f14451a.m15457b());
            this.f14452b.f14441a.f14350G.m18125b("pref_key_spam_option_unknown_num", Boolean.valueOf(this.f14451a.m15457b()));
        }
    }
}
