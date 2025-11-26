package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.facebook.FacebookInvitationCardSelectActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class FacebookSubMenuActivity extends Activity implements View.OnClickListener {

    /* renamed from: b */
    private static final String f4931b = FacebookSubMenuActivity.class.getSimpleName();

    /* renamed from: a */
    Context f4932a;

    /* renamed from: c */
    private C1374bb f4933c;

    /* renamed from: d */
    private LinearLayout f4934d;

    /* renamed from: e */
    private LinearLayout f4935e;

    /* renamed from: f */
    private LinearLayout f4936f;

    /* renamed from: g */
    private TextView f4937g;

    /* renamed from: h */
    private Button f4938h;

    /* renamed from: i */
    private ProgressDialog f4939i;

    /* renamed from: j */
    private AlertDialog f4940j = null;

    /* renamed from: k */
    private InterfaceC1369ax f4941k = new C1453e(this);

    /* renamed from: l */
    private InterfaceC1370ay f4942l = new C1458g(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_submenu_list);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f4932a = this;
        this.f4937g = (TextView) findViewById(R.id.facebook_account);
        this.f4937g.setText(getString(R.string.dialog_connecting_server));
        this.f4938h = (Button) findViewById(R.id.facebook_logout);
        this.f4934d = (LinearLayout) findViewById(R.id.facebook_invitation_card);
        this.f4935e = (LinearLayout) findViewById(R.id.facebook_invitation_msg);
        this.f4936f = (LinearLayout) findViewById(R.id.facebookFriendsUsingChatONLayout);
        this.f4934d.setOnClickListener(this);
        this.f4935e.setOnClickListener(this);
        this.f4936f.setOnClickListener(this);
        this.f4938h.setOnClickListener(this);
        this.f4933c = new C1374bb(this);
        m4777b();
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
    protected void onPause() {
        super.onPause();
        m4786g();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4933c.m5119a();
        this.f4933c = null;
        m4778c();
    }

    /* renamed from: b */
    private void m4777b() {
        if (this.f4933c.m5124b()) {
            this.f4937g.setText(this.f4933c.m5125c());
        } else {
            m4784f();
            this.f4933c.m5121a(this.f4941k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4778c() {
        m4786g();
        m4782e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4780d() {
        if (!isFinishing()) {
            if (this.f4940j == null) {
                this.f4940j = new AlertDialogBuilderC2120a(this.f4932a).setTitle(getResources().getString(R.string.toast_error)).setMessage(getResources().getString(R.string.toast_network_unable)).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1457f(this)).create();
            }
            this.f4940j.show();
        }
    }

    /* renamed from: e */
    private void m4782e() {
        if (this.f4940j != null && this.f4940j.isShowing()) {
            this.f4940j.dismiss();
            this.f4940j = null;
        }
    }

    /* renamed from: f */
    private void m4784f() {
        if (this.f4939i == null) {
            C1786r.m6061b("showProgressDialog() \t- null. create and show", f4931b);
            this.f4939i = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
        } else {
            C1786r.m6061b("showProgressDialog() \t- not null. show", f4931b);
        }
        this.f4939i.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4786g() {
        boolean zIsShowing = false;
        if (this.f4939i != null && (zIsShowing = this.f4939i.isShowing())) {
            C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f4939i + ". isSowing : " + zIsShowing, f4931b);
            this.f4939i.dismiss();
            this.f4939i = null;
            return;
        }
        C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f4939i + ". isSowing : " + zIsShowing, f4931b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4787h() {
        m4784f();
        this.f4933c.m5122a(this.f4942l);
    }

    /* renamed from: i */
    private void m4788i() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.logout).setMessage(R.string.logout_q).setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC1460i(this)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1459h(this)).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.facebook_logout /* 2131493596 */:
                m4788i();
                break;
            case R.id.facebook_invitation_card /* 2131493597 */:
                startActivity(new Intent(this, (Class<?>) FacebookInvitationCardSelectActivity.class));
                break;
            case R.id.facebook_invitation_msg /* 2131493598 */:
                Intent intent = new Intent(this, (Class<?>) InviteFacebookActivity.class);
                intent.putExtra("snsType", "facebook");
                startActivity(intent);
                break;
            case R.id.facebookFriendsUsingChatONLayout /* 2131493599 */:
                Intent intent2 = new Intent(this, (Class<?>) SnsFriendsUsingChatOnActivity.class);
                intent2.putExtra("snsType", "facebook");
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f4933c.mo5102a(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4789j();
    }

    /* renamed from: j */
    private void m4789j() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
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
