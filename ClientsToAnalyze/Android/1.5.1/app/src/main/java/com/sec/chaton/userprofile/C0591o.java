package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.userprofile.o */
/* loaded from: classes.dex */
class C0591o implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f3588a;

    C0591o(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f3588a = profileRegistStatusMessage;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3588a.f3356b.length() >= 40) {
            Toast.makeText(this.f3588a.f3355a, C0062R.string.setting_input_length_exceed, 1).show();
        }
    }
}
