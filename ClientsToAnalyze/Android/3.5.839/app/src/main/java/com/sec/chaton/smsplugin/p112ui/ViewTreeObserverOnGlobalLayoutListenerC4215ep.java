package com.sec.chaton.smsplugin.p112ui;

import android.graphics.Rect;
import android.view.ViewTreeObserver;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ep */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC4215ep implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15561a;

    ViewTreeObserverOnGlobalLayoutListenerC4215ep(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15561a = pluginComposeMessageActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f15561a.f14993am) {
            Rect rect = new Rect();
            this.f15561a.f14967aM.getWindowVisibleDisplayFrame(rect);
            if (this.f15561a.f14967aM.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                this.f15561a.m15976aC();
            } else {
                this.f15561a.m15975aB();
            }
        }
    }
}
