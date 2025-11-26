package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bk */
/* loaded from: classes.dex */
class C1661bk implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f6152a;

    C1661bk(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f6152a = relationshipRankFragment2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (view.isPressed() || view.isInTouchMode()) {
            if (i == 0) {
                this.f6152a.m5694a(this.f6152a.f6014w);
                return;
            }
            if (i == 1) {
                if (GlobalApplication.m3265f()) {
                    if (this.f6152a.f6016y == null || (this.f6152a.f6016y != null && !this.f6152a.f6016y.isShowing())) {
                        this.f6152a.m5698a(this.f6152a.m5714i(), this.f6152a.getString(R.string.setting_interaction_rank) + ":" + this.f6152a.m5713h());
                        return;
                    }
                    return;
                }
                if (GlobalApplication.m3265f()) {
                    if (this.f6152a.f6016y == null || (this.f6152a.f6016y != null && !this.f6152a.f6016y.isShowing())) {
                        this.f6152a.m5698a(this.f6152a.m5714i(), this.f6152a.getString(R.string.setting_interaction_rank) + ":" + this.f6152a.m5713h());
                        return;
                    }
                    return;
                }
                this.f6152a.m5698a(this.f6152a.m5714i(), this.f6152a.getString(R.string.setting_interaction_rank) + ":" + this.f6152a.m5713h());
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
