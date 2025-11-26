package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dg */
/* loaded from: classes.dex */
class C4179dg implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15501a;

    C4179dg(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15501a = pluginComposeMessageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        InputMethodManager inputMethodManager;
        if (this.f15501a.f14954Z.m16167a() == 1 && ((inputMethodManager = (InputMethodManager) this.f15501a.getSystemService("input_method")) == null || !inputMethodManager.isFullscreenMode())) {
            this.f15501a.f14943O.requestFocus();
        }
        this.f15501a.m16109w();
    }
}
