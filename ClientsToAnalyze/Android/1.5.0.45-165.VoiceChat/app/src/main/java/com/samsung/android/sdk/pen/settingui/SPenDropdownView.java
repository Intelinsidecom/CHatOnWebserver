package com.samsung.android.sdk.pen.settingui;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
class SPenDropdownView {
    protected final View anchor;
    private Drawable background;
    private View root;
    protected final PopupWindow window;
    protected final WindowManager windowManager;

    public SPenDropdownView(View anchor) {
        this.anchor = anchor;
        this.window = new PopupWindow(anchor.getContext());
        this.windowManager = (WindowManager) anchor.getContext().getSystemService("window");
        onCreate();
    }

    protected void onCreate() {
        this.window.setTouchInterceptor(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SPenDropdownView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 4) {
                    return false;
                }
                SPenDropdownView.this.window.dismiss();
                return true;
            }
        });
    }

    protected void show() {
        if (this.root == null) {
            throw new IllegalStateException("illegalStateException preShow");
        }
        if (this.background != null) {
            this.window.setBackgroundDrawable(this.background);
        }
        this.window.setTouchable(true);
        this.window.setFocusable(true);
        this.window.setOutsideTouchable(true);
        this.window.setContentView(this.root);
    }

    protected void setContentView(View root) {
        this.root = root;
        this.window.setContentView(root);
    }

    protected void setBackgroundDrawable(Drawable background) {
        this.background = background;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.window.setOnDismissListener(listener);
    }

    public void dismiss() {
        this.window.dismiss();
    }
}
