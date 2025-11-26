package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class StateLinearLayout extends LinearLayout implements InterfaceC3257d {

    /* renamed from: a */
    private InterfaceC3258e f11768a;

    public StateLinearLayout(Context context) {
        super(context);
    }

    public StateLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StateLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.sec.chaton.widget.InterfaceC3257d
    public void setOnDrawableStateChanged(InterfaceC3258e interfaceC3258e) {
        this.f11768a = interfaceC3258e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11768a != null) {
            this.f11768a.mo11465a(this, getDrawableState());
        }
    }
}
