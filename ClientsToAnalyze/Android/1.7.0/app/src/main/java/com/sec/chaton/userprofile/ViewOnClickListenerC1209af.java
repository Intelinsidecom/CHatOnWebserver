package com.sec.chaton.userprofile;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.widget.C1619g;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC1209af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4286a;

    ViewOnClickListenerC1209af(UserProfileDetail userProfileDetail) {
        this.f4286a = userProfileDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f4286a.f4249r.getText().toString())) {
            this.f4286a.f4249r.clearFocus();
            this.f4286a.f4226H.setFocusable(true);
            this.f4286a.f4226H.setFocusableInTouchMode(true);
            this.f4286a.f4226H.requestFocus();
            ((InputMethodManager) this.f4286a.getSystemService("input_method")).hideSoftInputFromWindow(this.f4286a.f4249r.getWindowToken(), 0);
            C0260h c0260h = new C0260h();
            c0260h.m939a(this.f4286a.f4249r.getText().toString());
            this.f4286a.f4246o.m873a(c0260h, "");
            this.f4286a.f4253v.show();
            return;
        }
        C1619g.m5888a(this.f4286a.f4223E, R.string.regist_enter_push_name, 0).show();
    }
}
