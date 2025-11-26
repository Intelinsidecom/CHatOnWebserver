package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.msgbox.C2660e;
import com.sec.chaton.p057e.C2287g;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import com.sec.widget.DropPanelMenu;
import com.sec.widget.FastScrollableListView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ThreadSelectionFragment extends ListFragment {

    /* renamed from: i */
    public static final String f15167i = ThreadSelectionFragment.class.getSimpleName();

    /* renamed from: A */
    private C2210x f15168A;

    /* renamed from: B */
    private int f15169B;

    /* renamed from: D */
    private String f15171D;

    /* renamed from: E */
    private String f15172E;

    /* renamed from: F */
    private String f15173F;

    /* renamed from: G */
    private String f15174G;

    /* renamed from: H */
    private DropPanelMenu f15175H;

    /* renamed from: J */
    private boolean f15177J;

    /* renamed from: K */
    private Menu f15178K;

    /* renamed from: L */
    private long[] f15179L;

    /* renamed from: N */
    private C5007c f15181N;

    /* renamed from: O */
    private InterfaceC4341jg f15182O;

    /* renamed from: Q */
    private LinearLayout f15184Q;

    /* renamed from: R */
    private View f15185R;

    /* renamed from: S */
    private ClearableEditText f15186S;

    /* renamed from: T */
    private View f15187T;

    /* renamed from: j */
    Bundle f15193j;

    /* renamed from: o */
    private ImageView f15198o;

    /* renamed from: p */
    private TextView f15199p;

    /* renamed from: q */
    private TextView f15200q;

    /* renamed from: r */
    private ViewStub f15201r;

    /* renamed from: s */
    private View f15202s;

    /* renamed from: t */
    private View f15203t;

    /* renamed from: u */
    private LinearLayout f15204u;

    /* renamed from: v */
    private LinearLayout f15205v;

    /* renamed from: w */
    private FastScrollableListView f15206w;

    /* renamed from: x */
    private C4331ix f15207x;

    /* renamed from: y */
    private CheckedTextView f15208y;

    /* renamed from: z */
    private boolean f15209z;

    /* renamed from: C */
    private int f15170C = -1;

    /* renamed from: I */
    private boolean f15176I = false;

    /* renamed from: M */
    private int f15180M = 1;

    /* renamed from: P */
    private EnumC1094bm f15183P = EnumC1094bm.INSIDE;

    /* renamed from: k */
    int f15194k = -1;

    /* renamed from: U */
    private final boolean f15188U = false;

    /* renamed from: V */
    private boolean f15189V = false;

    /* renamed from: l */
    ArrayList<String> f15195l = new ArrayList<>();

    /* renamed from: W */
    private boolean f15190W = false;

    /* renamed from: m */
    ContentObserver f15196m = new C4338jd(this, new Handler());

    /* renamed from: n */
    InterfaceC2211y f15197n = new C4339je(this);

    /* renamed from: X */
    private C2660e f15191X = null;

    /* renamed from: Y */
    private final TextWatcher f15192Y = new C4340jf(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15193j = new Bundle();
        this.f15168A = new C2210x(getActivity().getContentResolver(), this.f15197n);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLongArray("checkArray", this.f15206w.getCheckedItemIds());
    }

    /* renamed from: c */
    private int m16256c() {
        return R.layout.list_item_common_6;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f15181N = new C5007c();
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox, viewGroup, false);
        this.f15184Q = (LinearLayout) viewInflate.findViewById(R.id.msgSearchField);
        if (getActivity() instanceof ChatForwardActivity) {
            this.f15184Q.setVisibility(0);
            this.f15185R = viewInflate.findViewById(R.id.chatRoomSearchField);
            this.f15185R.setBackgroundColor(Color.parseColor("#fafafa"));
            this.f15186S = (ClearableEditText) this.f15185R.findViewById(R.id.text1);
            this.f15186S.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
            this.f15189V = false;
            this.f15186S.m18659a(this.f15192Y);
            this.f15186S.setHint(" " + getActivity().getResources().getString(R.string.chat_search_chat_title));
            this.f15186S.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4335ja(this));
        } else {
            this.f15184Q.setVisibility(8);
        }
        this.f15187T = viewInflate.findViewById(R.id.chatlist_no_search_result);
        this.f15201r = (ViewStub) viewInflate.findViewById(R.id.msg_no);
        this.f15202s = viewInflate.findViewById(R.id.msg_header);
        this.f15202s.setVisibility(8);
        this.f15204u = (LinearLayout) viewInflate.findViewById(R.id.linList);
        this.f15205v = (LinearLayout) viewInflate.findViewById(R.id.msg_loading);
        this.f15206w = (FastScrollableListView) viewInflate.findViewById(android.R.id.list);
        this.f15207x = new C4331ix(getActivity(), m16256c(), null);
        this.f15206w.setAdapter((ListAdapter) this.f15207x);
        this.f15208y = (CheckedTextView) viewInflate.findViewById(R.id.chatlist_delete_select_all);
        this.f15208y.setOnClickListener(new ViewOnClickListenerC4336jb(this));
        this.f15206w.setOnItemClickListener(new C4337jc(this));
        this.f15175H = new DropPanelMenu(this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.f15193j = arguments;
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f15169B = arguments.getInt("content_type");
            }
            if (arguments.containsKey("download_uri")) {
                this.f15171D = arguments.getString("download_uri");
            }
            if (arguments.containsKey("sub_content")) {
                this.f15172E = arguments.getString("sub_content");
            }
            if (arguments.containsKey("inboxNO")) {
                this.f15173F = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f15174G = arguments.getString("forward_sender_name");
            }
            if (arguments.containsKey("mode")) {
                this.f15180M = arguments.getInt("mode");
            }
            if (arguments.containsKey(C1071bk.f3371e)) {
                this.f15183P = (EnumC1094bm) arguments.get(C1071bk.f3371e);
            }
            if (arguments.containsKey("is_forward_mode")) {
                this.f15177J = arguments.getBoolean("is_forward_mode");
            }
            if (arguments.containsKey("ACTIVITY_PURPOSE_ARG2")) {
                this.f15194k = arguments.getInt("ACTIVITY_PURPOSE_ARG2");
            }
            if (arguments.containsKey("except_broadcast")) {
                this.f15190W = arguments.getBoolean("except_broadcast");
            }
        }
        m61a(this.f15207x);
        if (getActivity() instanceof ChatForwardActivity) {
            m60a().setChoiceMode(1);
            this.f15207x.m16505a(1);
            m16254b((ListView) null);
        } else {
            m60a().setChoiceMode(2);
            this.f15207x.m16505a(2);
        }
        m60a().setItemsCanFocus(true);
        registerForContextMenu(m60a());
        if (3 == this.f15180M) {
            this.f15208y.setVisibility(8);
        } else if (4 == this.f15180M) {
            this.f15208y.setVisibility(0);
        }
        if (bundle != null) {
            this.f15179L = bundle.getLongArray("checkArray");
        }
        m16259d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16259d() {
        if (this.f15206w.getCount() <= 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("showEmptyList()", ThreadSelectionFragment.class.getSimpleName());
            }
            if (this.f15203t == null) {
                this.f15203t = this.f15201r.inflate();
            }
            if (this.f15198o == null) {
                this.f15198o = (ImageView) this.f15203t.findViewById(R.id.image1);
                this.f15198o.setImageResource(R.drawable.no_contents_chat);
            }
            if (this.f15199p == null) {
                this.f15199p = (TextView) this.f15203t.findViewById(R.id.text1);
                this.f15199p.setText(getResources().getString(R.string.no_chats));
            }
            if (this.f15200q == null) {
                this.f15200q = (TextView) this.f15203t.findViewById(R.id.text2);
                if (getActivity() instanceof ChatForwardActivity) {
                    this.f15200q.setVisibility(8);
                } else {
                    this.f15200q.setText(getResources().getString(R.string.chatlist_no_chat_2));
                }
            }
            this.f15203t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16260e() {
        if (this.f15203t != null) {
            this.f15203t.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f15176I = false;
        BaseActivity.m6160a((Fragment) this, true);
        m16262f();
        if (getActivity() instanceof ThreadSelectionActivity) {
            ((ThreadSelectionActivity) getActivity()).m16245h().mo18823a(getResources().getString(R.string.message_options));
        }
        getActivity().getContentResolver().registerContentObserver(C2299s.f8209a, true, this.f15196m);
        m16267h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m16262f() {
        if (getActivity() instanceof ThreadSelectionActivity) {
            if (this.f15190W) {
                this.f15168A.startQuery(1, null, C2299s.m10195h(), null, null, new String[]{Spam.ACTIVITY_CANCEL}, null);
                return;
            } else {
                this.f15168A.startQuery(1, null, C2299s.m10193f(), null, null, new String[]{Spam.ACTIVITY_CANCEL}, null);
                return;
            }
        }
        if (C4904y.f17875e) {
            C4904y.m18634a("ERROR!! " + f15167i + " is attached on wrong activity.", f15167i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f15176I = true;
        BaseActivity.m6160a((Fragment) this, false);
        getActivity().getContentResolver().unregisterContentObserver(this.f15196m);
    }

    /* renamed from: a */
    public void m16281a(String str) {
        this.f15168A.startQuery(2, str, Uri.withAppendedPath(C2287g.f8193a, "inbox/fullsearch").buildUpon().appendQueryParameter("pattern", str).build(), null, null, null, null);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
        }
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        Cursor cursorA;
        super.onDestroyView();
        if (this.f15207x != null && (cursorA = this.f15207x.mo871a()) != null && !cursorA.isClosed()) {
            cursorA.close();
            if (C4904y.f17872b) {
                C4904y.m18639b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
        this.f15206w.setAdapter((ListAdapter) null);
        if (this.f15191X != null) {
            this.f15191X.m11236a();
            this.f15191X = null;
        }
        if (this.f15181N != null) {
            this.f15181N.m19014a();
        }
    }

    /* renamed from: g */
    private void m16265g() {
        int i = 0;
        if (C4904y.f17872b) {
            C4904y.m18639b("closeMultipleChatRoom()", ThreadSelectionFragment.class.getSimpleName());
        }
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        SparseBooleanArray checkedItemPositions = this.f15206w.getCheckedItemPositions();
        while (true) {
            int i2 = i;
            if (i2 < checkedItemPositions.size()) {
                if (checkedItemPositions.valueAt(i2)) {
                    Cursor cursor = (Cursor) this.f15207x.getItem(checkedItemPositions.keyAt(i2));
                    String string = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
                    this.f15195l.add(string);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("addToSpamMultiple() number : [" + string + "]", getClass().getSimpleName());
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f15178K.setGroupVisible(R.id.msgbox_menu_group_delete, true);
        MenuItem menuItemFindItem = menu.findItem(R.id.msgbox_menu_delete_cancel);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(true);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.msgbox_menu_delete_confirm);
        if (menuItemFindItem2 != null) {
            if (this.f15206w.getCheckedItemIds().length > 0) {
                menuItemFindItem2.setEnabled(true);
            } else {
                menuItemFindItem2.setEnabled(false);
            }
        }
        this.f15175H.setItemChanged(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onOptionsItemSelected()", ThreadSelectionFragment.class.getSimpleName());
        }
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.msgbox_menu_delete_cancel /* 2131166653 */:
                if (getActivity() instanceof ThreadSelectionActivity) {
                    m16269i();
                    break;
                }
                break;
            case R.id.msgbox_menu_delete_confirm /* 2131166654 */:
                m16265g();
                Intent intent = new Intent();
                intent.putStringArrayListExtra("selected_numbers", this.f15195l);
                getActivity().setResult(-1, intent);
                getActivity().finish();
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f15178K = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        super.mo62a(listView, view, i, j);
        if (getActivity() instanceof ChatForwardActivity) {
            if (this.f15182O != null) {
                this.f15182O.m16510a(true);
                m16254b(listView);
                return;
            }
            return;
        }
        m16249a(listView);
    }

    /* renamed from: a */
    private void m16249a(ListView listView) {
        MenuItem menuItemFindItem;
        if (getActivity() instanceof ThreadSelectionActivity) {
            if (this.f15178K != null && (menuItemFindItem = this.f15178K.findItem(R.id.msgbox_menu_delete_confirm)) != null) {
                if (listView.getCheckedItemIds().length > 0) {
                    menuItemFindItem.setEnabled(true);
                } else {
                    menuItemFindItem.setEnabled(false);
                }
            }
            if (this.f15208y != null) {
                if (listView.getCheckedItemIds().length == listView.getCount()) {
                    this.f15208y.setChecked(true);
                    this.f15209z = true;
                } else {
                    this.f15209z = false;
                    this.f15208y.setChecked(false);
                }
            }
        }
    }

    /* renamed from: b */
    private void m16254b(ListView listView) {
        String string;
        if (getActivity() != null) {
            int size = 0;
            if (listView != null) {
                size = listView.getCheckedItemPositions().size();
            }
            if (this.f15194k > 0) {
                string = getString(this.f15194k);
            } else {
                string = getString(R.string.chatview_menu_forward);
            }
            ((ChatForwardActivity) getActivity()).setTitle(string + " (" + size + ")");
        }
    }

    /* renamed from: h */
    private void m16267h() {
        if (this.f15182O != null) {
            if (this.f15206w != null && this.f15206w.getCheckedItemPositions().size() > 0) {
                this.f15182O.m16510a(true);
            } else {
                this.f15182O.m16510a(false);
            }
        }
    }

    /* renamed from: i */
    private void m16269i() {
        if (getActivity() instanceof ThreadSelectionActivity) {
            ((ThreadSelectionActivity) getActivity()).m16246i();
        } else {
            if (getActivity() instanceof ChatForwardActivity) {
                ((ChatForwardActivity) getActivity()).m10256h();
                return;
            }
            if (C4904y.f17875e) {
                C4904y.m18634a("ERROR!! " + f15167i + " is attached on wrong activity.", f15167i);
            }
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m16270j() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                if (this.f15186S != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f15186S.getWindowToken(), 0);
                }
            } catch (Exception e) {
                C4904y.m18646e("[MSGBOX] mSearchFieldText.setOnFocusChangeListener() Exception :: " + e.toString(), getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m16272k() {
        if (getActivity() != null && !((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m16275l() {
        if (getActivity() != null && ((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18837f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16248a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }
}
