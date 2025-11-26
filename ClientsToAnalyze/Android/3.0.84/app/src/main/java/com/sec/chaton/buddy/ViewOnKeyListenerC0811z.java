package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.z */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0811z implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3107a;

    ViewOnKeyListenerC0811z(AddBuddyFragment addBuddyFragment) {
        this.f3107a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f3107a.f1676X, R.string.popup_no_network_connection, 0).show();
            return true;
        }
        this.f3107a.m3175a(true);
        return true;
    }
}
