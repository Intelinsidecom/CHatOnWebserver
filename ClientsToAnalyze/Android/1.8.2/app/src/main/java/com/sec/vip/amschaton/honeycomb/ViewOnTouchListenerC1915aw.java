package com.sec.vip.amschaton.honeycomb;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aw */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1915aw implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f7051a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7052b;

    ViewOnTouchListenerC1915aw(AMSPlayerActivity aMSPlayerActivity, CheckBox checkBox) {
        this.f7052b = aMSPlayerActivity;
        this.f7051a = checkBox;
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
                    this.f7051a.setPressed(true);
                }
                return false;
            case 1:
                view.getDrawingRect(rect);
                if (rect.contains(x, y)) {
                    this.f7051a.setPressed(false);
                    this.f7051a.setChecked(this.f7051a.isChecked() ? false : true);
                }
                return false;
            case 2:
                view.getDrawingRect(rect);
                if (!rect.contains(x, y)) {
                    this.f7051a.setPressed(false);
                }
                return false;
            default:
                return false;
        }
    }
}
