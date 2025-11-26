package com.sec.chaton.chat;

import android.view.DragEvent;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.t */
/* loaded from: classes.dex */
class ViewOnDragListenerC1843t implements View.OnDragListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6966a;

    ViewOnDragListenerC1843t(ChatFragment chatFragment) {
        this.f6966a = chatFragment;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 3:
                return this.f6966a.m7952a(dragEvent, EnumC1665ds.EditTextSpace);
            default:
                return false;
        }
    }
}
