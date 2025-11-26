package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4037o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14551a;

    DialogInterfaceOnClickListenerC4037o(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14551a = setupSpamKeywordList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14551a.m15317a(((C4017bu) this.f14551a.f14301b.get(this.f14551a.f14306g)).m15454a());
        this.f14551a.f14301b.remove(this.f14551a.f14306g);
        this.f14551a.f14306g = 0;
        this.f14551a.m15322a(this.f14551a.getString(R.string.delete_complete));
        this.f14551a.f14302c.notifyDataSetInvalidated();
        this.f14551a.f14305f = 0;
        this.f14551a.m15338f();
        this.f14551a.invalidateOptionsMenu();
    }
}
