package com.sec.chaton.registration;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ActivitySyncSignInPopup extends AbstractMultiDeviceActivity {

    /* renamed from: B */
    private final String f11560B = ActivitySyncSignInPopup.class.getSimpleName();

    /* renamed from: C */
    private final int f11561C = 5;

    /* renamed from: D */
    private Context f11562D;

    /* renamed from: E */
    private Button f11563E;

    /* renamed from: F */
    private Button f11564F;

    /* renamed from: G */
    private ImageView f11565G;

    /* renamed from: H */
    private TextView f11566H;

    /* renamed from: I */
    private TextView f11567I;

    /* renamed from: J */
    private boolean f11568J;

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onCreate", this.f11560B);
        }
        setContentView(R.layout.layout_pop_up_account);
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (C4904y.f17873c) {
            C4904y.m18641c("onStart", this.f11560B);
        }
        this.f11563E.setOnClickListener(new ViewOnClickListenerC3309p(this));
        this.f11564F.setOnClickListener(new ViewOnClickListenerC3310q(this));
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: f */
    protected void mo12783f() {
        this.f11562D = this;
        this.f11563E = (Button) findViewById(R.id.btn_sync_sign);
        this.f11564F = (Button) findViewById(R.id.btn_not_now);
        this.f11565G = (ImageView) findViewById(R.id.image);
        this.f11566H = (TextView) findViewById(R.id.text1);
        this.f11567I = (TextView) findViewById(R.id.text2);
        this.f11568J = getIntent().getExtras().getBoolean("isSyncContacts", false);
        if (!this.f11568J) {
            this.f11563E.setText(getResources().getString(R.string.settings_sync_contacts));
            this.f11565G.setImageDrawable(getResources().getDrawable(R.drawable.push_popup_sync_contact));
            this.f11566H.setText(getResources().getString(R.string.dialog_contact_sync_comment1_new));
            this.f11567I.setText(getResources().getString(R.string.dialog_contact_sync_comment2));
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: g */
    protected void mo12787g() {
        this.f12163q = true;
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: h */
    protected void mo12788h() {
        this.f11564F.setVisibility(8);
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: i */
    protected void mo12789i() {
        this.f12165s = false;
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 5:
                if (i2 == -1) {
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: j */
    protected void mo12790j() {
    }
}
