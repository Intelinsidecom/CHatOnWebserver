package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: NotificationCompat.java */
/* renamed from: android.support.v4.app.av */
/* loaded from: classes.dex */
public class C0036av {

    /* renamed from: a */
    Context f138a;

    /* renamed from: b */
    CharSequence f139b;

    /* renamed from: c */
    CharSequence f140c;

    /* renamed from: d */
    PendingIntent f141d;

    /* renamed from: e */
    PendingIntent f142e;

    /* renamed from: f */
    RemoteViews f143f;

    /* renamed from: g */
    Bitmap f144g;

    /* renamed from: h */
    CharSequence f145h;

    /* renamed from: i */
    int f146i;

    /* renamed from: j */
    int f147j;

    /* renamed from: k */
    boolean f148k;

    /* renamed from: l */
    AbstractC0044bc f149l;

    /* renamed from: m */
    CharSequence f150m;

    /* renamed from: n */
    int f151n;

    /* renamed from: o */
    int f152o;

    /* renamed from: p */
    boolean f153p;

    /* renamed from: q */
    ArrayList<C0033as> f154q = new ArrayList<>();

    /* renamed from: r */
    Notification f155r = new Notification();

    public C0036av(Context context) {
        this.f138a = context;
        this.f155r.when = System.currentTimeMillis();
        this.f155r.audioStreamType = -1;
        this.f147j = 0;
    }

    /* renamed from: a */
    public C0036av m140a(int i) {
        this.f155r.icon = i;
        return this;
    }

    /* renamed from: a */
    public C0036av m143a(CharSequence charSequence) {
        this.f139b = charSequence;
        return this;
    }

    /* renamed from: b */
    public C0036av m145b(CharSequence charSequence) {
        this.f140c = charSequence;
        return this;
    }

    /* renamed from: a */
    public C0036av m141a(int i, int i2, boolean z) {
        this.f151n = i;
        this.f152o = i2;
        this.f153p = z;
        return this;
    }

    /* renamed from: a */
    public C0036av m142a(PendingIntent pendingIntent) {
        this.f141d = pendingIntent;
        return this;
    }

    /* renamed from: c */
    public C0036av m146c(CharSequence charSequence) {
        this.f155r.tickerText = charSequence;
        return this;
    }

    /* renamed from: a */
    public C0036av m144a(boolean z) {
        m138a(16, z);
        return this;
    }

    /* renamed from: a */
    private void m138a(int i, boolean z) {
        if (z) {
            this.f155r.flags |= i;
        } else {
            this.f155r.flags &= i ^ (-1);
        }
    }

    /* renamed from: a */
    public Notification m139a() {
        return C0032ar.f130a.mo147a(this);
    }
}
