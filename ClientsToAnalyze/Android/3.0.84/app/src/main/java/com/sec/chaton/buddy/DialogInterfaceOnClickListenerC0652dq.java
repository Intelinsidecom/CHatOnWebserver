package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0652dq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2871a;

    DialogInterfaceOnClickListenerC0652dq(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2871a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2871a.f1923O, R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C1330h(this.f2871a.f1925Q).m5716a("group", false, this.f2871a.f1940o.getText().toString().trim(), (String) null, this.f2871a.m3478d().m3445j(), 327);
        C1335m.m5782a(null, this.f2871a.f1940o.getText().toString().trim());
        if (this.f2871a.f1918J != null && !this.f2871a.f1918J.isShowing()) {
            this.f2871a.f1918J.show();
        }
    }
}
