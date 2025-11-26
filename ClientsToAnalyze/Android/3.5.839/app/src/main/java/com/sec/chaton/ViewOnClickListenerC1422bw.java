package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.specialbuddy.ChatONLiveMainActivity;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bw */
/* loaded from: classes.dex */
class ViewOnClickListenerC1422bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f5058a;

    ViewOnClickListenerC1422bw(PlusFragment plusFragment) {
        this.f5058a = plusFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5058a.startActivity(new Intent(this.f5058a.f1990q, (Class<?>) ChatONLiveMainActivity.class));
    }
}
