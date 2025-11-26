package com.sec.chaton.buddy;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.buddy.aq */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0093aq implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f633a;

    /* renamed from: b */
    final /* synthetic */ BuddyGroupEditActivity f634b;

    ViewOnTouchListenerC0093aq(BuddyGroupEditActivity buddyGroupEditActivity, Drawable drawable) {
        this.f634b = buddyGroupEditActivity;
        this.f633a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > (this.f634b.f517o.getMeasuredWidth() - this.f634b.f517o.getPaddingRight()) - this.f633a.getIntrinsicWidth()) {
            this.f634b.f517o.setText("");
            return true;
        }
        return false;
    }
}
