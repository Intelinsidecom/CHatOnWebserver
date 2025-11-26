package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.p007b.InterfaceC0075c;
import android.support.v4.view.ViewPager;

/* compiled from: ViewPager.java */
/* renamed from: android.support.v4.view.cf */
/* loaded from: classes.dex */
final class C0199cf implements InterfaceC0075c<ViewPager.SavedState> {
    C0199cf() {
    }

    @Override // android.support.v4.p007b.InterfaceC0075c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ViewPager.SavedState mo245a(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.SavedState(parcel, classLoader);
    }

    @Override // android.support.v4.p007b.InterfaceC0075c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ViewPager.SavedState[] mo246a(int i) {
        return new ViewPager.SavedState[i];
    }
}
