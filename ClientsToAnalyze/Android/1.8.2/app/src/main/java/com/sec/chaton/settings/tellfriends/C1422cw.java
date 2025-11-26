package com.sec.chaton.settings.tellfriends;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TwitterMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cw */
/* loaded from: classes.dex */
class C1422cw implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TwitterMessageActivity f5303a;

    C1422cw(TwitterMessageActivity twitterMessageActivity) {
        this.f5303a = twitterMessageActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f5303a.f5087g.setText(this.f5303a.m4996a(this.f5303a.f5086f.getText().toString()));
        boolean z = this.f5303a.f5085e;
        if (this.f5303a.f5086f.getText().toString().replaceAll(" ", "").replaceAll("\n", "").trim().length() < 1) {
            this.f5303a.f5085e = false;
        } else {
            this.f5303a.f5085e = true;
        }
        if (z != this.f5303a.f5085e) {
            this.f5303a.invalidateOptionsMenu();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
