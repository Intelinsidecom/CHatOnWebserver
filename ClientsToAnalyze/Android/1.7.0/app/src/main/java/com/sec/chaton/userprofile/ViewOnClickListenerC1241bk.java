package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bk */
/* loaded from: classes.dex */
class ViewOnClickListenerC1241bk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f4322a;

    ViewOnClickListenerC1241bk(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f4322a = relationshipRankFragment2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4322a.f4208p.setSelected(false);
        this.f4322a.f4209q.setSelected(false);
        this.f4322a.f4210r.setSelected(false);
        this.f4322a.f4211s.setSelected(false);
        this.f4322a.f4208p.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        this.f4322a.f4209q.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        this.f4322a.f4210r.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        this.f4322a.f4211s.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        switch (view.getId()) {
            case R.id.week1 /* 2131427983 */:
                this.f4322a.f4208p.setSelected(true);
                this.f4322a.m4349a(1);
                this.f4322a.f4212t.setText(this.f4322a.getString(R.string.interaction_rank_week, 1));
                this.f4322a.f4208p.setShadowLayer(1.0f, -1.0f, 1.0f, R.color.interaction_week_click_shadow);
                this.f4322a.f4213u = 1;
                break;
            case R.id.week2 /* 2131427984 */:
                this.f4322a.f4209q.setSelected(true);
                this.f4322a.m4349a(2);
                this.f4322a.f4212t.setText(this.f4322a.getString(R.string.interaction_rank_week, 2));
                this.f4322a.f4209q.setShadowLayer(1.0f, -1.0f, 1.0f, R.color.interaction_week_click_shadow);
                this.f4322a.f4213u = 2;
                break;
            case R.id.week3 /* 2131427985 */:
                this.f4322a.f4210r.setSelected(true);
                this.f4322a.m4349a(3);
                this.f4322a.f4212t.setText(this.f4322a.getString(R.string.interaction_rank_week, 3));
                this.f4322a.f4210r.setShadowLayer(1.0f, -1.0f, 1.0f, R.color.interaction_week_click_shadow);
                this.f4322a.f4213u = 3;
                break;
            case R.id.week4 /* 2131427986 */:
                this.f4322a.f4211s.setSelected(true);
                this.f4322a.m4349a(4);
                this.f4322a.f4212t.setText(this.f4322a.getString(R.string.interaction_rank_week, 4));
                this.f4322a.f4211s.setShadowLayer(1.0f, -1.0f, 1.0f, R.color.interaction_week_click_shadow);
                this.f4322a.f4213u = 4;
                break;
        }
    }
}
