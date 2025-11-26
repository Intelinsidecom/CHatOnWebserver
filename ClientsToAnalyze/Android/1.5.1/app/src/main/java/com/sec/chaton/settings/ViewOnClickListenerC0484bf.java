package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC0484bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChatView f3175a;

    ViewOnClickListenerC0484bf(ActivityChatView activityChatView) {
        this.f3175a = activityChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3175a.finish();
    }
}
