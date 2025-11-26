package com.sec.chaton.facebook;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: FacebookInvitationCardWriteActivity.java */
/* renamed from: com.sec.chaton.facebook.b */
/* loaded from: classes.dex */
class C0721b implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FacebookInvitationCardWriteActivity f2697a;

    C0721b(FacebookInvitationCardWriteActivity facebookInvitationCardWriteActivity) {
        this.f2697a = facebookInvitationCardWriteActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f2697a.f2688a.length() >= 2000) {
            Toast.makeText(this.f2697a.getApplicationContext(), R.string.toast_text_max_Length, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
