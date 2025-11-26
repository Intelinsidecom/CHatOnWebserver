package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.ar */
/* loaded from: classes.dex */
final class HandlerC1641ar extends Handler {
    HandlerC1641ar() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (MyPageRelationshipRankFragment.f5926t != null) {
            MyPageRelationshipRankFragment.f5926t.dismiss();
        }
    }
}
