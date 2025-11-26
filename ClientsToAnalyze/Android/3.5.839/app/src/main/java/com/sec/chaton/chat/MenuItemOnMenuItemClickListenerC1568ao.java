package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p054a.InterfaceC1549v;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ao */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1568ao implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1549v f5988a;

    /* renamed from: b */
    final /* synthetic */ long f5989b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f5990c;

    MenuItemOnMenuItemClickListenerC1568ao(ChatFragment chatFragment, InterfaceC1549v interfaceC1549v, long j) {
        this.f5990c = chatFragment;
        this.f5988a = interfaceC1549v;
        this.f5989b = j;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5990c.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.chat_view_menu_recall);
        abstractC4932aM18733a.mo18746b(R.string.message_will_be_recalled).mo18751b(true);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1570aq(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1569ap(this));
        abstractC4932aM18733a.mo18752b();
        return true;
    }
}
