package com.sec.chaton.smsplugin.spam;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.R;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC4002bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4017bu f14447a;

    /* renamed from: b */
    final /* synthetic */ C4000bd f14448b;

    ViewOnClickListenerC4002bf(C4000bd c4000bd, C4017bu c4017bu) {
        this.f14448b = c4000bd;
        this.f14447a = c4017bu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14448b.f14441a.f14370u == 0) {
            this.f14447a.m15456a(!this.f14447a.m15457b());
            ((CheckBox) this.f14448b.f14441a.f14373x.getChildAt(this.f14448b.f14441a.f14344A).findViewById(R.id.autoreject_item_checkbox)).setChecked(this.f14447a.m15457b());
            if (this.f14447a.m15454a() == -1) {
                this.f14448b.f14441a.f14350G.m18125b("pref_key_spam_option_unknown_num", Boolean.valueOf(this.f14447a.m15457b()));
            } else {
                this.f14448b.f14441a.m15368a(this.f14447a.m15458c(), this.f14447a.m15457b(), this.f14447a.m15454a());
            }
        }
    }
}
