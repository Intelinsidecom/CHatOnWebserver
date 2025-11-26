package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.AbstractRunnableC3324a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ImageViewPagerDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.ab */
/* loaded from: classes.dex */
public class C1851ab extends AbstractRunnableC3324a<String> {

    /* renamed from: a */
    private static final String f7073a = C1851ab.class.getSimpleName();

    /* renamed from: b */
    private String f7074b;

    /* renamed from: c */
    private EnumC1455w f7075c;

    /* renamed from: d */
    private String f7076d;

    /* renamed from: e */
    private Handler f7077e;

    /* renamed from: i */
    private boolean f7078i;

    /* renamed from: j */
    private ImageView f7079j;

    public C1851ab(String str, String str2, EnumC1455w enumC1455w, String str3, Handler handler, ImageView imageView) {
        super(str);
        this.f7074b = str2;
        this.f7075c = enumC1455w;
        this.f7076d = str3;
        this.f7077e = handler;
        this.f7079j = imageView;
        if (C3250y.f11734b) {
            C3250y.m11450b("[init] key: " + str + ", mDownloadUri: " + this.f7074b + ", mMsgContentType:" + this.f7075c, f7073a);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        if (this.f7074b == null) {
            return null;
        }
        if (this.f7074b.startsWith("file:")) {
            this.f7074b = Uri.parse(this.f7074b).getPath();
        }
        if (this.f7075c == EnumC1455w.IMAGE || this.f7075c == EnumC1455w.AMS) {
            try {
                return C3162ad.m11013b(Uri.parse(this.f7074b));
            } catch (FileNotFoundException e) {
                C3250y.m11443a(e, f7073a);
            } catch (IOException e2) {
                C3250y.m11443a(e2, f7073a);
            } catch (OutOfMemoryError e3) {
                this.f7078i = true;
                C3250y.m11443a(e3, f7073a);
            }
        }
        if (this.f7075c == EnumC1455w.VIDEO) {
            return m7697a(this.f7074b);
        }
        return null;
    }

    /* renamed from: a */
    private Bitmap m7697a(String str) {
        if (TextUtils.isEmpty(str) || C0816a.f3113b.equals(str)) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(str, 1);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        try {
            if (this.f7078i) {
                Message messageObtainMessage = this.f7077e.obtainMessage();
                messageObtainMessage.what = 1;
                this.f7077e.sendMessage(messageObtainMessage);
            } else if (obj != null && !((Bitmap) obj).isRecycled()) {
                mo4338h().setImageBitmap((Bitmap) obj);
                if (this.f7079j != null) {
                    this.f7079j.setVisibility(8);
                }
            } else if (this.f7075c == EnumC1455w.IMAGE || this.f7075c == EnumC1455w.AMS) {
                if (this.f7076d == null) {
                    mo4338h().setImageResource(R.drawable.turnk_no_image_default);
                } else if (this.f7079j != null) {
                    mo4338h().setVisibility(8);
                }
            } else {
                mo4338h().setImageResource(R.drawable.turnk_no_veido_default);
            }
        } catch (OutOfMemoryError e) {
            C3250y.m11443a(e, f7073a);
            Message messageObtainMessage2 = this.f7077e.obtainMessage();
            messageObtainMessage2.what = 1;
            this.f7077e.sendMessage(messageObtainMessage2);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Object objG = mo4337g();
        if (objG != null && !((Bitmap) objG).isRecycled()) {
            ((Bitmap) objG).recycle();
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: j */
    public boolean mo7491j() {
        return false;
    }
}
