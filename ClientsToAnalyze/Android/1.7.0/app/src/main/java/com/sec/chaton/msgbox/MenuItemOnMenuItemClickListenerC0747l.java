package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p025d.C0654g;
import com.sec.widget.C1619g;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.l */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0747l implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2549a;

    MenuItemOnMenuItemClickListenerC0747l(MsgboxFragment msgboxFragment) {
        this.f2549a = msgboxFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f2549a.f2504j.startQuery(2, null, C0654g.m2980a(this.f2549a.f2507m), new String[]{"participants_buddy_no"}, null, null, null);
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 != iM2526a && -2 != iM2526a) {
            this.f2549a.m3176a(this.f2549a.f2507m, this.f2549a.f2511q, this.f2549a.f2510p, this.f2549a.f2512r, this.f2549a.f2514t, this.f2549a.f2488B, this.f2549a.f2508n);
        } else {
            C1619g.m5888a(this.f2549a.getActivity(), R.string.popup_no_network_connection, 0).show();
        }
        return true;
    }
}
