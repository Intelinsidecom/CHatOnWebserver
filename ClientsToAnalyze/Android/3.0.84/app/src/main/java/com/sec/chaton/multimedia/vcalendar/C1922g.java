package com.sec.chaton.multimedia.vcalendar;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.g */
/* loaded from: classes.dex */
class C1922g implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f7345a;

    C1922g(VCalendarListFragment vCalendarListFragment) {
        this.f7345a = vCalendarListFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f7345a.m7803a(charSequence.toString());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
