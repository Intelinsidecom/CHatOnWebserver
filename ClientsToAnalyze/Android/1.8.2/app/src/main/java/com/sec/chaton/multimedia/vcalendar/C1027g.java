package com.sec.chaton.multimedia.vcalendar;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.g */
/* loaded from: classes.dex */
class C1027g implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f3770a;

    C1027g(VCalendarListFragment vCalendarListFragment) {
        this.f3770a = vCalendarListFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 1024) {
            C2153y.m7535a(this.f3770a.getActivity(), R.string.toast_text_max_Length, 0).show();
        }
        this.f3770a.m3973a(charSequence.toString());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
