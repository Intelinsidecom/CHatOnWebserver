package android.support.v4.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.Comparator;

/* compiled from: ViewPager.java */
/* renamed from: android.support.v4.view.ch */
/* loaded from: classes.dex */
class C0201ch implements Comparator<View> {
    C0201ch() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) view.getLayoutParams();
        ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams) view2.getLayoutParams();
        if (layoutParams.f440a != layoutParams2.f440a) {
            return layoutParams.f440a ? 1 : -1;
        }
        return layoutParams.f444e - layoutParams2.f444e;
    }
}
