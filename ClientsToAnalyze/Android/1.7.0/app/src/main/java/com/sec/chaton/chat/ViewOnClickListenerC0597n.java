package com.sec.chaton.chat;

import android.view.View;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0597n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2039a;

    ViewOnClickListenerC0597n(ChatActivity chatActivity) {
        this.f2039a = chatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2039a.onBackPressed();
    }
}
