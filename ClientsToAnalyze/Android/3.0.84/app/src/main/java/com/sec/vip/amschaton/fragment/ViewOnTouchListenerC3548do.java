package com.sec.vip.amschaton.fragment;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.do */
/* loaded from: classes.dex */
class ViewOnTouchListenerC3548do implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f12976a;

    /* renamed from: b */
    final /* synthetic */ AMSViewerFragment f12977b;

    ViewOnTouchListenerC3548do(AMSViewerFragment aMSViewerFragment, CheckBox checkBox) {
        this.f12977b = aMSViewerFragment;
        this.f12976a = checkBox;
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
                    this.f12976a.setPressed(true);
                }
                return false;
            case 1:
                view.getDrawingRect(rect);
                if (rect.contains(x, y)) {
                    this.f12976a.setPressed(false);
                    this.f12976a.setChecked(this.f12976a.isChecked() ? false : true);
                }
                return false;
            case 2:
                view.getDrawingRect(rect);
                if (!rect.contains(x, y)) {
                    this.f12976a.setPressed(false);
                }
                return false;
            default:
                return false;
        }
    }
}
