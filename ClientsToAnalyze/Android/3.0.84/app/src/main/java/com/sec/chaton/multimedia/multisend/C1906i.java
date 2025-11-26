package com.sec.chaton.multimedia.multisend;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import java.io.File;

/* compiled from: GalleryDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.multisend.i */
/* loaded from: classes.dex */
public class C1906i extends AbstractRunnableC3324a<String> {

    /* renamed from: a */
    private static final String f7261a = C1906i.class.getSimpleName();

    /* renamed from: b */
    private String f7262b;

    /* renamed from: c */
    private long f7263c;

    /* renamed from: d */
    private boolean f7264d;

    /* renamed from: e */
    private boolean f7265e;

    /* renamed from: i */
    private String f7266i;

    /* renamed from: j */
    private CheckBox f7267j;

    /* renamed from: k */
    private ImageView f7268k;

    public C1906i(String str, String str2, boolean z, boolean z2, String str3, CheckBox checkBox, ImageView imageView) {
        super(str);
        if (str2 != null) {
            this.f7263c = Long.valueOf(str2).longValue();
        } else {
            this.f7263c = 0L;
        }
        this.f7262b = str;
        this.f7264d = z;
        this.f7265e = z2;
        this.f7266i = str3;
        this.f7267j = checkBox;
        this.f7268k = imageView;
        if (C3250y.f11734b) {
            C3250y.m11450b("[init] key: " + str + ", id: " + this.f7263c + z, f7261a);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        mo4338h().setImageDrawable(null);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        if (C3250y.f11734b) {
            C3250y.m11450b("[onDispatch] content : " + this.f7262b, f7261a);
        }
        if (this.f7262b != null) {
            try {
                if (this.f7264d) {
                    Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m11493l().getContentResolver(), this.f7263c, 3, null);
                    Bitmap bitmapM11002a = this.f7266i != null ? C3162ad.m11002a(thumbnail, Integer.parseInt(this.f7266i)) : null;
                    if (bitmapM11002a != null) {
                        if (!thumbnail.isRecycled()) {
                            thumbnail.recycle();
                            return bitmapM11002a;
                        }
                        return bitmapM11002a;
                    }
                    if (thumbnail != null) {
                        return thumbnail;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("thumbBitmap1 is null", f7261a);
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("return null!!!", f7261a);
                    }
                } else {
                    if (this.f7265e) {
                        return C3243r.m11414a(CommonApplication.m11493l(), new File(this.f7262b), true, true, false);
                    }
                    Bitmap thumbnail2 = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m11493l().getContentResolver(), this.f7263c, 1, null);
                    Bitmap bitmapM11002a2 = this.f7266i != null ? C3162ad.m11002a(thumbnail2, Integer.parseInt(this.f7266i)) : null;
                    if (bitmapM11002a2 == null) {
                        return thumbnail2;
                    }
                    if (!thumbnail2.isRecycled()) {
                        thumbnail2.recycle();
                        return bitmapM11002a2;
                    }
                    return bitmapM11002a2;
                }
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                return null;
            } catch (OutOfMemoryError e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[onPostDispatch] key: " + ((String) this.f12013g) + ", value:" + obj, f7261a);
        }
        if (obj != null) {
            try {
                if (!((Bitmap) obj).isRecycled()) {
                    mo4338h().setImageBitmap((Bitmap) obj);
                    if (this.f7267j != null) {
                        this.f7267j.setEnabled(true);
                        this.f7267j.setVisibility(0);
                    }
                    if (this.f7268k != null) {
                        this.f7268k.setVisibility(8);
                        mo4338h().setClickable(false);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                return;
            } catch (OutOfMemoryError e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                return;
            }
        }
        if (this.f7267j != null) {
            this.f7267j.setEnabled(false);
            this.f7267j.setVisibility(8);
        }
        if (this.f7268k != null) {
            this.f7268k.setVisibility(0);
            mo4338h().setClickable(true);
        }
        mo4338h().setImageResource(R.drawable.trunk_image_default);
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
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap mo4337g() {
        return (Bitmap) super.mo4337g();
    }
}
