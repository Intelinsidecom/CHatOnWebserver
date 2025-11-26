package com.sec.chaton.chat;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.z */
/* loaded from: classes.dex */
class C1142z implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4567a;

    C1142z(ChatFragment chatFragment) {
        this.f4567a = chatFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null && i2 != i3) {
            String string = charSequence.toString();
            int length = string.length();
            boolean zMatches = string.matches("(\\s)+");
            if (this.f4567a.f3582bE.isEnabled() && length == 10001) {
                this.f4567a.f3528aD.setText(R.string.toast_text_max_Length);
                this.f4567a.f3528aD.setDuration(0);
                this.f4567a.f3528aD.show();
                this.f4567a.f3613bj.setText(string.substring(0, 10000));
                this.f4567a.f3613bj.setSelection(10000);
                return;
            }
            if (!zMatches && length > 0) {
                this.f4567a.f3582bE.setEnabled(true);
                this.f4567a.f3583bF.setEnabled(true);
                if (!this.f4567a.f3646cR || !this.f4567a.f3647cS) {
                    this.f4567a.f3582bE.setVisibility(0);
                    this.f4567a.f3583bF.setVisibility(8);
                } else if (this.f4567a.f3648cT) {
                    this.f4567a.f3583bF.setVisibility(8);
                    this.f4567a.f3582bE.setVisibility(0);
                } else {
                    this.f4567a.f3583bF.setVisibility(0);
                    this.f4567a.f3582bE.setVisibility(8);
                }
                this.f4567a.f3603bZ.setVisibility(8);
                return;
            }
            if (zMatches || length == 0) {
                this.f4567a.f3582bE.setEnabled(false);
                this.f4567a.f3583bF.setEnabled(false);
                if (this.f4567a.f3553ac) {
                    this.f4567a.f3582bE.setEnabled(true);
                    this.f4567a.f3582bE.setVisibility(0);
                    this.f4567a.f3603bZ.setVisibility(8);
                    if (this.f4567a.f3646cR && this.f4567a.f3647cS && !this.f4567a.f3648cT) {
                        this.f4567a.f3583bF.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (!this.f4567a.f3646cR || !this.f4567a.f3647cS || this.f4567a.f3648cT) {
                    this.f4567a.f3582bE.setEnabled(false);
                    this.f4567a.f3582bE.setVisibility(0);
                    this.f4567a.f3583bF.setVisibility(8);
                } else {
                    this.f4567a.f3583bF.setEnabled(false);
                    this.f4567a.f3583bF.setVisibility(0);
                    this.f4567a.f3582bE.setVisibility(8);
                }
                if (this.f4567a.f3621br) {
                    this.f4567a.f3582bE.setVisibility(8);
                    this.f4567a.f3583bF.setVisibility(8);
                    this.f4567a.f3603bZ.setVisibility(0);
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
