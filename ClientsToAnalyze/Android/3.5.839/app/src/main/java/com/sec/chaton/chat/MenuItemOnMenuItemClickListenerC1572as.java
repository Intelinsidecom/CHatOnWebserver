package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.chat.p054a.C1546s;
import com.sec.chaton.chat.p054a.InterfaceC1545r;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.util.C4869cg;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.as */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1572as implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1545r f5995a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f5996b;

    MenuItemOnMenuItemClickListenerC1572as(ChatFragment chatFragment, InterfaceC1545r interfaceC1545r) {
        this.f5996b = chatFragment;
        this.f5995a = interfaceC1545r;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f5996b.mo8272q();
        C1546s c1546sMo8411d_ = this.f5995a.mo8411d_();
        Intent intentM18488a = C4869cg.m18488a(this.f5996b.f5624cN, (Class<?>) PluginComposeMessageActivity.class, c1546sMo8411d_.f5949a, c1546sMo8411d_.f5950b, c1546sMo8411d_.f5951c);
        if (intentM18488a != null) {
            this.f5996b.startActivity(intentM18488a);
            return true;
        }
        return true;
    }
}
