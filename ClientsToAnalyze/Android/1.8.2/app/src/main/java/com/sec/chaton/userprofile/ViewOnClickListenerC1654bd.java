package com.sec.chaton.userprofile;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0107h;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1654bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f6145a;

    ViewOnClickListenerC1654bd(ProfileRegistPushName profileRegistPushName) {
        this.f6145a = profileRegistPushName;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.btnDone == view.getId()) {
            if (!TextUtils.isEmpty(this.f6145a.f5956b.getText().toString())) {
                C0107h c0107h = new C0107h();
                c0107h.m683a(this.f6145a.f5956b.getText().toString());
                this.f6145a.f5961j.m2963a(c0107h, "");
                this.f6145a.f5962k.show();
                return;
            }
            Toast.makeText(this.f6145a.f5955a, R.string.regist_enter_push_name, 0).show();
            return;
        }
        if (R.id.btnCancel == view.getId()) {
            this.f6145a.setResult(0);
            this.f6145a.finish();
        }
    }
}
