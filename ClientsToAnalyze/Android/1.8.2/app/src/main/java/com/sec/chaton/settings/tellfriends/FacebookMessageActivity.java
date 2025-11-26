package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;

/* loaded from: classes.dex */
public class FacebookMessageActivity extends Activity {

    /* renamed from: a */
    public static EditText f4918a;

    /* renamed from: f */
    private Activity f4924f;

    /* renamed from: g */
    private Context f4925g;

    /* renamed from: h */
    private String f4926h;

    /* renamed from: i */
    private String f4927i;

    /* renamed from: j */
    private ProgressDialog f4928j;

    /* renamed from: k */
    private static AlertDialog f4922k = null;

    /* renamed from: b */
    public static String f4919b = "Facebook_Intent_id";

    /* renamed from: c */
    public static String f4920c = "Facebook_Intent_name";

    /* renamed from: d */
    public static String f4921d = "Facebook_Intent_image";

    /* renamed from: e */
    private String f4923e = getClass().getSimpleName();

    /* renamed from: l */
    private boolean f4929l = false;

    /* renamed from: m */
    private InterfaceC1371az f4930m = new C1399c(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_message);
        C1786r.m6063c("onCreate()", this.f4923e);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        m4772a();
    }

    /* renamed from: a */
    public void m4772a() throws Resources.NotFoundException {
        C1786r.m6061b("initalize()", this.f4923e);
        this.f4924f = this;
        this.f4925g = this;
        Intent intent = getIntent();
        this.f4926h = intent.getStringExtra(f4919b);
        this.f4927i = intent.getStringExtra(f4920c);
        BitmapDrawable bitmapDrawable = new BitmapDrawable((Bitmap) intent.getParcelableExtra(f4921d));
        ImageView imageView = (ImageView) findViewById(R.id.new_message_my_profile_photo);
        TextView textView = (TextView) findViewById(R.id.new_message_my_profile_screenname);
        f4918a = (EditText) findViewById(R.id.facebook_message_editbox);
        f4918a.addTextChangedListener(new C1372b(this));
        imageView.setBackgroundDrawable(bitmapDrawable);
        textView.setText(this.f4927i);
        String string = getResources().getString(R.string.facebook_login_auto_post_text);
        if (!string.contains("www.ChatON.com/invite.html") && string.contains("www.ChatON.com")) {
            string = string.replace("www.ChatON.com", "www.ChatON.com/invite.html");
        }
        f4918a.setText(string);
    }

    /* renamed from: a */
    public void m4773a(String str, String str2) {
        m4764b(false);
        InviteFacebookActivity.f4943a.m5123a(str, str2, this.f4930m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4762b() {
        m4765c();
        m4767d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4765c() {
        C1786r.m6061b("dismissProgressDialog() \t- mProgressDialog : " + this.f4928j, this.f4923e);
        if (!isFinishing() && this.f4928j != null) {
            this.f4928j.dismiss();
            this.f4928j = null;
            this.f4924f.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4759a(boolean z) {
        m4758a(getResources().getString(R.string.facebook_post_failed));
    }

    /* renamed from: d */
    private static void m4767d() {
        if (f4922k != null && f4922k.isShowing()) {
            f4922k.dismiss();
            f4922k = null;
        }
    }

    /* renamed from: a */
    private void m4758a(String str) {
        Toast.makeText(this, str, 0).show();
    }

    /* renamed from: b */
    private void m4764b(boolean z) {
        C1786r.m6061b("showProgressDialog()", this.f4923e);
        if (this.f4928j == null) {
            C1786r.m6061b("showProgressDialog() \t- null, create and show , isFinishable : " + z, this.f4923e);
            this.f4928j = (ProgressDialog) new C1805i(this).m6139a(R.string.facebook_post_wait);
            this.f4928j.setCancelable(false);
            this.f4928j.setOnKeyListener(new DialogInterfaceOnKeyListenerC1426d(this, z));
        } else {
            C1786r.m6061b("showProgressDialog() \t- not null. show", this.f4923e);
        }
        this.f4928j.show();
    }

    /* renamed from: e */
    private void m4770e() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        C1786r.m6063c("onBackPressed", this.f4923e);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C1786r.m6063c("onStart", this.f4923e);
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

    /* renamed from: f */
    private void m4771f() {
        C1786r.m6061b("mGeneralButtonListener", this.f4923e);
        String string = f4918a.getText().toString();
        C1786r.m6061b("mMessage : " + string, this.f4923e);
        m4773a(this.f4926h, string);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_title_done /* 2131494130 */:
                m4771f();
                break;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
        menu.removeItem(R.id.actionbar_title_next);
        menu.removeItem(R.id.actionbar_title_cancel);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f4929l) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1786r.m6063c("onResume", this.f4923e);
        m4770e();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        C1786r.m6063c("onStop", this.f4923e);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1786r.m6063c("onDestroy", this.f4923e);
    }
}
