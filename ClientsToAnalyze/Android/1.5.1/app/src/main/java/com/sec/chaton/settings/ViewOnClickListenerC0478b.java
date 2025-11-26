package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0478b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3169a;

    ViewOnClickListenerC0478b(ActivitySkinChange activitySkinChange) {
        this.f3169a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3169a.f3064v.setBackgroundDrawable(this.f3169a.f3035S);
        this.f3169a.f3066x = "skin_bg_04";
        this.f3169a.f3046d.setSelected(false);
        this.f3169a.f3047e.setSelected(false);
        this.f3169a.f3063u.setVisibility(8);
        this.f3169a.f3048f.setSelected(false);
        this.f3169a.f3049g.setSelected(false);
        this.f3169a.f3050h.setSelected(false);
        this.f3169a.f3051i.setSelected(true);
        this.f3169a.f3052j.setSelected(false);
        this.f3169a.f3053k.setSelected(false);
        this.f3169a.f3054l.setSelected(false);
        this.f3169a.f3055m.setSelected(false);
        this.f3169a.f3056n.setSelected(false);
    }
}
