package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;

/* loaded from: classes.dex */
public class TwitterMessageActivity extends Activity {

    /* renamed from: a */
    Context f5081a = null;

    /* renamed from: b */
    AsyncTaskC1423cx f5082b = null;

    /* renamed from: c */
    String f5083c = null;

    /* renamed from: d */
    String f5084d = null;

    /* renamed from: e */
    private boolean f5085e = false;

    /* renamed from: f */
    private EditText f5086f = null;

    /* renamed from: g */
    private TextView f5087g = null;

    /* renamed from: h */
    private String f5088h = "140";

    /* renamed from: i */
    private ProgressDialog f5089i = null;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_twitter_message);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        this.f5081a = this;
        this.f5083c = getIntent().getExtras().getString("following_name");
        this.f5085e = true;
        this.f5089i = (ProgressDialog) new C1805i(this.f5081a).m6139a(R.string.facebook_post_wait);
        this.f5089i.setCancelable(false);
        this.f5089i.setOnKeyListener(new DialogInterfaceOnKeyListenerC1421cv(this));
        String string = getResources().getString(R.string.tellfriends_post_message);
        if (!string.contains("www.ChatON.com/invite.html") && string.contains("www.ChatON.com")) {
            string = string.replace("www.ChatON.com", "www.ChatON.com/invite.html");
        }
        if (this.f5083c.equals("")) {
            this.f5084d = string;
        } else {
            this.f5084d = "@" + this.f5083c + " " + string;
        }
        this.f5087g = (TextView) findViewById(R.id.text_remain);
        this.f5087g.setText(m4996a(this.f5084d));
        this.f5086f = (EditText) findViewById(R.id.twitter_message_editbox);
        this.f5086f.setText(this.f5084d);
        this.f5086f.performClick();
        this.f5086f.addTextChangedListener(new C1422cw(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f5082b != null) {
            this.f5082b.cancel(true);
        }
        m5001c();
    }

    /* renamed from: a */
    public void m5003a() {
        if (this.f5082b == null) {
            this.f5082b = (AsyncTaskC1423cx) new AsyncTaskC1423cx(this).execute(this.f5083c);
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
        m4999b();
    }

    /* renamed from: b */
    private void m4999b() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m4996a(String str) {
        return "(" + String.valueOf(str.length()) + "/" + this.f5088h + ")";
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
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_title_done /* 2131494130 */:
                if (!isFinishing()) {
                    m5003a();
                    break;
                }
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
        if (this.f5085e) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: c */
    private void m5001c() {
        if (this.f5089i != null && this.f5089i.isShowing()) {
            this.f5089i.dismiss();
            this.f5089i = null;
        }
    }
}
