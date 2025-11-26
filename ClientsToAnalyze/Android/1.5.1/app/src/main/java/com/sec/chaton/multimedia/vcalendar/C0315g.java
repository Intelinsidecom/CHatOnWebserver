package com.sec.chaton.multimedia.vcalendar;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.sec.chaton.multimedia.vcalendar.g */
/* loaded from: classes.dex */
class C0315g implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f2272a;

    C0315g(VCalendarListFragment vCalendarListFragment) {
        this.f2272a = vCalendarListFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        this.f2272a.m2600e();
        this.f2272a.m2592a(charSequence.toString());
    }
}
