package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.ba */
/* loaded from: classes.dex */
class C0104ba implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f647a;

    C0104ba(BuddyFragment buddyFragment) {
        this.f647a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ChatONLogWriter.m3512f("afterTextChanged() : " + this.f647a.f437ab, BuddyFragment.f409a);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ChatONLogWriter.m3512f("beforeTextChanged() : " + this.f647a.f437ab, BuddyFragment.f409a);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        ChatONLogWriter.m3512f("onTextChanged() : " + this.f647a.f437ab, BuddyFragment.f409a);
        this.f647a.m508n();
        if (this.f647a.f419J == 7 || this.f647a.f422M.size() == 0) {
            return;
        }
        this.f647a.m513p();
        this.f647a.m503k();
        if (String.valueOf(charSequence).length() > 0) {
            this.f647a.f434Y = true;
            this.f647a.f456l.setFastScrollEnabled(false);
            this.f647a.f431V.m528a(21);
            return;
        }
        this.f647a.f434Y = false;
        if (this.f647a.f417H == 11) {
            this.f647a.f456l.setFastScrollEnabled(true);
        }
        this.f647a.f430U.m440a(this.f647a.f417H);
        this.f647a.f456l.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f647a.f463s.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f647a.m473a(this.f647a.f422M, this.f647a.f423N);
        this.f647a.m506m();
    }
}
