package com.sec.chaton.msgbox;

import android.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.SMSProgressBar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MsgboxFragment extends ListFragment implements HomeTabFragment.OnTabChangeListener, OnChatisNew {

    /* renamed from: a */
    public static final String f1958a = MsgboxFragment.class.getSimpleName();

    /* renamed from: A */
    private int f1959A;

    /* renamed from: B */
    private int f1960B;

    /* renamed from: C */
    private int f1961C;

    /* renamed from: E */
    private int f1963E;

    /* renamed from: F */
    private String f1964F;

    /* renamed from: G */
    private String f1965G;

    /* renamed from: H */
    private String f1966H;

    /* renamed from: I */
    private long f1967I;

    /* renamed from: J */
    private MessageControl f1968J;

    /* renamed from: K */
    private ProgressDialog f1969K;

    /* renamed from: m */
    private LinearLayout f1974m;

    /* renamed from: n */
    private ListView f1975n;

    /* renamed from: o */
    private MsgBoxListAdapter f1976o;

    /* renamed from: p */
    private Cursor f1977p;

    /* renamed from: r */
    private NotifyingAsyncQueryHandler f1979r;

    /* renamed from: s */
    private ArrayList f1980s;

    /* renamed from: t */
    private ProfileImageView f1981t;

    /* renamed from: u */
    private String f1982u;

    /* renamed from: v */
    private String f1983v;

    /* renamed from: w */
    private String f1984w;

    /* renamed from: x */
    private String f1985x;

    /* renamed from: y */
    private ChatONContract.InBoxTable.ChatType f1986y;

    /* renamed from: z */
    private String f1987z;

    /* renamed from: q */
    private boolean f1978q = false;

    /* renamed from: D */
    private boolean f1962D = false;

    /* renamed from: b */
    ContentObserver f1971b = new C0263m(this, new Handler());

    /* renamed from: c */
    View.OnClickListener f1972c = new ViewOnClickListenerC0264n(this);

    /* renamed from: d */
    NotifyingAsyncQueryHandler.AsyncQueryListener f1973d = new C0265o(this);

    /* renamed from: L */
    private Handler f1970L = new HandlerC0266p(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AlertDialog.Builder m2413a(EditText editText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(C0062R.string.dialog_title_rename);
        builder.setView(editText);
        return builder;
    }

    /* renamed from: a */
    static /* synthetic */ String m2418a(MsgboxFragment msgboxFragment, Object obj) {
        String str = msgboxFragment.f1984w + obj;
        msgboxFragment.f1984w = str;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2421a(String[] strArr) {
        DialogInterfaceOnClickListenerC0253c dialogInterfaceOnClickListenerC0253c = new DialogInterfaceOnClickListenerC0253c(this);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getActivity()).setTitle(C0062R.string.menu_chat_delete).setMessage(C0062R.string.dialog_chatting_delete).setPositiveButton(C0062R.string.dialog_ok, dialogInterfaceOnClickListenerC0253c).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0252b(this)).create();
        alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0251a(this));
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String[] m2427f() {
        SparseBooleanArray checkedItemPositions = m35d().getCheckedItemPositions();
        if (checkedItemPositions == null || checkedItemPositions.size() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < m36e().getCount(); i++) {
            if (checkedItemPositions.get(i)) {
                Cursor cursor = (Cursor) m36e().getItem(i);
                arrayList.add(cursor.getString(cursor.getColumnIndex("inbox_no")));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2429g() {
        ChatONFileUtil.m3483a((StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath()) + "/" + this.f1982u);
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: a */
    public void mo390a() {
        setHasOptionsMenu(true);
    }

    @Override // com.sec.chaton.msgbox.OnChatisNew
    /* renamed from: a */
    public void mo2447a(View view, boolean z) {
        this.f1978q = z;
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo34a(ListView listView, View view, int i, long j) {
        if (listView.getChoiceMode() == 0) {
            if (this.f1978q) {
                m2450c();
            }
            Cursor cursor = (Cursor) m36e().getItem(i);
            String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
            int i2 = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
            Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("inboxNO", string);
            intent.putExtra("chatType", i2);
            intent.putExtra(ChatFragment.f729h, 1);
            if (!this.f1962D) {
                ((BaseActivity) getActivity()).openActivityOrFragment(intent);
                return;
            }
            intent.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f1963E);
            intent.putExtra("download_uri", this.f1964F);
            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f1963E) == ChatONContract.MessageTable.MsgContentType.CALENDAR || ChatONContract.MessageTable.MsgContentType.m2195a(this.f1963E) == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                intent.putExtra("sub_content", this.f1965G);
            }
            startActivity(intent);
            getActivity().finish();
        }
    }

    /* renamed from: a */
    public void m2448a(String str, ChatONContract.InBoxTable.ChatType chatType, String str2, String str3, int i, long j, String str4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(C0062R.string.menu_chat_close);
        builder.setMessage(C0062R.string.dialog_title_msgbox_delete).setCancelable(false).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0268r(this, str2, chatType, str, str3, i)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0267q(this));
        builder.show();
    }

    /* renamed from: a */
    public void m2449a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_title", str);
        contentValues.put("inbox_title_fixed", "Y");
        this.f1979r.startUpdate(-1, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no='" + str2 + "'", null);
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: b */
    public void mo391b() {
        setHasOptionsMenu(false);
        if (this.f1978q) {
            m2450c();
        }
    }

    /* renamed from: c */
    public void m2450c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_is_new", "N");
        this.f1979r.startUpdate(1, null, ChatONContract.InBoxTable.f1717a, contentValues, null, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE)) {
                this.f1963E = arguments.getInt(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE);
                ChatONLogWriter.m3509d("Msgbox content_type:" + this.f1963E);
                this.f1962D = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f1964F = arguments.getString("download_uri");
                ChatONLogWriter.m3509d("Msgbox download_uri:" + this.f1964F);
            }
            if (arguments.containsKey("sub_content")) {
                this.f1965G = arguments.getString("sub_content");
                ChatONLogWriter.m3509d("Msgbox sub_content:" + this.f1965G);
            }
            if (arguments.containsKey("inboxNO")) {
                this.f1966H = arguments.getString("inboxNO");
                ChatONLogWriter.m3509d("Msgbox mInboxNo:" + this.f1966H);
            }
        }
        m33a(this.f1976o);
        m35d().setChoiceMode(0);
        m35d().setItemsCanFocus(false);
        registerForContextMenu(m35d());
        this.f1969K = (ProgressDialog) new SMSProgressBar(getActivity()).onCreate(C0062R.string.setting_webview_please_wait);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m33a(this.f1976o);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1980s = new ArrayList();
        this.f1979r = new NotifyingAsyncQueryHandler(getActivity().getContentResolver(), this.f1973d);
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        Cursor cursor = (Cursor) m36e().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        this.f1959A = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f1982u = cursor.getString(cursor.getColumnIndex("inbox_no"));
        this.f1984w = cursor.getString(cursor.getColumnIndex("inbox_title"));
        this.f1985x = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
        this.f1986y = ChatONContract.InBoxTable.ChatType.m2188a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
        this.f1987z = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
        this.f1960B = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
        this.f1967I = cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no"));
        this.f1983v = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
        this.f1961C = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        String string = cursor.getString(cursor.getColumnIndex("buddy_name"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        ChatONLogWriter.m3509d("serverIP:" + this.f1987z);
        ChatONLogWriter.m3509d("serverPort:" + this.f1960B);
        this.f1981t = new ProfileImageView(getActivity());
        this.f1981t.init(this.f1981t, this.f1986y);
        if (this.f1986y == ChatONContract.InBoxTable.ChatType.ONETOONE) {
            ProfileImageLoader.m3610a(getActivity()).m3623a(this.f1981t, this.f1982u);
            this.f1981t.setBuddyNo(this.f1982u);
            if (!string2.equals("Y")) {
                this.f1984w = string;
            }
        } else if (this.f1986y == ChatONContract.InBoxTable.ChatType.BROADCAST) {
            this.f1984w = ChatUtil.m796a(string2, this.f1984w);
        } else if (this.f1961C == 0) {
            this.f1984w = getResources().getString(C0062R.string.chat_title_no_buddies);
        }
        contextMenu.setHeaderTitle(this.f1984w);
        contextMenu.add(C0062R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0260j(this));
        contextMenu.add(C0062R.string.dialog_edit_title).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0261k(this));
        contextMenu.add(C0062R.string.buddy_list_contextual_menu_shortcut).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0262l(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.add(0, 1, 1, C0062R.string.menu_inbox_group_chat).setIcon(C0062R.drawable.group_chat);
        menu.add(0, 2, 2, C0062R.string.menu_inbox_broadcast).setIcon(C0062R.drawable.broadcast);
        if (ChatONPref.m3519a().contains("UpdateIsCritical")) {
            menu.add(0, 4, 4, getResources().getString(C0062R.string.menu_inbox_setting)).setIcon(C0062R.drawable.settings_new);
        } else {
            menu.add(0, 4, 4, C0062R.string.menu_inbox_setting).setIcon(C0062R.drawable.ic_menu_settings);
        }
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C0062R.layout.layout_msgbox, viewGroup, false);
        this.f1974m = (LinearLayout) viewInflate.findViewById(C0062R.id.lLayoutMenu);
        ((Button) this.f1974m.findViewById(C0062R.id.btnLeave)).setOnClickListener(this.f1972c);
        ((Button) this.f1974m.findViewById(C0062R.id.btnCancel)).setOnClickListener(this.f1972c);
        this.f1975n = (ListView) viewInflate.findViewById(R.id.list);
        this.f1976o = new MsgBoxListAdapter(getActivity(), this.f1975n, C0062R.layout.item_msgbox, null);
        this.f1976o.m2412a(this);
        return viewInflate;
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
                m35d().setChoiceMode(2);
                this.f1974m.setVisibility(0);
                break;
            case 4:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getContentResolver().unregisterContentObserver(this.f1971b);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        BuddyFragment buddyFragment = (BuddyFragment) getFragmentManager().mo4a(C0062R.id.fragment_buddy);
        if ((buddyFragment != null ? buddyFragment.m525c() : 0) > 0) {
            menu.findItem(1).setVisible(true).setEnabled(true);
            menu.findItem(2).setVisible(true).setEnabled(true);
        } else {
            menu.findItem(1).setVisible(false).setEnabled(false);
            menu.findItem(2).setVisible(false).setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f1962D) {
            this.f1979r.startQuery(1, null, ChatONContract.InBoxTable.m2184a(), null, "inbox_no!='" + this.f1966H + "'", null, "inbox_last_time DESC");
        } else {
            this.f1979r.startQuery(1, null, ChatONContract.InBoxTable.m2184a(), null, null, null, "inbox_last_time DESC");
        }
        getActivity().getContentResolver().registerContentObserver(ChatONContract.InBoxTable.f1717a, true, this.f1971b);
    }
}
