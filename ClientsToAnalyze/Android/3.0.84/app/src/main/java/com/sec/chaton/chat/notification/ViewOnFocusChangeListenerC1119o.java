package com.sec.chaton.chat.notification;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.o */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1119o implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4529a;

    ViewOnFocusChangeListenerC1119o(ScreenNotification2 screenNotification2) {
        this.f4529a = screenNotification2;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (C3250y.f11735c) {
            C3250y.m11453c("edittext focus changed. value:" + z, ScreenNotification2.f4381d);
        }
        if (z) {
            if (this.f4529a.f4394M != null) {
                this.f4529a.f4394M.removeCallbacks(this.f4529a.f4393L);
                return;
            }
            return;
        }
        this.f4529a.m5415m();
    }
}
