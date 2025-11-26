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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.p070a.C3332a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: PostONImageDispatcherTask.java */
/* renamed from: com.sec.chaton.poston.az */
/* loaded from: classes.dex */
public class CallableC1986az extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: i */
    private String f7688i;

    /* renamed from: j */
    private int f7689j;

    /* renamed from: k */
    private int f7690k;

    /* renamed from: m */
    private String f7691m;

    /* renamed from: n */
    private String f7692n;

    /* renamed from: o */
    private String f7693o;

    /* renamed from: p */
    private String f7694p;

    /* renamed from: q */
    private String f7695q;

    /* renamed from: r */
    private boolean f7696r;

    /* renamed from: s */
    private String f7697s;

    /* renamed from: t */
    private Handler f7698t;

    /* renamed from: u */
    private final int f7699u;

    /* renamed from: v */
    private final int f7700v;

    /* renamed from: l */
    private static String f7687l = C3223ck.m11329c() + "/poston/";

    /* renamed from: a */
    public static String f7682a = "mypage";

    /* renamed from: b */
    public static String f7683b = "pager";

    /* renamed from: c */
    public static String f7684c = "detail";

    /* renamed from: d */
    public static String f7685d = "before";

    /* renamed from: e */
    public static String f7686e = "after";

    public CallableC1986az(String str, String str2, boolean z, String str3, String str4) {
        super(str + str4);
        this.f7694p = "PostONImageDispatcherTask";
        this.f7695q = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f7699u = (int) C3172an.m11085a(184.0f);
        this.f7700v = (int) C3172an.m11085a(220.0f);
        if (C3250y.f11734b) {
            C3250y.m11450b("PostONImageDispatcherTask Start ... key = " + str + str4, this.f7694p);
        }
        this.f7688i = str;
        this.f7691m = str2;
        this.f7692n = f7687l + this.f7691m;
        this.f7689j = R.drawable.rotate_emoticon_loading;
        this.f7690k = R.drawable.chat_anicon_btn_failed;
        this.f7696r = z;
        this.f7697s = str3;
        this.f7693o = this.f7688i.split("/")[r0.length - 1];
        C3250y.m11456e("mUrl: " + this.f7688i + " // mFileName: " + this.f7693o, this.f7694p);
    }

    public CallableC1986az(String str, String str2, boolean z, String str3, String str4, Handler handler) {
        super(str + str4);
        this.f7694p = "PostONImageDispatcherTask";
        this.f7695q = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f7699u = (int) C3172an.m11085a(184.0f);
        this.f7700v = (int) C3172an.m11085a(220.0f);
        if (C3250y.f11734b) {
            C3250y.m11450b("PostONImageDispatcherTask Start ... key = " + str + str4, this.f7694p);
        }
        this.f7688i = str;
        this.f7691m = str2;
        this.f7692n = f7687l + this.f7691m;
        this.f7689j = R.drawable.rotate_emoticon_loading;
        this.f7690k = R.drawable.chat_anicon_btn_failed;
        this.f7696r = z;
        this.f7697s = str3;
        this.f7698t = handler;
        this.f7693o = this.f7688i.split("/")[r0.length - 1];
        C3250y.m11456e("mUrl: " + this.f7688i + " // mFileName: " + this.f7693o, this.f7694p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo4338h = mo4338h();
        Drawable drawable = m11714k().getResources().getDrawable(this.f7689j);
        imageViewMo4338h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo4338h.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        ImageView imageViewMo4338h = mo4338h();
        imageViewMo4338h.setImageBitmap(null);
        imageViewMo4338h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo4338h.setBackgroundColor(0);
        m11711a(this, 500L);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws IOException {
        Bitmap bitmapM8031a;
        File file = new File(this.f7692n, this.f7693o);
        try {
            if (this.f7696r) {
                C3332a.m11750a().m11753a(this.f7688i + this.f7695q, file);
                bitmapM8031a = C3162ad.m11003a(Uri.fromFile(file));
                if (bitmapM8031a != null) {
                    bitmapM8031a.setDensity(160);
                }
            } else if (file.exists()) {
                bitmapM8031a = m8031a(new File(this.f7692n + "/thumbnail/" + this.f7693o), file);
                if (bitmapM8031a != null) {
                    bitmapM8031a.setDensity(160);
                }
            } else {
                bitmapM8031a = null;
            }
            return bitmapM8031a;
        } catch (InterruptedException e) {
            C3250y.m11443a(e, this.f7694p);
            return null;
        }
    }

    /* renamed from: a */
    private Bitmap m8031a(File file, File file2) {
        try {
            return C3243r.m11414a(CommonApplication.m11493l(), file2, false, false, true);
        } catch (OutOfMemoryError e) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e, this.f7694p);
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo4337g());
            bitmapDrawable.setAntiAlias(true);
            drawable = bitmapDrawable;
        } else if (!this.f7696r) {
            drawable = m11714k().getResources().getDrawable(R.drawable.trunk_no_veido_default);
        } else {
            drawable = m11714k().getResources().getDrawable(this.f7690k);
        }
        mo4338h().setScaleType(ImageView.ScaleType.CENTER_CROP);
        mo4338h().setImageDrawable(drawable);
        if (this.f7697s.equals(f7682a)) {
            mo4338h().setScaleType(GlobalApplication.m6456e() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.CENTER_CROP);
            if (drawable != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mo4338h().getLayoutParams();
                layoutParams.width = GlobalApplication.m6456e() ? m11714k().getResources().getDimensionPixelSize(R.dimen.poston_post_photo_width) : -1;
                layoutParams.height = GlobalApplication.m6456e() ? m11714k().getResources().getDimensionPixelSize(R.dimen.poston_post_photo_height) : this.f7699u;
                mo4338h().setLayoutParams(layoutParams);
                mo4338h().invalidate();
            }
        } else if (this.f7697s.equals(f7684c)) {
            mo4338h().setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (drawable != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) mo4338h().getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = this.f7700v;
                mo4338h().setLayoutParams(layoutParams2);
                mo4338h().invalidate();
            }
        } else if (this.f7697s.equals(f7683b)) {
            mo4338h().setScaleType(ImageView.ScaleType.FIT_CENTER);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) mo4338h().getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            mo4338h().setLayoutParams(layoutParams3);
            mo4338h().invalidate();
        }
        if (this.f7698t != null && this.f7696r && obj != null) {
            this.f7698t.sendMessage(Message.obtain(this.f7698t, 0, null));
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Bitmap bitmapMo4337g = mo4337g();
        m11708a((View) null);
        if (bitmapMo4337g != null && !bitmapMo4337g.isRecycled()) {
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
