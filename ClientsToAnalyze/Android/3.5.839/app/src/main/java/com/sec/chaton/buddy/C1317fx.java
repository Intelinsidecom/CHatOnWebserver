package com.sec.chaton.buddy;

import android.sec.multiwindow.MWOnDragListener;
import android.view.DragEvent;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fx */
/* loaded from: classes.dex */
class C1317fx extends MWOnDragListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4853a;

    C1317fx(BuddyProfileFragment buddyProfileFragment) {
        this.f4853a = buddyProfileFragment;
    }

    @Override // android.sec.multiwindow.MWOnDragListener
    public void onDrop(DragEvent dragEvent) {
        BuddyFragment.m6347a(dragEvent.getClipData(), new String[]{this.f4853a.f4013t}, this.f4853a.f3954aU);
    }
}
