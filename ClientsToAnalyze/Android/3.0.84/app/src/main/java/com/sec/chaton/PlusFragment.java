package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.sec.chaton.event.C1463e;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1403au;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings.downloads.C2555av;
import com.sec.chaton.settings.moreapps.C2710a;
import com.sec.chaton.settings.moreapps.C2714d;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.widget.ExpandableHeightGridView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PlusFragment extends Fragment implements InterfaceC0813bw {

    /* renamed from: a */
    public static final String f703a = PlusFragment.class.getSimpleName();

    /* renamed from: b */
    public boolean f704b;

    /* renamed from: e */
    private ExpandableHeightGridView f707e;

    /* renamed from: f */
    private ExpandableHeightGridView f708f;

    /* renamed from: g */
    private C2710a f709g;

    /* renamed from: h */
    private C2714d f710h;

    /* renamed from: i */
    private C1463e f711i;

    /* renamed from: k */
    private LinearLayout f713k;

    /* renamed from: l */
    private Cursor f714l;

    /* renamed from: m */
    private ArrayList<C0429ag> f715m;

    /* renamed from: n */
    private ArrayList<C0430ah> f716n;

    /* renamed from: o */
    private int f717o;

    /* renamed from: p */
    private C3326c f718p;

    /* renamed from: q */
    private C1377u f719q;

    /* renamed from: j */
    private boolean f712j = true;

    /* renamed from: c */
    ContentObserver f705c = new C3267x(this, new Handler());

    /* renamed from: r */
    private AdapterView.OnItemClickListener f720r = new C3268y(this);

    /* renamed from: s */
    private AdapterView.OnItemClickListener f721s = new C3269z(this);

    /* renamed from: d */
    InterfaceC1378v f706d = new C0412aa(this);

    /* renamed from: t */
    private BroadcastReceiver f722t = new C0413ab(this);

    /* renamed from: u */
    private BroadcastReceiver f723u = new C0414ac(this);

    /* renamed from: v */
    private Handler f724v = new HandlerC0426ad(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_plus_tab, viewGroup, false);
        this.f708f = (ExpandableHeightGridView) viewInflate.findViewById(R.id.menuGrid);
        this.f707e = (ExpandableHeightGridView) viewInflate.findViewById(R.id.moreAppsList);
        this.f708f.setOnItemClickListener(this.f720r);
        this.f707e.setOnItemClickListener(this.f721s);
        this.f711i = new C1463e(getActivity(), this.f724v);
        this.f713k = (LinearLayout) viewInflate.findViewById(R.id.loadingView);
        this.f718p = new C3326c();
        this.f716n = new ArrayList<>();
        this.f710h = new C2714d(getActivity(), this, this.f716n);
        this.f708f.setExpanded(true);
        this.f715m = new ArrayList<>();
        this.f709g = new C2710a(getActivity(), this, this.f715m, this.f718p);
        this.f707e.setExpanded(true);
        this.f707e.setAdapter((ListAdapter) this.f709g);
        this.f711i = new C1463e(getActivity(), this.f724v);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("more_event_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f722t, intentFilter);
        m1179d();
        this.f708f.setAdapter((ListAdapter) this.f710h);
        this.f719q = new C1377u(getActivity().getContentResolver(), this.f706d);
        this.f719q.startQuery(0, null, C1403au.f5215a, null, null, null, "priority");
        getActivity().getContentResolver().registerContentObserver(C1403au.f5215a, true, this.f705c);
        this.f704b = false;
        return viewInflate;
    }

    /* renamed from: d */
    private void m1179d() {
        C0430ah c0430ah = new C0430ah(R.drawable.plus_btn_ic_download, R.string.settings_title_downloads, 0);
        C0430ah c0430ah2 = new C0430ah(R.drawable.plus_btn_ic_livepartner, R.string.more_live_partner_button_name, 0);
        C0430ah c0430ah3 = new C0430ah(R.drawable.plus_btn_ic_event, R.string.setting_events, 0);
        this.f716n.add(c0430ah);
        this.f716n.add(c0430ah2);
        if (C1464f.m6399f()) {
            this.f716n.add(c0430ah3);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f704b = true;
        if (this.f718p != null) {
            this.f718p.m11731a();
        }
        getActivity().getContentResolver().unregisterContentObserver(this.f705c);
        super.onDestroyView();
    }

    /* renamed from: a */
    public synchronized void m1188a() {
        if (C3159aa.m10962a().m10978a("new_event_count", (Integer) 0).intValue() > 0) {
            this.f711i.m6383a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (GlobalApplication.m6456e() && getActivity() != null && isVisible()) {
            ((TabActivity) getActivity()).m1327h();
        }
        m1188a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("more_event_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f722t, intentFilter);
        m1181e();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e() && getActivity() != null && isVisible()) {
            ((TabActivity) getActivity()).m1327h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1181e() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f716n.size()) {
                break;
            }
            this.f716n.get(i2).f1494c = m1187a(this.f716n.get(i2).f1493b);
            i = i2 + 1;
        }
        if (this.f710h != null) {
            this.f710h.notifyDataSetChanged();
        }
        C3159aa.m10962a().m10984b("plus_tab_badge", Integer.valueOf(m1182f()));
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).sendBroadcast(new Intent("more_tab_badge_update"));
    }

    /* renamed from: a */
    public int m1187a(int i) {
        switch (i) {
            case R.string.setting_events /* 2131427957 */:
                return m1173a(EnumC0428af.Events);
            case R.string.settings_title_downloads /* 2131428103 */:
                return m1173a(EnumC0428af.Downloads);
            case R.string.more_live_partner_button_name /* 2131428282 */:
                return m1173a(EnumC0428af.LIVEPartner);
            default:
                return 0;
        }
    }

    /* renamed from: f */
    private int m1182f() {
        int i = 0;
        for (int i2 = 0; i2 < this.f716n.size(); i2++) {
            i += this.f716n.get(i2).f1494c;
        }
        return i;
    }

    /* renamed from: a */
    private int m1173a(EnumC0428af enumC0428af) {
        switch (enumC0428af) {
            case Downloads:
                return C2555av.m9487a();
            case LIVEPartner:
                return C3159aa.m10962a().m10978a("new_livepartner_count", (Integer) 0).intValue();
            case Events:
                return C1464f.m6406m();
            default:
                return 0;
        }
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: b */
    public void mo1189b() {
        if (GlobalApplication.m6456e() && getActivity() != null) {
            ((TabActivity) getActivity()).m1327h();
        }
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: c */
    public void mo1190c() {
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f712j = false;
        C3250y.m11456e("onPause() / isShow : " + this.f712j, f703a);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f722t);
    }
}
