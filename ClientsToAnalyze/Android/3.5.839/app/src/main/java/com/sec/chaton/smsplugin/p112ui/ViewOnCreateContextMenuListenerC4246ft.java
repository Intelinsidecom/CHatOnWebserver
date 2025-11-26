package com.sec.chaton.smsplugin.p112ui;

import android.view.ContextMenu;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ft */
/* loaded from: classes.dex */
class ViewOnCreateContextMenuListenerC4246ft implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15601a;

    ViewOnCreateContextMenuListenerC4246ft(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15601a = pluginComposeMessageActivity;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (contextMenuInfo != null) {
            C3782a c3782a = ((ContextMenuContextMenuInfoC4282hb) contextMenuInfo).f15663a;
            MenuItemOnMenuItemClickListenerC4262gi menuItemOnMenuItemClickListenerC4262gi = new MenuItemOnMenuItemClickListenerC4262gi(this.f15601a, c3782a);
            contextMenu.setHeaderTitle(c3782a.m14264f());
            if (c3782a.m14271m()) {
                contextMenu.add(0, 12, 0, R.string.menu_view_contact).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4262gi);
            } else if (C4149cd.m16416a(c3782a)) {
                contextMenu.add(0, 13, 0, R.string.menu_add_to_contacts).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC4262gi);
            }
        }
    }
}
