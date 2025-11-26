package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.be */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC4123be implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15362a;

    ViewOnLongClickListenerC4123be(MessageListItem messageListItem) {
        this.f15362a = messageListItem;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return view.showContextMenu();
    }
}
