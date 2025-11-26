package com.sec.chaton.util;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.common.p063a.AbstractC3271a;

/* loaded from: classes.dex */
public class EnhancedNotification extends BaseActivity {

    /* renamed from: a */
    private String f11461a;

    /* renamed from: b */
    private String f11462b;

    /* renamed from: c */
    private int f11463c;

    /* renamed from: d */
    private Dialog f11464d;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(2621568);
        Bundle extras = getIntent().getExtras();
        this.f11461a = extras.getString("Content");
        this.f11462b = extras.getString("InboxNO");
        this.f11463c = extras.getInt("Chattype");
        m10952a();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f11464d != null) {
            this.f11464d.dismiss();
        }
        Bundle extras = getIntent().getExtras();
        this.f11461a = extras.getString("Content");
        this.f11462b = extras.getString("InboxNO");
        this.f11463c = extras.getInt("Chattype");
        m10952a();
    }

    /* renamed from: a */
    private void m10952a() {
        this.f11464d = AbstractC3271a.m11494a(this).mo11495a(R.string.app_name).mo11509b(this.f11461a).mo11513c(R.drawable.profile_info_ic_chat).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3174ap(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3173ao(this)).mo11505a().mo11517a();
        this.f11464d.show();
    }
}
