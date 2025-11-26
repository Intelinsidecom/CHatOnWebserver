package com.sec.chaton.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;

/* compiled from: BubbleReceiveDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.bi */
/* loaded from: classes.dex */
public class C1257bi extends AbstractRunnableC1820a {

    /* renamed from: a */
    InterfaceC1258bj f4798a;

    /* renamed from: b */
    Context f4799b;

    public C1257bi(String str, Context context) {
        super(str);
        this.f4799b = context;
    }

    /* renamed from: a */
    public void m4741a(InterfaceC1258bj interfaceC1258bj) {
        this.f4798a = interfaceC1258bj;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: b */
    public void mo3768b() {
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() {
        Drawable drawableM3952i = C1003c.m3952i(this.f4799b, (String) m6178j());
        this.f4798a.mo4665b((String) m6178j(), drawableM3952i);
        return drawableM3952i;
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
