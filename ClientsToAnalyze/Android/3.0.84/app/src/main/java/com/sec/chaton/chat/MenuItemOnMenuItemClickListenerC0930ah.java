package com.sec.chaton.chat;

import android.database.Cursor;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p023a.InterfaceC0908l;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ah */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0930ah implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3873a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC0908l f3874b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f3875c;

    MenuItemOnMenuItemClickListenerC0930ah(ChatFragment chatFragment, int i, InterfaceC0908l interfaceC0908l) {
        this.f3875c = chatFragment;
        this.f3873a = i;
        this.f3874b = interfaceC0908l;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3875c.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.chat_view_menu_delete_message);
        Cursor cursor = (Cursor) this.f3875c.f3526aB.getAdapter().getItem(this.f3873a);
        abstractC3271aM11494a.mo11509b(C1075eq.m5317a(EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type"))))).mo11511b(true).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0932aj(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0931ai(this));
        abstractC3271aM11494a.mo11512b();
        return true;
    }
}
