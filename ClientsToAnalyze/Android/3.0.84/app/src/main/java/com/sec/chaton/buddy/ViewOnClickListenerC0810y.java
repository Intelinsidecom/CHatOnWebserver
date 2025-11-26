package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC0810y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3106a;

    ViewOnClickListenerC0810y(AddBuddyFragment addBuddyFragment) {
        this.f3106a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException, UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f3106a.f1676X, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f3106a.m3175a(true);
        }
    }
}
