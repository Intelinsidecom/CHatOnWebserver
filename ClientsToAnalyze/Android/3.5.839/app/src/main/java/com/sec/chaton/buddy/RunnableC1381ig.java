package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.widget.C5179v;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ig */
/* loaded from: classes.dex */
class RunnableC1381ig implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC4836ba f4982a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f4983b;

    /* renamed from: c */
    final /* synthetic */ C1380if f4984c;

    RunnableC1381ig(C1380if c1380if, EnumC4836ba enumC4836ba, Bitmap bitmap) {
        this.f4984c = c1380if;
        this.f4982a = enumC4836ba;
        this.f4983b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4982a == EnumC4836ba.SUCCESS) {
            if (this.f4983b == null) {
                C5179v.m19810a(this.f4984c.f4981a.f4151j, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f4984c.f4981a.f4141T = this.f4983b;
                if (this.f4984c.f4981a.f4159r != null) {
                    this.f4984c.f4981a.f4159r.setImageBitmap(this.f4984c.f4981a.f4141T);
                }
            }
        } else if (this.f4982a == EnumC4836ba.ERROR) {
            C5179v.m19810a(this.f4984c.f4981a.f4151j, R.string.toast_network_unable, 0).show();
        }
        if (this.f4984c.f4981a.f4149h != null) {
            this.f4984c.f4981a.f4149h.dismiss();
        }
    }
}
