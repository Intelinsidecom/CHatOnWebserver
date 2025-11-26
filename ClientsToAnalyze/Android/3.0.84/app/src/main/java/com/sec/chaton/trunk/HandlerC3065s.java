package com.sec.chaton.trunk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.trunk.p060b.C2991e;
import com.sec.chaton.trunk.p060b.C2992f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.s */
/* loaded from: classes.dex */
class HandlerC3065s extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3064r f10979a;

    HandlerC3065s(ViewOnClickListenerC3064r viewOnClickListenerC3064r) {
        this.f10979a = viewOnClickListenerC3064r;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.f10979a.f10972i.f10685a) {
            switch (message.what) {
                case 2:
                    C2991e c2991e = (C2991e) message.obj;
                    if (c2991e != null && c2991e.m10491a() != null) {
                        String strM10498d = c2991e.m10498d();
                        C3070x c3070x = (C3070x) c2991e.m10491a();
                        C3250y.m11450b("Download complete: " + strM10498d + ", ImageView: " + c3070x.m10614b(), ViewOnClickListenerC3064r.f10962b);
                        ViewOnClickListenerC3064r.m10592a(this.f10979a.f10971h, c2991e.m10494b(), c2991e.m10496c(), true);
                        this.f10979a.f10968e.m11730a(c3070x.m10614b(), new C2970ak(Uri.parse(strM10498d), c3070x.m10610a(), false, c3070x.m10617d()));
                        c3070x.m10616c().setVisibility(8);
                        break;
                    }
                    break;
                case 3:
                    C3250y.m11450b("Download canceled. " + message.obj, ViewOnClickListenerC3064r.f10962b);
                    break;
                case 4:
                    C3250y.m11450b("Download failed", ViewOnClickListenerC3064r.f10962b);
                    C2992f c2992f = (C2992f) message.obj;
                    if (c2992f != null && c2992f.m10491a() != null) {
                        C3070x c3070x2 = (C3070x) c2992f.m10491a();
                        this.f10979a.f10968e.m11732a(c3070x2.m10614b());
                        this.f10979a.m10587a(c3070x2.m10614b(), c3070x2.m10610a(), c3070x2.m10617d());
                        if (c3070x2.m10610a() == EnumC3026g.VIDEO || c3070x2.m10610a() == EnumC3026g.AMS) {
                            this.f10979a.m10586a(c3070x2.m10617d(), c3070x2.m10610a());
                        }
                        c3070x2.m10616c().setVisibility(8);
                        break;
                    }
                    break;
            }
        }
    }
}
