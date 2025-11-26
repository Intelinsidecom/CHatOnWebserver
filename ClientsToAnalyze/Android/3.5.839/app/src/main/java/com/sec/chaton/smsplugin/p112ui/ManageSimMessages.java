package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* loaded from: classes.dex */
public class ManageSimMessages extends Activity implements View.OnCreateContextMenuListener {

    /* renamed from: a */
    private static final Uri f14785a = Uri.parse("content://sms/icc");

    /* renamed from: b */
    private int f14786b;

    /* renamed from: c */
    private ContentResolver f14787c;

    /* renamed from: e */
    private ListView f14789e;

    /* renamed from: f */
    private TextView f14790f;

    /* renamed from: d */
    private Cursor f14788d = null;

    /* renamed from: g */
    private C4110as f14791g = null;

    /* renamed from: h */
    private AsyncQueryHandler f14792h = null;

    /* renamed from: i */
    private final ContentObserver f14793i = new C4104am(this, new Handler());

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(5);
        this.f14787c = getContentResolver();
        this.f14792h = new C4107ap(this, this.f14787c, this);
        setContentView(R.layout.sim_list);
        this.f14789e = (ListView) findViewById(R.id.messages);
        this.f14790f = (TextView) findViewById(R.id.empty_message);
        m15773a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        m15773a();
    }

    /* renamed from: a */
    private void m15773a() {
        m15774a(2);
        m15780b();
    }

    /* renamed from: b */
    private void m15780b() {
        try {
            this.f14792h.startQuery(0, null, f14785a, null, null, null, null);
        } catch (SQLiteException e) {
            SqliteWrapper.checkSQLiteException(this, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15784c() {
        m15774a(2);
        if (this.f14788d != null) {
            stopManagingCursor(this.f14788d);
            this.f14788d.close();
        }
        m15780b();
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, R.string.sim_copy_to_phone_memory);
        contextMenu.add(0, 1, 0, R.string.sim_delete);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        try {
            Cursor cursor = (Cursor) this.f14791g.getItem(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
            switch (menuItem.getItemId()) {
                case 0:
                    m15776a(cursor);
                    return true;
                case 1:
                    m15775a(new DialogInterfaceOnClickListenerC4105an(this, cursor), R.string.confirm_delete_SIM_message);
                    return true;
                case 2:
                    m15788d(cursor);
                    return true;
                default:
                    return super.onContextItemSelected(menuItem);
            }
        } catch (ClassCastException e) {
            C3890m.m14995a("ManageSimMessages", "Bad menuInfo.", e);
            return false;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        m15787d();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f14787c.unregisterContentObserver(this.f14793i);
    }

    /* renamed from: d */
    private void m15787d() {
        this.f14787c.registerContentObserver(f14785a, true, this.f14793i);
    }

    /* renamed from: a */
    private void m15776a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndexOrThrow("address"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("date")));
        try {
            if (m15782b(cursor)) {
                Telephony.Sms.Inbox.addMessage(this.f14787c, string, string2, null, lValueOf, true);
            } else {
                Telephony.Sms.Sent.addMessage(this.f14787c, string, string2, null, lValueOf);
            }
        } catch (SQLiteException e) {
            SqliteWrapper.checkSQLiteException(this, e);
        }
    }

    /* renamed from: b */
    private boolean m15782b(Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
        return i == 1 || i == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15785c(Cursor cursor) {
        SqliteWrapper.delete(this, this.f14787c, f14785a.buildUpon().appendPath(cursor.getString(cursor.getColumnIndexOrThrow("index_on_icc"))).build(), (String) null, (String[]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m15789e() {
        Cursor cursor = this.f14791g.getCursor();
        if (cursor != null && cursor.moveToFirst()) {
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                m15785c(cursor);
                cursor.moveToNext();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if (this.f14788d != null && this.f14788d.getCount() > 0 && this.f14786b == 0) {
            menu.add(0, 0, 0, R.string.menu_delete_messages).setIcon(android.R.drawable.ic_menu_delete);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 0:
                m15775a(new DialogInterfaceOnClickListenerC4106ao(this), R.string.confirm_delete_all_SIM_messages);
                break;
        }
        return true;
    }

    /* renamed from: a */
    private void m15775a(DialogInterface.OnClickListener onClickListener, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm_dialog_title);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.yes, onClickListener);
        builder.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        builder.setMessage(i);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15774a(int i) {
        if (this.f14786b != i) {
            this.f14786b = i;
            switch (i) {
                case 0:
                    this.f14789e.setVisibility(0);
                    this.f14790f.setVisibility(8);
                    setTitle(getString(R.string.sim_manage_messages_title));
                    setProgressBarIndeterminateVisibility(false);
                    this.f14789e.requestFocus();
                    break;
                case 1:
                    this.f14789e.setVisibility(8);
                    this.f14790f.setVisibility(0);
                    setTitle(getString(R.string.sim_manage_messages_title));
                    setProgressBarIndeterminateVisibility(false);
                    break;
                case 2:
                    this.f14789e.setVisibility(8);
                    this.f14790f.setVisibility(8);
                    setTitle(getString(R.string.refreshing));
                    setProgressBarIndeterminateVisibility(true);
                    break;
                default:
                    C3890m.m14999e("ManageSimMessages", "Invalid State");
                    break;
            }
        }
    }

    /* renamed from: d */
    private void m15788d(Cursor cursor) {
    }
}
