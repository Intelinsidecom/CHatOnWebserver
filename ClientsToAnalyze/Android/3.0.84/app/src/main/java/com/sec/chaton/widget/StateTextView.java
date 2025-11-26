package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.sec.chaton.p044l.C1603b;

/* loaded from: classes.dex */
public class StateTextView extends AdaptableTextView {

    /* renamed from: a */
    private C3264k f11769a;

    public StateTextView(Context context) {
        this(context, null);
    }

    public StateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1603b.stateTextViewStyle);
    }

    public StateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11769a = new C3264k(this, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11769a != null) {
            this.f11769a.m11488a();
        }
    }
}
