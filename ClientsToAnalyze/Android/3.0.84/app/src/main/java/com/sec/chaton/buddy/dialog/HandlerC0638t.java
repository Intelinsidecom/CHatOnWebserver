package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.util.C3250y;

/* compiled from: GroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.t */
/* loaded from: classes.dex */
class HandlerC0638t extends Handler {

    /* renamed from: a */
    final /* synthetic */ GroupDialog f2858a;

    HandlerC0638t(GroupDialog groupDialog) {
        this.f2858a = groupDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2858a.getApplicationContext() != null) {
            switch (message.what) {
                case 3005:
                    C0267d c0267d = (C0267d) message.obj;
                    if (c0267d == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", GroupDialog.f2704a);
                        break;
                    } else if (c0267d.m11704n() && c0267d.m1354e() != null && c0267d.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0267d.m1354e();
                        C3250y.m11450b(" Groupdialog CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD", GroupDialog.f2704a);
                        this.f2858a.f2730y.m11730a(this.f2858a.f2716k, new C1960a(coverStoryDownload.fileurl, this.f2858a.f2710e, C1960a.f7636b, this.f2858a.getApplicationContext(), this.f2858a.getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/", this.f2858a.f2731z + ".jpg", null));
                        break;
                    }
                    break;
                case 3006:
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (c0267d2 == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", GroupDialog.f2704a);
                        break;
                    } else if (c0267d2.m11704n() && c0267d2.m1354e() != null && c0267d2.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0267d2.m1354e();
                        String str = this.f2858a.getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
                        String str2 = this.f2858a.f2731z + ".jpg";
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM mContentId : " + this.f2858a.f2731z, GroupDialog.f2704a);
                        this.f2858a.f2730y.m11730a(this.f2858a.f2716k, new C1960a(coverStoryDownload2.fileurl, this.f2858a.f2710e, C1960a.f7636b, this.f2858a.getApplicationContext(), str, str2, this.f2858a.f2731z));
                        break;
                    }
                    break;
            }
        }
    }
}
