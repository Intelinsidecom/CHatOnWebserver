package com.coolots.chaton.common.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class EditTextNotHover extends EditText {
    public EditTextNotHover(Context context) {
        super(context);
    }

    public EditTextNotHover(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextNotHover(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Log.m2963i("dispatchGenericMotionEvent : event = " + event);
        int action = event.getAction();
        if (action == 9 || action == 7 || action == 10) {
            return false;
        }
        return super.dispatchGenericMotionEvent(event);
    }
}
