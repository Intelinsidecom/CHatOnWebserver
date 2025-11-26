package android.support.v4.p007b;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelableCompat.java */
/* renamed from: android.support.v4.b.b */
/* loaded from: classes.dex */
class C0074b<T> implements Parcelable.Creator<T> {

    /* renamed from: a */
    final InterfaceC0075c<T> f237a;

    public C0074b(InterfaceC0075c<T> interfaceC0075c) {
        this.f237a = interfaceC0075c;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.f237a.mo245a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.f237a.mo246a(i);
    }
}
