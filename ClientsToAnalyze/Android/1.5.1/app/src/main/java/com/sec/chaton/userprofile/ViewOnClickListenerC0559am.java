package com.sec.chaton.userprofile;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.UserProfileEntry;

/* renamed from: com.sec.chaton.userprofile.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC0559am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f3538a;

    ViewOnClickListenerC0559am(ProfileRegistPushName profileRegistPushName) {
        this.f3538a = profileRegistPushName;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0062R.id.btnDone != view.getId()) {
            if (C0062R.id.btnCancel == view.getId()) {
                this.f3538a.setResult(0);
                this.f3538a.finish();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f3538a.f3346b.getText().toString())) {
            Toast.makeText(this.f3538a.f3345a, C0062R.string.regist_enter_push_name, 0).show();
            return;
        }
        UserProfileEntry userProfileEntry = new UserProfileEntry();
        userProfileEntry.m1965a(this.f3538a.f3346b.getText().toString());
        this.f3538a.f3351g.m2065a(userProfileEntry, "");
        this.f3538a.f3352h.show();
    }
}
