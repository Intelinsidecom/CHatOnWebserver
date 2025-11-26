package com.sec.chaton.facebook;

import android.app.Activity;
import android.view.View;

/* compiled from: FacebookMenuActivity.java */
/* renamed from: com.sec.chaton.facebook.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC0739t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookMenuActivity f2736a;

    ViewOnClickListenerC0739t(FacebookMenuActivity facebookMenuActivity) {
        this.f2736a = facebookMenuActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getContext() instanceof Activity) {
            ((Activity) view.getContext()).finish();
        }
    }
}
