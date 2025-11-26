package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.z */
/* loaded from: classes.dex */
class ViewOnTouchListenerC3692z implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f13621a;

    ViewOnTouchListenerC3692z(EditTextWithClearButton editTextWithClearButton) {
        this.f13621a = editTextWithClearButton;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = this.f13621a.findViewById(R.id.EditTextClearlayout);
        int action = motionEvent.getAction();
        if (action == 0) {
            viewFindViewById.setBackgroundDrawable(this.f13621a.getResources().getDrawable(R.drawable.input_line_focus));
            return false;
        }
        if (action == 1) {
            viewFindViewById.setBackgroundDrawable(this.f13621a.getResources().getDrawable(R.drawable.input_line_focus));
            this.f13621a.invalidate();
            return false;
        }
        return false;
    }
}
