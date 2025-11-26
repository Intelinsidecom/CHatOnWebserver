package com.sec.chaton.multimedia.emoticon.p030a.p031a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.entry.InstallPackageEntry;
import com.sec.chaton.multimedia.emoticon.entry.inner.Anicon;
import com.sec.chaton.multimedia.emoticon.p032b.p033a.C0946a;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: InstallPackageTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a.a.d */
/* loaded from: classes.dex */
public class C0914d extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f3381d = C0913c.class.getSimpleName();

    public C0914d(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            InstallPackageEntry installPackageEntry = (InstallPackageEntry) c0101b.m671d();
            if (installPackageEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null.", f3381d);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(C0946a.m3814b(installPackageEntry.f3536id, installPackageEntry.expirationtime));
            if (C1786r.f6452b) {
                C1786r.m6061b("Save emoticon package to database.", f3381d);
            }
            for (Anicon anicon : installPackageEntry.emoticons) {
                if (C1786r.f6452b) {
                    C1786r.m6061b(anicon.toString(), f3381d);
                }
                anicon.packageid = installPackageEntry.f3536id;
                anicon.cdproxyurl = installPackageEntry.cdproxyurl;
                arrayList.add(C0946a.m3807a(anicon));
            }
            C0946a.m3813a(GlobalApplication.m3260b(), arrayList);
        }
    }
}
