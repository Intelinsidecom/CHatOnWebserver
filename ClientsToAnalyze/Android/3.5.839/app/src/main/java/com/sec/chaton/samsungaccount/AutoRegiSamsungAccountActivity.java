package com.sec.chaton.samsungaccount;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.registration.C3299gf;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import java.io.File;

/* loaded from: classes.dex */
public class AutoRegiSamsungAccountActivity extends AbstractMultiDeviceActivity {

    /* renamed from: B */
    private String f12173B;

    /* renamed from: C */
    private boolean f12174C;

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f12173B);
        }
        this.f12173B = getClass().getSimpleName();
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null && C2349a.m10301a("sms_feature")) {
            this.f12174C = extras.getBoolean("from_lite_user", false);
        }
        if (!C2349a.m10301a("mum_enable_feature")) {
            m13142k();
        } else {
            m13140b(true);
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: f */
    protected void mo12783f() {
        C3299gf c3299gf = new C3299gf(this);
        int iM13045e = c3299gf.m13045e();
        if (iM13045e == 1) {
            String strM13046f = c3299gf.m13046f();
            try {
                if (!TextUtils.isEmpty(strM13046f)) {
                    setContentView(R.layout.layout_settings_seasonal_theme);
                    ((ImageView) findViewById(R.id.seasnltheme)).setImageURI(Uri.fromFile(new File(strM13046f)));
                } else {
                    setContentView(R.layout.layout_settings_starting);
                }
                c3299gf.m13042b();
                return;
            } catch (OutOfMemoryError e) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("drawView :: " + e.toString(), this.f12173B);
                }
                setContentView(R.layout.layout_settings_starting);
                return;
            }
        }
        setContentView(R.layout.layout_settings_starting);
        if (iM13045e == 2) {
            c3299gf.m13043c();
        } else if (iM13045e == 3) {
            c3299gf.m13044d();
        }
        this.f12162p = (TextView) findViewById(R.id.step_comment);
        m13149a(getResources().getConfiguration());
        findViewById(R.id.progress).setVisibility(4);
        findViewById(R.id.loading).setVisibility(4);
        findViewById(R.id.step_comment).setVisibility(0);
        findViewById(R.id.registration_progress).setVisibility(0);
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: g */
    protected void mo12787g() {
        this.f12163q = false;
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: h */
    protected void mo12788h() {
        finish();
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: i */
    protected void mo12789i() {
        this.f12165s = true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C4904y.f17872b) {
            C4904y.m18639b("onConfigurationChanged", getClass().getSimpleName());
        }
        m13149a(configuration);
    }

    /* renamed from: a */
    private void m13149a(Configuration configuration) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (C4904y.f17872b) {
            C4904y.m18639b("densityDpi : " + displayMetrics.densityDpi + " Config : " + configuration, this.f12173B);
        }
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 1) {
            if (defaultDisplay.getRotation() == 0) {
                setRequestedOrientation(1);
                return;
            } else {
                if (2 == defaultDisplay.getRotation()) {
                    setRequestedOrientation(9);
                    return;
                }
                return;
            }
        }
        if (1 == defaultDisplay.getRotation()) {
            setRequestedOrientation(0);
        } else if (3 == defaultDisplay.getRotation()) {
            setRequestedOrientation(8);
        }
    }

    public void onWindowStatusChanged(boolean z, boolean z2, boolean z3) {
        if (GlobalApplication.m10288g()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            View decorView = getWindow().getDecorView();
            if (decorView != null && displayMetrics != null) {
                m13150a(decorView, displayMetrics);
            }
        }
    }

    /* renamed from: a */
    private void m13150a(View view, DisplayMetrics displayMetrics) {
        ImageView imageView = (ImageView) view.findViewById(R.id.logo_on);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.logo_text);
        double d = view.getLayoutParams().width / displayMetrics.widthPixels;
        double d2 = view.getLayoutParams().height / displayMetrics.heightPixels;
        if (d <= 0.0d || d2 <= 0.0d) {
            imageView.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.intro_chaton_image_width);
            imageView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.intro_chaton_image_height);
            imageView2.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.intro_chaton_logo_width);
            imageView2.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.intro_chaton_logo_height);
            return;
        }
        imageView.getLayoutParams().width = (int) (r6.width * d);
        imageView.getLayoutParams().height = (int) (r0.height * d2);
        imageView2.getLayoutParams().width = (int) (d * r0.width);
        imageView2.getLayoutParams().height = (int) (r0.height * d2);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: m */
    protected void mo13144m() {
        if (this.f12174C) {
            m13148q();
            InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this).mo18740a(getResources().getString(R.string.popup_title_confirm)).mo18749b(getResources().getString(R.string.popop_text_full_user_sa)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3329ah(this)).mo18745a();
            interfaceC4936eMo18745a.setCancelable(false);
            if (!this.f12166t) {
                interfaceC4936eMo18745a.show();
                return;
            } else {
                setResult(3);
                finish();
                return;
            }
        }
        super.mo13144m();
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: j */
    protected void mo12790j() {
    }
}
