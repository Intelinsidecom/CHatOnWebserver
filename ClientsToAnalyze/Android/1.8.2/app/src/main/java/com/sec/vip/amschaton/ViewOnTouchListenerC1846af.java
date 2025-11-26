package com.sec.vip.amschaton;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.af */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1846af implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1841aa f6776a;

    ViewOnTouchListenerC1846af(DialogC1841aa dialogC1841aa) {
        this.f6776a = dialogC1841aa;
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
                    this.f6776a.f6768c.setPressed(true);
                }
                return false;
            case 1:
                view.getDrawingRect(rect);
                if (rect.contains(x, y)) {
                    this.f6776a.f6768c.setPressed(false);
                    this.f6776a.f6768c.setChecked(this.f6776a.f6768c.isChecked() ? false : true);
                }
                return false;
            case 2:
                view.getDrawingRect(rect);
                if (!rect.contains(x, y)) {
                    this.f6776a.f6768c.setPressed(false);
                }
                return false;
            default:
                return false;
        }
    }
}
