package com.sec.chaton.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.common.p069e.AbstractRunnableC3324a;

/* compiled from: BubbleSendDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.cm */
/* loaded from: classes.dex */
public class C2479cm extends AbstractRunnableC3324a<String> {

    /* renamed from: a */
    Context f9339a;

    public C2479cm(String str, Context context) {
        super(str);
        this.f9339a = context;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        ((ImageView) mo4338h()).setBackgroundDrawable(null);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        return C2591cd.m9584g(this.f9339a, mo7454i().split("_")[1]);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            ((ImageView) mo4338h()).setBackgroundDrawable(drawable);
        } else {
            ((ImageView) mo4338h()).setBackgroundResource(R.drawable.download_default);
        }
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
