package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0102c;
import com.sec.chaton.p028io.entry.inner.Buddy;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bf */
/* loaded from: classes.dex */
class HandlerThreadC1750bf extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C1746bb f6381a;

    /* renamed from: b */
    private final Context f6382b;

    /* renamed from: c */
    private Handler f6383c;

    /* renamed from: d */
    private final ArrayList f6384d;

    /* renamed from: e */
    private final ArrayList f6385e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC1750bf(C1746bb c1746bb, Context context) {
        super("ProfileDownloader");
        this.f6381a = c1746bb;
        this.f6384d = C1794z.m6114a();
        this.f6385e = C1794z.m6114a();
        this.f6382b = context;
    }

    /* renamed from: a */
    public void m5966a() {
        if (this.f6383c == null) {
            this.f6383c = new Handler(getLooper(), this);
        }
        this.f6383c.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        m5965b();
        this.f6381a.f6367h.sendEmptyMessage(2);
        return true;
    }

    /* renamed from: b */
    private void m5965b() throws Throwable {
        this.f6381a.m5950a(this.f6384d, this.f6385e);
        Iterator it = this.f6385e.iterator();
        while (it.hasNext()) {
            C1751bg c1751bg = (C1751bg) it.next();
            Bitmap bitmapM5941a = this.f6381a.m5941a(this.f6382b, c1751bg.m5967a());
            if (bitmapM5941a != null) {
                this.f6381a.m5962a(c1751bg.m5967a(), bitmapM5941a);
                this.f6384d.remove(c1751bg);
            } else {
                if (c1751bg.m5968b() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || c1751bg.m5968b() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode()) {
                    C0102c c0102cM5963c = this.f6381a.m5963c(c1751bg.m5967a());
                    if (c0102cM5963c == null || c0102cM5963c.m679b() == EnumC1730am.ERROR) {
                        this.f6381a.m5956f(c1751bg.m5967a());
                    } else {
                        Bitmap bitmapM677a = c0102cM5963c.m677a();
                        if (bitmapM677a != null) {
                            this.f6381a.m5957a(bitmapM677a, c1751bg.m5967a());
                        }
                        this.f6381a.m5962a(c1751bg.m5967a(), bitmapM677a);
                    }
                } else {
                    this.f6381a.m5962a(c1751bg.m5967a(), (Bitmap) null);
                }
                this.f6384d.remove(c1751bg);
            }
        }
    }
}
