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
public class OauthSignin extends Activity {

    /* renamed from: g */
    private static boolean f4970g = false;

    /* renamed from: h */
    private ProgressDialog f4977h;

    /* renamed from: a */
    String f4971a = null;

    /* renamed from: b */
    Twitter f4972b = null;

    /* renamed from: c */
    WebView f4973c = null;

    /* renamed from: d */
    AsyncTaskC1347ab f4974d = null;

    /* renamed from: e */
    AsyncTaskC1346aa f4975e = null;

    /* renamed from: i */
    private Context f4978i = null;

    /* renamed from: j */
    private Timer f4979j = null;

    /* renamed from: k */
    private AlertDialog f4980k = null;

    /* renamed from: f */
    Handler f4976f = new HandlerC1473v(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4821b() {
        if (this.f4977h != null && this.f4977h.isShowing()) {
            this.f4977h.dismiss();
        }
        this.f4973c.stopLoading();
        if (this.f4979j != null) {
            this.f4979j.cancel();
        }
        if (this.f4974d != null) {
            this.f4974d.cancel(true);
        }
        if (this.f4975e != null) {
            this.f4975e.cancel(true);
        }
        if (f4970g) {
            if (this.f4980k != null) {
                this.f4980k.show();
            } else {
                this.f4980k = new AlertDialogBuilderC2120a(this.f4978i).setTitle(getResources().getString(R.string.toast_error)).setMessage(getResources().getString(R.string.toast_network_unable)).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1474w(this)).create();
                this.f4980k.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4822c() {
        if (!isFinishing()) {
            if (this.f4977h == null) {
                this.f4977h = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_provision_ing);
                this.f4977h.setOnKeyListener(new DialogInterfaceOnKeyListenerC1475x(this));
            }
            if (!this.f4977h.isShowing()) {
                this.f4977h.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4825d() {
        if (!isFinishing() && this.f4977h != null && this.f4977h.isShowing()) {
            this.f4977h.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_twitter_signin);
        this.f4978i = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        this.f4973c = (WebView) findViewById(R.id.twitter_signin_webview);
        m4822c();
        if (this.f4974d == null) {
            this.f4974d = (AsyncTaskC1347ab) new AsyncTaskC1347ab(this).execute("FiKaUrK1VKFB5pBaW77aPQ", "yd4oZTePGns9RyeuqXMYMUU1f70VS16sf8WhiCdwSM");
        }
    }

    /* renamed from: a */
    public void m4831a(String str) {
        this.f4973c.getSettings().setJavaScriptEnabled(true);
        this.f4973c.requestFocus(130);
        this.f4973c.loadUrl("http://twitter.com/oauth/authorize?oauth_token=" + str);
        this.f4973c.addJavascriptInterface(new C1477z(this), "PinCode");
        this.f4973c.setWebViewClient(new C1476y(this));
    }

    /* renamed from: a */
    public void m4830a() {
        C1786r.m6063c("Called. successSignin() - start activity", getClass().getSimpleName());
        startActivity(new Intent(this, (Class<?>) TWFollowingsListActivity.class));
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
        f4970g = true;
        m4826e();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        f4970g = false;
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

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: e */
    private void m4826e() {
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
        if (this.f4979j != null) {
            this.f4979j.cancel();
            this.f4979j.purge();
            this.f4979j = null;
        }
        if (this.f4974d != null) {
            this.f4974d.cancel(true);
        }
        if (this.f4975e != null) {
            this.f4975e.cancel(true);
        }
        if (this.f4980k != null) {
            this.f4980k.dismiss();
            this.f4980k = null;
        }
        if (this.f4977h != null) {
            this.f4977h.dismiss();
            this.f4977h = null;
        }
        super.onDestroy();
    }
}
