package com.sec.chaton.facebook;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class FacebookMenuActivity extends Activity {

    /* renamed from: a */
    private C0725f f2692a;

    /* renamed from: b */
    private TextView f2693b;

    /* renamed from: c */
    private Button f2694c;

    /* renamed from: d */
    private View.OnClickListener f2695d = new ViewOnClickListenerC0740u(this);

    /* renamed from: e */
    private InterfaceC0736q f2696e = new C0743x(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_menu);
        findViewById(R.id.facebook_menu_invitation_card).setOnClickListener(this.f2695d);
        findViewById(R.id.facebook_menu_chaton_family).setOnClickListener(this.f2695d);
        this.f2693b = (TextView) findViewById(R.id.facebook_menu_logout);
        this.f2694c = (Button) findViewById(R.id.btnExit);
        this.f2693b.setOnClickListener(this.f2695d);
        if (this.f2692a == null) {
            this.f2692a = new C0725f(this, this.f2696e);
        }
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        ((TextView) findViewById(R.id.facebook_account_info)).setText(this.f2692a.m3221b());
        this.f2694c.setOnClickListener(new ViewOnClickListenerC0739t(this));
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f2692a.m3218a(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3198a() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.logout).setMessage(R.string.logout_q).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0742w(this)).setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC0741v(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3199a(int i) {
        Toast.makeText(this, i, 0).show();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialogC1806j progressDialogC1806j = new ProgressDialogC1806j(this, false);
                progressDialogC1806j.setMessage(getString(R.string.facebook_post_wait));
                progressDialogC1806j.setIndeterminate(true);
                return progressDialogC1806j;
            case 1:
                ProgressDialogC1806j progressDialogC1806j2 = new ProgressDialogC1806j(this, false);
                progressDialogC1806j2.setMessage(getString(R.string.facebook_logout_wait));
                progressDialogC1806j2.setIndeterminate(true);
                return progressDialogC1806j2;
            default:
                return null;
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
