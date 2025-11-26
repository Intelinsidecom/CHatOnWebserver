package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.msgbox.j */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0260j implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2001a;

    MenuItemOnMenuItemClickListenerC0260j(MsgboxFragment msgboxFragment) {
        this.f2001a = msgboxFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f2001a.f1979r.startQuery(2, null, ChatONContract.ParticipantTable.m2199a(this.f2001a.f1982u), new String[]{"participants_buddy_no"}, null, null, null);
        this.f2001a.m2448a(this.f2001a.f1982u, this.f2001a.f1986y, this.f2001a.f1985x, this.f2001a.f1987z, this.f2001a.f1960B, this.f2001a.f1967I, this.f2001a.f1983v);
        return true;
    }
}
