package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.sec.chaton.buddy.as */
/* loaded from: classes.dex */
class C0095as implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f636a;

    C0095as(BuddyGroupActivity buddyGroupActivity) {
        this.f636a = buddyGroupActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        String strReplace = this.f636a.f482c.getText().toString().trim().replace(",", "");
        this.f636a.f482c.setText(strReplace);
        if (strReplace.length() > 0) {
            this.f636a.f483d.setEnabled(false);
            this.f636a.m539a(strReplace);
        }
        return true;
    }
}
