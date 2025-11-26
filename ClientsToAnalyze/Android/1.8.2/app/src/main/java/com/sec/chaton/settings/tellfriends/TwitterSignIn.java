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
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.Timer;
import twitter4j.Twitter;

/* loaded from: classes.dex */
public class TwitterSignIn extends Activity {

    /* renamed from: g */
    private ProgressDialog f5096g;

    /* renamed from: a */
    String f5090a = null;

    /* renamed from: b */
    Twitter f5091b = null;

    /* renamed from: c */
    WebView f5092c = null;

    /* renamed from: d */
    AsyncTaskC1431de f5093d = null;

    /* renamed from: e */
    AsyncTaskC1430dd f5094e = null;

    /* renamed from: h */
    private Context f5097h = null;

    /* renamed from: i */
    private Timer f5098i = null;

    /* renamed from: j */
    private AlertDialog f5099j = null;

    /* renamed from: f */
    Handler f5095f = new HandlerC1424cy(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5008b() {
        if (this.f5096g != null && this.f5096g.isShowing()) {
            this.f5096g.dismiss();
        }
        this.f5092c.stopLoading();
        if (this.f5098i != null) {
            this.f5098i.cancel();
        }
        if (this.f5093d != null) {
            this.f5093d.cancel(true);
        }
        if (this.f5094e != null) {
            this.f5094e.cancel(true);
        }
        if (this.f5099j != null) {
            this.f5099j.show();
        } else {
            this.f5099j = new AlertDialogBuilderC2120a(this.f5097h).setTitle(getResources().getString(R.string.ams_attention_title)).setMessage(getResources().getString(R.string.dev_network_error)).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1425cz(this)).create();
            this.f5099j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5010c() {
        if (!isFinishing()) {
            if (this.f5096g == null) {
                this.f5096g = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_provision_ing);
                this.f5096g.setCancelable(false);
                this.f5096g.setOnKeyListener(new DialogInterfaceOnKeyListenerC1427da(this));
            }
            if (!this.f5096g.isShowing()) {
                this.f5096g.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5013d() {
        if (!isFinishing() && this.f5096g != null && this.f5096g.isShowing()) {
            this.f5096g.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onCreate(bundle);
        setContentView(R.layout.layout_tellfriends_signin);
        this.f5097h = this;
        this.f5092c = (WebView) findViewById(R.id.tellfriends_signin_webview);
        if (this.f5093d == null) {
            this.f5093d = (AsyncTaskC1431de) new AsyncTaskC1431de(this).execute("FiKaUrK1VKFB5pBaW77aPQ", "yd4oZTePGns9RyeuqXMYMUU1f70VS16sf8WhiCdwSM");
        }
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.tellfriends_via_twitter);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m5009b(String str) {
        return str.length() > 0 && str.indexOf("<") < 0 && str.indexOf(">") < 0 && str.indexOf("/") < 0;
    }

    /* renamed from: a */
    public void m5018a(String str) {
        this.f5092c.getSettings().setSavePassword(false);
        this.f5092c.getSettings().setJavaScriptEnabled(true);
        this.f5092c.getSettings().getUserAgentString();
        this.f5092c.requestFocus(130);
        this.f5092c.loadUrl("http://twitter.com/oauth/authorize?oauth_token=" + str);
        this.f5092c.addJavascriptInterface(new C1429dc(this), "PinCode");
        this.f5092c.setWebViewClient(new C1428db(this));
    }

    /* renamed from: a */
    public void m5017a() {
        C1786r.m6063c("Called. successSignin() - start activity", getClass().getSimpleName());
        startActivity(new Intent(this, (Class<?>) TwitterSubMenuActivity.class));
        finish();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m5014e();
    }

    /* renamed from: e */
    private void m5014e() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f5098i != null) {
            this.f5098i.cancel();
            this.f5098i.purge();
            this.f5098i = null;
        }
        if (this.f5093d != null) {
            this.f5093d.cancel(true);
        }
        if (this.f5094e != null) {
            this.f5094e.cancel(true);
        }
        if (this.f5099j != null) {
            this.f5099j.dismiss();
            this.f5099j = null;
        }
        if (this.f5096g != null) {
            this.f5096g.dismiss();
            this.f5096g = null;
        }
        this.f5095f = null;
        super.onDestroy();
    }
}
