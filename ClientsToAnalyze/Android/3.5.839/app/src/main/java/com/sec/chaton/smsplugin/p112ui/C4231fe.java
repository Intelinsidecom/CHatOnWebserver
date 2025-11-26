package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fe */
/* loaded from: classes.dex */
class C4231fe implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15584a;

    C4231fe(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15584a = pluginComposeMessageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view != null) {
            ((MessageListItem) view).m15837l();
        }
    }
}
