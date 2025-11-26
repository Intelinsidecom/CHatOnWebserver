package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bg */
/* loaded from: classes.dex */
class C0567bg extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1979a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0567bg(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f1979a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C1341p.m4660c("QUERY_PARTICIPANTS_AFTER_INSERTED_onChange", ChatFragment.f1725a);
        this.f1979a.f1760U.startQuery(5, null, C0654g.m2980a(this.f1979a.f1861t), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
    }
}
