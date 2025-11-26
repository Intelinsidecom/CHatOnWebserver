package com.sec.vip.cropimage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.g */
/* loaded from: classes.dex */
class ViewOnTouchListenerC2083g implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f7571a;

    /* renamed from: b */
    private boolean f7572b = false;

    ViewOnTouchListenerC2083g(ImageModify imageModify) {
        this.f7571a = imageModify;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setSelected(true);
                this.f7572b = false;
                if (view.getId() == this.f7571a.m7282b(this.f7571a.f7507s)) {
                    this.f7572b = true;
                }
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (!this.f7572b) {
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
