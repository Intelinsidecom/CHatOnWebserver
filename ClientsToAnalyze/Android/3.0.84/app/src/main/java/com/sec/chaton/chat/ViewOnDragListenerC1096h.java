package com.sec.chaton.chat;

import android.view.DragEvent;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.h */
/* loaded from: classes.dex */
class ViewOnDragListenerC1096h implements View.OnDragListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4359a;

    ViewOnDragListenerC1096h(ChatFragment chatFragment) {
        this.f4359a = chatFragment;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 3:
                return this.f4359a.m4775a(dragEvent, EnumC1025cu.ChatSpace);
            default:
                return false;
        }
    }
}
