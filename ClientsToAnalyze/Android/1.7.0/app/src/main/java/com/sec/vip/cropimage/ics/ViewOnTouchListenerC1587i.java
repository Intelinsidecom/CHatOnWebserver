package com.sec.vip.cropimage.ics;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.i */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1587i implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f5604a;

    /* renamed from: b */
    private boolean f5605b = false;

    ViewOnTouchListenerC1587i(CropImage cropImage) {
        this.f5604a = cropImage;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setSelected(true);
                this.f5605b = false;
                if (view.getId() == this.f5604a.m5793d(this.f5604a.f5579q)) {
                    this.f5605b = true;
                }
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (!this.f5605b) {
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
