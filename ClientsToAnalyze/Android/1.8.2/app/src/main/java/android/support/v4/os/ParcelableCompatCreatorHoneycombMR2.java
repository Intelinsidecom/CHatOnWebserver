package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelableCompatHoneycombMR2.java */
/* loaded from: classes.dex */
class ParcelableCompatCreatorHoneycombMR2 implements Parcelable.ClassLoaderCreator {
    private final ParcelableCompatCreatorCallbacks mCallbacks;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.mCallbacks = parcelableCompatCreatorCallbacks;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.mCallbacks.createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.mCallbacks.newArray(i);
    }
}
