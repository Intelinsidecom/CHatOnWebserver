package com.sec.chaton.settings.moreapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3347i;
import com.sec.common.util.p070a.C3332a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: MoreDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.c */
/* loaded from: classes.dex */
public class CallableC2713c extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: b */
    private static final String f10026b = CallableC2713c.class.getSimpleName();

    /* renamed from: a */
    Uri f10027a;

    /* renamed from: c */
    private Context f10028c;

    /* renamed from: d */
    private ImageView f10029d;

    /* renamed from: e */
    private String f10030e;

    /* renamed from: i */
    private ImageView f10031i;

    /* renamed from: j */
    private boolean f10032j;

    public CallableC2713c(String str, Context context, String str2, C2712b c2712b) {
        super(str);
        this.f10028c = context;
        this.f10029d = c2712b.f10022a;
        this.f10030e = str2;
        this.f10031i = c2712b.f10024c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageView = this.f10029d;
        Drawable drawable = m11714k().getResources().getDrawable(R.drawable.rotate_emoticon_loading);
        imageView.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        ImageView imageView = this.f10029d;
        imageView.setImageBitmap(null);
        imageView.setBackgroundColor(0);
        m11711a(this, 500L);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        Bitmap bitmapM11003a;
        if (TextUtils.isEmpty(mo7454i())) {
            return null;
        }
        if (C3347i.m11778a(this.f10028c, this.f10030e)) {
            this.f10032j = true;
        } else {
            this.f10032j = false;
        }
        File file = new File(C3332a.m11751a(m11714k()), String.valueOf(mo7454i().hashCode()));
        this.f10027a = Uri.parse(file.toString());
        try {
            C3332a.m11750a().m11753a(mo7454i(), file);
            if (file == null) {
                return null;
            }
            try {
                if (file.exists()) {
                    bitmapM11003a = C3162ad.m11003a(this.f10027a);
                } else {
                    try {
                        bitmapM11003a = C3162ad.m11003a(this.f10027a);
                    } catch (Exception e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                        bitmapM11003a = null;
                    } catch (OutOfMemoryError e2) {
                        C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                        C3250y.m11443a(e2, getClass().getSimpleName());
                        bitmapM11003a = null;
                    }
                }
            } catch (Exception e3) {
                C3250y.m11443a(e3, getClass().getSimpleName());
                bitmapM11003a = null;
            } catch (OutOfMemoryError e4) {
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                C3250y.m11443a(e4, getClass().getSimpleName());
                bitmapM11003a = null;
            }
            return bitmapM11003a;
        } catch (InterruptedException e5) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e5, f10026b);
            }
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("Value: " + obj, CallableC2713c.class.getSimpleName());
        }
        try {
            if (obj != null) {
                if (obj instanceof Bitmap) {
                    if (((Bitmap) obj).isRecycled()) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b(" This bitmap is already recycled. ", CallableC2713c.class.getSimpleName());
                            return;
                        }
                        return;
                    }
                    this.f10029d.setImageBitmap((Bitmap) obj);
                } else if (obj instanceof Drawable) {
                    this.f10029d.setImageDrawable((Drawable) obj);
                }
                if (this.f10032j) {
                    this.f10031i.setVisibility(0);
                    return;
                } else {
                    this.f10031i.setVisibility(8);
                    return;
                }
            }
            this.f10029d.setImageResource(R.drawable.trunk_image_default);
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e2, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: j */
    public boolean mo7491j() {
        return true;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Object objG = mo4337g();
        if (objG != null && (objG instanceof Bitmap) && !((Bitmap) objG).isRecycled()) {
            ((Bitmap) objG).recycle();
        }
    }
}
