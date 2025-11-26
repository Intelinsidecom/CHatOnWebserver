package com.sec.chaton.calllog.view;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.z */
/* loaded from: classes.dex */
class C0886z implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f3478a;

    C0886z(DeleteCallLogFragment deleteCallLogFragment) {
        this.f3478a = deleteCallLogFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!(((CallLogData) this.f3478a.f3317h.get(i)) instanceof SeperatorCallLog)) {
            this.f3478a.f3318i.set(i, Boolean.valueOf(!((Boolean) this.f3478a.f3318i.get(i)).booleanValue()));
            this.f3478a.f3316g.notifyDataSetChanged();
        }
        this.f3478a.m4598g();
    }
}
