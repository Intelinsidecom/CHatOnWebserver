package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.r */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1630r implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f5750a;

    ViewOnTouchListenerC1630r(EditTextWithClearButton editTextWithClearButton) {
        this.f5750a = editTextWithClearButton;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getX() > (view.getMeasuredWidth() - view.getPaddingRight()) - this.f5750a.f5652a.getIntrinsicWidth()) {
            view.setSoundEffectsEnabled(true);
            view.playSoundEffect(0);
            view.setSoundEffectsEnabled(false);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }
        }
        return false;
    }
}
