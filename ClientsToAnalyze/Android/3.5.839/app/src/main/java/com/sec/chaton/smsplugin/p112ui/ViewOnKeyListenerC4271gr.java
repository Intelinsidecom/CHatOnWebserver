package com.sec.chaton.smsplugin.p112ui;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gr */
/* loaded from: classes.dex */
class ViewOnKeyListenerC4271gr implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ PluginConversationList f15644a;

    ViewOnKeyListenerC4271gr(PluginConversationList pluginConversationList) {
        this.f15644a = pluginConversationList;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 67:
                    long selectedItemId = this.f15644a.getListView().getSelectedItemId();
                    if (selectedItemId > 0) {
                        PluginConversationList.m16137a(selectedItemId, this.f15644a.f15058b);
                    }
                    return true;
            }
        }
        return false;
    }
}
