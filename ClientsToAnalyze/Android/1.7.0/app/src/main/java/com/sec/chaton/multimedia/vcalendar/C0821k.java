package com.sec.chaton.multimedia.vcalendar;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.k */
/* loaded from: classes.dex */
class C0821k implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f2820a;

    C0821k(VCalendarListFragment vCalendarListFragment) {
        this.f2820a = vCalendarListFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f2820a.m3328a(charSequence.toString());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
