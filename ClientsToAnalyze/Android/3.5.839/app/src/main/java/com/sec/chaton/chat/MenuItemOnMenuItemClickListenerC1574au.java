package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p054a.C1546s;
import com.sec.chaton.chat.p054a.InterfaceC1548u;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4869cg;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.au */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1574au implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1548u f5999a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6000b;

    MenuItemOnMenuItemClickListenerC1574au(ChatFragment chatFragment, InterfaceC1548u interfaceC1548u) {
        this.f6000b = chatFragment;
        this.f5999a = interfaceC1548u;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f6000b.mo8272q();
        C1546s c1546sMo8387b_ = this.f5999a.mo8387b_();
        Intent intentM18493a = C4869cg.m18493a(this.f6000b.f5624cN, this.f6000b.getString(R.string.trunk_opt_header_share), c1546sMo8387b_.f5949a, c1546sMo8387b_.f5950b, (String) null, c1546sMo8387b_.f5951c);
        if (intentM18493a != null) {
            if (!C4809aa.m18104a().m18119a("TrunkShareCheckPopup", (Boolean) false).booleanValue() && c1546sMo8387b_.f5951c == EnumC2214ab.AMS) {
                C4869cg.m18497a(this.f6000b.f5624cN, new DialogInterfaceOnClickListenerC1575av(this, intentM18493a)).mo18752b();
            } else {
                this.f6000b.startActivity(intentM18493a);
            }
        }
        return true;
    }
}
