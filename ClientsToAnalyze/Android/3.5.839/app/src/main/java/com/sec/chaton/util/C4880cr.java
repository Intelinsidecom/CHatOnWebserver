package com.sec.chaton.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MenuItem;
import android.widget.TextView;
import com.sec.chaton.p076m.C2571c;
import com.sec.chaton.p076m.C2572d;
import com.sec.chaton.p076m.C2573e;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;

/* compiled from: UIUtils.java */
/* renamed from: com.sec.chaton.util.cr */
/* loaded from: classes.dex */
public class C4880cr {

    /* renamed from: a */
    private static final String f17808a = C4880cr.class.getSimpleName();

    /* renamed from: a */
    public static void m18525a(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (i > 99) {
            strValueOf = "99+";
        }
        textView.setText(strValueOf);
    }

    /* renamed from: a */
    public static void m18523a(MenuItem menuItem) {
        Drawable icon;
        if (menuItem != null && (icon = menuItem.getIcon()) != null) {
            Drawable drawableMutate = icon.mutate();
            if (menuItem.isEnabled()) {
                drawableMutate.setAlpha(CommonApplication.m18732r().getResources().getInteger(C2573e.optionsmenuitem_icon_enabled_alpha));
            } else {
                drawableMutate.setAlpha(CommonApplication.m18732r().getResources().getInteger(C2573e.optionsmenuitem_icon_disabled_alpha));
            }
            menuItem.setIcon(drawableMutate);
        }
    }

    /* renamed from: b */
    public static void m18526b(MenuItem menuItem) {
        LayerDrawable layerDrawable = (LayerDrawable) CommonApplication.m18732r().getResources().getDrawable(C2571c.option_menu_item_badge_wrapper);
        Drawable icon = menuItem.getIcon();
        if (icon != null) {
            layerDrawable.setDrawableByLayerId(C2572d.icon, icon);
        }
        layerDrawable.findDrawableByLayerId(C2572d.badge).setAlpha(255);
        menuItem.setIcon(layerDrawable);
    }

    /* renamed from: a */
    public static void m18524a(MenuItem menuItem, boolean z) {
        try {
            LayerDrawable layerDrawable = (LayerDrawable) menuItem.getIcon();
            if (layerDrawable == null) {
                if (C4996f.f18229a.f18173e) {
                    C4996f.f18229a.m18894h(f17808a, "Icon is null of menu item.");
                }
            } else {
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(C2572d.badge);
                if (z) {
                    drawableFindDrawableByLayerId.setAlpha(255);
                } else {
                    drawableFindDrawableByLayerId.setAlpha(0);
                }
            }
        } catch (ClassCastException e) {
            throw new IllegalStateException("MenuItem isn't initialized. Calling initializeBadgeOfOptionsMenuItem().");
        }
    }
}
