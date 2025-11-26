package com.sec.chaton.trunk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
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
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.trunk.database.EnumC4668d;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class TrunkView extends ITrunkView implements InterfaceC4683q {

    /* renamed from: c */
    private static final String f16613c = TrunkView.class.getSimpleName();

    /* renamed from: A */
    private LinearLayout f16614A;

    /* renamed from: B */
    private String f16615B;

    /* renamed from: D */
    private Toast f16617D;

    /* renamed from: E */
    private C5007c f16618E;

    /* renamed from: F */
    private CheckedTextView f16619F;

    /* renamed from: G */
    private int f16620G;

    /* renamed from: H */
    private HashMap<String, Boolean> f16621H;

    /* renamed from: I */
    private Dialog f16622I;

    /* renamed from: J */
    private Menu f16623J;

    /* renamed from: L */
    private boolean f16625L;

    /* renamed from: O */
    private InterfaceC4936e f16628O;

    /* renamed from: a */
    boolean f16630a;

    /* renamed from: d */
    private InterfaceC4682p f16632d;

    /* renamed from: e */
    private InterfaceC4680n f16633e;

    /* renamed from: f */
    private InterfaceC4681o f16634f;

    /* renamed from: g */
    private Activity f16635g;

    /* renamed from: h */
    private InterfaceC4659cq f16636h;

    /* renamed from: i */
    private Intent f16637i;

    /* renamed from: j */
    private String f16638j;

    /* renamed from: k */
    private String f16639k;

    /* renamed from: l */
    private boolean f16640l;

    /* renamed from: m */
    private ListView f16641m;

    /* renamed from: n */
    private View f16642n;

    /* renamed from: o */
    private View f16643o;

    /* renamed from: p */
    private View f16644p;

    /* renamed from: q */
    private LinearLayout f16645q;

    /* renamed from: r */
    private Spinner f16646r;

    /* renamed from: s */
    private ViewOnClickListenerC4684r f16647s;

    /* renamed from: t */
    private EnumC4575b f16648t;

    /* renamed from: u */
    private boolean f16649u;

    /* renamed from: v */
    private EnumC4661cs f16650v;

    /* renamed from: w */
    private C4646cd f16651w;

    /* renamed from: x */
    private Future<C0778b> f16652x;

    /* renamed from: y */
    private Future<C0778b> f16653y;

    /* renamed from: z */
    private boolean f16654z;

    /* renamed from: b */
    public boolean f16631b = false;

    /* renamed from: C */
    private boolean f16616C = false;

    /* renamed from: K */
    private ArrayList<String> f16624K = new ArrayList<>();

    /* renamed from: M */
    private boolean f16626M = true;

    /* renamed from: N */
    private boolean f16627N = false;

    /* renamed from: P */
    private Handler f16629P = new HandlerC4652cj(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16635g = activity;
        try {
            this.f16636h = (InterfaceC4659cq) this.f16635g;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16635g = null;
        this.f16636h = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkView.onCreate()", f16613c);
        }
        super.onCreate(bundle);
        this.f16617D = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkView.onCreateView()", f16613c);
        }
        this.f16630a = false;
        this.f16654z = false;
        this.f16616C = false;
        this.f16625L = false;
        this.f16618E = new C5007c();
        if (bundle != null) {
            this.f16621H = (HashMap) bundle.getSerializable("checkedItem");
            this.f16625L = bundle.getBoolean("isRefreshInDelete", false);
            this.f16627N = bundle.getBoolean("onPopup", false);
            this.f16650v = (EnumC4661cs) bundle.getSerializable("viewtype");
        }
        setHasOptionsMenu(true);
        this.f16637i = this.f16635g.getIntent();
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk, viewGroup, false);
        this.f16638j = this.f16637i.getStringExtra("sessionId");
        this.f16639k = this.f16637i.getStringExtra("inboxNO");
        this.f16640l = this.f16637i.getBooleanExtra("isValid", false);
        this.f16648t = EnumC4575b.m17529a(C4809aa.m18104a().m18121a("trunkOrderingType", EnumC4575b.UnreadComment.m17530a()));
        this.f16651w = new C4646cd(this, this.f16629P, this.f16648t, this.f16638j);
        this.f16624K.clear();
        this.f16647s = new ViewOnClickListenerC4684r(this.f16635g, null, 0, this.f16648t, this.f16639k, this.f16618E, this, this.f16624K);
        this.f16614A = (LinearLayout) viewInflate.findViewById(R.id.moreLoadbar);
        this.f16641m = (ListView) viewInflate.findViewById(R.id.trunkItemGridView);
        this.f16641m.setAdapter((ListAdapter) this.f16647s);
        this.f16641m.setItemsCanFocus(true);
        this.f16641m.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        if (this.f16623J != null) {
            this.f16623J.findItem(R.id.btnDeleteMode).setEnabled(false);
            C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteMode));
            if (this.f16621H != null && this.f16621H.size() == 0) {
                this.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteComplete));
            }
        }
        this.f16619F = (CheckedTextView) viewInflate.findViewById(R.id.selectAll);
        this.f16619F.setOnClickListener(new ViewOnClickListenerC4654cl(this));
        this.f16642n = viewInflate.findViewById(R.id.noContents);
        ImageView imageView = (ImageView) this.f16642n.findViewById(R.id.image1);
        TextView textView = (TextView) this.f16642n.findViewById(R.id.text1);
        TextView textView2 = (TextView) this.f16642n.findViewById(R.id.text2);
        textView.setVisibility(8);
        imageView.setImageResource(R.drawable.no_contents_trunk);
        textView2.setText(R.string.album_share_pictures);
        this.f16643o = viewInflate.findViewById(R.id.networkErrorView);
        ImageView imageView2 = (ImageView) this.f16643o.findViewById(R.id.image1);
        TextView textView3 = (TextView) this.f16643o.findViewById(R.id.text1);
        TextView textView4 = (TextView) this.f16643o.findViewById(R.id.text2);
        textView3.setVisibility(8);
        imageView2.setImageResource(R.drawable.no_contents_network);
        textView4.setText(R.string.toast_network_unable);
        this.f16644p = viewInflate.findViewById(R.id.loadingView);
        if (this.f16625L) {
            this.f16650v = EnumC4661cs.DeleteMode;
        } else {
            this.f16650v = EnumC4661cs.TrunkItem;
        }
        m17490f();
        this.f16651w.m17508a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16651w.m17509b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f16651w.m17510c();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16630a = true;
        this.f16652x = null;
        this.f16647s.m17701c();
        if (this.f16641m != null) {
            this.f16641m.setOnItemClickListener(null);
            this.f16641m.setAdapter((ListAdapter) null);
        }
        if (this.f16618E != null) {
            this.f16618E.m19014a();
        }
        this.f16651w.m17511d();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkView.onDestroy()", f16613c);
        }
        super.onDestroy();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m17506a(boolean z) {
        if (Build.VERSION.SDK_INT >= 11 && this.f16623J != null && this.f16623J.findItem(R.id.btnDeleteMode) != null) {
            if (z) {
                this.f16623J.findItem(R.id.btnDeleteMode).setActionView(R.layout.layout_refresh_progressbar);
            } else {
                this.f16623J.findItem(R.id.btnDeleteMode).setActionView((View) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.trunk_menu, menu);
        this.f16623J = menu;
        if (this.f16625L) {
            this.f16623J.setGroupVisible(R.id.trunk_noraml_menu, false);
            this.f16623J.setGroupVisible(R.id.trunk_menu_delete, true);
            if (this.f16621H != null && this.f16621H.size() == 0) {
                this.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteComplete));
            }
        } else {
            this.f16623J.setGroupVisible(R.id.trunk_noraml_menu, true);
            this.f16623J.setGroupVisible(R.id.trunk_menu_delete, false);
            this.f16623J.findItem(R.id.btnDeleteMode).setEnabled(false);
            C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteMode));
        }
        if (!this.f16626M) {
            m17506a(true);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        m17494h();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.btnDeleteMode /* 2131166663 */:
                m17471a(EnumC4661cs.DeleteMode);
                if (this.f16623J != null) {
                    this.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                    C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteComplete));
                    m17470a(EnumC4660cr.Delete_guide);
                }
                return false;
            case R.id.btnForModeChange /* 2131166665 */:
                this.f16647s.m17700b();
                this.f16619F.setChecked(false);
                m17471a(EnumC4661cs.TrunkMode);
                return false;
            case R.id.btnDeleteComplete /* 2131166666 */:
                this.f16621H = this.f16647s.m17694a();
                m17480c();
                this.f16627N = true;
                return false;
            case R.id.trunk_menu_listby /* 2131166719 */:
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.format("Current order type: %s, ordinal: %s", this.f16648t, Integer.valueOf(this.f16648t.ordinal())), f16613c);
                }
                AbstractC4932a.m18733a(this.f16635g).mo18734a(R.string.setting_download_anicon_sort_by).mo18735a(R.array.trunk_ordering_types, this.f16648t.ordinal(), new DialogInterfaceOnClickListenerC4655cm(this)).mo18752b();
                return false;
            case R.id.trunk_menu_refresh /* 2131166720 */:
                m17473a(true, true, this.f16648t);
                return false;
            default:
                return false;
        }
    }

    /* renamed from: c */
    private void m17480c() {
        if (this.f16628O == null || !this.f16628O.isShowing()) {
            int i = R.string.menu_chat_delete;
            if (this.f16619F.isChecked()) {
                i = R.string.delete_all_items;
            }
            this.f16628O = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(i)).mo18749b(getResources().getString(m17483d())).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4656cn(this)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18745a();
            this.f16628O.setCanceledOnTouchOutside(false);
            this.f16628O.setOnDismissListener(new DialogInterfaceOnDismissListenerC4657co(this));
            this.f16628O.show();
        }
    }

    /* renamed from: d */
    private int m17483d() {
        return (this.f16621H == null || this.f16621H.size() <= 1) ? R.string.ams_delete_single_item : R.string.selected_items_deleted;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo17265a(Cursor cursor, EnumC4575b enumC4575b) {
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("SetTrunkItemList( OrderingType: %s )", enumC4575b), f16613c);
        }
        if (this.f16652x == null) {
            m17491g();
            this.f16614A.setVisibility(8);
            m17506a(false);
        }
        this.f16631b = false;
        this.f16620G = 0;
        if (cursor != null && cursor.getCount() > 0) {
            this.f16624K.clear();
            if (this.f16640l && this.f16623J != null) {
                this.f16623J.findItem(R.id.btnDeleteMode).setEnabled(true);
                C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteMode));
            }
            cursor.moveToLast();
            this.f16615B = cursor.getString(cursor.getColumnIndex("item_id"));
            if (EnumC4668d.m17666a(cursor.getInt(cursor.getColumnIndex("item_type"))) == EnumC4668d.LoadMore) {
                this.f16631b = true;
            } else {
                this.f16631b = false;
            }
            cursor.moveToFirst();
            do {
                if ("ME".equals(cursor.getString(cursor.getColumnIndex("sender_uid")))) {
                    this.f16620G++;
                }
            } while (cursor.moveToNext());
            cursor.moveToFirst();
            for (int i = 0; i < Math.ceil(cursor.getCount() / 9.0d); i++) {
                this.f16624K.add(String.valueOf(i));
                C4904y.m18646e("trunkDataList index add :" + Math.ceil(cursor.getCount() / 9), f16613c);
            }
            C4904y.m18646e("trunkDataList index add :" + Math.ceil(cursor.getCount() / 9.0d), f16613c);
            C4904y.m18646e("trunkDataList index cursor size :" + cursor.getCount(), f16613c);
            C4904y.m18646e("trunkDataList index size :" + this.f16624K.size(), f16613c);
        }
        if (this.f16625L) {
            this.f16647s.m17698a(this.f16621H);
        }
        this.f16647s.m17696a(enumC4575b);
        this.f16647s.m17695a(cursor);
        this.f16647s.notifyDataSetChanged();
        if (cursor == null || cursor.getCount() == 0) {
            this.f16624K.clear();
            if (this.f16650v == EnumC4661cs.NetworkError) {
                m17471a(EnumC4661cs.NetworkError);
            } else {
                m17471a(EnumC4661cs.Nothing);
            }
            if (this.f16623J != null) {
                this.f16623J.findItem(R.id.btnDeleteMode).setEnabled(false);
                C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteMode));
            }
        } else if (this.f16625L) {
            m17471a(EnumC4661cs.DeleteMode);
        } else {
            m17471a(EnumC4661cs.TrunkItem);
        }
        if (!this.f16654z) {
            m17473a(false, false, this.f16648t);
            this.f16654z = true;
        }
        m17494h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17470a(EnumC4660cr enumC4660cr) {
        switch (C4658cp.f16869a[enumC4660cr.ordinal()]) {
            case 1:
                this.f16617D.setText(R.string.popup_no_network_connection);
                this.f16617D.setDuration(0);
                this.f16617D.show();
                break;
            case 2:
                this.f16617D.setText(R.string.toast_network_unable);
                this.f16617D.setDuration(0);
                this.f16617D.show();
                break;
            case 3:
                this.f16617D.setText(R.string.trunk_delete_item);
                this.f16617D.setDuration(0);
                this.f16617D.show();
                break;
        }
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo17268a(InterfaceC4682p interfaceC4682p) {
        this.f16632d = interfaceC4682p;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo17266a(InterfaceC4680n interfaceC4680n) {
        this.f16633e = interfaceC4680n;
    }

    @Override // com.sec.chaton.trunk.ITrunkView
    /* renamed from: a */
    public void mo17267a(InterfaceC4681o interfaceC4681o) {
        this.f16634f = interfaceC4681o;
    }

    /* renamed from: a */
    public void m17504a(C4688v c4688v) {
        if (this.f16650v == EnumC4661cs.DeleteMode || this.f16647s.f16914a) {
            if ("ME".equals(c4688v.f16946i)) {
                if (c4688v.f16947j.isChecked()) {
                    c4688v.f16947j.setChecked(false);
                    this.f16619F.setChecked(false);
                } else {
                    c4688v.f16947j.setChecked(true);
                }
                this.f16647s.m17697a(c4688v, c4688v.f16947j.isChecked());
                if (this.f16620G != 0 && this.f16647s.m17694a().size() == this.f16620G) {
                    this.f16619F.setChecked(true);
                }
            }
            if (this.f16647s.m17694a().isEmpty()) {
                this.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(false);
                C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteComplete));
                return;
            } else {
                this.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(true);
                C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteComplete));
                return;
            }
        }
        this.f16636h.mo3086a(this.f16638j, this.f16639k, c4688v.f16938a, c4688v.f16945h, c4688v.f16944g, c4688v.f16940c, this.f16640l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m17487e() {
        if (this.f16648t == EnumC4575b.Recent) {
            this.f16648t = EnumC4575b.UnreadComment;
        } else if (this.f16648t == EnumC4575b.UnreadComment) {
            this.f16648t = EnumC4575b.Recent;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("Toggle ordering type to %s", this.f16648t), f16613c);
        }
        C4809aa.m18104a().m18128b("trunkOrderingType", this.f16648t.m17530a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17473a(boolean z, boolean z2, EnumC4575b enumC4575b) {
        int i = 30;
        if (m17496i()) {
            if (enumC4575b != this.f16648t) {
                this.f16649u = true;
            }
            this.f16626M = z2;
            if (enumC4575b == EnumC4575b.Recent) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.format("Request type is recent. Load item count: %d", 30), f16613c);
                }
            } else if (enumC4575b == EnumC4575b.UnreadComment) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.format("Request type is unread comment. Load item count: %d", 100), f16613c);
                }
                i = 100;
            } else {
                i = 0;
            }
            this.f16652x = this.f16632d.mo17638a(z, enumC4575b, i, 239);
            if (this.f16647s.getCount() == 0) {
                this.f16626M = true;
            }
            if (this.f16626M) {
                m17490f();
                if (this.f16623J != null) {
                    this.f16623J.findItem(R.id.btnDeleteMode).setEnabled(false);
                    C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteMode));
                }
            } else {
                m17506a(true);
                if (this.f16623J != null) {
                    this.f16623J.findItem(R.id.btnDeleteMode).setEnabled(false);
                    C4880cr.m18523a(this.f16623J.findItem(R.id.btnDeleteMode));
                }
            }
            m17494h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17472a(String str) {
        if (m17496i()) {
            this.f16614A.setVisibility(0);
            this.f16652x = this.f16633e.mo17639a(this.f16648t, 31, 239, str);
            m17494h();
        }
    }

    /* renamed from: f */
    private void m17490f() {
        this.f16644p.setVisibility(0);
        this.f16614A.setVisibility(8);
        m17506a(false);
        if (this.f16645q != null) {
            this.f16645q.setVisibility(8);
        }
        this.f16641m.setVisibility(8);
        this.f16643o.setVisibility(8);
        this.f16642n.setVisibility(8);
    }

    /* renamed from: g */
    private void m17491g() {
        int iM10677a;
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("Hide trunk item list loading view. change view to %s", this.f16650v), f16613c);
        }
        this.f16644p.setVisibility(8);
        if (this.f16650v == EnumC4661cs.NetworkError && -3 != (iM10677a = C2471v.m10677a(CommonApplication.m18732r())) && -2 != iM10677a) {
            this.f16650v = EnumC4661cs.TrunkItem;
        }
        m17471a(this.f16650v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17471a(EnumC4661cs enumC4661cs) {
        this.f16650v = enumC4661cs;
        if (this.f16652x == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("Switch view to %s", this.f16650v), f16613c);
            }
            switch (C4658cp.f16870b[enumC4661cs.ordinal()]) {
                case 1:
                    if (this.f16645q != null) {
                        this.f16645q.setVisibility(0);
                    }
                    this.f16641m.setVisibility(0);
                    this.f16643o.setVisibility(8);
                    this.f16642n.setVisibility(8);
                    this.f16644p.setVisibility(8);
                    break;
                case 2:
                    if (this.f16645q != null) {
                        this.f16645q.setVisibility(8);
                    }
                    this.f16641m.setVisibility(8);
                    this.f16643o.setVisibility(0);
                    int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        m17470a(EnumC4660cr.Nonetwork);
                    } else {
                        m17470a(EnumC4660cr.NetworkErr);
                    }
                    this.f16642n.setVisibility(8);
                    this.f16644p.setVisibility(8);
                    break;
                case 3:
                    if (this.f16645q != null) {
                        this.f16645q.setVisibility(8);
                    }
                    this.f16641m.setVisibility(8);
                    this.f16643o.setVisibility(8);
                    this.f16642n.setVisibility(0);
                    this.f16644p.setVisibility(8);
                    this.f16625L = false;
                    break;
                case 4:
                    if (this.f16623J != null) {
                        this.f16623J.setGroupVisible(R.id.trunk_noraml_menu, false);
                        this.f16623J.setGroupVisible(R.id.trunk_menu_delete, true);
                    }
                    ((TrunkActivity) getActivity()).m17269h().mo18823a(GlobalApplication.m10283b().getString(R.string.setting_delete_account_delete));
                    this.f16619F.setVisibility(0);
                    if (this.f16620G < 1) {
                        this.f16619F.setEnabled(false);
                        this.f16619F.setChecked(false);
                    } else if (this.f16621H != null && this.f16621H.size() == this.f16620G) {
                        this.f16619F.setEnabled(true);
                        this.f16619F.setChecked(true);
                    } else {
                        this.f16619F.setEnabled(true);
                        this.f16619F.setChecked(false);
                    }
                    this.f16647s.f16914a = true;
                    if (this.f16625L) {
                        this.f16641m.setVisibility(0);
                    }
                    if (this.f16627N) {
                        m17480c();
                    }
                    this.f16641m.invalidateViews();
                    break;
                case 5:
                    if (this.f16623J != null) {
                        this.f16623J.setGroupVisible(R.id.trunk_noraml_menu, true);
                        this.f16623J.setGroupVisible(R.id.trunk_menu_delete, false);
                    }
                    ((TrunkActivity) getActivity()).m17269h().mo18823a(GlobalApplication.m10283b().getString(R.string.trunk_title));
                    this.f16619F.setVisibility(8);
                    this.f16647s.f16914a = false;
                    this.f16641m.invalidateViews();
                    this.f16625L = false;
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m17494h() {
        if (!m17496i() || this.f16652x != null) {
            if (this.f16623J != null) {
                this.f16623J.findItem(R.id.trunk_menu_listby).setEnabled(false);
            }
            if (this.f16623J != null) {
                this.f16623J.findItem(R.id.trunk_menu_refresh).setEnabled(false);
                return;
            }
            return;
        }
        if (this.f16623J != null) {
            if (this.f16647s.getCount() != 0) {
                this.f16623J.findItem(R.id.trunk_menu_listby).setEnabled(true);
            } else {
                this.f16623J.findItem(R.id.trunk_menu_listby).setEnabled(false);
            }
        }
        if (this.f16623J != null) {
            this.f16623J.findItem(R.id.trunk_menu_refresh).setEnabled(true);
        }
    }

    /* renamed from: i */
    private boolean m17496i() {
        if (this.f16638j != null && !this.f16638j.trim().equals("")) {
            return true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("SessionId is invalid.", f16613c);
        }
        return false;
    }

    /* renamed from: a */
    public void m17505a(HashMap<String, Boolean> map) {
        m17498j();
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        this.f16653y = this.f16634f.mo17640a(arrayList, this.f16638j);
    }

    /* renamed from: j */
    private void m17498j() {
        if (this.f16622I == null) {
            this.f16622I = new C4923p(this.f16635g).m18724a(R.string.setting_webview_please_wait);
            this.f16622I.setCancelable(false);
        }
        if (this.f16622I != null) {
            this.f16622I.show();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4683q
    /* renamed from: a */
    public boolean mo17507a() {
        if (this.f16650v != EnumC4661cs.DeleteMode) {
            return false;
        }
        this.f16647s.m17700b();
        this.f16619F.setChecked(false);
        m17471a(EnumC4661cs.TrunkMode);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f16650v == EnumC4661cs.DeleteMode) {
            this.f16621H = this.f16647s.m17694a();
            bundle.putSerializable("checkedItem", (HashMap) this.f16621H.clone());
            bundle.putBoolean("isRefreshInDelete", true);
            bundle.putSerializable("viewtype", this.f16650v);
            if (this.f16628O != null && this.f16628O.isShowing()) {
                bundle.putBoolean("onPopup", true);
                return;
            } else {
                bundle.putBoolean("onPopup", false);
                return;
            }
        }
        bundle.putBoolean("isRefreshInDelete", false);
    }
}
