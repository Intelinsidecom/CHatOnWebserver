package com.sec.chaton.buddy;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.buddy.ap */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0092ap implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f631a;

    /* renamed from: b */
    final /* synthetic */ BuddyGroupEditActivity f632b;

    ViewOnTouchListenerC0092ap(BuddyGroupEditActivity buddyGroupEditActivity, Drawable drawable) {
        this.f632b = buddyGroupEditActivity;
        this.f631a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > (this.f632b.f515m.getMeasuredWidth() - this.f632b.f515m.getPaddingRight()) - this.f631a.getIntrinsicWidth()) {
            this.f632b.f515m.setText("");
            return true;
        }
        return false;
    }
}
