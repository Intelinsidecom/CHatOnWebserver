package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.m */
/* loaded from: classes.dex */
class ViewOnTouchListenerC2141m implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f7789a;

    ViewOnTouchListenerC2141m(DropPanelMenu dropPanelMenu) {
        this.f7789a = dropPanelMenu;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f7789a.f7707k.getLeft() > ((int) motionEvent.getX())) {
                    this.f7789a.f7702f.dismiss();
                    break;
                }
                break;
        }
        return false;
    }
}
