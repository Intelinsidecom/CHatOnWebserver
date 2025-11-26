package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.y */
/* loaded from: classes.dex */
class C1419y implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5055a;

    C1419y(AddBuddyFragment addBuddyFragment) {
        this.f5055a = addBuddyFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) throws Resources.NotFoundException {
        if (i != 3) {
            return false;
        }
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f5055a.f3528V, R.string.popup_no_network_connection, 0).show();
            return true;
        }
        this.f5055a.m6243a(true);
        return true;
    }
}
