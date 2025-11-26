package com.sec.chaton.push.message.processer;

import android.os.Handler;
import android.os.SystemClock;
import com.sec.chaton.push.util.AlarmTimer;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class AbstractMessageProcesser {

    /* renamed from: a */
    protected static Random f2621a;

    /* renamed from: d */
    private static final String f2622d = AbstractMessageProcesser.class.getSimpleName();

    /* renamed from: b */
    protected MessageController f2623b;

    /* renamed from: c */
    protected Handler f2624c;

    public AbstractMessageProcesser(MessageController messageController, Handler handler) {
        f2621a = new Random(System.currentTimeMillis());
        this.f2623b = messageController;
        this.f2624c = handler;
    }

    /* renamed from: a */
    protected void m2881a(int i) {
        AlarmTimer.m3016a().m3019a(this.f2623b.m2934g(), this.f2623b.m2942o(), SystemClock.elapsedRealtime() + m2886c(), new C0377l(this, i));
    }

    /* renamed from: a */
    protected void m2882a(int i, boolean z) {
        AlarmTimer.m3016a().m3019a(this.f2623b.m2934g(), this.f2623b.m2941n(), SystemClock.elapsedRealtime() + m2886c(), new C0376k(this, i, new C0375j(this, z)));
    }

    /* renamed from: a */
    protected void m2883a(ICallback iCallback, int i) {
        if (iCallback != null) {
            iCallback.mo2865a(i);
        }
    }

    /* renamed from: a */
    protected void m2884a(ICallback iCallback, Object obj) {
        if (iCallback != null) {
            iCallback.mo2866a(obj);
        }
    }

    /* renamed from: b */
    protected int m2885b() {
        return f2621a.nextInt();
    }

    /* renamed from: c */
    protected long m2886c() {
        return 600000 + f2621a.nextInt(121);
    }

    /* renamed from: d */
    protected void m2887d() {
        AlarmTimer.m3016a().m3018a(this.f2623b.m2934g(), this.f2623b.m2941n());
    }

    /* renamed from: e */
    protected void m2888e() {
        AlarmTimer.m3016a().m3018a(this.f2623b.m2934g(), this.f2623b.m2942o());
    }
}
