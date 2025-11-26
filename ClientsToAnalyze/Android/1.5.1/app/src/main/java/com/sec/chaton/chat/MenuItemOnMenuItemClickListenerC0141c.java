package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.c */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0141c implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f944a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f945b;

    MenuItemOnMenuItemClickListenerC0141c(ChatFragment chatFragment, String str) {
        this.f945b = chatFragment;
        this.f944a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f945b.f743M.startDelete(3, null, ChatONContract.MessageTable.f1726a, "_id='" + this.f944a + "'", null);
        return true;
    }
}
