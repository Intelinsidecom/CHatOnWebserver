package com.sec.chaton.chat.notification;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.r */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1122r implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4532a;

    ViewOnTouchListenerC1122r(ScreenNotification2 screenNotification2) {
        this.f4532a = screenNotification2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f4532a.f4418s != 10) {
            return false;
        }
        View viewFindViewById = this.f4532a.findViewById(R.id.layout_popup);
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
        this.f4532a.finish();
        return true;
    }
}
