package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.sec.chaton.p076m.C2570b;

/* loaded from: classes.dex */
public class NavigationTabWidget extends StateTextView {
    public NavigationTabWidget(Context context) {
        super(context, null);
    }

    public NavigationTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C2570b.actionbarNavigationTabWidgetStyle);
    }

    public NavigationTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTitleText(CharSequence charSequence) {
        setText(charSequence);
    }

    public void setTitleText(int i) {
        setText(i);
    }
}
