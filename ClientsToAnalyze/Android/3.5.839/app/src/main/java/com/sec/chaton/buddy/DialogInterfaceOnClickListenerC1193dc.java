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
/* renamed from: com.sec.chaton.buddy.dc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1193dc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Object f4421a;

    /* renamed from: b */
    final /* synthetic */ C1192db f4422b;

    DialogInterfaceOnClickListenerC1193dc(C1192db c1192db, Object obj) {
        this.f4422b = c1192db;
        this.f4421a = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4422b.f4420a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C2128i(this.f4422b.f4420a.f3749cm).m9489a("group", false, ((C1106c) this.f4421a).m7051b(), (String) null, (String[]) ((C1106c) this.f4421a).m7076y().keySet().toArray(new String[0]), 327);
        C2134o.m9568a((Handler) null, ((C1106c) this.f4421a).m7046a());
        this.f4422b.f4420a.f3706bk = (C1106c) this.f4421a;
        this.f4422b.f4420a.m6326V();
    }
}
