package com.android.p029ex.editstyledtext;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.DynamicDrawableSpan;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ah */
/* loaded from: classes.dex */
public class C0368ah extends DynamicDrawableSpan {

    /* renamed from: a */
    C0367ag f885a;

    public C0368ah(int i, int i2, Spannable spannable) {
        super(0);
        this.f885a = new C0367ag(i, i2, spannable);
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return this.f885a;
    }

    /* renamed from: a */
    public void m1318a(int i) {
        this.f885a.m1317a(i);
    }
}
