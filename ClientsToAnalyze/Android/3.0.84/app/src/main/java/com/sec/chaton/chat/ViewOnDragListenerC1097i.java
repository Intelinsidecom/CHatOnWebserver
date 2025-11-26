package com.sec.chaton.chat;

import android.view.DragEvent;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.i */
/* loaded from: classes.dex */
class ViewOnDragListenerC1097i implements View.OnDragListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4360a;

    ViewOnDragListenerC1097i(ChatFragment chatFragment) {
        this.f4360a = chatFragment;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 3:
                return this.f4360a.m4775a(dragEvent, EnumC1025cu.EditTextSpace);
            default:
                return false;
        }
    }
}
