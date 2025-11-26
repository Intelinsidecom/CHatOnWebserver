package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyGroupActivity.java */
/* renamed from: com.sec.chaton.buddy.bo */
/* loaded from: classes.dex */
class C0303bo implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f1414a;

    C0303bo(BuddyGroupActivity buddyGroupActivity) {
        this.f1414a = buddyGroupActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        String strReplace = this.f1414a.f1027c.getText().toString().trim().replace(",", "");
        this.f1414a.f1027c.setText(strReplace);
        if (strReplace.length() > 0) {
            this.f1414a.f1028d.setEnabled(false);
            this.f1414a.m2063a(strReplace);
        }
        return true;
    }
}
