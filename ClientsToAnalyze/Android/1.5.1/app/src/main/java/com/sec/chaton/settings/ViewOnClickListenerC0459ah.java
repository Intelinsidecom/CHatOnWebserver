package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC0459ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3150a;

    ViewOnClickListenerC0459ah(ActivitySkinChange activitySkinChange) {
        this.f3150a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3150a.finish();
    }
}
