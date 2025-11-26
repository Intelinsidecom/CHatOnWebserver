package com.sec.chaton.settings.moreapps;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.p133a.C5017a;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: PlusDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.g */
/* loaded from: classes.dex */
public class CallableC3675g extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: b */
    private static final String f13271b = CallableC3675g.class.getSimpleName();

    /* renamed from: a */
    Uri f13272a;

    /* renamed from: c */
    private boolean f13273c;

    /* renamed from: d */
    private String f13274d;

    /* renamed from: e */
    private ImageView f13275e;

    public CallableC3675g(String str) {
        super(str);
    }

    public CallableC3675g(String str, String str2, ImageView imageView) {
        super(str);
        this.f13273c = true;
        this.f13274d = str2;
        this.f13275e = imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        Drawable drawable = m18997k().getResources().getDrawable(R.drawable.rotate_emoticon_loading);
        mo7449h().setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        ImageView imageViewMo7449h = mo7449h();
        imageViewMo7449h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo7449h.setImageBitmap(null);
        imageViewMo7449h.setBackgroundColor(0);
        m18993a(this, 500L);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        Bitmap bitmapM18148a;
        if (TextUtils.isEmpty(m18996j())) {
            return null;
        }
        File file = new File(C5017a.m19065a(m18997k()), String.valueOf(m18996j().hashCode()));
        this.f13272a = Uri.parse(file.toString());
        try {
            C5017a.m19064a().m19067a(m18996j(), file);
            try {
                try {
                    if (file.exists()) {
                        bitmapM18148a = C4812ad.m18148a(this.f13272a);
                    } else {
                        try {
                            bitmapM18148a = C4812ad.m18148a(this.f13272a);
                        } catch (Exception e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                            bitmapM18148a = null;
                        } catch (OutOfMemoryError e2) {
                            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                            C4904y.m18635a(e2, getClass().getSimpleName());
                            bitmapM18148a = null;
                        }
                    }
                } catch (OutOfMemoryError e3) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                    C4904y.m18635a(e3, getClass().getSimpleName());
                    bitmapM18148a = null;
                }
            } catch (Exception e4) {
                C4904y.m18635a(e4, getClass().getSimpleName());
                bitmapM18148a = null;
            }
            return bitmapM18148a;
        } catch (InterruptedException e5) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e5, f13271b);
            }
            return null;
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Value: " + obj, CallableC3675g.class.getSimpleName());
        }
        try {
            try {
                if (obj != null) {
                    mo7449h().setScaleType(ImageView.ScaleType.FIT_XY);
                    if (obj instanceof Bitmap) {
                        if (((Bitmap) obj).isRecycled()) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b(" This bitmap is already recycled. ", CallableC3675g.class.getSimpleName());
                                return;
                            }
                            return;
                        }
                        mo7449h().setImageBitmap((Bitmap) obj);
                    } else if (obj instanceof Drawable) {
                        mo7449h().setImageDrawable((Drawable) obj);
                    }
                    if (this.f13273c && this.f13275e != null) {
                        if (C4809aa.m18104a().m18121a("new_promotion_ids", "").contains(this.f13274d)) {
                            this.f13275e.setVisibility(0);
                            return;
                        } else {
                            this.f13275e.setVisibility(8);
                            return;
                        }
                    }
                    return;
                }
                mo7449h().setImageResource(R.drawable.trunk_image_default);
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        } catch (OutOfMemoryError e2) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e2, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Object objG = mo7448g();
        if (objG != null && (objG instanceof Bitmap) && !((Bitmap) objG).isRecycled()) {
            ((Bitmap) objG).recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }
}
