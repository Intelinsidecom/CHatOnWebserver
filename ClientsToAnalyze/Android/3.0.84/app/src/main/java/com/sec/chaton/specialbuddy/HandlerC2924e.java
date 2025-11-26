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
import com.sec.chaton.util.C3250y;
import java.util.Map;

/* compiled from: ChatONLiveBuddyListFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.e */
/* loaded from: classes.dex */
class HandlerC2924e extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveBuddyListFragment f10454a;

    HandlerC2924e(ChatONLiveBuddyListFragment chatONLiveBuddyListFragment) {
        this.f10454a = chatONLiveBuddyListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        EnumC1688o enumC1688oM6977a;
        if (this.f10454a.m6966k() && (enumC1688oM6977a = EnumC1688o.m6977a(message.what)) != null) {
            String str = (String) message.obj;
            C3250y.m11450b(String.format("api(%s) with arguments : %s", enumC1688oM6977a.m6981d(), str), ChatONLiveBuddyListFragment.f10389k);
            switch (enumC1688oM6977a) {
                case HANDSHAKE_V2:
                    new AsyncTaskC1674a(this.f10454a.f10394n, C1692s.m6987a(this.f10454a.m6962g())).execute(str);
                    break;
                case GOPAGE_V1:
                case GOPAGE_V2:
                    C1683j c1683jM6969a = C1683j.m6969a(Uri.parse(str));
                    if (c1683jM6969a != null) {
                        switch (c1683jM6969a.m6971a()) {
                            case BUDDY_POPUP:
                                Intent intentM6970a = c1683jM6969a.m6970a(this.f10454a.m6961f());
                                if (intentM6970a != null) {
                                    Map<String, String> mapM6972b = c1683jM6969a.m6972b();
                                    this.f10454a.f10391j = null;
                                    if (mapM6972b != null) {
                                        this.f10454a.f10391j = mapM6972b.get("buddyid");
                                    }
                                    this.f10454a.startActivity(intentM6970a);
                                    break;
                                }
                                break;
                            case LIVE_CONTENTS:
                                Intent intentM6970a2 = c1683jM6969a.m6970a(this.f10454a.m6961f());
                                if (intentM6970a2 != null) {
                                    Map<String, String> mapM6972b2 = c1683jM6969a.m6972b();
                                    this.f10454a.f10391j = null;
                                    if (mapM6972b2 != null) {
                                        this.f10454a.f10391j = mapM6972b2.get("buddyid");
                                    }
                                    intentM6970a2.setFlags(536870912);
                                    this.f10454a.startActivity(intentM6970a2);
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
            }
        }
    }
}
