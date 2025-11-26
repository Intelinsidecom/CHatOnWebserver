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

/* compiled from: AniconPackageDetailActivity.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.g */
/* loaded from: classes.dex */
class HandlerC0924g extends Handler {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetailActivity f3472a;

    HandlerC0924g(AniconPackageDetailActivity aniconPackageDetailActivity) {
        this.f3472a = aniconPackageDetailActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        File fileM6231b = null;
        super.handleMessage(message);
        if (message.what == 1001) {
            if (this.f3472a.getActivity() != null && (this.f3472a.getActivity() == null || !this.f3472a.getActivity().isFinishing())) {
                this.f3472a.f3411w = null;
                C0101b c0101b = (C0101b) message.obj;
                if (c0101b.m665b() != EnumC0803m.SUCCESS) {
                    this.f3472a.m3695f();
                    this.f3472a.m3689c();
                } else {
                    InstallPackageEntry installPackageEntry = (InstallPackageEntry) c0101b.m671d();
                    this.f3472a.f3396h = installPackageEntry.packagezipurl;
                    try {
                        File fileM6212a = C1830a.m6212a(this.f3472a.getActivity());
                        this.f3472a.f3412x = new File(fileM6212a, String.valueOf(this.f3472a.f3396h.hashCode()));
                        C1830a.m6211a().m6214a(this.f3472a.f3413y, this.f3472a.f3396h, this.f3472a.f3412x, null);
                    } catch (IOException e) {
                        if (C1786r.f6455e) {
                            C1786r.m6056a(e, AniconPackageDetailActivity.f3389a);
                        }
                        this.f3472a.m3695f();
                        this.f3472a.m3689c();
                    }
                }
            } else {
                C1786r.m6066e("Activity is Finishing : ", getClass().getSimpleName());
                return;
            }
        }
        if (message.what == 2) {
            if (C1786r.f6452b) {
                C1786r.m6061b("File download is completed.", AniconPackageDetailActivity.f3389a);
            }
            try {
                try {
                    fileM6231b = ((C1836g) message.obj).m6231b();
                    C0921d.m3788a(this.f3472a.getActivity(), this.f3472a.f3390b, fileM6231b);
                    this.f3472a.m3700a();
                } catch (IOException e2) {
                    if (C1786r.f6455e) {
                        C1786r.m6056a(e2, AniconPackageDetailActivity.f3389a);
                    }
                    this.f3472a.m3689c();
                    if (fileM6231b != null && fileM6231b.exists()) {
                    }
                }
                this.f3472a.m3695f();
            } finally {
                if (fileM6231b != null && fileM6231b.exists()) {
                    fileM6231b.delete();
                }
            }
        }
        if (message.what == 1 && this.f3472a.f3407s.isShowing()) {
            this.f3472a.f3407s.setProgress(message.arg1);
        }
        if (message.what == 3) {
            this.f3472a.m3695f();
        }
        if (message.what == 4) {
            this.f3472a.m3695f();
            this.f3472a.m3689c();
        }
    }
}
