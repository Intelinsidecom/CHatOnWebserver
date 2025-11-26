package com.sec.chaton.trunk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.z */
/* loaded from: classes.dex */
class C1620z implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f5771a;

    C1620z(TrunkCommentView trunkCommentView) {
        this.f5771a = trunkCommentView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f5771a.f5439e.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f5771a.f5440f.setEnabled(false);
        } else {
            this.f5771a.f5440f.setEnabled(true);
        }
        if (this.f5771a.f5439e.length() >= 140) {
            Toast.makeText(this.f5771a.f5436b, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
