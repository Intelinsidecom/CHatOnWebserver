package android.support.v4.view;

import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public abstract class PagerAdapter {

    /* renamed from: a */
    private InterfaceC0028f f145a;

    /* renamed from: a */
    public abstract int m183a();

    /* renamed from: a */
    public abstract Object m184a(View view, int i);

    /* renamed from: a */
    public abstract void m185a(Parcelable parcelable, ClassLoader classLoader);

    /* renamed from: a */
    void m186a(InterfaceC0028f interfaceC0028f) {
        this.f145a = interfaceC0028f;
    }

    /* renamed from: a */
    public abstract void m187a(View view);

    /* renamed from: a */
    public abstract void m188a(View view, int i, Object obj);

    /* renamed from: a */
    public abstract boolean m189a(View view, Object obj);

    /* renamed from: b */
    public abstract Parcelable m190b();

    /* renamed from: b */
    public abstract void m191b(View view);
}
