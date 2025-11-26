package com.sec.vip.cropimage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.vip.cropimage.k */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0738k implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f4477a;

    /* renamed from: b */
    private boolean f4478b = false;

    ViewOnTouchListenerC0738k(ImageModify imageModify) {
        this.f4477a = imageModify;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setSelected(true);
                this.f4478b = false;
                if (view.getId() == this.f4477a.m4288b(this.f4477a.f4415q)) {
                    this.f4478b = true;
                }
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (!this.f4478b) {
                    Rect rect = new Rect(0, 0, 0, 0);
                    view.getDrawingRect(rect);
                    if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        view.setSelected(false);
                    }
                }
                return false;
        }
    }
}
