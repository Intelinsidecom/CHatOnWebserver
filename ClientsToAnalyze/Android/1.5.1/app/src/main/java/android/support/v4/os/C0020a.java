package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.os.a */
/* loaded from: classes.dex */
class C0020a implements Parcelable.Creator {

    /* renamed from: a */
    final ParcelableCompatCreatorCallbacks f134a;

    public C0020a(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.f134a = parcelableCompatCreatorCallbacks;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.f134a.mo167b(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.f134a.mo168b(i);
    }
}
