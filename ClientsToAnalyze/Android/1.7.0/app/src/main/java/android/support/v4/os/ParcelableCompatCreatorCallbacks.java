package android.support.v4.os;

import android.os.Parcel;

/* loaded from: classes.dex */
public interface ParcelableCompatCreatorCallbacks {
    Object createFromParcel(Parcel parcel, ClassLoader classLoader);

    Object[] newArray(int i);
}
