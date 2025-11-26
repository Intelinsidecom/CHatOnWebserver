package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.multimedia.emoticon.entry.InstallPackageEntry;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.common.p056b.p061e.C1836g;
import java.io.File;
import java.io.IOException;

/* compiled from: AniconPackageDetailActivityTest.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.m */
/* loaded from: classes.dex */
class HandlerC0930m extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetailActivityTest f3481a;

    HandlerC0930m(AniconPackageDetailActivityTest aniconPackageDetailActivityTest) {
        this.f3481a = aniconPackageDetailActivityTest;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        File fileM6231b = null;
        super.handleMessage(message);
        if (message.what == 1001) {
            this.f3481a.f3432v = null;
            C0101b c0101b = (C0101b) message.obj;
            if (c0101b.m665b() != EnumC0803m.SUCCESS) {
                this.f3481a.m3719f();
                this.f3481a.m3713c();
            } else {
                InstallPackageEntry installPackageEntry = (InstallPackageEntry) c0101b.m671d();
                this.f3481a.f3421k = installPackageEntry.packagezipurl;
                try {
                    File fileM6212a = C1830a.m6212a(this.f3481a);
                    this.f3481a.f3433w = new File(fileM6212a, String.valueOf(this.f3481a.f3421k.hashCode()));
                    C1830a.m6211a().m6214a(this.f3481a.f3434x, this.f3481a.f3421k, this.f3481a.f3433w, null);
                } catch (IOException e) {
                    if (C1786r.f6455e) {
                        C1786r.m6056a(e, AniconPackageDetailActivityTest.f3414a);
                    }
                    this.f3481a.m3719f();
                    this.f3481a.m3713c();
                }
            }
        }
        if (message.what == 2) {
            if (C1786r.f6452b) {
                C1786r.m6061b("File download is completed.", AniconPackageDetailActivityTest.f3414a);
            }
            try {
                try {
                    fileM6231b = ((C1836g) message.obj).m6231b();
                    C0921d.m3788a(this.f3481a, this.f3481a.f3415b, fileM6231b);
                    this.f3481a.f3425o.setVisibility(8);
                    this.f3481a.f3427q.setVisibility(0);
                } finally {
                    if (fileM6231b != null && fileM6231b.exists()) {
                        fileM6231b.delete();
                    }
                }
            } catch (IOException e2) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e2, AniconPackageDetailActivityTest.f3414a);
                }
                this.f3481a.m3713c();
                if (fileM6231b != null && fileM6231b.exists()) {
                }
            }
            this.f3481a.m3719f();
        }
        if (message.what == 1 && this.f3481a.f3428r.isShowing()) {
            this.f3481a.f3428r.setProgress(message.arg1);
        }
        if (message.what == 3) {
            this.f3481a.m3719f();
        }
        if (message.what == 4) {
            this.f3481a.m3719f();
            this.f3481a.m3713c();
        }
    }
}
