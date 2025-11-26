package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.view.View;

/* compiled from: SearchActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hq */
/* loaded from: classes.dex */
class ViewOnClickListenerC4297hq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f15689a;

    /* renamed from: b */
    final /* synthetic */ long f15690b;

    /* renamed from: c */
    final /* synthetic */ C4296hp f15691c;

    ViewOnClickListenerC4297hq(C4296hp c4296hp, long j, long j2) {
        this.f15691c = c4296hp;
        this.f15689a = j;
        this.f15690b = j2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f15691c.f15688e.f15683c, (Class<?>) PluginComposeMessageActivity.class);
        intent.putExtra("thread_id", this.f15689a);
        intent.putExtra("highlight", this.f15691c.f15688e.f15681a);
        intent.putExtra("select_id", this.f15690b);
        this.f15691c.f15688e.f15683c.startActivity(intent);
    }
}
