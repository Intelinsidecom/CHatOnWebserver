package com.samsung.sdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class ExEditText extends EditText {
    public ExEditText(Context context) {
        super(context);
    }

    public ExEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        RelativeLayout.LayoutParams layoutParams;
        if (getSelectionStart() != getSelectionEnd() && getText().length() > 0 && (layoutParams = (RelativeLayout.LayoutParams) getLayoutParams()) != null) {
            layoutParams.bottomMargin = 0;
            setLayoutParams(layoutParams);
        }
        super.onSelectionChanged(selStart, selEnd);
    }
}
