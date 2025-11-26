package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.database.EnumC1177e;
import com.sec.chaton.trunk.p043c.EnumC1152a;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.p007b.p008a.p011c.C0119d;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.C1632t;

/* loaded from: classes.dex */
public class TrunkView extends ITrunkView implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    private static final String f3825b = TrunkView.class.getSimpleName();

    /* renamed from: A */
    private LinearLayout f3826A;

    /* renamed from: B */
    private String f3827B;

    /* renamed from: D */
    private Toast f3829D;

    /* renamed from: E */
    private C1632t f3830E;

    /* renamed from: F */
    private C0119d f3831F;

    /* renamed from: c */
    private InterfaceC1193s f3834c;

    /* renamed from: d */
    private InterfaceC1106ad f3835d;

    /* renamed from: e */
    private Activity f3836e;

    /* renamed from: f */
    private InterfaceC1150bn f3837f;

    /* renamed from: g */
    private Intent f3838g;

    /* renamed from: h */
    private String f3839h;

    /* renamed from: i */
    private String f3840i;

    /* renamed from: j */
    private GridView f3841j;

    /* renamed from: k */
    private View f3842k;

    /* renamed from: l */
    private View f3843l;

    /* renamed from: m */
    private View f3844m;

    /* renamed from: n */
    private LinearLayout f3845n;

    /* renamed from: o */
    private Spinner f3846o;

    /* renamed from: p */
    private C1109ag f3847p;

    /* renamed from: q */
    private EnumC1152a f3848q;

    /* renamed from: r */
    private boolean f3849r;

    /* renamed from: s */
    private EnumC1182h f3850s;

    /* renamed from: t */
    private C1105ac f3851t;

    /* renamed from: u */
    private Object f3852u;

    /* renamed from: v */
    private boolean f3853v;

    /* renamed from: w */
    private boolean f3854w;

    /* renamed from: x */
    private MenuItem f3855x;

    /* renamed from: y */
    private MenuItem f3856y;

    /* renamed from: z */
    private LinearLayout f3857z;

    /* renamed from: a */
    public boolean f3833a = false;

    /* renamed from: C */
    private boolean f3828C = false;

    /* renamed from: G */
    private Handler f3832G = new HandlerC1184j(this);

    /* renamed from: a */
    public boolean m4086a(View view) {
        if (this.f3830E == null) {
            return false;
        }
        this.f3830E.m5919a(view);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3836e = activity;
        try {
            this.f3837f = (InterfaceC1150bn) this.f3836e;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3836e = null;
        this.f3837f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkView.onCreate()", f3825b);
        }
        super.onCreate(bundle);
        this.f3829D = C1619g.m5889a(GlobalApplication.m3100a(), (CharSequence) null, 0);
        this.f3830E = new C1632t(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkView.onCreateView()", f3825b);
        }
        this.f3854w = false;
        this.f3853v = false;
        this.f3828C = false;
        this.f3831F = new C0119d();
        this.f3838g = this.f3836e.getIntent();
        this.f3839h = getArguments().getString("sessionId");
        this.f3840i = getArguments().getString("inboxNO");
        this.f3848q = EnumC1152a.m4191a(C1323bs.m4575a().getString("trunkOrderingType", EnumC1152a.UnreadComment.m4192a()));
        this.f3851t = new C1105ac(this, this.f3832G, this.f3848q, this.f3839h);
        this.f3847p = new C1109ag(this.f3836e, null, 0, this.f3848q, this.f3840i, this.f3831F);
        setHasOptionsMenu(true);
        ((ChatActivity) getActivity()).m2592a();
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk, viewGroup, false);
        this.f3857z = (LinearLayout) viewInflate.findViewById(R.id.moreLoadbar);
        this.f3826A = (LinearLayout) viewInflate.findViewById(R.id.cacheLoadingbar);
        this.f3841j = (GridView) viewInflate.findViewById(R.id.trunkItemGridView);
        this.f3841j.setOnItemClickListener(this);
        this.f3841j.setAdapter((ListAdapter) this.f3847p);
        this.f3845n = (LinearLayout) viewInflate.findViewById(R.id.trunk_title_line);
        this.f3846o = (Spinner) viewInflate.findViewById(R.id.trunk_tablet_spinner);
        if (this.f3846o != null) {
            this.f3846o = (Spinner) viewInflate.findViewById(R.id.trunk_tablet_spinner);
            this.f3846o.setAdapter((SpinnerAdapter) ArrayAdapter.createFromResource(getActivity(), R.array.trunk_ordering_types, android.R.layout.simple_spinner_dropdown_item));
            this.f3846o.setSelection(this.f3848q != EnumC1152a.UnreadComment ? 1 : 0);
            this.f3846o.setOnItemSelectedListener(new C1186l(this));
        }
        this.f3842k = viewInflate.findViewById(R.id.nothingView);
        this.f3843l = viewInflate.findViewById(R.id.networkErrorView);
        this.f3844m = viewInflate.findViewById(R.id.loadingView);
        this.f3850s = EnumC1182h.TrunkItem;
        m4071d();
        this.f3851t.m4175f();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f3851t.m4176g();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f3851t.m4177h();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3854w = true;
        this.f3852u = null;
        this.f3847p.m4151a();
        if (this.f3841j != null) {
            this.f3841j.setOnItemClickListener(null);
            this.f3841j.setAdapter((ListAdapter) null);
        }
        if (this.f3831F != null) {
            this.f3831F.m601a();
        }
        this.f3851t.m4178i();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkView.onDestroy()", f3825b);
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.actionbar_menu_close, menu);
        this.f3855x = menu.findItem(R.id.trunk_menu_listby);
        this.f3856y = menu.findItem(R.id.trunk_menu_refresh);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        m4076f();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.actionbar_menu_close) {
            this.f3837f.mo2599c_();
            return true;
        }
        if (menuItem.getItemId() == R.id.trunk_menu_refresh) {
            m4062a(true, true, this.f3848q);
            ((ChatActivity) getActivity()).m2600d(this.f3839h);
            return true;
        }
        if (menuItem.getItemId() != R.id.trunk_menu_listby) {
            return false;
        }
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("Current order type: %s, ordinal: %s", this.f3848q, Integer.valueOf(this.f3848q.ordinal())), f3825b);
        }
        new AlertDialogBuilderC1625m(this.f3836e).setTitle(R.string.buddy_list_optionmenu_listby).setSingleChoiceItems(R.array.trunk_ordering_types, this.f3848q.ordinal(), new DialogInterfaceOnClickListenerC1187m(this)).show();
        return true;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo3967a(Cursor cursor, EnumC1152a enumC1152a) {
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("SetTrunkItemList( OrderingType: %s )", enumC1152a), f3825b);
        }
        m4076f();
        if (this.f3852u == null) {
            m4074e();
            this.f3857z.setVisibility(8);
            this.f3826A.setVisibility(8);
        }
        this.f3833a = false;
        if (cursor == null || cursor.getCount() == 0) {
            if (this.f3850s == EnumC1182h.NetworkError) {
                m4060a(EnumC1182h.NetworkError);
            } else {
                m4060a(EnumC1182h.Nothing);
            }
        } else {
            m4060a(EnumC1182h.TrunkItem);
            cursor.moveToLast();
            this.f3827B = cursor.getString(cursor.getColumnIndex("item_id"));
            if (EnumC1177e.m4253a(cursor.getInt(cursor.getColumnIndex("item_type"))) == EnumC1177e.LoadMore) {
                this.f3833a = true;
            } else {
                this.f3833a = false;
            }
            cursor.moveToFirst();
        }
        this.f3847p.m4152a(enumC1152a);
        this.f3847p.swapCursor(cursor);
        if (!this.f3853v) {
            m4062a(false, false, this.f3848q);
            this.f3853v = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4065b() {
        this.f3829D.setText(R.string.popup_no_network_connection);
        this.f3829D.setDuration(0);
        this.f3829D.show();
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo3969a(InterfaceC1193s interfaceC1193s) {
        this.f3834c = interfaceC1193s;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo3968a(InterfaceC1106ad interfaceC1106ad) {
        this.f3835d = interfaceC1106ad;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1199y c1199y = (C1199y) view.getTag();
        if (c1199y.f4076f == EnumC1177e.Item) {
            this.f3837f.mo2595a(this.f3839h, this.f3840i, c1199y.f4075e, c1199y.f4077g, c1199y.f4078h);
        } else if (c1199y.f4076f == EnumC1177e.LoadMore && this.f3826A.getVisibility() == 8) {
            m4061a(c1199y.f4075e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4069c() {
        if (this.f3848q == EnumC1152a.Recent) {
            this.f3848q = EnumC1152a.UnreadComment;
        } else if (this.f3848q == EnumC1152a.UnreadComment) {
            this.f3848q = EnumC1152a.Recent;
        }
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("Toggle ordering type to %s", this.f3848q), f3825b);
        }
        C1323bs.m4575a().edit().putString("trunkOrderingType", this.f3848q.m4192a()).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4062a(boolean z, boolean z2, EnumC1152a enumC1152a) {
        int i = 30;
        if (m4078g()) {
            if (enumC1152a != this.f3848q) {
                this.f3849r = true;
            }
            if (enumC1152a == EnumC1152a.Recent) {
                if (C1341p.f4578b) {
                    C1341p.m4658b(String.format("Request type is recent. Load item count: %d", 30), f3825b);
                }
            } else if (enumC1152a == EnumC1152a.UnreadComment) {
                if (C1341p.f4578b) {
                    C1341p.m4658b(String.format("Request type is unread comment. Load item count: %d", 100), f3825b);
                }
                i = 100;
            } else {
                i = 0;
            }
            this.f3852u = this.f3834c.mo4172a(z, enumC1152a, i, 239);
            if (this.f3847p.getCount() == 0) {
                z2 = true;
            }
            if (z2) {
                m4071d();
                this.f3826A.setVisibility(8);
            } else {
                this.f3826A.setVisibility(0);
            }
            m4076f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4061a(String str) {
        if (m4078g()) {
            this.f3857z.setVisibility(0);
            this.f3852u = this.f3835d.mo4141a(this.f3848q, 31, 239, str);
            m4076f();
        }
    }

    /* renamed from: d */
    private void m4071d() {
        this.f3844m.setVisibility(0);
        this.f3857z.setVisibility(8);
        this.f3826A.setVisibility(8);
        if (this.f3845n != null) {
            this.f3845n.setVisibility(8);
        }
        this.f3841j.setVisibility(8);
        this.f3843l.setVisibility(8);
        this.f3842k.setVisibility(8);
    }

    /* renamed from: e */
    private void m4074e() {
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("Hide trunk item list loading view. change view to %s", this.f3850s), f3825b);
        }
        this.f3844m.setVisibility(8);
        m4060a(this.f3850s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4060a(EnumC1182h enumC1182h) {
        this.f3850s = enumC1182h;
        if (this.f3852u == null) {
            if (C1341p.f4578b) {
                C1341p.m4658b(String.format("Switch view to %s", this.f3850s), f3825b);
            }
            switch (enumC1182h) {
                case TrunkItem:
                    if (this.f3845n != null) {
                        this.f3845n.setVisibility(0);
                    }
                    this.f3841j.setVisibility(0);
                    this.f3843l.setVisibility(8);
                    this.f3842k.setVisibility(8);
                    this.f3844m.setVisibility(8);
                    break;
                case NetworkError:
                    if (this.f3845n != null) {
                        this.f3845n.setVisibility(8);
                    }
                    this.f3841j.setVisibility(8);
                    this.f3843l.setVisibility(0);
                    this.f3842k.setVisibility(8);
                    this.f3844m.setVisibility(8);
                    break;
                case Nothing:
                    if (this.f3845n != null) {
                        this.f3845n.setVisibility(8);
                    }
                    this.f3841j.setVisibility(8);
                    this.f3843l.setVisibility(8);
                    this.f3842k.setVisibility(0);
                    this.f3844m.setVisibility(8);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4076f() {
        if (!m4078g() || this.f3852u != null) {
            if (this.f3855x != null) {
                this.f3855x.setEnabled(false);
            }
            if (this.f3856y != null) {
                this.f3856y.setEnabled(false);
                return;
            }
            return;
        }
        if (this.f3855x != null) {
            if (this.f3847p.getCount() != 0) {
                this.f3855x.setEnabled(true);
            } else {
                this.f3855x.setEnabled(false);
            }
        }
        if (this.f3856y != null) {
            this.f3856y.setEnabled(true);
        }
    }

    /* renamed from: g */
    private boolean m4078g() {
        if (this.f3839h != null && !this.f3839h.trim().equals("")) {
            return true;
        }
        if (C1341p.f4578b) {
            C1341p.m4658b("SessionId is invalid.", f3825b);
        }
        return false;
    }
}
