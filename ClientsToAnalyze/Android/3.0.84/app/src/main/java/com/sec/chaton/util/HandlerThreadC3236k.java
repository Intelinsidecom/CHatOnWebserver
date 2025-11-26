package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0271h;
import com.sec.chaton.p035io.entry.inner.Buddy;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.k */
/* loaded from: classes.dex */
class HandlerThreadC3236k extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C3231f f11691a;

    /* renamed from: b */
    private final Context f11692b;

    /* renamed from: c */
    private Handler f11693c;

    /* renamed from: d */
    private final ArrayList<C3237l> f11694d;

    /* renamed from: e */
    private final ArrayList<C3237l> f11695e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC3236k(C3231f c3231f, Context context) {
        super("ProfileDownloader");
        this.f11691a = c3231f;
        this.f11694d = C3165ag.m11031a();
        this.f11695e = C3165ag.m11031a();
        this.f11692b = context;
    }

    /* renamed from: a */
    public void m11392a() {
        if (this.f11693c == null) {
            this.f11693c = new Handler(getLooper(), this);
        }
        this.f11693c.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        m11391b();
        this.f11691a.f11676j.sendEmptyMessage(2);
        return true;
    }

    /* renamed from: b */
    private void m11391b() throws Throwable {
        this.f11691a.m11367a((ArrayList<C3237l>) this.f11694d, (ArrayList<C3237l>) this.f11695e);
        Iterator<C3237l> it = this.f11695e.iterator();
        while (it.hasNext()) {
            C3237l next = it.next();
            Bitmap bitmapM11357a = this.f11691a.m11357a(this.f11692b, next.m11393a());
            if (bitmapM11357a != null) {
                this.f11691a.m11382a(next.m11393a(), bitmapM11357a);
                this.f11694d.remove(next);
            } else {
                if (next.m11394b() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || next.m11394b() == Buddy.BuddyImageStatus.PROFILE_DELETED.getCode() || next.m11394b() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode()) {
                    C0271h c0271hM11390f = this.f11691a.m11390f(next.m11393a());
                    if (c0271hM11390f == null || c0271hM11390f.m1364b() == EnumC3186ba.ERROR) {
                        this.f11691a.m11376g(next.m11393a());
                    } else {
                        Bitmap bitmapM1362a = c0271hM11390f.m1362a();
                        if (bitmapM1362a != null) {
                            this.f11691a.m11377a(bitmapM1362a, next.m11393a());
                        }
                        this.f11691a.m11382a(next.m11393a(), bitmapM1362a);
                    }
                } else {
                    this.f11691a.m11382a(next.m11393a(), (Bitmap) null);
                }
                this.f11694d.remove(next);
            }
        }
    }
}
