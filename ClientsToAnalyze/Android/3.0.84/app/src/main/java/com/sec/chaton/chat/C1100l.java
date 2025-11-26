package com.sec.chaton.chat;

import android.database.DataSetObserver;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.l */
/* loaded from: classes.dex */
class C1100l extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4363a;

    C1100l(ChatFragment chatFragment) {
        this.f4363a = chatFragment;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f4363a.f3526aB.setSelection(this.f4363a.f3527aC.getCount() - 1);
        this.f4363a.f3527aC.unregisterDataSetObserver(this.f4363a.f3659ce);
    }
}
