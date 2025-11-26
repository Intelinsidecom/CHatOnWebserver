package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.an */
/* loaded from: classes.dex */
class C1217an implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4294a;

    C1217an(UserProfileDetail userProfileDetail) {
        this.f4294a = userProfileDetail;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1341p.m4662e("Text changed", getClass().toString());
        if (this.f4294a.f4249r.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4294a.f4225G.setButtonEnabled(false);
        } else {
            this.f4294a.f4225G.setButtonEnabled(true);
        }
        if (this.f4294a.f4249r.isFocused() && this.f4294a.f4249r.length() >= 30) {
            C1341p.m4662e("Text changed", getClass().toString());
            C1619g.m5888a(this.f4294a.f4223E, R.string.setting_input_length_exceed, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1341p.m4662e("Text changed before", getClass().toString());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        C1341p.m4662e("Text changed after", getClass().toString());
    }
}
