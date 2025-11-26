package com.sec.common.p131f;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.sec.common.p132g.AbstractRunnableC5005a;
import java.io.File;

/* compiled from: Picasso.java */
/* renamed from: com.sec.common.f.d */
/* loaded from: classes.dex */
class C5000d extends AbstractRunnableC5005a<File> {

    /* renamed from: a */
    final /* synthetic */ C4999c f18246a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5000d(C4999c c4999c) {
        super(c4999c.f18242g);
        this.f18246a = c4999c;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        mo7449h().setImageBitmap(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        return this.f18246a.m18969a();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        ImageView imageViewMo7449h = mo7449h();
        Bitmap bitmapMo7448g = mo7448g();
        if (bitmapMo7448g == null) {
            if (this.f18246a.f18244i > 0) {
                imageViewMo7449h.setImageResource(this.f18246a.f18244i);
                return;
            } else {
                imageViewMo7449h.setImageBitmap(null);
                return;
            }
        }
        imageViewMo7449h.setImageBitmap(bitmapMo7448g);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Bitmap bitmapMo7448g = mo7448g();
        m18990a((View) null);
        if (bitmapMo7448g != null) {
            bitmapMo7448g.recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap mo7448g() {
        return (Bitmap) super.mo7448g();
    }
}
