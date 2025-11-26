package com.sec.chaton.calllog.view;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.z */
/* loaded from: classes.dex */
class C1497z implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f5423a;

    C1497z(DeleteCallLogFragment deleteCallLogFragment) {
        this.f5423a = deleteCallLogFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!(((CallLogData) this.f5423a.f5290h.get(i)) instanceof SeperatorCallLog)) {
            this.f5423a.f5291i.set(i, Boolean.valueOf(!((Boolean) this.f5423a.f5291i.get(i)).booleanValue()));
            this.f5423a.f5289g.notifyDataSetChanged();
        }
        this.f5423a.m7754g();
    }
}
