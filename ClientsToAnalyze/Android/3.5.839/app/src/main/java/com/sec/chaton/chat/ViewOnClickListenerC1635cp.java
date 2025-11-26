package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cp */
/* loaded from: classes.dex */
class ViewOnClickListenerC1635cp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC1664dr f6162a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6163b;

    ViewOnClickListenerC1635cp(ChatFragment chatFragment, DialogInterfaceOnClickListenerC1664dr dialogInterfaceOnClickListenerC1664dr) {
        this.f6163b = chatFragment;
        this.f6162a = dialogInterfaceOnClickListenerC1664dr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6162a.m8499a(((CheckBox) view).isChecked());
    }
}
