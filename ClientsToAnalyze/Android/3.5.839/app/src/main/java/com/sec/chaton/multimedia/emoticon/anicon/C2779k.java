package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2131l;
import com.sec.chaton.p065io.entry.ViewPackageEntry;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: AniconPanelDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.k */
/* loaded from: classes.dex */
public class C2779k extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    static String f10066a = C2779k.class.getSimpleName();

    /* renamed from: b */
    private C2131l f10067b;

    /* renamed from: c */
    private String f10068c;

    public C2779k(String str, String str2, C2131l c2131l) {
        super(str);
        this.f10068c = str2;
        this.f10067b = c2131l;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        mo7449h().setImageBitmap(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws ExecutionException, InterruptedException, IOException {
        C0778b c0778b;
        String strJ = m18996j();
        BitmapDrawable bitmapDrawableM13782d = C3460d.m13782d(m18997k(), strJ, C5034k.m19096b(), C5034k.m19098c());
        if (bitmapDrawableM13782d != null) {
            return bitmapDrawableM13782d;
        }
        try {
            c0778b = this.f10067b.m9550a(EnumC2463n.UI, strJ, 240).get();
        } catch (InterruptedException e) {
            if (C4904y.f17872b) {
                C4904y.m18635a(e, f10066a);
            }
            c0778b = null;
        } catch (CancellationException e2) {
            if (C4904y.f17872b) {
                C4904y.m18635a(e2, f10066a);
            }
            c0778b = null;
        } catch (ExecutionException e3) {
            if (C4904y.f17872b) {
                C4904y.m18635a(e3, f10066a);
            }
            c0778b = null;
        }
        if (c0778b == null || c0778b.m3107b() != EnumC2464o.SUCCESS) {
            return null;
        }
        ViewPackageEntry viewPackageEntry = (ViewPackageEntry) c0778b.m3110e();
        if (viewPackageEntry == null) {
            return null;
        }
        this.f10068c = viewPackageEntry._package.panelurl;
        if (this.f10068c == null) {
            return null;
        }
        File file = new File(C5017a.m19065a(m18997k()), String.valueOf(this.f10068c.hashCode()));
        if (file.exists()) {
            file.delete();
        }
        try {
            C5017a.m19064a().m19067a(this.f10068c, file);
            C3460d.m13773b(m18997k(), strJ, file);
            return C3460d.m13782d(m18997k(), strJ, C5034k.m19096b(), C5034k.m19098c());
        } catch (InterruptedException e4) {
            return null;
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (obj != null) {
            drawable = mo7448g();
        } else {
            drawable = m18997k().getResources().getDrawable(R.drawable.anicon_broken);
        }
        mo7449h().setImageDrawable(drawable);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawableMo7448g = mo7448g();
        m18990a((View) null);
        if (bitmapDrawableMo7448g != null && (bitmap = bitmapDrawableMo7448g.getBitmap()) != null) {
            bitmap.recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable mo7448g() {
        return (BitmapDrawable) super.mo7448g();
    }
}
