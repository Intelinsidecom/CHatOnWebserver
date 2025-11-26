package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.common.tooltip.C5013c;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.h */
/* loaded from: classes.dex */
class HandlerC3920h extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f14113a;

    HandlerC3920h(AniconContainer aniconContainer) {
        this.f14113a = aniconContainer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        super.handleMessage(message);
        if (this.f14113a.getActivity() != null && C4878cp.m18516a().m18518b(EnumC4879cq.SMS_SHOP) && (view = (View) this.f14113a.f14087n.get("-1")) != null) {
            new C5013c().m19050a(view).m19049a(R.string.tooltip_shop).m19048a().m19042a(this.f14113a.getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.SMS_SHOP);
        }
    }
}
