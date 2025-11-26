package com.sec.chaton.ignore;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;
import twitter4j.MediaEntity;

/* compiled from: IgnoreBuddyAdapter.java */
/* renamed from: com.sec.chaton.ignore.c */
/* loaded from: classes.dex */
class HandlerC0824c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0822a f3036a;

    HandlerC0824c(C0822a c0822a) {
        this.f3036a = c0822a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case MediaEntity.Size.CROP /* 101 */:
                this.f3036a.f3030g.dismiss();
                if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                    C2153y.m7535a(this.f3036a.f3026c, R.string.dev_network_error, 0).show();
                } else {
                    C2153y.m7536a(this.f3036a.f3026c, this.f3036a.f3026c.getResources().getString(R.string.setting_buddy_unblocked, this.f3036a.f3028e), 0).show();
                    this.f3036a.f3024a.remove(this.f3036a.f3032i);
                }
                this.f3036a.notifyDataSetChanged();
                break;
        }
    }
}
