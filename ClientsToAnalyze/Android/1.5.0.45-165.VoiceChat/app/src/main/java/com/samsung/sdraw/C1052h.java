package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/* renamed from: com.samsung.sdraw.h */
/* loaded from: classes.dex */
class C1052h extends ImageButton {

    /* renamed from: a */
    private boolean f1743a;

    public C1052h(Context context) {
        super(context);
        this.f1743a = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas arg0) {
        if (!this.f1743a) {
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                if (getHeight() < 30) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                    layoutParams.height = 30;
                    setLayoutParams(layoutParams);
                }
            } else if ((getLayoutParams() instanceof RelativeLayout.LayoutParams) && getHeight() < 30) {
                int height = 30 - getHeight();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams2.height = 30;
                layoutParams2.width = height + getWidth();
                setLayoutParams(layoutParams2);
            }
            this.f1743a = true;
        }
        super.onDraw(arg0);
    }
}
