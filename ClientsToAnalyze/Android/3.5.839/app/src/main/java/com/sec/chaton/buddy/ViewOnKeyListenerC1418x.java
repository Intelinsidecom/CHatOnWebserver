package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.x */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1418x implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5054a;

    ViewOnKeyListenerC1418x(AddBuddyFragment addBuddyFragment) {
        this.f5054a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) throws Resources.NotFoundException {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f5054a.f3528V, R.string.popup_no_network_connection, 0).show();
            return true;
        }
        this.f5054a.m6243a(true);
        return true;
    }
}
