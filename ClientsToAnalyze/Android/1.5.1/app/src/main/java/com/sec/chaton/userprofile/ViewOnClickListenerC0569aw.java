package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.userprofile.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC0569aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRank2 f3549a;

    ViewOnClickListenerC0569aw(RelationshipRank2 relationshipRank2) {
        this.f3549a = relationshipRank2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3549a.m3335a(this.f3549a.m3349h(), this.f3549a.getString(C0062R.string.setting_interaction_rank) + ":" + this.f3549a.m3348g());
    }
}
