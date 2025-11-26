package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.settings.downloads.p056a.C2514e;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: AniconPackageDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.ah */
/* loaded from: classes.dex */
class HandlerC2541ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetail f9687a;

    HandlerC2541ah(AniconPackageDetail aniconPackageDetail) {
        this.f9687a = aniconPackageDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2514e c2514e = (C2514e) message.obj;
        switch (message.what) {
            case 1:
            case 2:
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("PackageId: ", c2514e.m9454c(), ". Status: ", Integer.valueOf(message.what)), AniconPackageDetail.f9447b);
                }
                this.f9687a.m9311a(this.f9687a.f9478z);
                break;
            case 3:
            case 4:
                this.f9687a.f9477y = null;
                this.f9687a.m9311a(this.f9687a.f9478z);
                break;
            case 5:
                this.f9687a.m9311a(this.f9687a.f9478z);
                break;
            case 6:
                this.f9687a.f9473u.setProgress(c2514e.m11747g().intValue());
                break;
        }
    }
}
