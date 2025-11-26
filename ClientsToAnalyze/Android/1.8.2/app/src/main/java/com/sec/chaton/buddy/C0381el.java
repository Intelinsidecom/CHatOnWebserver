package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.el */
/* loaded from: classes.dex */
class C0381el implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1539a;

    C0381el(GroupProfileFragment groupProfileFragment) {
        this.f1539a = groupProfileFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1539a.m2232a();
        return true;
    }
}
