package com.sec.chaton.registration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public abstract class AbstractUpgradeDialog extends BaseActivity {

    /* renamed from: A */
    private ImageView f11527A;

    /* renamed from: B */
    private TextView f11528B;

    /* renamed from: C */
    private TextView f11529C;

    /* renamed from: n */
    public TextView f11530n;

    /* renamed from: p */
    private LinearLayout f11532p;

    /* renamed from: q */
    private LinearLayout f11533q;

    /* renamed from: r */
    private LinearLayout f11534r;

    /* renamed from: s */
    private LinearLayout f11535s;

    /* renamed from: u */
    private Button f11537u;

    /* renamed from: v */
    private Button f11538v;

    /* renamed from: w */
    private boolean f11539w;

    /* renamed from: x */
    private boolean f11540x;

    /* renamed from: y */
    private boolean f11541y;

    /* renamed from: z */
    private ImageView f11542z;

    /* renamed from: o */
    private final String f11531o = AbstractUpgradeDialog.class.getSimpleName();

    /* renamed from: t */
    private TextView f11536t = null;

    /* renamed from: f */
    protected abstract void mo2879f();

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.upgrade_dialog);
        getWindow().setBackgroundDrawableResource(R.color.bright_foreground_light_disabled);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f11536t = (TextView) findViewById(R.id.dialog_message);
        this.f11530n = (TextView) findViewById(R.id.dialog_title);
        this.f11534r = (LinearLayout) findViewById(R.id.layout_center);
        this.f11535s = (LinearLayout) findViewById(R.id.layout_bottom_ok_cancel);
        this.f11538v = (Button) this.f11535s.findViewById(R.id.dialog_btn_no);
        this.f11542z = (ImageView) findViewById(R.id.image_apps);
        this.f11527A = (ImageView) findViewById(R.id.image_google);
        this.f11528B = (TextView) findViewById(R.id.name_apps);
        this.f11529C = (TextView) findViewById(R.id.name_google);
        if (Build.VERSION.SDK_INT < 11) {
            this.f11537u = (Button) findViewById(R.id.dialog_btn_yes);
            this.f11537u.setVisibility(0);
            findViewById(R.id.dialog_btn_yes_ics).setVisibility(8);
        } else {
            this.f11537u = (Button) findViewById(R.id.dialog_btn_yes_ics);
            this.f11537u.setVisibility(0);
            findViewById(R.id.dialog_btn_yes).setVisibility(8);
        }
        this.f11540x = getIntent().getBooleanExtra("isCritical", false);
        if (getIntent().getStringExtra("isReadyApps") == null) {
            this.f11539w = C4859bx.m18393b();
        } else if (getIntent().getStringExtra("isReadyApps").equals("YES")) {
            this.f11539w = true;
        } else if (getIntent().getStringExtra("isReadyApps").equals("NO")) {
            this.f11539w = false;
        } else {
            this.f11539w = C4859bx.m18393b();
        }
        this.f11541y = C4859bx.m18396c();
        this.f11535s.setVisibility(0);
        this.f11538v.setVisibility(0);
        mo2879f();
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
    }

    /* renamed from: a */
    public void m12768a(int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("initiateOneButtonAppl", this.f11531o);
        }
        this.f11534r.setVisibility(8);
        this.f11537u.setVisibility(0);
        this.f11537u.setOnClickListener(new ViewOnClickListenerC3131a(this, i));
    }

    /* renamed from: b */
    public void m12770b(int i) throws PackageManager.NameNotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("initiateTwoButtonAppl", this.f11531o);
        }
        if (this.f11541y && this.f11539w) {
            m12767g();
            this.f11534r.setVisibility(0);
            this.f11537u.setVisibility(8);
            this.f11532p = (LinearLayout) findViewById(R.id.dialog_btn_apps);
            this.f11532p.setVisibility(0);
            this.f11532p.setOnClickListener(new ViewOnClickListenerC3158b(this, i));
            this.f11533q = (LinearLayout) findViewById(R.id.dialog_btn_google);
            this.f11533q.setVisibility(0);
            this.f11533q.setOnClickListener(new ViewOnClickListenerC3185c(this, i));
            return;
        }
        this.f11534r.setVisibility(8);
        this.f11537u.setVisibility(0);
        this.f11537u.setOnClickListener(new ViewOnClickListenerC3212d(this, i));
    }

    /* renamed from: g */
    private void m12767g() throws PackageManager.NameNotFoundException {
        PackageManager packageManager = getPackageManager();
        try {
            this.f11528B.setText((String) packageManager.getApplicationLabel(packageManager.getApplicationInfo("com.sec.android.app.samsungapps", 0)));
            this.f11542z.setImageDrawable(packageManager.getApplicationIcon("com.sec.android.app.samsungapps"));
        } catch (PackageManager.NameNotFoundException e) {
            if (C4904y.f17875e) {
                C4904y.m18639b(e.toString(), this.f11531o);
            }
        }
        try {
            this.f11529C.setText((String) packageManager.getApplicationLabel(packageManager.getApplicationInfo("com.android.vending", 0)));
            this.f11527A.setImageDrawable(packageManager.getApplicationIcon("com.android.vending"));
        } catch (PackageManager.NameNotFoundException e2) {
            if (C4904y.f17875e) {
                C4904y.m18639b(e2.toString(), this.f11531o);
            }
        }
    }

    /* renamed from: a */
    public void m12769a(Context context, int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("handleCriticalCase", this.f11531o);
        }
        if (this.f11540x) {
            this.f11536t.setText(R.string.upgrade_dialog_critical_message);
            this.f11538v.setOnClickListener(new ViewOnClickListenerC3239e(this, i));
        } else {
            this.f11536t.setText(R.string.upgrade_dialog_basic_message);
            this.f11538v.setOnClickListener(new ViewOnClickListenerC3266f(this, i));
        }
    }
}
