package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.util.C4904y;

/* compiled from: GroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.z */
/* loaded from: classes.dex */
class HandlerC1248z extends Handler {

    /* renamed from: a */
    final /* synthetic */ GroupDialog f4748a;

    HandlerC1248z(GroupDialog groupDialog) {
        this.f4748a = groupDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4748a.getApplicationContext() != null) {
            switch (message.what) {
                case 3005:
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", GroupDialog.f4548a);
                        break;
                    } else if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b.m3110e();
                        C4904y.m18639b(" Groupdialog CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD", GroupDialog.f4548a);
                        this.f4748a.f4577z.m19023b(this.f4748a.f4562k, new C2955a(coverStoryDownload.fileurl, this.f4748a.f4556e, C2955a.f11033b, this.f4748a.getApplicationContext(), this.f4748a.getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/", this.f4748a.f4549A + ".jpg", null));
                        break;
                    }
                    break;
                case 3006:
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (c0778b2 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", GroupDialog.f4548a);
                        break;
                    } else if (c0778b2.m18954n() && c0778b2.m3110e() != null && c0778b2.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0778b2.m3110e();
                        String str = this.f4748a.getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
                        String str2 = this.f4748a.f4549A + ".jpg";
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM mContentId : " + this.f4748a.f4549A, GroupDialog.f4548a);
                        this.f4748a.f4577z.m19023b(this.f4748a.f4562k, new C2955a(coverStoryDownload2.fileurl, this.f4748a.f4556e, C2955a.f11033b, this.f4748a.getApplicationContext(), str, str2, this.f4748a.f4549A));
                        break;
                    }
                    break;
            }
        }
    }
}
