package com.sec.vip.cropimage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.n */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1597n implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f5619a;

    /* renamed from: b */
    private boolean f5620b = false;

    ViewOnTouchListenerC1597n(ImageModify imageModify) {
        this.f5619a = imageModify;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setSelected(true);
                this.f5620b = false;
                if (view.getId() == this.f5619a.m5688b(this.f5619a.f5469t)) {
                    this.f5620b = true;
                }
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (!this.f5620b) {
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
