package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.chat.e */
/* loaded from: classes.dex */
class HandlerC0143e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f954a;

    HandlerC0143e(ChatFragment chatFragment) {
        this.f954a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        HttpEntry httpEntry = (HttpEntry) message.obj;
        switch (message.what) {
            case TrunkMessageControl.METHOD_GET_TRUNK_LIST /* 900 */:
                if (httpEntry.m1951b() != HttpResultCode.SUCCESS) {
                    if (httpEntry.m1951b() == HttpResultCode.ERROR) {
                        ChatONLogWriter.m3508c("[TRUNK] Received METHOD_GET_TRUNK_LIST fail", this.f954a.getClass().getSimpleName());
                        break;
                    }
                } else {
                    ChatONLogWriter.m3508c("[TRUNK] Received METHOD_GET_TRUNK_LIST success", this.f954a.getClass().getSimpleName());
                    break;
                }
                break;
        }
    }
}
