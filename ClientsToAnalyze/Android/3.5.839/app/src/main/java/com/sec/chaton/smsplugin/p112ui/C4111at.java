package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import android.widget.AbsListView;

/* compiled from: MessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.at */
/* loaded from: classes.dex */
class C4111at implements AbsListView.RecyclerListener {

    /* renamed from: a */
    final /* synthetic */ C4110as f15331a;

    C4111at(C4110as c4110as) {
        this.f15331a = c4110as;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view instanceof MessageListItem) {
            ((MessageListItem) view).m15833h();
        }
    }
}
