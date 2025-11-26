package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.v */
/* loaded from: classes.dex */
class C0807v implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3103a;

    C0807v(AddBuddyFragment addBuddyFragment) {
        this.f3103a = addBuddyFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.f3103a.f1668P.setEnabled(true);
        } else {
            this.f3103a.f1668P.setEnabled(false);
        }
        this.f3103a.f1699t.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        if (charSequence.length() >= 100) {
            C3641ai.m13210a(this.f3103a.f1676X, R.string.toast_text_max_Length, 0).show();
        }
        if (this.f3103a.f1661I != null && this.f3103a.f1661I.getChildCount() > 0) {
            this.f3103a.f1661I.removeAllViews();
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
