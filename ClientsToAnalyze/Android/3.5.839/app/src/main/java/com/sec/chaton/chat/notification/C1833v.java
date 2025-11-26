package com.sec.chaton.chat.notification;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.p059b.C2254o;
import com.sec.chaton.p065io.entry.PushEntry;

/* compiled from: PushReceiverManager.java */
/* renamed from: com.sec.chaton.chat.notification.v */
/* loaded from: classes.dex */
public class C1833v {

    /* renamed from: a */
    private static C1833v f6954a;

    /* renamed from: b */
    private Handler f6955b = new HandlerC1834w(this);

    /* renamed from: a */
    public static synchronized C1833v m8979a() {
        if (f6954a == null) {
            f6954a = new C1833v();
        }
        return f6954a;
    }

    /* renamed from: a */
    public void m8980a(C2254o c2254o, PushEntry pushEntry) {
        if (C2349a.m10301a("chat_batch_push_feature")) {
            this.f6955b.removeMessages(0);
        }
        Message message = new Message();
        message.what = 0;
        message.obj = pushEntry;
        Bundle bundle = new Bundle();
        bundle.putString("buddyName", c2254o.m10116h());
        bundle.putInt("unreadCount", c2254o.m10113e());
        bundle.putLong("lastMergedTime", c2254o.m10118j());
        bundle.putString("inboxNo", c2254o.m10112d());
        bundle.putBoolean("isEnableNoti", c2254o.m10117i());
        bundle.putInt("msgContentType", c2254o.m10114f().m10076a());
        message.setData(bundle);
        if (C2349a.m10301a("chat_batch_push_feature")) {
            this.f6955b.sendMessageDelayed(message, 200L);
        } else {
            this.f6955b.sendMessage(message);
        }
    }
}
