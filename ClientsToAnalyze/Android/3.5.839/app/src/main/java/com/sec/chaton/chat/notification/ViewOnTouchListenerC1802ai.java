package com.sec.chaton.chat.notification;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ai */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1802ai implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6812a;

    ViewOnTouchListenerC1802ai(ScreenNotification2 screenNotification2) {
        this.f6812a = screenNotification2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f6812a.f6737J != 10) {
            return false;
        }
        View viewFindViewById = this.f6812a.findViewById(R.id.layout_popup);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int left = viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = viewFindViewById.getTop();
        int height = viewFindViewById.getHeight() + top;
        if (x <= 0 || y <= 0 || motionEvent.getAction() != 0) {
            return false;
        }
        if (x > left && x < width && y > top && y < height) {
            return false;
        }
        this.f6812a.m8882g();
        return true;
    }
}
