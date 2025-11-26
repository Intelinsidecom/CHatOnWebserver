package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p017e.C0694i;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.x */
/* loaded from: classes.dex */
class C0868x extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3200a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0868x(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f3200a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f3200a.f3129w) {
            if (TextUtils.isEmpty(this.f3200a.f3097A)) {
                this.f3200a.f3117k.startQuery(1, null, C0694i.m3139a(), null, "inbox_valid=? AND inbox_last_chat_type != ? AND inbox_web_url IS NULL", new String[]{"Y", Integer.toString(12)}, "inbox_last_time DESC");
                return;
            } else {
                this.f3200a.f3117k.startQuery(1, null, C0694i.m3139a(), null, "inbox_no!=? AND inbox_valid=? AND inbox_last_chat_type != ? AND inbox_web_url IS NULL", new String[]{this.f3200a.f3097A, "Y", Integer.toString(12)}, "inbox_last_time DESC");
                return;
            }
        }
        this.f3200a.f3117k.startQuery(1, null, C0694i.m3139a(), null, "inbox_last_chat_type != ?", new String[]{Integer.toString(12)}, "inbox_last_time DESC");
    }
}
