package com.sec.chaton.msgbox;

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
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import com.sec.widget.DropPanelMenu;
import com.sec.widget.FastScrollableListView;

/* loaded from: classes.dex */
public class MsgboxSelectionFragment extends ListFragment {

    /* renamed from: i */
    public static final String f9372i = MsgboxSelectionFragment.class.getSimpleName();

    /* renamed from: A */
    private int f9373A;

    /* renamed from: C */
    private String f9375C;

    /* renamed from: D */
    private String f9376D;

    /* renamed from: E */
    private String f9377E;

    /* renamed from: F */
    private String f9378F;

    /* renamed from: G */
    private DropPanelMenu f9379G;

    /* renamed from: I */
    private boolean f9381I;

    /* renamed from: K */
    private Menu f9383K;

    /* renamed from: L */
    private long[] f9384L;

    /* renamed from: N */
    private C5007c f9386N;

    /* renamed from: O */
    private InterfaceC2652bq f9387O;

    /* renamed from: Q */
    private LinearLayout f9389Q;

    /* renamed from: R */
    private View f9390R;

    /* renamed from: S */
    private ClearableEditText f9391S;

    /* renamed from: T */
    private View f9392T;

    /* renamed from: j */
    Bundle f9398j;

    /* renamed from: n */
    private ImageView f9402n;

    /* renamed from: o */
    private TextView f9403o;

    /* renamed from: p */
    private TextView f9404p;

    /* renamed from: q */
    private ViewStub f9405q;

    /* renamed from: r */
    private View f9406r;

    /* renamed from: s */
    private View f9407s;

    /* renamed from: t */
    private LinearLayout f9408t;

    /* renamed from: u */
    private LinearLayout f9409u;

    /* renamed from: v */
    private FastScrollableListView f9410v;

    /* renamed from: w */
    private C2608a f9411w;

    /* renamed from: x */
    private CheckedTextView f9412x;

    /* renamed from: y */
    private boolean f9413y;

    /* renamed from: z */
    private C2210x f9414z;

    /* renamed from: B */
    private int f9374B = -1;

    /* renamed from: H */
    private boolean f9380H = false;

    /* renamed from: J */
    private boolean f9382J = false;

    /* renamed from: M */
    private int f9385M = 1;

    /* renamed from: P */
    private EnumC1094bm f9388P = EnumC1094bm.INSIDE;

    /* renamed from: k */
    int f9399k = -1;

    /* renamed from: U */
    private boolean f9393U = false;

    /* renamed from: V */
    private boolean f9394V = false;

    /* renamed from: W */
    private int f9395W = 0;

    /* renamed from: l */
    ContentObserver f9400l = new C2649bn(this, new Handler());

    /* renamed from: m */
    InterfaceC2211y f9401m = new C2650bo(this);

    /* renamed from: X */
    private C2660e f9396X = null;

    /* renamed from: Y */
    private TextWatcher f9397Y = new C2651bp(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9398j = new Bundle();
        this.f9414z = new C2210x(getActivity().getContentResolver(), this.f9401m);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLongArray("checkArray", this.f9410v.getCheckedItemIds());
    }

    /* renamed from: f */
    private int m11115f() {
        return R.layout.list_item_common_6;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9386N = new C5007c();
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox, viewGroup, false);
        this.f9389Q = (LinearLayout) viewInflate.findViewById(R.id.msgSearchField);
        if (getActivity() instanceof ChatForwardActivity) {
            this.f9389Q.setVisibility(0);
            this.f9390R = viewInflate.findViewById(R.id.chatRoomSearchField);
            this.f9390R.setBackgroundColor(Color.parseColor("#fafafa"));
            this.f9391S = (ClearableEditText) this.f9390R.findViewById(R.id.text1);
            this.f9391S.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
            this.f9394V = false;
            this.f9391S.m18659a(this.f9397Y);
            this.f9391S.setHint(" " + getActivity().getResources().getString(R.string.chat_search_chat_title));
            this.f9391S.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2646bk(this));
        } else {
            this.f9389Q.setVisibility(8);
        }
        this.f9392T = viewInflate.findViewById(R.id.chatlist_no_search_result);
        this.f9405q = (ViewStub) viewInflate.findViewById(R.id.msg_no);
        this.f9406r = viewInflate.findViewById(R.id.msg_header);
        this.f9406r.setVisibility(8);
        this.f9408t = (LinearLayout) viewInflate.findViewById(R.id.linList);
        this.f9409u = (LinearLayout) viewInflate.findViewById(R.id.msg_loading);
        this.f9410v = (FastScrollableListView) viewInflate.findViewById(android.R.id.list);
        this.f9411w = new C2608a(getActivity(), m11115f(), null);
        this.f9410v.setAdapter((ListAdapter) this.f9411w);
        this.f9412x = (CheckedTextView) viewInflate.findViewById(R.id.chatlist_delete_select_all);
        this.f9412x.setOnClickListener(new ViewOnClickListenerC2647bl(this));
        this.f9410v.setOnItemClickListener(new C2648bm(this));
        this.f9379G = new DropPanelMenu(this);
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
        this.f9398j = arguments;
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f9373A = arguments.getInt("content_type");
            }
            if (arguments.containsKey("download_uri")) {
                this.f9375C = arguments.getString("download_uri");
            }
            if (arguments.containsKey("sub_content")) {
                this.f9376D = arguments.getString("sub_content");
            }
            if (arguments.containsKey("inboxNO")) {
                this.f9377E = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f9378F = arguments.getString("forward_sender_name");
            }
            if (arguments.containsKey("mode")) {
                this.f9385M = arguments.getInt("mode");
            }
            if (arguments.containsKey(C1071bk.f3371e)) {
                this.f9388P = (EnumC1094bm) arguments.get(C1071bk.f3371e);
            }
            if (arguments.containsKey("is_forward_mode")) {
                this.f9381I = arguments.getBoolean("is_forward_mode");
            }
            if (arguments.containsKey("ACTIVITY_PURPOSE_ARG2")) {
                this.f9399k = arguments.getInt("ACTIVITY_PURPOSE_ARG2");
            }
            if (arguments.containsKey("forward_chat_message")) {
                this.f9382J = arguments.getBoolean("forward_chat_message");
            }
        }
        m61a(this.f9411w);
        if (getActivity() instanceof ChatForwardActivity) {
            m60a().setChoiceMode(1);
            this.f9411w.m11156a(1);
            m11110b((ListView) null);
        } else {
            m60a().setChoiceMode(2);
            this.f9411w.m11156a(2);
        }
        m60a().setItemsCanFocus(true);
        registerForContextMenu(m60a());
        if (3 == this.f9385M) {
            this.f9412x.setVisibility(8);
        } else if (4 == this.f9385M) {
            this.f9412x.setVisibility(0);
        }
        if (bundle != null) {
            this.f9384L = bundle.getLongArray("checkArray");
        }
        m11118g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m11118g() {
        if (this.f9410v.getCount() <= 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("showEmptyList()", MsgboxSelectionFragment.class.getSimpleName());
            }
            if (this.f9407s == null) {
                this.f9407s = (LinearLayout) this.f9405q.inflate();
            }
            if (this.f9402n == null) {
                this.f9402n = (ImageView) this.f9407s.findViewById(R.id.image1);
                this.f9402n.setImageResource(R.drawable.no_contents_chat);
            }
            if (this.f9403o == null) {
                this.f9403o = (TextView) this.f9407s.findViewById(R.id.text1);
                this.f9403o.setText(getResources().getString(R.string.no_chats));
            }
            if (this.f9404p == null) {
                this.f9404p = (TextView) this.f9407s.findViewById(R.id.text2);
                if (getActivity() instanceof ChatForwardActivity) {
                    this.f9404p.setVisibility(8);
                } else {
                    this.f9404p.setText(getResources().getString(R.string.chatlist_no_chat_2));
                }
            }
            this.f9407s.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m11120h() {
        if (this.f9407s != null) {
            this.f9407s.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9380H = false;
        BaseActivity.m6160a((Fragment) this, true);
        m11122i();
        if (getActivity() instanceof MsgboxSelectionActivity) {
            ((MsgboxSelectionActivity) getActivity()).m11100h().mo18823a(getResources().getString(R.string.layout_chat_fragment_delete));
        }
        getActivity().getContentResolver().registerContentObserver(C2299s.f8209a, true, this.f9400l);
        m11130m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m11122i() {
        String str;
        if (getActivity() instanceof MsgboxSelectionActivity) {
            this.f9414z.startQuery(1, null, C2299s.m10188b(), null, null, null, null);
            return;
        }
        if (getActivity() instanceof ChatForwardActivity) {
            if (TextUtils.isEmpty(this.f9377E)) {
                str = "";
            } else {
                str = this.f9377E;
            }
            this.f9414z.startQuery(1, null, m11123j(), null, null, new String[]{str}, null);
            return;
        }
        if (C4904y.f17875e) {
            C4904y.m18634a("ERROR!! " + f9372i + " is attached on wrong activity.", f9372i);
        }
    }

    /* renamed from: j */
    private Uri m11123j() {
        if (C4822an.m18218a()) {
            if (this.f9373A == EnumC2214ab.CONTACT.m10076a()) {
                return C2299s.m10196i();
            }
            return C2299s.m10191d();
        }
        return C2299s.m10193f();
    }

    /* renamed from: k */
    private Uri m11125k() {
        if (C4822an.m18218a()) {
            if (this.f9373A == EnumC2214ab.CONTACT.m10076a()) {
                return C2299s.m10197j();
            }
            return C2299s.m10192e();
        }
        return C2299s.m10194g();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f9380H = true;
        getActivity().getContentResolver().unregisterContentObserver(this.f9400l);
    }

    /* renamed from: a */
    public void m11142a(String str) {
        String str2;
        Uri uriM11125k = m11125k();
        if (TextUtils.isEmpty(this.f9377E)) {
            str2 = "";
        } else {
            str2 = this.f9377E;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("%").append(str).append("%");
        this.f9414z.startQuery(2, str, uriM11125k, null, null, new String[]{str2, sb.toString()}, null);
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
        BaseActivity.m6160a((Fragment) this, false);
        if (this.f9411w != null && (cursorA = this.f9411w.mo871a()) != null && !cursorA.isClosed()) {
            cursorA.close();
            if (C4904y.f17872b) {
                C4904y.m18639b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
        this.f9410v.setAdapter((ListAdapter) null);
        if (this.f9396X != null) {
            this.f9396X.m11236a();
            this.f9396X = null;
        }
        if (this.f9386N != null) {
            this.f9386N.m19014a();
        }
    }

    /* renamed from: l */
    private void m11128l() {
        if (C4904y.f17872b) {
            C4904y.m18639b("closeMultipleChatRoom()", MsgboxSelectionFragment.class.getSimpleName());
        }
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
        } else {
            this.f9396X = new C2660e(getActivity(), 2);
            this.f9396X.m11238a(this.f9410v.getCheckedItemPositions(), m63b(), this.f9413y, this.f9410v.getCheckedItemIds().length);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f9383K.setGroupVisible(R.id.msgbox_menu_group_delete, true);
        MenuItem menuItemFindItem = menu.findItem(R.id.msgbox_menu_delete_cancel);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(true);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.msgbox_menu_delete_confirm);
        if (menuItemFindItem2 != null) {
            if (this.f9410v.getCheckedItemIds().length > 0) {
                menuItemFindItem2.setEnabled(true);
            } else {
                menuItemFindItem2.setEnabled(false);
            }
        }
        this.f9379G.setItemChanged(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onOptionsItemSelected()", MsgboxSelectionFragment.class.getSimpleName());
        }
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.msgbox_menu_delete_cancel /* 2131166653 */:
                if (getActivity() instanceof MsgboxSelectionActivity) {
                    m11132n();
                    break;
                }
                break;
            case R.id.msgbox_menu_delete_confirm /* 2131166654 */:
                m11128l();
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f9383K = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        super.mo62a(listView, view, i, j);
        if (getActivity() instanceof ChatForwardActivity) {
            if (this.f9387O != null) {
                this.f9387O.mo10259a(true);
                m11110b(listView);
                return;
            }
            return;
        }
        m11104a(listView);
    }

    /* renamed from: a */
    private void m11104a(ListView listView) {
        MenuItem menuItemFindItem;
        if (getActivity() instanceof MsgboxSelectionActivity) {
            if (this.f9383K != null && (menuItemFindItem = this.f9383K.findItem(R.id.msgbox_menu_delete_confirm)) != null) {
                if (listView.getCheckedItemIds().length > 0) {
                    menuItemFindItem.setEnabled(true);
                } else {
                    menuItemFindItem.setEnabled(false);
                }
            }
            if (this.f9412x != null) {
                if (listView.getCheckedItemIds().length == listView.getCount()) {
                    this.f9412x.setChecked(true);
                    this.f9413y = true;
                } else {
                    this.f9413y = false;
                    this.f9412x.setChecked(false);
                }
            }
        }
    }

    /* renamed from: b */
    private void m11110b(ListView listView) {
        String string;
        if (getActivity() != null) {
            int size = 0;
            if (listView != null) {
                size = listView.getCheckedItemPositions().size();
            }
            if (this.f9399k > 0) {
                string = getString(this.f9399k);
            } else {
                string = getString(R.string.chatview_menu_forward);
            }
            ((ChatForwardActivity) getActivity()).setTitle(string + " (" + size + ")");
        }
    }

    /* renamed from: c */
    public void m11143c() {
        if (this.f9410v != null) {
            this.f9410v.setItemChecked(this.f9410v.getCheckedItemPosition(), false);
        }
        m11130m();
        BaseActivity.m6160a((Fragment) this, true);
        m11110b((ListView) null);
    }

    /* renamed from: d */
    public void m11144d() {
        BaseActivity.m6160a((Fragment) this, false);
        m11110b((ListView) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m11130m() {
        if (this.f9387O != null) {
            if (this.f9410v != null && this.f9410v.getCheckedItemPositions().size() > 0) {
                this.f9387O.mo10259a(true);
            } else {
                this.f9387O.mo10259a(false);
            }
        }
    }

    /* renamed from: a */
    public void m11141a(InterfaceC2652bq interfaceC2652bq) {
        this.f9387O = interfaceC2652bq;
    }

    /* renamed from: e */
    public void m11145e() {
        if (getActivity() != null && this.f9410v != null) {
            int checkedItemPosition = this.f9410v.getCheckedItemPosition();
            if (C4904y.f17872b) {
                C4904y.m18639b("doFarwardAction updated checkedItemPosition[" + checkedItemPosition + "]", getClass().getSimpleName());
            }
            if (checkedItemPosition != -1) {
                Cursor cursor = (Cursor) m63b().getItem(checkedItemPosition);
                Bundle bundle = new Bundle();
                if (getActivity() instanceof ChatForwardActivity) {
                    bundle.putBoolean("isForwardSelected", true);
                    bundle.putInt("content_type", this.f9373A);
                    bundle.putString("download_uri", this.f9375C);
                    bundle.putString("sub_content", this.f9376D);
                    bundle.putString("forward_sender_name", this.f9378F);
                    bundle.putBoolean("is_forward_mode", this.f9381I);
                    bundle.putBoolean("forward_chat_message", this.f9382J);
                }
                ((InterfaceC2653br) getActivity()).mo10255a(cursor, bundle, this.f9388P);
            }
        }
    }

    /* renamed from: n */
    private void m11132n() {
        if (getActivity() instanceof MsgboxSelectionActivity) {
            ((MsgboxSelectionActivity) getActivity()).m11101i();
        } else {
            if (getActivity() instanceof ChatForwardActivity) {
                ((ChatForwardActivity) getActivity()).m10256h();
                return;
            }
            if (C4904y.f17875e) {
                C4904y.m18634a("ERROR!! " + f9372i + " is attached on wrong activity.", f9372i);
            }
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m11133o() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                if (this.f9391S != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f9391S.getWindowToken(), 0);
                }
            } catch (Exception e) {
                C4904y.m18646e("[MSGBOX] mSearchFieldText.setOnFocusChangeListener() Exception :: " + e.toString(), getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m11135p() {
        if (getActivity() != null && !((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m11138q() {
        if (getActivity() != null && ((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18837f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11103a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }
}
