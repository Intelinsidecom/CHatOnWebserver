package com.sec.chaton.smsplugin.spam;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.common.CommonApplication;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5097t;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class ManageSpamMessages extends Activity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnCreateContextMenuListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    static final String[] f14283a = {"transport_type", "_id", "address", "body", "date", "read", "type", "status", "sub", "sub_cs", "m_type", "msg_box", "d_rpt", "rr", "err_type", "locked", "date"};

    /* renamed from: b */
    private int f14284b;

    /* renamed from: c */
    private ContentResolver f14285c;

    /* renamed from: d */
    private ListView f14286d;

    /* renamed from: e */
    private LinearLayout f14287e;

    /* renamed from: h */
    private int f14290h;

    /* renamed from: i */
    private LinearLayout f14291i;

    /* renamed from: j */
    private CheckBox f14292j;

    /* renamed from: l */
    private Toast f14294l;

    /* renamed from: f */
    private C4018bv f14288f = null;

    /* renamed from: g */
    private AsyncQueryHandler f14289g = null;

    /* renamed from: k */
    private ProgressDialog f14293k = null;

    /* renamed from: m */
    private int f14295m = -1;

    /* renamed from: n */
    private final View.OnCreateContextMenuListener f14296n = new ViewOnCreateContextMenuListenerC4028f(this);

    /* renamed from: o */
    private AlertDialog f14297o = null;

    /* renamed from: p */
    private final Handler f14298p = new HandlerC4033k(this);

    /* renamed from: q */
    private boolean f14299q = true;

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, C4012bp.f14469e, f14283a, null, null, null);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f14288f.swapCursor(cursor);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        this.f14288f.swapCursor(null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(9);
        this.f14285c = getContentResolver();
        this.f14289g = new C4035m(this, this.f14285c, this);
        setContentView(R.layout.spam_list);
        this.f14286d = (ListView) findViewById(R.id.spam_messages);
        this.f14287e = (LinearLayout) findViewById(R.id.spam_empty_message);
        this.f14291i = (LinearLayout) findViewById(R.id.select_all_layout);
        this.f14292j = (CheckBox) findViewById(R.id.thread_delete_cb_selectall);
        this.f14291i.setVisibility(8);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.f14286d.setOnKeyListener(new ViewOnKeyListenerC3969a(this));
        this.f14291i.setOnKeyListener(new ViewOnKeyListenerC4023c(this));
        this.f14292j.setOnCheckedChangeListener(this);
        ((LinearLayout) findViewById(R.id.select_all_layout)).setOnClickListener(new ViewOnClickListenerC4024d(this));
        this.f14286d.setOnCreateContextMenuListener(this.f14296n);
        this.f14293k = new ProgressDialog(this);
        this.f14293k.setIndeterminate(true);
        this.f14293k.setCancelable(false);
        this.f14293k.setOnKeyListener(new DialogInterfaceOnKeyListenerC4027e(this));
        this.f14294l = Toast.makeText(CommonApplication.m18732r(), "", 0);
        m15297b(2);
    }

    /* renamed from: a */
    public void m15315a(boolean z, View view) {
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStart() {
        C3890m.m14996b("Mms/ManageSpamMessages", "onStart()");
        super.onStart();
        C3782a.m14210a();
        m15296b();
        C3890m.m14996b("Mms/ManageSpamMessages", "onStart()");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        m15285a();
        m15296b();
    }

    /* renamed from: a */
    private void m15285a() {
        C3890m.m14996b("Mms/ManageSpamMessages", "init()");
        m15297b(2);
        m15296b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15296b() {
        C3890m.m14996b("Mms/ManageSpamMessages", "startQuery()");
        try {
            this.f14289g.startQuery(0, null, C4012bp.f14469e, C4018bv.f14488a, null, null, "normalized_date DESC");
        } catch (SQLiteException e) {
            SqliteWrapper.checkSQLiteException(this, e);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3890m.m14996b("Mms/ManageSpamMessages", "onConfigurationChanged: " + configuration);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.f14295m < 0) {
            return false;
        }
        Cursor cursor = (Cursor) this.f14288f.getItem(this.f14295m);
        switch (menuItem.getItemId()) {
            case 0:
                if (!m15292a(cursor)) {
                    Toast.makeText(this, getString(R.string.status_failed), 1).show();
                } else {
                    Toast.makeText(this, getString(R.string.spam_restore_complete), 0).show();
                }
                return true;
            case 1:
                m15286a(new DialogInterfaceOnClickListenerC4029g(this, cursor.getString(cursor.getColumnIndexOrThrow("transport_type")), cursor.getLong(cursor.getColumnIndexOrThrow("_id"))), R.string.delete_check);
                return true;
            case 2:
                m15304c(cursor);
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f14288f != null) {
            this.f14288f.m15467a();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f14289g = null;
        this.f14292j.setOnCheckedChangeListener(null);
        if (this.f14288f != null && this.f14288f.getCursor() != null) {
            this.f14288f.getCursor().close();
        }
    }

    /* renamed from: a */
    private boolean m15292a(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        try {
            String string = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("body"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("date"));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("transport_type"));
            long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            try {
                if ("sms".equals(string3)) {
                    Telephony.Sms.Inbox.addMessage(this.f14285c, string, string2, null, Long.valueOf(j), true);
                    m15298b(cursor);
                } else if ("mms".equals(string3)) {
                    C5097t c5097tM19426a = C5097t.m19426a(this);
                    try {
                        c5097tM19426a.m19447a(c5097tM19426a.m19449a(ContentUris.withAppendedId(C4012bp.f14473i, j2)), Telephony.Mms.Inbox.CONTENT_URI);
                        m15298b(cursor);
                    } catch (C5111c e) {
                        C3890m.m14999e("Mms/ManageSpamMessages", "MMS restore failed !!!! MmsException =" + e);
                        return false;
                    }
                }
                return true;
            } catch (SQLiteException e2) {
                SqliteWrapper.checkSQLiteException(this, e2);
                return false;
            }
        } catch (CursorIndexOutOfBoundsException e3) {
            C3890m.m14996b("Mms/ManageSpamMessages", "restoreToInbox() total count : " + cursor.getCount() + "current position : " + cursor.getPosition());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15293a(C4034l c4034l) {
        try {
            if ("mms".equals(c4034l.m15505b()) || "mms".equals(c4034l.m15509f())) {
                C3890m.m14996b("Mms/ManageSpamMessages", "Restore mms to inbox : " + c4034l.m15504a());
                C5097t c5097tM19426a = C5097t.m19426a(this);
                try {
                    c5097tM19426a.m19447a(c5097tM19426a.m19449a(ContentUris.withAppendedId(C4012bp.f14473i, c4034l.m15504a())), Telephony.Mms.Inbox.CONTENT_URI);
                    m15299b(c4034l);
                } catch (C5111c e) {
                    C3890m.m14999e("Mms/ManageSpamMessages", "MMS restore failed !!!! MmsException =" + e);
                    return false;
                }
            } else if ("sms".equals(c4034l.m15509f())) {
                C3890m.m14996b("Mms/ManageSpamMessages", "Restore sms to inbox : " + c4034l.m15504a());
                Telephony.Sms.Inbox.addMessage(this.f14285c, c4034l.m15506c(), c4034l.m15507d(), null, Long.valueOf(c4034l.m15508e()), true);
                m15299b(c4034l);
            }
            return true;
        } catch (SQLiteException e2) {
            SqliteWrapper.checkSQLiteException(this, e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15299b(C4034l c4034l) {
        Uri uriWithAppendedId;
        String strM15505b = c4034l.m15505b();
        long jM15504a = c4034l.m15504a();
        if ("mms".equals(strM15505b)) {
            uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14473i, jM15504a);
        } else if ("wpm".equals(strM15505b)) {
            uriWithAppendedId = ContentUris.withAppendedId(C4149cd.f15440a, jM15504a);
        } else {
            uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14470f, jM15504a);
            C3890m.m14999e("Mms/ManageSpamMessages", "Spam_Soyeon delete uri= " + uriWithAppendedId);
        }
        SqliteWrapper.delete(this, this.f14285c, uriWithAppendedId, (String) null, (String[]) null);
    }

    /* renamed from: b */
    private void m15298b(Cursor cursor) {
        Uri uriWithAppendedId;
        if (!cursor.isClosed()) {
            String string = cursor.getString(cursor.getColumnIndexOrThrow("transport_type"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            if ("mms".equals(string)) {
                uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14473i, j);
            } else if ("wpm".equals(string)) {
                uriWithAppendedId = ContentUris.withAppendedId(C4149cd.f15440a, j);
            } else {
                uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14470f, j);
            }
            SqliteWrapper.delete(this, this.f14285c, uriWithAppendedId, (String) null, (String[]) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15291a(String str, long j) {
        Uri uriWithAppendedId;
        if ("mms".equals(str)) {
            uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14473i, j);
        } else if ("wpm".equals(str)) {
            uriWithAppendedId = ContentUris.withAppendedId(C4149cd.f15440a, j);
        } else {
            uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14470f, j);
        }
        SqliteWrapper.delete(this, this.f14285c, uriWithAppendedId, (String) null, (String[]) null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, R.string.spam_restore_menu).setIcon(R.drawable.list_icon_create).setVisible(false);
        menu.add(0, 2, 1, R.string.delete).setIcon(R.drawable.header_button_icon_delete).setVisible(false);
        menu.add(0, 3, 1, R.string.ok).setIcon(R.drawable.actionbar_list_icon_check).setShowAsActionFlags(1).setVisible(false);
        menu.add(0, 4, 1, R.string.cancel).setIcon(R.drawable.header_button_icon_cancel).setShowAsActionFlags(1).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(3).setEnabled(((this.f14288f == null || this.f14288f.m15469b() == null) ? 0 : this.f14288f.m15471c()) > 0);
        if (this.f14288f != null && this.f14288f.getCount() > 0 && this.f14284b == 0) {
            menu.findItem(1).setVisible(this.f14290h == 0);
            menu.findItem(2).setVisible(this.f14290h == 0);
            menu.findItem(3).setVisible(this.f14290h != 0);
            menu.findItem(4).setVisible(this.f14290h != 0);
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m15313a(2);
                return true;
            case 2:
                m15313a(1);
                return true;
            case 3:
                if (this.f14288f.m15471c() > 0) {
                    Cursor cursor = this.f14288f.getCursor();
                    ArrayList<Integer> arrayListM15469b = this.f14288f.m15469b();
                    if (this.f14290h == 1) {
                        DialogInterfaceOnClickListenerC4030h dialogInterfaceOnClickListenerC4030h = new DialogInterfaceOnClickListenerC4030h(this, arrayListM15469b, cursor);
                        if (arrayListM15469b.size() > 1) {
                            m15287a(dialogInterfaceOnClickListenerC4030h, R.string.menu_delete_messages, arrayListM15469b.size());
                        } else {
                            m15286a(dialogInterfaceOnClickListenerC4030h, R.string.menu_delete_message);
                        }
                    } else if (this.f14290h == 2) {
                        m15303c(R.string.spam_restore_doing);
                        new Thread(new RunnableC4032j(this, arrayListM15469b, cursor)).start();
                    }
                }
                return true;
            case 4:
                m15313a(0);
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private void m15286a(DialogInterface.OnClickListener onClickListener, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_dialog_title);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.ok_button, onClickListener);
        builder.setNegativeButton(R.string.cb_cancel, (DialogInterface.OnClickListener) null);
        builder.setMessage(i);
        this.f14297o = builder.create();
        this.f14297o.show();
    }

    /* renamed from: a */
    private void m15287a(DialogInterface.OnClickListener onClickListener, int i, int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_dialog_title);
        builder.setIconAttribute(android.R.attr.alertDialogIcon);
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.ok_button, onClickListener);
        builder.setNegativeButton(R.string.cb_cancel, (DialogInterface.OnClickListener) null);
        builder.setMessage(String.format(getString(i), Integer.valueOf(i2)));
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15297b(int i) {
        if (this.f14284b != i) {
            this.f14284b = i;
            switch (i) {
                case 0:
                    this.f14286d.setVisibility(0);
                    this.f14287e.setVisibility(8);
                    m15302c();
                    break;
                case 1:
                    this.f14286d.setVisibility(8);
                    this.f14287e.setVisibility(0);
                    m15302c();
                    break;
                case 2:
                    this.f14286d.setVisibility(8);
                    this.f14287e.setVisibility(8);
                    setTitle(getString(R.string.refreshing));
                    break;
                default:
                    C3890m.m14999e("Mms/ManageSpamMessages", "Invalid State");
                    break;
            }
            invalidateOptionsMenu();
        }
    }

    /* renamed from: c */
    private void m15304c(Cursor cursor) {
    }

    /* renamed from: a */
    public void m15313a(int i) {
        this.f14290h = i;
        if (this.f14290h == 0) {
            this.f14291i.setVisibility(8);
        }
        m15285a();
        m15296b();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f14288f != null) {
            if (compoundButton.getId() == R.id.thread_delete_cb_selectall) {
                if (this.f14292j.isChecked()) {
                    if (this.f14288f.m15471c() != this.f14288f.getCount()) {
                        for (int i = 0; i < this.f14288f.getCount(); i++) {
                            this.f14288f.m15470b(i);
                        }
                    }
                } else {
                    if (this.f14299q) {
                        this.f14288f.m15473d();
                    }
                    this.f14299q = true;
                }
            } else if (compoundButton.getId() == R.id.spam_list_item_checkbox) {
                if (compoundButton.isChecked()) {
                    this.f14288f.m15470b(((Integer) compoundButton.getTag()).intValue());
                    if (this.f14288f.m15471c() == this.f14288f.getCount()) {
                        this.f14292j.setChecked(true);
                    }
                } else {
                    this.f14288f.m15472c(((Integer) compoundButton.getTag()).intValue());
                    if (this.f14292j.isChecked()) {
                        this.f14299q = false;
                        this.f14292j.setChecked(false);
                    }
                }
            }
            this.f14288f.notifyDataSetChanged();
            invalidateOptionsMenu();
        }
    }

    /* renamed from: c */
    private void m15302c() {
        switch (this.f14290h) {
            case 0:
                setTitle(getResources().getString(R.string.msg_conversation_list_menu_spam));
                if (this.f14286d != null) {
                    this.f14286d.setNextFocusUpId(R.id.messages);
                    break;
                }
                break;
            case 1:
                setTitle(getResources().getString(R.string.delete));
                if (this.f14286d != null) {
                    this.f14286d.setNextFocusUpId(R.id.select_all_layout);
                    break;
                }
                break;
            case 2:
                setTitle(getResources().getString(R.string.spam_restore_menu));
                if (this.f14286d != null) {
                    this.f14286d.setNextFocusUpId(R.id.select_all_layout);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15303c(int i) {
        this.f14293k = new ProgressDialog(this);
        this.f14293k.setIndeterminate(true);
        this.f14293k.setCancelable(false);
        this.f14293k.setMessage(getString(i));
        this.f14293k.setOnKeyListener(new DialogInterfaceOnKeyListenerC3996b(this));
        this.f14293k.show();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f14290h != 0) {
            m15313a(0);
            return true;
        }
        if (i == 20 && this.f14286d != null && !this.f14286d.isFocused() && this.f14290h == 0) {
            this.f14286d.requestFocus();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
