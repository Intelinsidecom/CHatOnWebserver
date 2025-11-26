package com.sec.chaton.msgbox;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C2310s;
import com.sec.chaton.EnumC3073u;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.C0280ad;
import com.sec.chaton.p016a.C0281ae;
import com.sec.chaton.p016a.EnumC0302az;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1421l;
import com.sec.chaton.p037j.C1577e;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.widget.C3641ai;
import com.sec.widget.DropPanelMenu;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class MsgboxSelectionFragment extends ListFragment implements InterfaceC1714ar, InterfaceC1716c {

    /* renamed from: a */
    public static final String f6287a = MsgboxSelectionFragment.class.getSimpleName();

    /* renamed from: A */
    private C1337o f6288A;

    /* renamed from: B */
    private ProgressDialog f6289B;

    /* renamed from: C */
    private DropPanelMenu f6290C;

    /* renamed from: E */
    private boolean f6292E;

    /* renamed from: F */
    private Menu f6293F;

    /* renamed from: H */
    private C3326c f6295H;

    /* renamed from: I */
    private InterfaceC1712ap f6296I;

    /* renamed from: b */
    Bundle f6299b;

    /* renamed from: e */
    private ImageView f6302e;

    /* renamed from: f */
    private TextView f6303f;

    /* renamed from: g */
    private TextView f6304g;

    /* renamed from: h */
    private LinearLayout f6305h;

    /* renamed from: i */
    private LinearLayout f6306i;

    /* renamed from: j */
    private ListView f6307j;

    /* renamed from: k */
    private C1696a f6308k;

    /* renamed from: l */
    private CheckedTextView f6309l;

    /* renamed from: n */
    private boolean f6311n;

    /* renamed from: o */
    private C1377u f6312o;

    /* renamed from: p */
    private String f6313p;

    /* renamed from: q */
    private String f6314q;

    /* renamed from: r */
    private EnumC1450r f6315r;

    /* renamed from: s */
    private String f6316s;

    /* renamed from: t */
    private int f6317t;

    /* renamed from: u */
    private int f6318u;

    /* renamed from: v */
    private String f6319v;

    /* renamed from: w */
    private String f6320w;

    /* renamed from: x */
    private String f6321x;

    /* renamed from: z */
    private String f6323z;

    /* renamed from: m */
    private boolean f6310m = false;

    /* renamed from: y */
    private String f6322y = "";

    /* renamed from: D */
    private boolean f6291D = false;

    /* renamed from: G */
    private int f6294G = 1;

    /* renamed from: J */
    private EnumC3073u f6297J = EnumC3073u.INSIDE;

    /* renamed from: c */
    ContentObserver f6300c = new C1708al(this, new Handler());

    /* renamed from: d */
    InterfaceC1378v f6301d = new C1709am(this);

    /* renamed from: K */
    private Handler f6298K = new HandlerC1710an(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6299b = new Bundle();
        this.f6312o = new C1377u(getActivity().getContentResolver(), this.f6301d);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: f */
    private int m7086f() {
        return R.layout.list_item_common_6;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6295H = new C3326c();
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox_selection, viewGroup, false);
        this.f6305h = (LinearLayout) viewInflate.findViewById(R.id.msg_no);
        this.f6302e = (ImageView) this.f6305h.findViewById(R.id.image1);
        this.f6302e.setImageResource(R.drawable.no_contents_chat);
        this.f6303f = (TextView) this.f6305h.findViewById(R.id.text1);
        this.f6303f.setText(getResources().getString(R.string.no_chats));
        this.f6304g = (TextView) this.f6305h.findViewById(R.id.text2);
        this.f6304g.setText(getResources().getString(R.string.chatlist_no_chat_2));
        this.f6305h.setVisibility(8);
        this.f6306i = (LinearLayout) viewInflate.findViewById(R.id.msg_loading);
        this.f6307j = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f6307j.setFastScrollEnabled(false);
        this.f6308k = new C1696a(getActivity(), m7086f(), null);
        this.f6308k.m7124a((InterfaceC1714ar) this);
        this.f6307j.setAdapter((ListAdapter) this.f6308k);
        this.f6308k.m7125a((InterfaceC1716c) this);
        this.f6309l = (CheckedTextView) viewInflate.findViewById(R.id.chatlist_delete_select_all);
        this.f6309l.setOnClickListener(new ViewOnClickListenerC1702af(this));
        this.f6307j.setOnItemClickListener(new C1707ak(this));
        this.f6290C = new DropPanelMenu(this);
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
        this.f6299b = arguments;
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f6318u = arguments.getInt("content_type");
            }
            if (arguments.containsKey("download_uri")) {
                this.f6319v = arguments.getString("download_uri");
            }
            if (arguments.containsKey("sub_content")) {
                this.f6320w = arguments.getString("sub_content");
            }
            if (arguments.containsKey("inboxNO")) {
                this.f6321x = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f6323z = arguments.getString("forward_sender_name");
            }
            if (arguments.containsKey(RtspHeaders.Values.MODE)) {
                this.f6294G = arguments.getInt(RtspHeaders.Values.MODE);
            }
            if (arguments.containsKey(C2310s.f8621e)) {
                this.f6297J = (EnumC3073u) arguments.get(C2310s.f8621e);
            }
            if (arguments.containsKey("is_forward_mode")) {
                this.f6292E = arguments.getBoolean("is_forward_mode");
            }
        }
        setListAdapter(this.f6308k);
        if (getActivity() instanceof ChatForwardActivity) {
            getListView().setChoiceMode(1);
            this.f6308k.m7123a(1);
            if (GlobalApplication.m6456e()) {
                this.f6308k.m7130b(true);
            }
        } else {
            getListView().setChoiceMode(2);
            this.f6308k.m7123a(2);
        }
        if (GlobalApplication.m6456e() && getActivity() != null) {
            this.f6308k.m7130b(true);
        }
        getListView().setItemsCanFocus(true);
        registerForContextMenu(getListView());
        this.f6289B = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.setting_webview_please_wait);
        if (3 == this.f6294G) {
            this.f6309l.setVisibility(8);
        } else if (4 == this.f6294G) {
            this.f6309l.setVisibility(0);
        }
    }

    /* renamed from: g */
    private void m7089g() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        }
        if (C3241p.m11407c(getActivity())) {
            ((InterfaceC1713aq) getActivity()).mo6412c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        String str;
        super.onResume();
        this.f6291D = false;
        BaseActivity.m3081a(this, true);
        m7089g();
        if (getActivity() instanceof MsgboxSelectionActivity) {
            ((MsgboxSelectionActivity) getActivity()).m7076d().mo11583a(getResources().getString(R.string.layout_chat_fragment_delete));
            this.f6312o.startQuery(1, null, C1449q.m6331b(), null, null, null, null);
        } else if (getActivity() instanceof ChatForwardActivity) {
            if (TextUtils.isEmpty(this.f6321x)) {
                str = "";
            } else {
                str = this.f6321x;
            }
            this.f6312o.startQuery(1, null, C1449q.m6333c(), null, null, new String[]{str}, null);
        } else if (C3250y.f11737e) {
            C3250y.m11442a("ERROR!! " + f6287a + " is attached on wrong activity.", f6287a);
        }
        getActivity().getContentResolver().registerContentObserver(C1449q.f5381a, true, this.f6300c);
        m7103n();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f6291D = true;
        BaseActivity.m3081a(this, false);
        getActivity().getContentResolver().unregisterContentObserver(this.f6300c);
    }

    /* renamed from: a */
    public void m7111a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_is_new", "N");
        this.f6312o.startUpdate(1, null, C1449q.f5381a, contentValues, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7091h() {
        File file = new File(CommonApplication.m11493l().getFilesDir().getAbsolutePath() + "/", this.f6313p + "_chat_profile.png_");
        if (file.exists()) {
            file.delete();
        }
        C3243r.m11419a(C3223ck.m11328b() + "/" + this.f6313p);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7114a(java.util.ArrayList<java.lang.String> r14, java.util.ArrayList<java.lang.String> r15, java.lang.String r16, java.util.ArrayList<com.sec.chaton.p016a.C0280ad> r17) throws android.os.RemoteException, android.content.OperationApplicationException {
        /*
            r13 = this;
            android.support.v4.app.FragmentActivity r1 = r13.getActivity()
            android.content.ContentResolver r1 = r1.getContentResolver()
            r0 = r16
            android.database.Cursor r11 = com.sec.chaton.p027e.p028a.C1370n.m6148l(r1, r0)
            java.lang.String r9 = ""
            java.lang.String r7 = ""
            com.sec.chaton.e.r r5 = com.sec.chaton.p027e.EnumC1450r.UNKNOWN
            java.lang.String r3 = ""
            r1 = 0
            if (r11 == 0) goto L7d
            int r2 = r11.getCount()     // Catch: java.lang.Throwable -> L82
            if (r2 <= 0) goto L7d
        L1f:
            r11.moveToFirst()     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "inbox_no"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r10 = r11.getString(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "inbox_session_id"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r8 = r11.getString(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "inbox_chat_type"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L82
            int r2 = r11.getInt(r2)     // Catch: java.lang.Throwable -> L82
            com.sec.chaton.e.r r6 = com.sec.chaton.p027e.EnumC1450r.m6339a(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "inbox_server_ip"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r11.getString(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "inbox_server_port"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L82
            int r2 = r11.getInt(r2)     // Catch: java.lang.Throwable -> L82
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L82
            if (r12 != 0) goto L77
            com.sec.chaton.e.r r12 = com.sec.chaton.p027e.EnumC1450r.BROADCAST     // Catch: java.lang.Throwable -> L82
            if (r6 == r12) goto L77
            r1 = r2
            r3 = r6
            r5 = r10
            r2 = r4
            r4 = r8
        L67:
            if (r11 == 0) goto L6c
            r11.close()
        L6c:
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L89
            r1 = 1
            r13.m7080a(r14, r1)
        L76:
            return
        L77:
            boolean r2 = r11.moveToNext()     // Catch: java.lang.Throwable -> L82
            if (r2 != 0) goto L1f
        L7d:
            r2 = r3
            r4 = r7
            r3 = r5
            r5 = r9
            goto L67
        L82:
            r1 = move-exception
            if (r11 == 0) goto L88
            r11.close()
        L88:
            throw r1
        L89:
            if (r15 == 0) goto L95
            int r4 = r15.size()
            if (r4 <= 0) goto L95
            r4 = 0
            r13.m7080a(r15, r4)
        L95:
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto Lb3
            com.sec.chaton.util.bi r1 = com.sec.chaton.util.C3194bi.m11149a()
            com.sec.chaton.util.bk r1 = r1.m11154c()
            java.lang.String r2 = r1.m11155a()
            com.sec.chaton.util.bi r1 = com.sec.chaton.util.C3194bi.m11149a()
            com.sec.chaton.util.bk r1 = r1.m11154c()
            int r1 = r1.m11158b()
        Lb3:
            com.sec.chaton.d.o r3 = com.sec.chaton.p025d.C1337o.m5795a(r5, r3)
            r13.f6288A = r3
            com.sec.chaton.d.o r3 = r13.f6288A
            android.os.Handler r4 = r13.f6298K
            r3.m5874a(r4)
            com.sec.chaton.d.o r3 = r13.f6288A
            r3.m5880a(r5, r2, r1)
            com.sec.chaton.d.o r1 = r13.f6288A
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.m5893c(r2)
            android.app.ProgressDialog r1 = r13.f6289B
            boolean r1 = r1.isShowing()
            if (r1 != 0) goto Ldc
            android.app.ProgressDialog r1 = r13.f6289B
            r1.show()
        Ldc:
            com.sec.chaton.d.o r1 = r13.f6288A
            r0 = r17
            r1.m5866a(r14, r0)
            com.sec.chaton.j.e r1 = com.sec.chaton.p037j.C1577e.m6684a()
            r1.m6690b()
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.MsgboxSelectionFragment.m7114a(java.util.ArrayList, java.util.ArrayList, java.lang.String, java.util.ArrayList):void");
    }

    /* renamed from: a */
    private void m7080a(ArrayList<String> arrayList, boolean z) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList2.add(ContentProviderOperation.newDelete(C1449q.f5381a).withSelection("inbox_no=?", new String[]{next}).build());
            arrayList2.add(ContentProviderOperation.newDelete(C1454v.f5393a).withSelection("message_inbox_no=?", new String[]{next}).build());
            arrayList2.add(ContentProviderOperation.newDelete(C1457y.f5415a).withSelection("participants_inbox_no=?", new String[]{next}).build());
            C1555a.m6596a().m6600a(next);
            C1561g.m6628a().m6635a(next);
            File file = new File(GlobalApplication.m11493l().getFilesDir().getAbsolutePath() + "/", next + "_chat_profile.png_");
            if (file.exists()) {
                file.delete();
            }
            C3243r.m11419a(C3223ck.m11328b() + "/" + next);
        }
        try {
            if (arrayList2.size() > 0) {
                getActivity().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
            }
        } catch (OperationApplicationException e) {
            if (C3250y.f11737e) {
                C3250y.m11442a(e.toString(), getClass().getSimpleName());
            }
        } catch (RemoteException e2) {
            if (C3250y.f11737e) {
                C3250y.m11442a(e2.toString(), getClass().getSimpleName());
            }
        }
        arrayList2.clear();
        C1379w.m6203a(new C1379w(), -1, new C1421l(null, C1103a.f4442d, false));
        if (z) {
            m7099l();
            this.f6307j.clearChoices();
            if (GlobalApplication.m6456e()) {
                getActivity().setResult(-1);
            }
            m7105o();
        }
    }

    /* renamed from: a */
    public void m7113a(String str, EnumC1450r enumC1450r, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str2) && enumC1450r != EnumC1450r.BROADCAST) {
            this.f6288A = C1337o.m5795a(str, enumC1450r);
            this.f6288A.m5874a(this.f6298K);
            this.f6288A.m5880a(str, str3, i);
            this.f6288A.m5893c(Long.MAX_VALUE);
            if (!this.f6289B.isShowing()) {
                this.f6289B.show();
            }
            this.f6288A.m5838a(enumC1450r, str2, str);
            C1577e.m6684a().m6690b();
            this.f6288A.m5887b(true);
            return;
        }
        this.f6312o.startDelete(1, null, C1449q.f5381a, "inbox_no IN ('" + str + "')", null);
        this.f6312o.startDelete(2, null, C1454v.f5393a, "message_inbox_no='" + str + "'", null);
        C1555a.m6596a().m6600a(str);
        C1561g.m6628a().m6635a(str);
        m7091h();
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
        super.onDestroyView();
        if (this.f6308k != null) {
            Cursor cursor = this.f6308k.getCursor();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                if (C3250y.f11734b) {
                    C3250y.m11450b("The Cursor of Adapter was closed", getClass().getSimpleName());
                }
            }
            this.f6308k.m7124a((InterfaceC1714ar) null);
            this.f6308k.m7125a((InterfaceC1716c) null);
        }
        this.f6307j.setAdapter((ListAdapter) null);
        if (this.f6295H != null) {
            this.f6295H.m11731a();
        }
    }

    /* renamed from: i */
    private void m7093i() {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        if (this.f6294G == 2) {
            C3159aa.m10962a().m10977a("msgbox_close_popup_show", (Boolean) true).booleanValue();
        }
        if (!this.f6311n) {
            m7115b();
        } else {
            m7101m();
        }
    }

    /* renamed from: j */
    private boolean m7095j() {
        SparseBooleanArray checkedItemPositions = this.f6307j.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                Cursor cursor = (Cursor) getListAdapter().getItem(checkedItemPositions.keyAt(i));
                this.f6315r = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
                if (EnumC1450r.m6340a(this.f6315r)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7097k() throws RemoteException, OperationApplicationException {
        SparseBooleanArray checkedItemPositions = this.f6307j.getCheckedItemPositions();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<C0280ad> arrayList2 = new ArrayList<>();
        HashSet hashSet = new HashSet();
        ArrayList<String> arrayList3 = new ArrayList<>();
        EnumC1450r enumC1450r = EnumC1450r.UNKNOWN;
        StringBuilder sb = new StringBuilder();
        if (!this.f6289B.isShowing()) {
            this.f6289B.show();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= checkedItemPositions.size()) {
                break;
            }
            if (checkedItemPositions.valueAt(i2)) {
                Cursor cursor = (Cursor) getListAdapter().getItem(checkedItemPositions.keyAt(i2));
                C0281ae c0281aeNewBuilder = C0280ad.newBuilder();
                EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
                String string = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                long j = cursor.getLong(cursor.getColumnIndex("lasst_session_merge_time"));
                this.f6316s = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                this.f6317t = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                if (C3250y.f11734b) {
                    C3250y.m11450b("endChatMultiple() sessionID[" + string + "]", getClass().getSimpleName());
                }
                String string2 = cursor.getString(cursor.getColumnIndex("inbox_no"));
                if (hashSet.contains(string)) {
                    arrayList3.add(string2);
                } else {
                    arrayList.add(string2);
                    if (enumC1450rM6339a != EnumC1450r.BROADCAST && !TextUtils.isEmpty(string)) {
                        c0281aeNewBuilder.m1443a(m7079a(C1381y.m6218d(getActivity().getContentResolver(), string2)));
                        c0281aeNewBuilder.m1442a(EnumC0302az.m1704a(enumC1450rM6339a.m6342a()));
                        c0281aeNewBuilder.m1444a(string);
                        hashSet.add(string);
                        c0281aeNewBuilder.m1439a(j);
                        arrayList2.add(c0281aeNewBuilder.build());
                        sb.append("'").append(string2).append("'").append(",");
                    }
                }
            }
            i = i2 + 1;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("endChatMultiple() sessionIDs[" + hashSet + "]", getClass().getSimpleName());
        }
        m7114a(arrayList, arrayList3, sb.toString(), arrayList2);
    }

    /* renamed from: a */
    private ArrayList<String> m7079a(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.add(arrayList.get(0));
            return arrayList2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m7099l() {
        if (this.f6289B.isShowing()) {
            this.f6289B.dismiss();
        }
    }

    /* renamed from: m */
    private void m7101m() {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
        abstractC3271aM11494a.mo11495a(R.string.close_chat_room);
        abstractC3271aM11494a.mo11506b(R.string.delete_all_chat_rooms);
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1703ag(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1711ao(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* renamed from: b */
    public void m7115b() {
        if (!C3159aa.m10962a().m10977a("msgbox_close_popup_show", (Boolean) true).booleanValue()) {
            m7113a(this.f6313p, this.f6315r, this.f6314q, this.f6316s, this.f6317t);
            return;
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
        abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
        View viewInflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_msgbox_close_popup, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.isShowPopup);
        if (this.f6294G == 2 && checkBox != null) {
            checkBox.setVisibility(0);
            checkBox.setOnClickListener(new ViewOnClickListenerC1704ah(this));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.popupContent);
        if (m7095j()) {
            textView.setText(R.string.chat_deleted_popup);
        } else {
            textView.setText(R.string.dialog_title_msgbox_delete);
        }
        abstractC3271aM11494a.mo11502a(true);
        abstractC3271aM11494a.mo11508b(viewInflate);
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1706aj(this, checkBox)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1705ai(this));
        abstractC3271aM11494a.mo11512b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f6293F.setGroupVisible(R.id.msgbox_menu_group_delete, true);
        MenuItem menuItemFindItem = menu.findItem(R.id.msgbox_menu_delete_cancel);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(true);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.msgbox_menu_delete_confirm);
        if (menuItemFindItem2 != null) {
            if (this.f6307j.getCheckedItemIds().length > 0) {
                menuItemFindItem2.setEnabled(true);
            } else {
                menuItemFindItem2.setEnabled(false);
            }
        }
        this.f6290C.setItemChanged(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.msgbox_menu_delete_cancel /* 2131166563 */:
                if (getActivity() instanceof MsgboxSelectionActivity) {
                    m7105o();
                    break;
                }
                break;
            case R.id.msgbox_menu_delete_confirm /* 2131166564 */:
                m7093i();
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f6293F = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        if (getActivity() instanceof ChatForwardActivity) {
            if (this.f6296I != null) {
                this.f6296I.mo6416a(true);
                return;
            }
            return;
        }
        if (listView.getCheckedItemIds().length > 0) {
            this.f6293F.findItem(R.id.msgbox_menu_delete_confirm).setEnabled(true);
        } else {
            this.f6293F.findItem(R.id.msgbox_menu_delete_confirm).setEnabled(false);
        }
        if (listView.getCheckedItemIds().length == listView.getCount()) {
            this.f6309l.setChecked(true);
            this.f6311n = true;
        } else {
            this.f6311n = false;
            this.f6309l.setChecked(false);
        }
    }

    /* renamed from: c */
    public void m7116c() {
        if (this.f6307j != null) {
            this.f6307j.setItemChecked(this.f6307j.getCheckedItemPosition(), false);
        }
        m7103n();
        BaseActivity.m3081a(this, true);
    }

    /* renamed from: d */
    public void m7117d() {
        BaseActivity.m3081a(this, false);
        if (this.f6310m) {
            m7111a();
        }
    }

    /* renamed from: n */
    private void m7103n() {
        if (this.f6296I != null) {
            if (this.f6307j.getCheckedItemPositions().size() > 0) {
                this.f6296I.mo6416a(true);
            } else {
                this.f6296I.mo6416a(false);
            }
        }
    }

    /* renamed from: a */
    public void m7112a(InterfaceC1712ap interfaceC1712ap) {
        this.f6296I = interfaceC1712ap;
    }

    /* renamed from: e */
    public void m7118e() {
        int checkedItemPosition = this.f6307j.getCheckedItemPosition();
        if (C3250y.f11734b) {
            C3250y.m11450b("doFarwardAction updated checkedItemPosition[" + checkedItemPosition + "]", getClass().getSimpleName());
        }
        if (checkedItemPosition != -1) {
            Cursor cursor = (Cursor) getListAdapter().getItem(checkedItemPosition);
            if (this.f6310m) {
                m7111a();
            }
            Bundle bundle = new Bundle();
            if (getActivity() instanceof ChatForwardActivity) {
                bundle.putBoolean("isForwardSelected", true);
                bundle.putInt("content_type", this.f6318u);
                bundle.putString("download_uri", this.f6319v);
                bundle.putString("sub_content", this.f6320w);
                bundle.putString("forward_sender_name", this.f6323z);
                bundle.putBoolean("is_forward_mode", this.f6292E);
            }
            ((InterfaceC1713aq) getActivity()).mo6411a(cursor, bundle, this.f6297J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m7105o() {
        if (getActivity() instanceof MsgboxSelectionActivity) {
            ((MsgboxSelectionActivity) getActivity()).m7077e();
        } else {
            if (getActivity() instanceof ChatForwardActivity) {
                ((ChatForwardActivity) getActivity()).m6413d();
                return;
            }
            if (C3250y.f11737e) {
                C3250y.m11442a("ERROR!! " + f6287a + " is attached on wrong activity.", f6287a);
            }
            getActivity().finish();
        }
    }
}
