package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ac */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0518ac implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2420a;

    ViewOnKeyListenerC0518ac(AddBuddyFragment addBuddyFragment) {
        this.f2420a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        this.f2420a.m3197a();
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030023");
        }
        this.f2420a.f1695p.requestFocus();
        this.f2420a.m3166a(view);
        return true;
    }
}
