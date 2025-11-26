package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2531v;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: SoundListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.dm */
/* loaded from: classes.dex */
class HandlerC2627dm extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2625dk f9864a;

    HandlerC2627dm(ViewOnClickListenerC2625dk viewOnClickListenerC2625dk) {
        this.f9864a = viewOnClickListenerC2625dk;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2531v c2531v = (C2531v) message.obj;
        C2629do c2629do = (C2629do) this.f9864a.f9858e.get(c2531v.m9454c());
        if (c2629do != null) {
            switch (message.what) {
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("download_sound, PackageId: ", c2531v.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2625dk.f9855d);
                    }
                    this.f9864a.notifyDataSetChanged();
                    break;
                case 3:
                case 4:
                case 5:
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("download_sound, PackageId: ", c2531v.m9454c(), ". Status: ", Integer.valueOf(message.what)), ViewOnClickListenerC2625dk.f9855d);
                    }
                    this.f9864a.notifyDataSetChanged();
                    break;
                case 6:
                    c2629do.f9872h.setProgress(c2531v.m11747g().intValue());
                    break;
            }
        }
    }
}
