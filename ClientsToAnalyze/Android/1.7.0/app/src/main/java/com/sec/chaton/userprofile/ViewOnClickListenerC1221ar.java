package com.sec.chaton.userprofile;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.widget.C1619g;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC1221ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f4298a;

    ViewOnClickListenerC1221ar(ProfileRegistPushName profileRegistPushName) {
        this.f4298a = profileRegistPushName;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.btnDone == view.getId()) {
            if (!TextUtils.isEmpty(this.f4298a.f4174b.getText().toString())) {
                C0260h c0260h = new C0260h();
                c0260h.m939a(this.f4298a.f4174b.getText().toString());
                this.f4298a.f4178f.m873a(c0260h, "");
                this.f4298a.f4179g.show();
                return;
            }
            C1619g.m5888a(this.f4298a.f4173a, R.string.regist_enter_push_name, 0).show();
            return;
        }
        if (R.id.btnCancel == view.getId()) {
            this.f4298a.setResult(0);
            this.f4298a.m4341a();
            this.f4298a.finish();
        }
    }
}
