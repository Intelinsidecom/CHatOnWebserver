package com.sec.chaton.buddy;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.buddy.c */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0110c implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f653a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f654b;

    ViewOnTouchListenerC0110c(BuddyFragment buddyFragment, Drawable drawable) {
        this.f654b = buddyFragment;
        this.f653a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > (this.f654b.f459o.getMeasuredWidth() - this.f654b.f459o.getPaddingRight()) - this.f653a.getIntrinsicWidth()) {
            this.f654b.f459o.setText("");
            return true;
        }
        return false;
    }
}
