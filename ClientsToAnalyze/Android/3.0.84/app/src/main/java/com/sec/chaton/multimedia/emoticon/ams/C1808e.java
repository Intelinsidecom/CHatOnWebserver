package com.sec.chaton.multimedia.emoticon.ams;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3348j;
import java.io.File;

/* compiled from: AmsItemDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.ams.e */
/* loaded from: classes.dex */
public class C1808e extends AbstractRunnableC3324a<String> {
    public C1808e(String str) {
        super(str);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        mo4338h().setImageBitmap(null);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        return C3348j.m11791a(mo4338h().getContext(), new File(mo7454i()), C3347i.m11779b(), C3347i.m11780c());
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        Bitmap bitmap = (Bitmap) obj;
        ImageView imageViewMo4338h = mo4338h();
        if (bitmap == null) {
            imageViewMo4338h.setImageBitmap(null);
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(m11714k().getResources(), bitmap);
        bitmapDrawable.setAntiAlias(true);
        if (z) {
            imageViewMo4338h.setImageDrawable(bitmapDrawable);
            return;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), bitmapDrawable});
        imageViewMo4338h.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(100);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Bitmap bitmapMo4337g = mo4337g();
        if (bitmapMo4337g != null) {
            bitmapMo4337g.recycle();
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo7454i() {
        return (String) super.mo7454i();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo4337g() {
        return (Bitmap) super.mo4337g();
    }
}
