package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.trunk.database.EnumC3048d;
import com.sec.chaton.trunk.p058a.EnumC2959b;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TrunkView extends ITrunkView implements InterfaceC3063q {

    /* renamed from: c */
    private static final String f10665c = TrunkView.class.getSimpleName();

    /* renamed from: A */
    private LinearLayout f10666A;

    /* renamed from: B */
    private String f10667B;

    /* renamed from: D */
    private Toast f10669D;

    /* renamed from: E */
    private C3326c f10670E;

    /* renamed from: F */
    private CheckedTextView f10671F;

    /* renamed from: G */
    private int f10672G;

    /* renamed from: H */
    private HashMap<String, Boolean> f10673H;

    /* renamed from: I */
    private Dialog f10674I;

    /* renamed from: J */
    private Menu f10675J;

    /* renamed from: L */
    private boolean f10677L;

    /* renamed from: M */
    private ImageView f10678M;

    /* renamed from: N */
    private TextView f10679N;

    /* renamed from: O */
    private TextView f10680O;

    /* renamed from: P */
    private LinearLayout f10681P;

    /* renamed from: Q */
    private ImageView f10682Q;

    /* renamed from: a */
    boolean f10685a;

    /* renamed from: d */
    private InterfaceC3062p f10687d;

    /* renamed from: e */
    private InterfaceC3060n f10688e;

    /* renamed from: f */
    private InterfaceC3061o f10689f;

    /* renamed from: g */
    private Activity f10690g;

    /* renamed from: h */
    private InterfaceC3039cm f10691h;

    /* renamed from: i */
    private Intent f10692i;

    /* renamed from: j */
    private String f10693j;

    /* renamed from: k */
    private String f10694k;

    /* renamed from: l */
    private boolean f10695l;

    /* renamed from: m */
    private ListView f10696m;

    /* renamed from: n */
    private View f10697n;

    /* renamed from: o */
    private View f10698o;

    /* renamed from: p */
    private View f10699p;

    /* renamed from: q */
    private LinearLayout f10700q;

    /* renamed from: r */
    private Spinner f10701r;

    /* renamed from: s */
    private ViewOnClickListenerC3064r f10702s;

    /* renamed from: t */
    private EnumC2959b f10703t;

    /* renamed from: u */
    private boolean f10704u;

    /* renamed from: v */
    private EnumC3041co f10705v;

    /* renamed from: w */
    private C3018bz f10706w;

    /* renamed from: x */
    private Object f10707x;

    /* renamed from: y */
    private Object f10708y;

    /* renamed from: z */
    private boolean f10709z;

    /* renamed from: b */
    public boolean f10686b = false;

    /* renamed from: C */
    private boolean f10668C = false;

    /* renamed from: K */
    private ArrayList<String> f10676K = new ArrayList<>();

    /* renamed from: R */
    private boolean f10683R = true;

    /* renamed from: S */
    private Handler f10684S = new HandlerC3032cf(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10690g = activity;
        try {
            this.f10691h = (InterfaceC3039cm) this.f10690g;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10690g = null;
        this.f10691h = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkView.onCreate()", f10665c);
        }
        super.onCreate(bundle);
        this.f10669D = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkView.onCreateView()", f10665c);
        }
        this.f10685a = false;
        this.f10709z = false;
        this.f10668C = false;
        this.f10677L = false;
        this.f10670E = new C3326c();
        if (bundle != null) {
            this.f10673H = (HashMap) bundle.getSerializable("checkedItem");
            this.f10677L = bundle.getBoolean("isRefreshInDelete", false);
        }
        setHasOptionsMenu(true);
        this.f10692i = this.f10690g.getIntent();
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk, viewGroup, false);
        if (GlobalApplication.m6456e()) {
            this.f10681P = (LinearLayout) viewInflate.findViewById(R.id.lLayoutProfile);
            this.f10681P.setVisibility(0);
            this.f10679N = (TextView) viewInflate.findViewById(R.id.chatTitle);
            this.f10680O = (TextView) viewInflate.findViewById(R.id.textStatus);
            this.f10678M = (ImageView) viewInflate.findViewById(R.id.Chaticon);
            this.f10679N.setText(getArguments().getCharSequence("mTitle"));
            this.f10680O.setText(getArguments().getCharSequence("mSubtitle"));
            this.f10678M.setImageBitmap((Bitmap) getArguments().getParcelable("imageProfile"));
            this.f10693j = getArguments().getString("sessionId");
            this.f10694k = getArguments().getString("inboxNO");
            this.f10695l = getArguments().getBoolean("isValid", false);
            this.f10682Q = (ImageView) viewInflate.findViewById(R.id.imageTrunk);
            this.f10682Q.setOnClickListener(new ViewOnClickListenerC3034ch(this));
        } else {
            this.f10693j = this.f10692i.getStringExtra("sessionId");
            this.f10694k = this.f10692i.getStringExtra("inboxNO");
            this.f10695l = this.f10692i.getBooleanExtra("isValid", false);
        }
        this.f10703t = EnumC2959b.m10433a(C3159aa.m10962a().m10979a("trunkOrderingType", EnumC2959b.UnreadComment.m10434a()));
        this.f10706w = new C3018bz(this, this.f10684S, this.f10703t, this.f10693j);
        this.f10676K.clear();
        this.f10702s = new ViewOnClickListenerC3064r(this.f10690g, null, 0, this.f10703t, this.f10694k, this.f10670E, this, this.f10676K);
        this.f10666A = (LinearLayout) viewInflate.findViewById(R.id.moreLoadbar);
        this.f10696m = (ListView) viewInflate.findViewById(R.id.trunkItemGridView);
        this.f10696m.setAdapter((ListAdapter) this.f10702s);
        this.f10696m.setFocusable(true);
        this.f10696m.setItemsCanFocus(true);
        if (this.f10675J != null) {
            this.f10675J.findItem(R.id.btnDeleteMode).setEnabled(false);
            C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteMode));
            if (this.f10673H != null && this.f10673H.size() == 0) {
                this.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteComplete));
            }
        }
        m10381b(false);
        this.f10671F = (CheckedTextView) viewInflate.findViewById(R.id.selectAll);
        this.f10671F.setOnClickListener(new ViewOnClickListenerC3035ci(this));
        this.f10697n = viewInflate.findViewById(R.id.nothingView);
        this.f10698o = viewInflate.findViewById(R.id.networkErrorView);
        this.f10699p = viewInflate.findViewById(R.id.loadingView);
        if (this.f10677L) {
            this.f10705v = EnumC3041co.DeleteMode;
        } else {
            this.f10705v = EnumC3041co.TrunkItem;
        }
        m10390e();
        this.f10706w.m10411a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10706w.m10412b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f10706w.m10413c();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10685a = true;
        this.f10707x = null;
        this.f10702s.m10607c();
        if (this.f10696m != null) {
            this.f10696m.setOnItemClickListener(null);
            this.f10696m.setAdapter((ListAdapter) null);
        }
        if (this.f10670E != null) {
            this.f10670E.m11731a();
        }
        this.f10706w.m10414d();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkView.onDestroy()", f10665c);
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public void m10409a(boolean z) {
        if (Build.VERSION.SDK_INT >= 11 && this.f10675J != null && this.f10675J.findItem(R.id.btnDeleteMode) != null) {
            if (z) {
                this.f10675J.findItem(R.id.btnDeleteMode).setActionView(R.layout.layout_refresh_progressbar);
            } else {
                this.f10675J.findItem(R.id.btnDeleteMode).setActionView((View) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.trunk_menu, menu);
        this.f10675J = menu;
        if (this.f10677L) {
            this.f10675J.setGroupVisible(R.id.trunk_noraml_menu, false);
            this.f10675J.setGroupVisible(R.id.trunk_menu_delete, true);
            if (this.f10673H != null && this.f10673H.size() == 0) {
                this.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteComplete));
            }
        } else {
            this.f10675J.setGroupVisible(R.id.trunk_noraml_menu, true);
            this.f10675J.setGroupVisible(R.id.trunk_menu_delete, false);
            this.f10675J.findItem(R.id.btnDeleteMode).setEnabled(false);
            C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteMode));
            m10381b(false);
        }
        if (GlobalApplication.m6456e()) {
            this.f10675J.findItem(R.id.btnDeleteMode).setVisible(false);
        }
        if (!this.f10683R) {
            m10409a(true);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        m10394g();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.btnDeleteMode /* 2131166581 */:
                m10373a(EnumC3041co.DeleteMode);
                this.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteComplete));
                return false;
            case R.id.btnForModeChange /* 2131166583 */:
                if (GlobalApplication.m6456e()) {
                    this.f10681P.setVisibility(0);
                }
                this.f10702s.m10606b();
                this.f10671F.setChecked(false);
                m10373a(EnumC3041co.TrunkMode);
                if (GlobalApplication.m6456e()) {
                    m10381b(true);
                }
                return false;
            case R.id.btnDeleteComplete /* 2131166584 */:
                this.f10673H = this.f10702s.m10600a();
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.menu_chat_delete)).mo11509b(getResources().getString(m10383c())).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC3037ck(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return false;
            case R.id.trunk_menu_listby /* 2131166622 */:
                if (C3250y.f11734b) {
                    C3250y.m11450b(String.format("Current order type: %s, ordinal: %s", this.f10703t, Integer.valueOf(this.f10703t.ordinal())), f10665c);
                }
                AbstractC3271a.m11494a(this.f10690g).mo11495a(R.string.buddy_list_optionmenu_listby).mo11496a(R.array.trunk_ordering_types, this.f10703t.ordinal(), new DialogInterfaceOnClickListenerC3036cj(this)).mo11512b();
                return false;
            case R.id.trunk_menu_refresh /* 2131166623 */:
                m10375a(true, true, this.f10703t);
                return false;
            default:
                return false;
        }
    }

    /* renamed from: c */
    private int m10383c() {
        return (this.f10673H == null || this.f10673H.size() <= 1) ? R.string.ams_delete_single_item : R.string.selected_items_deleted;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo10177a(Cursor cursor, EnumC2959b enumC2959b) {
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("SetTrunkItemList( OrderingType: %s )", enumC2959b), f10665c);
        }
        if (this.f10707x == null) {
            m10393f();
            this.f10666A.setVisibility(8);
            m10409a(false);
        }
        this.f10686b = false;
        this.f10672G = 0;
        if (cursor != null && cursor.getCount() > 0) {
            this.f10676K.clear();
            if (this.f10695l) {
                if (this.f10675J != null) {
                    this.f10675J.findItem(R.id.btnDeleteMode).setEnabled(true);
                    C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteMode));
                }
                m10381b(true);
            }
            cursor.moveToLast();
            this.f10667B = cursor.getString(cursor.getColumnIndex("item_id"));
            if (EnumC3048d.m10572a(cursor.getInt(cursor.getColumnIndex("item_type"))) == EnumC3048d.LoadMore) {
                this.f10686b = true;
            } else {
                this.f10686b = false;
            }
            cursor.moveToFirst();
            do {
                if ("ME".equals(cursor.getString(cursor.getColumnIndex("sender_uid")))) {
                    this.f10672G++;
                }
            } while (cursor.moveToNext());
            cursor.moveToFirst();
            for (int i = 0; i < Math.ceil(cursor.getCount() / 9.0d); i++) {
                this.f10676K.add(String.valueOf(i));
                C3250y.m11456e("trunkDataList index add :" + Math.ceil(cursor.getCount() / 9), f10665c);
            }
            C3250y.m11456e("trunkDataList index add :" + Math.ceil(cursor.getCount() / 9.0d), f10665c);
            C3250y.m11456e("trunkDataList index cursor size :" + cursor.getCount(), f10665c);
            C3250y.m11456e("trunkDataList index size :" + this.f10676K.size(), f10665c);
        }
        if (this.f10677L) {
            this.f10702s.m10604a(this.f10673H);
        }
        this.f10702s.m10602a(enumC2959b);
        this.f10702s.m10601a(cursor);
        this.f10702s.notifyDataSetChanged();
        m10394g();
        if (cursor == null || cursor.getCount() == 0) {
            if (this.f10705v == EnumC3041co.NetworkError) {
                m10373a(EnumC3041co.NetworkError);
            } else {
                m10373a(EnumC3041co.Nothing);
            }
            if (this.f10675J != null) {
                this.f10675J.findItem(R.id.btnDeleteMode).setEnabled(false);
                C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteMode));
            }
            m10381b(false);
        } else if (this.f10677L) {
            m10373a(EnumC3041co.DeleteMode);
        } else {
            m10373a(EnumC3041co.TrunkItem);
        }
        if (!this.f10709z) {
            m10375a(false, false, this.f10703t);
            this.f10709z = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10372a(EnumC3040cn enumC3040cn) {
        switch (C3038cl.f10919a[enumC3040cn.ordinal()]) {
            case 1:
                this.f10669D.setText(R.string.popup_no_network_connection);
                this.f10669D.setDuration(0);
                this.f10669D.show();
                break;
            case 2:
                this.f10669D.setText(R.string.toast_network_unable);
                this.f10669D.setDuration(0);
                this.f10669D.show();
                break;
        }
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo10180a(InterfaceC3062p interfaceC3062p) {
        this.f10687d = interfaceC3062p;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo10178a(InterfaceC3060n interfaceC3060n) {
        this.f10688e = interfaceC3060n;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo10179a(InterfaceC3061o interfaceC3061o) {
        this.f10689f = interfaceC3061o;
    }

    /* renamed from: a */
    public void m10407a(C3068v c3068v) {
        if (this.f10705v == EnumC3041co.DeleteMode || this.f10702s.f10965a) {
            if ("ME".equals(c3068v.f10997i)) {
                if (c3068v.f10998j.isChecked()) {
                    c3068v.f10998j.setChecked(false);
                    this.f10671F.setChecked(false);
                } else {
                    c3068v.f10998j.setChecked(true);
                }
                this.f10702s.m10603a(c3068v, c3068v.f10998j.isChecked());
                if (this.f10672G != 0 && this.f10702s.m10600a().size() == this.f10672G) {
                    this.f10671F.setChecked(true);
                }
            }
            if (this.f10702s.m10600a().isEmpty()) {
                this.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteComplete));
                m10381b(false);
                return;
            } else {
                this.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(true);
                C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteComplete));
                m10381b(true);
                return;
            }
        }
        this.f10691h.mo1316a(this.f10693j, this.f10694k, c3068v.f10989a, c3068v.f10996h, c3068v.f10995g, c3068v.f10991c, this.f10695l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10387d() {
        if (this.f10703t == EnumC2959b.Recent) {
            this.f10703t = EnumC2959b.UnreadComment;
        } else if (this.f10703t == EnumC2959b.UnreadComment) {
            this.f10703t = EnumC2959b.Recent;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("Toggle ordering type to %s", this.f10703t), f10665c);
        }
        C3159aa.m10962a().m10986b("trunkOrderingType", this.f10703t.m10434a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10375a(boolean z, boolean z2, EnumC2959b enumC2959b) {
        int i = 30;
        if (m10397h()) {
            if (enumC2959b != this.f10703t) {
                this.f10704u = true;
            }
            this.f10683R = z2;
            if (enumC2959b == EnumC2959b.Recent) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(String.format("Request type is recent. Load item count: %d", 30), f10665c);
                }
            } else if (enumC2959b == EnumC2959b.UnreadComment) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(String.format("Request type is unread comment. Load item count: %d", 100), f10665c);
                }
                i = 100;
            } else {
                i = 0;
            }
            this.f10707x = this.f10687d.mo10541a(z, enumC2959b, i, 239);
            if (this.f10702s.getCount() == 0) {
                this.f10683R = true;
            }
            if (this.f10683R) {
                m10390e();
                if (this.f10675J != null) {
                    this.f10675J.findItem(R.id.btnDeleteMode).setEnabled(false);
                    C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteMode));
                }
            } else {
                m10409a(true);
                if (this.f10675J != null) {
                    this.f10675J.findItem(R.id.btnDeleteMode).setEnabled(false);
                    C3228cp.m11343a(this.f10675J.findItem(R.id.btnDeleteMode));
                }
                m10381b(false);
            }
            m10394g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10374a(String str) {
        if (m10397h()) {
            this.f10666A.setVisibility(0);
            this.f10707x = this.f10688e.mo10543a(this.f10703t, 31, 239, str);
            m10394g();
        }
    }

    /* renamed from: e */
    private void m10390e() {
        this.f10699p.setVisibility(0);
        this.f10666A.setVisibility(8);
        m10409a(false);
        if (this.f10700q != null) {
            this.f10700q.setVisibility(8);
        }
        this.f10696m.setVisibility(8);
        this.f10698o.setVisibility(8);
        this.f10697n.setVisibility(8);
    }

    /* renamed from: f */
    private void m10393f() {
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("Hide trunk item list loading view. change view to %s", this.f10705v), f10665c);
        }
        this.f10699p.setVisibility(8);
        m10373a(this.f10705v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10373a(EnumC3041co enumC3041co) {
        this.f10705v = enumC3041co;
        if (this.f10707x == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("Switch view to %s", this.f10705v), f10665c);
            }
            switch (C3038cl.f10920b[enumC3041co.ordinal()]) {
                case 1:
                    if (this.f10700q != null) {
                        this.f10700q.setVisibility(0);
                    }
                    this.f10696m.setVisibility(0);
                    this.f10698o.setVisibility(8);
                    this.f10697n.setVisibility(8);
                    this.f10699p.setVisibility(8);
                    break;
                case 2:
                    if (this.f10700q != null) {
                        this.f10700q.setVisibility(8);
                    }
                    this.f10696m.setVisibility(8);
                    this.f10698o.setVisibility(0);
                    int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a || -2 == iM6733a) {
                        m10372a(EnumC3040cn.Nonetwork);
                    } else {
                        m10372a(EnumC3040cn.NetworkErr);
                    }
                    this.f10697n.setVisibility(8);
                    this.f10699p.setVisibility(8);
                    break;
                case 3:
                    if (this.f10700q != null) {
                        this.f10700q.setVisibility(8);
                    }
                    this.f10696m.setVisibility(8);
                    this.f10698o.setVisibility(8);
                    this.f10697n.setVisibility(0);
                    this.f10699p.setVisibility(8);
                    break;
                case 4:
                    if (this.f10675J != null) {
                        this.f10675J.setGroupVisible(R.id.trunk_noraml_menu, false);
                        this.f10675J.setGroupVisible(R.id.trunk_menu_delete, true);
                    }
                    if (!GlobalApplication.m6456e()) {
                        ((TrunkActivity) getActivity()).m10181c().mo11583a(GlobalApplication.m6451b().getString(R.string.setting_delete_account_delete));
                    }
                    this.f10671F.setVisibility(0);
                    if (this.f10672G < 1) {
                        this.f10671F.setEnabled(false);
                        this.f10671F.setChecked(false);
                    } else if (this.f10673H != null && this.f10673H.size() == this.f10672G) {
                        this.f10671F.setEnabled(true);
                        this.f10671F.setChecked(true);
                    } else {
                        this.f10671F.setEnabled(true);
                        this.f10671F.setChecked(false);
                    }
                    this.f10702s.f10965a = true;
                    if (this.f10677L) {
                        this.f10696m.setVisibility(0);
                    }
                    this.f10696m.invalidateViews();
                    break;
                case 5:
                    if (this.f10675J != null) {
                        this.f10675J.setGroupVisible(R.id.trunk_noraml_menu, true);
                        this.f10675J.setGroupVisible(R.id.trunk_menu_delete, false);
                    }
                    if (!GlobalApplication.m6456e()) {
                        ((TrunkActivity) getActivity()).m10181c().mo11583a(GlobalApplication.m6451b().getString(R.string.trunk_title));
                    } else if (this.f10675J != null) {
                        this.f10675J.findItem(R.id.btnDeleteMode).setVisible(false);
                    }
                    this.f10671F.setVisibility(8);
                    this.f10702s.f10965a = false;
                    this.f10696m.invalidateViews();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m10394g() {
        if (!m10397h() || this.f10707x != null) {
            if (this.f10675J != null) {
                this.f10675J.findItem(R.id.trunk_menu_listby).setEnabled(false);
            }
            if (this.f10675J != null) {
                this.f10675J.findItem(R.id.trunk_menu_refresh).setEnabled(false);
                return;
            }
            return;
        }
        if (this.f10675J != null) {
            if (this.f10702s.getCount() != 0) {
                this.f10675J.findItem(R.id.trunk_menu_listby).setEnabled(true);
            } else {
                this.f10675J.findItem(R.id.trunk_menu_listby).setEnabled(false);
            }
        }
        if (this.f10675J != null) {
            this.f10675J.findItem(R.id.trunk_menu_refresh).setEnabled(true);
        }
    }

    /* renamed from: h */
    private boolean m10397h() {
        if (this.f10693j != null && !this.f10693j.trim().equals("")) {
            return true;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("SessionId is invalid.", f10665c);
        }
        return false;
    }

    /* renamed from: a */
    public void m10408a(HashMap<String, Boolean> map) {
        m10399i();
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        this.f10708y = this.f10689f.mo10545a(arrayList, this.f10693j);
    }

    /* renamed from: i */
    private void m10399i() {
        if (this.f10674I == null) {
            this.f10674I = new C3263j(this.f10690g).m11487a(R.string.setting_webview_please_wait);
            this.f10674I.setCancelable(false);
        }
        if (this.f10674I != null) {
            this.f10674I.show();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3063q
    /* renamed from: a */
    public boolean mo10410a() {
        if (this.f10705v != EnumC3041co.DeleteMode) {
            return false;
        }
        this.f10702s.m10606b();
        this.f10671F.setChecked(false);
        m10373a(EnumC3041co.TrunkMode);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10705v == EnumC3041co.DeleteMode) {
            this.f10673H = this.f10702s.m10600a();
            bundle.putSerializable("checkedItem", (HashMap) this.f10673H.clone());
            bundle.putBoolean("isRefreshInDelete", true);
            return;
        }
        bundle.putBoolean("isRefreshInDelete", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10381b(boolean z) {
        if (GlobalApplication.m6456e() && this.f10682Q != null) {
            this.f10682Q.setEnabled(z);
        }
    }
}
