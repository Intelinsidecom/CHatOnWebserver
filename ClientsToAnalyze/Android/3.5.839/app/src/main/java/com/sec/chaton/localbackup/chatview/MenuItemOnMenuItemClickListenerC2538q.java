package com.sec.chaton.localbackup.chatview;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4869cg;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.q */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2538q implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9129a;

    /* renamed from: b */
    final /* synthetic */ String f9130b;

    /* renamed from: c */
    final /* synthetic */ EnumC2214ab f9131c;

    /* renamed from: d */
    final /* synthetic */ ChatViewFragment f9132d;

    MenuItemOnMenuItemClickListenerC2538q(ChatViewFragment chatViewFragment, String str, String str2, EnumC2214ab enumC2214ab) {
        this.f9132d = chatViewFragment;
        this.f9129a = str;
        this.f9130b = str2;
        this.f9131c = enumC2214ab;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intentM18493a = C4869cg.m18493a(this.f9132d.f9078f, this.f9132d.getString(R.string.trunk_opt_header_share), this.f9129a, this.f9130b, (String) null, this.f9131c);
        if (intentM18493a != null) {
            if (!C4809aa.m18104a().m18119a("TrunkShareCheckPopup", (Boolean) false).booleanValue() && this.f9131c == EnumC2214ab.AMS) {
                C4869cg.m18497a(this.f9132d.f9078f, new DialogInterfaceOnClickListenerC2539r(this, intentM18493a)).mo18752b();
            } else {
                this.f9132d.startActivity(intentM18493a);
            }
        }
        return true;
    }
}
