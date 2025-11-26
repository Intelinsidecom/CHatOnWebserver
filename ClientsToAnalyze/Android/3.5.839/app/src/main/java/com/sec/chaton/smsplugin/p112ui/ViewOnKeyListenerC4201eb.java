package com.sec.chaton.smsplugin.p112ui;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.eb */
/* loaded from: classes.dex */
class ViewOnKeyListenerC4201eb implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15534a;

    ViewOnKeyListenerC4201eb(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15534a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 67 || this.f15534a.f14950V.length() != 0) {
            return false;
        }
        this.f15534a.m16058d(false);
        this.f15534a.f14996ap.m14439a((CharSequence) null, true);
        return true;
    }
}
