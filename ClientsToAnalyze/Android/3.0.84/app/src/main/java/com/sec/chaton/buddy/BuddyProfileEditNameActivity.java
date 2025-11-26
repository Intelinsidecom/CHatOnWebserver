package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1420k;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* loaded from: classes.dex */
public class BuddyProfileEditNameActivity extends BaseActivity {

    /* renamed from: a */
    public static final String f1999a = BuddyProfileEditNameActivity.class.getSimpleName();

    /* renamed from: c */
    C1330h f2001c;

    /* renamed from: f */
    private Context f2004f;

    /* renamed from: g */
    private ClearableEditText f2005g;

    /* renamed from: h */
    private String f2006h;

    /* renamed from: i */
    private C1377u f2007i;

    /* renamed from: j */
    private boolean f2008j;

    /* renamed from: k */
    private String f2009k;

    /* renamed from: l */
    private String f2010l;

    /* renamed from: b */
    String f2000b = C3223ck.m11328b();

    /* renamed from: m */
    private ProgressDialog f2011m = null;

    /* renamed from: d */
    InterfaceC1413d f2002d = new C0676en(this);

    /* renamed from: n */
    private TextWatcher f2012n = new C0677eo(this);

    /* renamed from: e */
    InterfaceC1378v f2003e = new C0678ep(this);

    /* renamed from: o */
    private Handler f2013o = new HandlerC0679eq(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11458g("onCreate()", f1999a);
        setContentView(R.layout.buddy_profile_rename);
        this.f2009k = getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f2010l = getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        this.f2007i = new C1377u(getContentResolver(), this.f2003e);
        this.f2011m = new ProgressDialogC3265l(this, false);
        this.f2011m.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f2001c = new C1330h(this.f2013o);
        m3576a();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f2005g.m11467b(this.f2012n);
        super.onPause();
    }

    /* renamed from: a */
    private void m3576a() {
        this.f2004f = this;
        this.f2005g = (ClearableEditText) findViewById(R.id.buddy_profile_edit_buddyname);
        this.f2005g.setInputType(16384);
        this.f2005g.setText(this.f2010l);
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2004f.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f2005g, 1);
            }
        } catch (Exception e) {
        }
        this.f2005g.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0674el(this));
        this.f2005g.m11464a(this.f2012n);
        this.f2005g.setMaxLength(R.string.toast_text_max_Length);
        this.f2005g.setOnEditorActionListener(new C0675em(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3581b() {
        this.f2005g.clearFocus();
        m3578a(this.f2005g);
        this.f2006h = this.f2005g.m11463a().toString().trim();
        if (!TextUtils.isEmpty(this.f2006h)) {
            this.f2001c.m5715a("update", false, this.f2006h, "+" + this.f2009k);
            this.f2011m.show();
            C1379w.m6203a(new C1379w(), 2, new C1420k(this.f2002d, this.f2006h, this.f2009k, 2));
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putString("PROFILE_BUDDY_RENAME", this.f2006h);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private void m3578a(ClearableEditText clearableEditText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2004f.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(clearableEditText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2005g.m11464a(this.f2012n);
        m3583c();
    }

    /* renamed from: c */
    private void m3583c() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f2011m != null && this.f2011m.isShowing()) {
            this.f2011m.dismiss();
            this.f2011m = null;
        }
    }
}
