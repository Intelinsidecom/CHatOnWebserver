package com.sec.chaton.smsplugin.p112ui;

import android.os.Message;
import android.view.View;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC4117az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15357a;

    ViewOnClickListenerC4117az(MessageListItem messageListItem) {
        this.f15357a = messageListItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15357a.f14841s != null) {
            int i = 2;
            if ("mms".equals(this.f15357a.f14842t.f15267b)) {
                i = 1;
            }
            Message messageObtain = Message.obtain(this.f15357a.f14841s, i);
            messageObtain.obj = Long.valueOf(this.f15357a.f14842t.m16307j());
            messageObtain.sendToTarget();
        }
    }
}
