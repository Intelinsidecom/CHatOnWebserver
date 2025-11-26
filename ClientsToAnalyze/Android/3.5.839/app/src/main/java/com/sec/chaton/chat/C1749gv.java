package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.p055d.C2134o;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.gv */
/* loaded from: classes.dex */
class C1749gv implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1747gt f6577a;

    C1749gv(AlertDialogC1747gt alertDialogC1747gt) {
        this.f6577a = alertDialogC1747gt;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.f6577a.f6571h = this.f6577a.f6569f.m18658a().toString().trim();
            if (this.f6577a.f6571h.length() <= 0) {
                return true;
            }
            if (this.f6577a.f6574k == null || this.f6577a.f6574k.equals("")) {
                this.f6577a.m8693b();
                return true;
            }
            C2134o.m9576c(this.f6577a.f6566c, this.f6577a.f6574k, this.f6577a.f6571h);
            if (this.f6577a.f6565b != null && !this.f6577a.f6565b.isShowing()) {
                this.f6577a.f6565b.show();
            }
            this.f6577a.dismiss();
            return true;
        }
        return false;
    }
}
