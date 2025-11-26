package com.sec.chaton.sns.p115ui;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.InterfaceC4442z;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class SnsSubMenuFragment extends Fragment implements View.OnClickListener, AbsListView.OnScrollListener, InterfaceC4511t {

    /* renamed from: g */
    private static final String f16050g = SnsSubMenuFragment.class.getSimpleName();

    /* renamed from: a */
    protected LinearLayout f16051a;

    /* renamed from: b */
    protected LinearLayout f16052b;

    /* renamed from: e */
    protected boolean f16055e;

    /* renamed from: h */
    private Activity f16057h;

    /* renamed from: i */
    private View f16058i;

    /* renamed from: j */
    private View f16059j;

    /* renamed from: k */
    private TextView f16060k;

    /* renamed from: l */
    private View f16061l;

    /* renamed from: m */
    private TextView f16062m;

    /* renamed from: n */
    private LinearLayout f16063n;

    /* renamed from: o */
    private TextView f16064o;

    /* renamed from: p */
    private ProgressDialog f16065p;

    /* renamed from: r */
    private ListView f16067r;

    /* renamed from: q */
    private InterfaceC4936e f16066q = null;

    /* renamed from: c */
    public C4504q f16053c = null;

    /* renamed from: d */
    protected ArrayList<C4379ae> f16054d = new ArrayList<>();

    /* renamed from: f */
    protected InterfaceC4442z f16056f = new C4454ah(this);

    /* renamed from: a */
    public abstract void mo16912a();

    /* renamed from: b */
    public abstract void mo16915b();

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16057h = activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16058i = layoutInflater.inflate(R.layout.layout_sns_submenu_list, viewGroup, false);
        this.f16055e = false;
        this.f16059j = this.f16058i.findViewById(R.id.sns_account_layout);
        int paddingLeft = this.f16059j.getPaddingLeft();
        int paddingTop = this.f16059j.getPaddingTop();
        int paddingRight = this.f16059j.getPaddingRight();
        int paddingBottom = this.f16059j.getPaddingBottom();
        this.f16059j.setBackgroundResource(R.drawable.listview_selector);
        this.f16059j.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        this.f16059j.findViewById(R.id.image1).setVisibility(8);
        this.f16059j.findViewById(R.id.button1).setFocusable(false);
        this.f16059j.findViewById(R.id.button1).setBackgroundResource(R.drawable.ic_arrow);
        this.f16059j.setFocusable(true);
        this.f16061l = this.f16058i.findViewById(R.id.sns_invitation_layout);
        int paddingLeft2 = this.f16061l.getPaddingLeft();
        int paddingTop2 = this.f16061l.getPaddingTop();
        int paddingRight2 = this.f16061l.getPaddingRight();
        int paddingBottom2 = this.f16061l.getPaddingBottom();
        this.f16061l.setBackgroundResource(R.drawable.listview_selector);
        this.f16061l.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
        this.f16061l.findViewById(R.id.image1).setVisibility(8);
        this.f16061l.findViewById(R.id.button1).setFocusable(false);
        this.f16061l.findViewById(R.id.button1).setBackgroundResource(R.drawable.ic_arrow);
        this.f16061l.setFocusable(true);
        this.f16067r = (ListView) this.f16058i.findViewById(R.id.sns_friends_list);
        this.f16052b = (LinearLayout) this.f16058i.findViewById(R.id.no_list_layout);
        this.f16051a = (LinearLayout) this.f16058i.findViewById(R.id.footer_progress);
        this.f16060k = (TextView) this.f16059j.findViewById(R.id.text1);
        this.f16060k.setText(getString(R.string.dialog_connecting_server));
        this.f16062m = (TextView) this.f16061l.findViewById(R.id.text1);
        this.f16063n = (LinearLayout) this.f16058i.findViewById(R.id.tv_title);
        this.f16064o = (TextView) this.f16063n.findViewById(R.id.text1);
        this.f16064o.setText(getString(R.string.chat_info_invite) + " (0)");
        this.f16059j.setOnClickListener(this);
        this.f16061l.setOnClickListener(this);
        this.f16067r.setClickable(false);
        this.f16067r.setFocusable(false);
        this.f16067r.setItemsCanFocus(true);
        this.f16067r.setFocusableInTouchMode(false);
        this.f16053c = new C4504q(this.f16057h, 0, this.f16054d);
        this.f16053c.m17055a(this);
        this.f16067r.setAdapter((ListAdapter) this.f16053c);
        this.f16053c.notifyDataSetInvalidated();
        this.f16067r.setOnScrollListener(this);
        mo16912a();
        setHasOptionsMenu(true);
        mo16915b();
        return this.f16058i;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f16057h = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m16918e();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m16920g();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            m16910j();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* renamed from: j */
    private void m16910j() {
        int lastVisiblePosition = this.f16067r.getLastVisiblePosition();
        if (lastVisiblePosition >= 0) {
            this.f16053c.m17053a(this.f16067r.getFirstVisiblePosition(), lastVisiblePosition, 5);
        }
    }

    /* renamed from: a */
    public void m16913a(String str) {
        this.f16060k.setText(str);
    }

    /* renamed from: c */
    public TextView m16916c() {
        return (TextView) this.f16062m.findViewById(R.id.text1);
    }

    /* renamed from: d */
    public boolean m16917d() {
        return this.f16055e;
    }

    /* renamed from: a */
    public void m16914a(boolean z) {
        this.f16055e = z;
    }

    /* renamed from: e */
    public void m16918e() {
        m16920g();
        m16911k();
    }

    /* renamed from: k */
    private void m16911k() {
        if (this.f16066q != null && this.f16066q.isShowing()) {
            this.f16066q.dismiss();
            this.f16066q = null;
        }
    }

    /* renamed from: b */
    private void m16906b(boolean z) {
        if (this.f16065p == null) {
            C4904y.m18639b("showProgressDialog() \t- null. create and show", f16050g);
            this.f16065p = ProgressDialog.show(this.f16057h, null, getString(R.string.dialog_connecting_server));
            this.f16065p.setCancelable(false);
            this.f16065p.setOnKeyListener(new DialogInterfaceOnKeyListenerC4452af(this, z));
            return;
        }
        C4904y.m18639b("showProgressDialog() \t- not null. show", f16050g);
        this.f16065p.show();
    }

    /* renamed from: f */
    protected void m16919f() {
        m16906b(true);
    }

    /* renamed from: g */
    public void m16920g() {
        boolean zIsShowing;
        if (this.f16065p != null && (zIsShowing = this.f16065p.isShowing())) {
            C4904y.m18639b("dismissProgressDialog() \t- mProgressDialog : " + this.f16065p + ". isSowing : " + zIsShowing, f16050g);
            this.f16065p.dismiss();
            this.f16065p = null;
        }
    }

    /* renamed from: c */
    private void m16908c(boolean z) {
        if (this.f16066q == null) {
            this.f16066q = AbstractC4932a.m18733a(this.f16057h).mo18740a(getResources().getString(R.string.ams_attention_title)).mo18749b(getResources().getString(R.string.dev_network_error)).mo18751b(false).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4453ag(this, z)).mo18745a();
        }
        this.f16066q.show();
    }

    /* renamed from: h */
    public void m16921h() {
        m16908c(true);
    }
}
