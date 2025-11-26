package com.sec.chaton;

import android.os.Bundle;
import com.sec.chaton.registration.AbstractUpgradeDialog;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatONVUpgradeDialog extends AbstractUpgradeDialog {

    /* renamed from: b */
    private final String f670b = ChatONVUpgradeDialog.class.getSimpleName();

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreate", this.f670b);
        }
        this.f8076a.setText(R.string.chaton_voice_video_chat);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy", this.f670b);
        }
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onResume", this.f670b);
        }
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog
    /* renamed from: a */
    protected void mo1132a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("initializeView", this.f670b);
        }
        m8387b(1);
        m8386a(this, 1);
    }
}
