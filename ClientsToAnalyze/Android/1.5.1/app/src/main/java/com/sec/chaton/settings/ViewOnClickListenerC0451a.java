package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC0451a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3142a;

    ViewOnClickListenerC0451a(ActivitySkinChange activitySkinChange) {
        this.f3142a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3142a.f3064v.setBackgroundDrawable(this.f3142a.f3036T);
        this.f3142a.f3066x = "skin_bg_05";
        this.f3142a.f3046d.setSelected(false);
        this.f3142a.f3047e.setSelected(false);
        this.f3142a.f3063u.setVisibility(8);
        this.f3142a.f3048f.setSelected(false);
        this.f3142a.f3049g.setSelected(false);
        this.f3142a.f3050h.setSelected(false);
        this.f3142a.f3051i.setSelected(false);
        this.f3142a.f3052j.setSelected(true);
        this.f3142a.f3053k.setSelected(false);
        this.f3142a.f3054l.setSelected(false);
        this.f3142a.f3055m.setSelected(false);
        this.f3142a.f3056n.setSelected(false);
    }
}
