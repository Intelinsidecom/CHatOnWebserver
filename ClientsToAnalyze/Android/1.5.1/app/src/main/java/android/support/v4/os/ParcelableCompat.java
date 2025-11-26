package android.support.v4.os;

import android.os.Build;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableCompat {
    /* renamed from: a */
    public static Parcelable.Creator m166a(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        if (Build.VERSION.SDK_INT >= 13) {
            C0021b.m169a(parcelableCompatCreatorCallbacks);
        }
        return new C0020a(parcelableCompatCreatorCallbacks);
    }
}
