package com.sec.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: IcsSpinner.java */
/* renamed from: com.sec.common.widget.v */
/* loaded from: classes.dex */
class C3389v extends IcsListPopupWindow implements InterfaceC3391x {

    /* renamed from: a */
    final /* synthetic */ IcsSpinner f12263a;

    /* renamed from: b */
    private CharSequence f12264b;

    /* renamed from: c */
    private ListAdapter f12265c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3389v(IcsSpinner icsSpinner, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0, i);
        this.f12263a = icsSpinner;
        m11916a(icsSpinner);
        m11919a(true);
        m11914a(0);
        m11917a(new C3390w(this, icsSpinner));
    }

    @Override // com.sec.common.widget.IcsListPopupWindow, com.sec.common.widget.InterfaceC3391x
    /* renamed from: a */
    public void mo11918a(ListAdapter listAdapter) {
        super.mo11918a(listAdapter);
        this.f12265c = listAdapter;
    }

    @Override // com.sec.common.widget.InterfaceC3391x
    /* renamed from: a */
    public void mo11960a(CharSequence charSequence) {
        this.f12264b = charSequence;
    }

    @Override // com.sec.common.widget.IcsListPopupWindow, com.sec.common.widget.InterfaceC3391x
    /* renamed from: a */
    public void mo11913a() {
        int paddingLeft = this.f12263a.getPaddingLeft();
        if (this.f12263a.f12199F == -2) {
            int width = this.f12263a.getWidth();
            m11924d(Math.max(this.f12263a.m11931a((SpinnerAdapter) this.f12265c, this.f12263a.getBackground()), (width - paddingLeft) - this.f12263a.getPaddingRight()));
        } else if (this.f12263a.f12199F == -1) {
            m11924d((this.f12263a.getWidth() - paddingLeft) - this.f12263a.getPaddingRight());
        } else {
            m11924d(this.f12263a.f12199F);
        }
        Drawable background = this.f12263a.getBackground();
        int i = 0;
        if (background != null) {
            background.getPadding(this.f12263a.f12204K);
            i = -this.f12263a.f12204K.left;
        }
        m11921b(i + paddingLeft);
        m11927e(2);
        super.mo11913a();
        m11926e().setChoiceMode(1);
        this.f12263a.setSelection(this.f12263a.m11891g());
    }
}
