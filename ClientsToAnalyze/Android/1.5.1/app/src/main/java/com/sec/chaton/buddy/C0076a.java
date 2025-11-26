package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.a */
/* loaded from: classes.dex */
class C0076a extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f609a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0076a(BuddyFragment buddyFragment, Handler handler) {
        super(handler);
        this.f609a = buddyFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ChatONLogWriter.m3512f("ContentObserver.onChange() : " + this.f609a.f437ab, BuddyFragment.f409a);
        if (!this.f609a.f437ab) {
            this.f609a.f438ac = true;
            ChatONLogWriter.m3512f("isChanged : " + this.f609a.f438ac, BuddyFragment.f409a);
            return;
        }
        if (this.f609a.f431V != null) {
            this.f609a.f431V.m527a();
        }
        if (this.f609a.f430U != null) {
            this.f609a.m503k();
        }
    }
}
