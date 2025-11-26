package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC1304b;
import com.sec.widget.C1619g;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.au */
/* loaded from: classes.dex */
class RunnableC0386au implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC1304b f1355a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f1356b;

    /* renamed from: c */
    final /* synthetic */ C0412bt f1357c;

    RunnableC0386au(C0412bt c0412bt, EnumC1304b enumC1304b, Bitmap bitmap) {
        this.f1357c = c0412bt;
        this.f1355a = enumC1304b;
        this.f1356b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1355a == EnumC1304b.SUCCESS) {
            if (this.f1356b == null) {
                C1619g.m5888a(this.f1357c.f1386a.f1265b, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f1357c.f1386a.f1268e = this.f1356b;
                this.f1357c.f1386a.f1266c.setImageBitmap(this.f1357c.f1386a.f1268e);
            }
        } else if (this.f1355a == EnumC1304b.ERROR) {
            C1619g.m5888a(this.f1357c.f1386a.f1265b, R.string.toast_network_unable, 0).show();
        }
        if (this.f1357c.f1386a.f1267d != null) {
            this.f1357c.f1386a.f1267d.dismiss();
        }
    }
}
