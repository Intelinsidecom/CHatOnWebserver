package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.p025d.C0662o;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bl */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0572bl implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1988a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f1989b;

    MenuItemOnMenuItemClickListenerC0572bl(ChatFragment chatFragment, String str) {
        this.f1989b = chatFragment;
        this.f1988a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f1989b.f1760U.startDelete(3, null, C0662o.m3002c(), "_id='" + this.f1988a + "'", null);
        return true;
    }
}
