package com.sec.chaton.smsplugin.p112ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ba */
/* loaded from: classes.dex */
class HandlerC4119ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15358a;

    HandlerC4119ba(MessageListItem messageListItem) {
        this.f15358a = messageListItem;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.f15358a.f14821a.performLongClick();
                this.f15358a.f14810L = "";
                break;
        }
    }
}
