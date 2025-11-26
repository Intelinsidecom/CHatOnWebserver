package com.sec.chaton.userprofile;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.bg */
/* loaded from: classes.dex */
class C1657bg implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f6148a;

    C1657bg(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f6148a = profileRegistStatusMessage;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6148a.f5966b.length() >= 40) {
            Toast.makeText(this.f6148a.f5965a, R.string.setting_input_length_exceed, 1).show();
        }
    }
}
