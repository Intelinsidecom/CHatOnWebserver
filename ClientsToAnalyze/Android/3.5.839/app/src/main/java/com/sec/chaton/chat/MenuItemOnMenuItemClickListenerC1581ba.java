package com.sec.chaton.chat;

import android.database.Cursor;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p054a.InterfaceC1542o;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ba */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1581ba implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ int f6015a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC1542o f6016b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6017c;

    MenuItemOnMenuItemClickListenerC1581ba(ChatFragment chatFragment, int i, InterfaceC1542o interfaceC1542o) {
        this.f6017c = chatFragment;
        this.f6015a = i;
        this.f6016b = interfaceC1542o;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f6017c.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.chat_view_menu_delete);
        Cursor cursor = (Cursor) this.f6017c.f5527aT.getAdapter().getItem(this.f6015a);
        abstractC4932aM18733a.mo18749b(C1736gi.m8631a(EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type"))))).mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1595bc(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1594bb(this));
        abstractC4932aM18733a.mo18752b();
        return true;
    }
}
