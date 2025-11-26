package com.sec.chaton.poston;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: CoverStoryDispatcherTask.java */
/* renamed from: com.sec.chaton.poston.a */
/* loaded from: classes.dex */
public class C1960a extends AbstractRunnableC3324a<String> {

    /* renamed from: c */
    private String f7639c;

    /* renamed from: d */
    private int f7640d;

    /* renamed from: e */
    private int f7641e;

    /* renamed from: i */
    private String f7642i;

    /* renamed from: j */
    private String f7643j;

    /* renamed from: k */
    private String f7644k;

    /* renamed from: l */
    private String f7645l;

    /* renamed from: m */
    private String f7646m;

    /* renamed from: n */
    private String f7647n;

    /* renamed from: o */
    private Context f7648o;

    /* renamed from: p */
    private String f7649p;

    /* renamed from: q */
    private String f7650q;

    /* renamed from: t */
    private final int f7651t;

    /* renamed from: u */
    private final int f7652u;

    /* renamed from: r */
    private static String f7637r = "mypage";

    /* renamed from: s */
    private static String f7638s = "buddy";

    /* renamed from: a */
    public static String f7635a = "sample";

    /* renamed from: b */
    public static String f7636b = "content";

    public C1960a(String str, String str2, String str3, Context context, String str4, String str5, String str6) {
        super(str + str6);
        this.f7645l = C1960a.class.getSimpleName();
        this.f7646m = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f7651t = (int) C3172an.m11085a(286.0f);
        this.f7652u = (int) C3172an.m11085a(184.0f);
        if (C3250y.f11734b) {
            C3250y.m11450b("CoverStoryDispatcherTask Start...", this.f7645l);
        }
        this.f7639c = str;
        this.f7642i = str2;
        this.f7640d = R.drawable.rotate_emoticon_loading;
        this.f7641e = R.drawable.chat_anicon_btn_failed;
        this.f7647n = str3;
        this.f7648o = context;
        this.f7643j = str4;
        if (f7635a.equals(this.f7647n)) {
            this.f7644k = str5;
            if (C3250y.f11734b) {
                C3250y.m11450b("IMAGE_FROM_SAMPLE [mFileName] : " + this.f7644k + " ## [mFileDir] : " + this.f7643j, this.f7645l);
            }
        } else if (f7637r.equals(this.f7647n)) {
            this.f7644k = "mycoverstory.jpg";
            if (C3250y.f11734b) {
                C3250y.m11450b("IMAGE_FROM_MYPAGE [mFileName] : " + this.f7644k + " ## [mFileDir] : " + this.f7643j, this.f7645l);
            }
        } else {
            this.f7644k = str5;
            if (C3250y.f11734b) {
                C3250y.m11450b("NOT IMAGE_FROM_SAMPLE [mFileName] : " + this.f7644k + " ## [mFileDir] : " + this.f7643j, this.f7645l);
            }
        }
        if (f7636b.equals(this.f7647n) && !TextUtils.isEmpty(str6)) {
            this.f7649p = str6;
            this.f7650q = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        }
    }

    public C1960a(String str, String str2, Context context, String str3, String str4, String str5) {
        super(str3 + str5);
        this.f7645l = C1960a.class.getSimpleName();
        this.f7646m = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f7651t = (int) C3172an.m11085a(286.0f);
        this.f7652u = (int) C3172an.m11085a(184.0f);
        this.f7639c = null;
        this.f7642i = str;
        this.f7640d = R.drawable.rotate_emoticon_loading;
        this.f7641e = R.drawable.chat_anicon_btn_failed;
        this.f7647n = str2;
        this.f7648o = context;
        this.f7643j = str3;
        this.f7644k = str4;
    }

    public C1960a(String str, String str2, String str3, String str4, Context context) {
        super(str);
        this.f7645l = C1960a.class.getSimpleName();
        this.f7646m = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f7651t = (int) C3172an.m11085a(286.0f);
        this.f7652u = (int) C3172an.m11085a(184.0f);
        this.f7639c = str;
        this.f7642i = str2;
        this.f7643j = str3;
        this.f7640d = R.drawable.rotate_emoticon_loading;
        this.f7641e = R.drawable.chat_anicon_btn_failed;
        this.f7647n = str4;
        this.f7648o = context;
        this.f7644k = "coverstory.jpg";
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        ImageView imageViewMo4338h;
        if (f7635a.equals(this.f7647n) && (imageViewMo4338h = mo4338h()) != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("onPreDispatch() WHITE SCREEN CHECK", this.f7645l);
            }
            imageViewMo4338h.setImageBitmap(null);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        File file = new File(this.f7643j, this.f7644k);
        if (C3250y.f11734b) {
            C3250y.m11450b("onDispatch() [mFileDir] : " + this.f7643j + " ## [mFileName] : " + this.f7644k, this.f7645l);
        }
        if (this.f7639c != null) {
            if (file.exists()) {
                file.delete();
            }
            try {
                if (f7635a.equals(this.f7647n)) {
                    C3332a.m11750a().m11753a(this.f7639c, file);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("IMAGE_FROM_SAMPLE mUrl : " + this.f7639c, this.f7645l);
                    }
                } else if (f7636b.equals(this.f7647n)) {
                    C3332a.m11750a().m11753a(this.f7639c, file);
                } else {
                    C3332a.m11750a().m11753a(this.f7639c + this.f7646m, file);
                }
                Bitmap bitmapM11003a = C3162ad.m11003a(Uri.fromFile(file));
                if (bitmapM11003a != null) {
                    bitmapM11003a.setDensity(160);
                    return bitmapM11003a;
                }
                return bitmapM11003a;
            } catch (IOException e) {
                C3250y.m11450b("FileNotFoundException onDispatch() [mFileDir] : " + this.f7643j + " ## [mFileName] : " + this.f7644k, this.f7645l);
                if (mo4338h() != null) {
                    C3250y.m11450b("FileNotFoundException Pattern Setting ~!! loadDefaultCoverStory()", this.f7645l);
                    C3231f.m11368a(mo4338h());
                }
                return null;
            } catch (InterruptedException e2) {
                file.delete();
                if (C3250y.f11737e) {
                    C3250y.m11443a(e2, this.f7645l);
                }
                return null;
            }
        }
        if (!file.exists()) {
            return null;
        }
        try {
            Bitmap bitmapM11003a2 = C3162ad.m11003a(Uri.fromFile(file));
            if (bitmapM11003a2 != null) {
                bitmapM11003a2.setDensity(160);
                return bitmapM11003a2;
            }
            return bitmapM11003a2;
        } catch (Exception e3) {
            file.delete();
            if (C3250y.f11737e) {
                C3250y.m11443a(e3, this.f7645l);
            }
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws IOException {
        Bitmap bitmapM11011b;
        Display defaultDisplay = ((WindowManager) this.f7648o.getSystemService("window")).getDefaultDisplay();
        Configuration configuration = this.f7648o.getResources().getConfiguration();
        if (f7637r.equals(this.f7647n)) {
            if (obj != null) {
                if (configuration.orientation == 2) {
                    bitmapM11011b = C3162ad.m10994a(this.f7648o, defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C3172an.m11085a(59.0f), this.f7643j, this.f7644k);
                } else {
                    bitmapM11011b = C3162ad.m11011b(this.f7648o, defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C3172an.m11085a(59.0f), this.f7643j, this.f7644k);
                }
                if (mo4338h() != null) {
                    mo4338h().setImageBitmap(bitmapM11011b);
                    return;
                }
                return;
            }
            return;
        }
        if (mo4338h() != null) {
            mo4338h().setImageBitmap(mo4337g());
        }
        if (f7636b.equals(this.f7647n) && this.f7649p != null) {
            String str = this.f7643j + this.f7644k;
            if (C3250y.f11734b) {
                C3250y.m11450b("copyCoverStoryforRandomImages\t[mOriginPath] : " + str + " ## [mDestDir] : " + this.f7650q, this.f7645l);
            }
            if (this.f7650q != null) {
                BuddyDialog.m4116a(this.f7649p, str, this.f7650q);
            }
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
