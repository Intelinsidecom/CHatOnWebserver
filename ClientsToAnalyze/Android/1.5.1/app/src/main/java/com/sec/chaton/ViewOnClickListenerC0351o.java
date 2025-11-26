package com.sec.chaton;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityAbout;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC0351o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f2584a;

    ViewOnClickListenerC0351o(UpgradeDialog upgradeDialog) {
        this.f2584a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2584a.finish();
        GlobalApplication.m2384a(this.f2584a);
        if (TextUtils.isEmpty(ChatONPref.m3519a().getString("UpdateUrl", ""))) {
            Toast.makeText(this.f2584a, C0062R.string.toast_network_unable, 0).show();
        } else {
            ActivityAbout.m3120a(this.f2584a);
        }
    }
}
