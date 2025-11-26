package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.chat.p023a.C0910n;
import com.sec.chaton.chat.p023a.InterfaceC0912p;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3220ch;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ad */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0926ad implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0912p f3864a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f3865b;

    MenuItemOnMenuItemClickListenerC0926ad(ChatFragment chatFragment, InterfaceC0912p interfaceC0912p) {
        this.f3865b = chatFragment;
        this.f3864a = interfaceC0912p;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f3865b.mo5019t();
        C0910n c0910nMo5095f = this.f3864a.mo5095f();
        Intent intentM11321a = C3220ch.m11321a(this.f3865b.f3672cr, this.f3865b.getString(R.string.trunk_opt_header_share), c0910nMo5095f.f3840a, c0910nMo5095f.f3841b, (String) null, c0910nMo5095f.f3842c);
        if (intentM11321a != null) {
            if ((C3159aa.m10962a().m10977a("TrunkShareCheckPopup", (Boolean) false).booleanValue() || !(c0910nMo5095f.f3842c == EnumC1455w.IMAGE || c0910nMo5095f.f3842c == EnumC1455w.AMS)) ? false : C3025f.m10540b(c0910nMo5095f.f3840a)) {
                C3220ch.m11325a(this.f3865b.f3672cr, new DialogInterfaceOnClickListenerC0927ae(this, intentM11321a)).mo11512b();
                return true;
            }
            this.f3865b.startActivity(intentM11321a);
            return true;
        }
        return true;
    }
}
