package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC3186ba;
import com.sec.widget.C3641ai;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hy */
/* loaded from: classes.dex */
class RunnableC0768hy implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC3186ba f3036a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f3037b;

    /* renamed from: c */
    final /* synthetic */ C0767hx f3038c;

    RunnableC0768hy(C0767hx c0767hx, EnumC3186ba enumC3186ba, Bitmap bitmap) {
        this.f3038c = c0767hx;
        this.f3036a = enumC3186ba;
        this.f3037b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3036a == EnumC3186ba.SUCCESS) {
            if (this.f3037b == null) {
                C3641ai.m13210a(this.f3038c.f3035a.f2288Y, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f3038c.f3035a.f2289Z = this.f3037b;
                if (this.f3038c.f3035a.f2313r != null) {
                    this.f3038c.f3035a.f2313r.setImageBitmap(this.f3038c.f3035a.f2289Z);
                }
            }
        } else if (this.f3036a == EnumC3186ba.ERROR) {
            C3641ai.m13210a(this.f3038c.f3035a.f2288Y, R.string.toast_network_unable, 0).show();
        }
        if (this.f3038c.f3035a.f2304i != null) {
            this.f3038c.f3035a.f2304i.dismiss();
        }
    }
}
