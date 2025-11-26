package com.sec.chaton.userprofile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.ZoomableImageView;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5035l;
import com.sec.common.util.C5051q;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: ProfileImageDispatcherTask.java */
/* renamed from: com.sec.chaton.userprofile.bt */
/* loaded from: classes.dex */
public class CallableC4761bt extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: a */
    boolean f17452a;

    /* renamed from: b */
    private String f17453b;

    /* renamed from: c */
    private int f17454c;

    /* renamed from: d */
    private int f17455d;

    /* renamed from: e */
    private int f17456e;

    /* renamed from: i */
    private int f17457i;

    /* renamed from: j */
    private String f17458j;

    /* renamed from: k */
    private String f17459k;

    /* renamed from: l */
    private ImageView f17460l;

    /* renamed from: m */
    private ImageView f17461m;

    /* renamed from: n */
    private String f17462n;

    /* renamed from: o */
    private boolean f17463o;

    /* renamed from: p */
    private String f17464p;

    /* renamed from: q */
    private Handler f17465q;

    /* renamed from: r */
    private String f17466r;

    /* renamed from: s */
    private int f17467s;

    /* renamed from: t */
    private boolean f17468t;

    public CallableC4761bt(ImageView imageView, String str, int i, int i2, String str2, String str3) {
        super(str);
        this.f17453b = "ProfileImageDispatcherTask";
        this.f17460l = null;
        this.f17461m = null;
        this.f17464p = "";
        this.f17467s = -1;
        this.f17468t = false;
        this.f17456e = i;
        this.f17457i = i2;
        this.f17458j = str2;
        this.f17459k = str3;
        this.f17462n = str;
        this.f17460l = imageView;
        this.f17454c = R.drawable.rotate_emoticon_loading;
        this.f17455d = R.drawable.image_broken;
    }

    public CallableC4761bt(ImageView imageView, ImageView imageView2, String str, int i, int i2, String str2, String str3, boolean z) {
        super(str);
        this.f17453b = "ProfileImageDispatcherTask";
        this.f17460l = null;
        this.f17461m = null;
        this.f17464p = "";
        this.f17467s = -1;
        this.f17468t = false;
        this.f17456e = i;
        this.f17457i = i2;
        this.f17458j = str2;
        this.f17459k = str3;
        this.f17462n = str;
        this.f17460l = imageView;
        this.f17461m = imageView2;
        this.f17463o = z;
        this.f17454c = R.drawable.rotate_emoticon_loading;
        this.f17455d = R.drawable.image_broken;
    }

    public CallableC4761bt(ImageView imageView, ImageView imageView2, String str, int i, int i2, String str2, String str3, boolean z, Handler handler) {
        super(str);
        this.f17453b = "ProfileImageDispatcherTask";
        this.f17460l = null;
        this.f17461m = null;
        this.f17464p = "";
        this.f17467s = -1;
        this.f17468t = false;
        this.f17456e = i;
        this.f17457i = i2;
        this.f17458j = str2;
        this.f17459k = str3;
        this.f17462n = str;
        this.f17460l = imageView;
        this.f17461m = imageView2;
        this.f17463o = z;
        this.f17465q = handler;
        this.f17454c = R.drawable.rotate_emoticon_loading;
        this.f17455d = R.drawable.chat_anicon_btn_failed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        mo7449h();
        Drawable drawable = m18997k().getResources().getDrawable(this.f17454c);
        if (this.f17460l != null) {
            this.f17460l.setVisibility(0);
            this.f17460l.setImageDrawable(drawable);
        }
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        if (this.f17461m != null) {
            this.f17461m.setVisibility(8);
        }
        m18993a(this, 500L);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws Throwable {
        File file = new File(this.f17458j, this.f17459k);
        if (!file.exists() || file.length() == 0) {
            try {
                C5017a.m19064a().m19067a(this.f17462n, file).exists();
            } catch (InterruptedException e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Error image Exception : " + this.f17458j + this.f17459k + "//// : " + e, this.f17453b);
                }
            }
        }
        if (this.f17461m != null) {
            this.f17461m.setVisibility(8);
        }
        Bitmap bitmapM18148a = C4812ad.m18148a(Uri.fromFile(file));
        if (bitmapM18148a != null) {
            bitmapM18148a.setDensity(160);
            if (this.f17463o) {
                C4855bt.m18351a(CommonApplication.m18732r()).m18358a();
                Uri uriM18149a = C4812ad.m18149a(C4812ad.m18151a(C5035l.m19109a(m18997k(), file, this.f17456e, this.f17457i)), "myprofile.png_");
                if (uriM18149a == null) {
                    C4904y.m18634a("saveByteArrayOutputStreamToFileForProfile returns null", this.f17453b);
                } else if (new File(uriM18149a.getPath()).length() > 0) {
                    C4809aa.m18108a("profile_image_status", "updated");
                } else {
                    C4904y.m18634a("File length is 0:" + uriM18149a.getPath(), "ProfileUploadTask");
                }
            }
        } else if (C4904y.f17872b) {
            C4904y.m18639b("Error image bitmap = null", this.f17453b);
        }
        return bitmapM18148a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        Boolean bool;
        BitmapDrawable bitmapDrawable;
        Boolean.valueOf(false);
        if (C4904y.f17872b) {
            C4904y.m18639b("onPostDispatch.. ", this.f17453b);
        }
        switch (this.f17467s) {
            case 0:
                C4809aa.m18108a("profile_small_image0", this.f17466r);
                break;
            case 1:
                C4809aa.m18108a("profile_small_image1", this.f17466r);
                break;
            case 2:
                C4809aa.m18108a("profile_small_image2", this.f17466r);
                break;
            case 3:
                C4809aa.m18108a("profile_small_image3", this.f17466r);
                break;
        }
        if (obj != null) {
            if (this.f17468t) {
                C5051q c5051q = new C5051q(mo7448g());
                c5051q.m19198a(true);
                bitmapDrawable = c5051q;
            } else {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(mo7448g());
                bitmapDrawable2.setAntiAlias(true);
                bitmapDrawable = bitmapDrawable2;
            }
            drawable2 = bitmapDrawable;
            bool = false;
        } else {
            if (this.f17468t) {
                C5051q c5051q2 = new C5051q(BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), this.f17455d));
                c5051q2.m19198a(true);
                drawable = c5051q2;
            } else {
                drawable = m18997k().getResources().getDrawable(this.f17455d);
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Error image 01", this.f17453b);
            }
            drawable2 = drawable;
            bool = true;
        }
        if (this.f17460l != null) {
            this.f17460l.setVisibility(8);
        }
        if (z || this.f17452a) {
            mo7449h();
            if (!bool.booleanValue() || this.f17461m == null) {
                if (this.f17461m != null) {
                    this.f17461m.setVisibility(8);
                }
                mo7449h().setImageDrawable(drawable2);
            } else {
                mo7449h().setImageBitmap(null);
                this.f17461m.setVisibility(0);
                this.f17461m.setImageDrawable(drawable2);
                if (C4904y.f17872b) {
                    C4904y.m18639b("Error image 02", this.f17453b);
                }
            }
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable2});
            if (!bool.booleanValue() || this.f17461m == null) {
                if (this.f17461m != null) {
                    this.f17461m.setVisibility(8);
                }
                mo7449h().setVisibility(0);
                mo7449h().setImageDrawable(transitionDrawable);
            } else {
                mo7449h().setImageDrawable(null);
                this.f17461m.setVisibility(0);
                this.f17461m.setImageDrawable(transitionDrawable);
                if (C4904y.f17872b) {
                    C4904y.m18639b("Error image 03", this.f17453b);
                }
            }
            transitionDrawable.startTransition(100);
        }
        if (this.f17465q != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("download_success", !bool.booleanValue());
            bundle.putString("filename_id", this.f17459k);
            this.f17465q.sendMessage(Message.obtain(this.f17465q, 0, bundle));
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        if (this.f17461m != null) {
            this.f17461m.setVisibility(8);
        }
        Bitmap bitmapMo7448g = mo7448g();
        m18990a((View) null);
        if (bitmapMo7448g != null && !bitmapMo7448g.isRecycled()) {
            bitmapMo7448g.recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        View viewMo7449h = super.mo7449h();
        if (viewMo7449h instanceof ZoomableImageView) {
            this.f17452a = true;
        } else {
            this.f17452a = false;
        }
        return (ImageView) viewMo7449h;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo7448g() {
        return (Bitmap) super.mo7448g();
    }
}
