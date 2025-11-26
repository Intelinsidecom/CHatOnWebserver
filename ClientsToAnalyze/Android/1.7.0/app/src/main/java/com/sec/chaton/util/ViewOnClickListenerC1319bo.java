package com.sec.chaton.util;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bo */
/* loaded from: classes.dex */
class ViewOnClickListenerC1319bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4538a;

    ViewOnClickListenerC1319bo(ScreenOnNotification screenOnNotification) {
        this.f4538a = screenOnNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4538a.f4455x.removeCallbacks(this.f4538a.f4456y);
        this.f4538a.f4457z = true;
        GlobalApplication.f2413g = true;
    }
}
