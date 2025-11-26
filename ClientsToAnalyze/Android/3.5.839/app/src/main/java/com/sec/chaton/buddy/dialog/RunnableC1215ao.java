package com.sec.chaton.buddy.dialog;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.widget.C5179v;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ao */
/* loaded from: classes.dex */
class RunnableC1215ao implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC4836ba f4711a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f4712b;

    /* renamed from: c */
    final /* synthetic */ C1214an f4713c;

    RunnableC1215ao(C1214an c1214an, EnumC4836ba enumC4836ba, Bitmap bitmap) {
        this.f4713c = c1214an;
        this.f4711a = enumC4836ba;
        this.f4712b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4713c.f4710a.f4676h != null) {
            if (this.f4711a == EnumC4836ba.SUCCESS) {
                this.f4713c.f4710a.f4667K = EnumC4836ba.SUCCESS;
                if (this.f4712b == null) {
                    if (this.f4713c.f4710a.f4676h != null) {
                        C5179v.m19810a(this.f4713c.f4710a.f4676h, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
                    }
                } else {
                    this.f4713c.f4710a.f4665I = this.f4712b;
                    if (this.f4713c.f4710a.f4686r != null) {
                        this.f4713c.f4710a.f4686r.setImageBitmap(this.f4713c.f4710a.f4665I);
                    }
                }
            } else if (this.f4711a == EnumC4836ba.ERROR && this.f4713c.f4710a.f4676h != null) {
                C5179v.m19810a(this.f4713c.f4710a.f4676h, R.string.toast_network_unable, 0).show();
            }
            this.f4713c.f4710a.m7385j();
        }
    }
}
