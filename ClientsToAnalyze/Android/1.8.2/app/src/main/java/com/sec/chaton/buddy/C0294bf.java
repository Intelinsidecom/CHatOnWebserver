package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bf */
/* loaded from: classes.dex */
class C0294bf implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1391a;

    C0294bf(BuddyFragment buddyFragment) {
        this.f1391a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30 && this.f1391a.f922J) {
            Toast.makeText(this.f1391a.getActivity(), R.string.toast_text_max_Length, 0).show();
        }
        if (this.f1391a.f924L.getText().toString().replaceAll(" ", "").replaceAll("\n", "").replaceAll(",", "").length() == 0) {
            this.f1391a.f926N.setEnabled(false);
        } else {
            this.f1391a.f926N.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
