package com.sec.chaton.receiver;

import android.app.KeyguardManager;
import android.content.Intent;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p027e.p029b.C1424o;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p035io.entry.PushEntry;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.a */
/* loaded from: classes.dex */
class C2120a implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ PushReceiver f8074a;

    C2120a(PushReceiver pushReceiver) {
        this.f8074a = pushReceiver;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) throws Throwable {
        if (obj != null) {
            C1424o c1424o = (C1424o) obj;
            if (z) {
                PushEntry pushEntryM6274c = c1424o.m6274c();
                if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntryM6274c.senderID)) {
                    KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m11493l().getSystemService("keyguard");
                    if (!c1424o.m6277f() && (!C1103a.m5432a(GlobalApplication.m11493l()).m5458a(c1424o.m6275d()) || keyguardManager.inKeyguardRestrictedInputMode())) {
                        String strM6278g = c1424o.m6278g();
                        int iM6276e = c1424o.m6276e();
                        boolean z2 = true;
                        if (EnumC1450r.m6339a(pushEntryM6274c.chatType.intValue()) == EnumC1450r.WEB_AUTH) {
                            z2 = false;
                            strM6278g = "ChatON";
                            iM6276e = 1;
                        }
                        Intent intentM1171a = IntentControllerActivity.m1171a(this.f8074a.f8068c, true);
                        intentM1171a.putExtra("callChatList", z2);
                        int iIntValue = 0;
                        switch (EnumC1450r.m6339a(pushEntryM6274c.chatType.intValue())) {
                            case ONETOONE:
                            case BROADCAST:
                                intentM1171a.putExtra("inboxNO", c1424o.m6275d());
                                intentM1171a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                                intentM1171a.putExtra("fromPush", 1);
                                intentM1171a.putExtra("buddyNO", pushEntryM6274c.senderID);
                                iIntValue = EnumC1450r.ONETOONE.m6342a();
                                break;
                            case GROUPCHAT:
                                intentM1171a.putExtra("inboxNO", c1424o.m6275d());
                                intentM1171a.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                                intentM1171a.putExtra("fromPush", 1);
                                intentM1171a.putExtra("buddyNO", pushEntryM6274c.senderID);
                                iIntValue = EnumC1450r.GROUPCHAT.m6342a();
                                break;
                            case WEB_AUTH:
                                intentM1171a.putExtra("inboxNO", c1424o.m6275d());
                                intentM1171a.putExtra("chatType", EnumC1450r.WEB_AUTH.m6342a());
                                intentM1171a.putExtra("fromPush", 1);
                                intentM1171a.putExtra("Content", pushEntryM6274c.message);
                                intentM1171a.setAction("com.sec.chaton.action.NOTI_WEB");
                                iIntValue = pushEntryM6274c.chatType.intValue();
                                break;
                        }
                        EnumC1455w enumC1455wM6174a = C1373q.m6174a(pushEntryM6274c.message, pushEntryM6274c.msgType.intValue());
                        if (C3250y.f11735c) {
                            String str = pushEntryM6274c.message;
                            int length = str.length();
                            if (length > 3) {
                                length = 3;
                            }
                            C3250y.m11453c("InboxNO: " + c1424o.m6275d() + ", MsgID: " + pushEntryM6274c.msgID + ", sender: " + pushEntryM6274c.senderID + ", message: " + str.substring(0, length) + ", MsgType: " + enumC1455wM6174a + ", unreadCount: " + iM6276e, this.f8074a.getClass().getSimpleName());
                        }
                        if (C3250y.f11738f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ch@t[c <~~ s]push received= ").append("MsgID : ").append(pushEntryM6274c.msgID).append(", ").append("SessionID : ").append(pushEntryM6274c.sessionID);
                            C3250y.m11457f(sb.toString(), this.f8074a.getClass().getSimpleName());
                        }
                        C1103a.m5432a(this.f8074a.f8068c).m5455a(pushEntryM6274c.senderID, pushEntryM6274c.message, c1424o.m6275d(), pushEntryM6274c.msgID.longValue(), enumC1455wM6174a, iIntValue, pushEntryM6274c.sessionID, strM6278g, c1424o.m6279h(), pushEntryM6274c.sentTime.longValue(), pushEntryM6274c.f5633IP, pushEntryM6274c.PORT.intValue(), pushEntryM6274c.receiverCount.intValue(), c1424o.m6280i(), pushEntryM6274c.truncated.booleanValue() ? "Y" : "N");
                    }
                    EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(pushEntryM6274c.chatType.intValue());
                    if (PushReceiver.f8065e != null && C1103a.m5432a(GlobalApplication.m11493l()).m5458a(c1424o.m6275d())) {
                        PushReceiver.f8065e.mo4978a(pushEntryM6274c.f5633IP, pushEntryM6274c.PORT.intValue(), pushEntryM6274c.senderID, pushEntryM6274c.sessionID, enumC1450rM6339a);
                        if (!PushReceiver.f8065e.mo5018s() && !c1424o.m6277f()) {
                            PushReceiver.f8065e.mo4963a(1, pushEntryM6274c.message, C1381y.m6227h(CommonApplication.m11493l().getContentResolver(), pushEntryM6274c.senderID), EnumC1455w.m6358a(pushEntryM6274c.msgType.intValue()));
                        }
                    } else {
                        C1337o c1337oM5813d = C1337o.m5813d(c1424o.m6275d());
                        if (c1337oM5813d != null) {
                            c1337oM5813d.m5901j();
                        }
                    }
                }
            }
            if (c1424o.m6273b()) {
                C1302ao.m5594a().mo5480a(c1424o.m6272a());
                C3250y.m11453c("push.notiAck( )", getClass().getSimpleName());
            }
        }
        if (this.f8074a.f8069d != null) {
            this.f8074a.f8069d.release();
        }
    }
}
