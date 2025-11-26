package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2291k;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p065io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: CoverstorySampleFragment.java */
/* renamed from: com.sec.chaton.userprofile.n */
/* loaded from: classes.dex */
class HandlerC4795n extends Handler {

    /* renamed from: a */
    final /* synthetic */ CoverstorySampleFragment f17528a;

    HandlerC4795n(CoverstorySampleFragment coverstorySampleFragment) {
        this.f17528a = coverstorySampleFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17528a.getActivity() != null) {
            switch (message.what) {
                case 3004:
                    C0778b c0778b = (C0778b) message.obj;
                    if (this.f17528a.f17111g != null && this.f17528a.f17111g.isShowing()) {
                        this.f17528a.f17111g.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
                        CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0778b.m3110e();
                        this.f17528a.f17107a = coverStorySampleList.coverstory;
                        C4809aa.m18107a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                        CoverstorySampleFragment.f17106m.startQuery(CoverstorySampleFragment.f17102b, null, C2291k.f8198a, null, null, null, null);
                        break;
                    } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                        CoverstorySampleFragment.f17106m.startQuery(CoverstorySampleFragment.f17102b, null, C2291k.f8198a, null, null, null, null);
                        break;
                    }
                    break;
                case 3005:
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (this.f17528a.f17111g != null && this.f17528a.f17111g.isShowing()) {
                        this.f17528a.f17111g.dismiss();
                    }
                    C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD", getClass().getSimpleName());
                    if (c0778b2 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b2.m18954n() && c0778b2.m3110e() != null && c0778b2.m3107b() != EnumC2464o.ERROR) {
                        ((InterfaceC4796o) this.f17528a.getActivity()).mo17805a(((CoverStoryDownload) c0778b2.m3110e()).fileurl, null, this.f17528a.f17115n);
                        break;
                    }
                    break;
            }
        }
    }
}
