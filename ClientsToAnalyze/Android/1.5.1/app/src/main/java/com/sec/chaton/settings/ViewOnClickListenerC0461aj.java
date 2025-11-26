package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.settings.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC0461aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkins f3152a;

    ViewOnClickListenerC0461aj(ActivitySkins activitySkins) {
        this.f3152a = activitySkins;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatONPref.m3519a().edit().putString("Skin Style", this.f3152a.f3073e).commit();
    }
}
