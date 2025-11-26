package com.sec.chaton.chat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3205bt;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3348j;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: ChatProfileImageDispatcherTask.java */
/* renamed from: com.sec.chaton.chat.eo */
/* loaded from: classes.dex */
public class CallableC1073eo extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    File f4304a;

    /* renamed from: b */
    private ImageView f4305b;

    /* renamed from: c */
    private ImageView f4306c;

    /* renamed from: d */
    private int f4307d;

    /* renamed from: e */
    private int f4308e;

    /* renamed from: i */
    private String f4309i;

    /* renamed from: j */
    private String f4310j;

    /* renamed from: k */
    private String f4311k;

    /* renamed from: l */
    private String f4312l;

    /* renamed from: m */
    private int f4313m;

    public CallableC1073eo(ImageView imageView, String str, String str2) {
        super(str);
        this.f4304a = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();
        this.f4305b = imageView;
        this.f4313m = R.drawable.rotate_emoticon_loading;
        this.f4312l = str2;
    }

    /* renamed from: a */
    public void m5311a(int i, int i2, String str, String str2, String str3) {
        this.f4307d = i;
        this.f4308e = i2;
        this.f4309i = str;
        this.f4310j = str2;
        this.f4311k = this.f4312l + "_chat_profile.png_" + str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo4338h = mo4338h();
        Drawable drawable = m11714k().getResources().getDrawable(this.f4313m);
        if (this.f4305b == null) {
            imageViewMo4338h.setImageDrawable(drawable);
        } else {
            this.f4305b.setVisibility(0);
            this.f4305b.setImageDrawable(drawable);
        }
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() throws IOException {
        File fileM5309n = m5309n();
        if (fileM5309n != null && fileM5309n.exists()) {
            Bitmap bitmapM11791a = C3348j.m11791a(m11714k(), fileM5309n, this.f4307d, this.f4308e);
            bitmapM11791a.setDensity(160);
            mo4338h().setImageBitmap(bitmapM11791a);
        } else {
            mo4338h().setImageResource(R.drawable.contacts_default_group);
            m11711a(this, 500L);
        }
    }

    /* renamed from: n */
    private File m5309n() {
        File[] fileArrListFiles = this.f4304a.listFiles(new C1074ep(this));
        if (fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws IOException {
        File file = new File(this.f4309i, this.f4310j);
        try {
            C3332a.m11750a().m11753a(mo7454i(), file);
            Bitmap bitmapM11791a = C3348j.m11791a(m11714k(), file, this.f4307d, this.f4308e);
            bitmapM11791a.setDensity(160);
            return bitmapM11791a;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        if (this.f4305b != null) {
            this.f4305b.setVisibility(8);
        }
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo4337g());
            bitmapDrawable.setAntiAlias(true);
            if (z) {
                ImageView imageViewMo4338h = mo4338h();
                if (this.f4306c != null) {
                    this.f4306c.setVisibility(8);
                }
                C3205bt.m11182a(CommonApplication.m11493l()).m11216a(this.f4312l, EnumC1450r.GROUPCHAT);
                imageViewMo4338h.setImageDrawable(bitmapDrawable);
                return;
            }
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), bitmapDrawable});
            if (this.f4306c != null) {
                this.f4306c.setVisibility(8);
            }
            mo4338h().setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(100);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo4337g() {
        return (Bitmap) super.mo4337g();
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
}
