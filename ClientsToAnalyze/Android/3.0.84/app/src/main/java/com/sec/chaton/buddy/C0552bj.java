package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.buddy.p019a.C0511a;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.util.C3190be;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bj */
/* loaded from: classes.dex */
class C0552bj implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2511a;

    C0552bj(BuddyFragment buddyFragment) {
        this.f2511a = buddyFragment;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C3250y.m11458g("beforeTextChanged() : " + this.f2511a.f1809au, BuddyFragment.f1724a);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C3250y.m11458g("onTextChanged() : " + this.f2511a.f1809au, BuddyFragment.f1724a);
        if (this.f2511a.getResources().getConfiguration().orientation != 2 || charSequence.length() == 0 || this.f2511a.f1791ac != 1) {
            this.f2511a.m3332al();
        } else {
            this.f2511a.m3334am();
        }
        if (this.f2511a.f1791ac != 7 && this.f2511a.f1796ah.size() != 0) {
            if (!BuddyFragment.f1731i && String.valueOf(charSequence).length() <= 0) {
                C3250y.m11450b("invalid character(empty string) input from keyboard", getClass().getSimpleName());
            }
            this.f2511a.m3228H();
            if (String.valueOf(charSequence).length() > 0) {
                if (C3190be.m11141b(charSequence.charAt(0)) || C3190be.m11142c(charSequence.charAt(0)) || charSequence.charAt(0) == 9676) {
                    this.f2511a.f1738B.setVisibility(8);
                    this.f2511a.f1747K.setVisibility(0);
                    return;
                } else {
                    this.f2511a.f1806ar = true;
                    this.f2511a.f1738B.setFastScrollEnabled(false);
                    this.f2511a.f1804ap.m4051a(21);
                }
            } else {
                if (BuddyFragment.f1731i) {
                    this.f2511a.f1806ar = false;
                    this.f2511a.m3214A();
                    if (this.f2511a.f1789aa == 11) {
                        this.f2511a.f1738B.setFastScrollEnabled(true);
                    }
                    this.f2511a.f1738B.setVisibility(0);
                    this.f2511a.f1747K.setVisibility(8);
                    this.f2511a.m3284a((ArrayList<C0511a>) this.f2511a.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2511a.f1797ai);
                    this.f2511a.m3232J();
                } else {
                    this.f2511a.f1738B.setFastScrollEnabled(false);
                    this.f2511a.f1804ap.m4051a(21);
                }
                this.f2511a.m3214A();
                this.f2511a.f1804ap.m4054b();
            }
            BuddyFragment.f1731i = false;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        C3250y.m11458g("afterTextChanged() : " + this.f2511a.f1809au, BuddyFragment.f1724a);
    }
}
