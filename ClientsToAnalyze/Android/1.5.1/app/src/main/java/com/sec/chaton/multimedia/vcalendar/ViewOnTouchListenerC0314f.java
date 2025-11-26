package com.sec.chaton.multimedia.vcalendar;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.multimedia.vcalendar.f */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0314f implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f2270a;

    /* renamed from: b */
    final /* synthetic */ VCalendarListFragment f2271b;

    ViewOnTouchListenerC0314f(VCalendarListFragment vCalendarListFragment, Drawable drawable) {
        this.f2271b = vCalendarListFragment;
        this.f2270a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > (this.f2271b.f2223f.getMeasuredWidth() - this.f2271b.f2223f.getPaddingRight()) - this.f2270a.getIntrinsicWidth()) {
            this.f2271b.f2223f.setText("");
            return true;
        }
        return false;
    }
}
