package com.sec.chaton.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class StateLinearLayout extends LinearLayout implements InterfaceC4917j {

    /* renamed from: a */
    private InterfaceC4918k f17931a;

    public StateLinearLayout(Context context) {
        super(context);
    }

    public StateLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public StateLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.sec.chaton.widget.InterfaceC4917j
    public void setOnDrawableStateChanged(InterfaceC4918k interfaceC4918k) {
        this.f17931a = interfaceC4918k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f17931a != null) {
            this.f17931a.mo16542a(this, getDrawableState());
        }
    }
}
