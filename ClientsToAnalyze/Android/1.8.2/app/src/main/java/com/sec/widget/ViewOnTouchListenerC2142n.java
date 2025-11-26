package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.n */
/* loaded from: classes.dex */
class ViewOnTouchListenerC2142n implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f7790a;

    ViewOnTouchListenerC2142n(DropPanelMenu dropPanelMenu) {
        this.f7790a = dropPanelMenu;
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
                    for (int i2 = 0; i2 < this.f7790a.f7700d.size(); i2++) {
                        MenuItemC2145q menuItemC2145q = (MenuItemC2145q) this.f7790a.f7700d.getItem(i2);
                        if (view.equals(menuItemC2145q.m7513b())) {
                            this.f7790a.f7708l.mo7495a(menuItemC2145q);
                        }
                    }
                    this.f7790a.f7702f.dismiss();
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
