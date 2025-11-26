package com.sec.chaton.dialogmenu;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class ListItem {

    /* renamed from: a */
    public final String f1831a;

    /* renamed from: b */
    public final Drawable f1832b;

    /* renamed from: c */
    public final int f1833c;

    public ListItem(Resources resources, int i, int i2, int i3) {
        this.f1831a = resources.getString(i);
        if (i2 != -1) {
            this.f1832b = resources.getDrawable(i2);
        } else {
            this.f1832b = null;
        }
        this.f1833c = i3;
    }
}
