package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1346u;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1240bj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f4321a;

    ViewOnClickListenerC1240bj(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f4321a = relationshipRankFragment2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            this.f4321a.m4351a(this.f4321a.m4363f(), this.f4321a.getString(R.string.setting_interaction_rank) + ":" + this.f4321a.m4362e());
        }
    }
}
