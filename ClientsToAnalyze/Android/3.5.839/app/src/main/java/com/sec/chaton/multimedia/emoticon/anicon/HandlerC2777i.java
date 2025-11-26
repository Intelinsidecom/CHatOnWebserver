package com.sec.chaton.multimedia.emoticon.anicon;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.common.tooltip.C5013c;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.i */
/* loaded from: classes.dex */
class HandlerC2777i extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f10065a;

    HandlerC2777i(AniconContainer aniconContainer) {
        this.f10065a = aniconContainer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10065a.getActivity() != null && C4878cp.m18516a().m18518b(EnumC4879cq.SHOP) && this.f10065a.f10027i != null) {
            new C5013c().m19050a(this.f10065a.f10027i).m19049a(R.string.tooltip_shop).m19048a().m19042a(this.f10065a.getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.SHOP);
        }
    }
}
