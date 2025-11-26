package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.multimedia.emoticon.C1835j;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.an */
/* loaded from: classes.dex */
class C0936an implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3882a;

    C0936an(ChatFragment chatFragment) {
        this.f3882a = chatFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) throws IOException {
        if (this.f3882a.f3694dn != null) {
            this.f3882a.m4868b(i);
            return true;
        }
        if (i == 4 || (this.f3882a.f3620bq && keyEvent != null && keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0)) {
            this.f3882a.m4875b(this.f3882a.f3613bj.getText().toString(), (String) null);
            return true;
        }
        if (i == 6) {
            CharSequence charSequenceM7508a = C1835j.m7508a(this.f3882a.f3672cr, this.f3882a.f3613bj.getText().toString(), (int) (this.f3882a.f3613bj.getLineHeight() * 1.2f));
            this.f3882a.f3613bj.setText(charSequenceM7508a);
            this.f3882a.f3613bj.setSelection(charSequenceM7508a.length());
            return true;
        }
        return false;
    }
}
