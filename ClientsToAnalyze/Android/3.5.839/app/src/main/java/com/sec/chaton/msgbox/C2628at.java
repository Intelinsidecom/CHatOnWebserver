package com.sec.chaton.msgbox;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.at */
/* loaded from: classes.dex */
class C2628at implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9477a;

    C2628at(MsgboxFragment msgboxFragment) {
        this.f9477a = msgboxFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C4904y.m18646e("onTextChanged()", MsgboxFragment.f9318i);
        if (charSequence.length() == 0 || this.f9477a.getResources().getConfiguration().orientation != 2) {
            this.f9477a.m11077o();
        } else {
            this.f9477a.m11079p();
        }
        if (this.f9477a.f9360o != 0) {
            String string = this.f9477a.f9344W.m18658a().toString();
            if (String.valueOf(string).length() > 0) {
                this.f9477a.f9346Y = true;
                this.f9477a.m11098a(string);
            } else if (i == 0 && i3 == 0 && i2 > 0) {
                this.f9477a.f9346Y = false;
                m11164a();
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* renamed from: a */
    private void m11164a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("resetSearchCursor()", MsgboxFragment.f9318i);
        }
        this.f9477a.f9324C.m11159b("");
        this.f9477a.f9341T = true;
        this.f9477a.m11075n();
    }
}
