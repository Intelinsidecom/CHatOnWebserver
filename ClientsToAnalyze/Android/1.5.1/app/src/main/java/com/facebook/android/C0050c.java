package com.facebook.android;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* renamed from: com.facebook.android.c */
/* loaded from: classes.dex */
class C0050c extends LinearLayout {

    /* renamed from: a */
    private Dialog f215a;

    public C0050c(Context context, Dialog dialog) {
        super(context);
        this.f215a = dialog;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Display defaultDisplay = this.f215a.getWindow().getWindowManager().getDefaultDisplay();
        float f = getContext().getResources().getDisplayMetrics().density;
        float[] fArr = configuration.orientation == 2 ? FbDialog.f204a : FbDialog.f205b;
        setLayoutParams(new FrameLayout.LayoutParams(defaultDisplay.getWidth() - ((int) ((fArr[0] * f) + 0.5f)), defaultDisplay.getHeight() - ((int) ((f * fArr[1]) + 0.5f))));
    }
}
