package android.support.v4.view.p009a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean.java */
/* renamed from: android.support.v4.view.a.s */
/* loaded from: classes.dex */
final class C0132s extends AccessibilityNodeProvider {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0133t f457a;

    C0132s(InterfaceC0133t interfaceC0133t) {
        this.f457a = interfaceC0133t;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f457a.mo584a(i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f457a.mo585a(str, i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f457a.mo586a(i, i2, bundle);
    }
}
