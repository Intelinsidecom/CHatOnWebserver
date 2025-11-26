package com.sec.chaton.trunk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.trunk.p042b.C1134e;
import com.sec.chaton.trunk.p042b.C1136g;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.aa */
/* loaded from: classes.dex */
class HandlerC1103aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1109ag f3860a;

    HandlerC1103aa(C1109ag c1109ag) {
        this.f3860a = c1109ag;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                C1136g c1136g = (C1136g) message.obj;
                if (c1136g != null && c1136g.m4164a() != null) {
                    String strM4171d = c1136g.m4171d();
                    C1196v c1196v = (C1196v) c1136g.m4164a();
                    C1341p.m4658b("Download complete: " + strM4171d + ", ImageView: " + c1196v.m4261b(), C1109ag.f3906a);
                    C1109ag.m4145a(this.f3860a.f3911d, c1136g.m4167b(), c1136g.m4169c(), true);
                    this.f3860a.f3913f.m603a(c1196v.m4261b(), new C1147bk(Uri.parse(strM4171d), c1196v.m4257a(), false));
                    c1196v.m4262c().setVisibility(8);
                    break;
                }
                break;
            case 3:
                C1341p.m4658b("Download canceled. " + message.obj, C1109ag.f3906a);
                break;
            case 4:
                C1341p.m4658b("Download failed", C1109ag.f3906a);
                C1134e c1134e = (C1134e) message.obj;
                if (c1134e != null && c1134e.m4164a() != null) {
                    C1196v c1196v2 = (C1196v) c1134e.m4164a();
                    this.f3860a.f3913f.m602a(c1196v2.m4261b());
                    this.f3860a.m4143a(c1196v2.m4261b(), c1196v2.m4257a());
                    c1196v2.m4262c().setVisibility(8);
                    break;
                }
                break;
        }
    }
}
