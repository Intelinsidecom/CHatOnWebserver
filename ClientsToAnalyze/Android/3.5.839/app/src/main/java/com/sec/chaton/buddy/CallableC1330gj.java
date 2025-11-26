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
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.p133a.C5017a;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: BuddyProfileImageDispatcherTask.java */
/* renamed from: com.sec.chaton.buddy.gj */
/* loaded from: classes.dex */
public class CallableC1330gj extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: a */
    private String f4871a;

    /* renamed from: b */
    private ImageView f4872b;

    /* renamed from: c */
    private int f4873c;

    /* renamed from: d */
    private int f4874d;

    /* renamed from: e */
    private int f4875e;

    /* renamed from: i */
    private int f4876i;

    /* renamed from: j */
    private boolean f4877j;

    /* renamed from: k */
    private String f4878k;

    /* renamed from: l */
    private String f4879l;

    /* renamed from: m */
    private boolean f4880m;

    /* renamed from: n */
    private boolean f4881n;

    /* renamed from: o */
    private String f4882o;

    public CallableC1330gj(ImageView imageView, String str, int i, int i2, String str2, String str3) {
        super(str);
        this.f4871a = "BuddyProfileImageDispatcherTask";
        this.f4872b = null;
        this.f4882o = "";
        this.f4875e = i;
        this.f4876i = i2;
        this.f4878k = str2;
        this.f4879l = str3;
        this.f4872b = imageView;
        this.f4880m = false;
        this.f4877j = false;
        this.f4873c = R.drawable.rotate_emoticon_loading;
        this.f4874d = R.drawable.profile_photo_buddy_default;
    }

    public CallableC1330gj(ImageView imageView, String str, int i, int i2, String str2, String str3, boolean z) {
        super(str);
        this.f4871a = "BuddyProfileImageDispatcherTask";
        this.f4872b = null;
        this.f4882o = "";
        this.f4875e = i;
        this.f4876i = i2;
        this.f4878k = str2;
        this.f4879l = str3;
        this.f4872b = imageView;
        this.f4880m = z;
        this.f4877j = false;
        this.f4873c = R.drawable.rotate_emoticon_loading;
        this.f4874d = R.drawable.profile_photo_buddy_default;
    }

    public CallableC1330gj(String str, String str2, String str3) {
        super(str);
        this.f4871a = "BuddyProfileImageDispatcherTask";
        this.f4872b = null;
        this.f4882o = "";
        this.f4875e = 0;
        this.f4876i = 0;
        this.f4878k = str2;
        this.f4879l = str3;
        this.f4872b = null;
        this.f4880m = false;
        this.f4877j = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo7449h = mo7449h();
        if (!this.f4877j) {
            Drawable drawable = m18997k().getResources().getDrawable(this.f4873c);
            if (this.f4872b == null) {
                imageViewMo7449h.setImageDrawable(drawable);
            } else {
                this.f4872b.setVisibility(8);
                this.f4872b.setImageDrawable(drawable);
            }
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        m18993a(this, 500L);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        Bitmap bitmapM18144a;
        try {
            File file = new File(this.f4878k, this.f4879l);
            if (!file.exists() || file.length() == 0) {
                C5017a.m19064a().m19067a(m18996j(), file);
            }
            if (!this.f4877j) {
                if (!this.f4880m) {
                    bitmapM18144a = C4812ad.m18145a(m18997k(), file.getAbsolutePath());
                } else {
                    bitmapM18144a = C4812ad.m18145a(m18997k(), file.getAbsolutePath());
                }
            } else {
                bitmapM18144a = C4812ad.m18144a(m18997k(), Uri.fromFile(file), 66, 44);
            }
            if (bitmapM18144a != null) {
                bitmapM18144a.setDensity(160);
            }
            if (this.f4881n) {
                Uri uriM18149a = C4812ad.m18149a(bitmapM18144a != null ? C4812ad.m18151a(bitmapM18144a) : null, "myprofile.png_");
                if (uriM18149a == null) {
                    C4904y.m18634a("saveByteArrayOutputStreamToFileForProfile returns null", this.f4871a);
                    return bitmapM18144a;
                }
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM18144a, 288, 288, true);
                C2496n.m10790e(CommonApplication.m18732r(), this.f4882o);
                C2496n.m10759a(CommonApplication.m18732r(), this.f4882o, bitmapCreateScaledBitmap);
                if (new File(uriM18149a.getPath()).length() > 0) {
                    C4809aa.m18108a("profile_image_status", "updated");
                } else {
                    C4904y.m18634a("File length is 0:" + uriM18149a.getPath(), "ProfileUploadTask");
                }
                C2496n.m10782c(CommonApplication.m18732r());
                return bitmapM18144a;
            }
            return bitmapM18144a;
        } catch (InterruptedException e) {
            return null;
        } catch (Exception e2) {
            C4904y.m18635a(e2, getClass().getSimpleName());
            return null;
        } catch (OutOfMemoryError e3) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e3, getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (C4904y.f17872b) {
            C4904y.m18639b("BuddyProfileImageDispatcherTask. Value: " + obj + ", Cache: " + z, this.f4871a);
        }
        try {
            if (obj != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(mo7448g());
                bitmapDrawable.setAntiAlias(true);
                drawable = bitmapDrawable;
            } else if (!this.f4877j) {
                if (this.f4880m) {
                    drawable = m18997k().getResources().getDrawable(this.f4874d);
                } else {
                    mo7449h().setVisibility(8);
                    return;
                }
            } else {
                drawable = null;
            }
            if (this.f4872b != null) {
                this.f4872b.setVisibility(8);
            }
            if (z) {
                if (drawable != null) {
                    mo7449h().setImageDrawable(drawable);
                }
            } else if (drawable != null) {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable});
                mo7449h().setImageDrawable(transitionDrawable);
                transitionDrawable.startTransition(100);
            }
        } catch (NullPointerException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Bitmap bitmapMo7448g = mo7448g();
        m18990a((View) null);
        if (bitmapMo7448g != null) {
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
