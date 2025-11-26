package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1443k;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p035io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: CoverstorySampleFragment.java */
/* renamed from: com.sec.chaton.userprofile.s */
/* loaded from: classes.dex */
class HandlerC3150s extends Handler {

    /* renamed from: a */
    final /* synthetic */ CoverstorySampleFragment f11419a;

    HandlerC3150s(CoverstorySampleFragment coverstorySampleFragment) {
        this.f11419a = coverstorySampleFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11419a.getActivity() != null) {
            switch (message.what) {
                case 3004:
                    C0267d c0267d = (C0267d) message.obj;
                    if (this.f11419a.f11055g != null && this.f11419a.f11055g.isShowing()) {
                        this.f11419a.f11055g.dismiss();
                    }
                    if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
                        CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0267d.m1354e();
                        this.f11419a.f11051a = coverStorySampleList.coverstory;
                        C3159aa.m10965a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                        CoverstorySampleFragment.f11050m.startQuery(CoverstorySampleFragment.f11046b, null, C1443k.f5371a, null, null, null, null);
                        break;
                    } else if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                        CoverstorySampleFragment.f11050m.startQuery(CoverstorySampleFragment.f11046b, null, C1443k.f5371a, null, null, null, null);
                        break;
                    }
                    break;
                case 3005:
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (this.f11419a.f11055g != null && this.f11419a.f11055g.isShowing()) {
                        this.f11419a.f11055g.dismiss();
                    }
                    C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD", getClass().getSimpleName());
                    if (c0267d2 == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0267d2.m11704n() && c0267d2.m1354e() != null && c0267d2.m1351b() != EnumC1587o.ERROR) {
                        ((InterfaceC3151t) this.f11419a.getActivity()).mo10651a(((CoverStoryDownload) c0267d2.m1354e()).fileurl, null, this.f11419a.f11059n);
                        break;
                    }
                    break;
            }
        }
    }
}
