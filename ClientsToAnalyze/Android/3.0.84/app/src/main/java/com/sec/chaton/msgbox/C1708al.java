package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.p027e.C1449q;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.al */
/* loaded from: classes.dex */
class C1708al extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6355a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1708al(MsgboxSelectionFragment msgboxSelectionFragment, Handler handler) {
        super(handler);
        this.f6355a = msgboxSelectionFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        String str;
        if (this.f6355a.getActivity() instanceof ChatForwardActivity) {
            if (!TextUtils.isEmpty(this.f6355a.f6321x)) {
                str = this.f6355a.f6321x;
            } else {
                str = "";
            }
            this.f6355a.f6312o.startQuery(1, null, C1449q.m6333c(), null, null, new String[]{str}, null);
            return;
        }
        this.f6355a.f6312o.startQuery(1, null, C1449q.m6331b(), null, null, null, null);
    }
}
