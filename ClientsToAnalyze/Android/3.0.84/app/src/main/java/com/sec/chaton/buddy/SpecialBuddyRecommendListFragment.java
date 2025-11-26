package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpecialBuddyRecommendListFragment extends Fragment {

    /* renamed from: a */
    View f2322a;

    /* renamed from: d */
    private C0785io f2325d;

    /* renamed from: e */
    private ListView f2326e;

    /* renamed from: f */
    private View f2327f;

    /* renamed from: g */
    private ProgressDialog f2328g;

    /* renamed from: h */
    private LinearLayout f2329h;

    /* renamed from: i */
    private LinearLayout f2330i;

    /* renamed from: j */
    private ArrayList<C0784in> f2331j;

    /* renamed from: m */
    private C1377u f2334m;

    /* renamed from: n */
    private ImageView f2335n;

    /* renamed from: o */
    private C1330h f2336o;

    /* renamed from: p */
    private Activity f2337p;

    /* renamed from: k */
    private int f2332k = 0;

    /* renamed from: l */
    private ArrayList<String> f2333l = new ArrayList<>();

    /* renamed from: b */
    ContentObserver f2323b = new C0779ii(this, new Handler());

    /* renamed from: q */
    private Handler f2338q = new HandlerC0782il(this);

    /* renamed from: c */
    InterfaceC1378v f2324c = new C0783im(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f2337p = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f2337p = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2336o = new C1330h(this.f2338q);
        this.f2334m = new C1377u(this.f2337p.getContentResolver(), this.f2324c);
        this.f2334m.startQuery(100, null, C1388af.f5186a, null, "type='100'", null, "buddy_name ASC");
        this.f2337p.getContentResolver().registerContentObserver(C1388af.f5186a, true, this.f2323b);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_specialbuddy_recommend_list, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_specialbuddy_list_footer, (ViewGroup) null);
        linearLayout.setClickable(false);
        this.f2331j = new ArrayList<>();
        this.f2325d = new C0785io(this, this.f2337p, R.layout.list_item_common_5, this.f2331j);
        this.f2335n = (ImageView) linearLayout.findViewById(R.id.special_buddy_image);
        this.f2326e = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f2327f = viewInflate.findViewById(R.id.no_recommendations_layout);
        this.f2329h = (LinearLayout) viewInflate.findViewById(R.id.specialbuddy_profile_footer_progress);
        this.f2330i = (LinearLayout) viewInflate.findViewById(R.id.specialbuddy_profile_footer);
        if (this.f2331j.size() <= 0) {
            this.f2330i.setVisibility(8);
        }
        this.f2326e.addHeaderView(linearLayout);
        this.f2326e.setAdapter((ListAdapter) this.f2325d);
        this.f2326e.setItemsCanFocus(true);
        this.f2326e.setOnItemSelectedListener(new C0780ij(this));
        this.f2326e.setEmptyView(this.f2327f);
        this.f2326e.setOnKeyListener(new ViewOnKeyListenerC0781ik(this));
        this.f2335n.setVisibility(8);
        this.f2330i.setVisibility(0);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f2337p.getContentResolver().unregisterContentObserver(this.f2323b);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (getResources() != null && this.f2327f != null) {
            this.f2327f.setPadding(0, getResources().getDimensionPixelSize(R.dimen.buddy_no_suggestion_padding_top), 0, 0);
        }
    }
}
