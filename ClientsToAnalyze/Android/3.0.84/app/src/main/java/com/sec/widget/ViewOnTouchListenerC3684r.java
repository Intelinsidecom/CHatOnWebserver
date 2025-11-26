package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.r */
/* loaded from: classes.dex */
class ViewOnTouchListenerC3684r implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f13594a;

    ViewOnTouchListenerC3684r(DropPanelMenu dropPanelMenu) {
        this.f13594a = dropPanelMenu;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f13594a.f13376k.getLeft() > ((int) motionEvent.getX())) {
                    this.f13594a.f13371f.dismiss();
                    break;
                }
                break;
        }
        return false;
    }
}
