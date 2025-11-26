package com.sec.chaton.registration;

import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ImageTextViewGroup;

/* loaded from: classes.dex */
public class ActivitySignInWithAccount extends MainActivity {

    /* renamed from: E */
    private ImageTextViewGroup f11555E;

    /* renamed from: F */
    private ImageTextViewGroup f11556F;

    /* renamed from: G */
    private ImageTextViewGroup f11557G;

    /* renamed from: H */
    private ImageTextViewGroup f11558H;

    /* renamed from: I */
    private final String f11559I = ActivitySignInWithAccount.class.getSimpleName();

    @Override // com.sec.chaton.samsungaccount.MainActivity, com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f11559I);
        }
        super.onCreate(bundle);
        this.f12192B = this;
        setTitle(R.string.sign_in_with_sns_account);
    }

    @Override // com.sec.chaton.samsungaccount.MainActivity, com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: f */
    protected void mo12783f() {
        setContentView(R.layout.layout_sign_in_with_account);
        this.f11555E = (ImageTextViewGroup) findViewById(R.id.btn_samsung_account).findViewById(R.id.button4);
        this.f11555E.setGravity(19);
        this.f11555E.setImageResource(R.drawable.sync_ic_account);
        this.f11555E.setText(R.string.setting_samsung_account);
        this.f11555E.setOnClickListener(new ViewOnClickListenerC3305l(this));
        m12782u();
    }

    @Override // com.sec.chaton.samsungaccount.MainActivity, com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onStart", this.f11559I);
        }
        m13190d(true);
        super.onStart();
        String strM18121a = C4809aa.m18104a().m18121a("country_letter", (String) null);
        if (!C4859bx.m18408f((String) null) || !C4859bx.m18408f(strM18121a)) {
            this.f11556F.setVisibility(8);
        } else {
            this.f11556F.setVisibility(0);
        }
        if (!C4859bx.m18411g((String) null) || !C4859bx.m18411g(strM18121a)) {
            this.f11557G.setVisibility(8);
        } else {
            this.f11557G.setVisibility(0);
        }
        if (!C4859bx.m18413h(strM18121a)) {
            this.f11558H.setVisibility(8);
        } else {
            this.f11558H.setVisibility(0);
        }
    }

    /* renamed from: u */
    private void m12782u() {
        this.f11556F = (ImageTextViewGroup) findViewById(R.id.btn_facebook_account).findViewById(R.id.button4);
        this.f11556F.setGravity(19);
        this.f11556F.setImageResource(R.drawable.sync_ic_facebook);
        this.f11556F.setText(R.string.user_facebook_account);
        this.f11556F.setOnClickListener(new ViewOnClickListenerC3306m(this));
        this.f11558H = (ImageTextViewGroup) findViewById(R.id.btn_od_account).findViewById(R.id.button4);
        this.f11558H.setGravity(19);
        this.f11558H.setImageResource(R.drawable.sync_ic_odnoklassniki);
        this.f11558H.setText(R.string.user_od_account);
        this.f11558H.setOnClickListener(new ViewOnClickListenerC3307n(this));
        this.f11557G = (ImageTextViewGroup) findViewById(R.id.btn_vk_account).findViewById(R.id.button4);
        this.f11557G.setGravity(19);
        this.f11557G.setImageResource(R.drawable.sync_ic_vkontakte);
        this.f11557G.setText(R.string.user_vk_account);
        this.f11557G.setOnClickListener(new ViewOnClickListenerC3308o(this));
    }
}
