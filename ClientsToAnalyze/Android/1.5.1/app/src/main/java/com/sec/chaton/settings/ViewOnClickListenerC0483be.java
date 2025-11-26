package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.settings.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC0483be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatView f3174a;

    ViewOnClickListenerC0483be(ActivityChatView activityChatView) {
        this.f3174a = activityChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatONPref.m3519a().edit().putString("Default Font Size", this.f3174a.f2981b).commit();
        this.f3174a.finish();
    }
}
