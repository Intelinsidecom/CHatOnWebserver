package com.sec.chaton.chat.notification;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.af */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1799af implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6809a;

    ViewOnFocusChangeListenerC1799af(ScreenNotification2 screenNotification2) {
        this.f6809a = screenNotification2;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (C4904y.f17873c) {
            C4904y.m18641c("edittext focus changed. value:" + z, ScreenNotification2.f6727v);
        }
        if (z) {
            this.f6809a.f6736I = true;
            if (this.f6809a.f6768ao != null) {
                this.f6809a.f6768ao.removeCallbacks(this.f6809a.f6758ae);
                return;
            }
            return;
        }
        this.f6809a.m8869u();
    }
}
