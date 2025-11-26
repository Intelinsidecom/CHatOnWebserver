package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.r */
/* loaded from: classes.dex */
class ViewOnTouchListenerC2146r implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f7814a;

    ViewOnTouchListenerC2146r(EditTextWithClearButton editTextWithClearButton) {
        this.f7814a = editTextWithClearButton;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getX() > (view.getMeasuredWidth() - view.getPaddingRight()) - this.f7814a.f7711a.getIntrinsicWidth()) {
            view.playSoundEffect(0);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }
        }
        return false;
    }
}
