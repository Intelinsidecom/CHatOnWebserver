package android.support.v4.view;

import android.os.Build;

/* compiled from: GravityCompat.java */
/* renamed from: android.support.v4.view.n */
/* loaded from: classes.dex */
public class C0212n {

    /* renamed from: a */
    static final InterfaceC0213o f485a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f485a = new C0215q();
        } else {
            f485a = new C0214p();
        }
    }

    /* renamed from: a */
    public static int m726a(int i, int i2) {
        return f485a.mo727a(i, i2);
    }
}
