package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes.dex */
public class ExpandableHeightGridView extends GridView {

    /* renamed from: a */
    boolean f13394a;

    public ExpandableHeightGridView(Context context) {
        super(context);
        this.f13394a = false;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13394a = false;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13394a = false;
    }

    /* renamed from: a */
    public boolean m13103a() {
        return this.f13394a;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (m13103a()) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setExpanded(boolean z) {
        this.f13394a = z;
    }
}
