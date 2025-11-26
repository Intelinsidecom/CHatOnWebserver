package android.support.v4.view.p009a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat.java */
/* renamed from: android.support.v4.view.a.v */
/* loaded from: classes.dex */
final class C0135v extends AccessibilityNodeProvider {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0136w f458a;

    C0135v(InterfaceC0136w interfaceC0136w) {
        this.f458a = interfaceC0136w;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f458a.mo587a(i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f458a.mo588a(str, i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f458a.mo589a(i, i2, bundle);
    }
}
