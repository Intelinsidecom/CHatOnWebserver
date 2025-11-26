package com.sec.common.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.o */
/* loaded from: classes.dex */
class ViewOnTouchListenerC5070o implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f18505a;

    private ViewOnTouchListenerC5070o(IcsListPopupWindow icsListPopupWindow) {
        this.f18505a = icsListPopupWindow;
    }

    /* synthetic */ ViewOnTouchListenerC5070o(IcsListPopupWindow icsListPopupWindow, C5065j c5065j) {
        this(icsListPopupWindow);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f18505a.f18446b != null && this.f18505a.f18446b.isShowing() && x >= 0 && x < this.f18505a.f18446b.getWidth() && y >= 0 && y < this.f18505a.f18446b.getHeight()) {
            this.f18505a.f18466v.postDelayed(this.f18505a.f18462r, 250L);
            return false;
        }
        if (action == 1) {
            this.f18505a.f18466v.removeCallbacks(this.f18505a.f18462r);
            return false;
        }
        return false;
    }
}
