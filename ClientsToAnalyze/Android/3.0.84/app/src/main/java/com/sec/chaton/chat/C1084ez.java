package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.p025d.C1335m;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.ez */
/* loaded from: classes.dex */
class C1084ez implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1082ex f4346a;

    C1084ez(AlertDialogC1082ex alertDialogC1082ex) {
        this.f4346a = alertDialogC1082ex;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.f4346a.f4340h = this.f4346a.f4338f.m11463a().toString().trim();
            if (this.f4346a.f4343k == null || this.f4346a.f4343k.equals("")) {
                this.f4346a.m5354b();
                return true;
            }
            C1335m.m5789c(this.f4346a.f4335c, this.f4346a.f4343k, this.f4346a.f4340h);
            if (this.f4346a.f4334b != null && !this.f4346a.f4334b.isShowing()) {
                this.f4346a.f4334b.show();
            }
            this.f4346a.dismiss();
            return true;
        }
        return false;
    }
}
