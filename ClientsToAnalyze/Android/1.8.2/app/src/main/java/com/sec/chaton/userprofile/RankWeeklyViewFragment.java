package com.sec.chaton.userprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class RankWeeklyViewFragment extends Fragment {

    /* renamed from: a */
    TextView f5975a;

    /* renamed from: b */
    TextView f5976b;

    /* renamed from: c */
    TextView f5977c;

    /* renamed from: d */
    TextView f5978d;

    /* renamed from: e */
    ImageView f5979e;

    /* renamed from: f */
    ImageView f5980f;

    /* renamed from: g */
    ImageView f5981g;

    /* renamed from: h */
    ImageView f5982h;

    /* renamed from: i */
    View.OnClickListener f5983i = new ViewOnClickListenerC1659bi(this);

    /* renamed from: j */
    private View f5984j;

    /* renamed from: k */
    private RelativeLayout f5985k;

    /* renamed from: l */
    private RelativeLayout f5986l;

    /* renamed from: m */
    private RelativeLayout f5987m;

    /* renamed from: n */
    private RelativeLayout f5988n;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6061b("onCreate", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6061b("onCreateView", getClass().getSimpleName());
        this.f5984j = layoutInflater.inflate(R.layout.layout_weeklyrank, viewGroup, false);
        this.f5985k = (RelativeLayout) this.f5984j.findViewById(R.id.layoutWeek1);
        this.f5985k.setOnClickListener(this.f5983i);
        this.f5986l = (RelativeLayout) this.f5984j.findViewById(R.id.layoutWeek2);
        this.f5986l.setOnClickListener(this.f5983i);
        this.f5987m = (RelativeLayout) this.f5984j.findViewById(R.id.layoutWeek3);
        this.f5987m.setOnClickListener(this.f5983i);
        this.f5988n = (RelativeLayout) this.f5984j.findViewById(R.id.layoutWeek4);
        this.f5988n.setOnClickListener(this.f5983i);
        this.f5975a = (TextView) this.f5984j.findViewById(R.id.textWeek1);
        this.f5975a.setText(getString(R.string.interaction_rank_week, 1));
        this.f5976b = (TextView) this.f5984j.findViewById(R.id.textWeek2);
        this.f5976b.setText(getString(R.string.interaction_rank_week, 2));
        this.f5977c = (TextView) this.f5984j.findViewById(R.id.textWeek3);
        this.f5977c.setText(getString(R.string.interaction_rank_week, 3));
        this.f5978d = (TextView) this.f5984j.findViewById(R.id.textWeek4);
        this.f5978d.setText(getString(R.string.interaction_rank_week, 4));
        this.f5979e = (ImageView) this.f5984j.findViewById(R.id.week_selecter1);
        this.f5980f = (ImageView) this.f5984j.findViewById(R.id.week_selecter2);
        this.f5981g = (ImageView) this.f5984j.findViewById(R.id.week_selecter3);
        this.f5982h = (ImageView) this.f5984j.findViewById(R.id.week_selecter4);
        return this.f5984j;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6061b("onStart", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6061b("onResume", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6061b("onPause", getClass().getSimpleName());
    }
}
