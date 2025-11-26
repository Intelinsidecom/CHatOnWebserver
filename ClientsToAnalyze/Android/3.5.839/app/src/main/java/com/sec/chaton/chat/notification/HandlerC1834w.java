package com.sec.chaton.chat.notification;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.EnumC1774ht;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p065io.entry.PushEntry;
import com.sec.chaton.util.C4904y;
import java.io.IOException;

/* compiled from: PushReceiverManager.java */
/* renamed from: com.sec.chaton.chat.notification.w */
/* loaded from: classes.dex */
class HandlerC1834w extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1833v f6956a;

    HandlerC1834w(C1833v c1833v) {
        this.f6956a = c1833v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        switch (message.what) {
            case 0:
                if (C2349a.m10301a("chat_batch_push_feature")) {
                    this.f6956a.f6955b.removeMessages(0);
                }
                PushEntry pushEntry = (PushEntry) message.obj;
                Bundle data = message.getData();
                String string = data.getString("buddyName");
                int i = data.getInt("unreadCount");
                long j = data.getLong("lastMergedTime");
                String string2 = data.getString("inboxNo");
                boolean z = data.getBoolean("isEnableNoti");
                EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(data.getInt("msgContentType"));
                if (EnumC2300t.m10207a(pushEntry.chatType.intValue()) == EnumC2300t.WEB_AUTH) {
                    string = "ChatON";
                    i = 1;
                }
                int iIntValue = pushEntry.chatType.intValue();
                if (C4904y.f17873c) {
                    C4904y.m18641c("InboxNO: " + string2 + ", MsgID: " + pushEntry.msgID + ", sender: " + pushEntry.senderID + ", message: " + C1734gg.m8584a(pushEntry.message) + ", MsgType: " + enumC2214abM10070a + ", unreadCount: " + i, this.f6956a.getClass().getSimpleName());
                }
                if (C4904y.f17876f) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ch@t[c <~~ s]push received= ").append("MsgID : ").append(pushEntry.msgID).append(", ").append("SessionID : ").append(pushEntry.sessionID);
                    C4904y.m18647f(sb.toString(), this.f6956a.getClass().getSimpleName());
                }
                EnumC2301u enumC2301uM8784b = EnumC2301u.NORMAL;
                if (pushEntry.userType != null) {
                    enumC2301uM8784b = EnumC1774ht.m8784b(pushEntry.userType);
                }
                C1813b.m8906b().m8926a(pushEntry.senderID, pushEntry.message, string2, pushEntry.msgID.longValue(), enumC2214abM10070a, iIntValue, pushEntry.sessionID, string, z, pushEntry.sentTime.longValue(), pushEntry.f8555IP, pushEntry.PORT.intValue(), pushEntry.receiverCount.intValue(), j, pushEntry.truncated.booleanValue() ? "Y" : "N", enumC2301uM8784b);
                break;
        }
    }
}
