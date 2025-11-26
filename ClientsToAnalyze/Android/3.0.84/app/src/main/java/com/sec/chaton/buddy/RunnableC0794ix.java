package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC3186ba;
import com.sec.widget.C3641ai;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.ix */
/* loaded from: classes.dex */
class RunnableC0794ix implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC3186ba f3086a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f3087b;

    /* renamed from: c */
    final /* synthetic */ C0793iw f3088c;

    RunnableC0794ix(C0793iw c0793iw, EnumC3186ba enumC3186ba, Bitmap bitmap) {
        this.f3088c = c0793iw;
        this.f3086a = enumC3186ba;
        this.f3087b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3086a == EnumC3186ba.SUCCESS) {
            if (this.f3087b == null) {
                C3641ai.m13210a(this.f3088c.f3085a.f2346b, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f3088c.f3085a.f2349e = this.f3087b;
                if (this.f3088c.f3085a.f2347c != null) {
                    this.f3088c.f3085a.f2347c.setImageBitmap(this.f3088c.f3085a.f2349e);
                    if (this.f3088c.f3085a.f2347c.getDrawable() != null) {
                        this.f3088c.f3085a.f2347c.setOnTouchListener(this.f3088c.f3085a.f2350f);
                        this.f3088c.f3085a.f2350f.m7704a(this.f3088c.f3085a.f2347c);
                    }
                }
            }
        } else if (this.f3086a == EnumC3186ba.ERROR) {
            C3641ai.m13210a(this.f3088c.f3085a.f2346b, R.string.toast_network_unable, 0).show();
        }
        if (this.f3088c.f3085a.f2348d != null) {
            this.f3088c.f3085a.f2348d.dismiss();
        }
    }
}
