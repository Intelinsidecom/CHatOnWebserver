package android.support.v4.app;

import android.app.Notification;

/* compiled from: NotificationCompat.java */
/* renamed from: android.support.v4.app.ay */
/* loaded from: classes.dex */
class C0039ay implements InterfaceC0038ax {
    C0039ay() {
    }

    @Override // android.support.v4.app.InterfaceC0038ax
    /* renamed from: a */
    public Notification mo147a(C0036av c0036av) {
        Notification notification = c0036av.f155r;
        notification.setLatestEventInfo(c0036av.f138a, c0036av.f139b, c0036av.f140c, c0036av.f141d);
        if (c0036av.f147j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
