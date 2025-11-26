package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.widget.C5179v;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.jc */
/* loaded from: classes.dex */
class RunnableC1404jc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC4836ba f5035a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f5036b;

    /* renamed from: c */
    final /* synthetic */ C1403jb f5037c;

    RunnableC1404jc(C1403jb c1403jb, EnumC4836ba enumC4836ba, Bitmap bitmap) {
        this.f5037c = c1403jb;
        this.f5035a = enumC4836ba;
        this.f5036b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5035a == EnumC4836ba.SUCCESS) {
            if (this.f5036b == null) {
                C5179v.m19810a(this.f5037c.f5034a.f4196o, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            } else {
                this.f5037c.f5034a.f4199r = this.f5036b;
                if (this.f5037c.f5034a.f4197p != null) {
                    this.f5037c.f5034a.f4197p.setImageBitmap(this.f5037c.f5034a.f4199r);
                    if (this.f5037c.f5034a.f4197p.getDrawable() != null) {
                        this.f5037c.f5034a.f4197p.setOnTouchListener(this.f5037c.f5034a.f4200s);
                        this.f5037c.f5034a.f4200s.m11930a(this.f5037c.f5034a.f4197p);
                    }
                }
            }
        } else if (this.f5035a == EnumC4836ba.ERROR) {
            C5179v.m19810a(this.f5037c.f5034a.f4196o, R.string.toast_network_unable, 0).show();
        }
        if (this.f5037c.f5034a.f4198q != null && this.f5037c.f5034a.f4198q.isShowing() && this.f5037c.f5034a.f4196o != null && !this.f5037c.f5034a.f4196o.isFinishing()) {
            this.f5037c.f5034a.f4198q.dismiss();
        }
    }
}
