package android.support.v4.os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableCompat {
    public static Parcelable.Creator newCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        if (Build.VERSION.SDK_INT >= 13) {
            ParcelableCompatCreatorHoneycombMR2Stub.instantiate(parcelableCompatCreatorCallbacks);
        }
        return new CompatCreator(parcelableCompatCreatorCallbacks);
    }

    class CompatCreator implements Parcelable.Creator {
        final ParcelableCompatCreatorCallbacks mCallbacks;

        public CompatCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return this.mCallbacks.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return this.mCallbacks.newArray(i);
        }
    }
}
