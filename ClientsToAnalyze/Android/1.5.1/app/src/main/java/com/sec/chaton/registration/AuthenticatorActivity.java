package com.sec.chaton.registration;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    /* renamed from: a */
    public String f2885a;

    /* renamed from: b */
    public String f2886b;

    /* renamed from: c */
    public String f2887c;

    /* renamed from: i */
    private ImageView f2893i;

    /* renamed from: j */
    private TextView f2894j;

    /* renamed from: g */
    private boolean f2891g = false;

    /* renamed from: h */
    private boolean f2892h = false;

    /* renamed from: d */
    boolean f2888d = false;

    /* renamed from: e */
    boolean f2889e = false;

    /* renamed from: f */
    boolean f2890f = false;

    /* renamed from: a */
    private void m3092a(String str, String str2) {
        Account account = new Account(str, "com.sec.chaton");
        AccountManager.get(getApplicationContext()).addAccountExplicitly(account, str2, null);
        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
        new AsyncTaskC0445u(null).execute(GlobalApplication.m2387e());
    }

    /* renamed from: b */
    private void m3095b() {
        Intent intent = new Intent(this, (Class<?>) ActivityProvisioning.class);
        this.f2885a = ChatONPref.m3519a().getString("Push Name", "");
        this.f2886b = ChatONPref.m3519a().getString("msisdn", "");
        intent.putExtra("REG_NAME", this.f2885a);
        intent.putExtra("REG_PNO", this.f2886b);
        startActivityForResult(intent, 2);
    }

    /* renamed from: c */
    private void m3098c() {
        m3092a(this.f2886b, this.f2887c);
        Intent intent = new Intent();
        this.f2886b = ChatONPref.m3519a().getString("msisdn", "");
        this.f2887c = ChatONPref.m3519a().getString("uid", "");
        intent.putExtra("authAccount", this.f2886b);
        intent.putExtra("accountType", "com.sec.chaton");
        intent.putExtra("authtoken", this.f2887c);
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3099d() {
        setContentView(C0062R.layout.layout_settings_disclaimer);
        m3100a();
    }

    /* renamed from: a */
    public void m3100a() {
        ((Button) findViewById(C0062R.id.setting_about_btn1)).setOnClickListener(new ViewOnClickListenerC0410ah(this));
        ((Button) findViewById(C0062R.id.setting_about_btn2)).setOnClickListener(new ViewOnClickListenerC0411ai(this));
        ((Button) findViewById(C0062R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC0412aj(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        finish();
                        break;
                    }
                } else {
                    ChatONPref.m3519a().edit().putString("provisioning_selfsms_status", "DONE").commit();
                    m3095b();
                    break;
                }
                break;
            case 2:
                this.f2887c = ChatONPref.m3519a().getString("uid", "");
                if (i2 != -1 && TextUtils.isEmpty(this.f2887c)) {
                    finish();
                    break;
                } else {
                    m3098c();
                    break;
                }
                break;
            case 4:
                m3099d();
                break;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.f2892h = true;
        finish();
    }

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3508c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        setContentView(C0062R.layout.layout_settings_starting);
        this.f2891g = true;
        ProgressBar progressBar = (ProgressBar) findViewById(C0062R.id.progress);
        TextView textView = (TextView) findViewById(C0062R.id.loading);
        this.f2893i = (ImageView) findViewById(C0062R.id.logo);
        this.f2894j = (TextView) findViewById(C0062R.id.samsung_ltd);
        progressBar.setVisibility(4);
        textView.setVisibility(4);
        this.f2893i.setVisibility(0);
        this.f2894j.setVisibility(0);
        new Handler().postDelayed(new RunnableC0409ag(this), 1000L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3508c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3508c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }
}
