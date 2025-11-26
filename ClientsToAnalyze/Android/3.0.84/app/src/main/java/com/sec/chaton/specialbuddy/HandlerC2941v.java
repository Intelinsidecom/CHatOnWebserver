package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.p016a.p017a.C0265b;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p016a.p017a.EnumC0275l;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.v */
/* loaded from: classes.dex */
class HandlerC2941v extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10477a;

    HandlerC2941v(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10477a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iM1365f;
        AbstractC3271a abstractC3271aM10147a;
        if (this.f10477a.m6966k()) {
            C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
            if (c0272i == null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("resultEntry is null", SpecialBuddyChatFragment.f10409m);
                    return;
                }
                return;
            }
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.END_APP) {
                if (!ExitAppDialogActivity.m1139a()) {
                    ExitAppDialogActivity.m1141b();
                    return;
                }
                return;
            }
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESTART_APP && (abstractC3271aM10147a = this.f10477a.m10147a(EnumC0273j.RESTART_APP)) != null) {
                abstractC3271aM10147a.mo11505a().show();
            }
            if (!c0272i.f858a && (((iM1365f = c0272i.m1365f()) == 24 || iM1365f == 23 || iM1365f == 21) && this.f10477a.f10442s != null)) {
                this.f10477a.f10442s.m5901j();
                this.f10477a.f10442s.m5880a(this.f10477a.f10445v, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
            }
            C3250y.m11450b("spbd_refresh, messageControl return : " + message.what, SpecialBuddyChatFragment.f10409m);
            switch (message.what) {
                case 2:
                    if (c0272i.f858a || this.f10477a.f10448y != EnumC1450r.GROUPCHAT || c0272i.f859b == EnumC0275l.NETWORKFAIL) {
                    }
                    break;
                case 6:
                    int iM1334b = ((C0265b) c0272i).m1334b();
                    if (iM1334b > 0 && !this.f10477a.mo5018s()) {
                        this.f10477a.mo4963a(iM1334b, "", "", (EnumC1455w) null);
                        break;
                    }
                    break;
            }
        }
    }
}
