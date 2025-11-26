package com.sec.chaton;

import android.os.Bundle;
import com.sec.chaton.registration.AbstractUpgradeDialog;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatONVUpgradeDialog extends AbstractUpgradeDialog {

    /* renamed from: o */
    private final String f1918o = ChatONVUpgradeDialog.class.getSimpleName();

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f1918o);
        }
        this.f11530n.setText(R.string.chaton_voice_video_chat);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", this.f1918o);
        }
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume", this.f1918o);
        }
    }

    @Override // com.sec.chaton.registration.AbstractUpgradeDialog
    /* renamed from: f */
    protected void mo2879f() {
        if (C4904y.f17872b) {
            C4904y.m18639b("initializeView", this.f1918o);
        }
        m12770b(1);
        m12769a(this, 1);
    }
}
