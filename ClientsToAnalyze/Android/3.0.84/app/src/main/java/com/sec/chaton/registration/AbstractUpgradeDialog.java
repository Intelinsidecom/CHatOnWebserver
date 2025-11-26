package com.sec.chaton.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public abstract class AbstractUpgradeDialog extends BaseActivity {

    /* renamed from: a */
    public TextView f8076a;

    /* renamed from: c */
    private LinearLayout f8078c;

    /* renamed from: d */
    private LinearLayout f8079d;

    /* renamed from: e */
    private LinearLayout f8080e;

    /* renamed from: f */
    private LinearLayout f8081f;

    /* renamed from: h */
    private Button f8083h;

    /* renamed from: i */
    private Button f8084i;

    /* renamed from: j */
    private boolean f8085j;

    /* renamed from: k */
    private boolean f8086k;

    /* renamed from: l */
    private boolean f8087l;

    /* renamed from: b */
    private final String f8077b = AbstractUpgradeDialog.class.getSimpleName();

    /* renamed from: g */
    private TextView f8082g = null;

    /* renamed from: a */
    protected abstract void mo1132a();

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.upgrade_dialog);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f8082g = (TextView) findViewById(R.id.dialog_message);
        this.f8076a = (TextView) findViewById(R.id.dialog_title);
        this.f8080e = (LinearLayout) findViewById(R.id.layout_center);
        this.f8081f = (LinearLayout) findViewById(R.id.layout_bottom_ok_cancel);
        this.f8084i = (Button) this.f8081f.findViewById(R.id.dialog_btn_no);
        if (Build.VERSION.SDK_INT < 11) {
            this.f8083h = (Button) findViewById(R.id.dialog_btn_yes);
            this.f8083h.setVisibility(0);
            findViewById(R.id.dialog_btn_yes_ics).setVisibility(8);
        } else {
            this.f8083h = (Button) findViewById(R.id.dialog_btn_yes_ics);
            this.f8083h.setVisibility(0);
            findViewById(R.id.dialog_btn_yes).setVisibility(8);
        }
        this.f8086k = getIntent().getBooleanExtra("isCritical", false);
        if (getIntent().getStringExtra("isReadyApps") == null) {
            this.f8085j = C3214cb.m11261b();
        } else if (getIntent().getStringExtra("isReadyApps").equals("YES")) {
            this.f8085j = true;
        } else if (getIntent().getStringExtra("isReadyApps").equals("NO")) {
            this.f8085j = false;
        } else {
            this.f8085j = C3214cb.m11261b();
        }
        this.f8087l = C3214cb.m11264c();
        this.f8081f.setVisibility(0);
        this.f8084i.setVisibility(0);
        mo1132a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m8383b();
    }

    /* renamed from: b */
    private void m8383b() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", this.f8077b);
        }
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: a */
    public void m8385a(int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("initiateOneButtonAppl", this.f8077b);
        }
        this.f8080e.setVisibility(8);
        this.f8083h.setVisibility(0);
        this.f8083h.setOnClickListener(new ViewOnClickListenerC2122a(this, i));
    }

    /* renamed from: b */
    public void m8387b(int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("initiateTwoButtonAppl", this.f8077b);
        }
        if (this.f8087l && this.f8085j) {
            this.f8080e.setVisibility(0);
            this.f8083h.setVisibility(8);
            this.f8078c = (LinearLayout) findViewById(R.id.dialog_btn_apps);
            this.f8078c.setVisibility(0);
            this.f8078c.setOnClickListener(new ViewOnClickListenerC2149b(this, i));
            this.f8079d = (LinearLayout) findViewById(R.id.dialog_btn_google);
            this.f8079d.setVisibility(0);
            this.f8079d.setOnClickListener(new ViewOnClickListenerC2176c(this, i));
            return;
        }
        this.f8080e.setVisibility(8);
        this.f8083h.setVisibility(0);
        this.f8083h.setOnClickListener(new ViewOnClickListenerC2203d(this, i));
    }

    /* renamed from: a */
    public void m8386a(Context context, int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("handleCriticalCase", this.f8077b);
        }
        if (this.f8086k) {
            this.f8082g.setText(R.string.upgrade_dialog_critical_message);
            this.f8084i.setOnClickListener(new ViewOnClickListenerC2230e(this, context));
        } else {
            this.f8082g.setText(R.string.upgrade_dialog_basic_message);
            this.f8084i.setOnClickListener(new ViewOnClickListenerC2257f(this, i));
        }
    }
}
