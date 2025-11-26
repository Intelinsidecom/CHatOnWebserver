package com.sec.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.f */
/* loaded from: classes.dex */
class ViewOnTouchListenerC5163f implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DropPanelMenu f18886a;

    ViewOnTouchListenerC5163f(DropPanelMenu dropPanelMenu) {
        this.f18886a = dropPanelMenu;
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
                    for (int i2 = 0; i2 < this.f18886a.f18736d.size(); i2++) {
                        MenuItemC5166i menuItemC5166i = (MenuItemC5166i) this.f18886a.f18736d.getItem(i2);
                        if (view.equals(menuItemC5166i.m19767b())) {
                            this.f18886a.f18744l.mo19749a(menuItemC5166i);
                        }
                    }
                    this.f18886a.f18738f.dismiss();
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
