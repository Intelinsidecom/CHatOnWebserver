package com.sec.chaton.msgbox;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.u */
/* loaded from: classes.dex */
class C1734u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6407a;

    C1734u(MsgboxFragment msgboxFragment) {
        this.f6407a = msgboxFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C3250y.m11456e("beforeTextChanged()", MsgboxFragment.f6228a);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C3250y.m11456e("onTextChanged() Start", "[SEARCH]");
        C3250y.m11456e("onTextChanged()", MsgboxFragment.f6228a);
        this.f6407a.f6246O.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        if (this.f6407a.getResources().getConfiguration().orientation != 2 || charSequence.length() == 0) {
            this.f6407a.m7056p();
        } else {
            this.f6407a.m7058q();
        }
        if (charSequence.length() >= 30) {
            C3641ai.m13210a(this.f6407a.getActivity(), R.string.setting_input_length_exceed, 1).show();
        }
        if (this.f6407a.f6252U.isEnabled()) {
            if (!this.f6407a.f6247P && String.valueOf(charSequence).length() <= 0) {
                C3250y.m11450b("invalid character(empty string) input from keyboard", getClass().getSimpleName());
            }
            if (String.valueOf(charSequence).length() > 0) {
                this.f6407a.f6248Q = true;
                this.f6407a.m7050m();
                this.f6407a.m7052n();
            } else {
                this.f6407a.f6248Q = false;
                this.f6407a.m7054o();
            }
            this.f6407a.f6247P = false;
            C3250y.m11456e("onTextChanged() End", "[SEARCH]");
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        C3250y.m11456e("afterTextChanged()", MsgboxFragment.f6228a);
    }
}
