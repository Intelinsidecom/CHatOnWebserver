package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.s */
/* loaded from: classes.dex */
class ViewOnTouchListenerC3685s implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f13595a;

    ViewOnTouchListenerC3685s(DropPanelMenu dropPanelMenu) {
        this.f13595a = dropPanelMenu;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LinearLayout linearLayout = (LinearLayout) view;
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    linearLayout.getChildAt(i).setPressed(true);
                }
                return true;
            case 1:
                if (view.isPressed()) {
                    for (int i2 = 0; i2 < this.f13595a.f13369d.size(); i2++) {
                        MenuItemC3688v menuItemC3688v = (MenuItemC3688v) this.f13595a.f13369d.getItem(i2);
                        if (view.equals(menuItemC3688v.m13282b())) {
                            this.f13595a.f13377l.mo13264a(menuItemC3688v);
                        }
                    }
                    this.f13595a.f13371f.dismiss();
                    view.setPressed(false);
                    for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
                        linearLayout.getChildAt(i3).setPressed(false);
                    }
                }
                return true;
            case 2:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < 0 || view.getWidth() < x || y < 0 || view.getHeight() < y) {
                    view.setPressed(false);
                    for (int i4 = 0; i4 < linearLayout.getChildCount(); i4++) {
                        linearLayout.getChildAt(i4).setPressed(false);
                    }
                }
                return true;
            case 3:
                if (view.isPressed()) {
                    view.setPressed(false);
                    for (int i5 = 0; i5 < linearLayout.getChildCount(); i5++) {
                        linearLayout.getChildAt(i5).setPressed(false);
                    }
                }
                return true;
            default:
                return true;
        }
    }
}
