package com.sec.chaton.chat;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.TrunkActivity;

/* renamed from: com.sec.chaton.chat.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0148j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f959a;

    ViewOnClickListenerC0148j(ChatFragment chatFragment) {
        this.f959a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(GlobalApplication.m2386d(), TrunkActivity.class);
        intent.putExtra("sessionId", this.f959a.f827x);
        intent.putExtra("inboxNO", this.f959a.f822s);
        this.f959a.startActivity(intent);
    }
}
