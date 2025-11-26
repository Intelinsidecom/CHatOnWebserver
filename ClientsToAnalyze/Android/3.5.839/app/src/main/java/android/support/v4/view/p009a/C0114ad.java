package android.support.v4.view.p009a;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompatIcs.java */
/* renamed from: android.support.v4.view.a.ad */
/* loaded from: classes.dex */
class C0114ad {
    /* renamed from: a */
    public static Object m490a() {
        return AccessibilityRecord.obtain();
    }

    /* renamed from: a */
    public static void m491a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    /* renamed from: b */
    public static void m493b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    /* renamed from: a */
    public static void m492a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    /* renamed from: c */
    public static void m494c(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
