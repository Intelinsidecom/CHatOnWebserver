package android.support.v4.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ActionBarDrawerToggleHoneycomb.java */
/* renamed from: android.support.v4.app.i */
/* loaded from: classes.dex */
class C0055i {

    /* renamed from: a */
    private static final int[] f166a = {R.attr.homeAsUpIndicator};

    /* renamed from: a */
    public static Object m164a(Object obj, Activity activity, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object c0056j = obj == null ? new C0056j(activity) : obj;
        C0056j c0056j2 = (C0056j) c0056j;
        if (c0056j2.f167a != null) {
            try {
                c0056j2.f168b.invoke(activity.getActionBar(), Integer.valueOf(i));
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return c0056j;
    }

    /* renamed from: a */
    public static Drawable m163a(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(f166a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }
}
