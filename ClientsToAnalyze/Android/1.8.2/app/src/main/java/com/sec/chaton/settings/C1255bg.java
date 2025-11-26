package com.sec.chaton.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;

/* compiled from: BgDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.bg */
/* loaded from: classes.dex */
public class C1255bg extends AbstractRunnableC1820a {

    /* renamed from: a */
    InterfaceC1256bh f4796a;

    /* renamed from: b */
    Context f4797b;

    public C1255bg(String str, Context context) {
        super(str);
        this.f4797b = context;
    }

    /* renamed from: a */
    public void m4740a(InterfaceC1256bh interfaceC1256bh) {
        this.f4796a = interfaceC1256bh;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: b */
    public void mo3768b() {
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() throws Throwable {
        Drawable drawableM3947d = C1003c.m3947d(this.f4797b, (String) m6178j());
        this.f4796a.mo4662a((String) m6178j(), drawableM3947d);
        this.f4796a.mo4663a((String) m6178j(), C1003c.m3949f(this.f4797b, (String) m6178j()));
        return drawableM3947d;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: a */
    public void mo3767a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable = (Drawable) obj;
        if (drawable == null) {
            drawable = this.f4797b.getResources().getDrawable(R.drawable.thumb_skin_networkerror);
        }
        ((ImageView) mo3775i()).setImageDrawable(drawable);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: d */
    public void mo3770d() {
        Drawable drawable = (Drawable) mo3774h();
        if (drawable != null) {
            C1003c.m3940a(drawable);
        }
    }
}
