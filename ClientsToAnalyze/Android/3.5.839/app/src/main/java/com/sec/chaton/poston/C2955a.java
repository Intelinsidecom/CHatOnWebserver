package com.sec.chaton.poston;

import android.content.Context;
import android.content.OperationApplicationException;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p131f.C4999c;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;

/* compiled from: CoverStoryDispatcherTask.java */
/* renamed from: com.sec.chaton.poston.a */
/* loaded from: classes.dex */
public class C2955a extends AbstractRunnableC5005a<String> {

    /* renamed from: c */
    private String f11036c;

    /* renamed from: d */
    private int f11037d;

    /* renamed from: e */
    private int f11038e;

    /* renamed from: i */
    private String f11039i;

    /* renamed from: j */
    private String f11040j;

    /* renamed from: k */
    private String f11041k;

    /* renamed from: l */
    private String f11042l;

    /* renamed from: m */
    private String f11043m;

    /* renamed from: n */
    private String f11044n;

    /* renamed from: o */
    private Context f11045o;

    /* renamed from: p */
    private String f11046p;

    /* renamed from: q */
    private String f11047q;

    /* renamed from: r */
    private static String f11034r = "mypage";

    /* renamed from: s */
    private static String f11035s = "buddy";

    /* renamed from: a */
    public static String f11032a = "sample";

    /* renamed from: b */
    public static String f11033b = "content";

    public C2955a(String str, String str2, String str3, Context context, String str4, String str5, String str6) {
        super(str + str6);
        this.f11042l = C2955a.class.getSimpleName();
        this.f11043m = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        if (C4904y.f17872b) {
            C4904y.m18639b("CoverStoryDispatcherTask Start...", this.f11042l);
        }
        this.f11036c = str;
        this.f11039i = str2;
        this.f11037d = R.drawable.rotate_emoticon_loading;
        this.f11038e = R.drawable.image_broken;
        this.f11044n = str3;
        this.f11045o = context;
        this.f11040j = str4;
        if (f11032a.equals(this.f11044n)) {
            this.f11041k = str5;
            if (C4904y.f17872b) {
                C4904y.m18639b("IMAGE_FROM_SAMPLE [mFileName] : " + this.f11041k + " ## [mFileDir] : " + this.f11040j, this.f11042l);
            }
        } else if (f11034r.equals(this.f11044n)) {
            this.f11041k = "mycoverstory.jpg";
            if (C4904y.f17872b) {
                C4904y.m18639b("IMAGE_FROM_MYPAGE [mFileName] : " + this.f11041k + " ## [mFileDir] : " + this.f11040j, this.f11042l);
            }
        } else {
            this.f11041k = str5;
            if (C4904y.f17872b) {
                C4904y.m18639b("NOT IMAGE_FROM_SAMPLE [mFileName] : " + this.f11041k + " ## [mFileDir] : " + this.f11040j, this.f11042l);
            }
        }
        if (f11033b.equals(this.f11044n) && !TextUtils.isEmpty(str6)) {
            this.f11046p = str6;
            this.f11047q = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        }
    }

    public C2955a(String str, String str2, String str3, String str4, Context context) {
        super(str);
        this.f11042l = C2955a.class.getSimpleName();
        this.f11043m = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f11036c = str;
        this.f11039i = str2;
        this.f11040j = str3;
        this.f11037d = R.drawable.rotate_emoticon_loading;
        this.f11038e = R.drawable.image_broken;
        this.f11044n = str4;
        this.f11045o = context;
        this.f11041k = "coverstory.jpg";
    }

    public C2955a(String str, String str2, String str3, String str4, String str5, Context context) {
        super(str);
        this.f11042l = C2955a.class.getSimpleName();
        this.f11043m = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f11036c = str;
        this.f11039i = str2;
        this.f11040j = str3;
        this.f11037d = R.drawable.rotate_emoticon_loading;
        this.f11038e = R.drawable.chat_anicon_btn_failed;
        this.f11044n = str5;
        this.f11045o = context;
        this.f11041k = str4;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        ImageView imageViewMo7449h;
        if (f11032a.equals(this.f11044n) && (imageViewMo7449h = mo7449h()) != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onPreDispatch() WHITE SCREEN CHECK", this.f11042l);
            }
            imageViewMo7449h.setImageBitmap(null);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws Throwable {
        Bitmap bitmapM18969a;
        File file = new File(this.f11040j, this.f11041k);
        if (C4904y.f17872b) {
            C4904y.m18639b("onDispatch() [mFileDir] : " + this.f11040j + " ## [mFileName] : " + this.f11041k, this.f11042l);
        }
        if (this.f11036c != null) {
            if (file.exists()) {
                file.delete();
            }
            try {
                if (f11032a.equals(this.f11044n)) {
                    C5017a.m19064a().m19067a(this.f11036c, file);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("IMAGE_FROM_SAMPLE mUrl : " + this.f11036c, this.f11042l);
                    }
                } else if (f11033b.equals(this.f11044n)) {
                    C5017a.m19064a().m19067a(this.f11036c, file);
                } else {
                    C5017a.m19064a().m19067a(this.f11036c + this.f11043m, file);
                }
                bitmapM18969a = new C4999c().m18976a(file).m18969a();
                if (bitmapM18969a != null) {
                    bitmapM18969a.setDensity(160);
                }
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("FileNotFoundException onDispatch() [mFileDir] : " + this.f11040j + " ## [mFileName] : " + this.f11041k, this.f11042l);
                }
                if (mo7449h() != null) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("FileNotFoundException Pattern Setting ~!! loadDefaultCoverStory()", this.f11042l);
                    }
                    C1331gk.m7458a(mo7449h());
                }
                bitmapM18969a = null;
            } catch (InterruptedException e2) {
                file.delete();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, this.f11042l);
                }
                bitmapM18969a = null;
            }
        } else if (file.exists()) {
            try {
                bitmapM18969a = new C4999c().m18976a(file).m18969a();
                if (bitmapM18969a != null) {
                    bitmapM18969a.setDensity(160);
                }
            } catch (Exception e3) {
                file.delete();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e3, this.f11042l);
                }
                bitmapM18969a = null;
            }
        } else {
            bitmapM18969a = null;
        }
        if (f11033b.equals(this.f11044n) && this.f11046p != null) {
            String str = this.f11040j + this.f11041k;
            if (C4904y.f17872b) {
                C4904y.m18639b("copyCoverStoryforRandomImages\t[mOriginPath] : " + str + " ## [mDestDir] : " + this.f11047q, this.f11042l);
            }
            if (this.f11047q != null) {
                BuddyDialog.m7173a(this.f11046p, str, this.f11047q);
            }
        }
        if (bitmapM18969a == null) {
            try {
                C2190d.m9830c(GlobalApplication.m10279a().getContentResolver(), this.f11039i, "");
            } catch (OperationApplicationException e4) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e4, this.f11042l);
                }
            } catch (RemoteException e5) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e5, this.f11042l);
                }
            }
        }
        return bitmapM18969a;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        if (mo7449h() != null) {
            mo7449h().setImageBitmap(mo7448g());
        } else if (C4904y.f17872b) {
            C4904y.m18639b(" coverstory onPostDispatch getView() is NULL", this.f11042l);
        }
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
