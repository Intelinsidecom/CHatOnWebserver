package com.sec.chaton.shop.inappbilling;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.shop.inappbilling.p100a.C3741d;
import com.sec.chaton.shop.inappbilling.p100a.C3756s;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3748k;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3750m;
import com.sec.chaton.shop.inappbilling.p100a.InterfaceC3752o;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class BillingDialogActivity extends PasswordLockActivity {

    /* renamed from: b */
    public static final String f13419b = BillingDialogActivity.class.getSimpleName();

    /* renamed from: a */
    Context f13420a;

    /* renamed from: c */
    C3741d f13421c;

    /* renamed from: d */
    Activity f13422d;

    /* renamed from: i */
    private String f13427i;

    /* renamed from: j */
    private String f13428j;

    /* renamed from: k */
    private String f13429k;

    /* renamed from: l */
    private String f13430l;

    /* renamed from: m */
    private InterfaceC4936e f13431m;

    /* renamed from: n */
    private boolean f13432n;

    /* renamed from: o */
    private boolean f13433o;

    /* renamed from: p */
    private boolean f13434p;

    /* renamed from: h */
    private Dialog f13426h = null;

    /* renamed from: e */
    InterfaceC3752o f13423e = new C3758b(this);

    /* renamed from: f */
    InterfaceC3750m f13424f = new C3759c(this);

    /* renamed from: g */
    InterfaceC3748k f13425g = new C3760d(this);

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f13420a = this;
        if (bundle == null) {
            this.f13432n = true;
            this.f13422d = this;
            String packageName = GlobalApplication.m18732r().getPackageName();
            if (!Config.CHATON_PACKAGE_NAME.equals(packageName) && !"com.sec.chatonforcanada".equals(packageName)) {
                C5179v.m19810a(getApplicationContext(), R.string.toast_error, 0).show();
                finish();
                return;
            }
            Intent intent = getIntent();
            this.f13430l = intent.getStringExtra("item_type");
            this.f13428j = intent.getStringExtra("item_id");
            this.f13429k = intent.getStringExtra("market_code");
            this.f13427i = intent.getStringExtra("product_id");
            String stringExtra = intent.getStringExtra("market_data");
            if (this.f13427i != null) {
                this.f13427i = this.f13427i.toLowerCase();
            }
            if (!m14086b()) {
                if (this.f13432n) {
                    this.f13421c = new C3741d(this.f13422d, stringExtra);
                    this.f13421c.m14117a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Starting setup.", f13419b);
                    }
                    this.f13421c.m14111a(new C3737a(this));
                    m14088c();
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    setFinishOnTouchOutside(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f13432n = false;
        if (this.f13421c != null) {
            this.f13421c.m14108a();
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m14086b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.shop.inappbilling.BillingDialogActivity.m14086b():boolean");
    }

    /* renamed from: c */
    private void m14088c() {
        if (C4904y.f17872b) {
            C4904y.m18641c("showAlertDailog", f13419b);
        }
        this.f13431m = AbstractC4932a.m18733a(this.f13420a).mo18745a();
        this.f13431m.setCancelable(false);
        this.f13431m.setCanceledOnTouchOutside(false);
        this.f13431m.show();
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onActivityResult(" + i + "," + i2 + "," + intent, f13419b);
        }
        if (this.f13421c == null) {
            m14083a(0, null);
        } else if (!this.f13421c.m14119a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        } else if (C4904y.f17872b) {
            C4904y.m18639b("onActivityResult handled by IABUtil.", f13419b);
        }
    }

    /* renamed from: a */
    boolean m14094a(C3756s c3756s) {
        if (c3756s == null) {
            return false;
        }
        c3756s.m14139c();
        return true;
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("Destroying helper.", f13419b);
        }
        if (this.f13421c != null) {
            this.f13421c.m14108a();
        }
        this.f13421c = null;
        if (this.f13431m != null && this.f13431m.isShowing()) {
            this.f13431m.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14083a(int i, Intent intent) {
        if (C4904y.f17872b) {
            C4904y.m18639b("sendBillingData.", f13419b);
        }
        setResult(i, intent);
        if (this.f13421c != null) {
            this.f13421c.m14108a();
        }
        this.f13421c = null;
        if (this.f13431m != null && this.f13431m.isShowing()) {
            this.f13431m.dismiss();
        }
        finish();
    }

    /* renamed from: a */
    void m14093a(boolean z) {
        if (z) {
            m14090d();
        } else if (this.f13426h != null) {
            this.f13426h.dismiss();
        }
    }

    /* renamed from: d */
    private void m14090d() {
        if (this.f13426h == null) {
            this.f13426h = new C4923p(this.f13422d).m18724a(R.string.setting_webview_please_wait);
            this.f13426h.setCancelable(false);
            this.f13426h.setCanceledOnTouchOutside(false);
        }
        if (this.f13426h != null) {
            this.f13426h.show();
        }
    }

    /* renamed from: a */
    void m14092a(String str) {
        if (C4904y.f17875e) {
            C4904y.m18634a(str, f13419b);
        }
    }

    /* renamed from: a */
    void m14091a() {
        getPreferences(0).edit().commit();
    }
}
