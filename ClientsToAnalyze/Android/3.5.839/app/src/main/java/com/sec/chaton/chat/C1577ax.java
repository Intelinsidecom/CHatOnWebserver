package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.multimedia.emoticon.C2799k;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ax */
/* loaded from: classes.dex */
class C1577ax implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6005a;

    C1577ax(ChatFragment chatFragment) {
        this.f6005a = chatFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (this.f6005a.f5677dP != null) {
            this.f6005a.m8064b(i);
            return true;
        }
        if (i == 4 || (this.f6005a.f5572bN && keyEvent != null && keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0)) {
            this.f6005a.m8123c(this.f6005a.f5564bF.getText().toString(), (String) null);
            return true;
        }
        if (i == 6) {
            CharSequence charSequenceM11709a = C2799k.m11709a(this.f6005a.f5624cN, this.f6005a.f5564bF.getText().toString(), (int) (this.f6005a.f5564bF.getLineHeight() * 1.2f));
            this.f6005a.f5564bF.setText(charSequenceM11709a);
            this.f6005a.f5564bF.setSelection(charSequenceM11709a.length());
            return true;
        }
        return false;
    }
}
