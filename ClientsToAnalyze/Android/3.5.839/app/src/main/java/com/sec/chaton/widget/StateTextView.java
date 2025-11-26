package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.sec.chaton.p076m.C2570b;

/* loaded from: classes.dex */
public class StateTextView extends AdaptableTextView {

    /* renamed from: a */
    private C4925r f17932a;

    public StateTextView(Context context) {
        this(context, null);
    }

    public StateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2570b.stateTextViewStyle);
    }

    public StateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17932a = new C4925r(this, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f17932a != null) {
            this.f17932a.m18726a();
        }
    }
}
