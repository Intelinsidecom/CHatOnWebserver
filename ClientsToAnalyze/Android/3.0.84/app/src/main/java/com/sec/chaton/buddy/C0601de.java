package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.de */
/* loaded from: classes.dex */
class C0601de implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0599dc f2593a;

    C0601de(AlertDialogC0599dc alertDialogC0599dc) {
        this.f2593a = alertDialogC0599dc;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        if (!this.f2593a.m4070b()) {
            if (this.f2593a.f2587j.m11463a().toString().trim().replace(",", "").length() > 30) {
                Toast.makeText(this.f2593a.f2588k, R.string.toast_text_max_Length, 0).show();
            } else {
                this.f2593a.m4073c();
                this.f2593a.dismiss();
            }
        } else {
            this.f2593a.dismiss();
        }
        BuddyFragment.f1734m = true;
        return true;
    }
}
