package android.support.v4.view;

import android.os.Build;

/* loaded from: classes.dex */
public class MenuCompat {

    /* renamed from: a */
    static final InterfaceC0036n f143a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f143a = new C0031i();
        } else {
            f143a = new C0033k();
        }
    }
}
