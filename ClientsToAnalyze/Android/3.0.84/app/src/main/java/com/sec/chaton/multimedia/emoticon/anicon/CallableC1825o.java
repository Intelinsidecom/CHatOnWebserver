package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3172an;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3348j;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: RemoteImageResourceDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.o */
/* loaded from: classes.dex */
public class CallableC1825o extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    private int f6806a;

    /* renamed from: b */
    private int f6807b;

    /* renamed from: c */
    private int f6808c;

    /* renamed from: d */
    private int f6809d;

    /* renamed from: e */
    private boolean f6810e;

    public CallableC1825o(String str) {
        this(str, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public CallableC1825o(String str, int i, int i2) {
        this(str, i, i2, false);
    }

    public CallableC1825o(String str, int i, int i2, boolean z) {
        super(str);
        this.f6808c = i;
        this.f6809d = i2;
        this.f6810e = z;
        this.f6806a = R.drawable.rotate_emoticon_loading;
        this.f6807b = R.drawable.chat_anicon_btn_failed;
    }

    /* renamed from: a */
    public void m7494a(int i) {
        this.f6807b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo4338h = mo4338h();
        Drawable drawable = m11714k().getResources().getDrawable(this.f6806a);
        imageViewMo4338h.setImageDrawable(drawable);
        imageViewMo4338h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        mo4338h().setImageBitmap(null);
        mo4338h().setScaleType(ImageView.ScaleType.FIT_XY);
        m11711a(this, 500L);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws IOException {
        File file = new File(C3332a.m11751a(m11714k()), String.valueOf(mo7454i().hashCode()));
        try {
            C3332a.m11750a().m11753a(mo7454i(), file);
            Bitmap bitmapM11791a = C3348j.m11791a(m11714k(), file, this.f6808c, this.f6809d);
            bitmapM11791a.setDensity(160);
            return bitmapM11791a;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        mo4338h().setScaleType(ImageView.ScaleType.FIT_XY);
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo4337g());
            bitmapDrawable.setAntiAlias(true);
            drawable = bitmapDrawable;
            if (this.f6810e) {
                m7492a(mo4338h(), bitmapDrawable);
                drawable = bitmapDrawable;
            }
        } else {
            drawable = m11714k().getResources().getDrawable(this.f6807b);
        }
        if (z) {
            mo4338h().setImageDrawable(drawable);
            return;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable});
        mo4338h().setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(100);
    }

    /* renamed from: a */
    private void m7492a(ImageView imageView, BitmapDrawable bitmapDrawable) {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        if (bitmapDrawable != null) {
            imageView.setImageDrawable(bitmapDrawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layoutParams.height = (int) ((defaultDisplay.getWidth() - C3172an.m11085a(20.0f)) - C3172an.m11087c(20.0f));
            imageView.setLayoutParams(layoutParams);
            imageView.invalidate();
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Bitmap bitmapMo4337g = mo4337g();
        m11708a((View) null);
        if (bitmapMo4337g != null) {
            bitmapMo4337g.recycle();
        }
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
