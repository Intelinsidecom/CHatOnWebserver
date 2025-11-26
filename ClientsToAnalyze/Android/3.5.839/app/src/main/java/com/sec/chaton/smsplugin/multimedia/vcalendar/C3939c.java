package com.sec.chaton.smsplugin.multimedia.vcalendar;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: MmsVCalendarListFragment.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.vcalendar.c */
/* loaded from: classes.dex */
class C3939c implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MmsVCalendarListFragment f14200a;

    C3939c(MmsVCalendarListFragment mmsVCalendarListFragment) {
        this.f14200a = mmsVCalendarListFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f14200a.m15204a(charSequence.toString());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
