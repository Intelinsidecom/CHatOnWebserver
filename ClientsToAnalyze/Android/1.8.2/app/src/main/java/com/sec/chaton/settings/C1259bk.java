package com.sec.chaton.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;

/* compiled from: BubbleSendDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.bk */
/* loaded from: classes.dex */
public class C1259bk extends AbstractRunnableC1820a {

    /* renamed from: a */
    InterfaceC1260bl f4800a;

    /* renamed from: b */
    Context f4801b;

    public C1259bk(String str, Context context) {
        super(str);
        this.f4801b = context;
    }

    /* renamed from: a */
    public void m4742a(InterfaceC1260bl interfaceC1260bl) {
        this.f4800a = interfaceC1260bl;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: b */
    public void mo3768b() {
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() {
        Drawable drawableM3950g = C1003c.m3950g(this.f4801b, (String) m6178j());
        this.f4800a.mo4667c((String) m6178j(), drawableM3950g);
        return drawableM3950g;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: a */
    public void mo3767a(Object obj, boolean z) {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            ((TextView) mo3775i()).setBackgroundDrawable(drawable);
        } else {
            ((TextView) mo3775i()).setBackgroundResource(R.drawable.thumb_bubble_networkerror);
        }
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
