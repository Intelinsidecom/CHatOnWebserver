package com.sec.vip.cropimage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.vip.cropimage.s */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0746s implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f4512a;

    /* renamed from: b */
    private boolean f4513b = false;

    ViewOnTouchListenerC0746s(CropImage cropImage) {
        this.f4512a = cropImage;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setSelected(true);
                this.f4513b = false;
                if (view.getId() == this.f4512a.m4243b(this.f4512a.f4378q)) {
                    this.f4513b = true;
                }
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (!this.f4513b) {
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
