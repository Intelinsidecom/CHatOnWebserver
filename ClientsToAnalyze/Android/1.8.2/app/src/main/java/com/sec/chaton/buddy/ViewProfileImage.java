package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* loaded from: classes.dex */
public class ViewProfileImage extends BaseActivity {

    /* renamed from: a */
    public static final String f1297a = ViewProfileImage.class.getSimpleName();

    /* renamed from: c */
    private Context f1299c;

    /* renamed from: d */
    private LinearLayout f1300d;

    /* renamed from: e */
    private ImageView f1301e;

    /* renamed from: i */
    private Button f1302i;

    /* renamed from: j */
    private Button f1303j;

    /* renamed from: k */
    private ProgressDialog f1304k = null;

    /* renamed from: l */
    private Bitmap f1305l = null;

    /* renamed from: b */
    View.OnClickListener f1298b = new ViewOnClickListenerC0415fs(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.view_profile_image_layout);
        this.f1299c = this;
        m2297a();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (GlobalApplication.m3265f()) {
            getMenuInflater().inflate(R.menu.actionbar_menu_done_cancel, menu);
            menu.removeItem(R.id.actionbar_menu_delete_group);
            menu.removeItem(R.id.actionbar_menu_done);
            return true;
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_menu_cancel /* 2131494122 */:
                finish();
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m2297a();
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m2297a() {
        this.f1300d = (LinearLayout) findViewById(R.id.profile_holder);
        this.f1301e = (ImageView) findViewById(R.id.profile_big_image);
        if (!GlobalApplication.m3265f()) {
            this.f1302i = (Button) findViewById(R.id.profile_save);
            this.f1302i.setOnClickListener(this.f1298b);
            this.f1302i.setEnabled(false);
            this.f1303j = (Button) findViewById(R.id.profile_cancel);
            this.f1303j.setOnClickListener(this.f1298b);
            this.f1303j.setEnabled(false);
        }
        if (getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.NOT_CHANGE.getCode()) {
            this.f1304k = ProgressDialogC1806j.m6141a(this.f1299c, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            C1791w.m6097a(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), new C0413fq(this));
        } else {
            Toast.makeText(this.f1299c, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            if (!GlobalApplication.m3265f()) {
                this.f1303j.setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f1304k.dismiss();
        this.f1304k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2299b() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            this.f1299c.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        }
    }
}
