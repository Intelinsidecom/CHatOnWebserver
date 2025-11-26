package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.Timer;
import weibo4android.Weibo;

/* loaded from: classes.dex */
public class WeiboSignIn extends Activity {

    /* renamed from: g */
    private ProgressDialog f5127g;

    /* renamed from: a */
    Weibo f5121a = null;

    /* renamed from: b */
    WebView f5122b = null;

    /* renamed from: c */
    AsyncTaskC1447du f5123c = null;

    /* renamed from: d */
    AsyncTaskC1446dt f5124d = null;

    /* renamed from: f */
    private String f5126f = null;

    /* renamed from: h */
    private Context f5128h = null;

    /* renamed from: i */
    private Timer f5129i = null;

    /* renamed from: j */
    private AlertDialog f5130j = null;

    /* renamed from: e */
    Handler f5125e = new HandlerC1442dp(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5044b() {
        if (this.f5127g != null && this.f5127g.isShowing()) {
            this.f5127g.dismiss();
        }
        this.f5122b.stopLoading();
        if (this.f5129i != null) {
            this.f5129i.cancel();
        }
        if (this.f5130j != null) {
            this.f5130j.show();
        } else {
            this.f5130j = new AlertDialogBuilderC2120a(this.f5128h).setTitle(getResources().getString(R.string.ams_attention_title)).setMessage(getResources().getString(R.string.dev_network_error)).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1443dq(this)).create();
            this.f5130j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5045c() {
        if (!isFinishing()) {
            if (this.f5127g == null) {
                this.f5127g = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
                this.f5127g.setCancelable(false);
                this.f5127g.setOnKeyListener(new DialogInterfaceOnKeyListenerC1444dr(this));
            }
            if (!this.f5127g.isShowing()) {
                this.f5127g.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5048d() {
        if (!isFinishing() && this.f5127g != null && this.f5127g.isShowing()) {
            this.f5127g.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_tellfriends_signin);
        this.f5128h = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f5122b = (WebView) findViewById(R.id.tellfriends_signin_webview);
        if (this.f5123c == null) {
            this.f5123c = (AsyncTaskC1447du) new AsyncTaskC1447du(this).execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public void m5053a() {
        C1786r.m6063c("Called. successSignin() - WeiboSubMenuActivity Start", getClass().getSimpleName());
        startActivity(new Intent(this, (Class<?>) WeiboSubMenuActivity.class));
        finish();
    }

    /* renamed from: a */
    public void m5054a(String str) {
        WebSettings settings = this.f5122b.getSettings();
        settings.setSavePassword(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        this.f5122b.getSettings().setJavaScriptEnabled(true);
        this.f5122b.getSettings().getUserAgentString();
        this.f5122b.requestFocus(130);
        this.f5122b.loadUrl(str);
        this.f5122b.setWebViewClient(new C1445ds(this));
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m5050e();
    }

    /* renamed from: e */
    private void m5050e() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.tellfriends_via_weibo);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f5129i != null) {
            this.f5129i.cancel();
            this.f5129i.purge();
            this.f5129i = null;
        }
        if (this.f5123c != null) {
            this.f5123c.cancel(true);
        }
        if (this.f5124d != null) {
            this.f5124d.cancel(true);
        }
        if (this.f5130j != null) {
            this.f5130j.dismiss();
            this.f5130j = null;
        }
        if (this.f5127g != null) {
            this.f5127g.dismiss();
            this.f5127g = null;
        }
        this.f5125e = null;
        super.onDestroy();
    }
}
