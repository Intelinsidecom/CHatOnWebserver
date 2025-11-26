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
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpecialBuddyRecommendListFragment extends Fragment {

    /* renamed from: c */
    private C1392ir f4170c;

    /* renamed from: d */
    private ListView f4171d;

    /* renamed from: e */
    private View f4172e;

    /* renamed from: f */
    private ProgressDialog f4173f;

    /* renamed from: g */
    private LinearLayout f4174g;

    /* renamed from: h */
    private LinearLayout f4175h;

    /* renamed from: i */
    private ArrayList<C1391iq> f4176i;

    /* renamed from: l */
    private C2210x f4179l;

    /* renamed from: m */
    private ImageView f4180m;

    /* renamed from: n */
    private C2128i f4181n;

    /* renamed from: o */
    private Activity f4182o;

    /* renamed from: j */
    private int f4177j = 0;

    /* renamed from: k */
    private ArrayList<String> f4178k = new ArrayList<>();

    /* renamed from: a */
    ContentObserver f4168a = new C1388in(this, new Handler());

    /* renamed from: p */
    private Handler f4183p = new HandlerC1389io(this);

    /* renamed from: b */
    InterfaceC2211y f4169b = new C1390ip(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f4182o = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f4182o = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4181n = new C2128i(this.f4183p);
        this.f4179l = new C2210x(this.f4182o.getContentResolver(), this.f4169b);
        this.f4179l.startQuery(100, null, C2228ap.f7956a, null, "type='100'", null, "buddy_name ASC");
        this.f4182o.getContentResolver().registerContentObserver(C2228ap.f7956a, true, this.f4168a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_specialbuddy_recommend_list, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.layout_specialbuddy_list_footer, (ViewGroup) null);
        linearLayout.setClickable(false);
        this.f4176i = new ArrayList<>();
        this.f4170c = new C1392ir(this, this.f4182o, R.layout.list_item_common_5, this.f4176i);
        this.f4180m = (ImageView) linearLayout.findViewById(R.id.special_buddy_image);
        this.f4171d = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f4172e = viewInflate.findViewById(R.id.no_recommendations_layout);
        this.f4174g = (LinearLayout) viewInflate.findViewById(R.id.specialbuddy_profile_footer_progress);
        this.f4175h = (LinearLayout) viewInflate.findViewById(R.id.specialbuddy_profile_footer);
        if (this.f4176i.size() <= 0) {
            this.f4175h.setVisibility(8);
        }
        this.f4171d.addHeaderView(linearLayout);
        this.f4171d.setAdapter((ListAdapter) this.f4170c);
        this.f4171d.setItemsCanFocus(true);
        this.f4171d.setEmptyView(this.f4172e);
        this.f4180m.setVisibility(8);
        this.f4175h.setVisibility(0);
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
        this.f4182o.getContentResolver().unregisterContentObserver(this.f4168a);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (getResources() != null && this.f4172e != null) {
            this.f4172e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.buddy_no_suggestion_padding_top), 0, 0);
        }
    }
}
