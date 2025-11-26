package com.sec.chaton.poston;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ap */
/* loaded from: classes.dex */
class C2971ap implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11068a;

    C2971ap(PostONDetailFragment postONDetailFragment) {
        this.f11068a = postONDetailFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (textView.getText() == null || textView.getText().toString().trim().length() <= 0 || i != 6) {
            return false;
        }
        this.f11068a.f10922ad.performClick();
        return true;
    }
}
