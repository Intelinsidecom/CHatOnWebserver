package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3983an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14424a;

    DialogInterfaceOnClickListenerC3983an(SetupSpamNumberList setupSpamNumberList) {
        this.f14424a = setupSpamNumberList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14424a.m15364a(((C4017bu) this.f14424a.f14366p.get(this.f14424a.f14371v)).m15454a());
        this.f14424a.f14366p.remove(this.f14424a.f14371v);
        this.f14424a.f14371v = 0;
        this.f14424a.m15374b(this.f14424a.getString(R.string.delete_complete));
        this.f14424a.f14367q.notifyDataSetInvalidated();
        this.f14424a.f14370u = 0;
        this.f14424a.m15396m();
        this.f14424a.invalidateOptionsMenu();
    }
}
