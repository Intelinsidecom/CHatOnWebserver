package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.p070a.C3332a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: BuddyProfileImageDispatcherTask.java */
/* renamed from: com.sec.chaton.buddy.fi */
/* loaded from: classes.dex */
public class CallableC0698fi extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    private String f2925a;

    /* renamed from: b */
    private ImageView f2926b;

    /* renamed from: c */
    private int f2927c;

    /* renamed from: d */
    private int f2928d;

    /* renamed from: e */
    private int f2929e;

    /* renamed from: i */
    private int f2930i;

    /* renamed from: j */
    private boolean f2931j;

    /* renamed from: k */
    private String f2932k;

    /* renamed from: l */
    private String f2933l;

    /* renamed from: m */
    private boolean f2934m;

    /* renamed from: n */
    private boolean f2935n;

    /* renamed from: o */
    private String f2936o;

    public CallableC0698fi(ImageView imageView, String str, int i, int i2, String str2, String str3) {
        super(str);
        this.f2925a = "BuddyProfileImageDispatcherTask";
        this.f2926b = null;
        this.f2936o = "";
        this.f2929e = i;
        this.f2930i = i2;
        this.f2932k = str2;
        this.f2933l = str3;
        this.f2926b = imageView;
        this.f2934m = false;
        this.f2931j = false;
        this.f2927c = R.drawable.rotate_emoticon_loading;
        this.f2928d = R.drawable.profile_photo_buddy_default;
    }

    public CallableC0698fi(ImageView imageView, String str, int i, int i2, String str2, String str3, boolean z) {
        super(str);
        this.f2925a = "BuddyProfileImageDispatcherTask";
        this.f2926b = null;
        this.f2936o = "";
        this.f2929e = i;
        this.f2930i = i2;
        this.f2932k = str2;
        this.f2933l = str3;
        this.f2926b = imageView;
        this.f2934m = z;
        this.f2931j = false;
        this.f2927c = R.drawable.rotate_emoticon_loading;
        this.f2928d = R.drawable.profile_photo_buddy_default;
    }

    public CallableC0698fi(ImageView imageView, String str, int i, int i2, String str2, String str3, boolean z, boolean z2) {
        super(str);
        this.f2925a = "BuddyProfileImageDispatcherTask";
        this.f2926b = null;
        this.f2936o = "";
        this.f2929e = i;
        this.f2930i = i2;
        this.f2932k = str2;
        this.f2933l = str3;
        this.f2926b = imageView;
        this.f2934m = z;
        this.f2931j = false;
        this.f2935n = z2;
        this.f2936o = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f2927c = R.drawable.rotate_emoticon_loading;
        this.f2928d = R.drawable.profile_photo_buddy_default;
    }

    public CallableC0698fi(String str, String str2, String str3) {
        super(str);
        this.f2925a = "BuddyProfileImageDispatcherTask";
        this.f2926b = null;
        this.f2936o = "";
        this.f2929e = 0;
        this.f2930i = 0;
        this.f2932k = str2;
        this.f2933l = str3;
        this.f2926b = null;
        this.f2934m = false;
        this.f2931j = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo4338h = mo4338h();
        if (!this.f2931j) {
            Drawable drawable = m11714k().getResources().getDrawable(this.f2927c);
            if (this.f2926b == null) {
                imageViewMo4338h.setImageDrawable(drawable);
            } else {
                this.f2926b.setVisibility(8);
                this.f2926b.setImageDrawable(drawable);
            }
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        m11711a(this, 500L);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        Bitmap bitmapM10999a;
        try {
            try {
                File file = new File(this.f2932k, this.f2933l);
                if (!file.exists() || file.length() == 0) {
                    C3332a.m11750a().m11753a(mo7454i(), file);
                }
                if (!this.f2931j) {
                    if (!this.f2934m) {
                        bitmapM10999a = C3162ad.m11000a(m11714k(), file.getAbsolutePath());
                    } else {
                        bitmapM10999a = C3162ad.m11000a(m11714k(), file.getAbsolutePath());
                    }
                } else {
                    bitmapM10999a = C3162ad.m10999a(m11714k(), Uri.fromFile(file), 66, 44);
                }
                if (bitmapM10999a != null) {
                    bitmapM10999a.setDensity(160);
                }
                if (this.f2935n) {
                    Uri uriM11004a = C3162ad.m11004a(C3162ad.m11006a(bitmapM10999a), "myprofile.png_");
                    if (uriM11004a == null) {
                        C3250y.m11442a("saveByteArrayOutputStreamToFileForProfile returns null", this.f2925a);
                        return bitmapM10999a;
                    }
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM10999a, 288, 288, true);
                    C3205bt.m11182a(CommonApplication.m11493l()).m11227b(this.f2936o);
                    C3205bt.m11182a(CommonApplication.m11493l()).m11224b(bitmapCreateScaledBitmap, this.f2936o);
                    if (new File(uriM11004a.getPath()).length() > 0) {
                        C3159aa.m10966a("profile_image_status", "updated");
                        return bitmapM10999a;
                    }
                    C3250y.m11442a("File length is 0:" + uriM11004a.getPath(), "ProfileUploadTask");
                    return bitmapM10999a;
                }
                return bitmapM10999a;
            } catch (InterruptedException e) {
                return null;
            } catch (OutOfMemoryError e2) {
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                C3250y.m11443a(e2, getClass().getSimpleName());
                return null;
            }
        } catch (Exception e3) {
            C3250y.m11443a(e3, getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        try {
            if (obj != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(mo4337g());
                bitmapDrawable.setAntiAlias(true);
                drawable = bitmapDrawable;
            } else if (!this.f2931j) {
                if (this.f2934m) {
                    drawable = m11714k().getResources().getDrawable(this.f2928d);
                } else {
                    mo4338h().setVisibility(8);
                    return;
                }
            } else {
                drawable = null;
            }
            if (this.f2926b != null) {
                this.f2926b.setVisibility(8);
            }
            if (z) {
                if (drawable != null) {
                    mo4338h().setImageDrawable(drawable);
                }
            } else if (drawable != null) {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable});
                mo4338h().setImageDrawable(transitionDrawable);
                transitionDrawable.startTransition(100);
            }
        } catch (NullPointerException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
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
