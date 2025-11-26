package com.sec.chaton;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.util.C4904y;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.n */
/* loaded from: classes.dex */
class C2914n implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f10780a;

    C2914n(AdminMenu adminMenu) {
        this.f10780a = adminMenu;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (C4904y.m18637a(this.f10780a.f1888Y.getText().toString()) || C4904y.m18640b(this.f10780a.f1888Y.getText().toString())) {
            this.f10780a.f1889Z.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
