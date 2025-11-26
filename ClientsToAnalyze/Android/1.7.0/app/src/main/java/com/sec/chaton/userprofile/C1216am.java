package com.sec.chaton.userprofile;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.chaton.util.C1341p;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.am */
/* loaded from: classes.dex */
class C1216am implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4293a;

    C1216am(UserProfileDetail userProfileDetail) {
        this.f4293a = userProfileDetail;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        if (this.f4293a.f4225G.m5854a()) {
            C1341p.m4662e("mypage_header.isEnabled() : " + this.f4293a.f4225G.m5854a(), getClass().getSimpleName());
            this.f4293a.f4249r.clearFocus();
            this.f4293a.f4226H.requestFocus();
            ((InputMethodManager) this.f4293a.getSystemService("input_method")).hideSoftInputFromWindow(this.f4293a.f4249r.getWindowToken(), 0);
            C0260h c0260h = new C0260h();
            c0260h.m939a(this.f4293a.f4249r.getText().toString());
            this.f4293a.f4246o.m873a(c0260h, "");
            this.f4293a.f4253v.show();
            return true;
        }
        C1341p.m4662e("mypage_header.isEnabled() : " + this.f4293a.f4225G.m5854a(), getClass().getSimpleName());
        return false;
    }
}
