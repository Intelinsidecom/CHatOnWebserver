package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: WeiboTextInputLayout.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ea */
/* loaded from: classes.dex */
class C1454ea implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1452dz f5358a;

    C1454ea(ViewOnClickListenerC1452dz viewOnClickListenerC1452dz) {
        this.f5358a = viewOnClickListenerC1452dz;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = editable.toString();
        boolean z = this.f5358a.f5354h;
        if (string.replaceAll(" ", "").replaceAll("\n", "").trim().length() < 1) {
            this.f5358a.f5354h = false;
        } else {
            this.f5358a.f5354h = true;
        }
        if (z != this.f5358a.f5354h) {
            ((Activity) this.f5358a.f5348b).invalidateOptionsMenu();
        }
        this.f5358a.f5349c.setText(String.format("(%d/%d)", Integer.valueOf(this.f5358a.f5355i.m5195a(string)), Integer.valueOf(this.f5358a.f5352f)));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
