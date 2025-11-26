package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.settings.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC0460ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3151a;

    ViewOnClickListenerC0460ai(ActivitySkinChange activitySkinChange) {
        this.f3151a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatONPref.m3519a().edit().putString("setting_change_skin", this.f3151a.f3066x).commit();
        ChatONPref.m3519a().edit().putString("setting_change_bubble", this.f3151a.f3067y).commit();
        this.f3151a.finish();
    }
}
