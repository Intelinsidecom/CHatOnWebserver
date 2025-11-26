package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.widget.SearchView;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.go */
/* loaded from: classes.dex */
class C4268go implements SearchView.OnQueryTextListener {

    /* renamed from: a */
    final /* synthetic */ PluginConversationList f15640a;

    C4268go(PluginConversationList pluginConversationList) {
        this.f15640a = pluginConversationList;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        Intent intent = new Intent();
        intent.setClass(this.f15640a, SearchActivity.class);
        intent.putExtra("query", str);
        this.f15640a.startActivity(intent);
        this.f15640a.f15065i.collapseActionView();
        return true;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }
}
