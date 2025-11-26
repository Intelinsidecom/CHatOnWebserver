package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.e */
/* loaded from: classes.dex */
class ViewOnTouchListenerC5162e implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f18885a;

    ViewOnTouchListenerC5162e(DropPanelMenu dropPanelMenu) {
        this.f18885a = dropPanelMenu;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f18885a.f18743k.getLeft() > ((int) motionEvent.getX())) {
                    this.f18885a.f18738f.dismiss();
                    break;
                }
                break;
        }
        return false;
    }
}
