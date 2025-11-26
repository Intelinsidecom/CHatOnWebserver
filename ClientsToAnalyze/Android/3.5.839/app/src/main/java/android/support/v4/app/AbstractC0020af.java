package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.AbstractC0144ae;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: FragmentStatePagerAdapter.java */
/* renamed from: android.support.v4.app.af */
/* loaded from: classes.dex */
public abstract class AbstractC0020af extends AbstractC0144ae {

    /* renamed from: a */
    private final AbstractC0069w f96a;

    /* renamed from: b */
    private AbstractC0024aj f97b = null;

    /* renamed from: c */
    private ArrayList<Fragment.SavedState> f98c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<Fragment> f99d = new ArrayList<>();

    /* renamed from: e */
    private Fragment f100e = null;

    /* renamed from: a */
    public abstract Fragment mo86a(int i);

    public AbstractC0020af(AbstractC0069w abstractC0069w) {
        this.f96a = abstractC0069w;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo78a(ViewGroup viewGroup) {
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public Object mo76a(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f99d.size() <= i || (fragment = this.f99d.get(i)) == null) {
            if (this.f97b == null) {
                this.f97b = this.f96a.mo183a();
            }
            Fragment fragmentMo86a = mo86a(i);
            if (this.f98c.size() > i && (savedState = this.f98c.get(i)) != null) {
                fragmentMo86a.setInitialSavedState(savedState);
            }
            while (this.f99d.size() <= i) {
                this.f99d.add(null);
            }
            fragmentMo86a.setMenuVisibility(false);
            fragmentMo86a.setUserVisibleHint(false);
            this.f99d.set(i, fragmentMo86a);
            this.f97b.mo95a(viewGroup.getId(), fragmentMo86a);
            return fragmentMo86a;
        }
        return fragment;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo79a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f97b == null) {
            this.f97b = this.f96a.mo183a();
        }
        while (this.f98c.size() <= i) {
            this.f98c.add(null);
        }
        this.f98c.set(i, this.f96a.mo179a(fragment));
        this.f99d.set(i, null);
        this.f97b.mo97a(fragment);
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public void mo83b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f100e) {
            if (this.f100e != null) {
                this.f100e.setMenuVisibility(false);
                this.f100e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f100e = fragment;
        }
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public void mo82b(ViewGroup viewGroup) {
        if (this.f97b != null) {
            this.f97b.mo103c();
            this.f97b = null;
            this.f96a.mo186b();
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
        Bundle bundle = null;
        if (this.f98c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f98c.size()];
            this.f98c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.f99d.size(); i++) {
            Fragment fragment = this.f99d.get(i);
            if (fragment != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.f96a.mo185a(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo77a(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f98c.clear();
            this.f99d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f98c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentMo181a = this.f96a.mo181a(bundle, str);
                    if (fragmentMo181a != null) {
                        while (this.f99d.size() <= i) {
                            this.f99d.add(null);
                        }
                        fragmentMo181a.setMenuVisibility(false);
                        this.f99d.set(i, fragmentMo181a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
