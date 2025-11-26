package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.AbstractRunnableC5005a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ImageViewPagerDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.ae */
/* loaded from: classes.dex */
public class C2820ae extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    private static final String f10384a = C2820ae.class.getSimpleName();

    /* renamed from: b */
    private String f10385b;

    /* renamed from: c */
    private EnumC2214ab f10386c;

    /* renamed from: d */
    private String f10387d;

    /* renamed from: e */
    private Handler f10388e;

    /* renamed from: i */
    private boolean f10389i;

    /* renamed from: j */
    private ImageView f10390j;

    public C2820ae(String str, String str2, EnumC2214ab enumC2214ab, String str3, Handler handler, ImageView imageView) {
        super(str);
        this.f10385b = str2;
        this.f10386c = enumC2214ab;
        this.f10387d = str3;
        this.f10388e = handler;
        this.f10390j = imageView;
        if (C4904y.f17872b) {
            C4904y.m18639b("[init] key: " + str + ", mDownloadUri: " + this.f10385b + ", mMsgContentType:" + this.f10386c, f10384a);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        if (this.f10385b == null) {
            return null;
        }
        if (this.f10385b.startsWith("file:")) {
            this.f10385b = Uri.parse(this.f10385b).getPath();
        }
        if (this.f10386c == EnumC2214ab.IMAGE || this.f10386c == EnumC2214ab.AMS) {
            try {
                return C4812ad.m18158b(Uri.parse(this.f10385b));
            } catch (FileNotFoundException e) {
                C4904y.m18635a(e, f10384a);
            } catch (IOException e2) {
                C4904y.m18635a(e2, f10384a);
            } catch (OutOfMemoryError e3) {
                this.f10389i = true;
                C4904y.m18635a(e3, f10384a);
            }
        }
        if (this.f10386c == EnumC2214ab.VIDEO) {
            return m11923a(this.f10385b);
        }
        return null;
    }

    /* renamed from: a */
    private Bitmap m11923a(String str) {
        if (TextUtils.isEmpty(str) || C1427a.f5066d.equals(str)) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(str, 1);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        try {
            if (this.f10389i) {
                Message messageObtainMessage = this.f10388e.obtainMessage();
                messageObtainMessage.what = 1;
                this.f10388e.sendMessage(messageObtainMessage);
            } else if (obj != null && !((Bitmap) obj).isRecycled()) {
                mo7449h().setImageBitmap((Bitmap) obj);
                if (this.f10390j != null) {
                    this.f10390j.setVisibility(8);
                }
            } else {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mo7449h().getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                mo7449h().setLayoutParams(layoutParams);
                if (this.f10386c == EnumC2214ab.IMAGE || this.f10386c == EnumC2214ab.AMS) {
                    if (this.f10387d == null) {
                        mo7449h().setImageResource(R.drawable.trunk_no_image_default);
                    } else if (this.f10390j != null) {
                        mo7449h().setVisibility(8);
                    }
                } else {
                    mo7449h().setImageResource(R.drawable.trunk_no_veido_default);
                }
            }
        } catch (OutOfMemoryError e) {
            C4904y.m18635a(e, f10384a);
            Message messageObtainMessage2 = this.f10388e.obtainMessage();
            messageObtainMessage2.what = 1;
            this.f10388e.sendMessage(messageObtainMessage2);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Object objG = mo7448g();
        if (objG != null && !((Bitmap) objG).isRecycled()) {
            ((Bitmap) objG).recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: i */
    public boolean mo11696i() {
        return false;
    }
}
