package com.sec.chaton.facebook;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class FacebookInvitationCardWriteActivity extends BaseActivity {

    /* renamed from: a */
    private EditText f2688a;

    /* renamed from: b */
    private C0725f f2689b;

    /* renamed from: c */
    private int f2690c;

    /* renamed from: d */
    private InterfaceC0736q f2691d = new C0722c(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_invitation_card_write);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        this.f2690c = getIntent().getIntExtra("invitationCardResId", 0);
        this.f2688a = (EditText) findViewById(R.id.invitationMessage);
        this.f2688a.addTextChangedListener(new C0721b(this));
        if (this.f2689b == null) {
            this.f2689b = new C0725f(this, this.f2691d);
        }
        ((ImageView) findViewById(R.id.invitationCardImage)).setImageResource(this.f2690c);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialogC1806j progressDialogC1806j = new ProgressDialogC1806j(this, false);
                progressDialogC1806j.setMessage(getString(R.string.facebook_post_wait));
                progressDialogC1806j.setIndeterminate(true);
                return progressDialogC1806j;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3192a() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_attention_title).setMessage(R.string.facebook_post_failed).setCancelable(false).setNegativeButton(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0724e(this)).setPositiveButton(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC0723d(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3193a(int i) {
        Toast.makeText(this, i, 0).show();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
        menu.removeItem(R.id.actionbar_title_next);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                return true;
            case R.id.actionbar_title_done /* 2131494130 */:
                if (C1739av.m5927a()) {
                    return false;
                }
                String str = this.f2688a.getText().toString() + "\nwww.chaton.com/invite.html\n\n" + getString(R.string.logo_is_different_for_canada);
                C1786r.m6063c("Invitation Message " + str, getClass().getSimpleName());
                this.f2689b.m3219a(0, this.f2690c, str);
                return true;
            default:
                return true;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
