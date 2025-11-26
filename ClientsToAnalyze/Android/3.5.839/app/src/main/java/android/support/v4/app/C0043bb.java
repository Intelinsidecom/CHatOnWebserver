package android.support.v4.app;

import android.app.Notification;
import java.util.Iterator;

/* compiled from: NotificationCompat.java */
/* renamed from: android.support.v4.app.bb */
/* loaded from: classes.dex */
class C0043bb implements InterfaceC0038ax {
    C0043bb() {
    }

    @Override // android.support.v4.app.InterfaceC0038ax
    /* renamed from: a */
    public Notification mo147a(C0036av c0036av) {
        C0047bf c0047bf = new C0047bf(c0036av.f138a, c0036av.f155r, c0036av.f139b, c0036av.f140c, c0036av.f145h, c0036av.f143f, c0036av.f146i, c0036av.f141d, c0036av.f142e, c0036av.f144g, c0036av.f151n, c0036av.f152o, c0036av.f153p, c0036av.f148k, c0036av.f147j, c0036av.f150m);
        Iterator<C0033as> it = c0036av.f154q.iterator();
        while (it.hasNext()) {
            C0033as next = it.next();
            c0047bf.m151a(next.f131a, next.f132b, next.f133c);
        }
        if (c0036av.f149l != null) {
            if (c0036av.f149l instanceof C0035au) {
                C0035au c0035au = (C0035au) c0036av.f149l;
                c0047bf.m153a(c0035au.f157d, c0035au.f159f, c0035au.f158e, c0035au.f137a);
            } else if (c0036av.f149l instanceof C0037aw) {
                C0037aw c0037aw = (C0037aw) c0036av.f149l;
                c0047bf.m154a(c0037aw.f157d, c0037aw.f159f, c0037aw.f158e, c0037aw.f156a);
            } else if (c0036av.f149l instanceof C0034at) {
                C0034at c0034at = (C0034at) c0036av.f149l;
                c0047bf.m152a(c0034at.f157d, c0034at.f159f, c0034at.f158e, c0034at.f134a, c0034at.f135b, c0034at.f136c);
            }
        }
        return c0047bf.m150a();
    }
}
