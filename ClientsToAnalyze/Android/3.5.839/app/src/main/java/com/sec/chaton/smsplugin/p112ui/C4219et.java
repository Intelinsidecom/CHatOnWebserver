package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.et */
/* loaded from: classes.dex */
class C4219et implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15570a;

    C4219et(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15570a = pluginComposeMessageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view != null && (view instanceof MessageListItem)) {
            ((MessageListItem) view).m15837l();
        }
    }
}
