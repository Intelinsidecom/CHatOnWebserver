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
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import com.sec.common.util.p133a.C5017a;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: MoreDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.f */
/* loaded from: classes.dex */
public class CallableC3674f extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: b */
    private static final String f13264b = CallableC3674f.class.getSimpleName();

    /* renamed from: a */
    Uri f13265a;

    /* renamed from: c */
    private Context f13266c;

    /* renamed from: d */
    private ImageView f13267d;

    /* renamed from: e */
    private String f13268e;

    /* renamed from: i */
    private ImageView f13269i;

    /* renamed from: j */
    private boolean f13270j;

    public CallableC3674f(String str, Context context, String str2, C3673e c3673e) {
        super(str);
        this.f13266c = context;
        this.f13267d = c3673e.f13260a;
        this.f13268e = str2;
        this.f13269i = c3673e.f13262c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageView = this.f13267d;
        Drawable drawable = m18997k().getResources().getDrawable(R.drawable.rotate_emoticon_loading);
        imageView.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        ImageView imageView = this.f13267d;
        imageView.setImageBitmap(null);
        imageView.setBackgroundColor(0);
        m18993a(this, 500L);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws IOException {
        Bitmap bitmapM18148a;
        if (TextUtils.isEmpty(m18996j())) {
            return null;
        }
        if (C5034k.m19095a(this.f13266c, this.f13268e)) {
            this.f13270j = true;
        } else {
            this.f13270j = false;
        }
        File file = new File(C5017a.m19065a(m18997k()), String.valueOf(m18996j().hashCode()));
        this.f13265a = Uri.parse(file.toString());
        try {
            C5017a.m19064a().m19067a(m18996j(), file);
            try {
                try {
                    if (file.exists()) {
                        bitmapM18148a = C4812ad.m18148a(this.f13265a);
                    } else {
                        try {
                            bitmapM18148a = C4812ad.m18148a(this.f13265a);
                        } catch (Exception e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                            bitmapM18148a = null;
                        } catch (OutOfMemoryError e2) {
                            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                            C4904y.m18635a(e2, getClass().getSimpleName());
                            bitmapM18148a = null;
                        }
                    }
                } catch (Exception e3) {
                    C4904y.m18635a(e3, getClass().getSimpleName());
                    bitmapM18148a = null;
                }
            } catch (OutOfMemoryError e4) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                C4904y.m18635a(e4, getClass().getSimpleName());
                bitmapM18148a = null;
            }
            return bitmapM18148a;
        } catch (InterruptedException e5) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e5, f13264b);
            }
            return null;
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Value: " + obj, CallableC3674f.class.getSimpleName());
        }
        try {
            if (obj != null) {
                if (obj instanceof Bitmap) {
                    if (((Bitmap) obj).isRecycled()) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b(" This bitmap is already recycled. ", CallableC3674f.class.getSimpleName());
                            return;
                        }
                        return;
                    }
                    this.f13267d.setImageBitmap((Bitmap) obj);
                } else if (obj instanceof Drawable) {
                    this.f13267d.setImageDrawable((Drawable) obj);
                }
                if (this.f13270j) {
                    this.f13269i.setVisibility(8);
                    return;
                } else {
                    this.f13269i.setVisibility(0);
                    return;
                }
            }
            this.f13267d.setImageResource(R.drawable.trunk_image_default);
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        } catch (OutOfMemoryError e2) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e2, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: i */
    public boolean mo11696i() {
        return true;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Object objG = mo7448g();
        if (objG != null && (objG instanceof Bitmap) && !((Bitmap) objG).isRecycled()) {
            ((Bitmap) objG).recycle();
        }
    }
}
