package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;

/* compiled from: KeyEventCompat.java */
/* renamed from: android.support.v4.view.s */
/* loaded from: classes.dex */
public class C0217s {

    /* renamed from: a */
    static final InterfaceC0221w f486a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f486a = new C0220v();
        } else {
            f486a = new C0218t();
        }
    }

    /* renamed from: a */
    public static boolean m730a(KeyEvent keyEvent, int i) {
        return f486a.mo735a(keyEvent.getMetaState(), i);
    }

    /* renamed from: a */
    public static boolean m729a(KeyEvent keyEvent) {
        return f486a.mo736b(keyEvent.getMetaState());
    }

    /* renamed from: b */
    public static void m731b(KeyEvent keyEvent) {
        f486a.mo734a(keyEvent);
    }
}
