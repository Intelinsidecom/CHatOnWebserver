package com.sec.chaton.poston;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bc */
/* loaded from: classes.dex */
class C2985bc implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11100a;

    C2985bc(PostONWriteFragment postONWriteFragment) {
        this.f11100a = postONWriteFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f11100a.getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f11100a.f11028w.getWindowToken(), 0);
        }
        return true;
    }
}
