package com.sec.chaton.trunk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.sec.chaton.trunk.p120b.C4607e;
import com.sec.chaton.trunk.p120b.C4608f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.s */
/* loaded from: classes.dex */
class HandlerC4685s extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC4684r f16928a;

    HandlerC4685s(ViewOnClickListenerC4684r viewOnClickListenerC4684r) {
        this.f16928a = viewOnClickListenerC4684r;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.f16928a.f16921i.f16630a) {
            switch (message.what) {
                case 2:
                    C4607e c4607e = (C4607e) message.obj;
                    if (c4607e != null && c4607e.m17563a() != null) {
                        String strM17570d = c4607e.m17570d();
                        C4690x c4690x = (C4690x) c4607e.m17563a();
                        C4904y.m18639b("Download complete: " + strM17570d + ", ImageView: " + c4690x.m17708b(), ViewOnClickListenerC4684r.f16911b);
                        ViewOnClickListenerC4684r.m17686a(this.f16928a.f16920h, c4607e.m17566b(), c4607e.m17568c(), true);
                        this.f16928a.f16917e.m19023b(c4690x.m17708b(), new C4589an(Uri.parse(strM17570d), c4690x.m17704a(), false, c4690x.m17711d()));
                        c4690x.m17710c().setVisibility(8);
                        break;
                    }
                    break;
                case 3:
                    C4904y.m18639b("Download canceled. " + message.obj, ViewOnClickListenerC4684r.f16911b);
                    break;
                case 4:
                    C4904y.m18639b("Download failed", ViewOnClickListenerC4684r.f16911b);
                    C4608f c4608f = (C4608f) message.obj;
                    if (c4608f != null && c4608f.m17563a() != null) {
                        C4690x c4690x2 = (C4690x) c4608f.m17563a();
                        this.f16928a.f16917e.m19015a((View) c4690x2.m17708b());
                        this.f16928a.m17681a(c4690x2.m17708b(), c4690x2.m17704a(), c4690x2.m17711d());
                        if (c4690x2.m17704a() == EnumC4642g.VIDEO || c4690x2.m17704a() == EnumC4642g.AMS) {
                            this.f16928a.m17680a(c4690x2.m17711d(), c4690x2.m17704a());
                        }
                        c4690x2.m17710c().setVisibility(8);
                        break;
                    }
                    break;
            }
        }
    }
}
