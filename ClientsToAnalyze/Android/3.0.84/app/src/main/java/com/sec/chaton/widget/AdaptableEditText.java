package com.sec.chaton.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import com.sec.chaton.util.C3199bn;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AdaptableEditText extends EditText {
    public AdaptableEditText(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context);
        C3254a.m11479a(this);
    }

    public AdaptableEditText(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        C3254a.m11479a(this);
    }

    public AdaptableEditText(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i);
        C3254a.m11479a(this);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(inputFilterArr);
        for (InputFilter inputFilter : inputFilterArr) {
            if (inputFilter instanceof C3199bn) {
                getInputExtras(true).putInt("maxLength", ((C3199bn) inputFilter).m11161a());
            }
        }
    }
}
