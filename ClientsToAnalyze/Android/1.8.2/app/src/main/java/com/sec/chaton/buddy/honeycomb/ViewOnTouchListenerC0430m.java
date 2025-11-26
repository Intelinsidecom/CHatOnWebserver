package com.sec.chaton.buddy.honeycomb;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: BuddySelectFragment.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.m */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0430m implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f1646a;

    /* renamed from: b */
    final /* synthetic */ BuddySelectFragment f1647b;

    ViewOnTouchListenerC0430m(BuddySelectFragment buddySelectFragment, Drawable drawable) {
        this.f1647b = buddySelectFragment;
        this.f1646a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || motionEvent.getX() <= (this.f1647b.f1602n.getMeasuredWidth() - this.f1647b.f1602n.getPaddingRight()) - this.f1646a.getIntrinsicWidth()) {
            return false;
        }
        view.playSoundEffect(0);
        this.f1647b.f1602n.setText("");
        return true;
    }
}
