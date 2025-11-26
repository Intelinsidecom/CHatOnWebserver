package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.sec.chaton.p015b.p016a.C0253a;
import com.sec.chaton.p033io.entry.inner.Buddy;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.ao */
/* loaded from: classes.dex */
class HandlerThreadC1292ao extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C1348w f4472a;

    /* renamed from: b */
    private final Context f4473b;

    /* renamed from: c */
    private Handler f4474c;

    /* renamed from: d */
    private final ArrayList f4475d;

    /* renamed from: e */
    private final ArrayList f4476e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC1292ao(C1348w c1348w, Context context) {
        super("ProfileDownloader");
        this.f4472a = c1348w;
        this.f4475d = C1350y.m4715a();
        this.f4476e = C1350y.m4715a();
        this.f4473b = context;
    }

    /* renamed from: a */
    public void m4492a() {
        if (this.f4474c == null) {
            this.f4474c = new Handler(getLooper(), this);
        }
        this.f4474c.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        m4491b();
        this.f4472a.f4598h.sendEmptyMessage(2);
        return true;
    }

    /* renamed from: b */
    private void m4491b() throws Throwable {
        this.f4472a.m4690a(this.f4475d, this.f4476e);
        Iterator it = this.f4476e.iterator();
        while (it.hasNext()) {
            C1293ap c1293ap = (C1293ap) it.next();
            Bitmap bitmapM4681a = this.f4472a.m4681a(this.f4473b, c1293ap.m4493a());
            if (bitmapM4681a != null) {
                this.f4472a.m4702a(c1293ap.m4493a(), bitmapM4681a);
                this.f4475d.remove(c1293ap);
            } else {
                if (c1293ap.m4494b() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || c1293ap.m4494b() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode()) {
                    C0253a c0253aM4703c = this.f4472a.m4703c(c1293ap.m4493a());
                    if (c0253aM4703c == null || c0253aM4703c.m916b() == EnumC1304b.ERROR) {
                        this.f4472a.m4696e(c1293ap.m4493a());
                    } else {
                        Bitmap bitmapM914a = c0253aM4703c.m914a();
                        if (bitmapM914a != null) {
                            this.f4472a.m4697a(bitmapM914a, c1293ap.m4493a());
                        }
                        this.f4472a.m4702a(c1293ap.m4493a(), bitmapM914a);
                    }
                } else {
                    this.f4472a.m4702a(c1293ap.m4493a(), (Bitmap) null);
                }
                this.f4475d.remove(c1293ap);
            }
        }
    }
}
