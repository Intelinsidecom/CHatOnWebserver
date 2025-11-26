package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.AbstractC0144ae;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: FragmentPagerAdapter.java */
/* renamed from: android.support.v4.app.ad */
/* loaded from: classes.dex */
public abstract class AbstractC0018ad extends AbstractC0144ae {

    /* renamed from: a */
    private final AbstractC0069w f93a;

    /* renamed from: b */
    private AbstractC0024aj f94b = null;

    /* renamed from: c */
    private Fragment f95c = null;

    /* renamed from: a */
    public abstract Fragment mo75a(int i);

    public AbstractC0018ad(AbstractC0069w abstractC0069w) {
        this.f93a = abstractC0069w;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo78a(ViewGroup viewGroup) {
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public Object mo76a(ViewGroup viewGroup, int i) {
        if (this.f94b == null) {
            this.f94b = this.f93a.mo183a();
        }
        long jM81b = m81b(i);
        Fragment fragmentMo182a = this.f93a.mo182a(m73a(viewGroup.getId(), jM81b));
        if (fragmentMo182a != null) {
            this.f94b.mo106e(fragmentMo182a);
        } else {
            fragmentMo182a = mo75a(i);
            this.f94b.mo96a(viewGroup.getId(), fragmentMo182a, m73a(viewGroup.getId(), jM81b));
        }
        if (fragmentMo182a != this.f95c) {
            fragmentMo182a.setMenuVisibility(false);
            fragmentMo182a.setUserVisibleHint(false);
        }
        return fragmentMo182a;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo79a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f94b == null) {
            this.f94b = this.f93a.mo183a();
        }
        this.f94b.mo105d((Fragment) obj);
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public void mo83b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f95c) {
            if (this.f95c != null) {
                this.f95c.setMenuVisibility(false);
                this.f95c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f95c = fragment;
        }
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public void mo82b(ViewGroup viewGroup) {
        if (this.f94b != null) {
            this.f94b.mo103c();
            this.f94b = null;
            this.f93a.mo186b();
        }
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public boolean mo80a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public Parcelable mo74a() {
        return null;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo77a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* renamed from: b */
    public long m81b(int i) {
        return i;
    }

    /* renamed from: a */
    private static String m73a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
