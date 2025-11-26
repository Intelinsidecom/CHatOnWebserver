package com.sec.chaton.event;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.specialbuddy.ChatONLiveEventActivity;

/* compiled from: EventDialog.java */
/* renamed from: com.sec.chaton.event.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1461c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EventDialog f5438a;

    ViewOnClickListenerC1461c(EventDialog eventDialog) {
        this.f5438a = eventDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1464f.m6393b(this.f5438a.f5420c.isChecked());
        Intent intent = new Intent(this.f5438a.getApplicationContext(), (Class<?>) ChatONLiveEventActivity.class);
        intent.setFlags(67108864);
        this.f5438a.startActivity(intent);
        this.f5438a.finish();
    }
}
