package com.sec.chaton.settings.tellfriends;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FacebookMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.b */
/* loaded from: classes.dex */
class C1372b implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FacebookMessageActivity f5201a;

    C1372b(FacebookMessageActivity facebookMessageActivity) {
        this.f5201a = facebookMessageActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 0 || charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f5201a.f4929l = false;
        } else {
            this.f5201a.f4929l = true;
        }
        this.f5201a.invalidateOptionsMenu();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
