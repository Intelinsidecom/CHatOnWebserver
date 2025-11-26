package com.sec.chaton.poston;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bb */
/* loaded from: classes.dex */
class C1989bb implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7704a;

    C1989bb(PostONWriteFragment postONWriteFragment) {
        this.f7704a = postONWriteFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f7704a.getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f7704a.f7630v.getWindowToken(), 0);
        }
        return true;
    }
}
