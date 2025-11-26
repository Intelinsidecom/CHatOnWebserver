package com.sec.vip.cropimage.honeycomb;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.f */
/* loaded from: classes.dex */
class ViewOnTouchListenerC2090f implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f7612a;

    /* renamed from: b */
    private boolean f7613b = false;

    ViewOnTouchListenerC2090f(CropImage cropImage) {
        this.f7612a = cropImage;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setSelected(true);
                this.f7613b = false;
                if (view.getId() == this.f7612a.m7358d(this.f7612a.f7594r)) {
                    this.f7613b = true;
                }
                return false;
            case 1:
            default:
                return false;
            case 2:
                if (!this.f7613b) {
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
