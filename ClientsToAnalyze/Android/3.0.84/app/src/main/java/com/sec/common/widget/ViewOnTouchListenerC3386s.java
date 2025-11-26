package com.sec.common.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.s */
/* loaded from: classes.dex */
class ViewOnTouchListenerC3386s implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f12259a;

    private ViewOnTouchListenerC3386s(IcsListPopupWindow icsListPopupWindow) {
        this.f12259a = icsListPopupWindow;
    }

    /* synthetic */ ViewOnTouchListenerC3386s(IcsListPopupWindow icsListPopupWindow, C3381n c3381n) {
        this(icsListPopupWindow);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f12259a.f12176b != null && this.f12259a.f12176b.isShowing() && x >= 0 && x < this.f12259a.f12176b.getWidth() && y >= 0 && y < this.f12259a.f12176b.getHeight()) {
            this.f12259a.f12196v.postDelayed(this.f12259a.f12192r, 250L);
            return false;
        }
        if (action == 1) {
            this.f12259a.f12196v.removeCallbacks(this.f12259a.f12192r);
            return false;
        }
        return false;
    }
}
