package com.sec.chaton.smsplugin.p112ui;

import android.widget.AbsListView;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.eu */
/* loaded from: classes.dex */
class C4220eu implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15571a;

    C4220eu(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15571a = pluginComposeMessageActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f15571a.f14953Y.getSelectedView() != null && !this.f15571a.f14943O.isFocused()) {
            this.f15571a.f14953Y.getSelectedView().requestFocus();
            this.f15571a.f14953Y.getSelectedView().setSelected(false);
        }
        if (i + 1 + i2 > i3) {
            this.f15571a.f14953Y.setTranscriptMode(2);
        } else if (i2 != 0) {
            this.f15571a.f14953Y.setTranscriptMode(0);
        }
    }
}
