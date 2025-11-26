package com.sec.chaton.userprofile;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C1341p;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bl */
/* loaded from: classes.dex */
class C1242bl extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f4323a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1242bl(RelationshipRankFragment2 relationshipRankFragment2, Handler handler) {
        super(handler);
        this.f4323a = relationshipRankFragment2;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C1341p.m4662e("ContentObserver.onChange: " + z, getClass().getSimpleName());
        super.onChange(z);
        this.f4323a.m4349a(this.f4323a.f4213u);
    }
}
