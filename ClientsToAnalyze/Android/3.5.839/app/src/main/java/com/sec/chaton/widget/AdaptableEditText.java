package com.sec.chaton.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import com.sec.chaton.util.C4849bn;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AdaptableEditText extends EditText {
    public AdaptableEditText(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context);
        C4908a.m18711a(this);
    }

    public AdaptableEditText(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        C4908a.m18711a(this);
    }

    public AdaptableEditText(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i);
        C4908a.m18711a(this);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(inputFilterArr);
        for (InputFilter inputFilter : inputFilterArr) {
            if (inputFilter instanceof C4849bn) {
                getInputExtras(true).putInt("maxLength", ((C4849bn) inputFilter).m18336a());
            }
        }
    }
}
