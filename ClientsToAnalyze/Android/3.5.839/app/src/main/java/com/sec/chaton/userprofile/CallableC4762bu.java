package com.sec.chaton.userprofile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.ZoomableImageView;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p131f.C4999c;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: ProfileImageDispatcherTask2.java */
/* renamed from: com.sec.chaton.userprofile.bu */
/* loaded from: classes.dex */
public class CallableC4762bu extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: a */
    private String f17469a;

    /* renamed from: b */
    private String f17470b;

    /* renamed from: c */
    private boolean f17471c;

    /* renamed from: d */
    private String f17472d;

    /* renamed from: e */
    private int f17473e;

    /* renamed from: i */
    private int f17474i;

    /* renamed from: j */
    private int f17475j;

    /* renamed from: k */
    private boolean f17476k;

    /* renamed from: l */
    private ImageView f17477l;

    /* renamed from: m */
    private Handler f17478m;

    /* renamed from: n */
    private ImageView f17479n;

    /* renamed from: o */
    private String f17480o;

    public CallableC4762bu(String str, String str2, boolean z, int i, Handler handler) {
        super(str2);
        this.f17474i = R.drawable.rotate_emoticon_loading;
        this.f17475j = R.drawable.image_broken;
        this.f17477l = null;
        this.f17480o = CallableC4761bt.class.getSimpleName();
        this.f17469a = str;
        this.f17470b = str2;
        this.f17471c = z;
        this.f17473e = i;
        this.f17478m = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        Drawable drawable = m18997k().getResources().getDrawable(this.f17474i);
        if (this.f17479n != null) {
            this.f17479n.setVisibility(0);
            this.f17479n.setImageDrawable(drawable);
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
        m18993a(this, 500L);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws IOException {
        String str;
        if (C4904y.f17872b) {
            C4904y.m18639b("onDispatch...", this.f17480o);
        }
        String strM18502c = C4873ck.m18502c();
        String str2 = this.f17470b + "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        String str3 = "&size=140";
        this.f17472d = strM18502c + "/profilehistory/";
        if (this.f17471c) {
            str3 = "&size=800";
            str = MyPageFragment.f17194b;
        } else {
            str = MyPageFragment.f17195c;
        }
        File file = new File(this.f17472d);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str + this.f17469a);
        if (!file2.exists() || file2.length() == 0) {
            try {
                C5017a.m19064a().m19067a(str2 + str3, file2);
            } catch (InterruptedException e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Error image Exception : " + this.f17472d + this.f17469a + "//// : " + e, this.f17480o);
                }
            }
        }
        Bitmap bitmapM18969a = new C4999c().m18976a(file2).m18972a(this.f17473e, this.f17473e).m18969a();
        if (bitmapM18969a != null) {
            bitmapM18969a.setDensity(160);
        } else if (C4904y.f17872b) {
            C4904y.m18639b("Error image bitmap = null", this.f17480o);
        }
        return bitmapM18969a;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Boolean bool;
        Drawable drawable;
        if (C4904y.f17872b) {
            C4904y.m18639b("onPostDispatch...", this.f17480o);
        }
        Boolean.valueOf(false);
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo7448g());
            bitmapDrawable.setAntiAlias(true);
            bool = false;
            drawable = bitmapDrawable;
        } else {
            bool = true;
            drawable = m18997k().getResources().getDrawable(this.f17475j);
        }
        if (this.f17479n != null) {
            this.f17479n.setVisibility(8);
        }
        if (this.f17476k) {
            if (!bool.booleanValue() || this.f17477l == null) {
                mo7449h().setImageDrawable(drawable);
                return;
            }
            mo7449h().setImageBitmap(null);
            this.f17477l.setVisibility(0);
            this.f17477l.setImageDrawable(drawable);
            if (C4904y.f17872b) {
                C4904y.m18639b("Error image 02", this.f17480o);
                return;
            }
            return;
        }
        mo7449h().setImageDrawable(drawable);
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
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        View viewMo7449h = super.mo7449h();
        if (viewMo7449h instanceof ZoomableImageView) {
            this.f17476k = true;
        } else {
            this.f17476k = false;
        }
        return (ImageView) viewMo7449h;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo7448g() {
        return (Bitmap) super.mo7448g();
    }
}
