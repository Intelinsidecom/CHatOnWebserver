package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0498i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3190a;

    ViewOnClickListenerC0498i(ActivitySkinChange activitySkinChange) {
        this.f3190a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3190a.f3064v.setBackgroundResource(C0062R.drawable.skin_preview_bg);
        this.f3190a.f3066x = "pad_chat_bg_01";
        this.f3190a.f3046d.setSelected(false);
        this.f3190a.f3047e.setSelected(false);
        this.f3190a.f3063u.setVisibility(8);
        this.f3190a.f3048f.setSelected(true);
        this.f3190a.f3049g.setSelected(false);
        this.f3190a.f3050h.setSelected(false);
        this.f3190a.f3051i.setSelected(false);
        this.f3190a.f3052j.setSelected(false);
        this.f3190a.f3053k.setSelected(false);
        this.f3190a.f3054l.setSelected(false);
        this.f3190a.f3055m.setSelected(false);
        this.f3190a.f3056n.setSelected(false);
    }
}
