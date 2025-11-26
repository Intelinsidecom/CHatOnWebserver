package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.sec.chaton.common.entry.ImageRequestResult;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ImageDownloader;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sec.chaton.util.l */
/* loaded from: classes.dex */
class HandlerThreadC0614l extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ ProfileImageLoader f3779a;

    /* renamed from: b */
    private final Context f3780b;

    /* renamed from: c */
    private Handler f3781c;

    /* renamed from: d */
    private final ArrayList f3782d;

    /* renamed from: e */
    private final ArrayList f3783e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC0614l(ProfileImageLoader profileImageLoader, Context context) {
        super("ProfileDownloader");
        this.f3779a = profileImageLoader;
        this.f3782d = CollectionsUtil.m3553a();
        this.f3783e = CollectionsUtil.m3553a();
        this.f3780b = context;
    }

    /* renamed from: b */
    private void m3692b() throws Throwable {
        this.f3779a.m3615a(this.f3782d, this.f3783e);
        Iterator it = this.f3783e.iterator();
        while (it.hasNext()) {
            C0615m c0615m = (C0615m) it.next();
            Bitmap bitmapM3607a = this.f3779a.m3607a(this.f3780b, c0615m.m3694a());
            if (bitmapM3607a != null) {
                this.f3779a.m3626a(c0615m.m3694a(), bitmapM3607a);
                this.f3782d.remove(c0615m);
            } else {
                if (c0615m.m3695b() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || c0615m.m3695b() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode()) {
                    ImageRequestResult imageRequestResultM3627b = this.f3779a.m3627b(c0615m.m3694a());
                    if (imageRequestResultM3627b == null || imageRequestResultM3627b.m1962b() == ImageDownloader.ImageDownResult.ERROR) {
                        this.f3779a.m3620e(c0615m.m3694a());
                    } else {
                        Bitmap bitmapM1960a = imageRequestResultM3627b.m1960a();
                        if (bitmapM1960a != null) {
                            this.f3779a.m3621a(bitmapM1960a, c0615m.m3694a());
                        }
                        this.f3779a.m3626a(c0615m.m3694a(), bitmapM1960a);
                    }
                } else {
                    this.f3779a.m3626a(c0615m.m3694a(), (Bitmap) null);
                }
                this.f3782d.remove(c0615m);
            }
        }
    }

    /* renamed from: a */
    public void m3693a() {
        if (this.f3781c == null) {
            this.f3781c = new Handler(getLooper(), this);
        }
        this.f3781c.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        m3692b();
        this.f3779a.f3708i.sendEmptyMessage(2);
        return true;
    }
}
