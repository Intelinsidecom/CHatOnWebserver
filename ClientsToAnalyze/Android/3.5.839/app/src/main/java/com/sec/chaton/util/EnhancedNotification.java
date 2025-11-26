package com.sec.chaton.util;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.common.p123a.AbstractC4932a;

/* loaded from: classes.dex */
public class EnhancedNotification extends BaseActivity {

    /* renamed from: n */
    private String f17562n;

    /* renamed from: o */
    private String f17563o;

    /* renamed from: p */
    private int f17564p;

    /* renamed from: q */
    private Dialog f17565q;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(2621568);
        Bundle extras = getIntent().getExtras();
        this.f17562n = extras.getString("Content");
        this.f17563o = extras.getString("InboxNO");
        this.f17564p = extras.getInt("Chattype");
        m18097f();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f17565q != null) {
            this.f17565q.dismiss();
        }
        Bundle extras = getIntent().getExtras();
        this.f17562n = extras.getString("Content");
        this.f17563o = extras.getString("InboxNO");
        this.f17564p = extras.getInt("Chattype");
        m18097f();
    }

    /* renamed from: f */
    private void m18097f() {
        this.f17565q = AbstractC4932a.m18733a(this).mo18734a(R.string.app_name).mo18749b(this.f17562n).mo18753c(R.drawable.profile_info_ic_chat).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4824ap(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4823ao(this)).mo18745a().mo18758a();
        this.f17565q.show();
    }
}
