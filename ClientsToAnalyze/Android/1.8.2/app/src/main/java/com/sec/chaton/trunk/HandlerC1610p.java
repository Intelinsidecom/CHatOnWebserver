package com.sec.chaton.trunk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.trunk.p050c.C1573e;
import com.sec.chaton.trunk.p050c.C1574f;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.p */
/* loaded from: classes.dex */
class HandlerC1610p extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1609o f5727a;

    HandlerC1610p(C1609o c1609o) {
        this.f5727a = c1609o;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                C1573e c1573e = (C1573e) message.obj;
                if (c1573e != null && c1573e.m5439a() != null) {
                    String strM5446d = c1573e.m5446d();
                    C1615u c1615u = (C1615u) c1573e.m5439a();
                    C1786r.m6061b("Download complete: " + strM5446d + ", ImageView: " + c1615u.m5527b(), C1609o.f5718a);
                    C0639k.m2911a(this.f5727a.f5721d, c1573e.m5442b(), c1573e.m5444c());
                    this.f5727a.m5513a(c1615u.m5527b(), c1615u.m5523a(), Uri.parse(strM5446d));
                    c1615u.m5528c().setVisibility(8);
                    break;
                }
                break;
            case 3:
                C1786r.m6061b("Download canceled. " + message.obj, C1609o.f5718a);
                break;
            case 4:
                C1786r.m6061b("Download failed", C1609o.f5718a);
                C1574f c1574f = (C1574f) message.obj;
                if (c1574f != null && c1574f.m5439a() != null) {
                    C1615u c1615u2 = (C1615u) c1574f.m5439a();
                    this.f5727a.m5512a(c1615u2.m5527b(), c1615u2.m5523a());
                    c1615u2.m5528c().setVisibility(8);
                    break;
                }
                break;
        }
    }
}
