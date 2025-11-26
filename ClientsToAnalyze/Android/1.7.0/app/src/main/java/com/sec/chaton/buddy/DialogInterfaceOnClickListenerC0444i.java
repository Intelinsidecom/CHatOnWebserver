package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0646i;
import com.sec.widget.C1619g;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0444i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0363a f1436a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f1437b;

    DialogInterfaceOnClickListenerC0444i(BuddyFragment buddyFragment, C0363a c0363a) {
        this.f1437b = buddyFragment;
        this.f1436a = c0363a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0627g.m2858a(new C0627g(), -1, new C0646i(this.f1437b.f1148f, Integer.parseInt(this.f1436a.m2308a())));
        C1619g.m5889a(this.f1437b.getActivity(), this.f1437b.getResources().getString(R.string.trunk_toast_deleted), 0).show();
    }
}
