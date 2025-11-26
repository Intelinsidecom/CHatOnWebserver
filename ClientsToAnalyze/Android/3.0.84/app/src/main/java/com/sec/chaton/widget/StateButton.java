package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.sec.chaton.p044l.C1603b;

/* loaded from: classes.dex */
public class StateButton extends Button {

    /* renamed from: a */
    private C3264k f11767a;

    public StateButton(Context context) {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1603b.stateButtonStyle);
    }

    public StateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11767a = new C3264k(this, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11767a != null) {
            this.f11767a.m11488a();
        }
    }
}
