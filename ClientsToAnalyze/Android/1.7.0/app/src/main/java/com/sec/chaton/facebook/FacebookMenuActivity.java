package com.sec.chaton.facebook;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;

/* loaded from: classes.dex */
public class FacebookMenuActivity extends Activity {

    /* renamed from: a */
    private C0700o f2355a;

    /* renamed from: b */
    private TextView f2356b;

    /* renamed from: c */
    private int[] f2357c = {R.drawable.invitation_card_01, R.drawable.invitation_card_02, R.drawable.invitation_card_03};

    /* renamed from: d */
    private View.OnClickListener f2358d = new ViewOnClickListenerC0693h(this);

    /* renamed from: e */
    private InterfaceC0698m f2359e = new C0690e(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_facebook_menu);
        findViewById(R.id.facebook_menu_invitation_card).setOnClickListener(this.f2358d);
        findViewById(R.id.facebook_menu_chaton_family).setOnClickListener(this.f2358d);
        this.f2356b = (TextView) findViewById(R.id.facebook_menu_logout);
        this.f2356b.setOnClickListener(this.f2358d);
        if (this.f2355a == null) {
            this.f2355a = new C0700o(this, this.f2359e);
        }
        ((TextView) findViewById(R.id.facebook_account_info)).setText(this.f2355a.m3080a());
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f2355a.m3082a(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3060a() {
        new AlertDialogBuilderC1625m(this).setTitle(R.string.logout).setMessage(R.string.facebook_logout_q).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0691f(this)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0692g(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3061a(int i) {
        C1619g.m5888a(this, i, 0).show();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialogC1354a progressDialogC1354a = new ProgressDialogC1354a(this, false);
                progressDialogC1354a.setMessage(getString(R.string.facebook_post_wait));
                progressDialogC1354a.setIndeterminate(true);
                return progressDialogC1354a;
            case 1:
                ProgressDialogC1354a progressDialogC1354a2 = new ProgressDialogC1354a(this, false);
                progressDialogC1354a2.setMessage(getString(R.string.facebook_logout_wait));
                progressDialogC1354a2.setIndeterminate(true);
                return progressDialogC1354a2;
            default:
                return null;
        }
    }
}
