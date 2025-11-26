package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;
import twitter4j.Twitter;

/* loaded from: classes.dex */
public class TwitterSubMenuActivity extends Activity implements View.OnClickListener {

    /* renamed from: b */
    private static final String f5100b = TwitterSubMenuActivity.class.getSimpleName();

    /* renamed from: a */
    Context f5101a;

    /* renamed from: d */
    private LinearLayout f5103d;

    /* renamed from: e */
    private LinearLayout f5104e;

    /* renamed from: f */
    private LinearLayout f5105f;

    /* renamed from: g */
    private TextView f5106g;

    /* renamed from: h */
    private Button f5107h;

    /* renamed from: i */
    private ProgressDialog f5108i;

    /* renamed from: c */
    private Twitter f5102c = null;

    /* renamed from: j */
    private AsyncTaskC1436dj f5109j = null;

    /* renamed from: k */
    private AlertDialog f5110k = null;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_submenu_list);
        this.f5101a = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f5106g = (TextView) findViewById(R.id.facebook_account);
        this.f5106g.setText(getString(R.string.dialog_connecting_server));
        this.f5107h = (Button) findViewById(R.id.facebook_logout);
        this.f5103d = (LinearLayout) findViewById(R.id.facebookFriendsUsingChatONLayout);
        this.f5104e = (LinearLayout) findViewById(R.id.facebook_invitation_card);
        ((TextView) this.f5104e.findViewById(R.id.textview2)).setText(R.string.tellfriends_twitter_submenu_list_message_to_mine);
        this.f5105f = (LinearLayout) findViewById(R.id.facebook_invitation_msg);
        ((TextView) this.f5105f.findViewById(R.id.textview3)).setText(R.string.tellfriends_twitter_submenu_list_message_to_friends);
        this.f5103d.setOnClickListener(this);
        this.f5104e.setOnClickListener(this);
        this.f5105f.setOnClickListener(this);
        this.f5107h.setOnClickListener(this);
        m5022a();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        m5031e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f5109j != null) {
            this.f5109j.cancel(true);
            this.f5109j = null;
        }
        m5024b();
        super.onDestroy();
    }

    /* renamed from: a */
    private void m5022a() {
        SharedPreferences sharedPreferences = getSharedPreferences("TwitterLogin", 0);
        sharedPreferences.getString("twitter_access_token", "");
        if (sharedPreferences.getString("twitter_access_secret_token", "").equals("")) {
            startActivity(new Intent(this.f5101a, (Class<?>) TwitterSignIn.class));
            return;
        }
        m5028d();
        String strM5168b = C1437dk.m5166a().m5168b();
        if (strM5168b == null) {
            if (this.f5109j == null) {
                this.f5109j = (AsyncTaskC1436dj) new AsyncTaskC1436dj(this).execute(new String[0]);
            }
        } else {
            m5031e();
            this.f5106g.setText(strM5168b);
        }
    }

    /* renamed from: b */
    private void m5024b() {
        m5031e();
        m5027c();
    }

    /* renamed from: c */
    private void m5027c() {
        if (this.f5110k != null && this.f5110k.isShowing()) {
            this.f5110k.dismiss();
            this.f5110k = null;
        }
    }

    /* renamed from: a */
    private void m5023a(boolean z) {
        if (this.f5108i == null) {
            C1786r.m6061b("showProgressDialog() \t- null. create and show", f5100b);
            this.f5108i = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
            this.f5108i.setCancelable(false);
            this.f5108i.setOnKeyListener(new DialogInterfaceOnKeyListenerC1433dg(this, z));
            this.f5108i.show();
            return;
        }
        C1786r.m6061b("showProgressDialog() \t- not null. show", f5100b);
        this.f5108i.show();
    }

    /* renamed from: d */
    private void m5028d() {
        m5023a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5031e() {
        boolean zIsShowing = false;
        if (this.f5108i != null && (zIsShowing = this.f5108i.isShowing())) {
            C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f5108i + ". isSowing : " + zIsShowing, f5100b);
            this.f5108i.dismiss();
            this.f5108i = null;
            return;
        }
        C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f5108i + ". isSowing : " + zIsShowing, f5100b);
    }

    /* renamed from: f */
    private void m5032f() {
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this);
        alertDialogBuilderC2120a.setTitle(R.string.logout).setMessage(R.string.logout_q).setCancelable(false).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1435di(this)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC1434dh(this));
        alertDialogBuilderC2120a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5033g() {
        m5023a(false);
        CookieSyncManager.createInstance(this.f5101a);
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = getSharedPreferences("TwitterLogin", 0).edit();
        editorEdit.putString("twitter_access_token", "");
        editorEdit.putString("twitter_access_secret_token", "");
        editorEdit.commit();
        C1437dk.m5166a().m5171e();
        C1350ae.m5081a(this.f5101a).m5084a(C1350ae.f5158b, false);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.facebook_logout /* 2131493596 */:
                m5032f();
                break;
            case R.id.facebook_invitation_card /* 2131493597 */:
                Intent intent = new Intent(this, (Class<?>) TwitterMessageActivity.class);
                intent.putExtra("following_name", "");
                startActivity(intent);
                break;
            case R.id.facebook_invitation_msg /* 2131493598 */:
                startActivity(new Intent(this, (Class<?>) TWFollowingsListActivity.class));
                break;
            case R.id.facebookFriendsUsingChatONLayout /* 2131493599 */:
                Intent intent2 = new Intent(this, (Class<?>) SnsFriendsUsingChatOnActivity.class);
                intent2.putExtra("snsType", "twitter");
                startActivity(intent2);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m5034h();
    }

    /* renamed from: h */
    private void m5034h() {
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
}
