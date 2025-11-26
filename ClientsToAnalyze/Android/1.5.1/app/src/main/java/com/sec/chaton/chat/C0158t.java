package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.trunk.database.DatabaseConstant;

/* renamed from: com.sec.chaton.chat.t */
/* loaded from: classes.dex */
class C0158t extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f980a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0158t(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f980a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f980a.f743M.startQuery(9, null, DatabaseConstant.TrunkTable.CONTENT_URI, null, "session_id=?", new String[]{this.f980a.f827x}, null);
    }
}
