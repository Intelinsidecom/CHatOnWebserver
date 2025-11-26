package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes.dex */
public class ExpandableHeightGridView extends GridView {

    /* renamed from: a */
    boolean f18761a;

    public ExpandableHeightGridView(Context context) {
        super(context);
        this.f18761a = false;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18761a = false;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18761a = false;
    }

    /* renamed from: a */
    public boolean m19635a() {
        return this.f18761a;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (m19635a()) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setExpanded(boolean z) {
        this.f18761a = z;
    }
}
