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
import com.sec.widget.AlertDialogBuilderC2120a;
import weibo4android.Weibo;

/* loaded from: classes.dex */
public class WeiboSubMenuActivity extends Activity implements View.OnClickListener {

    /* renamed from: b */
    private static final String f5131b = WeiboSubMenuActivity.class.getSimpleName();

    /* renamed from: a */
    Context f5132a;

    /* renamed from: c */
    private LinearLayout f5133c;

    /* renamed from: d */
    private LinearLayout f5134d;

    /* renamed from: e */
    private LinearLayout f5135e;

    /* renamed from: f */
    private TextView f5136f;

    /* renamed from: g */
    private Button f5137g;

    /* renamed from: h */
    private ProgressDialog f5138h;

    /* renamed from: i */
    private AlertDialog f5139i = null;

    /* renamed from: j */
    private String f5140j = null;

    /* renamed from: k */
    private String f5141k = null;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_submenu_list);
        this.f5132a = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f5136f = (TextView) findViewById(R.id.facebook_account);
        this.f5136f.setText(getString(R.string.dialog_connecting_server));
        this.f5137g = (Button) findViewById(R.id.facebook_logout);
        this.f5135e = (LinearLayout) findViewById(R.id.facebookFriendsUsingChatONLayout);
        ((TextView) this.f5135e.findViewById(R.id.textview1)).setText(R.string.tellfriends_friends_using_chaton);
        this.f5133c = (LinearLayout) findViewById(R.id.facebook_invitation_card);
        ((TextView) this.f5133c.findViewById(R.id.textview2)).setText(R.string.tellfriends_weibo_submenu_list_message_to_mine);
        this.f5134d = (LinearLayout) findViewById(R.id.facebook_invitation_msg);
        ((TextView) this.f5134d.findViewById(R.id.textview3)).setText(R.string.tellfriends_weibo_submenu_list_message_to_friends);
        this.f5135e.setOnClickListener(this);
        this.f5133c.setOnClickListener(this);
        this.f5134d.setOnClickListener(this);
        this.f5137g.setOnClickListener(this);
        m5057a();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        m5062d();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        m5059b();
        super.onDestroy();
    }

    /* renamed from: a */
    private void m5057a() {
        SharedPreferences sharedPreferences = getSharedPreferences("WeiboLogin", 0);
        String string = sharedPreferences.getString("weibo_access_secret_token", "");
        this.f5140j = String.valueOf(sharedPreferences.getLong("weibo_userID", 0L));
        this.f5141k = sharedPreferences.getString("weibo_userName", "");
        if (string.equals("")) {
            startActivity(new Intent(this.f5132a, (Class<?>) WeiboSignIn.class));
        } else if (this.f5141k == null) {
            this.f5136f.setText(getString(R.string.dialog_connecting_server));
        } else {
            this.f5136f.setText(this.f5141k);
        }
    }

    /* renamed from: b */
    private void m5059b() {
        m5062d();
        m5061c();
    }

    /* renamed from: c */
    private void m5061c() {
        if (this.f5139i != null && this.f5139i.isShowing()) {
            this.f5139i.dismiss();
            this.f5139i = null;
        }
    }

    /* renamed from: a */
    private void m5058a(boolean z) {
        if (this.f5138h == null) {
            C1786r.m6061b("showProgressDialog() \t- null. create and show", f5131b);
            this.f5138h = ProgressDialog.show(this, null, getString(R.string.dialog_connecting_server));
            this.f5138h.setCancelable(false);
            this.f5138h.setOnKeyListener(new DialogInterfaceOnKeyListenerC1449dw(this, z));
        } else {
            C1786r.m6061b("showProgressDialog() \t- not null. show", f5131b);
        }
        this.f5138h.show();
    }

    /* renamed from: d */
    private void m5062d() {
        boolean zIsShowing = false;
        if (this.f5138h != null && (zIsShowing = this.f5138h.isShowing())) {
            C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f5138h + ". isSowing : " + zIsShowing, f5131b);
            this.f5138h.dismiss();
            this.f5138h = null;
            return;
        }
        C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f5138h + ". isSowing : " + zIsShowing, f5131b);
    }

    /* renamed from: e */
    private void m5063e() {
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this);
        alertDialogBuilderC2120a.setTitle(R.string.logout).setMessage(R.string.logout_q).setCancelable(false).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1451dy(this)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC1450dx(this));
        alertDialogBuilderC2120a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5064f() {
        m5058a(false);
        CookieSyncManager.createInstance(this.f5132a);
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = getSharedPreferences("WeiboLogin", 0).edit();
        editorEdit.putString("weibo_access_token", "");
        editorEdit.putString("weibo_access_secret_token", "");
        editorEdit.putLong("weibo_userID", 0L);
        editorEdit.putString("weibo_userName", "");
        editorEdit.commit();
        C1472u.m5199a().m5200a((Weibo) null);
        C1350ae.m5081a(this.f5132a).m5084a(C1350ae.f5159c, false);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.facebook_logout /* 2131493596 */:
                m5063e();
                break;
            case R.id.facebook_invitation_card /* 2131493597 */:
                Intent intent = new Intent(this, (Class<?>) WeiboMessageActivity.class);
                intent.putExtra("following_uid", this.f5140j);
                intent.putExtra("following_name", this.f5141k);
                startActivity(intent);
                break;
            case R.id.facebook_invitation_msg /* 2131493598 */:
                startActivity(new Intent(this, (Class<?>) TellFriendsWeiboActivity.class));
                break;
            case R.id.facebookFriendsUsingChatONLayout /* 2131493599 */:
                Intent intent2 = new Intent(this, (Class<?>) SnsFriendsUsingChatOnActivity.class);
                intent2.putExtra("snsType", "weibo");
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
        m5065g();
    }

    /* renamed from: g */
    private void m5065g() {
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
}
