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
/* renamed from: com.sec.chaton.buddy.cp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0585cp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Object f2547a;

    /* renamed from: b */
    final /* synthetic */ C0584co f2548b;

    DialogInterfaceOnClickListenerC0585cp(C0584co c0584co, Object obj) {
        this.f2548b = c0584co;
        this.f2547a = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2548b.f2546a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C1330h(this.f2548b.f2546a.f1837bX).m5716a("group", false, ((C0513c) this.f2547a).m3976c(), (String) null, (String[]) ((C0513c) this.f2547a).m3999z().keySet().toArray(new String[0]), 327);
        C1335m.m5782a(null, ((C0513c) this.f2547a).m3975b());
        this.f2548b.f2546a.f1786aX = (C0513c) this.f2547a;
        this.f2548b.f2546a.m3262Y();
    }
}
