package android.support.v4.view;

import android.os.Bundle;
import android.view.View;

/* compiled from: AccessibilityDelegateCompatJellyBean.java */
/* renamed from: android.support.v4.view.k */
/* loaded from: classes.dex */
class C0209k {
    /* renamed from: a */
    public static Object m723a(InterfaceC0211m interfaceC0211m) {
        return new C0210l(interfaceC0211m);
    }

    /* renamed from: a */
    public static Object m724a(Object obj, View view) {
        return ((View.AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    /* renamed from: a */
    public static boolean m725a(Object obj, View view, int i, Bundle bundle) {
        return ((View.AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
