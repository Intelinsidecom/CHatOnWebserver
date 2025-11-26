package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.C0837a;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MyPageBuddiesSay extends ListFragment {

    /* renamed from: a */
    public static final String f5794a = MyPageBuddiesSay.class.getSimpleName();

    /* renamed from: c */
    private C0638j f5796c;

    /* renamed from: d */
    private View f5797d;

    /* renamed from: e */
    private View f5798e;

    /* renamed from: f */
    private String f5799f;

    /* renamed from: g */
    private String f5800g;

    /* renamed from: h */
    private String f5801h;

    /* renamed from: i */
    private String f5802i;

    /* renamed from: j */
    private ArrayList f5803j;

    /* renamed from: k */
    private ProgressDialog f5804k;

    /* renamed from: l */
    private ProgressBar f5805l;

    /* renamed from: m */
    private Button f5806m;

    /* renamed from: n */
    private LinearLayout f5807n;

    /* renamed from: o */
    private boolean f5808o;

    /* renamed from: p */
    private FrameLayout f5809p;

    /* renamed from: q */
    private MyPageInteraction f5810q;

    /* renamed from: b */
    AbsListView.OnScrollListener f5795b = new C1700j(this);

    /* renamed from: r */
    private Handler f5811r = new HandlerC1701k(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5799f = C1789u.m6075a().getString("msisdn", "");
        this.f5800g = C1789u.m6075a().getString("Push Name", "");
        this.f5796c = new C0638j(this.f5811r);
        this.f5803j = new ArrayList();
        this.f5801h = "";
        this.f5802i = "";
        this.f5808o = true;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5804k = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.wait_sending);
        this.f5798e = layoutInflater.inflate(R.layout.memo_refresh_footer, (ViewGroup) null);
        this.f5805l = (ProgressBar) this.f5798e.findViewById(R.id.footer_progress);
        this.f5806m = (Button) this.f5798e.findViewById(R.id.footer_memo_content);
        this.f5807n = (LinearLayout) this.f5798e.findViewById(R.id.footer_no_memo);
        return GlobalApplication.m3265f() ? layoutInflater.inflate(R.layout.buddies_say, viewGroup, false) : super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C1786r.m6061b("-----onActivityCreated", getClass().getSimpleName());
        if (GlobalApplication.m3265f() && MyPageFragmentTablet.f5860a) {
            this.f5809p = new FrameLayout(getActivity());
            this.f5809p.setId(R.id.fragment_header);
            this.f5809p.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            getListView().addHeaderView(this.f5809p, null, false);
            this.f5810q = new MyPageInteraction();
            getFragmentManager().beginTransaction().replace(R.id.fragment_header, this.f5810q).commit();
            this.f5797d = this.f5809p;
        }
        getListView().addFooterView(this.f5798e, null, false);
        getListView().setAdapter((ListAdapter) new C0837a(getListView(), getActivity(), this.f5803j, R.layout.memo_adapter_item));
        getListView().setSelection(getListView().getHeaderViewsCount());
        getListView().setDivider(getResources().getDrawable(R.drawable.list_2line));
        getListView().setDividerHeight(1);
        getListView().setScrollbarFadingEnabled(true);
        getListView().setOnScrollListener(this.f5795b);
        registerForContextMenu(getListView());
        m5562a();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6061b("-----onResume", getClass().getSimpleName());
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_header);
        if (fragmentFindFragmentById instanceof MyPageInteraction) {
            ((MyPageInteraction) fragmentFindFragmentById).m5656a();
        }
    }

    /* renamed from: a */
    private void m5562a() {
        this.f5808o = true;
        this.f5805l.setVisibility(0);
        this.f5796c.m2897a(this.f5799f);
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        C0839c c0839c = (C0839c) getListAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position - 1);
        if (c0839c != null) {
            String strM3495a = c0839c.m3495a();
            String strM3498d = c0839c.m3498d();
            contextMenu.setHeaderTitle(R.string.mypage_buddies_say);
            contextMenu.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1699i(this, strM3495a, strM3498d));
        }
    }
}
