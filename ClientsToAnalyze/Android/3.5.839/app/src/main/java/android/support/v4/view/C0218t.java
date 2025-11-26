package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: KeyEventCompat.java */
/* renamed from: android.support.v4.view.t */
/* loaded from: classes.dex */
class C0218t implements InterfaceC0221w {
    C0218t() {
    }

    /* renamed from: a */
    private static int m732a(int i, int i2, int i3, int i4, int i5) {
        boolean z = (i2 & i3) != 0;
        int i6 = i4 | i5;
        boolean z2 = (i2 & i6) != 0;
        if (z) {
            if (z2) {
                throw new IllegalArgumentException("bad arguments");
            }
            return i & (i6 ^ (-1));
        }
        if (z2) {
            return i & (i3 ^ (-1));
        }
        return i;
    }

    /* renamed from: a */
    public int mo733a(int i) {
        int i2 = (i & 192) != 0 ? i | 1 : i;
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    @Override // android.support.v4.view.InterfaceC0221w
    /* renamed from: a */
    public boolean mo735a(int i, int i2) {
        return m732a(m732a(mo733a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
    }

    @Override // android.support.v4.view.InterfaceC0221w
    /* renamed from: b */
    public boolean mo736b(int i) {
        return (mo733a(i) & 247) == 0;
    }

    @Override // android.support.v4.view.InterfaceC0221w
    /* renamed from: a */
    public void mo734a(KeyEvent keyEvent) {
    }
}
