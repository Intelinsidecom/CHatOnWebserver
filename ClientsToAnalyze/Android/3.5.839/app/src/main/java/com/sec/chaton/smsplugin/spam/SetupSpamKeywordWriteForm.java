package com.sec.chaton.smsplugin.spam;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemProperties;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.google.android.p134a.p136b.C5110f;

@TargetApi(14)
/* loaded from: classes.dex */
public class SetupSpamKeywordWriteForm extends Activity {

    /* renamed from: e */
    private EditText f14330e;

    /* renamed from: f */
    private AlertDialog f14331f;

    /* renamed from: g */
    private boolean f14332g;

    /* renamed from: j */
    private ActionBar f14335j;

    /* renamed from: n */
    private boolean f14339n;

    /* renamed from: a */
    String f14326a = "";

    /* renamed from: b */
    int f14327b = 0;

    /* renamed from: c */
    int f14328c = -1;

    /* renamed from: d */
    TextView f14329d = null;

    /* renamed from: h */
    private long f14333h = 0;

    /* renamed from: i */
    private Handler f14334i = null;

    /* renamed from: k */
    private LinearLayout f14336k = null;

    /* renamed from: l */
    private TextView f14337l = null;

    /* renamed from: m */
    private TextView f14338m = null;

    /* renamed from: o */
    private MenuItem f14340o = null;

    /* renamed from: p */
    private MenuItem f14341p = null;

    /* renamed from: q */
    private final TextWatcher f14342q = new C3979aj(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.form_setup_spam_keyword_write);
        this.f14339n = getResources().getConfiguration().orientation == 2;
        m15354b();
        this.f14335j = getActionBar();
        if (this.f14335j != null) {
            this.f14335j.setDisplayHomeAsUpEnabled(true);
            this.f14335j.setCustomView(this.f14336k, new ActionBar.LayoutParams(-1, -1));
            this.f14335j.setDisplayShowCustomEnabled(true);
        }
        m15350a();
        Intent intent = getIntent();
        this.f14332g = intent.getBooleanExtra("UPDATE_MODE", false);
        if (this.f14332g) {
            this.f14326a = intent.getStringExtra("SpamWord");
            this.f14330e.setText(this.f14326a);
            this.f14330e.setSelection(this.f14326a.length(), this.f14326a.length());
            this.f14328c = intent.getIntExtra("UPDATE_ID", 0);
        }
        this.f14327b = intent.getIntExtra("SpamCriteria", 0);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f14334i = new Handler();
        this.f14330e.requestFocus();
        if (this.f14330e.isFocused()) {
            this.f14334i.postDelayed(new RunnableC3976ag(this), 500L);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f14330e.getWindowToken(), 0);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                softkeyLeftRun(null);
                return true;
            case 2:
                softkeyRightRun(null);
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        this.f14341p = menu.add(0, 2, 0, R.string.cancel);
        this.f14341p.setShowAsAction(2);
        this.f14340o = menu.add(0, 1, 0, R.string.save);
        this.f14340o.setShowAsAction(2);
        this.f14341p.setIcon(R.drawable.selector_actionbar_delete_cancel_button);
        this.f14340o.setIcon(R.drawable.selector_actionbar_delete_done_button);
        return super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    private void m15350a() {
        this.f14330e = (EditText) findViewById(R.id.spam_keyword_text);
        this.f14330e.setFocusable(true);
        this.f14330e.addTextChangedListener(this.f14342q);
    }

    /* renamed from: b */
    private void m15354b() {
        if (this.f14336k == null) {
            this.f14336k = (LinearLayout) getLayoutInflater().inflate(R.layout.actionbar_delete_message, (ViewGroup) null);
            this.f14337l = (TextView) this.f14336k.findViewById(R.id.delete_message_actionbar_done_btn);
            this.f14338m = (TextView) this.f14336k.findViewById(R.id.delete_message_actionbar_cancel_btn);
            if (this.f14336k != null) {
                ((TextView) this.f14336k.findViewById(R.id.actionbar_delete_message_title)).setText(getString(R.string.spam_keyword_blockphrases));
            }
        }
        if (this.f14337l != null) {
            this.f14337l.setVisibility(8);
        }
        if (this.f14338m != null) {
            this.f14338m.setVisibility(8);
        }
        if (this.f14340o != null) {
            this.f14340o.setEnabled(true);
            if (this.f14339n) {
                this.f14340o.setIcon(R.drawable.actionbar_list_icon_check);
            } else {
                this.f14340o.setIcon(0);
            }
        }
        if (this.f14341p != null) {
            this.f14341p.setEnabled(true);
            if (this.f14339n) {
                this.f14341p.setIcon(R.drawable.selector_actionbar_delete_cancel_button);
            } else {
                this.f14341p.setIcon(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15352a(String str) throws NumberFormatException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter_type", (Integer) 1);
        contentValues.put("filter", str);
        contentValues.put("criteria", (Integer) 0);
        contentValues.put("enable", (Integer) 1);
        Uri uriM19498a = C5110f.m19498a(this, getContentResolver(), C4012bp.f14468d, contentValues);
        if (uriM19498a != null && uriM19498a.getPathSegments() != null) {
            int i = Integer.parseInt(uriM19498a.getPathSegments().get(1));
            C4015bs.m15433a(i, new C4017bu(i, 1, true, str, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15357c() {
        ContentValues contentValues = new ContentValues();
        String strTrim = this.f14330e.getText().toString().trim();
        contentValues.put("filter", strTrim);
        getContentResolver().update(Uri.withAppendedPath(C4012bp.f14468d, Integer.toString(this.f14328c)), contentValues, null, null);
        C4015bs.m15434a(this.f14328c, strTrim);
    }

    /* renamed from: b */
    private int m15353b(String str) {
        ContentResolver contentResolver = getContentResolver();
        StringBuilder sb = new StringBuilder();
        sb.append("filter_type = 1 AND filter = ");
        DatabaseUtils.appendEscapedSQLString(sb, str);
        Cursor cursorQuery = contentResolver.query(C4012bp.f14468d, null, sb.toString(), null, null);
        if (cursorQuery == null) {
            return 0;
        }
        cursorQuery.moveToFirst();
        int count = cursorQuery.getCount();
        cursorQuery.close();
        return count;
    }

    public void softkeyLeftRun(View view) {
        String string = this.f14330e.getText().toString();
        int iM16443l = C4149cd.m16443l(string);
        if (string.trim().length() == 0) {
            showDialog(2);
            return;
        }
        if (iM16443l < 4) {
            showDialog(1);
        } else if (m15353b(string) > 0) {
            showDialog(3);
        } else {
            m15361a(4, R.string.alert_inform, string);
        }
    }

    public void softkeyRightRun(View view) {
        setResult(0, null);
        finish();
    }

    /* renamed from: a */
    public void m15361a(int i, int i2, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(i2);
        builder.setMessage(String.format(getResources().getString(R.string.spam_keyword_rev_description), "'" + str + "'"));
        builder.setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC3978ai(this)).setNegativeButton(R.string.no, new DialogInterfaceOnClickListenerC3977ah(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m15358d() {
        Cursor cursorQuery = getContentResolver().query(C4012bp.f14468d, null, "filter_type = 1", null, null);
        if (cursorQuery == null) {
            return 0;
        }
        int count = cursorQuery.getCount();
        if (cursorQuery != null) {
            cursorQuery.close();
            return count;
        }
        return count;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 82:
                if (keyEvent.isLongPress()) {
                    return true;
                }
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        String str = SystemProperties.get("ro.csc.sales_code");
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle(getResources().getString(R.string.alert_inform));
                if (str != null && (str.equals("CHN") || str.equals("CHU") || str.equals("CHM"))) {
                    builder.setMessage(getResources().getString(R.string.spam_keyword_input_alert_chinese));
                } else {
                    builder.setMessage(getResources().getString(R.string.spam_keyword_input_alert));
                }
                builder.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
                this.f14331f = builder.create();
                return this.f14331f;
            case 2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setIcon(android.R.drawable.ic_dialog_alert);
                builder2.setTitle(R.string.alert_inform);
                builder2.setMessage(getResources().getString(R.string.spam_keyword_validation_alert));
                builder2.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
                this.f14331f = builder2.create();
                return this.f14331f;
            case 3:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setIcon(android.R.drawable.ic_dialog_alert);
                builder3.setTitle(R.string.alert_inform);
                builder3.setMessage(getResources().getString(R.string.spam_keyword_already_alert));
                builder3.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
                this.f14331f = builder3.create();
                return this.f14331f;
            case 4:
            default:
                return null;
            case 5:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setIcon(android.R.drawable.ic_dialog_alert);
                builder4.setTitle(R.string.alert_inform);
                builder4.setMessage(getResources().getString(R.string.spam_keyword_max_message));
                builder4.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC3980ak(this));
                builder4.setOnCancelListener(new DialogInterfaceOnCancelListenerC3981al(this));
                this.f14331f = builder4.create();
                return this.f14331f;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14339n = getResources().getConfiguration().orientation == 2;
        m15354b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return true;
    }
}
