package com.sec.chaton.mobileweb;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.mobileweb.p077a.AsyncTaskC2587a;
import com.sec.chaton.util.C4904y;

/* compiled from: GeneralWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.f */
/* loaded from: classes.dex */
class HandlerC2592f extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeneralWebFragment f9252a;

    HandlerC2592f(GeneralWebFragment generalWebFragment) {
        this.f9252a = generalWebFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intentM10990a;
        if (this.f9252a.isValidActivity()) {
            if (!C2602p.m11019b(this.f9252a.mWebView.getUrl())) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[Security Check] Interface called from : " + this.f9252a.mWebView.getUrl(), GeneralWebFragment.f9200b);
                    return;
                }
                return;
            }
            EnumC2598l enumC2598lM11002a = EnumC2598l.m11002a(message.what);
            if (enumC2598lM11002a != null) {
                String str = (String) message.obj;
                C4904y.m18639b(String.format("api(%s) with arguments : %s", enumC2598lM11002a.m11006d(), str), GeneralWebFragment.f9200b);
                switch (enumC2598lM11002a) {
                    case HANDSHAKE_V2:
                        AsyncTaskC2587a.m10995a(this.f9252a.f9221y, C2602p.m11012a(this.f9252a.getRequestApiList())).execute(str);
                        break;
                    case GOPAGE_V1:
                    case GOPAGE_V2:
                    case GOPAGE_V3:
                        C2586a c2586aM10989a = C2586a.m10989a(Uri.parse(str));
                        if (c2586aM10989a != null) {
                            switch (c2586aM10989a.m10991a()) {
                                case M_ACTION_BUDDY_POPUP:
                                    Intent intentM10990a2 = c2586aM10989a.m10990a(this.f9252a.getAttachedActivity());
                                    if (intentM10990a2 != null) {
                                        this.f9252a.startActivity(intentM10990a2);
                                        break;
                                    }
                                    break;
                                case M_ACTION_LIVE_CONTENTS:
                                    Intent intentM10990a3 = c2586aM10989a.m10990a(this.f9252a.getAttachedActivity());
                                    if (intentM10990a3 != null) {
                                        intentM10990a3.setFlags(67108864);
                                        this.f9252a.startActivity(intentM10990a3);
                                        break;
                                    }
                                    break;
                                case M_ACTION_LIVE_CHAT:
                                    if (C2349a.m10301a("live_chat_feature") && (intentM10990a = c2586aM10989a.m10990a(this.f9252a.getAttachedActivity())) != null) {
                                        intentM10990a.setFlags(67108864);
                                        this.f9252a.startActivity(intentM10990a);
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }
}
