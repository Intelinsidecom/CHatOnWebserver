package com.sec.chaton.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dt */
/* loaded from: classes.dex */
class ViewOnClickListenerC1051dt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4162a;

    ViewOnClickListenerC1051dt(ChatInfoFragment chatInfoFragment) {
        this.f4162a = chatInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4162a.f3740h, (Class<?>) ChatInfoMoreActivity.class);
        Bundle arguments = this.f4162a.getArguments();
        arguments.putBoolean("ACTIVITY_PURPOSE_ARG", false);
        intent.putExtras(arguments);
        this.f4162a.startActivity(intent);
    }
}
