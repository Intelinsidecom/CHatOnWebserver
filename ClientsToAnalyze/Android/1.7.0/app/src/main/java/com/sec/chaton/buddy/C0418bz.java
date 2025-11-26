package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.widget.C1619g;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bz */
/* loaded from: classes.dex */
class C0418bz implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1393a;

    C0418bz(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1393a = addBuddyFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 100) {
            C1619g.m5888a(this.f1393a.getActivity(), R.string.toast_text_max_Length, 0).show();
        }
        if (this.f1393a.f1083v != null && this.f1393a.f1083v.getChildCount() > 0) {
            this.f1393a.f1083v.removeAllViews();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() == 1 && editable.toString().trim().length() == 0) {
            editable.clear();
        }
    }
}
