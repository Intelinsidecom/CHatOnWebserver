package android.support.v4.view.p009a;

import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompatJellyBean.java */
/* renamed from: android.support.v4.view.a.i */
/* loaded from: classes.dex */
class C0122i {
    /* renamed from: a */
    public static boolean m574a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    /* renamed from: a */
    public static void m573a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    /* renamed from: a */
    public static void m572a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
    }

    /* renamed from: b */
    public static int m575b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMovementGranularities();
    }

    /* renamed from: c */
    public static boolean m577c(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    /* renamed from: b */
    public static void m576b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }
}
