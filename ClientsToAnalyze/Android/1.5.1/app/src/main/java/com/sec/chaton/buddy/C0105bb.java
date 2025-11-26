package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.buddy.bb */
/* loaded from: classes.dex */
class C0105bb implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f648a;

    C0105bb(BuddyFragment buddyFragment) {
        this.f648a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30 && this.f648a.f466v) {
            Toast.makeText(this.f648a.getActivity(), C0062R.string.toast_text_max_Length, 0).show();
        }
        if (this.f648a.f467w.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f648a.f469y.setEnabled(false);
        } else {
            this.f648a.f469y.setEnabled(true);
        }
    }
}
