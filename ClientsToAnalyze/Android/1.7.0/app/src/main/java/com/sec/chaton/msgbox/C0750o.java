package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p025d.C0671x;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.o */
/* loaded from: classes.dex */
class C0750o extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2554a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0750o(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f2554a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f2554a.f2516v) {
            if (TextUtils.isEmpty(this.f2554a.f2520z)) {
                this.f2554a.f2504j.startQuery(1, null, C0671x.m3037a(), null, "inbox_valid=? AND inbox_last_chat_type != ?", new String[]{"Y", Integer.toString(12)}, "inbox_last_time DESC");
                return;
            } else {
                this.f2554a.f2504j.startQuery(1, null, C0671x.m3037a(), null, "inbox_no!=? AND inbox_valid=? AND inbox_last_chat_type != ?", new String[]{this.f2554a.f2520z, "Y", Integer.toString(12)}, "inbox_last_time DESC");
                return;
            }
        }
        this.f2554a.f2504j.startQuery(1, null, C0671x.m3037a(), null, "inbox_last_chat_type != ?", new String[]{Integer.toString(12)}, "inbox_last_time DESC");
    }
}
