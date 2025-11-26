package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.widget.C5179v;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ae */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2613ae implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9435a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9436b;

    MenuItemOnMenuItemClickListenerC2613ae(MsgboxFragment msgboxFragment, String str) {
        this.f9436b = msgboxFragment;
        this.f9435a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (C4149cd.m16435f(this.f9436b.getActivity(), this.f9435a)) {
            C5179v.m19810a(this.f9436b.getActivity(), R.string.noti_unregistered_as_spamnumber, 0).show();
            return true;
        }
        return true;
    }
}
