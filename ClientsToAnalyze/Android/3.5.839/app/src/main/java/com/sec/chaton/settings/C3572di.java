package com.sec.chaton.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.common.p132g.AbstractRunnableC5005a;

/* compiled from: BgDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.di */
/* loaded from: classes.dex */
public class C3572di extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    Context f13061a;

    /* renamed from: b */
    String f13062b;

    public C3572di(String str, String str2, Context context) {
        super(str);
        this.f13061a = context;
        this.f13062b = str2;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        ((ImageView) mo7449h()).setImageDrawable(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        String str = m18996j().split("_")[1];
        if (EnumC2258bd.Skin.m10123a().equals(this.f13062b)) {
            return C3474r.m13830d(this.f13061a, str);
        }
        return C3474r.m13831d(this.f13061a, str, true);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable = (Drawable) obj;
        if (drawable == null) {
            drawable = this.f13061a.getResources().getDrawable(R.drawable.image_broken);
        }
        ((ImageView) mo7449h()).setImageDrawable(drawable);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Drawable drawable = (Drawable) mo7448g();
        if (drawable != null) {
            C3474r.m13818a(drawable);
        }
    }
}
