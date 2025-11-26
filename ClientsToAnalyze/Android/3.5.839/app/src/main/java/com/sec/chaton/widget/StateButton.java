package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.sec.chaton.p076m.C2570b;

/* loaded from: classes.dex */
public class StateButton extends Button {

    /* renamed from: a */
    private C4925r f17930a;

    public StateButton(Context context) {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2570b.stateButtonStyle);
    }

    public StateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17930a = C4925r.m18725a(this, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f17930a != null) {
            this.f17930a.m18726a();
        }
    }
}
