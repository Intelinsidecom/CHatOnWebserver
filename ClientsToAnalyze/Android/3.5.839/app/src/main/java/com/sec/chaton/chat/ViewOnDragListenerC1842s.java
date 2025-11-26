package com.sec.chaton.chat;

import android.view.DragEvent;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.s */
/* loaded from: classes.dex */
class ViewOnDragListenerC1842s implements View.OnDragListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6965a;

    ViewOnDragListenerC1842s(ChatFragment chatFragment) {
        this.f6965a = chatFragment;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 3:
                return this.f6965a.m7952a(dragEvent, EnumC1665ds.ChatSpace);
            default:
                return false;
        }
    }
}
