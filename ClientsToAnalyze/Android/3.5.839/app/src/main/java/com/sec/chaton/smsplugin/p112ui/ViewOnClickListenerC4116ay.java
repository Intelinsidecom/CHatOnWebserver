package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.smsplugin.transaction.TransactionService;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC4116ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4108aq f15355a;

    /* renamed from: b */
    final /* synthetic */ MessageListItem f15356b;

    ViewOnClickListenerC4116ay(MessageListItem messageListItem, C4108aq c4108aq) {
        this.f15356b = messageListItem;
        this.f15355a = c4108aq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15356b.f14840r.setVisibility(8);
        Intent intent = new Intent(this.f15356b.mContext, (Class<?>) TransactionService.class);
        intent.putExtra("uri", this.f15355a.f15283r.toString());
        intent.putExtra("type", 1);
        this.f15356b.mContext.startService(intent);
    }
}
