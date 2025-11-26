package com.sec.chaton.settings.moreapps;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.mobileweb.C2586a;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2598l;
import com.sec.chaton.mobileweb.p077a.AsyncTaskC2587a;
import com.sec.chaton.util.C4904y;

/* compiled from: EventFragment.java */
/* renamed from: com.sec.chaton.settings.moreapps.a */
/* loaded from: classes.dex */
class HandlerC3666a extends Handler {

    /* renamed from: a */
    final /* synthetic */ EventFragment f13252a;

    HandlerC3666a(EventFragment eventFragment) {
        this.f13252a = eventFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        EnumC2598l enumC2598lM11002a;
        if (this.f13252a.isValidActivity() && (enumC2598lM11002a = EnumC2598l.m11002a(message.what)) != null) {
            String str = (String) message.obj;
            C4904y.m18639b(String.format("api(%s) with arguments : %s", enumC2598lM11002a.m11006d(), str), EventFragment.f13244f);
            switch (enumC2598lM11002a) {
                case HANDSHAKE_V2:
                    AsyncTaskC2587a.m10995a(this.f13252a.f13249i, C2602p.m11012a(this.f13252a.getRequestApiList())).execute(str);
                    break;
                case GOPAGE_V1:
                case GOPAGE_V2:
                    if (C2586a.m10989a(Uri.parse(str)) != null) {
                        switch (r0.m10991a()) {
                            case M_ACTION_MORE_TAB:
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("GOPAGE : MORE_TAB", EventFragment.f13244f);
                                }
                                this.f13252a.getAttachedActivity().finish();
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
