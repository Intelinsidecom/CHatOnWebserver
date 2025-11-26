package com.sec.chaton.multimedia.multisend;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import java.io.File;

/* compiled from: GalleryDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.multisend.i */
/* loaded from: classes.dex */
public class C2875i extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    private static final String f10582a = C2875i.class.getSimpleName();

    /* renamed from: b */
    private String f10583b;

    /* renamed from: c */
    private long f10584c;

    /* renamed from: d */
    private boolean f10585d;

    /* renamed from: e */
    private boolean f10586e;

    /* renamed from: i */
    private String f10587i;

    /* renamed from: j */
    private CheckBox f10588j;

    /* renamed from: k */
    private ImageView f10589k;

    public C2875i(String str, String str2, boolean z, boolean z2, String str3, CheckBox checkBox, ImageView imageView) {
        super(str);
        if (str2 != null) {
            this.f10584c = Long.valueOf(str2).longValue();
        } else {
            this.f10584c = 0L;
        }
        this.f10583b = str;
        this.f10585d = z;
        this.f10586e = z2;
        this.f10587i = str3;
        this.f10588j = checkBox;
        this.f10589k = imageView;
        if (C4904y.f17872b) {
            C4904y.m18639b("[init] key: " + str + ", id: " + this.f10584c + z, f10582a);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        mo7449h().setImageDrawable(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        if (C4904y.f17872b) {
            C4904y.m18639b("[onDispatch] content : " + this.f10583b, f10582a);
        }
        if (this.f10583b != null) {
            try {
                if (this.f10585d) {
                    Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m18732r().getContentResolver(), this.f10584c, 3, null);
                    Bitmap bitmapM18147a = this.f10587i != null ? C4812ad.m18147a(thumbnail, Integer.parseInt(this.f10587i)) : null;
                    if (bitmapM18147a != null) {
                        if (!thumbnail.isRecycled()) {
                            thumbnail.recycle();
                            return bitmapM18147a;
                        }
                        return bitmapM18147a;
                    }
                    if (thumbnail != null) {
                        return thumbnail;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("thumbBitmap1 is null", f10582a);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("return null!!!", f10582a);
                    }
                } else {
                    if (this.f10586e) {
                        return C4894o.m18598a(CommonApplication.m18732r(), new File(this.f10583b), true, true, false);
                    }
                    Bitmap thumbnail2 = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m18732r().getContentResolver(), this.f10584c, 1, null);
                    Bitmap bitmapM18147a2 = (this.f10587i == null || thumbnail2 == null) ? null : C4812ad.m18147a(thumbnail2, Integer.parseInt(this.f10587i));
                    if (bitmapM18147a2 == null) {
                        return thumbnail2;
                    }
                    if (thumbnail2 != null && !thumbnail2.isRecycled()) {
                        thumbnail2.recycle();
                        return bitmapM18147a2;
                    }
                    return bitmapM18147a2;
                }
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                return null;
            } catch (OutOfMemoryError e2) {
                C4904y.m18635a(e2, getClass().getSimpleName());
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[onPostDispatch] key: " + ((String) this.f18262g) + ", value:" + obj, f10582a);
        }
        if (obj != null) {
            try {
                if (!((Bitmap) obj).isRecycled()) {
                    mo7449h().setImageBitmap((Bitmap) obj);
                    if (this.f10588j != null) {
                        this.f10588j.setEnabled(true);
                        this.f10588j.setVisibility(0);
                    }
                    if (this.f10589k != null) {
                        this.f10589k.setVisibility(8);
                        mo7449h().setClickable(false);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                return;
            } catch (OutOfMemoryError e2) {
                C4904y.m18635a(e2, getClass().getSimpleName());
                return;
            }
        }
        if (this.f10588j != null) {
            this.f10588j.setEnabled(false);
            this.f10588j.setVisibility(8);
        }
        if (this.f10589k != null) {
            this.f10589k.setVisibility(0);
            mo7449h().setClickable(true);
        }
        mo7449h().setImageResource(R.drawable.trunk_image_default);
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
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap mo7448g() {
        return (Bitmap) super.mo7448g();
    }
}
