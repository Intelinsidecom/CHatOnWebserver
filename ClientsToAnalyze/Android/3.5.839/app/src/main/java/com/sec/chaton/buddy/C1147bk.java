package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.buddy.p050a.C1104a;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.util.C4840be;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bk */
/* loaded from: classes.dex */
class C1147bk implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4366a;

    C1147bk(BuddyFragment buddyFragment) {
        this.f4366a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C4904y.m18639b("beforeTextChanged() : " + this.f4366a.f3627aH, BuddyFragment.f3576a);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Resources.NotFoundException {
        C4904y.m18639b("onTextChanged() : " + this.f4366a.f3627aH, BuddyFragment.f3576a);
        if (this.f4366a.getResources().getConfiguration().orientation != 2 || charSequence.length() == 0 || this.f4366a.f3660ao != 1) {
            this.f4366a.m6418ai();
            this.f4366a.m6608k();
        } else {
            this.f4366a.m6421aj();
            this.f4366a.f3713br.setVisibility(8);
        }
        if (this.f4366a.f3660ao != 7 && this.f4366a.f3665at.size() != 0) {
            if (!this.f4366a.f3718bw && String.valueOf(charSequence).length() <= 0) {
                C4904y.m18639b("invalid character(empty string) input from keyboard", getClass().getSimpleName());
            }
            this.f4366a.m6289D();
            if (String.valueOf(charSequence).length() <= 0) {
                this.f4366a.f3623aD = false;
                if (this.f4366a.f3658am == 11 && this.f4366a.f3602I != null) {
                    this.f4366a.f3602I.setFastScrollEnabled(true);
                }
                if (this.f4366a.f3602I != null) {
                    this.f4366a.f3602I.setVisibility(0);
                }
                this.f4366a.f3615V.setVisibility(8);
                this.f4366a.m6371a((ArrayList<C1104a>) this.f4366a.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4366a.f3666au);
                this.f4366a.m6293F();
            } else if (C4840be.m18315b(charSequence.charAt(0)) || C4840be.m18316c(charSequence.charAt(0)) || charSequence.charAt(0) == 9676) {
                if (this.f4366a.f3602I != null) {
                    this.f4366a.f3602I.setVisibility(8);
                }
                this.f4366a.f3615V.setVisibility(0);
                return;
            } else {
                this.f4366a.f3623aD = true;
                if (this.f4366a.f3602I != null) {
                    this.f4366a.f3602I.setFastScrollEnabled(false);
                }
                this.f4366a.f3621aB.m7400a(21);
            }
            this.f4366a.f3718bw = false;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        C4904y.m18639b("afterTextChanged() : " + this.f4366a.f3627aH, BuddyFragment.f3576a);
    }
}
