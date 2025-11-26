package com.sec.vip.amschaton;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.ah */
/* loaded from: classes.dex */
class ViewOnTouchListenerC3406ah implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C3402ad f12477a;

    ViewOnTouchListenerC3406ah(C3402ad c3402ad) {
        this.f12477a = c3402ad;
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
                    this.f12477a.f12470e.setPressed(true);
                }
                return false;
            case 1:
                view.getDrawingRect(rect);
                if (rect.contains(x, y)) {
                    this.f12477a.f12470e.setPressed(false);
                    this.f12477a.f12470e.setChecked(this.f12477a.f12470e.isChecked() ? false : true);
                }
                return false;
            case 2:
                view.getDrawingRect(rect);
                if (!rect.contains(x, y)) {
                    this.f12477a.f12470e.setPressed(false);
                }
                return false;
            default:
                return false;
        }
    }
}
