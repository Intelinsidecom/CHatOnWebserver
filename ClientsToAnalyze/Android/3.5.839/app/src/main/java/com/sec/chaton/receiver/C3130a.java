package com.sec.chaton.receiver;

import android.app.KeyguardManager;
import android.content.res.Resources;
import android.os.PowerManager;
import android.text.TextUtils;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1833v;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p057e.p059b.C2254o;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p065io.entry.PushEntry;
import com.sec.chaton.qmlog.C3122d;
import com.sec.chaton.qmlog.EnumC3124f;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.a */
/* loaded from: classes.dex */
class C3130a implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ PushReceiver f11526a;

    C3130a(PushReceiver pushReceiver) {
        this.f11526a = pushReceiver;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            C2254o c2254o = (C2254o) obj;
            if (z) {
                if (c2254o.m10119k()) {
                    C1736gi.m8642a(c2254o.m10116h(), c2254o.m10111c().sentTime.longValue());
                } else {
                    PushEntry pushEntryM10111c = c2254o.m10111c();
                    if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntryM10111c.senderID)) {
                        KeyguardManager keyguardManager = (KeyguardManager) CommonApplication.m18732r().getSystemService("keyguard");
                        String strM10112d = c2254o.m10112d();
                        if (!TextUtils.isEmpty(c2254o.m10111c().userType)) {
                            if ((!c2254o.m10115g() && (!C1813b.m8906b().m8931a(strM10112d) || C1813b.m8906b().m8933b(strM10112d) != EnumC4549n.m17246a(pushEntryM10111c.userType).m17247a())) || keyguardManager.inKeyguardRestrictedInputMode()) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("call push receiver manager. msgID:" + pushEntryM10111c.msgID, "NotificationReceiver");
                                }
                                C1833v.m8979a().m8980a(c2254o, pushEntryM10111c);
                            }
                        } else if (!c2254o.m10115g() && (!C1813b.m8906b().m8931a(c2254o.m10112d()) || keyguardManager.inKeyguardRestrictedInputMode())) {
                            if (C4904y.f17873c) {
                                C4904y.m18641c("call push receiver manager. msgID:" + pushEntryM10111c.msgID, "NotificationReceiver");
                            }
                            C1833v.m8979a().m8980a(c2254o, pushEntryM10111c);
                        }
                    }
                    EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(pushEntryM10111c.chatType.intValue());
                    if (PushReceiver.f11518e != null && C1813b.m8906b().m8931a(c2254o.m10112d())) {
                        PushReceiver.f11518e.mo8234a(c2254o.m10112d(), pushEntryM10111c.f8555IP, pushEntryM10111c.PORT.intValue(), pushEntryM10111c.senderID, pushEntryM10111c.sessionID, enumC2300tM10207a);
                        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(pushEntryM10111c.senderID) && !PushReceiver.f11518e.mo8271p() && !c2254o.m10115g()) {
                            PushReceiver.f11518e.mo8219a(1, pushEntryM10111c.message, C2176ab.m9697g(CommonApplication.m18732r().getContentResolver(), pushEntryM10111c.senderID), C2204r.m10020a(pushEntryM10111c.message, pushEntryM10111c.msgType.intValue()));
                        }
                    } else {
                        C2142w c2142wM9606c = C2142w.m9606c(c2254o.m10112d());
                        if (c2142wM9606c != null) {
                            c2142wM9606c.mo9274d();
                        }
                    }
                    if (C2349a.m10301a("chaton_qmlog_sending")) {
                        C3122d.m12732a().m12747a(EnumC3124f.PUSH, pushEntryM10111c.msgID.longValue(), pushEntryM10111c.message.length(), pushEntryM10111c.sentTime.longValue(), System.currentTimeMillis());
                    }
                }
            }
            if (c2254o.m10110b()) {
                C2093az.m9337a().mo9078a(c2254o.m10109a());
                C4904y.m18641c("push.notiAck( ) - NotiID: " + c2254o.m10109a(), getClass().getSimpleName());
            } else {
                C4904y.m18641c("Ack - false - NotiID: " + c2254o.m10109a(), getClass().getSimpleName());
            }
        }
        if (this.f11526a.f11522d != null) {
            this.f11526a.f11522d.release();
        }
        ((PowerManager) this.f11526a.f11521c.getSystemService("power")).newWakeLock(1, "ChatONforACK").acquire(2000L);
    }
}
