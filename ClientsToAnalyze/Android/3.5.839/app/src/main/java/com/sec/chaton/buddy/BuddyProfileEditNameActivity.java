package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2250k;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* loaded from: classes.dex */
public class BuddyProfileEditNameActivity extends BaseActivity {

    /* renamed from: n */
    public static final String f3891n = BuddyProfileEditNameActivity.class.getSimpleName();

    /* renamed from: p */
    C2128i f3895p;

    /* renamed from: s */
    private Context f3898s;

    /* renamed from: t */
    private ClearableEditText f3899t;

    /* renamed from: u */
    private String f3900u;

    /* renamed from: v */
    private C2210x f3901v;

    /* renamed from: w */
    private boolean f3902w;

    /* renamed from: x */
    private String f3903x;

    /* renamed from: y */
    private String f3904y;

    /* renamed from: o */
    String f3894o = C4873ck.m18501b();

    /* renamed from: z */
    private ProgressDialog f3905z = null;

    /* renamed from: q */
    InterfaceC2243d f3896q = new C1307fn(this);

    /* renamed from: A */
    private TextWatcher f3892A = new C1308fo(this);

    /* renamed from: r */
    InterfaceC2211y f3897r = new C1309fp(this);

    /* renamed from: B */
    private Handler f3893B = new HandlerC1310fq(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate()", f3891n);
        setContentView(R.layout.buddy_profile_rename);
        this.f3903x = getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f3904y = getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        this.f3901v = new C2210x(getContentResolver(), this.f3897r);
        this.f3905z = new ProgressDialogC4926s(this, false);
        this.f3905z.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f3895p = new C2128i(this.f3893B);
        m6752f();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f3899t.m18661b(this.f3892A);
        super.onPause();
    }

    /* renamed from: f */
    private void m6752f() {
        this.f3898s = this;
        this.f3899t = (ClearableEditText) findViewById(R.id.buddy_profile_edit_buddyname);
        this.f3899t.setInputType(MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND);
        this.f3899t.setText(this.f3904y);
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f3898s.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f3899t, 1);
            }
        } catch (Exception e) {
        }
        this.f3899t.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1305fl(this));
        this.f3899t.m18659a(this.f3892A);
        this.f3899t.setMaxLength(R.string.toast_text_max_Length);
        this.f3899t.setOnEditorActionListener(new C1306fm(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6753g() {
        this.f3899t.clearFocus();
        m6747a(this.f3899t);
        this.f3900u = this.f3899t.m18658a().toString().trim();
        if (!TextUtils.isEmpty(this.f3900u)) {
            this.f3895p.m9488a("update", false, this.f3900u, "+" + this.f3903x);
            this.f3905z.show();
            C2212z.m10068a(new C2212z(), 2, new C2250k(this.f3896q, this.f3900u, this.f3903x, 2));
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putString("PROFILE_BUDDY_RENAME", this.f3900u);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private void m6747a(ClearableEditText clearableEditText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f3898s.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(clearableEditText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f3899t.m18659a(this.f3892A);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f3905z != null && this.f3905z.isShowing()) {
            this.f3905z.dismiss();
            this.f3905z = null;
        }
    }
}
