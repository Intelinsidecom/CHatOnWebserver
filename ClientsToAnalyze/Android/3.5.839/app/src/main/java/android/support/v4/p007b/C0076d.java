package android.support.v4.p007b;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelableCompatHoneycombMR2.java */
/* renamed from: android.support.v4.b.d */
/* loaded from: classes.dex */
class C0076d<T> implements Parcelable.ClassLoaderCreator<T> {

    /* renamed from: a */
    private final InterfaceC0075c<T> f238a;

    public C0076d(InterfaceC0075c<T> interfaceC0075c) {
        this.f238a = interfaceC0075c;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.f238a.mo245a(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f238a.mo245a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.f238a.mo246a(i);
    }
}
