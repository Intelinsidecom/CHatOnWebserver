package android.support.v4.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* compiled from: ActionBarDrawerToggleHoneycomb.java */
/* renamed from: android.support.v4.app.j */
/* loaded from: classes.dex */
class C0056j {

    /* renamed from: a */
    public Method f167a;

    /* renamed from: b */
    public Method f168b;

    /* renamed from: c */
    public ImageView f169c;

    C0056j(Activity activity) {
        try {
            this.f167a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.f168b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            View viewFindViewById = activity.findViewById(R.id.home);
            if (viewFindViewById != null) {
                ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                if (viewGroup.getChildCount() == 2) {
                    View childAt = viewGroup.getChildAt(0);
                    View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                    if (childAt2 instanceof ImageView) {
                        this.f169c = (ImageView) childAt2;
                    }
                }
            }
        }
    }
}
