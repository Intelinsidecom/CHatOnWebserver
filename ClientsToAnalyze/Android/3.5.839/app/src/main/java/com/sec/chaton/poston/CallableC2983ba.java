package com.sec.chaton.poston;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import com.sec.common.util.p133a.C5017a;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: PostONImageDispatcherTask.java */
/* renamed from: com.sec.chaton.poston.ba */
/* loaded from: classes.dex */
public class CallableC2983ba extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: i */
    private String f11087i;

    /* renamed from: j */
    private int f11088j;

    /* renamed from: k */
    private int f11089k;

    /* renamed from: m */
    private String f11090m;

    /* renamed from: n */
    private String f11091n;

    /* renamed from: o */
    private String f11092o;

    /* renamed from: p */
    private String f11093p;

    /* renamed from: q */
    private String f11094q;

    /* renamed from: r */
    private boolean f11095r;

    /* renamed from: s */
    private String f11096s;

    /* renamed from: t */
    private Handler f11097t;

    /* renamed from: u */
    private final int f11098u;

    /* renamed from: v */
    private final int f11099v;

    /* renamed from: l */
    private static String f11086l = C4873ck.m18502c() + "/poston/";

    /* renamed from: a */
    public static String f11081a = "mypage";

    /* renamed from: b */
    public static String f11082b = "pager";

    /* renamed from: c */
    public static String f11083c = "detail";

    /* renamed from: d */
    public static String f11084d = "before";

    /* renamed from: e */
    public static String f11085e = "after";

    public CallableC2983ba(String str, String str2, boolean z, String str3, String str4) {
        super(str + str4);
        this.f11093p = "PostONImageDispatcherTask";
        this.f11094q = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f11098u = (int) C5034k.m19088a(184.0f);
        this.f11099v = (int) C5034k.m19088a(220.0f);
        if (C4904y.f17872b) {
            C4904y.m18639b("PostONImageDispatcherTask Start ... key = " + str + str4, this.f11093p);
        }
        this.f11087i = str;
        this.f11090m = str2;
        this.f11091n = f11086l + this.f11090m;
        this.f11088j = R.drawable.rotate_emoticon_loading;
        this.f11089k = R.drawable.image_broken;
        this.f11095r = z;
        this.f11096s = str3;
        this.f11092o = this.f11087i.split("/")[r0.length - 1];
        C4904y.m18646e("mUrl: " + this.f11087i + " // mFileName: " + this.f11092o, this.f11093p);
    }

    public CallableC2983ba(String str, String str2, boolean z, String str3, String str4, Handler handler) {
        super(str + str4);
        this.f11093p = "PostONImageDispatcherTask";
        this.f11094q = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f11098u = (int) C5034k.m19088a(184.0f);
        this.f11099v = (int) C5034k.m19088a(220.0f);
        if (C4904y.f17872b) {
            C4904y.m18639b("PostONImageDispatcherTask Start ... key = " + str + str4, this.f11093p);
        }
        this.f11087i = str;
        this.f11090m = str2;
        this.f11091n = f11086l + this.f11090m;
        this.f11088j = R.drawable.rotate_emoticon_loading;
        this.f11089k = R.drawable.image_broken;
        this.f11095r = z;
        this.f11096s = str3;
        this.f11097t = handler;
        this.f11092o = this.f11087i.split("/")[r0.length - 1];
        C4904y.m18646e("mUrl: " + this.f11087i + " // mFileName: " + this.f11092o, this.f11093p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo7449h = mo7449h();
        Drawable drawable = m18997k().getResources().getDrawable(this.f11088j);
        imageViewMo7449h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo7449h.setImageDrawable(drawable);
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
        imageViewMo7449h.setImageBitmap(null);
        imageViewMo7449h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo7449h.setBackgroundColor(0);
        m18993a(this, 500L);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws IOException {
        Bitmap bitmapM12351a;
        File file = new File(this.f11091n, this.f11092o);
        try {
            if (this.f11095r) {
                C5017a.m19064a().m19067a(this.f11087i + this.f11094q, file);
                bitmapM12351a = C4812ad.m18148a(Uri.fromFile(file));
                if (bitmapM12351a != null) {
                    bitmapM12351a.setDensity(160);
                }
            } else if (file.exists()) {
                bitmapM12351a = m12351a(new File(this.f11091n + "/thumbnail/" + this.f11092o), file);
                if (bitmapM12351a != null) {
                    bitmapM12351a.setDensity(160);
                }
            } else {
                bitmapM12351a = null;
            }
            return bitmapM12351a;
        } catch (InterruptedException e) {
            C4904y.m18635a(e, this.f11093p);
            return null;
        }
    }

    /* renamed from: a */
    private Bitmap m12351a(File file, File file2) {
        try {
            return C4894o.m18598a(CommonApplication.m18732r(), file2, false, false, true);
        } catch (OutOfMemoryError e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e, this.f11093p);
            return null;
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo7448g());
            bitmapDrawable.setAntiAlias(true);
            drawable = bitmapDrawable;
        } else if (!this.f11095r) {
            drawable = m18997k().getResources().getDrawable(R.drawable.trunk_no_veido_default);
        } else {
            drawable = m18997k().getResources().getDrawable(this.f11089k);
        }
        mo7449h().setImageDrawable(drawable);
        if (obj != null) {
            if (this.f11096s.equals(f11081a)) {
                mo7449h().setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (drawable != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mo7449h().getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.f11098u;
                    mo7449h().setLayoutParams(layoutParams);
                    mo7449h().invalidate();
                }
            } else if (this.f11096s.equals(f11083c)) {
                mo7449h().setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (drawable != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) mo7449h().getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = this.f11099v;
                    mo7449h().setLayoutParams(layoutParams2);
                    mo7449h().invalidate();
                }
            } else if (this.f11096s.equals(f11082b)) {
                mo7449h().setScaleType(ImageView.ScaleType.FIT_CENTER);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) mo7449h().getLayoutParams();
                layoutParams3.width = -1;
                layoutParams3.height = -1;
                mo7449h().setLayoutParams(layoutParams3);
                mo7449h().invalidate();
            }
            if (this.f11097t != null && this.f11095r && obj != null) {
                this.f11097t.sendMessage(Message.obtain(this.f11097t, 0, null));
            }
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Bitmap bitmapMo7448g = mo7448g();
        m18990a((View) null);
        if (bitmapMo7448g != null && !bitmapMo7448g.isRecycled()) {
            bitmapMo7448g.recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo7448g() {
        return (Bitmap) super.mo7448g();
    }
}
