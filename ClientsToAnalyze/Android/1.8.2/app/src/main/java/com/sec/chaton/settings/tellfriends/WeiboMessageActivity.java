package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import java.net.URL;
import weibo4android.Weibo;

/* loaded from: classes.dex */
public class WeiboMessageActivity extends Activity {

    /* renamed from: a */
    Context f5111a = null;

    /* renamed from: b */
    AsyncTaskC1440dn f5112b = null;

    /* renamed from: c */
    String f5113c = null;

    /* renamed from: d */
    String f5114d = null;

    /* renamed from: e */
    URL f5115e = null;

    /* renamed from: f */
    String f5116f = null;

    /* renamed from: g */
    private EditText f5117g = null;

    /* renamed from: h */
    private Weibo f5118h = null;

    /* renamed from: i */
    private boolean f5119i = false;

    /* renamed from: j */
    private ViewOnClickListenerC1452dz f5120j = null;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_weibo_message);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.f5119i = true;
        } else {
            this.f5119i = false;
        }
        this.f5111a = this;
        this.f5116f = getIntent().getExtras().getString("following_uid");
        this.f5113c = getIntent().getExtras().getString("following_name");
        String string = getResources().getString(R.string.tellfriends_post_message);
        if (!string.contains("www.ChatON.com/invite.html") && string.contains("www.ChatON.com")) {
            string = string.replace("www.ChatON.com", "http://www.ChatON.com/invite.html");
        }
        if (this.f5116f.equals(String.valueOf(getSharedPreferences("WeiboLogin", 0).getLong("weibo_userID", 0L)))) {
            this.f5114d = string;
        } else {
            this.f5114d = "@" + this.f5113c + " " + string;
        }
        this.f5117g = (EditText) findViewById(R.id.edit_text_input);
        m5037a(this.f5114d);
    }

    /* renamed from: a */
    private void m5037a(String str) {
        this.f5120j = new ViewOnClickListenerC1452dz(this, this.f5117g, 280);
        if (str != null) {
            this.f5120j.m5192a(str);
        }
    }

    /* renamed from: a */
    public void m5039a() {
        if (this.f5112b == null) {
            this.f5112b = new AsyncTaskC1440dn(this);
            if (this.f5119i) {
                this.f5112b.execute(this.f5113c);
            } else {
                this.f5112b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f5113c);
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f5112b != null) {
            this.f5112b.cancel(true);
            this.f5112b = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m5038b();
    }

    /* renamed from: b */
    private void m5038b() {
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
                m5039a();
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
        if (this.f5120j.m5193a()) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
