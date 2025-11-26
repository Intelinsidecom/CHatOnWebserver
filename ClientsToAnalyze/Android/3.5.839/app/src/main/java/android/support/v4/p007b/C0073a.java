package android.support.v4.p007b;

import android.os.Build;
import android.os.Parcelable;

/* compiled from: ParcelableCompat.java */
/* renamed from: android.support.v4.b.a */
/* loaded from: classes.dex */
public class C0073a {
    /* renamed from: a */
    public static <T> Parcelable.Creator<T> m244a(InterfaceC0075c<T> interfaceC0075c) {
        if (Build.VERSION.SDK_INT >= 13) {
            C0077e.m247a(interfaceC0075c);
        }
        return new C0074b(interfaceC0075c);
    }
}
