package com.sec.chaton.p074l;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5051q;
import java.io.IOException;

/* compiled from: ProfileImageManager.java */
/* renamed from: com.sec.chaton.l.r */
/* loaded from: classes.dex */
class C2500r extends AbstractRunnableC5005a<String> implements InterfaceC2493k {

    /* renamed from: a */
    private String f8960a;

    /* renamed from: b */
    private EnumC2300t f8961b;

    /* renamed from: c */
    private EnumC2498p f8962c;

    public C2500r(String str, String str2, EnumC2300t enumC2300t, EnumC2498p enumC2498p) {
        super(str);
        this.f8960a = str2;
        this.f8961b = enumC2300t;
        this.f8962c = enumC2498p;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        mo7449h().setImageDrawable(C2496n.m10753a(this.f8961b, this.f8962c));
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws IOException {
        try {
            return new CallableC2488f(m18997k(), m18996j(), this.f8960a, EnumC2508z.LOAD).call();
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw C1057b.m6157a(e2);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        Drawable bitmapDrawable;
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null && bitmap != C2496n.f8946a) {
            if (this.f8962c == EnumC2498p.ROUND) {
                bitmapDrawable = new C5051q(bitmap);
            } else {
                bitmapDrawable = new BitmapDrawable(m18997k().getResources(), bitmap);
            }
            mo7449h().setImageDrawable(bitmapDrawable);
            return;
        }
        mo7449h().setImageDrawable(C2496n.m10753a(this.f8961b, this.f8962c));
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return EnumC2508z.LOAD.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }
}
