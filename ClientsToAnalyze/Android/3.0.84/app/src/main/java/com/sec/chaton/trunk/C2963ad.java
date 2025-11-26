package com.sec.chaton.trunk;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ad */
/* loaded from: classes.dex */
class C2963ad implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10743a;

    C2963ad(TrunkCommentView trunkCommentView) {
        this.f10743a = trunkCommentView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f10743a.f10506e.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f10743a.f10507f.setEnabled(false);
        } else {
            this.f10743a.f10507f.setEnabled(true);
        }
        if (this.f10743a.f10506e.length() >= 140) {
            C3641ai.m13210a(this.f10743a.f10503b, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
