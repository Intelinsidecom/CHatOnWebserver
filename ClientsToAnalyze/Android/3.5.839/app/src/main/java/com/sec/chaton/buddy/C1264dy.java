package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dy */
/* loaded from: classes.dex */
class C1264dy implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4797a;

    C1264dy(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4797a = alertDialogC1262dw;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        if (!this.f4797a.m7420b()) {
            if (this.f4797a.f4791j.m18658a().toString().trim().replace(",", "").length() > 30) {
                Toast.makeText(this.f4797a.f4792k, R.string.toast_text_max_Length, 0).show();
            } else {
                this.f4797a.m7423c();
                this.f4797a.dismiss();
            }
        } else {
            this.f4797a.dismiss();
        }
        BuddyFragment.f3586l = true;
        return true;
    }
}
