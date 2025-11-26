package com.sec.vip.amschaton.honeycomb;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ao */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1419ao implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f5051a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5052b;

    ViewOnTouchListenerC1419ao(AMSPlayerActivity aMSPlayerActivity, CheckBox checkBox) {
        this.f5052b = aMSPlayerActivity;
        this.f5051a = checkBox;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = new Rect(0, 0, 0, 0);
        switch (motionEvent.getAction()) {
            case 0:
                view.getDrawingRect(rect);
                if (rect.contains(x, y)) {
                    this.f5051a.setPressed(true);
                }
                return false;
            case 1:
                view.getDrawingRect(rect);
                if (rect.contains(x, y)) {
                    this.f5051a.setPressed(false);
                    this.f5051a.setChecked(this.f5051a.isChecked() ? false : true);
                }
                return false;
            case 2:
                view.getDrawingRect(rect);
                if (!rect.contains(x, y)) {
                    this.f5051a.setPressed(false);
                }
                return false;
            default:
                return false;
        }
    }
}
