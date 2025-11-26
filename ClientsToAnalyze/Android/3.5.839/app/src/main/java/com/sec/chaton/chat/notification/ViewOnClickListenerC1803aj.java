package com.sec.chaton.chat.notification;

import android.view.View;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1803aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6813a;

    ViewOnClickListenerC1803aj(ScreenNotification2 screenNotification2) {
        this.f6813a = screenNotification2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6813a.f6746S.setCurrentItem(this.f6813a.f6746S.m424c() + 1);
    }
}
