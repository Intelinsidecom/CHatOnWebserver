package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ad */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0519ad implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2421a;

    ViewOnKeyListenerC0519ad(AddBuddyFragment addBuddyFragment) {
        this.f2421a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        this.f2421a.m3197a();
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030024");
        }
        this.f2421a.f1699t.requestFocus();
        this.f2421a.m3166a(view);
        return true;
    }
}
