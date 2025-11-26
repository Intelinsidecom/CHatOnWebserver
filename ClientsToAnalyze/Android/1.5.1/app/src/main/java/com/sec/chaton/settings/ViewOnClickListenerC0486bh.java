package com.sec.chaton.settings;

import android.view.View;

/* renamed from: com.sec.chaton.settings.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC0486bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityAbout f3177a;

    ViewOnClickListenerC0486bh(ActivityAbout activityAbout) {
        this.f3177a = activityAbout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3177a.showDialog(1);
    }
}
