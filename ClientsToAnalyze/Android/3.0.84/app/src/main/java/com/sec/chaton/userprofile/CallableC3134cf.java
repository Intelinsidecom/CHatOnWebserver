package com.sec.chaton.userprofile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C0522ag;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: SetProfileImageFromFileTask.java */
/* renamed from: com.sec.chaton.userprofile.cf */
/* loaded from: classes.dex */
public class CallableC3134cf extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    private File f11365a;

    /* renamed from: b */
    private Context f11366b;

    /* renamed from: c */
    private ImageView f11367c;

    /* renamed from: d */
    private boolean f11368d;

    /* renamed from: e */
    private boolean f11369e;

    public CallableC3134cf(File file, Boolean bool, Boolean bool2) {
        super(file.getName() + file.lastModified());
        this.f11368d = false;
        this.f11369e = true;
        C3250y.m11456e("yeseul/ file.getName(): " + file.getName(), getClass().getSimpleName());
        this.f11365a = file;
        this.f11368d = bool.booleanValue();
        this.f11369e = bool2.booleanValue();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        Bitmap bitmapM11000a;
        this.f11366b = m11714k();
        C3250y.m11456e("onDispatch...", getClass().getSimpleName());
        if (this.f11365a.length() <= 0 || (bitmapM11000a = C3162ad.m11000a(this.f11366b, this.f11365a.getAbsolutePath())) == null) {
            return null;
        }
        return bitmapM11000a;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        C3250y.m11456e("onPostDispatch...", getClass().getSimpleName());
        this.f11367c = (ImageView) mo4338h();
        try {
            if (obj != null) {
                C3250y.m11456e("onPostExecute... : Result != null", getClass().getSimpleName());
                this.f11367c.setImageBitmap(mo4337g());
                C0522ag.m4019a("Me", mo4337g());
            } else {
                C3250y.m11456e("onPostExecute... : Result = null", getClass().getSimpleName());
                if (this.f11366b != null) {
                    C3641ai.m13210a(this.f11366b, R.string.toast_error, 0).show();
                    this.f11365a.delete();
                    this.f11367c.setImageDrawable(null);
                    this.f11367c.setImageBitmap(BitmapFactory.decodeResource(this.f11366b.getResources(), R.drawable.chat_anicon_btn_failed));
                }
            }
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
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
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap mo4337g() {
        return (Bitmap) super.mo4337g();
    }
}
