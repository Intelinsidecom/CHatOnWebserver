package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: KeyEventCompatHoneycomb.java */
/* renamed from: android.support.v4.view.y */
/* loaded from: classes.dex */
class C0223y {
    /* renamed from: a */
    public static int m738a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    /* renamed from: a */
    public static boolean m739a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    /* renamed from: b */
    public static boolean m740b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
