package com.sec.chaton.util;

import android.view.View;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC1756bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6394a;

    ViewOnClickListenerC1756bl(ScreenOnNotification screenOnNotification) {
        this.f6394a = screenOnNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6394a.f6316z.removeCallbacks(this.f6394a.f6290A);
        this.f6394a.f6291B = true;
    }
}
