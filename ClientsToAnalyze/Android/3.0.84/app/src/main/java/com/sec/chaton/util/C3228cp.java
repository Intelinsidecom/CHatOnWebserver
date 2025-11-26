package com.sec.chaton.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.MotionEventCompat;
import android.view.MenuItem;
import android.widget.TextView;
import com.sec.chaton.p044l.C1604c;
import com.sec.chaton.p044l.C1605d;
import com.sec.chaton.p044l.C1606e;
import com.sec.common.CommonApplication;

/* compiled from: UIUtils.java */
/* renamed from: com.sec.chaton.util.cp */
/* loaded from: classes.dex */
public class C3228cp {
    /* renamed from: a */
    public static void m11345a(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (i > 99) {
            strValueOf = "99+";
        }
        textView.setText(strValueOf);
    }

    /* renamed from: a */
    public static void m11343a(MenuItem menuItem) {
        Drawable icon;
        if (menuItem != null && (icon = menuItem.getIcon()) != null) {
            Drawable drawableMutate = icon.mutate();
            if (menuItem.isEnabled()) {
                drawableMutate.setAlpha(CommonApplication.m11493l().getResources().getInteger(C1606e.optionsmenuitem_icon_enabled_alpha));
            } else {
                drawableMutate.setAlpha(CommonApplication.m11493l().getResources().getInteger(C1606e.optionsmenuitem_icon_disabled_alpha));
            }
            menuItem.setIcon(drawableMutate);
        }
    }

    /* renamed from: b */
    public static void m11346b(MenuItem menuItem) {
        LayerDrawable layerDrawable = (LayerDrawable) CommonApplication.m11493l().getResources().getDrawable(C1604c.option_menu_item_badge_wrapper);
        Drawable icon = menuItem.getIcon();
        if (icon != null) {
            layerDrawable.setDrawableByLayerId(C1605d.icon, icon);
        }
        layerDrawable.findDrawableByLayerId(C1605d.badge).setAlpha(MotionEventCompat.ACTION_MASK);
        menuItem.setIcon(layerDrawable);
    }

    /* renamed from: a */
    public static void m11344a(MenuItem menuItem, boolean z) {
        try {
            Drawable drawableFindDrawableByLayerId = ((LayerDrawable) menuItem.getIcon()).findDrawableByLayerId(C1605d.badge);
            if (z) {
                drawableFindDrawableByLayerId.setAlpha(MotionEventCompat.ACTION_MASK);
            } else {
                drawableFindDrawableByLayerId.setAlpha(0);
            }
        } catch (ClassCastException e) {
            throw new IllegalStateException("MenuItem isn't initialized. Calling initializeBadgeOfOptionsMenuItem().");
        }
    }
}
