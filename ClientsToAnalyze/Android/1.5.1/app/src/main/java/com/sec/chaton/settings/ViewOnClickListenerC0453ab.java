package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC0453ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3144a;

    ViewOnClickListenerC0453ab(ActivitySkinChange activitySkinChange) {
        this.f3144a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3144a.f3064v.setBackgroundDrawable(this.f3144a.f3039W);
        this.f3144a.f3066x = "skin_bg_08";
        this.f3144a.f3046d.setSelected(false);
        this.f3144a.f3047e.setSelected(false);
        this.f3144a.f3063u.setVisibility(8);
        this.f3144a.f3048f.setSelected(false);
        this.f3144a.f3049g.setSelected(false);
        this.f3144a.f3050h.setSelected(false);
        this.f3144a.f3051i.setSelected(false);
        this.f3144a.f3052j.setSelected(false);
        this.f3144a.f3053k.setSelected(false);
        this.f3144a.f3054l.setSelected(false);
        this.f3144a.f3055m.setSelected(true);
        this.f3144a.f3056n.setSelected(false);
    }
}
