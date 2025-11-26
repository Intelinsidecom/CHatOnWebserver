package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter.java */
/* renamed from: android.support.v4.view.ae */
/* loaded from: classes.dex */
public abstract class AbstractC0144ae {

    /* renamed from: a */
    private DataSetObservable f461a = new DataSetObservable();

    /* renamed from: a */
    public abstract boolean mo80a(View view, Object obj);

    /* renamed from: b */
    public abstract int mo612b();

    /* renamed from: a */
    public void mo78a(ViewGroup viewGroup) {
        mo610a((View) viewGroup);
    }

    /* renamed from: a */
    public Object mo76a(ViewGroup viewGroup, int i) {
        return mo608a((View) viewGroup, i);
    }

    /* renamed from: a */
    public void mo79a(ViewGroup viewGroup, int i, Object obj) {
        mo611a((View) viewGroup, i, obj);
    }

    /* renamed from: b */
    public void mo83b(ViewGroup viewGroup, int i, Object obj) {
        m615b((View) viewGroup, i, obj);
    }

    /* renamed from: b */
    public void mo82b(ViewGroup viewGroup) {
        mo614b((View) viewGroup);
    }

    /* renamed from: a */
    public void mo610a(View view) {
    }

    /* renamed from: a */
    public Object mo608a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    /* renamed from: a */
    public void mo611a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /* renamed from: b */
    public void m615b(View view, int i, Object obj) {
    }

    /* renamed from: b */
    public void mo614b(View view) {
    }

    /* renamed from: a */
    public Parcelable mo74a() {
        return null;
    }

    /* renamed from: a */
    public void mo77a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* renamed from: a */
    public int mo607a(Object obj) {
        return -1;
    }

    /* renamed from: c */
    public void m617c() {
        this.f461a.notifyChanged();
    }

    /* renamed from: a */
    public void m609a(DataSetObserver dataSetObserver) {
        this.f461a.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public void m613b(DataSetObserver dataSetObserver) {
        this.f461a.unregisterObserver(dataSetObserver);
    }

    /* renamed from: c */
    public CharSequence m616c(int i) {
        return null;
    }

    /* renamed from: d */
    public float m618d(int i) {
        return 1.0f;
    }
}
