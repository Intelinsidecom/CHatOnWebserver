package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC0452aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3143a;

    ViewOnClickListenerC0452aa(ActivitySkinChange activitySkinChange) {
        this.f3143a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3143a.f3064v.setBackgroundDrawable(this.f3143a.f3038V);
        this.f3143a.f3066x = "skin_bg_07";
        this.f3143a.f3046d.setSelected(false);
        this.f3143a.f3047e.setSelected(false);
        this.f3143a.f3063u.setVisibility(8);
        this.f3143a.f3048f.setSelected(false);
        this.f3143a.f3049g.setSelected(false);
        this.f3143a.f3050h.setSelected(false);
        this.f3143a.f3051i.setSelected(false);
        this.f3143a.f3052j.setSelected(false);
        this.f3143a.f3053k.setSelected(false);
        this.f3143a.f3054l.setSelected(true);
        this.f3143a.f3055m.setSelected(false);
        this.f3143a.f3056n.setSelected(false);
    }
}
