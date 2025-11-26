package com.sec.chaton.msgbox;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.C2310s;
import com.sec.chaton.InterfaceC0813bw;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.EmptyFragment;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1090fe;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatInfoActivity;
import com.sec.chaton.chat.EmptyChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1414e;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.provider.p049a.C2037a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ImageTextViewGroup;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3348j;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import com.sec.widget.FastScrollableListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class MsgboxFragment extends ListFragment implements InterfaceC0047c, InterfaceC0813bw, InterfaceC1714ar {

    /* renamed from: a */
    public static final String f6228a = MsgboxFragment.class.getSimpleName();

    /* renamed from: b */
    public static String f6229b = "extra_search_title";

    /* renamed from: c */
    public static String f6230c = "extra_search_cursor";

    /* renamed from: d */
    public static String f6231d = "chiness_chat_title";

    /* renamed from: A */
    private C1337o f6232A;

    /* renamed from: B */
    private ProgressDialog f6233B;

    /* renamed from: D */
    private View f6235D;

    /* renamed from: E */
    private ImageTextViewGroup f6236E;

    /* renamed from: I */
    private C3326c f6240I;

    /* renamed from: J */
    private C3205bt f6241J;

    /* renamed from: K */
    private C1090fe f6242K;

    /* renamed from: N */
    private View f6245N;

    /* renamed from: O */
    private ClearableEditText f6246O;

    /* renamed from: R */
    private ArrayList<Object[]> f6249R;

    /* renamed from: S */
    private Cursor f6250S;

    /* renamed from: T */
    private ImageButton f6251T;

    /* renamed from: U */
    private ImageButton f6252U;

    /* renamed from: V */
    private View f6253V;

    /* renamed from: W */
    private View f6254W;

    /* renamed from: X */
    private RelativeLayout f6255X;

    /* renamed from: aa */
    private int f6258aa;

    /* renamed from: ab */
    private int f6259ab;

    /* renamed from: ac */
    private int f6260ac;

    /* renamed from: ad */
    private int f6261ad;

    /* renamed from: h */
    private FastScrollableListView f6268h;

    /* renamed from: i */
    private LinearLayout f6269i;

    /* renamed from: j */
    private LinearLayout f6270j;

    /* renamed from: k */
    private ImageView f6271k;

    /* renamed from: l */
    private TextView f6272l;

    /* renamed from: m */
    private TextView f6273m;

    /* renamed from: n */
    private C1696a f6274n;

    /* renamed from: p */
    private C1377u f6276p;

    /* renamed from: q */
    private ArrayList<String> f6277q;

    /* renamed from: r */
    private String f6278r;

    /* renamed from: s */
    private String f6279s;

    /* renamed from: t */
    private long f6280t;

    /* renamed from: u */
    private EnumC1450r f6281u;

    /* renamed from: v */
    private String f6282v;

    /* renamed from: w */
    private int f6283w;

    /* renamed from: x */
    private int f6284x;

    /* renamed from: o */
    private boolean f6275o = false;

    /* renamed from: y */
    private boolean f6285y = false;

    /* renamed from: z */
    private String f6286z = "";

    /* renamed from: C */
    private InterfaceC3274d f6234C = null;

    /* renamed from: F */
    private boolean f6237F = false;

    /* renamed from: G */
    private boolean f6238G = false;

    /* renamed from: H */
    private int f6239H = 1;

    /* renamed from: L */
    private boolean f6243L = false;

    /* renamed from: M */
    private boolean f6244M = false;

    /* renamed from: P */
    private boolean f6247P = false;

    /* renamed from: Q */
    private boolean f6248Q = false;

    /* renamed from: Y */
    private final String f6256Y = "";

    /* renamed from: Z */
    private LinearLayout.LayoutParams f6257Z = null;

    /* renamed from: e */
    ContentObserver f6265e = new C1723j(this, new Handler());

    /* renamed from: f */
    InterfaceC1378v f6266f = new C1724k(this);

    /* renamed from: ae */
    private Handler f6262ae = new HandlerC1725l(this);

    /* renamed from: g */
    public Handler f6267g = new HandlerC1732s(this);

    /* renamed from: af */
    private TextWatcher f6263af = new C1734u(this);

    /* renamed from: ag */
    private SlookAirButton.ItemSelectListener f6264ag = new C1736w(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6277q = new ArrayList<>();
        this.f6249R = new ArrayList<>();
        this.f6276p = new C1377u(getActivity().getContentResolver(), this.f6266f);
        if (GlobalApplication.m6456e()) {
            this.f6258aa = C3172an.m11087c(getResources().getDimension(R.dimen.search_divider_right_margin));
            this.f6259ab = C3172an.m11087c(getResources().getDimension(R.dimen.search_divider_right_margin_up));
            this.f6260ac = C3172an.m11087c(getResources().getDimension(R.dimen.search_divider_height));
            this.f6261ad = C3172an.m11087c(getResources().getDimension(R.dimen.search_divider_top_margin));
            this.f6257Z = new LinearLayout.LayoutParams(-2, this.f6260ac);
        }
    }

    /* renamed from: g */
    private int m7037g() {
        return R.layout.list_item_common_6;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6240I = new C3326c();
        this.f6241J = C3205bt.m11182a(getActivity().getApplicationContext());
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox, viewGroup, false);
        this.f6245N = viewInflate.findViewById(R.id.chatRoomSearchField);
        this.f6245N.setBackgroundColor(Color.parseColor("#fafafa"));
        this.f6246O = (ClearableEditText) this.f6245N.findViewById(R.id.text1);
        this.f6248Q = false;
        this.f6246O.m11464a(this.f6263af);
        this.f6246O.setHint(getResources().getString(R.string.chat_search_chat_title));
        this.f6246O.setOnKeyListener(new ViewOnKeyListenerC1718e(this));
        this.f6246O.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1729p(this));
        this.f6251T = (ImageButton) this.f6245N.findViewById(R.id.button1);
        this.f6251T.setImageResource(R.drawable.input_ic_call_log);
        this.f6251T.setContentDescription(getResources().getString(R.string.more_call_log));
        if (C3214cb.m11256a(CommonApplication.m11493l())) {
            this.f6251T.setVisibility(0);
            this.f6251T.setOnClickListener(new ViewOnClickListenerC1737x(this));
        } else {
            this.f6251T.setVisibility(8);
        }
        this.f6252U = (ImageButton) this.f6245N.findViewById(R.id.button2);
        this.f6252U.setContentDescription(getResources().getString(R.string.layout_chat_fragment_delete));
        this.f6252U.setVisibility(0);
        this.f6252U.setEnabled(false);
        this.f6252U.setImageResource(R.drawable.input_ic_delete_disable);
        this.f6252U.setOnClickListener(new ViewOnClickListenerC1738y(this));
        this.f6269i = (LinearLayout) viewInflate.findViewById(R.id.msg_no);
        this.f6271k = (ImageView) this.f6269i.findViewById(R.id.image1);
        this.f6271k.setImageResource(R.drawable.no_contents_chat);
        this.f6272l = (TextView) this.f6269i.findViewById(R.id.text1);
        this.f6272l.setText(getResources().getString(R.string.no_chats));
        this.f6273m = (TextView) this.f6269i.findViewById(R.id.text2);
        this.f6273m.setText(getResources().getString(R.string.chatlist_no_chat_2));
        this.f6269i.setVisibility(8);
        this.f6270j = (LinearLayout) viewInflate.findViewById(R.id.msg_loading);
        this.f6268h = (FastScrollableListView) viewInflate.findViewById(android.R.id.list);
        this.f6268h.setOnScrollListener(new C1739z(this));
        this.f6235D = viewInflate.findViewById(R.id.first_chatlist_sync);
        this.f6235D.setFocusable(false);
        this.f6235D.setEnabled(false);
        this.f6235D.setClickable(false);
        this.f6236E = (ImageTextViewGroup) this.f6235D.findViewById(R.id.button4);
        this.f6236E.setText(R.string.load_chat_list_history_button);
        this.f6236E.setImageResource(R.drawable.sync_ic_sync);
        this.f6236E.setGravity(19);
        this.f6236E.setContentDescription(getString(R.string.load_chat_list_history_button));
        if (this.f6236E != null) {
            this.f6236E.setFocusable(true);
            this.f6236E.setOnClickListener(new ViewOnClickListenerC1697aa(this));
        }
        this.f6274n = new C1696a(getActivity(), this.f6268h, m7037g(), null, this.f6240I, this.f6264ag);
        this.f6274n.m7124a(this);
        this.f6274n.m7129b("");
        this.f6243L = true;
        getActivity().getContentResolver().registerContentObserver(C1449q.f5381a, true, this.f6265e);
        this.f6244M = true;
        if (GlobalApplication.m6456e()) {
            viewInflate.findViewById(R.id.search_divider);
            m7069a(1);
            this.f6253V = viewInflate.findViewById(R.id.child_buddy_footer_gradient);
            this.f6254W = viewInflate.findViewById(R.id.splitView_buddy_footer_indicator);
            this.f6255X = (RelativeLayout) viewInflate.findViewById(R.id.sync_panel_bottom);
            this.f6253V.setVisibility(this.f6235D.getVisibility());
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7011a(boolean z) {
        long jM10976a;
        long jCurrentTimeMillis;
        if (z) {
            jCurrentTimeMillis = System.currentTimeMillis();
            C3159aa.m10962a().m10982a("do_not_show_max_chat_list_check_day", Long.valueOf(jCurrentTimeMillis));
            jM10976a = jCurrentTimeMillis;
        } else {
            jM10976a = C3159aa.m10962a().m10976a("do_not_show_max_chat_list_check_day", 0L);
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this.f6238G = false;
        if (jM10976a != 0 && jCurrentTimeMillis - jM10976a <= 2592000000L) {
            this.f6238G = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f6285y = true;
            }
            if (arguments.containsKey("download_uri")) {
            }
            if (arguments.containsKey("sub_content")) {
            }
            if (arguments.containsKey("forward_sender_name")) {
            }
            if (arguments.containsKey("inboxNO")) {
            }
            if (arguments.containsKey(RtspHeaders.Values.MODE)) {
                this.f6239H = arguments.getInt(RtspHeaders.Values.MODE);
            }
            if (arguments.containsKey(C2310s.f8621e)) {
            }
            if (arguments.containsKey("is_forward_mode")) {
            }
            BaseActivity.m3081a(this, true);
        }
        setListAdapter(this.f6274n);
        getListView().setChoiceMode(0);
        this.f6274n.m7123a(0);
        getListView().setItemsCanFocus(false);
        registerForContextMenu(getListView());
        if (this.f6239H == 3) {
            getListView().setChoiceMode(1);
            this.f6274n.m7123a(1);
        } else if (this.f6239H == 4) {
            getListView().setChoiceMode(2);
            this.f6274n.m7123a(2);
        }
        this.f6233B = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.buddy_adaptor_wait_progress);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x012e  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.MsgboxFragment.onResume():void");
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11456e("[MSGBOX] onPause()", getClass().getSimpleName());
        this.f6237F = true;
        m7043j();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m7040h();
        C3250y.m11456e("[MSGBOX] onStart()", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        C3250y.m11456e("[MSGBOX] onStop()", getClass().getSimpleName());
        super.onStop();
    }

    /* renamed from: a */
    public void m7068a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_is_new", "N");
        this.f6276p.startUpdate(1, null, C1449q.f5381a, contentValues, null, null);
    }

    @Override // android.support.v4.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        switch (this.f6239H) {
            case 1:
                Cursor cursor = (Cursor) getListAdapter().getItem(i);
                if (this.f6275o) {
                    m7068a();
                }
                if (this.f6246O != null) {
                    this.f6246O.setText("");
                }
                m7043j();
                ((InterfaceC1701ae) getActivity()).mo1314a(cursor, this.f6285y);
                break;
            case 2:
                Cursor cursor2 = (Cursor) getListAdapter().getItem(i);
                try {
                    m7020b(cursor2.getString(cursor2.getColumnIndex("inbox_no")), cursor2.getString(cursor2.getColumnIndex("inbox_session_id")), EnumC1450r.m6339a(cursor2.getInt(cursor2.getColumnIndex("inbox_chat_type"))), cursor2.getString(cursor2.getColumnIndex("inbox_server_ip")), cursor2.getInt(cursor2.getColumnIndex("inbox_server_port")));
                    break;
                } catch (Exception e) {
                    C3250y.m11442a(e.toString(), f6228a);
                    return;
                }
        }
    }

    /* renamed from: a */
    private Bitmap m6998a(File file) {
        return C3348j.m11791a(CommonApplication.m11493l(), file, (int) C3172an.m11085a(55.0f), (int) C3172an.m11085a(55.0f));
    }

    /* renamed from: a */
    private ProfileImageView m6999a(boolean z, String str, String str2, EnumC1450r enumC1450r, String str3, String str4, String str5, String str6) {
        ProfileImageView profileImageView = new ProfileImageView(getActivity());
        profileImageView.m11473a(profileImageView, enumC1450r);
        if (enumC1450r == EnumC1450r.ONETOONE) {
            if (z) {
                C3205bt.m11182a(getActivity()).m11210a(profileImageView, str2);
                profileImageView.setBuddyNo(str2);
            }
        } else {
            File absoluteFile = CommonApplication.m11493l().getFilesDir().getAbsoluteFile();
            if (EnumC1450r.m6340a(enumC1450r)) {
                File file = new File(absoluteFile, str3 + "_chat_profile.png_");
                if (file != null && file.exists()) {
                    profileImageView.setImageBitmap(m6998a(file));
                }
            } else {
                String str7 = "";
                if (!TextUtils.isEmpty(str6)) {
                    str7 = str6.split("&filename=")[r0.length - 1];
                }
                File file2 = new File(absoluteFile, str3 + "_chat_profile.png_." + str7);
                if (file2 != null && file2.exists()) {
                    profileImageView.setImageBitmap(m6998a(file2));
                } else if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                    File file3 = new File(absoluteFile, C1362f.m6073e(GlobalApplication.m6447a().getContentResolver(), str5) + "_group_profile.png_");
                    if (file3.exists()) {
                        profileImageView.setImageBitmap(m6998a(file3));
                    }
                }
            }
        }
        return profileImageView;
    }

    /* renamed from: c */
    private String m7021c(String str, EnumC1450r enumC1450r, String str2, String str3, int i) throws Resources.NotFoundException {
        if (enumC1450r == EnumC1450r.ONETOONE) {
            if (str3.equals("Y") || str == null) {
            }
        } else if (EnumC1450r.m6340a(enumC1450r)) {
            C1075eq.m5319a(str3, str2);
        } else if (i == 0) {
            getResources().getString(R.string.chat_title_no_buddies);
        }
        return str2;
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        boolean zStartsWith;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (this.f6239H != 2) {
            ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(getActivity(), contextMenu);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            if (adapterContextMenuInfo != null) {
                Cursor cursor = (Cursor) getListAdapter().getItem(adapterContextMenuInfo.position);
                this.f6278r = cursor.getString(cursor.getColumnIndex("inbox_no"));
                String string = cursor.getString(cursor.getColumnIndex("inbox_title"));
                this.f6279s = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                this.f6280t = cursor.getLong(cursor.getColumnIndex("lasst_session_merge_time"));
                this.f6281u = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
                this.f6282v = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                this.f6283w = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                this.f6284x = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
                String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                String string3 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
                String string4 = cursor.getString(cursor.getColumnIndex("profile_url"));
                String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                boolean zEquals2 = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                String string6 = cursor.getString(cursor.getColumnIndex("relation_buddy_no"));
                C1337o.m5795a(this.f6278r, this.f6281u).m5894c(this.f6279s);
                C1337o.m5795a(this.f6278r, this.f6281u).m5867a(this.f6280t);
                C3250y.m11454d("serverIP:" + this.f6282v);
                C3250y.m11454d("serverPort:" + this.f6283w);
                if (!TextUtils.isEmpty(string)) {
                    contextMenuC0453a.setHeaderTitle(string);
                } else {
                    if (zEquals && this.f6281u == EnumC1450r.GROUPCHAT) {
                        contextMenuC0453a.setHeaderTitle(R.string.chat_title_no_buddies);
                    }
                    if (zEquals && this.f6281u == EnumC1450r.ONETOONE) {
                        contextMenuC0453a.setHeaderTitle(R.string.unknown);
                    }
                    if (zEquals && EnumC1450r.m6340a(this.f6281u)) {
                        contextMenuC0453a.setHeaderTitle(R.string.chat_title_no_buddies);
                    }
                }
                if (TextUtils.isEmpty(string5)) {
                    zStartsWith = false;
                } else {
                    zStartsWith = string5.startsWith("0999");
                }
                if (zEquals) {
                    if (!zStartsWith) {
                        contextMenuC0453a.add(R.string.chat_view_menu_info2).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1700ad(this, string5, zEquals2, string, string3, string6));
                    }
                    if (!EnumC1450r.m6340a(this.f6281u)) {
                        if (zEquals2) {
                            contextMenuC0453a.add(R.string.chaton_live_buddy_alert_off).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1719f(this, zEquals2));
                        } else {
                            contextMenuC0453a.add(R.string.chaton_live_buddy_alert_on).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1720g(this, zEquals2));
                        }
                    }
                    contextMenuC0453a.add(R.string.buddy_list_add_to_home_screen).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1721h(this, zEquals, string2, string5, string, string3, string6, string4));
                }
                contextMenuC0453a.add(R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1722i(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7001a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        String string3 = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
        EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
        String string4 = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
        String string7 = cursor.getString(cursor.getColumnIndex("relation_buddy_no"));
        C1337o.m5795a(string, enumC1450rM6339a).m5894c(string3);
        m7010a(string6, zEquals, string, string2, enumC1450rM6339a, string3, string4, i, string5, string7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7010a(String str, boolean z, String str2, String str3, EnumC1450r enumC1450r, String str4, String str5, int i, String str6, String str7) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1457y.m6367a(str2), new String[]{"participants_buddy_no"}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("participants_buddy_no")));
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (TextUtils.isEmpty(str7) || str7.equals(str)) {
            str7 = null;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) ChatInfoActivity.class);
        intent.putExtra("ACTIVITY_PURPOSE", 6);
        intent.putExtra(ChatFragment.f3493j, true);
        intent.putExtra(ChatFragment.f3490g, str3);
        intent.putExtra("inboxNO", str2);
        intent.putExtra("chatType", enumC1450r.m6342a());
        intent.putExtra("buddyNO", str);
        intent.putExtra("inboxValid", true);
        intent.putExtra(ChatFragment.f3489f, (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra(ChatFragment.f3497n, z);
        intent.putExtra("sessionID", str4);
        intent.putExtra("inbox_server_ip", str5);
        intent.putExtra("inbox_server_port", i);
        intent.putExtra("ACTIVITY_PURPOSE_ARG", true);
        intent.putExtra("inbox_title_fixed", str6);
        if (!TextUtils.isEmpty(str7)) {
            intent.putExtra("groupId", str7);
        }
        startActivityForResult(intent, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7017b(Cursor cursor) {
        m7012a("Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti"))), cursor.getString(cursor.getColumnIndex("inbox_no")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7012a(boolean z, String str) {
        if (z) {
            C1370n.m6109a(CommonApplication.m11493l().getContentResolver(), str, false);
        } else {
            C1370n.m6109a(CommonApplication.m11493l().getContentResolver(), str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7022c(Cursor cursor) throws Resources.NotFoundException {
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        m7013a("Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid"))), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_no")), string, enumC1450rM6339a, string2, i, cursor.getString(cursor.getColumnIndex("inbox_title_fixed")), cursor.getString(cursor.getColumnIndex("relation_buddy_no")), cursor.getString(cursor.getColumnIndex("profile_url")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7013a(boolean r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, com.sec.chaton.p027e.EnumC1450r r16, java.lang.String r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.MsgboxFragment.m7013a(boolean, java.lang.String, java.lang.String, java.lang.String, com.sec.chaton.e.r, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7027d(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
        EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
        String string3 = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
        C1337o.m5795a(string, enumC1450rM6339a).m5894c(string2);
        m7009a(string, string2, enumC1450rM6339a, string3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7009a(String str, String str2, EnumC1450r enumC1450r, String str3, int i) {
        try {
            this.f6246O.setText("");
            m7043j();
            m7020b(str, str2, enumC1450r, str3, i);
        } catch (Exception e) {
            C3250y.m11442a(e.toString(), f6228a);
        }
    }

    /* renamed from: b */
    private void m7020b(String str, String str2, EnumC1450r enumC1450r, String str3, int i) {
        this.f6276p.startQuery(2, null, C1457y.m6367a(str), new String[]{"participants_buddy_no"}, null, null, null);
        if (!C3347i.m11788k()) {
            C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        if (this.f6239H == 2 ? C3159aa.m10962a().m10977a("msgbox_close_popup_show", (Boolean) true).booleanValue() : true) {
            m7071a(str, enumC1450r, str2, str3, i);
        } else {
            m7072b(str, enumC1450r, str2, str3, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7040h() {
        if (C3171am.m11080r()) {
            if (this.f6235D == null) {
                C3250y.m11450b("setDisplayFirstSyncButton() mChatListSync is null. ERROR.", getClass().getSimpleName());
                return;
            }
            long jM10976a = C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_time", 0L);
            if (jM10976a != 0) {
                this.f6235D.setVisibility(8);
                this.f6236E.setVisibility(8);
                ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
            } else {
                this.f6235D.setVisibility(0);
                this.f6236E.setVisibility(0);
            }
            if (GlobalApplication.m6456e() && this.f6253V != null) {
                this.f6255X.setVisibility(this.f6235D.getVisibility());
                this.f6253V.setVisibility(this.f6235D.getVisibility());
                this.f6254W.setVisibility(8);
            }
            C3250y.m11450b("setDisplayFirstSyncButton() lastChatListSyncCallTime[" + jM10976a + "]", getClass().getSimpleName());
        }
    }

    /* renamed from: i */
    private void m7042i() {
        File[] fileArrListFiles = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().listFiles(new C1726m(this));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                C3250y.m11450b("[Delete File] " + file + " : " + file.delete(), f6228a);
            }
        }
        C3243r.m11419a(C3223ck.m11328b() + "/" + this.f6278r);
        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.trunk_toast_deleted, 0).show();
    }

    /* renamed from: a */
    public void m7071a(String str, EnumC1450r enumC1450r, String str2, String str3, int i) {
        if (!C3159aa.m10962a().m10977a("msgbox_close_popup_show", (Boolean) true).booleanValue()) {
            m7072b(str, enumC1450r, str2, str3, i);
            return;
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
        abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
        View viewInflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_msgbox_close_popup, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.isShowPopup);
        if (this.f6239H == 2 && checkBox != null) {
            checkBox.setVisibility(0);
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.popupContent);
        if (EnumC1450r.m6340a(enumC1450r)) {
            textView.setText(R.string.chat_deleted_popup);
        } else {
            textView.setText(R.string.dialog_title_msgbox_delete);
        }
        abstractC3271aM11494a.mo11502a(true);
        abstractC3271aM11494a.mo11508b(viewInflate);
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1728o(this, checkBox, str, enumC1450r, str2, str3, i)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1727n(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* renamed from: b */
    public final void m7072b(String str, EnumC1450r enumC1450r, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str2) && enumC1450r != EnumC1450r.BROADCAST) {
            this.f6232A = C1337o.m5795a(str, enumC1450r);
            this.f6232A.m5874a(this.f6262ae);
            this.f6232A.m5880a(str, str3, i);
            this.f6232A.m5893c(Long.MAX_VALUE);
            if (!this.f6233B.isShowing()) {
                this.f6233B.show();
            }
            this.f6232A.m5838a(enumC1450r, str2, str);
            this.f6232A.m5887b(true);
            return;
        }
        this.f6276p.startDelete(1, null, C1449q.f5381a, "inbox_no IN ('" + str + "')", null);
        this.f6276p.startDelete(2, null, C1454v.f5393a, "message_inbox_no='" + str + "'", null);
        C1555a.m6596a().m6600a(str);
        C1561g.m6628a().m6635a(str);
        m7042i();
        if (GlobalApplication.m6456e()) {
            m7070a("");
            ((TabActivity) getActivity()).m1312a(R.id.child, new Intent(), EmptyChatFragment.class);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7069a(1);
        if (getActivity().findViewById(R.id.fragment_container) != null) {
            new Timer(true).schedule(new C1730q(this, new Handler()), 200L);
        } else {
            setListAdapter(this.f6274n);
        }
        if (getResources().getConfiguration().orientation == 1) {
            m7056p();
        } else if (getResources().getConfiguration().orientation == 2 && this.f6246O != null && this.f6246O.m11463a().toString().length() > 0) {
            m7058q();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("inboxNO");
                    String stringExtra2 = intent.getStringExtra("buddyNO");
                    int intExtra = intent.getIntExtra("chatType", 0);
                    EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(intExtra);
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    String stringExtra3 = intent.getStringExtra("inbox_session_id");
                    String stringExtra4 = intent.getStringExtra("inbox_server_ip");
                    int intExtra2 = intent.getIntExtra("inbox_server_port", 0);
                    if (intent.hasExtra("isClosing")) {
                        m7072b(stringExtra, enumC1450rM6339a, stringExtra3, stringExtra4, intExtra2);
                        break;
                    } else {
                        if (this.f6275o) {
                            m7068a();
                        }
                        if (stringArrayExtra != null) {
                            ArrayList arrayList = new ArrayList();
                            for (String str : stringArrayExtra) {
                                arrayList.add(str);
                            }
                            Intent intentM1226a = TabActivity.m1226a(CommonApplication.m11493l());
                            intentM1226a.putExtra("callChatList", true);
                            if (intExtra == EnumC1450r.ONETOONE.m6342a()) {
                                intentM1226a.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                                intentM1226a.putExtra(ChatFragment.f3494k, true);
                                arrayList.add(stringExtra2);
                            } else {
                                intentM1226a.putExtra("inboxNO", stringExtra);
                                intentM1226a.putExtra("chatType", intExtra);
                                intentM1226a.putExtra(ChatFragment.f3496m, true);
                            }
                            intentM1226a.putExtra("inboxValid", true);
                            intentM1226a.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                            startActivity(intentM1226a);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m7070a(String str) {
        this.f6286z = str;
        this.f6274n.m7127a(str);
        this.f6268h.invalidateViews();
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getContentResolver().unregisterContentObserver(this.f6265e);
        this.f6246O.setText("");
        this.f6246O.m11467b(this.f6263af);
        this.f6274n.m7122a();
        this.f6268h.setAdapter((ListAdapter) null);
        Cursor cursor = this.f6274n.getCursor();
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
            if (C3250y.f11734b) {
                C3250y.m11450b("The Cursor of Adapter was cosed", getClass().getSimpleName());
            }
        }
        if (this.f6233B != null && this.f6233B.isShowing()) {
            this.f6233B.dismiss();
        }
        if (this.f6234C != null && this.f6234C.isShowing()) {
            this.f6234C.dismiss();
        }
        if (this.f6240I != null) {
            this.f6240I.m11731a();
        }
        if (this.f6249R != null && this.f6249R.size() > 0) {
            C3250y.m11450b("[ChatTitleSearch] resetSearchCursor", getClass().getSimpleName());
            this.f6249R.clear();
            this.f6249R = null;
        }
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: b */
    public void mo1189b() {
        C3250y.m11456e("[MSGBOX] onTabSelected()", getClass().getSimpleName());
        long jM10976a = C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_call_time", 0L);
        if (jM10976a != 0) {
            m7000a(jM10976a);
        }
        BaseActivity.m3081a(this, true);
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent();
            intent.putExtra(EmptyFragment.f2243c, EmptyFragment.f2242b);
            ((TabActivity) getActivity()).m1312a(R.id.fragment_msg_box, intent, EmptyFragment.class);
        }
        if (GlobalApplication.m6456e() && this.f6274n != null) {
            this.f6274n.m7127a("");
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00050001");
        }
    }

    /* renamed from: a */
    private void m7000a(long j) {
        boolean z = System.currentTimeMillis() - j > 600000;
        if (this.f6244M) {
            this.f6243L = true;
            m7048l();
        }
        m7014a(z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7014a(boolean z, boolean z2) {
        C3250y.m11450b("SyncChatList()", getClass().getSimpleName());
        if (!C3171am.m11080r()) {
            C3250y.m11456e("[MSGBOX] [Before mapping] Don't need to sync ChatListInfo", f6228a);
            return;
        }
        if (z) {
            C2037a.m8126c();
            C3250y.m11456e("[MSGBOX] Need to sync ChatListInfo", f6228a);
            C3159aa.m10962a().m10982a("multidevice_chatlist_sync_last_call_time", Long.valueOf(System.currentTimeMillis()));
            this.f6242K = new C1090fe(this.f6267g, C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_time", 0L));
            this.f6242K.m5375a();
            if (z2 && !this.f6233B.isShowing()) {
                this.f6233B.show();
                return;
            }
            return;
        }
        C3250y.m11456e("[MSGBOX] [After mapping] Don't need to sync ChatListInfo", f6228a);
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: c */
    public void mo1190c() {
        C3250y.m11456e("[MSGBOX] onTabUnSelected()", getClass().getSimpleName());
        if (this.f6246O != null) {
            this.f6246O.setText("");
        }
        m7043j();
        BaseActivity.m3081a(this, false);
        if (this.f6275o) {
            m7068a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7043j() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                if (this.f6246O != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f6246O.getWindowToken(), 0);
                }
            } catch (Exception e) {
                C3250y.m11456e("[MSGBOX] mSearchFieldText.setOnFocusChangeListener() Exception :: " + e.toString(), getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7045k() {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
        abstractC3271aM11494a.mo11495a(R.string.load_chat_list_history_button);
        abstractC3271aM11494a.mo11506b(R.string.chat_no_history_found_popup_text);
        abstractC3271aM11494a.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1733t(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m7048l() {
        if (this.f6243L) {
            this.f6243L = false;
            C3250y.m11456e("[MSGBOX] updateMsgbox()", getClass().getSimpleName());
            this.f6276p.startQuery(1, null, C1449q.m6331b(), null, null, null, null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (!C3171am.m11080r()) {
            menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, false);
        } else if (C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_time", 0L) != 0) {
            menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, true);
        } else {
            menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.msgbox_menu_sync /* 2131166566 */:
                C3250y.m11450b("onOptionsItemSelected():msgbox_menu_sync", getClass().getSimpleName());
                m7014a(true, true);
                return true;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.activity_msgbox_menu, menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7031e(Cursor cursor) {
        Message messageM6267c = C1414e.m6265a().m6267c();
        messageM6267c.obj = cursor;
        C1414e.m6265a().m6266b().sendMessage(messageM6267c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7035f(Cursor cursor) {
        C3250y.m11456e("makeBackUpCursor() Start", "[SEARCH]");
        if (this.f6252U != null && this.f6252U.isEnabled() && cursor != null && cursor.getCount() > 0) {
            this.f6249R.clear();
            int columnIndex = cursor.getColumnIndex("inbox_title");
            int columnIndex2 = cursor.getColumnIndex("inbox_no");
            int columnIndex3 = cursor.getColumnIndex("buddy_no");
            int columnIndex4 = cursor.getColumnIndex("inbox_chat_type");
            int columnIndex5 = cursor.getColumnIndex("inbox_valid");
            int columnIndex6 = cursor.getColumnIndex("relation_buddy_no");
            int columnIndex7 = cursor.getColumnIndex("buddy_show_phone_number");
            int columnIndex8 = cursor.getColumnIndex("buddy_extra_info");
            int columnIndex9 = cursor.getColumnIndex("buddy_msisdns");
            int columnIndex10 = cursor.getColumnIndex("is_buddy");
            int columnIndex11 = cursor.getColumnIndex("inbox_last_chat_type");
            int columnIndex12 = cursor.getColumnIndex("inbox_session_id");
            int columnIndex13 = cursor.getColumnIndex("inbox_last_msg_no");
            int columnIndex14 = cursor.getColumnIndex("_id");
            int columnIndex15 = cursor.getColumnIndex("inbox_server_ip");
            int columnIndex16 = cursor.getColumnIndex("inbox_server_port");
            int columnIndex17 = cursor.getColumnIndex("inbox_title_fixed");
            int columnIndex18 = cursor.getColumnIndex("inbox_last_msg_sender");
            int columnIndex19 = cursor.getColumnIndex("inbox_last_temp_msg");
            int columnIndex20 = cursor.getColumnIndex("buddy_name");
            int columnIndex21 = cursor.getColumnIndex("inbox_trunk_unread_count");
            int columnIndex22 = cursor.getColumnIndex("inbox_last_timestamp");
            int columnIndex23 = cursor.getColumnIndex("inbox_last_time");
            int columnIndex24 = cursor.getColumnIndex("inbox_enable_noti");
            int columnIndex25 = cursor.getColumnIndex("inbox_unread_count");
            int columnIndex26 = cursor.getColumnIndex("inbox_is_entered");
            int columnIndex27 = cursor.getColumnIndex("lasst_session_merge_time");
            int columnIndex28 = cursor.getColumnIndex("inbox_participants");
            int columnIndex29 = cursor.getColumnIndex("inbox_last_tid");
            int columnIndex30 = cursor.getColumnIndex("inbox_translated");
            int columnIndex31 = cursor.getColumnIndex("inbox_last_message");
            int columnIndex32 = cursor.getColumnIndex("inbox_is_new");
            int columnIndex33 = cursor.getColumnIndex("profile_url");
            int columnIndex34 = cursor.getColumnIndex("inbox_enable_translate");
            int columnIndex35 = cursor.getColumnIndex("translate_outgoing_message");
            int columnIndex36 = cursor.getColumnIndex("inbox_translate_my_language");
            int columnIndex37 = cursor.getColumnIndex("inbox_translate_buddy_language");
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                String string = cursor.getString(columnIndex);
                String string2 = "";
                if (!TextUtils.isEmpty(string)) {
                    string2 = cursor.getString(columnIndex);
                } else {
                    string = "";
                }
                this.f6249R.add(new Object[]{string, string2, cursor.getString(columnIndex2), cursor.getString(columnIndex3), Integer.valueOf(cursor.getInt(columnIndex4)), cursor.getString(columnIndex5), cursor.getString(columnIndex6), Integer.valueOf(cursor.getInt(columnIndex7)), cursor.getString(columnIndex8), cursor.getString(columnIndex9), cursor.getString(columnIndex10), Integer.valueOf(cursor.getInt(columnIndex11)), cursor.getString(columnIndex12), Long.valueOf(cursor.getLong(columnIndex13)), Integer.valueOf(cursor.getInt(columnIndex14)), cursor.getString(columnIndex15), Integer.valueOf(cursor.getInt(columnIndex16)), cursor.getString(columnIndex17), cursor.getString(columnIndex18), cursor.getString(columnIndex19), cursor.getString(columnIndex20), Integer.valueOf(cursor.getInt(columnIndex21)), Long.valueOf(cursor.getLong(columnIndex22)), Long.valueOf(cursor.getLong(columnIndex23)), cursor.getString(columnIndex24), Integer.valueOf(cursor.getInt(columnIndex25)), cursor.getString(columnIndex26), Long.valueOf(cursor.getLong(columnIndex27)), Integer.valueOf(cursor.getInt(columnIndex28)), cursor.getString(columnIndex29), cursor.getString(columnIndex30), cursor.getString(columnIndex31), cursor.getString(columnIndex32), cursor.getString(columnIndex33), cursor.getString(columnIndex34), cursor.getString(columnIndex35), cursor.getString(columnIndex36), cursor.getString(columnIndex37)});
            }
            C3250y.m11456e("makeBackUpCursor() End", "[SEARCH]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m7050m() {
        C3250y.m11456e("createSearchResult() Start", "[SEARCH]");
        if (this.f6252U.isEnabled() && this.f6249R != null && this.f6249R.size() > 0) {
            String string = this.f6246O.m11463a().toString();
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"inbox_title", f6231d, "inbox_no", "buddy_no", "inbox_chat_type", "inbox_valid", "relation_buddy_no", "buddy_show_phone_number", "buddy_extra_info", "buddy_msisdns", "is_buddy", "inbox_last_chat_type", "inbox_session_id", "inbox_last_msg_no", "_id", "inbox_server_ip", "inbox_server_port", "inbox_title_fixed", "inbox_last_msg_sender", "inbox_last_temp_msg", "buddy_name", "inbox_trunk_unread_count", "inbox_last_timestamp", "inbox_last_time", "inbox_enable_noti", "inbox_unread_count", "inbox_is_entered", "lasst_session_merge_time", "inbox_participants", "inbox_last_tid", "inbox_translated", "inbox_last_message", "inbox_is_new", "profile_url", "inbox_enable_translate", "translate_outgoing_message", "inbox_translate_my_language", "inbox_translate_buddy_language"});
            C3250y.m11456e("createSearchResult() Start -1", "[SEARCH]");
            Iterator<Object[]> it = this.f6249R.iterator();
            while (it.hasNext()) {
                Object[] next = it.next();
                C3250y.m11456e("createSearchResult() Start 1", "[SEARCH]");
                String string2 = next[0].toString();
                String string3 = next[1].toString();
                if (TextUtils.isEmpty(string2)) {
                    string2 = "";
                }
                if (TextUtils.isEmpty(string3)) {
                }
                if (!TextUtils.isEmpty(string2) && string2.toUpperCase().toUpperCase().contains(string.toUpperCase())) {
                    matrixCursor.addRow(next);
                }
            }
            C3250y.m11456e("createSearchResult() Start X", "[SEARCH]");
            this.f6250S = matrixCursor;
            C3250y.m11456e("createSearchResult() End", "[SEARCH]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7052n() {
        C3250y.m11456e("setSearchResult() Start", "[SEARCH]");
        if (this.f6252U.isEnabled() && this.f6249R != null && this.f6249R.size() > 0) {
            this.f6274n.m7129b(this.f6246O.m11463a().toString());
            Cursor cursorSwapCursor = this.f6274n.swapCursor(this.f6250S);
            if (cursorSwapCursor != null) {
                C3250y.m11450b("[ChatTitleSearch] setSearchResult", getClass().getSimpleName());
                m7031e(cursorSwapCursor);
            }
            C3250y.m11456e("setSearchResult() End", "[SEARCH]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m7054o() {
        this.f6274n.m7129b("");
        this.f6243L = true;
        m7048l();
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
        if (!isDetached() && z && this.f6251T != null) {
            this.f6251T.setVisibility(0);
            this.f6251T.setOnClickListener(new ViewOnClickListenerC1735v(this));
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        if (!isDetached() && z && this.f6251T != null) {
            this.f6251T.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* renamed from: d */
    public void m7073d() {
        if (this.f6274n != null) {
            this.f6274n.m7128a(true);
            this.f6274n.notifyDataSetChanged();
        }
        if (this.f6255X != null) {
            this.f6255X.setVisibility(this.f6235D.getVisibility());
        }
        if (this.f6254W != null) {
            this.f6254W.setVisibility(this.f6235D.getVisibility());
        }
        if (this.f6253V != null) {
            this.f6253V.setVisibility(8);
        }
        m7069a(0);
    }

    /* renamed from: e */
    public void m7074e() {
        if (this.f6274n != null) {
            this.f6274n.m7128a(false);
            this.f6274n.notifyDataSetChanged();
        }
        if (this.f6255X != null) {
            this.f6255X.setVisibility(this.f6235D.getVisibility());
        }
        if (this.f6253V != null) {
            this.f6253V.setVisibility(this.f6235D.getVisibility());
        }
        if (this.f6254W != null) {
            this.f6254W.setVisibility(8);
        }
        m7069a(1);
    }

    /* renamed from: f */
    public void m7075f() {
        if (GlobalApplication.m6456e()) {
            this.f6274n.m7127a("");
        }
    }

    /* renamed from: a */
    public void m7069a(int i) {
        View viewFindViewById;
        if (GlobalApplication.m6456e() && getView() != null && (viewFindViewById = getView().findViewById(R.id.search_divider)) != null) {
            switch (i) {
                case 0:
                    this.f6257Z.setMargins(0, this.f6261ad, this.f6258aa, 0);
                    viewFindViewById.setLayoutParams(this.f6257Z);
                    break;
                case 1:
                    this.f6257Z.setMargins(0, this.f6261ad, this.f6259ab, 0);
                    viewFindViewById.setLayoutParams(this.f6257Z);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m7056p() {
        if (!GlobalApplication.m6456e() && getActivity() != null && !((ActionBarFragmentActivity) getActivity()).m11543k().mo11594d()) {
            ((ActionBarFragmentActivity) getActivity()).m11543k().mo11595e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m7058q() {
        if (!GlobalApplication.m6456e() && getActivity() != null && ((ActionBarFragmentActivity) getActivity()).m11543k().mo11594d()) {
            ((ActionBarFragmentActivity) getActivity()).m11543k().mo11597f();
        }
    }
}
