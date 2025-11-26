package com.sec.chaton.smsplugin.spam;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;

@TargetApi(14)
/* loaded from: classes.dex */
public class SetupSpamNumberWriteForm extends Activity {

    /* renamed from: g */
    private static final Intent f14376g = new Intent("android.intent.action.GET_CONTENT");

    /* renamed from: h */
    private static final String[] f14377h;

    /* renamed from: a */
    EditText f14378a;

    /* renamed from: b */
    LinearLayout f14379b;

    /* renamed from: c */
    LayoutInflater f14380c;

    /* renamed from: d */
    Toast f14381d;

    /* renamed from: e */
    TextView f14382e;

    /* renamed from: i */
    private boolean f14384i;

    /* renamed from: j */
    private int f14385j;

    /* renamed from: k */
    private String f14386k;

    /* renamed from: l */
    private int f14387l;

    /* renamed from: m */
    private int f14388m;

    /* renamed from: o */
    private ActionBar f14390o;

    /* renamed from: s */
    private boolean f14394s;

    /* renamed from: n */
    private Handler f14389n = null;

    /* renamed from: p */
    private LinearLayout f14391p = null;

    /* renamed from: q */
    private TextView f14392q = null;

    /* renamed from: r */
    private TextView f14393r = null;

    /* renamed from: t */
    private MenuItem f14395t = null;

    /* renamed from: u */
    private MenuItem f14396u = null;

    /* renamed from: f */
    final String f14383f = "SetupSpamNumberWriteForm";

    /* renamed from: v */
    private final Handler f14397v = new HandlerC4011bo(this);

    static {
        f14376g.setType("vnd.android.cursor.item/phone_v2");
        f14377h = new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1"};
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.form_setup_spam_number_write);
        this.f14394s = getResources().getConfiguration().orientation == 2;
        m15410b();
        this.f14390o = getActionBar();
        if (this.f14390o != null) {
            this.f14390o.setDisplayHomeAsUpEnabled(true);
            this.f14390o.setCustomView(this.f14391p, new ActionBar.LayoutParams(-1, -1));
            this.f14390o.setDisplayShowCustomEnabled(true);
        }
        this.f14381d = Toast.makeText(getApplicationContext(), (CharSequence) null, 0);
        if (bundle != null) {
            C3890m.m14999e("SetupSpamNumberWriteForm", "onCreate  savedInstanceState  mMatchCriteria = " + this.f14387l);
            this.f14387l = bundle.getInt("match_criteria", 0);
        }
        m15405a();
        this.f14384i = getIntent().getBooleanExtra("UPDATE_MODE", false);
        if (this.f14384i) {
            this.f14385j = getIntent().getIntExtra("UPDATE_ID", 0);
            this.f14388m = getIntent().getIntExtra("MATCH_MODE", 0);
            this.f14386k = getIntent().getStringExtra("SELECT_NUMBER");
            this.f14387l = this.f14388m;
            this.f14378a.setText(this.f14386k);
            int length = this.f14378a.length();
            if (length > 0) {
                this.f14378a.setSelection(length);
            }
            String[] stringArray = getResources().getStringArray(R.array.pref_entries_spam_match_criteria);
            this.f14382e = (TextView) findViewById(R.id.text_sub);
            this.f14382e.setText(stringArray[this.f14387l]);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("match_criteria", this.f14387l);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.f14387l = bundle.getInt("match_criteria", 0);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f14389n = new Handler();
        this.f14378a.requestFocus();
        if (this.f14378a.isFocused()) {
            this.f14389n.postDelayed(new RunnableC4006bj(this), 500L);
        }
        m15414d();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14394s = getResources().getConfiguration().orientation == 2;
        m15410b();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /* renamed from: a */
    private void m15405a() throws Resources.NotFoundException {
        this.f14378a = (EditText) findViewById(R.id.edit_text);
        this.f14380c = LayoutInflater.from(this);
        this.f14379b = (LinearLayout) findViewById(R.id.match_criteria_layout);
        this.f14379b.setOnClickListener(new ViewOnClickListenerC4007bk(this));
        String[] stringArray = getResources().getStringArray(R.array.pref_entries_spam_match_criteria);
        this.f14382e = (TextView) findViewById(R.id.text_sub);
        this.f14382e.setText(stringArray[this.f14387l]);
    }

    /* renamed from: b */
    private void m15410b() {
        if (this.f14391p == null) {
            this.f14391p = (LinearLayout) getLayoutInflater().inflate(R.layout.actionbar_delete_message, (ViewGroup) null);
            this.f14392q = (TextView) this.f14391p.findViewById(R.id.delete_message_actionbar_done_btn);
            this.f14393r = (TextView) this.f14391p.findViewById(R.id.delete_message_actionbar_cancel_btn);
            ((TextView) this.f14391p.findViewById(R.id.actionbar_delete_message_title)).setText(getString(R.string.pref_title_register_number));
        }
        if (this.f14392q != null) {
            this.f14392q.setVisibility(8);
        }
        if (this.f14393r != null) {
            this.f14393r.setVisibility(8);
        }
        if (this.f14395t != null) {
            this.f14395t.setEnabled(true);
            this.f14395t.setIcon(R.drawable.actionbar_list_icon_check);
        }
        if (this.f14396u != null) {
            this.f14396u.setEnabled(true);
            this.f14396u.setIcon(R.drawable.selector_actionbar_delete_cancel_button);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws NumberFormatException {
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
        this.f14396u = menu.add(0, 2, 0, R.string.cancel);
        this.f14396u.setShowAsAction(2);
        this.f14395t = menu.add(0, 1, 0, R.string.done);
        this.f14395t.setShowAsAction(2);
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15412c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.spam_msg_match_criteria_menu);
        builder.setCancelable(true);
        builder.setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC4008bl(this));
        builder.setSingleChoiceItems(R.array.pref_entries_spam_match_criteria, this.f14387l, new DialogInterfaceOnClickListenerC4009bm(this));
        builder.create().show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #0 {all -> 0x00b2, blocks: (B:19:0x007d, B:26:0x0095, B:28:0x009f, B:30:0x00a5, B:31:0x00ac, B:21:0x0083), top: B:40:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r10, int r11, android.content.Intent r12) throws java.lang.Throwable {
        /*
            r9 = this;
            r3 = 0
            r0 = -1
            r7 = 0
            r8 = 100
            super.onActivityResult(r10, r11, r12)
            java.lang.String r6 = ""
            switch(r10) {
                case 1: goto L2d;
                case 2: goto L68;
                default: goto Le;
            }
        Le:
            r0 = r6
        Lf:
            android.os.Handler r1 = r9.f14397v
            com.sec.chaton.smsplugin.spam.bn r2 = new com.sec.chaton.smsplugin.spam.bn
            r2.<init>(r9)
            r3 = 200(0xc8, double:9.9E-322)
            r1.postDelayed(r2, r3)
            if (r0 == 0) goto L2c
            int r1 = r0.length()
            if (r1 <= 0) goto L2c
            android.widget.EditText r1 = r9.f14378a
            int r0 = r0.length()
            r1.setSelection(r0)
        L2c:
            return
        L2d:
            if (r11 != r0) goto Le
            java.lang.String r0 = "TEST"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[LogsPickerActivity.onActivityResult] uri:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r12.getDataString()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14997c(r0, r1)
            java.lang.String r0 = "NUMBER"
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r0 = android.telephony.PhoneNumberUtils.stripSeparators(r0)
            int r1 = r0.length()
            if (r1 <= r8) goto L62
            java.lang.String r0 = r0.substring(r3, r8)
        L62:
            android.widget.EditText r1 = r9.f14378a
            r1.setText(r0)
            goto Lf
        L68:
            if (r11 != r0) goto Lb9
            android.content.ContentResolver r0 = r9.getContentResolver()     // Catch: java.lang.Throwable -> Lc5
            android.net.Uri r1 = r12.getData()     // Catch: java.lang.Throwable -> Lc5
            java.lang.String[] r2 = com.sec.chaton.smsplugin.spam.SetupSpamNumberWriteForm.f14377h     // Catch: java.lang.Throwable -> Lc5
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto L83
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> Lb2
            if (r0 != 0) goto L94
        L83:
            java.lang.String r0 = "AutoReject"
            java.lang.String r2 = "onActivityResult: bad contact data, no results found."
            com.sec.chaton.smsplugin.p111h.C3890m.m14997c(r0, r2)     // Catch: java.lang.Throwable -> Lb2
            r0 = r6
        L8d:
            if (r1 == 0) goto Lf
            r1.close()
            goto Lf
        L94:
            r0 = 1
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = android.telephony.PhoneNumberUtils.stripSeparators(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r0 == 0) goto L8d
            int r2 = r0.length()     // Catch: java.lang.Throwable -> Lb2
            if (r2 <= r8) goto Lac
            r2 = 0
            r3 = 100
            java.lang.String r0 = r0.substring(r2, r3)     // Catch: java.lang.Throwable -> Lb2
        Lac:
            android.widget.EditText r2 = r9.f14378a     // Catch: java.lang.Throwable -> Lb2
            r2.setText(r0)     // Catch: java.lang.Throwable -> Lb2
            goto L8d
        Lb2:
            r0 = move-exception
        Lb3:
            if (r1 == 0) goto Lb8
            r1.close()
        Lb8:
            throw r0
        Lb9:
            java.lang.String r0 = "AutoReject"
            java.lang.String r1 = "onActivityResult: cancelled."
            com.sec.chaton.smsplugin.p111h.C3890m.m14997c(r0, r1)
            r0 = r6
            goto Lf
        Lc5:
            r0 = move-exception
            r1 = r7
            goto Lb3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.spam.SetupSpamNumberWriteForm.onActivityResult(int, int, android.content.Intent):void");
    }

    public void softkeyLeftRun(View view) throws NumberFormatException {
        if (this.f14378a.getText().length() == 0) {
            m15413c(getString(R.string.spam_number_save_empty));
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f14378a.getWindowToken(), 1);
            return;
        }
        if (m15408a(this.f14378a.getText().toString())) {
            String string = null;
            switch (this.f14387l) {
                case 0:
                    string = getString(R.string.Dialog_ExactlyTheSameAs);
                    break;
                case 1:
                    string = getString(R.string.Dialog_StartWith);
                    break;
                case 2:
                    string = getString(R.string.Dialog_EndsWith);
                    break;
                case 3:
                    string = getString(R.string.Dialog_Includes);
                    break;
            }
            m15413c(this.f14378a.getText().toString() + " ( " + string + " ) \n" + getString(R.string.spam_number_save_already));
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f14378a.getWindowToken(), 0);
            return;
        }
        if (!m15411b(this.f14378a.getText().toString())) {
            m15413c(getString(R.string.spam_number_save_invalid));
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f14378a.getWindowToken(), 0);
            return;
        }
        if (this.f14384i) {
            m15407a(this.f14378a.getText().toString(), 1, Integer.valueOf(this.f14387l), this.f14385j);
        } else {
            m15404a(this.f14378a.getText().toString(), this.f14387l);
        }
        setResult(-1, getIntent());
        finish();
    }

    public void softkeyRightRun(View view) {
        setResult(0, null);
        finish();
    }

    /* renamed from: a */
    private boolean m15408a(String str) {
        boolean z;
        boolean z2 = true;
        if ("".equals(str)) {
            return false;
        }
        Cursor cursorQuery = getContentResolver().query(C4012bp.f14468d, null, "filter_type =0 AND filter ='" + str + "'", null, null);
        if (cursorQuery == null) {
            C3890m.m14997c("SetupSpamNumberWriteForm", "checkAlreadyInUse : false, cursor is null");
            return false;
        }
        cursorQuery.moveToFirst();
        if (cursorQuery.getCount() == 0) {
            z2 = false;
        } else if (!this.f14384i) {
            C3890m.m14997c("SetupSpamNumberWriteForm", "checkAlreadyInUse : true, insert mode, number is duplicated");
        } else {
            if (this.f14385j == cursorQuery.getInt(0)) {
                z = false;
            } else {
                C3890m.m14997c("SetupSpamNumberWriteForm", "checkAlreadyInUse : true, update mode, number is duplicated");
                z = true;
            }
            z2 = z;
        }
        cursorQuery.close();
        return z2;
    }

    /* renamed from: b */
    private boolean m15411b(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!PhoneNumberUtils.isReallyDialable(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private void m15413c(String str) {
        if (this.f14381d != null) {
            this.f14381d.setText(str);
            this.f14381d.show();
        }
    }

    /* renamed from: a */
    private void m15407a(String str, Integer num, Integer num2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter", str);
        contentValues.put("enable", num);
        contentValues.put("criteria", num2);
        getContentResolver().update(Uri.withAppendedPath(C4012bp.f14468d, Integer.toString(i)), contentValues, null, null);
        C4015bs.m15436a(i, str, num.intValue() != 0, num2.intValue());
    }

    /* renamed from: a */
    private int m15404a(String str, int i) throws NumberFormatException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter_type", (Integer) 0);
        contentValues.put("filter", str);
        contentValues.put("enable", (Integer) 1);
        contentValues.put("criteria", Integer.valueOf(i));
        Uri uriInsert = getContentResolver().insert(C4012bp.f14468d, contentValues);
        if (uriInsert == null) {
            return 0;
        }
        int i2 = Integer.parseInt(uriInsert.getLastPathSegment());
        C4015bs.m15433a(i2, new C4017bu(i2, 0, true, str, i));
        return i2;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C4904y.m18639b("onUserLeaveHint", getClass().getSimpleName());
    }

    /* renamed from: d */
    private void m15414d() {
        C4904y.m18639b("showAgainPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C4892m.m18575b(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            C4892m.m18577c(false);
            startActivity(intent);
        }
    }
}
