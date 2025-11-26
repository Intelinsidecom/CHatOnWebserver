package com.sec.chaton.receiver;

import android.app.PendingIntent;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0700o;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p019b.C0685l;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.p028io.entry.PushEntry;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.a */
/* loaded from: classes.dex */
class C1144a implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ PushReceiver f4158a;

    C1144a(PushReceiver pushReceiver) {
        this.f4158a = pushReceiver;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        EnumC0699n enumC0699nM3046a;
        if (z && obj != null) {
            C0685l c0685l = (C0685l) obj;
            PushEntry pushEntryM3103c = c0685l.m3103c();
            if (!c0685l.m3106f() && (GlobalApplication.f2776b == null || !GlobalApplication.f2776b.equals(c0685l.m3104d()))) {
                boolean z2 = true;
                if (EnumC0695j.m3145a(pushEntryM3103c.chatType.intValue()) == EnumC0695j.WEB_AUTH) {
                    z2 = false;
                }
                Intent intent = new Intent(HomeActivity.m585a(this.f4158a.f4156c, z2));
                int iIntValue = 0;
                switch (EnumC0695j.m3145a(pushEntryM3103c.chatType.intValue())) {
                    case ONETOONE:
                    case BROADCAST:
                        intent.putExtra("inboxNO", c0685l.m3104d());
                        intent.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1754j, 1);
                        intent.putExtra("buddyNO", c0685l.m3103c().senderID);
                        iIntValue = EnumC0695j.ONETOONE.m3146a();
                        break;
                    case GROUPCHAT:
                        intent.putExtra("inboxNO", c0685l.m3104d());
                        intent.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1754j, 1);
                        intent.putExtra("buddyNO", c0685l.m3103c().senderID);
                        iIntValue = EnumC0695j.GROUPCHAT.m3146a();
                        break;
                    case WEB_AUTH:
                        intent.putExtra("inboxNO", c0685l.m3104d());
                        intent.putExtra("chatType", EnumC0695j.WEB_AUTH.m3146a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra("Content", pushEntryM3103c.message);
                        iIntValue = pushEntryM3103c.chatType.intValue();
                        break;
                }
                PendingIntent activity = PendingIntent.getActivity(this.f4158a.f4156c, 0, intent, 268435456);
                String str = pushEntryM3103c.message;
                EnumC0699n enumC0699n = EnumC0699n.UNDEFINED;
                if (pushEntryM3103c.msgType.intValue() != EnumC0700o.MSG.m3163a()) {
                    enumC0699nM3046a = C0665i.m3046a(pushEntryM3103c.message);
                } else {
                    enumC0699nM3046a = EnumC0699n.TEXT;
                }
                C1786r.m6063c("[NOTI] ChatType: " + EnumC0695j.m3145a(pushEntryM3103c.chatType.intValue()) + ", Memory Address:" + this, this.f4158a.getClass().getSimpleName());
                C1788t.m6070a(this.f4158a.f4156c).m6074a(pushEntryM3103c.senderID, pushEntryM3103c.message, c0685l.m3104d(), activity, pushEntryM3103c.msgID.longValue(), enumC0699nM3046a, c0685l.m3105e(), iIntValue, c0685l.m3107g(), pushEntryM3103c.sessionID);
            }
            EnumC0695j enumC0695jM3145a = EnumC0695j.m3145a(pushEntryM3103c.chatType.intValue());
            if (PushReceiver.f4153e != null && GlobalApplication.f2776b != null && c0685l.m3104d().equals(GlobalApplication.f2776b)) {
                PushReceiver.f4153e.allowWithPush(pushEntryM3103c.f3049IP, pushEntryM3103c.PORT.intValue(), pushEntryM3103c.senderID, pushEntryM3103c.sessionID, enumC0695jM3145a);
                if (!PushReceiver.f4153e.enableAutoScroll() && !c0685l.m3106f()) {
                    PushReceiver.f4153e.setPreviewText(1);
                }
            } else {
                C0639k c0639kM2914b = C0639k.m2914b(c0685l.m3104d());
                if (c0639kM2914b != null) {
                    c0639kM2914b.m2954f();
                }
            }
            if (c0685l.m3102b()) {
                C0620aj.m2804a().mo2703a(c0685l.m3101a());
            }
        }
    }
}
