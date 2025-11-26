package com.sec.chaton.smsplugin.p112ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.util.C4904y;

/* compiled from: ThreadSelectionFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.jf */
/* loaded from: classes.dex */
class C4340jf implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ThreadSelectionFragment f15770a;

    C4340jf(ThreadSelectionFragment threadSelectionFragment) {
        this.f15770a = threadSelectionFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C4904y.m18646e("onTextChanged()", ThreadSelectionFragment.f15167i);
        if (charSequence.length() == 0 || this.f15770a.getResources().getConfiguration().orientation != 2) {
            this.f15770a.m16272k();
        } else {
            this.f15770a.m16275l();
        }
        if (String.valueOf(charSequence).length() > 0) {
            this.f15770a.f15189V = true;
            this.f15770a.m16281a(this.f15770a.f15186S.m18658a().toString());
        } else {
            this.f15770a.f15189V = false;
            m16509a();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* renamed from: a */
    private void m16509a() {
        this.f15770a.f15207x.m16507a("");
        this.f15770a.m16262f();
    }
}
