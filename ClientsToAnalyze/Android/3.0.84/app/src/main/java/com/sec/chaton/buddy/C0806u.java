package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.u */
/* loaded from: classes.dex */
class C0806u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3102a;

    C0806u(AddBuddyFragment addBuddyFragment) {
        this.f3102a = addBuddyFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() == 1 && editable.toString().trim().length() == 0) {
            editable.clear();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.f3102a.f1696q.setEnabled(true);
        } else {
            this.f3102a.f1696q.setEnabled(false);
        }
        this.f3102a.f1695p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        if (charSequence.length() >= 20) {
            C3641ai.m13210a(this.f3102a.f1676X, R.string.toast_text_max_Length, 0).show();
        }
        if (this.f3102a.f1661I != null && this.f3102a.f1661I.getChildCount() > 0) {
            this.f3102a.f1661I.removeAllViews();
        }
    }
}
