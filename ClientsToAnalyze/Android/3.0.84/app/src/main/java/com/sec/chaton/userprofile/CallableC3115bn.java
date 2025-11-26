package com.sec.chaton.userprofile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.ZoomableImageView;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3348j;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: ProfileImageDispatcherTask.java */
/* renamed from: com.sec.chaton.userprofile.bn */
/* loaded from: classes.dex */
public class CallableC3115bn extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    boolean f11333a;

    /* renamed from: b */
    private String f11334b;

    /* renamed from: c */
    private int f11335c;

    /* renamed from: d */
    private int f11336d;

    /* renamed from: e */
    private int f11337e;

    /* renamed from: i */
    private int f11338i;

    /* renamed from: j */
    private String f11339j;

    /* renamed from: k */
    private String f11340k;

    /* renamed from: l */
    private ImageView f11341l;

    /* renamed from: m */
    private ImageView f11342m;

    /* renamed from: n */
    private String f11343n;

    /* renamed from: o */
    private boolean f11344o;

    /* renamed from: p */
    private String f11345p;

    /* renamed from: q */
    private boolean f11346q;

    /* renamed from: r */
    private boolean f11347r;

    /* renamed from: s */
    private Handler f11348s;

    public CallableC3115bn(ImageView imageView, String str, int i, int i2, String str2, String str3) {
        super(str);
        this.f11334b = "ProfileImageDispatcherTask";
        this.f11341l = null;
        this.f11342m = null;
        this.f11345p = "";
        this.f11337e = i;
        this.f11338i = i2;
        this.f11339j = str2;
        this.f11340k = str3;
        this.f11343n = str;
        this.f11341l = imageView;
        this.f11335c = R.drawable.rotate_emoticon_loading;
        this.f11336d = R.drawable.chat_anicon_btn_failed;
    }

    public CallableC3115bn(ImageView imageView, String str, int i, int i2, String str2, String str3, boolean z, Handler handler) {
        super(str);
        this.f11334b = "ProfileImageDispatcherTask";
        this.f11341l = null;
        this.f11342m = null;
        this.f11345p = "";
        this.f11337e = i;
        this.f11338i = i2;
        this.f11339j = str2;
        this.f11340k = str3;
        this.f11343n = str;
        this.f11344o = z;
        this.f11345p = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f11346q = true;
        this.f11347r = z;
        this.f11341l = imageView;
        this.f11348s = handler;
        this.f11335c = R.drawable.rotate_emoticon_loading;
        this.f11336d = R.drawable.chat_anicon_btn_failed;
    }

    public CallableC3115bn(ImageView imageView, ImageView imageView2, String str, int i, int i2, String str2, String str3, boolean z) {
        super(str);
        this.f11334b = "ProfileImageDispatcherTask";
        this.f11341l = null;
        this.f11342m = null;
        this.f11345p = "";
        this.f11337e = i;
        this.f11338i = i2;
        this.f11339j = str2;
        this.f11340k = str3;
        this.f11343n = str;
        this.f11341l = imageView;
        this.f11342m = imageView2;
        this.f11344o = z;
        this.f11335c = R.drawable.rotate_emoticon_loading;
        this.f11336d = R.drawable.chat_anicon_btn_failed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        mo4338h();
        Drawable drawable = m11714k().getResources().getDrawable(this.f11335c);
        if (this.f11341l != null) {
            this.f11341l.setVisibility(0);
            this.f11341l.setImageDrawable(drawable);
        }
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        if (this.f11342m != null) {
            this.f11342m.setVisibility(8);
        }
        m11711a(this, 500L);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws Throwable {
        File file = new File(this.f11339j, this.f11340k);
        try {
            if (this.f11342m != null) {
                this.f11342m.setVisibility(8);
            }
            C3332a.m11750a().m11753a(this.f11343n, file);
            Bitmap bitmapM11003a = C3162ad.m11003a(Uri.fromFile(file));
            if (bitmapM11003a != null) {
                bitmapM11003a.setDensity(160);
            }
            if (this.f11344o) {
                Uri uriM11004a = C3162ad.m11004a(C3162ad.m11006a(C3348j.m11791a(m11714k(), file, this.f11337e, this.f11338i)), "myprofile.png_");
                if (uriM11004a == null) {
                    C3250y.m11442a("saveByteArrayOutputStreamToFileForProfile returns null", this.f11334b);
                    return bitmapM11003a;
                }
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM11003a, 288, 288, true);
                C3205bt.m11182a(CommonApplication.m11493l()).m11227b(this.f11345p);
                C3205bt.m11182a(CommonApplication.m11493l()).m11224b(bitmapCreateScaledBitmap, this.f11345p);
                if (new File(uriM11004a.getPath()).length() > 0) {
                    C3159aa.m10966a("profile_image_status", "updated");
                    return bitmapM11003a;
                }
                C3250y.m11442a("File length is 0:" + uriM11004a.getPath(), "ProfileUploadTask");
                return bitmapM11003a;
            }
            return bitmapM11003a;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Boolean bool;
        Drawable drawable;
        Boolean.valueOf(false);
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo4337g());
            bitmapDrawable.setAntiAlias(true);
            bool = false;
            drawable = bitmapDrawable;
        } else {
            bool = true;
            drawable = m11714k().getResources().getDrawable(this.f11336d);
        }
        if (this.f11341l != null) {
            this.f11341l.setVisibility(8);
        }
        if (z || this.f11333a) {
            mo4338h();
            if (!bool.booleanValue() || this.f11342m == null) {
                if (this.f11342m != null) {
                    this.f11342m.setVisibility(8);
                }
                mo4338h().setImageDrawable(drawable);
            } else {
                this.f11342m.setVisibility(0);
                this.f11342m.setImageDrawable(drawable);
            }
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable});
            if (!bool.booleanValue() || this.f11342m == null) {
                if (this.f11342m != null) {
                    this.f11342m.setVisibility(8);
                }
                mo4338h().setImageDrawable(transitionDrawable);
            } else {
                mo4338h().setImageDrawable(null);
                this.f11342m.setVisibility(0);
                this.f11342m.setImageDrawable(transitionDrawable);
            }
            transitionDrawable.startTransition(100);
        }
        if (this.f11348s != null) {
            this.f11348s.sendMessage(Message.obtain(this.f11348s, 0, null));
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        if (this.f11342m != null) {
            this.f11342m.setVisibility(8);
        }
        Bitmap bitmapMo4337g = mo4337g();
        m11708a((View) null);
        if (bitmapMo4337g != null && !bitmapMo4337g.isRecycled()) {
            bitmapMo4337g.recycle();
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        View viewMo4338h = super.mo4338h();
        if (viewMo4338h instanceof ZoomableImageView) {
            this.f11333a = true;
        } else {
            this.f11333a = false;
        }
        return (ImageView) viewMo4338h;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo4337g() {
        return (Bitmap) super.mo4337g();
    }
}
