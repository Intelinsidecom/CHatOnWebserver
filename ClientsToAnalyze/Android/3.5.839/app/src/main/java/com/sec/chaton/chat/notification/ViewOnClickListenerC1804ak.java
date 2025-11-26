package com.sec.chaton.chat.notification;

import android.view.View;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC1804ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6814a;

    ViewOnClickListenerC1804ak(ScreenNotification2 screenNotification2) {
        this.f6814a = screenNotification2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6814a.f6746S.setCurrentItem(this.f6814a.f6746S.m424c() - 1);
    }
}
