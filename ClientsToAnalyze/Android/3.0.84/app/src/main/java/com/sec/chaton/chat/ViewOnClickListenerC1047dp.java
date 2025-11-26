package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dp */
/* loaded from: classes.dex */
class ViewOnClickListenerC1047dp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4158a;

    ViewOnClickListenerC1047dp(ChatInfoFragment chatInfoFragment) {
        this.f4158a = chatInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialogC1082ex(this.f4158a.f3741i, this.f4158a.f3740h, this.f4158a.f3738f, this.f4158a.f3742j, this.f4158a.f3725M).show();
    }
}
