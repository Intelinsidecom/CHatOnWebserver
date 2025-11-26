package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0782f;
import com.sec.chaton.p046a.p047a.C0785i;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p046a.p047a.EnumC0791o;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.ac */
/* loaded from: classes.dex */
class HandlerC4533ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16394a;

    HandlerC4533ac(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16394a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iM3152g;
        AbstractC4932a abstractC4932aM17212a;
        if (this.f16394a.isValidActivity()) {
            C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
            if (c0788l == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("resultEntry is null", SpecialBuddyChatFragment.f16299l);
                    return;
                }
                return;
            }
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.END_APP) {
                if (!ExitAppDialogActivity.m2892a()) {
                    ExitAppDialogActivity.m2894b();
                    return;
                }
                return;
            }
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESTART_APP && (abstractC4932aM17212a = this.f16394a.m17212a(EnumC0789m.RESTART_APP)) != null) {
                abstractC4932aM17212a.mo18745a().show();
            }
            if (!c0788l.f2172a && (((iM3152g = c0788l.m3152g()) == 24 || iM3152g == 23 || iM3152g == 21) && this.f16394a.f16373r != null)) {
                this.f16394a.f16373r.mo9274d();
                this.f16394a.f16373r.mo9252a(this.f16394a.f16376u, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
            }
            C4904y.m18639b("spbd_refresh, messageControl return : " + message.what, SpecialBuddyChatFragment.f16299l);
            switch (message.what) {
                case 2:
                    if (c0788l.f2172a || this.f16394a.f16379x != EnumC2300t.GROUPCHAT || c0788l.f2173b == EnumC0791o.NETWORKFAIL) {
                    }
                    break;
                case 6:
                    int iM3118b = ((C0782f) c0788l).m3118b();
                    if (iM3118b > 0 && !this.f16394a.mo8271p()) {
                        this.f16394a.mo8219a(iM3118b, "", "", null);
                        break;
                    }
                    break;
                case 34:
                case 36:
                    int iM3136b = ((C0785i) c0788l).m3136b();
                    if (iM3136b > 0 && !this.f16394a.mo8271p()) {
                        this.f16394a.mo8219a(iM3136b, "", "", null);
                        break;
                    }
                    break;
            }
        }
    }
}
