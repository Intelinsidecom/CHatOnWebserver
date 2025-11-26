package com.sec.chaton.receiver;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p025d.EnumC0650c;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p025d.p027b.C0639b;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.p033io.entry.PushEntry;
import com.sec.chaton.util.C1332g;
import com.sec.chaton.util.C1341p;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.a */
/* loaded from: classes.dex */
class C0926a implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ PushReceiver f3137a;

    C0926a(PushReceiver pushReceiver) {
        this.f3137a = pushReceiver;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        EnumC0651d enumC0651dM2931a;
        if (z && obj != null) {
            C0639b c0639b = (C0639b) obj;
            PushEntry pushEntryM2953c = c0639b.m2953c();
            KeyguardManager keyguardManager = (KeyguardManager) GlobalApplication.m3100a().getSystemService("keyguard");
            if (!c0639b.m2957g() && (GlobalApplication.f2408b == null || !GlobalApplication.f2408b.equals(c0639b.m2954d()) || keyguardManager.inKeyguardRestrictedInputMode())) {
                String strM2958h = c0639b.m2958h();
                boolean z2 = true;
                if (EnumC0665r.m3011a(pushEntryM2953c.chatType.intValue()) == EnumC0665r.WEB_AUTH) {
                    z2 = false;
                    strM2958h = "ChatON";
                }
                Intent intent = new Intent(HomeActivity.m630a(this.f3137a.f3134c, z2));
                int iIntValue = 0;
                switch (EnumC0665r.m3011a(pushEntryM2953c.chatType.intValue())) {
                    case ONETOONE:
                    case BROADCAST:
                        intent.putExtra("inboxNO", c0639b.m2954d());
                        intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1735h, 1);
                        intent.putExtra("buddyNO", pushEntryM2953c.senderID);
                        iIntValue = EnumC0665r.ONETOONE.m3012a();
                        break;
                    case GROUPCHAT:
                        intent.putExtra("inboxNO", c0639b.m2954d());
                        intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1735h, 1);
                        intent.putExtra("buddyNO", pushEntryM2953c.senderID);
                        iIntValue = EnumC0665r.GROUPCHAT.m3012a();
                        break;
                    case WEB_AUTH:
                        intent.putExtra("inboxNO", c0639b.m2954d());
                        intent.putExtra("chatType", EnumC0665r.WEB_AUTH.m3012a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra("Content", pushEntryM2953c.message);
                        iIntValue = pushEntryM2953c.chatType.intValue();
                        break;
                }
                PendingIntent activity = PendingIntent.getActivity(this.f3137a.f3134c, 0, intent, 268435456);
                EnumC0651d enumC0651d = EnumC0651d.UNDEFINED;
                if (pushEntryM2953c.msgType.intValue() != EnumC0650c.MSG.m2975a()) {
                    enumC0651dM2931a = C0635o.m2931a(pushEntryM2953c.message);
                } else {
                    enumC0651dM2931a = EnumC0651d.TEXT;
                }
                C1341p.m4660c("[NOTI] ChatType: " + EnumC0665r.m3011a(pushEntryM2953c.chatType.intValue()) + ", Memory Address:" + this, this.f3137a.getClass().getSimpleName());
                C1332g.m4605a(this.f3137a.f3134c).m4611a(pushEntryM2953c.senderID, pushEntryM2953c.message, c0639b.m2954d(), activity, pushEntryM2953c.msgID.longValue(), enumC0651dM2931a, c0639b.m2956f(), iIntValue, pushEntryM2953c.sessionID, c0639b.m2955e(), strM2958h, c0639b.m2959i());
            }
            EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(pushEntryM2953c.chatType.intValue());
            if (GlobalApplication.f2408b != null && c0639b.m2954d().equals(GlobalApplication.f2408b)) {
                PushReceiver.f3131e.m2696a(pushEntryM2953c.f2447IP, pushEntryM2953c.PORT.intValue(), pushEntryM2953c.senderID, pushEntryM2953c.sessionID, enumC0665rM3011a);
                if (!PushReceiver.f3131e.f1745F && !c0639b.m2957g()) {
                    PushReceiver.f3131e.m2685a(1);
                }
            } else {
                C0223v c0223vM817b = C0223v.m817b(c0639b.m2954d());
                if (c0223vM817b != null) {
                    c0223vM817b.m857f();
                }
            }
            if (c0639b.m2952b()) {
                C0192ae.m739a().mo742a(c0639b.m2951a());
                C1341p.m4660c("push.notiAck( )", getClass().getSimpleName());
            }
        }
    }
}
