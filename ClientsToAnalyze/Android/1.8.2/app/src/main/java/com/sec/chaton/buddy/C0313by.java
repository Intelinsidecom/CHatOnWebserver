package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0680g;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.by */
/* loaded from: classes.dex */
class C0313by implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1432a;

    C0313by(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1432a = buddyGroupEditActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1432a.m2069a(this.f1432a.f1063p);
        this.f1432a.f1048P = this.f1432a.f1063p.getText().toString().trim();
        this.f1432a.f1048P = this.f1432a.f1048P.replace(",", "");
        if (this.f1432a.f1048P.length() > 0 && !"".equals(this.f1432a.f1048P)) {
            C0668l.m3077a(new C0668l(), 3, new C0680g(this.f1432a.f1060m, this.f1432a.f1048P, 3));
        }
        return true;
    }
}
