package com.sec.chaton.block;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.l */
/* loaded from: classes.dex */
class C0486l extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1598a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0486l(BlockFragment blockFragment, Handler handler) {
        super(handler);
        this.f1598a = blockFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11458g("selfChange = " + z, getClass().getSimpleName());
        if (this.f1598a.f1549j != null) {
            this.f1598a.f1549j.m5704a();
        }
    }
}
