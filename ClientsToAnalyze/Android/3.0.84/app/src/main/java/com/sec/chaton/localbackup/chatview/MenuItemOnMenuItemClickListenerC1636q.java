package com.sec.chaton.localbackup.chatview;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3220ch;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.q */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1636q implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6085a;

    /* renamed from: b */
    final /* synthetic */ String f6086b;

    /* renamed from: c */
    final /* synthetic */ EnumC1455w f6087c;

    /* renamed from: d */
    final /* synthetic */ String f6088d;

    /* renamed from: e */
    final /* synthetic */ ChatViewFragment f6089e;

    MenuItemOnMenuItemClickListenerC1636q(ChatViewFragment chatViewFragment, String str, String str2, EnumC1455w enumC1455w, String str3) {
        this.f6089e = chatViewFragment;
        this.f6085a = str;
        this.f6086b = str2;
        this.f6087c = enumC1455w;
        this.f6088d = str3;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intentM11321a = C3220ch.m11321a(this.f6089e.f6034f, this.f6089e.getString(R.string.trunk_opt_header_share), this.f6085a, this.f6086b, (String) null, this.f6087c);
        if (intentM11321a != null) {
            if ((C3159aa.m10962a().m10977a("TrunkShareCheckPopup", (Boolean) false).booleanValue() || !(this.f6087c == EnumC1455w.IMAGE || this.f6087c == EnumC1455w.AMS)) ? false : C3025f.m10540b(this.f6088d)) {
                C3220ch.m11325a(this.f6089e.f6034f, new DialogInterfaceOnClickListenerC1637r(this, intentM11321a)).mo11512b();
                return true;
            }
            this.f6089e.startActivity(intentM11321a);
            return true;
        }
        return true;
    }
}
