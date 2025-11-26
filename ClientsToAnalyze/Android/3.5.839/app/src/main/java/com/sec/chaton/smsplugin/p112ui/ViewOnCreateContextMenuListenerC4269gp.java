package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.view.ContextMenu;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p102b.C3790i;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gp */
/* loaded from: classes.dex */
class ViewOnCreateContextMenuListenerC4269gp implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    final /* synthetic */ PluginConversationList f15641a;

    ViewOnCreateContextMenuListenerC4269gp(PluginConversationList pluginConversationList) {
        this.f15641a = pluginConversationList;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Cursor cursor = this.f15641a.f15059c.getCursor();
        if (cursor != null && cursor.getPosition() >= 0) {
            C3789h c3789hM14362g = C3790i.m14318a(this.f15641a, cursor).m14362g();
            contextMenu.setHeaderTitle(c3789hM14362g.m14310b(","));
            contextMenu.add(0, 1, 0, R.string.menu_view);
            if (c3789hM14362g.size() == 1) {
                if (c3789hM14362g.get(0).m14271m()) {
                    contextMenu.add(0, 2, 0, R.string.menu_view_contact);
                } else {
                    contextMenu.add(0, 3, 0, R.string.menu_add_to_contacts);
                }
            }
            contextMenu.add(0, 0, 0, R.string.menu_delete);
        }
    }
}
