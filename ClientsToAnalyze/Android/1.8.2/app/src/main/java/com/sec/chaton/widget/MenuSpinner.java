package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

/* loaded from: classes.dex */
public class MenuSpinner extends Spinner {
    public MenuSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getSelectedItemPosition() > 0) {
            removeViewInLayout(getChildAt(0));
        }
    }
}
