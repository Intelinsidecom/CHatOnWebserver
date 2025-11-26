package com.sec.chaton.chat;

import android.R;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ab */
/* loaded from: classes.dex */
class ViewOnCreateContextMenuListenerC0526ab implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1876a;

    ViewOnCreateContextMenuListenerC0526ab(ChatFragment chatFragment) {
        this.f1876a = chatFragment;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        MenuItem menuItemFindItem = contextMenu.findItem(R.id.paste);
        if (menuItemFindItem != null) {
            menuItemFindItem.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0590g(this));
        }
    }
}
