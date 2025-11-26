package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC0496g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3188a;

    ViewOnClickListenerC0496g(ActivitySkinChange activitySkinChange) {
        this.f3188a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3188a.f3064v.setBackgroundDrawable(this.f3188a.f3034R);
        this.f3188a.f3066x = "skin_bg_03";
        this.f3188a.f3046d.setSelected(false);
        this.f3188a.f3047e.setSelected(false);
        this.f3188a.f3063u.setVisibility(8);
        this.f3188a.f3048f.setSelected(false);
        this.f3188a.f3049g.setSelected(false);
        this.f3188a.f3050h.setSelected(true);
        this.f3188a.f3051i.setSelected(false);
        this.f3188a.f3052j.setSelected(false);
        this.f3188a.f3053k.setSelected(false);
        this.f3188a.f3054l.setSelected(false);
        this.f3188a.f3055m.setSelected(false);
        this.f3188a.f3056n.setSelected(false);
    }
}
