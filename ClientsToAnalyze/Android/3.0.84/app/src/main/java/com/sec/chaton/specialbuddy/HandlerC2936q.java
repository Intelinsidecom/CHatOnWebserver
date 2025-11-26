package com.sec.chaton.specialbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.mobileweb.C1683j;
import com.sec.chaton.mobileweb.C1692s;
import com.sec.chaton.mobileweb.EnumC1688o;
import com.sec.chaton.mobileweb.p047a.AsyncTaskC1674a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareEntry;
import com.sec.chaton.util.C3247v;
import com.sec.chaton.util.C3250y;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.q */
/* loaded from: classes.dex */
class HandlerC2936q extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10471a;

    HandlerC2936q(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10471a = specialBuddyChatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        EnumC1688o enumC1688oM6977a;
        SpecialBuddyShareEntry specialBuddyShareEntry;
        if (this.f10471a.m6966k() && (enumC1688oM6977a = EnumC1688o.m6977a(message.what)) != null) {
            String str = (String) message.obj;
            C3250y.m11450b(String.format("api(%s) with arguments : %s", enumC1688oM6977a.m6981d(), str), SpecialBuddyChatFragment.f10409m);
            switch (enumC1688oM6977a) {
                case HANDSHAKE_V2:
                    new AsyncTaskC1674a(this.f10471a.f10431V, C1692s.m6987a(this.f10471a.m6962g())).execute(str);
                    break;
                case GOPAGE_V1:
                case GOPAGE_V2:
                    C1683j c1683jM6969a = C1683j.m6969a(Uri.parse(str));
                    if (c1683jM6969a != null) {
                        switch (c1683jM6969a.m6971a()) {
                            case BUDDY_POPUP:
                                Intent intentM6970a = c1683jM6969a.m6970a(this.f10471a.m6961f());
                                if (intentM6970a != null) {
                                    this.f10471a.startActivity(intentM6970a);
                                    break;
                                }
                                break;
                            case LIVE_CONTENTS:
                                Intent intentM6970a2 = c1683jM6969a.m6970a(this.f10471a.m6961f());
                                if (intentM6970a2 != null) {
                                    intentM6970a2.setFlags(536870912);
                                    this.f10471a.startActivity(intentM6970a2);
                                    break;
                                }
                                break;
                            case LIVE_CHAT:
                                if (!C1493a.m6463a("live_chat_feature")) {
                                }
                                break;
                        }
                    }
                    break;
                case SHARE_V2:
                    try {
                        specialBuddyShareEntry = (SpecialBuddyShareEntry) new C3247v(str).m11432b(SpecialBuddyShareEntry.class);
                    } catch (Exception e) {
                        C3250y.m11443a(e, SpecialBuddyChatFragment.f10409m);
                        specialBuddyShareEntry = null;
                    }
                    C3250y.m11450b("[IN] ENTRY : " + specialBuddyShareEntry, SpecialBuddyChatFragment.f10409m);
                    if (specialBuddyShareEntry != null) {
                        this.f10471a.startActivity(this.f10471a.m10096a(this.f10471a.m6961f(), EnumC1455w.LIVESHARE, specialBuddyShareEntry.getRawContents(), (String) null));
                        break;
                    }
                    break;
            }
        }
    }
}
