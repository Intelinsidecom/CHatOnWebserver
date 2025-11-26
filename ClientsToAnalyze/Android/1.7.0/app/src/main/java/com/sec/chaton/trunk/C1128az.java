package com.sec.chaton.trunk;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.az */
/* loaded from: classes.dex */
class C1128az implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3938a;

    C1128az(TrunkCommentView trunkCommentView) {
        this.f3938a = trunkCommentView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3938a.f3757e.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f3938a.f3758f.setEnabled(false);
        } else {
            this.f3938a.f3758f.setEnabled(true);
        }
        if (this.f3938a.f3757e.length() >= 140) {
            C1619g.m5888a(this.f3938a.f3754b, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
