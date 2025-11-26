package com.sec.chaton.buddy;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.buddy.at */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0096at implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f637a;

    /* renamed from: b */
    final /* synthetic */ BuddyGroupActivity f638b;

    ViewOnTouchListenerC0096at(BuddyGroupActivity buddyGroupActivity, Drawable drawable) {
        this.f638b = buddyGroupActivity;
        this.f637a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > (this.f638b.f482c.getMeasuredWidth() - this.f638b.f482c.getPaddingRight()) - this.f637a.getIntrinsicWidth()) {
            this.f638b.f482c.setText("");
            return true;
        }
        return false;
    }
}
