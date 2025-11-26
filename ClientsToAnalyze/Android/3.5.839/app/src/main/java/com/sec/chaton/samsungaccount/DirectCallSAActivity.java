package com.sec.chaton.samsungaccount;

import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class DirectCallSAActivity extends AbstractMultiDeviceActivity {

    /* renamed from: B */
    private final String f12175B = DirectCallSAActivity.class.getSimpleName();

    /* renamed from: C */
    private Bundle f12176C;

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onCreate", this.f12175B);
        }
        this.f12176C = getIntent().getExtras();
        setContentView(R.layout.layout_full_transparent);
        super.onCreate(bundle);
        m13141c(true);
        if (!C2349a.m10301a("mum_enable_feature")) {
            m13142k();
        } else {
            m13140b(true);
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: f */
    protected void mo12783f() {
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: g */
    protected void mo12787g() {
        if (this.f12176C != null) {
            this.f12163q = this.f12176C.getBoolean("is_mapping_mode", false);
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: h */
    protected void mo12788h() {
        finish();
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: i */
    protected void mo12789i() {
        this.f12165s = false;
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: j */
    protected void mo12790j() {
    }
}
