package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.ViewPackageEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: AniconPackageDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.ai */
/* loaded from: classes.dex */
class HandlerC2542ai extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetail f9688a;

    HandlerC2542ai(AniconPackageDetail aniconPackageDetail) {
        this.f9688a = aniconPackageDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9688a.getActivity() != null && !this.f9688a.getActivity().isFinishing() && message.what == 1000) {
            this.f9688a.f9451D.dismiss();
            C0267d c0267d = (C0267d) message.obj;
            if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                ViewPackageEntry viewPackageEntry = (ViewPackageEntry) c0267d.m1354e();
                this.f9688a.f9455c = viewPackageEntry._package.f5653id;
                this.f9688a.getLoaderManager().restartLoader(0, null, this.f9688a);
                return;
            }
            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.toast_network_unable, 0).show();
            ((ActivityAniconPackageDetail) this.f9688a.getActivity()).m9262c();
        }
    }
}
