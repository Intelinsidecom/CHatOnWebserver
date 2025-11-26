package com.p001a.p002a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.i */
/* loaded from: classes.dex */
class C0034i extends LinearLayout {

    /* renamed from: a */
    private Dialog f27a;

    public C0034i(Context context, Dialog dialog) {
        super(context);
        this.f27a = dialog;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Display defaultDisplay = this.f27a.getWindow().getWindowManager().getDefaultDisplay();
        float f = getContext().getResources().getDisplayMetrics().density;
        float[] fArr = configuration.orientation == 2 ? DialogC0031f.f16a : DialogC0031f.f17b;
        setLayoutParams(new FrameLayout.LayoutParams(defaultDisplay.getWidth() - ((int) ((fArr[0] * f) + 0.5f)), defaultDisplay.getHeight() - ((int) ((fArr[1] * f) + 0.5f))));
    }
}
