package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p035io.entry.ViewPackageEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3347i;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CancellationException;

/* compiled from: AniconPanelDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.j */
/* loaded from: classes.dex */
public class C1820j extends AbstractRunnableC3324a<String> {

    /* renamed from: a */
    static String f6791a = C1820j.class.getSimpleName();

    /* renamed from: b */
    private C1332j f6792b;

    /* renamed from: c */
    private String f6793c;

    public C1820j(String str, String str2, C1332j c1332j) {
        super(str);
        this.f6793c = str2;
        this.f6792b = c1332j;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        mo4338h().setImageBitmap(null);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws IOException {
        C0267d c0267dB;
        String strI = mo7454i();
        if (TextUtils.isEmpty(this.f6793c)) {
            try {
                c0267dB = this.f6792b.m5768a(EnumC1172b.UI, strI, 240).m5491b();
            } catch (InterruptedException e) {
                if (C3250y.f11734b) {
                    C3250y.m11443a(e, f6791a);
                }
                c0267dB = null;
            } catch (CancellationException e2) {
                if (C3250y.f11734b) {
                    C3250y.m11443a(e2, f6791a);
                }
                c0267dB = null;
            }
            if (c0267dB == null || c0267dB.m1351b() != EnumC1587o.SUCCESS) {
                return null;
            }
            ViewPackageEntry viewPackageEntry = (ViewPackageEntry) c0267dB.m1354e();
            if (viewPackageEntry == null) {
                return null;
            }
            this.f6793c = viewPackageEntry._package.panelurl;
        }
        BitmapDrawable bitmapDrawableM9666d = C2646u.m9666d(m11714k(), strI, C3347i.m11779b(), C3347i.m11780c());
        if (bitmapDrawableM9666d != null) {
            return bitmapDrawableM9666d;
        }
        File file = new File(C3332a.m11751a(m11714k()), String.valueOf(this.f6793c.hashCode()));
        if (file.exists()) {
            file.delete();
        }
        try {
            C3332a.m11750a().m11753a(this.f6793c, file);
            C2646u.m9655b(m11714k(), strI, file);
            return C2646u.m9666d(m11714k(), strI, C3347i.m11779b(), C3347i.m11780c());
        } catch (InterruptedException e3) {
            return null;
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (obj != null) {
            drawable = mo4337g();
        } else {
            drawable = m11714k().getResources().getDrawable(R.drawable.chat_anicon_btn_failed);
        }
        mo4338h().setImageDrawable(drawable);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawableMo4337g = mo4337g();
        m11708a((View) null);
        if (bitmapDrawableMo4337g != null && (bitmap = bitmapDrawableMo4337g.getBitmap()) != null) {
            bitmap.recycle();
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable mo4337g() {
        return (BitmapDrawable) super.mo4337g();
    }
}
