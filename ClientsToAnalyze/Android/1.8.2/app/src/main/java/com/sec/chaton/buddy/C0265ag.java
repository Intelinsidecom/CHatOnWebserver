package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ag */
/* loaded from: classes.dex */
class C0265ag implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1360a;

    C0265ag(BuddyFragment buddyFragment) {
        this.f1360a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C1786r.m6067f("buddySelectAddGroupWatcher : " + charSequence.toString().trim().replace(",", "").length(), BuddyFragment.f908a);
        if (charSequence.toString().trim().replace(",", "").length() > 0) {
            this.f1360a.getActivity().findViewById(R.id.actionbar_menu_done).setEnabled(true);
        } else {
            this.f1360a.getActivity().findViewById(R.id.actionbar_menu_done).setEnabled(false);
        }
    }
}
