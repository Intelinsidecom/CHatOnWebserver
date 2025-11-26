package com.sec.chaton.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.common.p132g.AbstractRunnableC5005a;

/* compiled from: BubbleReceiveDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.dj */
/* loaded from: classes.dex */
public class C3573dj extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    Context f13063a;

    public C3573dj(String str, Context context) {
        super(str);
        this.f13063a = context;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        ((ImageView) mo7449h()).setBackgroundDrawable(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        return C3474r.m13840i(this.f13063a, m18996j().split("_")[1]);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            ((ImageView) mo7449h()).setBackgroundDrawable(drawable);
        } else {
            ((ImageView) mo7449h()).setBackgroundResource(R.drawable.image_broken);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Drawable drawable = (Drawable) mo7448g();
        if (drawable != null) {
            C3474r.m13818a(drawable);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: i */
    public boolean mo11696i() {
        return false;
    }
}
