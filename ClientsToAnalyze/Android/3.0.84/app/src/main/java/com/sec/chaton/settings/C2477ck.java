package com.sec.chaton.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.common.p069e.AbstractRunnableC3324a;

/* compiled from: BgDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.ck */
/* loaded from: classes.dex */
public class C2477ck extends AbstractRunnableC3324a<String> {

    /* renamed from: a */
    Context f9337a;

    public C2477ck(String str, Context context) {
        super(str);
        this.f9337a = context;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        ((ImageView) mo4338h()).setImageDrawable(null);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        return C2591cd.m9579d(this.f9337a, mo7454i().split("_")[1]);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable = (Drawable) obj;
        if (drawable == null) {
            drawable = this.f9337a.getResources().getDrawable(R.drawable.download_default);
        }
        ((ImageView) mo4338h()).setImageDrawable(drawable);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Drawable drawable = (Drawable) mo4337g();
        if (drawable != null) {
            C2591cd.m9569a(drawable);
        }
    }
}
