package com.sec.chaton.msgbox;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p015d.p016a.AsyncTaskC0534ab;
import com.sec.chaton.p015d.p016a.AsyncTaskC0608x;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.settings.SettingActivity;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.ArrayList;
import java.util.Timer;

/* loaded from: classes.dex */
public class MsgboxFragment extends ListFragment implements InterfaceC0221al, InterfaceC0870z {

    /* renamed from: a */
    public static final String f3096a = MsgboxFragment.class.getSimpleName();

    /* renamed from: A */
    private String f3097A;

    /* renamed from: C */
    private long f3099C;

    /* renamed from: D */
    private C0639k f3100D;

    /* renamed from: E */
    private ProgressDialog f3101E;

    /* renamed from: F */
    private View f3102F;

    /* renamed from: G */
    private View f3103G;

    /* renamed from: H */
    private Button f3104H;

    /* renamed from: I */
    private Button f3105I;

    /* renamed from: f */
    private LinearLayout f3112f;

    /* renamed from: g */
    private ListView f3113g;

    /* renamed from: h */
    private C0845a f3114h;

    /* renamed from: i */
    private Cursor f3115i;

    /* renamed from: k */
    private C0666j f3117k;

    /* renamed from: l */
    private ArrayList f3118l;

    /* renamed from: m */
    private ProfileImageView f3119m;

    /* renamed from: n */
    private String f3120n;

    /* renamed from: o */
    private String f3121o;

    /* renamed from: p */
    private String f3122p;

    /* renamed from: q */
    private String f3123q;

    /* renamed from: r */
    private EnumC0695j f3124r;

    /* renamed from: s */
    private String f3125s;

    /* renamed from: t */
    private int f3126t;

    /* renamed from: u */
    private int f3127u;

    /* renamed from: v */
    private int f3128v;

    /* renamed from: x */
    private int f3130x;

    /* renamed from: y */
    private String f3131y;

    /* renamed from: z */
    private String f3132z;

    /* renamed from: e */
    private String f3111e = null;

    /* renamed from: j */
    private boolean f3116j = false;

    /* renamed from: w */
    private boolean f3129w = false;

    /* renamed from: B */
    private String f3098B = "";

    /* renamed from: J */
    private String f3106J = "";

    /* renamed from: b */
    ContentObserver f3108b = new C0868x(this, new Handler());

    /* renamed from: c */
    View.OnClickListener f3109c = new ViewOnClickListenerC0869y(this);

    /* renamed from: d */
    InterfaceC0667k f3110d = new C0853i(this);

    /* renamed from: K */
    private Handler f3107K = new HandlerC0854j(this);

    /* renamed from: a */
    static /* synthetic */ String m3501a(MsgboxFragment msgboxFragment, Object obj) {
        String str = msgboxFragment.f3122p + obj;
        msgboxFragment.f3122p = str;
        return str;
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        BaseActivity.m1827a(this, true);
        if (GlobalApplication.m3265f()) {
            m3537c();
            m3538d();
            C1786r.m6063c("[onTabSelected] mLastInboxNo " + this.f3111e, getClass().getSimpleName());
            if (getActivity().getIntent().getExtras() != null && (getActivity().getIntent().getExtras().containsKey("shortcut_from_buddy_screen") || getActivity().getIntent().getExtras().containsKey("shortcut_from_chat_screen"))) {
                this.f3111e = null;
            } else {
                new C0852h(this).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3511g() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.MsgboxFragment.m3511g():void");
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        BaseActivity.m1827a(this, false);
        if (this.f3116j) {
            m3539e();
        }
        if (GlobalApplication.m3265f()) {
            this.f3111e = m3540f();
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3118l = new ArrayList();
        this.f3117k = new C0666j(getActivity().getContentResolver(), this.f3110d);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        int dimensionPixelOffset;
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox, viewGroup, false);
        this.f3112f = (LinearLayout) viewInflate.findViewById(R.id.lLayoutMenu);
        ((Button) this.f3112f.findViewById(R.id.btnLeave)).setOnClickListener(this.f3109c);
        ((Button) this.f3112f.findViewById(R.id.btnCancel)).setOnClickListener(this.f3109c);
        if (viewInflate.findViewById(R.id.honeycomb_divider) != null) {
            this.f3102F = viewInflate.findViewById(R.id.honeycomb_divider);
        }
        if (viewInflate.findViewById(R.id.honeycomb_menu) != null) {
            this.f3103G = viewInflate.findViewById(R.id.honeycomb_menu);
            this.f3103G.setVisibility(8);
        }
        if (viewInflate.findViewById(R.id.button_start_chat) != null) {
            this.f3104H = (Button) viewInflate.findViewById(R.id.button_start_chat);
            this.f3104H.setOnClickListener(this.f3109c);
            this.f3104H.setVisibility(8);
        }
        if (viewInflate.findViewById(R.id.button_broadcast) != null) {
            this.f3105I = (Button) viewInflate.findViewById(R.id.button_broadcast);
            this.f3105I.setOnClickListener(this.f3109c);
            this.f3105I.setVisibility(8);
        }
        this.f3113g = (ListView) viewInflate.findViewById(android.R.id.list);
        if (getActivity() instanceof ChatForwardActivity) {
            this.f3113g.setLayoutParams(new LinearLayout.LayoutParams(-1, 623));
        }
        if (getActivity() instanceof HomeActivity) {
            Configuration configuration = getResources().getConfiguration();
            if (configuration.orientation == 2) {
                dimensionPixelOffset = getActivity().getResources().getDimensionPixelOffset(R.dimen.land_msgbox_list_height);
            } else {
                dimensionPixelOffset = configuration.orientation == 1 ? getActivity().getResources().getDimensionPixelOffset(R.dimen.port_msgbox_list_height) : 0;
            }
            this.f3113g.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelOffset));
        }
        this.f3113g.setDivider(getResources().getDrawable(R.drawable.list_2line));
        this.f3114h = new C0845a(getActivity(), this.f3113g, R.layout.item_msgbox, null);
        this.f3114h.m3545a(this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f3130x = arguments.getInt("content_type");
                this.f3129w = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f3131y = arguments.getString("download_uri");
            }
            if (arguments.containsKey("sub_content")) {
                this.f3132z = arguments.getString("sub_content");
            }
            if (arguments.containsKey("inboxNO")) {
                this.f3097A = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f3106J = arguments.getString("forward_sender_name");
            }
        }
        setListAdapter(this.f3114h);
        getListView().setChoiceMode(0);
        getListView().setItemsCanFocus(false);
        registerForContextMenu(getListView());
        this.f3101E = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.setting_webview_please_wait);
    }

    /* renamed from: c */
    public void m3537c() {
        BuddyFragment buddyFragment = (BuddyFragment) getFragmentManager().findFragmentById(R.id.fragment_buddy);
        if ((buddyFragment != null ? buddyFragment.m2047e() : 0) == 0) {
            this.f3104H.setEnabled(false);
            this.f3105I.setEnabled(false);
        } else {
            this.f3104H.setEnabled(true);
            this.f3105I.setEnabled(true);
        }
    }

    /* renamed from: d */
    public void m3538d() {
        Fragment fragmentFindFragmentByTag = getFragmentManager().findFragmentByTag("container");
        if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.toString().matches(".*BuddySelectFragment.*")) {
            m3533a("");
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3103G != null && this.f3102F != null) {
            if (!this.f3129w) {
                this.f3102F.setVisibility(0);
                this.f3103G.setVisibility(8);
            } else {
                this.f3102F.setVisibility(8);
                this.f3103G.setVisibility(8);
            }
        }
        if (GlobalApplication.m3265f()) {
            m3537c();
        }
        if (this.f3129w) {
            if (TextUtils.isEmpty(this.f3097A)) {
                this.f3117k.startQuery(1, null, C0694i.m3139a(), null, "inbox_valid=? AND inbox_last_chat_type != ? AND inbox_web_url IS NULL", new String[]{"Y", Integer.toString(12)}, "inbox_last_time DESC");
            } else {
                this.f3117k.startQuery(1, null, C0694i.m3139a(), null, "inbox_no!=? AND inbox_valid=? AND inbox_last_chat_type != ? AND inbox_web_url IS NULL", new String[]{this.f3097A, "Y", Integer.toString(12)}, "inbox_last_time DESC");
            }
        } else {
            this.f3117k.startQuery(1, null, C0694i.m3139a(), null, "inbox_last_chat_type != ?", new String[]{Integer.toString(12)}, "inbox_last_time DESC");
        }
        getActivity().getContentResolver().registerContentObserver(C0694i.f2616a, true, this.f3108b);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getContentResolver().unregisterContentObserver(this.f3108b);
    }

    /* renamed from: e */
    public void m3539e() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_is_new", "N");
        this.f3117k.startUpdate(1, null, C0694i.f2616a, contentValues, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    @Override // android.support.v4.app.ListFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onListItemClick(android.widget.ListView r10, android.view.View r11, int r12, long r13) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = r10.getChoiceMode()
            if (r0 != 0) goto Ld0
            boolean r0 = r9.f3116j
            if (r0 == 0) goto Ld
            r9.m3539e()
        Ld:
            android.widget.ListAdapter r0 = r9.getListAdapter()
            java.lang.Object r0 = r0.getItem(r12)
            android.database.Cursor r0 = (android.database.Cursor) r0
            java.lang.String r1 = "inbox_no"
            int r1 = r0.getColumnIndex(r1)
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "buddy_no"
            int r2 = r0.getColumnIndex(r2)
            java.lang.String r6 = r0.getString(r2)
            java.lang.String r2 = "inbox_chat_type"
            int r2 = r0.getColumnIndex(r2)
            int r2 = r0.getInt(r2)
            java.lang.String r3 = "Y"
            java.lang.String r4 = "inbox_valid"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r0 = r0.getString(r4)
            boolean r0 = r3.equals(r0)
            android.support.v4.app.FragmentActivity r3 = r9.getActivity()
            r4 = 1
            android.content.Intent r8 = com.sec.chaton.HomeActivity.m585a(r3, r4)
            java.lang.String r3 = "inboxNO"
            r8.putExtra(r3, r1)
            java.lang.String r3 = "chatType"
            r8.putExtra(r3, r2)
            java.lang.String r2 = com.sec.chaton.chat.ChatFragment.f1754j
            r3 = 1
            r8.putExtra(r2, r3)
            java.lang.String r2 = "inboxValid"
            r8.putExtra(r2, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto Ldd
            r7 = 0
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.Throwable -> Ld1
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Ld1
            android.net.Uri r1 = com.sec.chaton.p017e.C0701p.m3164a(r1)     // Catch: java.lang.Throwable -> Ld1
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Ld1
            r3 = 0
            java.lang.String r4 = "buddy_no"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Ld1
            r3 = 0
            r4 = 0
            java.lang.String r5 = "rowid DESC"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Ld1
            if (r1 == 0) goto Ldb
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Ld9
            if (r0 <= 0) goto Ldb
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Ld9
            r0 = 0
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> Ld9
            r0 = r6
        L97:
            if (r1 == 0) goto L9c
            r1.close()
        L9c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto Lad
            java.lang.String r1 = "receivers"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]
            r3 = 0
            r2[r3] = r0
            r8.putExtra(r1, r2)
        Lad:
            boolean r0 = r9.f3129w
            if (r0 == 0) goto Lcd
            java.lang.String r0 = "content_type"
            int r1 = r9.f3130x
            r8.putExtra(r0, r1)
            java.lang.String r0 = "download_uri"
            java.lang.String r1 = r9.f3131y
            r8.putExtra(r0, r1)
            java.lang.String r0 = "forward_sender_name"
            java.lang.String r1 = r9.f3106J
            r8.putExtra(r0, r1)
            java.lang.String r0 = "sub_content"
            java.lang.String r1 = r9.f3132z
            r8.putExtra(r0, r1)
        Lcd:
            r9.startActivity(r8)
        Ld0:
            return
        Ld1:
            r0 = move-exception
            r1 = r7
        Ld3:
            if (r1 == 0) goto Ld8
            r1.close()
        Ld8:
            throw r0
        Ld9:
            r0 = move-exception
            goto Ld3
        Ldb:
            r0 = r6
            goto L97
        Ldd:
            r0 = r6
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.MsgboxFragment.onListItemClick(android.widget.ListView, android.view.View, int, long):void");
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        TextView textView;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        Cursor cursor = (Cursor) getListAdapter().getItem(adapterContextMenuInfo.position);
        this.f3126t = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f3120n = cursor.getString(cursor.getColumnIndex("inbox_no"));
        this.f3122p = cursor.getString(cursor.getColumnIndex("inbox_title"));
        this.f3123q = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
        this.f3124r = EnumC0695j.m3145a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
        this.f3125s = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
        this.f3127u = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
        if (TextUtils.isEmpty(this.f3125s)) {
            this.f3125s = GlobalApplication.m3263d().m5922b().m5923a();
            this.f3127u = GlobalApplication.m3263d().m5922b().m5926b();
        }
        this.f3099C = cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no"));
        this.f3121o = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
        this.f3128v = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        String string = cursor.getString(cursor.getColumnIndex("buddy_name"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
        boolean zEquals2 = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
        C1786r.m6064d("serverIP:" + this.f3125s);
        C1786r.m6064d("serverPort:" + this.f3127u);
        this.f3119m = new ProfileImageView(getActivity());
        this.f3119m.m6129a(this.f3119m, this.f3124r);
        if (this.f3124r == EnumC0695j.ONETOONE) {
            if (zEquals) {
                C1746bb.m5945a(getActivity()).m5959a(this.f3119m, string3);
                this.f3119m.setBuddyNo(string3);
            }
            if (!string2.equals("Y")) {
                this.f3122p = string;
            }
        } else if (this.f3124r == EnumC0695j.BROADCAST) {
            this.f3122p = C0493bg.m2685a(string2, this.f3122p);
        } else if (this.f3128v == 0) {
            this.f3122p = getResources().getString(R.string.chat_title_no_buddies);
        }
        if (this.f3122p == null) {
            FrameLayout frameLayout = (FrameLayout) adapterContextMenuInfo.targetView;
            if (frameLayout != null && (textView = (TextView) frameLayout.findViewById(R.id.msgboxTextName)) != null) {
                this.f3122p = (String) textView.getText();
            } else {
                this.f3122p = getResources().getString(R.string.toast_error);
            }
        }
        contextMenu.setHeaderTitle(this.f3122p);
        if (GlobalApplication.m3265f()) {
            contextMenu.add(R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0862r(this));
        } else {
            contextMenu.add(R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0863s(this));
        }
        if (zEquals) {
            if (!GlobalApplication.m3265f()) {
                contextMenu.add(R.string.buddy_list_contextual_menu_viewprofile).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0864t(this, string3, zEquals2));
            } else {
                contextMenu.add(R.string.chat_profile).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0865u(this, string3, string, zEquals2));
            }
            contextMenu.add(R.string.buddy_list_contextual_menu_shortcut).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0866v(this, string3));
            if (string3 != null && string3.startsWith("0999")) {
                contextMenu.add(R.string.buddy_list_contextual_menu_viewprofile).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0867w(this, string3));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.add(0, 1, 1, R.string.menu_inbox_group_chat).setIcon(R.drawable.group_chat);
        menu.add(0, 2, 2, R.string.menu_inbox_broadcast).setIcon(R.drawable.broadcast);
        if (C1789u.m6075a().contains("UpdateIsCritical")) {
            menu.add(0, 4, 4, getResources().getString(R.string.menu_inbox_setting)).setIcon(R.drawable.settings_new);
        } else {
            menu.add(0, 4, 4, R.string.menu_inbox_setting).setIcon(R.drawable.ic_menu_settings);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        BuddyFragment buddyFragment = (BuddyFragment) getFragmentManager().findFragmentById(R.id.fragment_buddy);
        if ((buddyFragment != null ? buddyFragment.m2047e() : 0) > 0) {
            menu.findItem(1).setVisible(true).setEnabled(true);
            menu.findItem(2).setVisible(true).setEnabled(true);
        } else {
            menu.findItem(1).setVisible(false).setEnabled(false);
            menu.findItem(2).setVisible(false).setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                startActivity(intent);
                break;
            case 2:
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("BUDDY_SORT_STYLE", 11);
                intent2.putExtra("ACTIVITY_PURPOSE", 3);
                startActivity(intent2);
                break;
            case 3:
                getListView().setChoiceMode(2);
                this.f3112f.setVisibility(0);
                break;
            case 4:
                startActivity(new Intent(getActivity(), (Class<?>) (GlobalApplication.m3265f() ? SettingActivity.class : ActivitySettings.class)));
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public String[] m3513h() {
        int i = 0;
        SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
        if (checkedItemPositions == null || checkedItemPositions.size() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 < getListAdapter().getCount()) {
                if (checkedItemPositions.get(i2)) {
                    Cursor cursor = (Cursor) getListAdapter().getItem(i2);
                    arrayList.add(cursor.getString(cursor.getColumnIndex("inbox_no")));
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                i = i2 + 1;
            } else {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3515i() {
        C1783o.m6036a((C1767bw.m6002a() ? GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath()) + "/" + this.f3120n);
    }

    /* renamed from: a */
    public void m3535a(String str, EnumC0695j enumC0695j, String str2, String str3, int i, long j, String str4) {
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
        alertDialogBuilderC2120a.setTitle(R.string.menu_chat_close);
        alertDialogBuilderC2120a.setMessage(R.string.dialog_title_msgbox_delete).setCancelable(false).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0856l(this)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0855k(this, str, enumC0695j, str2, str3, i));
        alertDialogBuilderC2120a.show();
    }

    /* renamed from: a */
    public void m3534a(String str, EnumC0695j enumC0695j, String str2, String str3, int i) {
        C1788t.m6070a(getActivity()).m6073a(this.f3126t);
        if (!TextUtils.isEmpty(str2) && enumC0695j != EnumC0695j.BROADCAST) {
            this.f3100D = C0639k.m2904a(this.f3107K, str, enumC0695j);
            this.f3100D.m2947a(str, str3, i);
            this.f3100D.m2930a(Long.MAX_VALUE);
            if (!this.f3101E.isShowing()) {
                this.f3101E.show();
            }
            this.f3100D.m2937a(enumC0695j, str2, str, (String[]) this.f3118l.toArray(new String[0]));
            if (!this.f3100D.f2484b) {
                this.f3100D.f2484b = true;
            } else {
                this.f3100D.m2959k();
            }
            this.f3100D.m2949b(true);
            return;
        }
        this.f3117k.startDelete(1, null, C0694i.f2616a, "inbox_no IN ('" + str + "')", null);
        this.f3117k.startDelete(2, null, C0698m.f2626a, "message_inbox_no='" + str + "'", null);
        if (C0639k.m2914b(str) != null && C0639k.m2914b(str).f2486d != null) {
            for (Long l : C0639k.m2914b(str).f2486d.keySet()) {
                if (C0639k.m2914b(str).f2486d.containsKey(l)) {
                    ((AsyncTaskC0608x) C0639k.m2914b(str).f2486d.get(l)).cancel(true);
                    C0639k.m2914b(str).f2486d.remove(l);
                }
            }
        }
        if (C0639k.m2914b(str) != null && C0639k.m2914b(str).f2485c != null) {
            for (Long l2 : C0639k.m2914b(str).f2485c.keySet()) {
                if (C0639k.m2914b(str).f2485c.containsKey(l2)) {
                    ((AsyncTaskC0534ab) C0639k.m2914b(str).f2485c.get(l2)).cancel(true);
                    C0639k.m2914b(str).f2485c.remove(l2);
                }
            }
        }
        m3515i();
        if (GlobalApplication.m3265f() && this.f3098B.equals(str)) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3504a(String[] strArr) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getActivity()).setTitle(R.string.menu_chat_delete).setMessage(R.string.dialog_chatting_delete).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0858n(this)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0857m(this)).create();
        alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0859o(this));
        alertDialogCreate.show();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (getActivity() instanceof HomeActivity) {
            int dimensionPixelOffset = 0;
            if (configuration.orientation == 2) {
                dimensionPixelOffset = getActivity().getResources().getDimensionPixelOffset(R.dimen.land_msgbox_list_height);
            } else if (configuration.orientation == 1) {
                dimensionPixelOffset = getActivity().getResources().getDimensionPixelOffset(R.dimen.port_msgbox_list_height);
            }
            this.f3113g.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelOffset));
        }
        if (getActivity().findViewById(R.id.fragment_container) != null) {
            new Timer(true).schedule(new C0860p(this, new Handler()), 200L);
        } else {
            setListAdapter(this.f3114h);
        }
    }

    @Override // com.sec.chaton.msgbox.InterfaceC0870z
    /* renamed from: a */
    public void mo3532a(View view, boolean z) {
        this.f3116j = z;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (intent.hasExtra("isClosing")) {
                        m3534a(intent.getStringExtra("inboxNO"), EnumC0695j.ONETOONE, null, null, 0);
                        break;
                    } else {
                        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                        if (this.f3116j) {
                            m3539e();
                        }
                        if (stringArrayExtra != null) {
                            String stringExtra = intent.getStringExtra("inboxNO");
                            String stringExtra2 = intent.getStringExtra("buddyNO");
                            int intExtra = intent.getIntExtra("chatType", 0);
                            ArrayList arrayList = new ArrayList();
                            for (String str : stringArrayExtra) {
                                arrayList.add(str);
                            }
                            Intent intentM585a = HomeActivity.m585a((Context) getActivity(), true);
                            if (intExtra == EnumC0695j.ONETOONE.m3146a()) {
                                intentM585a.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                                arrayList.add(stringExtra2);
                            } else {
                                intentM585a.putExtra("inboxNO", stringExtra);
                                intentM585a.putExtra("chatType", intExtra);
                                intentM585a.putExtra(ChatFragment.f1754j, 1);
                                intentM585a.putExtra(ChatFragment.f1756l, true);
                            }
                            intentM585a.putExtra("inboxValid", true);
                            intentM585a.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                            startActivity(intentM585a);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m3533a(String str) {
        this.f3098B = str;
        C1789u.m6079a("lastInbox", str);
        this.f3114h.m3546a(str);
        this.f3113g.invalidateViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3113g.getCount()) {
                Cursor cursor = (Cursor) this.f3113g.getItemAtPosition(i2);
                if (cursor == null || !cursor.getString(cursor.getColumnIndex("inbox_no")).equals(str)) {
                    i = i2 + 1;
                } else {
                    this.f3113g.setSelection(i2);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public void m3536b(String str) {
        C1786r.m6063c("setMsgTabCachedInbox called, setting mLastInboxNo null", getClass().getSimpleName());
        this.f3111e = str;
    }

    /* renamed from: f */
    public String m3540f() {
        return this.f3098B;
    }
}
