package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC0523x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3303a;

    ViewOnClickListenerC0523x(ActivitySkinChange activitySkinChange) {
        this.f3303a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3303a.f3064v.setBackgroundDrawable(this.f3303a.f3037U);
        this.f3303a.f3066x = "skin_bg_06";
        this.f3303a.f3046d.setSelected(false);
        this.f3303a.f3047e.setSelected(false);
        this.f3303a.f3063u.setVisibility(8);
        this.f3303a.f3048f.setSelected(false);
        this.f3303a.f3049g.setSelected(false);
        this.f3303a.f3050h.setSelected(false);
        this.f3303a.f3051i.setSelected(false);
        this.f3303a.f3052j.setSelected(false);
        this.f3303a.f3053k.setSelected(true);
        this.f3303a.f3054l.setSelected(false);
        this.f3303a.f3055m.setSelected(false);
        this.f3303a.f3056n.setSelected(false);
    }
}
