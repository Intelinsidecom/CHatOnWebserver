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
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.trunk.database.EnumC1588d;
import com.sec.chaton.trunk.p047a.C1514b;
import com.sec.chaton.trunk.p048b.EnumC1551b;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.trunk.tablet.TrunkItemTabletActivity;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1748bd;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TrunkView extends ITrunkView implements InterfaceC1607m, InterfaceC1608n {

    /* renamed from: c */
    private static final String f5509c = TrunkView.class.getSimpleName();

    /* renamed from: A */
    private EnumC0695j f5510A;

    /* renamed from: B */
    private C1797a f5511B;

    /* renamed from: C */
    private C1797a f5512C;

    /* renamed from: a */
    ArrayList f5514a;

    /* renamed from: d */
    private InterfaceC1606l f5516d;

    /* renamed from: e */
    private InterfaceC1605k f5517e;

    /* renamed from: f */
    private Activity f5518f;

    /* renamed from: g */
    private InterfaceC1566bo f5519g;

    /* renamed from: h */
    private Intent f5520h;

    /* renamed from: i */
    private String f5521i;

    /* renamed from: j */
    private String f5522j;

    /* renamed from: k */
    private GridView f5523k;

    /* renamed from: l */
    private View f5524l;

    /* renamed from: m */
    private View f5525m;

    /* renamed from: n */
    private View f5526n;

    /* renamed from: o */
    private C1609o f5527o;

    /* renamed from: p */
    private C1514b f5528p;

    /* renamed from: q */
    private EnumC1551b f5529q;

    /* renamed from: r */
    private boolean f5530r;

    /* renamed from: s */
    private EnumC1567bp f5531s;

    /* renamed from: t */
    private C1554bc f5532t;

    /* renamed from: u */
    private Object f5533u;

    /* renamed from: v */
    private C1798b f5534v;

    /* renamed from: w */
    private boolean f5535w;

    /* renamed from: x */
    private boolean f5536x;

    /* renamed from: y */
    private String f5537y;

    /* renamed from: z */
    private String f5538z;

    /* renamed from: D */
    private Handler f5513D = new HandlerC1559bh(this);

    /* renamed from: b */
    AdapterView.OnItemSelectedListener f5515b = new C1563bl(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5518f = activity;
        if (!GlobalApplication.m3265f()) {
            try {
                this.f5519g = (InterfaceC1566bo) this.f5518f;
            } catch (ClassCastException e) {
                throw new ClassCastException(String.format("%s must implement ITrunkViewListener.", activity.toString()));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5518f = null;
        this.f5519g = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C1786r.m6061b("TrunkView.onCreate()", f5509c);
        super.onCreate(bundle);
        this.f5536x = false;
        this.f5535w = false;
        this.f5520h = this.f5518f.getIntent();
        this.f5521i = this.f5520h.getStringExtra("sessionId");
        this.f5522j = this.f5520h.getStringExtra("inboxNO");
        this.f5538z = this.f5520h.getStringExtra("chatTitle");
        this.f5537y = this.f5520h.getStringExtra("buddyNo");
        if (this.f5520h.getExtras() != null) {
            this.f5510A = (EnumC0695j) this.f5520h.getExtras().get("trunkChatType");
        }
        this.f5529q = EnumC1551b.m5405a(C1789u.m6075a().getString("trunkOrderingType", EnumC1551b.UnreadComment.m5406a()));
        this.f5528p = new C1514b();
        this.f5527o = new C1609o(this.f5518f, null, 0, this.f5529q, this.f5522j, this.f5528p);
        this.f5527o.m5521a((InterfaceC1607m) this);
        this.f5527o.m5522a((InterfaceC1608n) this);
        this.f5532t = new C1554bc(this, this.f5513D, this.f5529q, this.f5521i);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkView.onCreateView()", f5509c);
        }
        setHasOptionsMenu(true);
        View viewInflate = layoutInflater.inflate(R.layout.trunk_fragment, viewGroup, false);
        ((FrameLayout) viewInflate.findViewById(R.id.imageChatBg)).setOnClickListener(new ViewOnClickListenerC1560bi(this));
        this.f5523k = (GridView) viewInflate.findViewById(R.id.trunkItemGridView);
        this.f5523k.setAdapter((ListAdapter) this.f5527o);
        this.f5524l = viewInflate.findViewById(R.id.nothingView);
        this.f5525m = viewInflate.findViewById(R.id.networkErrorView);
        this.f5526n = viewInflate.findViewById(R.id.loadingView);
        this.f5531s = EnumC1567bp.TrunkItem;
        m5338h();
        this.f5532t.m5354a();
        this.f5514a = new ArrayList();
        this.f5511B = new C1797a(getResources().getString(R.string.trunk_menu_refresh), R.drawable.refresh);
        this.f5514a.add(this.f5511B);
        this.f5534v = new C1798b(getActivity(), this.f5514a);
        if (GlobalApplication.m3265f()) {
            BaseActivity.m1829b(this, true);
        }
        ((TextView) viewInflate.findViewById(R.id.chatTitle)).setText(this.f5538z);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.Chaticon);
        if (this.f5510A == EnumC0695j.ONETOONE) {
            C1746bb.m5945a(getActivity()).m5959a(imageView, this.f5537y);
        } else if (this.f5510A == EnumC0695j.GROUPCHAT) {
            C1746bb.m5945a(getActivity()).m5958a(imageView, EnumC1748bd.CHAT_GROUP);
        } else if (this.f5510A == EnumC0695j.BROADCAST) {
            C1746bb.m5945a(getActivity()).m5958a(imageView, EnumC1748bd.BROADCAST);
        }
        imageView.setOnClickListener(new ViewOnClickListenerC1561bj(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5532t.m5355b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f5532t.m5356c();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkView.onDestroy()", f5509c);
        }
        super.onDestroy();
        this.f5536x = true;
        this.f5533u = null;
        this.f5532t.m5357d();
        if (this.f5527o != null) {
            this.f5527o.m5521a((InterfaceC1607m) null);
            this.f5527o.m5522a((InterfaceC1608n) null);
        }
        if (this.f5528p != null) {
            this.f5528p.mo5364a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        m5342j();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.actionbar_menu_close) {
            if (!GlobalApplication.m3265f()) {
                this.f5519g.mo5233c_();
                return true;
            }
            m5352d();
            return true;
        }
        if (menuItem.getItemId() == R.id.trunk_menu_refresh) {
            m5326a(true, true, this.f5529q);
            return true;
        }
        if (menuItem.getItemId() != R.id.trunk_menu_listby) {
            return false;
        }
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("Current order type: %s, ordinal: %s", this.f5529q, Integer.valueOf(this.f5529q.ordinal())), f5509c);
        }
        new AlertDialogBuilderC2120a(this.f5518f).setTitle(R.string.buddy_list_optionmenu_listby).setSingleChoiceItems(R.array.trunk_ordering_types, this.f5529q.ordinal(), new DialogInterfaceOnClickListenerC1562bk(this)).show();
        return true;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo5228a(Cursor cursor, EnumC1551b enumC1551b) {
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("SetTrunkItemList( OrderingType: %s )", enumC1551b), f5509c);
        }
        m5342j();
        if (this.f5533u == null) {
            m5340i();
            this.f5518f.setProgressBarIndeterminateVisibility(false);
        }
        this.f5527o.m5520a(enumC1551b);
        this.f5527o.swapCursor(cursor);
        if (cursor == null || cursor.getCount() == 0) {
            if (this.f5531s == EnumC1567bp.NetworkError) {
                m5324a(EnumC1567bp.NetworkError);
            } else {
                m5324a(EnumC1567bp.Nothing);
            }
        } else {
            m5324a(EnumC1567bp.TrunkItem);
        }
        if (!this.f5535w) {
            m5326a(false, false, this.f5529q);
            this.f5535w = true;
        }
        m5346a();
    }

    /* renamed from: a */
    public void m5346a() {
        if (this.f5527o.getCount() != 0 && this.f5514a != null && this.f5514a.size() < 2) {
            this.f5512C = new C1797a(getResources().getString(R.string.buddy_list_optionmenu_listby), R.drawable.list_by);
            this.f5514a.add(this.f5512C);
        } else if (this.f5527o.getCount() == 0 && this.f5514a != null) {
            this.f5514a.clear();
            this.f5511B = new C1797a(getResources().getString(R.string.trunk_menu_refresh), R.drawable.refresh);
            this.f5514a.add(this.f5511B);
        }
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo5230a(InterfaceC1606l interfaceC1606l) {
        this.f5516d = interfaceC1606l;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo5229a(InterfaceC1605k interfaceC1605k) {
        this.f5517e = interfaceC1605k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1607m
    /* renamed from: a */
    public void mo5347a(View view, String str, EnumC1588d enumC1588d, String str2, EnumC1599h enumC1599h) {
        if (enumC1588d == EnumC1588d.Item) {
            if (!GlobalApplication.m3265f()) {
                this.f5519g.mo5232a(this.f5521i, this.f5522j, str, str2, enumC1599h);
                return;
            } else {
                m5348a(this.f5521i, this.f5522j, str, str2, enumC1599h);
                return;
            }
        }
        if (enumC1588d == EnumC1588d.LoadMore) {
            m5325a(str);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1608n
    /* renamed from: b */
    public void mo5350b(View view, String str, EnumC1588d enumC1588d, String str2, EnumC1599h enumC1599h) {
        if (enumC1588d == EnumC1588d.Item) {
            if (!GlobalApplication.m3265f()) {
                this.f5519g.mo5232a(this.f5521i, this.f5522j, str, str2, enumC1599h);
                return;
            } else {
                m5348a(this.f5521i, this.f5522j, str, str2, enumC1599h);
                return;
            }
        }
        if (enumC1588d == EnumC1588d.LoadMore) {
            m5325a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5336g() {
        if (this.f5529q == EnumC1551b.Recent) {
            this.f5529q = EnumC1551b.UnreadComment;
        } else if (this.f5529q == EnumC1551b.UnreadComment) {
            this.f5529q = EnumC1551b.Recent;
        }
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("Toggle ordering type to %s", this.f5529q), f5509c);
        }
        C1789u.m6075a().edit().putString("trunkOrderingType", this.f5529q.m5406a()).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5326a(boolean z, boolean z2, EnumC1551b enumC1551b) {
        int i = 30;
        if (m5344k()) {
            if (enumC1551b != this.f5529q) {
                this.f5530r = true;
            }
            if (enumC1551b == EnumC1551b.Recent) {
                if (C1786r.f6452b) {
                    C1786r.m6061b(String.format("Request type is recent. Load item count: %d", 30), f5509c);
                }
            } else if (enumC1551b == EnumC1551b.UnreadComment) {
                if (C1786r.f6452b) {
                    C1786r.m6061b(String.format("Request type is unread comment. Load item count: %d", 100), f5509c);
                }
                i = 100;
            } else {
                i = 0;
            }
            this.f5533u = this.f5516d.mo5426a(z, enumC1551b, i, 239);
            if (this.f5527o.getCount() == 0) {
                z2 = true;
            }
            if (z2) {
                m5338h();
                this.f5518f.setProgressBarIndeterminateVisibility(false);
            } else {
                this.f5518f.setProgressBarIndeterminateVisibility(true);
            }
            m5342j();
        }
    }

    /* renamed from: b */
    public C1798b m5349b() {
        return this.f5534v;
    }

    /* renamed from: c */
    public AdapterView.OnItemSelectedListener m5351c() {
        return this.f5515b;
    }

    /* renamed from: a */
    private void m5325a(String str) {
        if (m5344k()) {
            this.f5518f.setProgressBarIndeterminateVisibility(true);
            this.f5533u = this.f5517e.mo5428a(this.f5529q, 31, 239, str);
            m5342j();
        }
    }

    /* renamed from: h */
    private void m5338h() {
        this.f5526n.setVisibility(0);
        this.f5523k.setVisibility(8);
        this.f5525m.setVisibility(8);
        this.f5524l.setVisibility(8);
    }

    /* renamed from: i */
    private void m5340i() {
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("Hide trunk item list loading view. change view to %s", this.f5531s), f5509c);
        }
        this.f5526n.setVisibility(8);
        m5324a(this.f5531s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5324a(EnumC1567bp enumC1567bp) {
        this.f5531s = enumC1567bp;
        if (this.f5533u == null) {
            if (C1786r.f6452b) {
                C1786r.m6061b(String.format("Switch view to %s", this.f5531s), f5509c);
            }
            switch (C1565bn.f5642a[enumC1567bp.ordinal()]) {
                case 1:
                    this.f5523k.setVisibility(0);
                    this.f5523k.setFocusable(false);
                    this.f5525m.setVisibility(8);
                    this.f5524l.setVisibility(8);
                    this.f5526n.setVisibility(8);
                    break;
                case 2:
                    this.f5523k.setVisibility(8);
                    this.f5525m.setVisibility(0);
                    this.f5524l.setVisibility(8);
                    this.f5526n.setVisibility(8);
                    break;
                case 3:
                    this.f5523k.setVisibility(8);
                    this.f5525m.setVisibility(8);
                    this.f5524l.setVisibility(0);
                    this.f5526n.setVisibility(8);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5342j() {
    }

    /* renamed from: k */
    private boolean m5344k() {
        if (this.f5521i != null && !this.f5521i.trim().equals("")) {
            return true;
        }
        if (C1786r.f6452b) {
            C1786r.m6061b("SessionId is invalid.", f5509c);
        }
        return false;
    }

    /* renamed from: a */
    public void m5348a(String str, String str2, String str3, String str4, EnumC1599h enumC1599h) {
        Intent intent = new Intent(getActivity(), (Class<?>) TrunkItemTabletActivity.class);
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNo", str2);
        intent.putExtra("trunkItemId", str3);
        intent.putExtra("downloadUrl", str4);
        intent.putExtra("contentType", enumC1599h);
        startActivity(intent);
    }

    /* renamed from: d */
    public void m5352d() {
    }

    /* renamed from: e */
    public void m5353e() {
        ChatFragment chatFragment = new ChatFragment();
        chatFragment.setArguments(getActivity().getIntent().getExtras());
        HomeTabletFragment.m628a(getFragmentManager(), chatFragment);
    }
}
