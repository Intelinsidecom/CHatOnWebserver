package com.sec.chaton.userprofile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: SetProfileImageFromFileTask.java */
/* renamed from: com.sec.chaton.userprofile.cp */
/* loaded from: classes.dex */
public class CallableC4784cp extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: a */
    private File f17500a;

    /* renamed from: b */
    private Context f17501b;

    /* renamed from: c */
    private ImageView f17502c;

    /* renamed from: d */
    private boolean f17503d;

    /* renamed from: e */
    private boolean f17504e;

    public CallableC4784cp(File file, Boolean bool, Boolean bool2) {
        super(file.getName() + file.lastModified());
        this.f17503d = false;
        this.f17504e = true;
        C4904y.m18646e("yeseul/ file.getName(): " + file.getName(), getClass().getSimpleName());
        this.f17500a = file;
        this.f17503d = bool.booleanValue();
        this.f17504e = bool2.booleanValue();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        return null;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        Bitmap bitmapM18145a;
        this.f17501b = m18997k();
        C4904y.m18646e("onDispatch...", getClass().getSimpleName());
        if (this.f17500a.length() <= 0 || (bitmapM18145a = C4812ad.m18145a(this.f17501b, this.f17500a.getAbsolutePath())) == null) {
            return null;
        }
        return bitmapM18145a;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        C4904y.m18646e("onPostDispatch...", getClass().getSimpleName());
        this.f17502c = (ImageView) mo7449h();
        try {
            if (obj != null) {
                C4904y.m18646e("onPostExecute... : Result != null", getClass().getSimpleName());
                this.f17502c.setImageBitmap(mo7448g());
            } else {
                C4904y.m18646e("onPostExecute... : Result = null", getClass().getSimpleName());
                if (this.f17501b != null) {
                    C5179v.m19810a(this.f17501b, R.string.toast_error, 0).show();
                    this.f17500a.delete();
                    this.f17502c.setImageDrawable(null);
                    this.f17502c.setImageBitmap(BitmapFactory.decodeResource(this.f17501b.getResources(), R.drawable.image_broken));
                }
            }
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
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
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap mo7448g() {
        return (Bitmap) super.mo7448g();
    }
}
