package com.sec.vip.amschaton;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: classes.dex */
public class AMSEditText extends EditText {
    public AMSEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        int i = editorInfo.imeOptions & MotionEventCompat.ACTION_MASK;
        if ((i & 6) != 0) {
            editorInfo.imeOptions = i ^ editorInfo.imeOptions;
            editorInfo.imeOptions |= 6;
        }
        if ((editorInfo.imeOptions & 1073741824) != 0) {
            editorInfo.imeOptions &= -1073741825;
        }
        return inputConnectionOnCreateInputConnection;
    }
}
