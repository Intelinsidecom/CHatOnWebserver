package com.sec.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: IcsSpinner.java */
/* renamed from: com.sec.common.widget.s */
/* loaded from: classes.dex */
class C5074s extends IcsListPopupWindow implements InterfaceC5076u {

    /* renamed from: a */
    final /* synthetic */ IcsSpinner f18509a;

    /* renamed from: b */
    private CharSequence f18510b;

    /* renamed from: c */
    private ListAdapter f18511c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5074s(IcsSpinner icsSpinner, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0, i);
        this.f18509a = icsSpinner;
        m19258a(icsSpinner);
        m19261a(true);
        m19256a(0);
        m19259a(new C5075t(this, icsSpinner));
    }

    @Override // com.sec.common.widget.IcsListPopupWindow, com.sec.common.widget.InterfaceC5076u
    /* renamed from: a */
    public void mo19260a(ListAdapter listAdapter) {
        super.mo19260a(listAdapter);
        this.f18511c = listAdapter;
    }

    @Override // com.sec.common.widget.InterfaceC5076u
    /* renamed from: a */
    public void mo19282a(CharSequence charSequence) {
        this.f18510b = charSequence;
    }

    @Override // com.sec.common.widget.IcsListPopupWindow, com.sec.common.widget.InterfaceC5076u
    /* renamed from: a */
    public void mo19255a() {
        int paddingLeft = this.f18509a.getPaddingLeft();
        if (this.f18509a.f18469F == -2) {
            int width = this.f18509a.getWidth();
            m19266d(Math.max(this.f18509a.m19273a((SpinnerAdapter) this.f18511c, this.f18509a.getBackground()), (width - paddingLeft) - this.f18509a.getPaddingRight()));
        } else if (this.f18509a.f18469F == -1) {
            m19266d((this.f18509a.getWidth() - paddingLeft) - this.f18509a.getPaddingRight());
        } else {
            m19266d(this.f18509a.f18469F);
        }
        Drawable background = this.f18509a.getBackground();
        int i = 0;
        if (background != null) {
            background.getPadding(this.f18509a.f18474K);
            i = -this.f18509a.f18474K.left;
        }
        m19263b(i + paddingLeft);
        m19269e(2);
        super.mo19255a();
        m19268e().setChoiceMode(1);
        this.f18509a.setSelection(this.f18509a.m19233g());
    }
}
