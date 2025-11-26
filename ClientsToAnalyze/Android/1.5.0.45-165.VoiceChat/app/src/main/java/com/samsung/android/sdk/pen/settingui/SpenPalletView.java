package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
class SpenPalletView extends LinearLayout {
    private onLayoutListner mPalletViewOnLayoutListner;

    interface onLayoutListner {
        void onLayout(boolean z, int i, int i2, int i3, int i4);
    }

    public SpenPalletView(Context mContext) {
        super(mContext);
        this.mPalletViewOnLayoutListner = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mPalletViewOnLayoutListner != null) {
            this.mPalletViewOnLayoutListner.onLayout(changed, left, top, right, bottom);
        }
    }

    public void setOnLayoutListener(onLayoutListner mOnLayoutListner) {
        this.mPalletViewOnLayoutListner = mOnLayoutListner;
    }
}
