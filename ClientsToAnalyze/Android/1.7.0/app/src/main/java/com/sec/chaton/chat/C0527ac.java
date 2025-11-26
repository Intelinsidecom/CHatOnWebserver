package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ac */
/* loaded from: classes.dex */
class C0527ac implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1877a;

    C0527ac(ChatFragment chatFragment) {
        this.f1877a = chatFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f1877a.m2707i();
            this.f1877a.f1834bf.hideSoftInputFromWindow(ChatFragment.f1726aC.getWindowToken(), 0);
        }
        return false;
    }
}
