package com.sec.chaton.chat;

import android.database.DataSetObserver;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.w */
/* loaded from: classes.dex */
class C1876w extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f7094a;

    C1876w(ChatFragment chatFragment) {
        this.f7094a = chatFragment;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f7094a.f5527aT.setSelection(this.f7094a.f5528aU.getCount() - 1);
        this.f7094a.f5528aU.unregisterDataSetObserver(this.f7094a.f5614cD);
    }
}
