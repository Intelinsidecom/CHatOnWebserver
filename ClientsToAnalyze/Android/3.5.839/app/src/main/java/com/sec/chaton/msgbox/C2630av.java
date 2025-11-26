package com.sec.chaton.msgbox;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.av */
/* loaded from: classes.dex */
class C2630av extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9479a;

    C2630av(MsgboxFragment msgboxFragment) {
        this.f9479a = msgboxFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f9479a.getActivity() != null && this.f9479a.f9324C != null && C4809aa.m18104a().m18129b("uid") && intent.getAction() != null) {
            if ("android.intent.action.DATE_CHANGED".equals(intent.getAction()) || "android.intent.action.TIME_SET".equals(intent.getAction()) || "android.intent.action.TIMEZONE_CHANGED".equals(intent.getAction())) {
                this.f9479a.f9324C.m11160c();
                this.f9479a.f9324C.notifyDataSetChanged();
                if (C4904y.f17872b) {
                    C4904y.m18639b("[MSGBOX] mSystemEventBR onReceive:: [" + intent.getAction() + "]", MsgboxFragment.f9318i);
                }
            }
        }
    }
}
