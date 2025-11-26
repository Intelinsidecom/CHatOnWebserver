package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.m */
/* loaded from: classes.dex */
class ViewOnTouchListenerC5170m implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f18912a;

    ViewOnTouchListenerC5170m(EditTextWithClearButton editTextWithClearButton) {
        this.f18912a = editTextWithClearButton;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = this.f18912a.findViewById(R.id.EditTextClearlayout);
        int action = motionEvent.getAction();
        if (action == 0) {
            viewFindViewById.setBackgroundDrawable(this.f18912a.getResources().getDrawable(R.drawable.input_line_focus));
            return false;
        }
        if (action == 1) {
            viewFindViewById.setBackgroundDrawable(this.f18912a.getResources().getDrawable(R.drawable.input_line_focus));
            this.f18912a.invalidate();
            return false;
        }
        return false;
    }
}
