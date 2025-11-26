package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ek */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1277ek implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4810a;

    DialogInterfaceOnClickListenerC1277ek(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4810a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4810a.f3801P, R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C2128i(this.f4810a.f3803R).m9489a("group", false, this.f4810a.f3820q.getText().toString().trim(), (String) null, this.f4810a.m6633d().m6606i(), 327);
        C2134o.m9568a((Handler) null, this.f4810a.f3820q.getText().toString().trim());
        if (this.f4810a.f3796K != null && !this.f4810a.f3796K.isShowing()) {
            this.f4810a.f3796K.show();
        }
    }
}
