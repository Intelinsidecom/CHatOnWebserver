package com.sec.chaton.settings;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ActivityPasswordLockSet extends Activity {

    /* renamed from: a */
    private static String f4519a = ActivityPasswordLockSet.class.getSimpleName();

    /* renamed from: k */
    private int f4529k;

    /* renamed from: m */
    private String f4531m;

    /* renamed from: p */
    private Button f4534p;

    /* renamed from: q */
    private Context f4535q;

    /* renamed from: t */
    private TextView f4538t;

    /* renamed from: u */
    private int f4539u;

    /* renamed from: v */
    private int f4540v;

    /* renamed from: b */
    private TextView[] f4520b = new TextView[4];

    /* renamed from: c */
    private int[] f4521c = {R.id.keypad_0, R.id.keypad_1, R.id.keypad_2, R.id.keypad_3, R.id.keypad_4, R.id.keypad_5, R.id.keypad_6, R.id.keypad_7, R.id.keypad_8, R.id.keypad_9, R.id.keypad_back};

    /* renamed from: d */
    private int[] f4522d = {R.id.code_1, R.id.code_2, R.id.code_3, R.id.code_4};

    /* renamed from: e */
    private String f4523e = "";

    /* renamed from: f */
    private String[] f4524f = new String[2];

    /* renamed from: g */
    private int f4525g = 0;

    /* renamed from: h */
    private int f4526h = 0;

    /* renamed from: i */
    private int f4527i = 0;

    /* renamed from: j */
    private int f4528j = 0;

    /* renamed from: l */
    private int f4530l = 1;

    /* renamed from: n */
    private int f4532n = 0;

    /* renamed from: o */
    private String f4533o = "";

    /* renamed from: r */
    private ProgressDialog f4536r = null;

    /* renamed from: s */
    private final int f4537s = 0;

    /* renamed from: w */
    private String f4541w = "";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws NumberFormatException {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
        setContentView(R.layout.layout_password_lock);
        this.f4534p = (Button) findViewById(R.id.keypad_cancel);
        this.f4538t = (TextView) findViewById(R.id.description);
        this.f4535q = this;
        try {
            this.f4523e = getIntent().getExtras().get("MODE").toString();
            C1786r.m6061b("MODE : " + this.f4523e, f4519a);
        } catch (Exception e) {
            C1786r.m6061b("error : " + e.toString(), f4519a);
        }
        m4535a();
        for (int i = 0; i < 4; i++) {
            this.f4520b[i] = (TextView) findViewById(this.f4522d[i]);
        }
        if (this.f4523e.equals("SET")) {
            C1781m.m6023b(false);
            m4543e(R.string.title_for_passlock_set_activity);
            this.f4534p.setEnabled(true);
            this.f4534p.setText(R.string.layout_chat_fragment_cancel);
        } else {
            C1781m.m6023b(true);
        }
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            ActionBar actionBar = getActionBar();
            getActionBar().setTitle(R.string.settings_password_lock);
            actionBar.setHomeButtonEnabled(false);
        }
        m4533d();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C1786r.m6061b("item =" + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    public void clickkeypad_back(View view) {
        C1786r.m6061b("clickkeypad_back", f4519a);
        if (this.f4526h > 0) {
            C1786r.m6061b("INPUT_PASSWORD : " + this.f4524f[this.f4525g], f4519a);
            this.f4526h--;
            this.f4524f[this.f4525g] = this.f4524f[this.f4525g].substring(0, this.f4526h);
            this.f4541w = this.f4541w.substring(0, this.f4526h);
            m4541c(this.f4526h);
            return;
        }
        if (this.f4526h == 0) {
            m4539b();
        }
    }

    public void clickkeypad_cancel(View view) {
        C1786r.m6061b("clickkeypad_cancel", f4519a);
        C1781m.m6023b(false);
        if (this.f4523e.equals("HOME") || this.f4523e.equals("RECEIVER")) {
            Intent intent = new Intent(this, (Class<?>) HomeActivity.class);
            intent.addFlags(67108864);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.putExtra("finish", true);
            startActivityForResult(intent, -1);
            return;
        }
        finish();
    }

    public void clickkeypad(View view) throws NoSuchAlgorithmException {
        C1786r.m6061b("clickkeypad", f4519a);
        if (this.f4526h != 4) {
            this.f4532n = 0;
            int i = 0;
            while (true) {
                if (i >= this.f4521c.length - 1) {
                    break;
                }
                if (view.getId() != this.f4521c[i]) {
                    i++;
                } else {
                    this.f4532n = i;
                    break;
                }
            }
            String string = Integer.toString(this.f4532n);
            StringBuilder sb = new StringBuilder();
            String[] strArr = this.f4524f;
            int i2 = this.f4525g;
            strArr[i2] = sb.append(strArr[i2]).append(string).toString();
            this.f4541w += string;
            C1786r.m6061b("INPUT_PASSWORD : " + this.f4524f[this.f4525g], f4519a);
            m4540b(this.f4526h);
            this.f4526h++;
            if (this.f4526h == 4) {
                C1786r.m6061b("MODE : " + this.f4523e, f4519a);
                C1786r.m6061b("keypad_input : " + this.f4526h, f4519a);
                String[] strArr2 = new String[2];
                String[] strArrM4538a = m4538a("GET", "", "");
                String strM6021b = C1781m.m6021b(this.f4524f[this.f4525g]);
                if (this.f4523e.equals("PRIVACY")) {
                    if (strM6021b.equals(strArrM4538a[this.f4530l])) {
                        C1781m.m6023b(false);
                        if (C1781m.m6019a()) {
                            C1781m.m6018a(false);
                        }
                        this.f4528j = 0;
                        setResult(-1);
                        finish();
                        return;
                    }
                    m4535a();
                    this.f4526h = 0;
                    m4536a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    this.f4538t.setTextColor(Color.parseColor("#e86d00"));
                    m4542d(R.string.description_for_wrong_passlock);
                    m4537a((String) null);
                    this.f4539u = 0;
                    m4534e();
                    m4539b();
                    return;
                }
                if (this.f4523e.equals("RECEIVER") || this.f4523e.equals("HOME")) {
                    if (strM6021b.equals(strArrM4538a[this.f4530l])) {
                        C1781m.m6023b(false);
                        if (C1781m.m6019a()) {
                            C1781m.m6018a(false);
                        }
                        this.f4528j = 0;
                        finish();
                        return;
                    }
                    m4535a();
                    this.f4526h = 0;
                    m4536a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    this.f4538t.setTextColor(Color.parseColor("#e86d00"));
                    m4542d(R.string.description_for_wrong_passlock);
                    m4537a((String) null);
                    this.f4539u = 0;
                    m4534e();
                    m4539b();
                    return;
                }
                if (this.f4523e.equals("CHANGE")) {
                    if (strM6021b.equals(strArrM4538a[this.f4530l])) {
                        C1781m.m6023b(false);
                        if (C1781m.m6019a()) {
                            C1781m.m6018a(false);
                        }
                        this.f4528j = 0;
                        finish();
                        Intent intent = new Intent(this, (Class<?>) ActivityPasswordLockSet.class);
                        intent.putExtra("MODE", "SET");
                        startActivityForResult(intent, -1);
                        return;
                    }
                    m4535a();
                    this.f4526h = 0;
                    m4536a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    this.f4538t.setTextColor(Color.parseColor("#e86d00"));
                    m4542d(R.string.description_for_wrong_passlock);
                    m4537a((String) null);
                    this.f4539u = 0;
                    m4534e();
                    m4539b();
                    return;
                }
                this.f4525g++;
                if (this.f4525g == 2) {
                    if (this.f4524f[this.f4525g - 2].equals(this.f4524f[this.f4525g - 1])) {
                        C1781m.m6023b(false);
                        if (C1781m.m6019a()) {
                            C1781m.m6018a(false);
                        }
                        m4538a("SET", "ON", this.f4524f[this.f4525g - 1]);
                        return;
                    }
                    m4535a();
                    this.f4526h = 0;
                    this.f4525g = 0;
                    m4536a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    m4543e(R.string.title_for_passlock_set_activity);
                    this.f4538t.setTextColor(Color.parseColor("#e86d00"));
                    m4542d(R.string.description_for_wrong_passlock);
                    m4537a((String) null);
                    m4539b();
                    return;
                }
                this.f4526h = 0;
                m4542d(R.string.setting_password_lock_blank);
                m4543e(R.string.title_for_passlock_set_activity_retry);
                m4539b();
            }
        }
    }

    /* renamed from: a */
    public void m4536a(int i) {
        C1786r.m6061b("start_vibrator", f4519a);
        ((Vibrator) getApplicationContext().getSystemService("vibrator")).vibrate(i);
    }

    /* renamed from: a */
    public void m4535a() {
        C1786r.m6061b("initialize_password", f4519a);
        for (int i = 0; i < 2; i++) {
            this.f4524f[i] = "";
        }
        this.f4541w = "";
    }

    /* renamed from: b */
    public void m4540b(int i) {
        C1786r.m6061b("passlock_setImage", f4519a);
        for (int i2 = 0; i2 <= i; i2++) {
            this.f4520b[i2].setBackgroundResource(R.drawable.password_highlight);
        }
    }

    /* renamed from: c */
    public void m4541c(int i) {
        C1786r.m6061b("passlock_backImage", f4519a);
        if (this.f4528j != 0) {
            this.f4520b[i].setBackgroundResource(R.drawable.password_normal);
            this.f4520b[i].setText("");
        } else {
            this.f4520b[i].setBackgroundResource(R.drawable.password_normal);
        }
    }

    /* renamed from: b */
    public void m4539b() {
        C1786r.m6061b("passlock_defaultImage", f4519a);
        new Handler().postDelayed(new RunnableC1228ag(this), 15L);
    }

    /* renamed from: d */
    public void m4542d(int i) {
        C1786r.m6061b("passlock_setText", f4519a);
        ((TextView) findViewById(R.id.description)).setText(i);
        this.f4529k = i;
    }

    /* renamed from: e */
    public void m4543e(int i) {
        C1786r.m6061b("passlock_title_setText", f4519a);
        ((TextView) findViewById(R.id.title)).setText(i);
        this.f4540v = i;
    }

    /* renamed from: a */
    public void m4537a(String str) {
        C1786r.m6061b("passlock_hint_setText", f4519a);
        ((TextView) findViewById(R.id.hint)).setText(str);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C1786r.m6061b("onBackPressed", f4519a);
        C1781m.m6023b(false);
        if (this.f4523e.equals("HOME") || this.f4523e.equals("RECEIVER")) {
            Intent intent = new Intent(this, (Class<?>) HomeActivity.class);
            intent.addFlags(67108864);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.putExtra("finish", true);
            startActivityForResult(intent, -1);
            return;
        }
        if (C1781m.m6019a()) {
            C1781m.m6018a(false);
        }
        finish();
    }

    /* renamed from: a */
    public String[] m4538a(String str, String str2, String str3) throws NoSuchAlgorithmException {
        C1786r.m6061b("prePassword", f4519a);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("password_lock", 0);
        SharedPreferences sharedPreferencesM6075a = C1789u.m6075a();
        if (str.equals("GET")) {
            C1786r.m6061b("GET preference", f4519a);
            strArr[0] = sharedPreferences.getString("app_lock_state", C1781m.m6027d());
            strArr[1] = sharedPreferences.getString("app_lock_password", "0000");
        } else {
            C1786r.m6061b("SET preference", f4519a);
            C1786r.m6061b("state : " + str2, f4519a);
            C1786r.m6061b("pass : " + str3, f4519a);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM6021b = C1781m.m6021b(str2);
            String strM6021b2 = C1781m.m6021b(str3);
            editorEdit.putString("app_lock_state", strM6021b);
            editorEdit.putString("app_lock_password", strM6021b2);
            editorEdit.commit();
            C1786r.m6061b("pass : " + str3, f4519a);
            C1786r.m6061b("editor : " + editorEdit, f4519a);
            C1789u.m6075a().edit().putString("lock_state", str2).commit();
            C1786r.m6061b("LOCK_STATE : " + sharedPreferencesM6075a.getString("lock_state", "default"), f4519a);
            C1781m.m6023b(false);
            finish();
        }
        return strArr;
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        C1786r.m6061b("onRetainNonConfigurationInstance", f4519a);
        HashMap map = new HashMap();
        C1786r.m6061b("backupmapclear : " + map, f4519a);
        map.put("INPUT_PASSWORD[0]", this.f4524f[0]);
        C1786r.m6061b("INPUT_PASSWORD[0] :" + this.f4524f[0], f4519a);
        map.put("INPUT_PASSWORD[1]", this.f4524f[1]);
        C1786r.m6061b("INPUT_PASSWORD[1] :" + this.f4524f[1], f4519a);
        map.put("inputUserPassword", this.f4541w);
        C1786r.m6061b("inputUserPassword :" + this.f4541w, f4519a);
        String string = Integer.toString(this.f4525g);
        map.put("password_index", string);
        C1786r.m6061b("password_index : " + string, f4519a);
        String string2 = Integer.toString(this.f4526h);
        map.put("keypad_input", string2);
        C1786r.m6061b("keypad_input : " + string2, f4519a);
        map.put("descriptionbackup", Integer.toString(this.f4529k));
        map.put("titlebackup", Integer.toString(this.f4540v));
        map.put("hintbackup", this.f4531m);
        String string3 = Integer.toString(this.f4527i);
        map.put("error_count", string3);
        C1786r.m6061b("error_count : " + string3, f4519a);
        String string4 = Integer.toString(this.f4539u);
        map.put("error_count_temp", string4);
        C1786r.m6061b("error_count_temp : " + string4, f4519a);
        String string5 = Integer.toString(this.f4528j);
        map.put("error_number_count", string5);
        C1786r.m6061b("error_number_count : " + string5, f4519a);
        return map;
    }

    /* renamed from: d */
    private void m4533d() throws NumberFormatException {
        C1786r.m6061b("Restore", f4519a);
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (lastNonConfigurationInstance != null) {
            HashMap map = (HashMap) lastNonConfigurationInstance;
            this.f4524f[0] = (String) map.get("INPUT_PASSWORD[0]");
            C1786r.m6061b("INPUT_PASSWORD[0] :" + this.f4524f[0], f4519a);
            this.f4524f[1] = (String) map.get("INPUT_PASSWORD[1]");
            C1786r.m6061b("INPUT_PASSWORD[1] :" + this.f4524f[1], f4519a);
            this.f4541w = (String) map.get("inputUserPassword");
            C1786r.m6061b("inputUserPassword :" + this.f4541w, f4519a);
            int i = Integer.parseInt((String) map.get("password_index"));
            this.f4525g = i;
            C1786r.m6061b("password_index : " + i, f4519a);
            int i2 = Integer.parseInt((String) map.get("keypad_input"));
            this.f4526h = i2;
            C1786r.m6061b("keypad_input : " + i2, f4519a);
            this.f4529k = Integer.parseInt((String) map.get("descriptionbackup"));
            if (this.f4529k != 0) {
                m4542d(this.f4529k);
            }
            this.f4540v = Integer.parseInt((String) map.get("titlebackup"));
            if (this.f4540v != 0) {
                m4543e(this.f4540v);
            }
            int i3 = Integer.parseInt((String) map.get("error_count"));
            this.f4527i = i3;
            C1786r.m6061b("error_count : " + i3, f4519a);
            int i4 = Integer.parseInt((String) map.get("error_count_temp"));
            this.f4539u = i4;
            C1786r.m6061b("error_count_temp : " + i4, f4519a);
            int i5 = Integer.parseInt((String) map.get("error_number_count"));
            this.f4528j = i5;
            C1786r.m6061b("error_number_count : " + i5, f4519a);
            this.f4531m = (String) map.get("hintbackup");
            C1786r.m6061b("Restore error_count" + this.f4527i, f4519a);
            if (this.f4539u >= 5) {
                this.f4538t.setTextColor(Color.parseColor("#000000"));
                if ("".equals(this.f4531m)) {
                    C1786r.m6061b("Hint null", f4519a);
                } else {
                    m4537a(getResources().getString(R.string.description_for_hint) + m4531b(this.f4531m));
                }
                this.f4534p.setEnabled(true);
                this.f4534p.setText(R.string.settings_delete);
                this.f4534p.setTextSize(18.0f);
                this.f4534p.setOnClickListener(new ViewOnClickListenerC1229ah(this, getResources().getString(R.string.setting_delete_account_warning) + "\n" + getResources().getString(R.string.setting_delete_account, "") + "\n+" + C1789u.m6075a().getString("msisdn", "")));
            }
            C1786r.m6061b("backupmap : " + map, f4519a);
            for (int i6 = 1; i6 <= this.f4526h; i6++) {
                m4540b(i6 - 1);
            }
        }
    }

    /* renamed from: e */
    private void m4534e() {
        this.f4527i++;
        this.f4528j++;
        this.f4531m = getSharedPreferences("password_lock", 0).getString("password_hint", "");
        if (this.f4527i >= 5) {
            this.f4538t.setTextColor(Color.parseColor("#000000"));
            this.f4539u = this.f4527i;
            C1786r.m6061b("error_count_temp : " + this.f4539u, f4519a);
            if ("".equals(this.f4531m)) {
                C1786r.m6061b("Hint null", f4519a);
            } else {
                m4537a(getResources().getString(R.string.description_for_hint) + " " + this.f4531m);
                m4537a(getResources().getString(R.string.description_for_hint) + m4531b(this.f4531m));
            }
            m4542d(R.string.description_for_passlock_footer);
            this.f4534p.setEnabled(true);
            this.f4534p.setText(R.string.settings_delete);
            this.f4534p.setTextSize(18.0f);
            this.f4534p.setOnClickListener(new ViewOnClickListenerC1231aj(this, getResources().getString(R.string.setting_delete_account_warning) + "\n" + getResources().getString(R.string.setting_delete_account, "") + "\n+" + C1789u.m6075a().getString("msisdn", "")));
            return;
        }
        this.f4534p.setEnabled(false);
        this.f4534p.setText("");
    }

    /* renamed from: c */
    public static String m4532c() {
        C1786r.m6063c("Complete Class name = " + ActivityPasswordLockSet.class.getName(), f4519a);
        return ActivityPasswordLockSet.class.getName();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C1786r.m6063c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
        if (!C1781m.m6019a() && this.f4523e.equals("HOME")) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C1786r.m6063c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C1786r.m6063c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C1786r.m6063c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f4535q != null && this.f4536r != null) {
            this.f4536r.dismiss();
            Toast.makeText(this.f4535q, this.f4535q.getResources().getString(R.string.ams_msg_deleted), 0).show();
        }
        C1786r.m6063c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, f4519a);
    }

    /* renamed from: b */
    private String m4531b(String str) {
        return new String(Base64.decode(str, 0));
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        if (this.f4523e.equals("SET")) {
            C1781m.m6018a(true);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
