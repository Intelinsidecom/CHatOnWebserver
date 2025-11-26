package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0563bu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0513c f2522a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f2523b;

    DialogInterfaceOnClickListenerC0563bu(BuddyFragment buddyFragment, C0513c c0513c) {
        this.f2523b = buddyFragment;
        this.f2522a = c0513c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2523b.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C1330h(this.f2523b.f1837bX).m5716a("group", false, this.f2522a.m3976c(), (String) null, (String[]) this.f2522a.m3999z().keySet().toArray(new String[0]), 327);
        C1335m.m5782a(null, this.f2522a.m3976c());
        this.f2523b.f1786aX = this.f2522a;
        this.f2523b.m3262Y();
    }
}
