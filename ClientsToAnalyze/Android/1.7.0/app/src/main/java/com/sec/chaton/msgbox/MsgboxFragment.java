package com.sec.chaton.msgbox;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.InterfaceC0726l;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.C1356c;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.widget.AlertDialogBuilderC1625m;
import java.util.ArrayList;
import java.util.Timer;

/* loaded from: classes.dex */
public class MsgboxFragment extends ListFragment implements InterfaceC0726l, InterfaceC0756u {

    /* renamed from: a */
    public static final String f2486a = MsgboxFragment.class.getSimpleName();

    /* renamed from: B */
    private long f2488B;

    /* renamed from: C */
    private C0223v f2489C;

    /* renamed from: D */
    private ProgressDialog f2490D;

    /* renamed from: E */
    private View f2491E;

    /* renamed from: F */
    private View f2492F;

    /* renamed from: G */
    private LinearLayout f2493G;

    /* renamed from: e */
    private LinearLayout f2499e;

    /* renamed from: f */
    private ListView f2500f;

    /* renamed from: g */
    private C0736a f2501g;

    /* renamed from: h */
    private Cursor f2502h;

    /* renamed from: j */
    private C0630j f2504j;

    /* renamed from: k */
    private ArrayList f2505k;

    /* renamed from: l */
    private ProfileImageView f2506l;

    /* renamed from: m */
    private String f2507m;

    /* renamed from: n */
    private String f2508n;

    /* renamed from: o */
    private String f2509o;

    /* renamed from: p */
    private String f2510p;

    /* renamed from: q */
    private EnumC0665r f2511q;

    /* renamed from: r */
    private String f2512r;

    /* renamed from: s */
    private int f2513s;

    /* renamed from: t */
    private int f2514t;

    /* renamed from: u */
    private int f2515u;

    /* renamed from: w */
    private int f2517w;

    /* renamed from: x */
    private String f2518x;

    /* renamed from: y */
    private String f2519y;

    /* renamed from: z */
    private String f2520z;

    /* renamed from: i */
    private boolean f2503i = false;

    /* renamed from: v */
    private boolean f2516v = false;

    /* renamed from: A */
    private String f2487A = "";

    /* renamed from: H */
    private boolean f2494H = false;

    /* renamed from: b */
    ContentObserver f2496b = new C0750o(this, new Handler());

    /* renamed from: c */
    View.OnClickListener f2497c = new ViewOnClickListenerC0751p(this);

    /* renamed from: d */
    InterfaceC0626f f2498d = new C0752q(this);

    /* renamed from: I */
    private Handler f2495I = new HandlerC0753r(this);

    /* renamed from: a */
    static /* synthetic */ String m3145a(MsgboxFragment msgboxFragment, Object obj) {
        String str = msgboxFragment.f2509o + obj;
        msgboxFragment.f2509o = str;
        return str;
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: a */
    public void mo2192a() {
        BaseActivity.m2041a(this, true);
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: b */
    public void mo2200b() {
        BaseActivity.m2041a(this, false);
        if (this.f2503i) {
            m3177c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2505k = new ArrayList();
        this.f2504j = new C0630j(getActivity().getContentResolver(), this.f2498d);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox, viewGroup, false);
        this.f2499e = (LinearLayout) viewInflate.findViewById(R.id.lLayoutMenu);
        this.f2493G = (LinearLayout) viewInflate.findViewById(R.id.msg_background);
        if (viewInflate.findViewById(R.id.honeycomb_divider) != null) {
            this.f2491E = viewInflate.findViewById(R.id.honeycomb_divider);
        }
        if (viewInflate.findViewById(R.id.honeycomb_menu) != null) {
            this.f2492F = viewInflate.findViewById(R.id.honeycomb_menu);
        }
        if (getResources().getConfiguration().orientation == 2) {
            if (this.f2493G != null) {
                this.f2493G.setPadding(0, 0, 0, 0);
            }
        } else if (getResources().getConfiguration().orientation == 1 && this.f2493G != null) {
            this.f2493G.setPadding(0, (int) C1301ax.m4544a(49.0f), 0, 0);
        }
        this.f2500f = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f2501g = new C0736a(getActivity(), this.f2500f, R.layout.item_msgbox, null);
        this.f2501g.m3182a(this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f2517w = arguments.getInt("content_type");
                this.f2516v = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f2518x = arguments.getString("download_uri");
            }
            if (arguments.containsKey("sub_content")) {
                this.f2519y = arguments.getString("sub_content");
            }
            if (arguments.containsKey("inboxNO")) {
                this.f2520z = arguments.getString("inboxNO");
            }
        }
        setListAdapter(this.f2501g);
        getListView().setChoiceMode(0);
        getListView().setItemsCanFocus(false);
        registerForContextMenu(getListView());
        this.f2490D = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.setting_webview_please_wait);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f2494H = false;
        if (this.f2492F != null && this.f2491E != null) {
            if (!this.f2516v) {
                this.f2491E.setVisibility(0);
                this.f2492F.setVisibility(0);
            } else {
                this.f2491E.setVisibility(8);
                this.f2492F.setVisibility(8);
            }
        }
        if (this.f2516v) {
            if (TextUtils.isEmpty(this.f2520z)) {
                this.f2504j.startQuery(1, null, C0671x.m3037a(), null, "inbox_valid=? AND inbox_last_chat_type != ?", new String[]{"Y", Integer.toString(12)}, "inbox_last_time DESC");
            } else {
                this.f2504j.startQuery(1, null, C0671x.m3037a(), null, "inbox_no!=? AND inbox_valid=? AND inbox_last_chat_type != ?", new String[]{this.f2520z, "Y", Integer.toString(12)}, "inbox_last_time DESC");
            }
        } else {
            this.f2504j.startQuery(1, null, C0671x.m3037a(), null, "inbox_last_chat_type != ?", new String[]{Integer.toString(12)}, "inbox_last_time DESC");
        }
        getActivity().getContentResolver().registerContentObserver(C0671x.f2315a, true, this.f2496b);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f2494H = true;
        getActivity().getContentResolver().unregisterContentObserver(this.f2496b);
    }

    /* renamed from: c */
    public void m3177c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_is_new", "N");
        this.f2504j.startUpdate(1, null, C0671x.f2315a, contentValues, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    @Override // android.support.v4.app.ListFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onListItemClick(android.widget.ListView r10, android.view.View r11, int r12, long r13) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = r10.getChoiceMode()
            if (r0 != 0) goto Lc9
            boolean r0 = r9.f2503i
            if (r0 == 0) goto Ld
            r9.m3177c()
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
            android.content.Intent r8 = com.sec.chaton.HomeActivity.m630a(r3, r4)
            java.lang.String r3 = "inboxNO"
            r8.putExtra(r3, r1)
            java.lang.String r3 = "chatType"
            r8.putExtra(r3, r2)
            java.lang.String r2 = com.sec.chaton.chat.ChatFragment.f1735h
            r3 = 1
            r8.putExtra(r2, r3)
            java.lang.String r2 = "inboxValid"
            r8.putExtra(r2, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto Ld6
            r7 = 0
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3100a()     // Catch: java.lang.Throwable -> Lca
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lca
            android.net.Uri r1 = com.sec.chaton.p025d.C0654g.m2980a(r1)     // Catch: java.lang.Throwable -> Lca
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lca
            r3 = 0
            java.lang.String r4 = "buddy_no"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lca
            r3 = 0
            r4 = 0
            java.lang.String r5 = "rowid DESC"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lca
            if (r1 == 0) goto Ld4
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Ld2
            if (r0 <= 0) goto Ld4
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Ld2
            r0 = 0
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> Ld2
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
            boolean r0 = r9.f2516v
            if (r0 == 0) goto Lc6
            java.lang.String r0 = "content_type"
            int r1 = r9.f2517w
            r8.putExtra(r0, r1)
            java.lang.String r0 = "download_uri"
            java.lang.String r1 = r9.f2518x
            r8.putExtra(r0, r1)
            java.lang.String r0 = "sub_content"
            java.lang.String r1 = r9.f2519y
            r8.putExtra(r0, r1)
        Lc6:
            r9.startActivity(r8)
        Lc9:
            return
        Lca:
            r0 = move-exception
            r1 = r7
        Lcc:
            if (r1 == 0) goto Ld1
            r1.close()
        Ld1:
            throw r0
        Ld2:
            r0 = move-exception
            goto Lcc
        Ld4:
            r0 = r6
            goto L97
        Ld6:
            r0 = r6
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.MsgboxFragment.onListItemClick(android.widget.ListView, android.view.View, int, long):void");
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        Cursor cursor = (Cursor) getListAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        this.f2513s = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f2507m = cursor.getString(cursor.getColumnIndex("inbox_no"));
        this.f2509o = cursor.getString(cursor.getColumnIndex("inbox_title"));
        this.f2510p = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
        this.f2511q = EnumC0665r.m3011a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
        this.f2512r = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
        this.f2514t = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
        this.f2488B = cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no"));
        this.f2508n = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
        this.f2515u = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        String string = cursor.getString(cursor.getColumnIndex("buddy_name"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
        C1341p.m4659c("serverIP:" + this.f2512r);
        C1341p.m4659c("serverPort:" + this.f2514t);
        this.f2506l = new ProfileImageView(getActivity());
        this.f2506l.m4722a(this.f2506l, this.f2511q);
        if (this.f2511q == EnumC0665r.ONETOONE) {
            if (zEquals) {
                C1348w.m4685a(getActivity()).m4699a(this.f2506l, string3);
                this.f2506l.setBuddyNo(string3);
            }
            if (!string2.equals("Y")) {
                this.f2509o = string;
            }
        } else if (this.f2511q == EnumC0665r.BROADCAST) {
            this.f2509o = C0520a.m2714a(string2, this.f2509o);
        } else if (this.f2515u == 0) {
            this.f2509o = getResources().getString(R.string.chat_title_no_buddies);
        }
        contextMenu.setHeaderTitle(this.f2509o);
        contextMenu.add(R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0747l(this));
        if (zEquals) {
            contextMenu.add(R.string.chat_view_menu_info2).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0748m(this, string3));
            contextMenu.add(R.string.buddy_list_contextual_menu_shortcut).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0749n(this, string3));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
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
                this.f2499e.setVisibility(0);
                break;
            case 4:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String[] m3151d() {
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
                }
                i = i2 + 1;
            } else {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3153e() {
        C1324bt.m4585a(C1327bw.m4596b() + "/" + this.f2507m);
    }

    /* renamed from: a */
    public void m3176a(String str, EnumC0665r enumC0665r, String str2, String str3, int i, long j, String str4) {
        AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
        alertDialogBuilderC1625m.setTitle(R.string.menu_chat_close);
        alertDialogBuilderC1625m.setMessage(R.string.dialog_title_msgbox_delete).setCancelable(true).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0755t(this, str2, enumC0665r, str, str3, i)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0754s(this));
        alertDialogBuilderC1625m.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3147a(String[] strArr) {
        DialogInterfaceOnClickListenerC0740e dialogInterfaceOnClickListenerC0740e = new DialogInterfaceOnClickListenerC0740e(this);
        AlertDialog alertDialogCreate = new AlertDialogBuilderC1625m(getActivity()).setTitle(R.string.menu_chat_delete).setMessage(R.string.dialog_chatting_delete).setPositiveButton(R.string.dialog_ok, dialogInterfaceOnClickListenerC0740e).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0739d(this)).create();
        alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0738c(this));
        alertDialogCreate.show();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getActivity().findViewById(R.id.fragment_container) != null) {
            new Timer(true).schedule(new C0737b(this, new Handler()), 200L);
        } else {
            setListAdapter(this.f2501g);
        }
        if (configuration.orientation == 2) {
            if (this.f2493G != null) {
                this.f2493G.setPadding(0, 0, 0, 0);
            }
        } else if (configuration.orientation == 1 && this.f2493G != null) {
            this.f2493G.setPadding(0, (int) C1301ax.m4544a(49.0f), 0, 0);
        }
    }

    @Override // com.sec.chaton.msgbox.InterfaceC0756u
    /* renamed from: a */
    public void mo3174a(View view, boolean z) {
        this.f2503i = z;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    if (this.f2503i) {
                        m3177c();
                    }
                    if (stringArrayExtra != null) {
                        String stringExtra = intent.getStringExtra("inboxNO");
                        String stringExtra2 = intent.getStringExtra("buddyNO");
                        int intExtra = intent.getIntExtra("chatType", 0);
                        ArrayList arrayList = new ArrayList();
                        for (String str : stringArrayExtra) {
                            arrayList.add(str);
                        }
                        Intent intentM630a = HomeActivity.m630a((Context) getActivity(), true);
                        if (intExtra == EnumC0665r.ONETOONE.m3012a()) {
                            intentM630a.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                            arrayList.add(stringExtra2);
                        } else {
                            intentM630a.putExtra("inboxNO", stringExtra);
                            intentM630a.putExtra("chatType", intExtra);
                            intentM630a.putExtra(ChatFragment.f1735h, 1);
                            intentM630a.putExtra(ChatFragment.f1737j, true);
                        }
                        intentM630a.putExtra("inboxValid", true);
                        intentM630a.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                        startActivity(intentM630a);
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m3175a(String str) {
        this.f2487A = str;
        this.f2501g.m3183a(str);
        this.f2500f.invalidateViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2500f.getCount()) {
                Cursor cursor = (Cursor) this.f2500f.getItemAtPosition(i2);
                if (cursor == null || !cursor.getString(cursor.getColumnIndex("inbox_no")).equals(str)) {
                    i = i2 + 1;
                } else {
                    this.f2500f.setSelection(i2);
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f2501g.changeCursor(null);
    }
}
