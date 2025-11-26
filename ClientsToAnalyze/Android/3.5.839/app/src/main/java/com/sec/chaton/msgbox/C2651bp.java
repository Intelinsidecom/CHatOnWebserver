package com.sec.chaton.msgbox;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.bp */
/* loaded from: classes.dex */
class C2651bp implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f9509a;

    C2651bp(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f9509a = msgboxSelectionFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C4904y.m18646e("onTextChanged()", MsgboxSelectionFragment.f9372i);
        if (charSequence.length() == 0 || this.f9509a.getResources().getConfiguration().orientation != 2) {
            this.f9509a.m11135p();
        } else {
            this.f9509a.m11138q();
        }
        if (this.f9509a.f9395W != 0) {
            String string = this.f9509a.f9391S.m18658a().toString();
            if (String.valueOf(string).length() > 0) {
                this.f9509a.f9394V = true;
                this.f9509a.m11142a(string);
            } else if (i == 0 && i3 == 0 && i2 > 0) {
                this.f9509a.f9394V = false;
                m11166a();
            }
            if (this.f9509a.f9410v != null) {
                this.f9509a.f9410v.clearChoices();
                this.f9509a.m11130m();
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* renamed from: a */
    private void m11166a() {
        this.f9509a.f9411w.m11159b("");
        this.f9509a.m11122i();
    }
}
