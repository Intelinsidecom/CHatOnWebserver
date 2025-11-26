package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC0495f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3187a;

    ViewOnClickListenerC0495f(ActivitySkinChange activitySkinChange) {
        this.f3187a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3187a.f3064v.setBackgroundDrawable(this.f3187a.f3033Q);
        this.f3187a.f3066x = "skin_bg_02";
        this.f3187a.f3046d.setSelected(false);
        this.f3187a.f3047e.setSelected(false);
        this.f3187a.f3063u.setVisibility(8);
        this.f3187a.f3048f.setSelected(false);
        this.f3187a.f3049g.setSelected(true);
        this.f3187a.f3050h.setSelected(false);
        this.f3187a.f3051i.setSelected(false);
        this.f3187a.f3052j.setSelected(false);
        this.f3187a.f3053k.setSelected(false);
        this.f3187a.f3054l.setSelected(false);
        this.f3187a.f3055m.setSelected(false);
        this.f3187a.f3056n.setSelected(false);
    }
}
