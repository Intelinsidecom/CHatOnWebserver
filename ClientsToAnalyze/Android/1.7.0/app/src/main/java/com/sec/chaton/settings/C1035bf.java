package com.sec.chaton.settings;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0667t;

/* compiled from: RelationHideFragment.java */
/* renamed from: com.sec.chaton.settings.bf */
/* loaded from: classes.dex */
class C1035bf extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ RelationHideFragment f3639a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1035bf(RelationHideFragment relationHideFragment, Handler handler) {
        super(handler);
        this.f3639a = relationHideFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        this.f3639a.f3585l.query(C0667t.f2310a, null, "buddy_relation_hide = 'Y' ", null, null);
    }
}
