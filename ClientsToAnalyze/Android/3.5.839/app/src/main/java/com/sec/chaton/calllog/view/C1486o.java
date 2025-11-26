package com.sec.chaton.calllog.view;

import android.widget.AbsListView;
import android.widget.ListView;
import com.sec.chaton.R;

/* compiled from: CallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.o */
/* loaded from: classes.dex */
class C1486o implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ CallLogFragment f5414a;

    C1486o(CallLogFragment callLogFragment) {
        this.f5414a = callLogFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ListView listView = (ListView) absListView.findViewById(R.id.calllog_list);
        if (listView != null) {
            CallLogFragment.f5258d = listView.getFirstVisiblePosition();
            if (listView.getChildAt(0) != null) {
                CallLogFragment.f5259e = listView.getChildAt(0).getTop();
            }
        }
    }
}
