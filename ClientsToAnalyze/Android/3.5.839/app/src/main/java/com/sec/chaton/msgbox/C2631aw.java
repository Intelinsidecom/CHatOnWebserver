package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.aw */
/* loaded from: classes.dex */
class C2631aw extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9480a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2631aw(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f9480a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f9480a.getActivity() != null && this.f9480a.f9324C != null) {
            this.f9480a.f9324C.m11160c();
            this.f9480a.f9324C.notifyDataSetChanged();
            if (C4904y.f17872b) {
                C4904y.m18639b("[MSGBOX] mSystemEventObserver", MsgboxFragment.f9318i);
            }
        }
    }
}
