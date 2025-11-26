package com.sec.chaton.msgbox;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.smsplugin.p112ui.MessagingInfoActivity;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.bd */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2639bd implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9489a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9490b;

    MenuItemOnMenuItemClickListenerC2639bd(MsgboxFragment msgboxFragment, String str) {
        this.f9490b = msgboxFragment;
        this.f9489a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.f9490b.getActivity(), (Class<?>) MessagingInfoActivity.class);
        intent.putExtra(MessagingInfoActivity.f14857o, this.f9489a);
        intent.putExtra(MessagingInfoActivity.f14856n, this.f9490b.f9326E);
        intent.putExtra(MessagingInfoActivity.f14859q, this.f9490b.f9329H == EnumC2300t.BROADCAST2 ? MessagingInfoActivity.f14864v : MessagingInfoActivity.f14863u);
        this.f9490b.startActivityForResult(intent, 3);
        return true;
    }
}
