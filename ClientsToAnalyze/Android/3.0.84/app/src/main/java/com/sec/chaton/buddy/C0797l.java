package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.l */
/* loaded from: classes.dex */
class C0797l implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3091a;

    C0797l(AddBuddyFragment addBuddyFragment) {
        this.f3091a = addBuddyFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (i != 3) {
            return false;
        }
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f3091a.f1676X, R.string.popup_no_network_connection, 0).show();
            return true;
        }
        this.f3091a.m3175a(true);
        return true;
    }
}
