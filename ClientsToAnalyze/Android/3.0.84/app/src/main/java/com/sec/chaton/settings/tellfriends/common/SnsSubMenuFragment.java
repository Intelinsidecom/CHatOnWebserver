package com.sec.chaton.settings.tellfriends.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.chaton.settings.tellfriends.InterfaceC2727ad;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class SnsSubMenuFragment extends Fragment implements View.OnClickListener, AbsListView.OnScrollListener, InterfaceC2791g {

    /* renamed from: g */
    private static final String f10248g = SnsSubMenuFragment.class.getSimpleName();

    /* renamed from: a */
    protected LinearLayout f10249a;

    /* renamed from: b */
    protected LinearLayout f10250b;

    /* renamed from: e */
    protected boolean f10253e;

    /* renamed from: h */
    private Activity f10255h;

    /* renamed from: i */
    private View f10256i;

    /* renamed from: j */
    private View f10257j;

    /* renamed from: k */
    private TextView f10258k;

    /* renamed from: l */
    private View f10259l;

    /* renamed from: m */
    private TextView f10260m;

    /* renamed from: n */
    private LinearLayout f10261n;

    /* renamed from: o */
    private TextView f10262o;

    /* renamed from: p */
    private ProgressDialog f10263p;

    /* renamed from: r */
    private ListView f10265r;

    /* renamed from: q */
    private InterfaceC3274d f10264q = null;

    /* renamed from: c */
    public C2788d f10251c = null;

    /* renamed from: d */
    protected ArrayList<C2732ai> f10252d = new ArrayList<>();

    /* renamed from: f */
    protected InterfaceC2727ad f10254f = new C2809y(this);

    /* renamed from: a */
    public abstract void mo9717a();

    /* renamed from: b */
    public abstract void mo9719b();

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10255h = activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10256i = layoutInflater.inflate(R.layout.layout_sns_submenu_list, viewGroup, false);
        this.f10253e = false;
        this.f10257j = this.f10256i.findViewById(R.id.sns_account_layout);
        int paddingLeft = this.f10257j.getPaddingLeft();
        int paddingTop = this.f10257j.getPaddingTop();
        int paddingRight = this.f10257j.getPaddingRight();
        int paddingBottom = this.f10257j.getPaddingBottom();
        this.f10257j.setBackgroundResource(R.drawable.listview_selector);
        this.f10257j.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        this.f10257j.findViewById(R.id.image1).setVisibility(8);
        this.f10257j.findViewById(R.id.button1).setFocusable(false);
        this.f10257j.findViewById(R.id.button1).setBackgroundResource(R.drawable.ic_arrow);
        this.f10257j.setFocusable(true);
        this.f10259l = this.f10256i.findViewById(R.id.sns_invitation_layout);
        int paddingLeft2 = this.f10259l.getPaddingLeft();
        int paddingTop2 = this.f10259l.getPaddingTop();
        int paddingRight2 = this.f10259l.getPaddingRight();
        int paddingBottom2 = this.f10259l.getPaddingBottom();
        this.f10259l.setBackgroundResource(R.drawable.listview_selector);
        this.f10259l.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
        this.f10259l.findViewById(R.id.image1).setVisibility(8);
        this.f10259l.findViewById(R.id.button1).setFocusable(false);
        this.f10259l.findViewById(R.id.button1).setBackgroundResource(R.drawable.ic_arrow);
        this.f10259l.setFocusable(true);
        this.f10265r = (ListView) this.f10256i.findViewById(R.id.sns_friends_list);
        this.f10250b = (LinearLayout) this.f10256i.findViewById(R.id.no_list_layout);
        this.f10249a = (LinearLayout) this.f10256i.findViewById(R.id.footer_progress);
        this.f10258k = (TextView) this.f10257j.findViewById(R.id.text1);
        this.f10258k.setText(getString(R.string.dialog_connecting_server));
        this.f10260m = (TextView) this.f10259l.findViewById(R.id.text1);
        this.f10261n = (LinearLayout) this.f10256i.findViewById(R.id.tv_title);
        this.f10262o = (TextView) this.f10261n.findViewById(R.id.text1);
        this.f10262o.setText(getString(R.string.chat_info_invite) + " (0)");
        this.f10257j.setOnClickListener(this);
        this.f10259l.setOnClickListener(this);
        this.f10265r.setClickable(false);
        this.f10265r.setFocusable(false);
        this.f10265r.setItemsCanFocus(true);
        this.f10265r.setFocusableInTouchMode(false);
        this.f10251c = new C2788d(this.f10255h, 0, this.f10252d);
        this.f10251c.m10003a(this);
        this.f10265r.setAdapter((ListAdapter) this.f10251c);
        this.f10251c.notifyDataSetInvalidated();
        this.f10265r.setOnScrollListener(this);
        mo9719b();
        setHasOptionsMenu(true);
        mo9717a();
        return this.f10256i;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f10255h = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m9990g();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m9992i();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m9983d();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            m9981c();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* renamed from: c */
    private void m9981c() {
        int lastVisiblePosition = this.f10265r.getLastVisiblePosition();
        if (lastVisiblePosition >= 0) {
            this.f10251c.m10001a(this.f10265r.getFirstVisiblePosition(), lastVisiblePosition, 5);
        }
    }

    /* renamed from: a */
    public void m9986a(String str) {
        this.f10258k.setText(str);
    }

    /* renamed from: e */
    public TextView m9988e() {
        return (TextView) this.f10260m.findViewById(R.id.text1);
    }

    /* renamed from: f */
    public boolean m9989f() {
        return this.f10253e;
    }

    /* renamed from: a */
    public void m9987a(boolean z) {
        this.f10253e = z;
    }

    /* renamed from: d */
    private void m9983d() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f10255h.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: g */
    public void m9990g() {
        m9992i();
        m9985l();
    }

    /* renamed from: l */
    private void m9985l() {
        if (this.f10264q != null && this.f10264q.isShowing()) {
            this.f10264q.dismiss();
            this.f10264q = null;
        }
    }

    /* renamed from: b */
    private void m9979b(boolean z) {
        if (this.f10263p == null) {
            C3250y.m11450b("showProgressDialog() \t- null. create and show", f10248g);
            this.f10263p = ProgressDialog.show(this.f10255h, null, getString(R.string.dialog_connecting_server));
            this.f10263p.setCancelable(false);
            this.f10263p.setOnKeyListener(new DialogInterfaceOnKeyListenerC2807w(this, z));
            return;
        }
        C3250y.m11450b("showProgressDialog() \t- not null. show", f10248g);
        this.f10263p.show();
    }

    /* renamed from: h */
    protected void m9991h() {
        m9979b(true);
    }

    /* renamed from: i */
    public void m9992i() {
        boolean zIsShowing;
        if (this.f10263p != null && (zIsShowing = this.f10263p.isShowing())) {
            C3250y.m11450b("dismissProgressDialog() \t- mProgressDialog : " + this.f10263p + ". isSowing : " + zIsShowing, f10248g);
            this.f10263p.dismiss();
            this.f10263p = null;
        }
    }

    /* renamed from: c */
    private void m9982c(boolean z) {
        if (this.f10264q == null) {
            this.f10264q = AbstractC3271a.m11494a(this.f10255h).mo11500a(getResources().getString(R.string.ams_attention_title)).mo11509b(getResources().getString(R.string.dev_network_error)).mo11511b(false).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2808x(this, z)).mo11505a();
        }
        this.f10264q.show();
    }

    /* renamed from: j */
    public void m9993j() {
        m9982c(true);
    }
}
