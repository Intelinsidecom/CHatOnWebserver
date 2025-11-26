package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.ViewPager;

/* renamed from: android.support.v4.view.l */
/* loaded from: classes.dex */
final class C0034l implements ParcelableCompatCreatorCallbacks {
    C0034l() {
    }

    @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewPager.SavedState mo167b(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.SavedState(parcel, classLoader);
    }

    @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewPager.SavedState[] mo168b(int i) {
        return new ViewPager.SavedState[i];
    }
}
