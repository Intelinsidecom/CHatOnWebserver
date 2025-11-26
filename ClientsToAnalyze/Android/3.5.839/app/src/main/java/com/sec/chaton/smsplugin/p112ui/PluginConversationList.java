package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.AsyncQueryHandler;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SqliteWrapper;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.InterfaceC3889l;
import com.sec.chaton.smsplugin.spam.ManageSpamMessages;
import com.sec.common.p123a.AbstractC4932a;
import java.util.ArrayList;
import java.util.Collection;

@TargetApi(14)
/* loaded from: classes.dex */
public class PluginConversationList extends ListActivity implements InterfaceC3889l {

    /* renamed from: b */
    private C4276gw f15058b;

    /* renamed from: c */
    private C4349p f15059c;

    /* renamed from: d */
    private CharSequence f15060d;

    /* renamed from: e */
    private SharedPreferences f15061e;

    /* renamed from: f */
    private Handler f15062f;

    /* renamed from: g */
    private boolean f15063g;

    /* renamed from: h */
    private TextView f15064h;

    /* renamed from: i */
    private MenuItem f15065i;

    /* renamed from: j */
    private SearchView f15066j;

    /* renamed from: k */
    private ArrayList<ContentProviderOperation> f15067k;

    /* renamed from: l */
    private ArrayList<ContentProviderOperation> f15068l;

    /* renamed from: m */
    private final InterfaceC4350q f15069m = new C4266gm(this);

    /* renamed from: a */
    SearchView.OnQueryTextListener f15057a = new C4268go(this);

    /* renamed from: n */
    private final View.OnCreateContextMenuListener f15070n = new ViewOnCreateContextMenuListenerC4269gp(this);

    /* renamed from: o */
    private final View.OnKeyListener f15071o = new ViewOnKeyListenerC4271gr(this);

    /* renamed from: p */
    private final Runnable f15072p = new RunnableC4272gs(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(5);
        m16135a();
        setContentView(R.layout.conversation_list_screen);
        this.f15058b = new C4276gw(this, getContentResolver());
        ListView listView = getListView();
        listView.setOnCreateContextMenuListener(this.f15070n);
        listView.setOnKeyListener(this.f15071o);
        listView.setChoiceMode(3);
        listView.setMultiChoiceModeListener(new C4275gv(this, null));
        listView.setEmptyView(findViewById(R.id.empty));
        m16145b();
        this.f15060d = getString(R.string.app_label);
        this.f15062f = new Handler();
        this.f15061e = PreferenceManager.getDefaultSharedPreferences(this);
        C3890m.m14994a("PluginConversationList", "checkedMessageLimits: " + this.f15061e.getBoolean("checked_message_limits", false));
        this.f15067k = new ArrayList<>();
        this.f15068l = new ArrayList<>();
    }

    /* renamed from: a */
    private void m16135a() {
        ActionBar actionBar = getActionBar();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.conversation_list_actionbar, (ViewGroup) null);
        actionBar.setDisplayOptions(16, 16);
        actionBar.setCustomView(viewGroup, new ActionBar.LayoutParams(-2, -2, 21));
        this.f15064h = (TextView) viewGroup.findViewById(R.id.unread_conv_count);
    }

    /* renamed from: b */
    private void m16145b() {
        this.f15059c = new C4349p(this, null);
        this.f15059c.m16527a(this.f15069m);
        setListAdapter(this.f15059c);
        getListView().setRecyclerListener(this.f15059c);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        m16147c();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C3887j.m14982c().m14986a((InterfaceC3889l) this);
        this.f15063g = true;
        m16147c();
        if (!C3790i.m14346o()) {
            C3782a.m14210a();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        C3887j.m14982c().m14989b(this);
        getListView().setChoiceMode(3);
        this.f15059c.changeCursor(null);
    }

    @Override // com.sec.chaton.smsplugin.p111h.InterfaceC3889l
    /* renamed from: a */
    public void mo14992a(long j, boolean z) {
        this.f15058b.post(new RunnableC4267gn(this, j, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16147c() {
        try {
            setProgressBarIndeterminateVisibility(true);
            C3790i.m14332b(this.f15058b, 1701);
            C3790i.m14325a(this.f15058b, 1702, "read=0");
        } catch (SQLiteException e) {
            SqliteWrapper.checkSQLiteException(this, e);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.conversation_list_menu, menu);
        this.f15065i = menu.findItem(R.id.search);
        this.f15066j = (SearchView) this.f15065i.getActionView();
        if (this.f15066j != null) {
            this.f15066j.setOnQueryTextListener(this.f15057a);
            this.f15066j.setQueryHint(getString(R.string.search_hint));
            this.f15066j.setIconifiedByDefault(true);
            SearchManager searchManager = (SearchManager) getSystemService("search");
            if (searchManager != null) {
                this.f15066j.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.action_delete_all);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(this.f15059c.getCount() > 0);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.action_debug_dump);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(false);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        this.f15065i.expandActionView();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_compose_new /* 2131166699 */:
                m16149d();
                return false;
            case R.id.action_manage_spam /* 2131166700 */:
                startActivity(new Intent(this, (Class<?>) ManageSpamMessages.class));
                return false;
            case R.id.action_delete_all /* 2131166701 */:
                m16137a(-1L, this.f15058b);
                return false;
            case R.id.action_debug_dump /* 2131166702 */:
                C3811d.m14483a(this);
                return false;
            default:
                return true;
        }
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i, long j) {
        Cursor cursor = (Cursor) getListView().getItemAtPosition(i);
        if (cursor != null) {
            long jM14359d = C3790i.m14318a(this, cursor).m14359d();
            C3890m.m14996b("PluginConversationList", "onListItemClick: pos=" + i + ", view=" + view + ", tid=" + jM14359d);
            m16136a(jM14359d);
        }
    }

    /* renamed from: d */
    private void m16149d() {
        startActivity(PluginComposeMessageActivity.m15925a(this, 0L));
    }

    /* renamed from: a */
    private void m16136a(long j) {
        startActivity(PluginComposeMessageActivity.m15925a(this, j));
    }

    /* renamed from: a */
    public static Intent m16134a(String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        if (Telephony.Mms.isEmailAddress(str)) {
            intent.putExtra("email", str);
        } else {
            intent.putExtra("phone", str);
            intent.putExtra("phone_type", 2);
        }
        intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
        return intent;
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        Cursor cursor = this.f15059c.getCursor();
        if (cursor != null && cursor.getPosition() >= 0) {
            C3790i c3790iM14318a = C3790i.m14318a(this, cursor);
            long jM14359d = c3790iM14318a.m14359d();
            switch (menuItem.getItemId()) {
                case 0:
                    m16137a(jM14359d, this.f15058b);
                    break;
                case 1:
                    m16136a(jM14359d);
                    break;
                case 2:
                    Intent intent = new Intent("android.intent.action.VIEW", c3790iM14318a.m14362g().get(0).m14268j());
                    intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
                    startActivity(intent);
                    break;
                case 3:
                    startActivity(m16134a(c3790iM14318a.m14362g().get(0).m14262d()));
                    break;
            }
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3890m.m14994a("PluginConversationList", "onConfigurationChanged: " + configuration);
    }

    /* renamed from: a */
    public static void m16137a(long j, AsyncQueryHandler asyncQueryHandler) {
        ArrayList arrayList = null;
        if (j != -1) {
            arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
        }
        m16142a(arrayList, asyncQueryHandler);
    }

    /* renamed from: a */
    public static void m16142a(Collection<Long> collection, AsyncQueryHandler asyncQueryHandler) {
        C3790i.m14328a(asyncQueryHandler, collection, 1802);
    }

    /* renamed from: a */
    public static void m16140a(DialogInterfaceOnClickListenerC4273gt dialogInterfaceOnClickListenerC4273gt, Collection<Long> collection, boolean z, Context context) {
        View viewInflate = View.inflate(context, R.layout.delete_thread_dialog_view, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.message);
        if (collection == null) {
            textView.setText(R.string.confirm_delete_all_conversations);
        } else {
            textView.setText(R.string.selected_message_will_be_deleted_in_message_room);
        }
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.delete_locked);
        checkBox.setText(R.string.delete_unlocked);
        if (!z) {
            checkBox.setVisibility(8);
        } else {
            checkBox.setVisibility(0);
            dialogInterfaceOnClickListenerC4273gt.m16479a(checkBox.isChecked());
            checkBox.setOnClickListener(new ViewOnClickListenerC4270gq(dialogInterfaceOnClickListenerC4273gt, checkBox));
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18734a(R.string.delete);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, dialogInterfaceOnClickListenerC4273gt);
        abstractC4932aM18733a.mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16141a(String str, Object... objArr) {
        C3890m.m14996b("PluginConversationList", "[" + Thread.currentThread().getId() + "] " + String.format(str, objArr));
    }
}
