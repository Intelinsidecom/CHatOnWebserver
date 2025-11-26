package com.sec.chaton.buddy.dialog;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC3186ba;
import com.sec.widget.C3641ai;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ae */
/* loaded from: classes.dex */
class RunnableC0611ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC3186ba f2827a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f2828b;

    /* renamed from: c */
    final /* synthetic */ C0610ad f2829c;

    RunnableC0611ae(C0610ad c0610ad, EnumC3186ba enumC3186ba, Bitmap bitmap) {
        this.f2829c = c0610ad;
        this.f2827a = enumC3186ba;
        this.f2828b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2827a == EnumC3186ba.SUCCESS) {
            if (this.f2828b == null) {
                C3641ai.m13210a(this.f2829c.f2826a.f2802h, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f2829c.f2826a.f2794G = this.f2828b;
                if (this.f2829c.f2826a.f2808n != null) {
                    this.f2829c.f2826a.f2808n.setImageBitmap(this.f2829c.f2826a.f2794G);
                }
            }
        } else if (this.f2827a == EnumC3186ba.ERROR) {
            C3641ai.m13210a(this.f2829c.f2826a.f2802h, R.string.toast_network_unable, 0).show();
        }
        this.f2829c.f2826a.m4314i();
    }
}
