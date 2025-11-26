package com.sec.chaton.buddy;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.buddy.ag */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0083ag implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f617a;

    /* renamed from: b */
    final /* synthetic */ ViewOnFocusChangeListenerC0106bc f618b;

    ViewOnTouchListenerC0083ag(ViewOnFocusChangeListenerC0106bc viewOnFocusChangeListenerC0106bc, Drawable drawable) {
        this.f618b = viewOnFocusChangeListenerC0106bc;
        this.f617a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > (this.f618b.f649a.f467w.getMeasuredWidth() - this.f618b.f649a.f467w.getPaddingRight()) - this.f617a.getIntrinsicWidth()) {
            this.f618b.f649a.f467w.setText("");
            return true;
        }
        return false;
    }
}
