package com.sec.chaton.multimedia.vcalendar;

import android.view.View;

/* renamed from: com.sec.chaton.multimedia.vcalendar.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0311c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VcalendarDetailActivity f2262a;

    ViewOnClickListenerC0311c(VcalendarDetailActivity vcalendarDetailActivity) {
        this.f2262a = vcalendarDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2262a.finish();
    }
}
