package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1167cd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4388a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4389b;

    DialogInterfaceOnClickListenerC1167cd(BuddyFragment buddyFragment, C1106c c1106c) {
        this.f4389b = buddyFragment;
        this.f4388a = c1106c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4389b.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C2128i(this.f4389b.f3749cm).m9489a("group", false, this.f4388a.m7051b(), (String) null, (String[]) this.f4388a.m7076y().keySet().toArray(new String[0]), 327);
        C2134o.m9568a((Handler) null, this.f4388a.m7051b());
        this.f4389b.f3706bk = this.f4388a;
        this.f4389b.m6326V();
    }
}
