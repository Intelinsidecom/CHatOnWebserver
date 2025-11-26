package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import com.sec.chaton.smsplugin.p110g.C3855a;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bc */
/* loaded from: classes.dex */
class ViewOnClickListenerC4121bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15360a;

    ViewOnClickListenerC4121bc(MessageListItem messageListItem) {
        this.f15360a = messageListItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4149cd.m16408a(this.f15360a.getContext(), (C3855a) view.getTag());
    }
}
