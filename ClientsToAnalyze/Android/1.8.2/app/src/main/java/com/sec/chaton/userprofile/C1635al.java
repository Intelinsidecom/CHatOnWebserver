package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.al */
/* loaded from: classes.dex */
class C1635al implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageRelationshipRankFragment f6122a;

    C1635al(MyPageRelationshipRankFragment myPageRelationshipRankFragment) {
        this.f6122a = myPageRelationshipRankFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (GlobalApplication.m3265f()) {
            if (this.f6122a.f5946w == null || (this.f6122a.f5946w != null && !this.f6122a.f5946w.isShowing())) {
                this.f6122a.m5660a(this.f6122a.m5677i(), this.f6122a.getString(R.string.setting_interaction_rank) + ":" + this.f6122a.m5676h());
                return;
            }
            return;
        }
        if (GlobalApplication.m3265f()) {
            if (this.f6122a.f5946w == null || (this.f6122a.f5946w != null && !this.f6122a.f5946w.isShowing())) {
                this.f6122a.m5660a(this.f6122a.m5677i(), this.f6122a.getString(R.string.setting_interaction_rank) + ":" + this.f6122a.m5676h());
                return;
            }
            return;
        }
        this.f6122a.m5660a(this.f6122a.m5677i(), this.f6122a.getString(R.string.setting_interaction_rank) + ":" + this.f6122a.m5676h());
    }
}
