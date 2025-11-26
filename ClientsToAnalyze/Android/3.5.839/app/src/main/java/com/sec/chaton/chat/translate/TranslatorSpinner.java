package com.sec.chaton.chat.translate;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

/* loaded from: classes.dex */
public class TranslatorSpinner extends Spinner {

    /* renamed from: a */
    private int f6989a;

    public TranslatorSpinner(Context context) {
        super(context);
        this.f6989a = 0;
    }

    public TranslatorSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6989a = 0;
    }

    public TranslatorSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6989a = 0;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f6989a == getSelectedItemPosition() && getOnItemSelectedListener() != null) {
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), getSelectedItemPosition(), getSelectedItemId());
        }
        if (!z) {
            this.f6989a = getSelectedItemPosition();
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
