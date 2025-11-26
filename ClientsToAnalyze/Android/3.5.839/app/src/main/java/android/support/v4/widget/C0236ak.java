package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: SlidingPaneLayout.java */
/* renamed from: android.support.v4.widget.ak */
/* loaded from: classes.dex */
class C0236ak extends C0235aj {

    /* renamed from: a */
    private Method f550a;

    /* renamed from: b */
    private Field f551b;

    C0236ak() {
        try {
            this.f550a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (NoSuchMethodException e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f551b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f551b.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    @Override // android.support.v4.widget.C0235aj, android.support.v4.widget.InterfaceC0234ai
    /* renamed from: a */
    public void mo823a(SlidingPaneLayout slidingPaneLayout, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f550a != null && this.f551b != null) {
            try {
                this.f551b.setBoolean(view, true);
                this.f550a.invoke(view, (Object[]) null);
            } catch (Exception e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.mo823a(slidingPaneLayout, view);
            return;
        }
        view.invalidate();
    }
}
