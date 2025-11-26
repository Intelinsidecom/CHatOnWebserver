package com.sec.chaton.chat;

import android.R;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cj */
/* loaded from: classes.dex */
class ViewOnCreateContextMenuListenerC1014cj implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4092a;

    ViewOnCreateContextMenuListenerC1014cj(ChatFragment chatFragment) {
        this.f4092a = chatFragment;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        MenuItem menuItemFindItem = contextMenu.findItem(R.id.paste);
        if (menuItemFindItem != null) {
            menuItemFindItem.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1015ck(this));
        }
    }
}
