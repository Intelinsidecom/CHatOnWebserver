package com.sec.chaton.smsplugin.p112ui;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.provider.C3945c;
import java.util.ArrayList;

/* compiled from: MessagingInfoActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cn */
/* loaded from: classes.dex */
class HandlerC4159cn extends Handler {

    /* renamed from: a */
    final /* synthetic */ MessagingInfoActivity f15463a;

    HandlerC4159cn(MessagingInfoActivity messagingInfoActivity) {
        this.f15463a = messagingInfoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        C3945c c3945c = (C3945c) message.obj;
        Object obj = c3945c.f14222g;
        switch (i) {
            case 1805:
                ArrayList arrayList = (ArrayList) obj;
                PluginComposeMessageActivity.m15963a(new DialogInterfaceOnClickListenerC4254ga(arrayList, this.f15463a, this), arrayList, ((Boolean) c3945c.f14223h).booleanValue(), this.f15463a);
                break;
            case 1806:
                C3896s.m15044b("DELETE_CONVERSATION_TOKEN in message info", "MessagingInfoActivity");
                this.f15463a.setResult(1806);
                this.f15463a.finish();
                break;
        }
    }
}
