package com.sec.chaton.multimedia.skin.p035a.p036a;

import android.os.Handler;
import com.sec.chaton.multimedia.skin.entry.DownloadSkinEntry;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p060d.C1828c;

/* compiled from: DownloadSkinTask.java */
/* renamed from: com.sec.chaton.multimedia.skin.a.a.a */
/* loaded from: classes.dex */
public class C0996a extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f3687d = C0996a.class.getSimpleName();

    public C0996a(Handler handler, C0798h c0798h) {
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
            DownloadSkinEntry downloadSkinEntry = (DownloadSkinEntry) c0101b.m671d();
            if (downloadSkinEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null.", f3687d);
                }
            } else if (C1786r.f6452b) {
                C1786r.m6061b(C1828c.m6207a("Entry: ", downloadSkinEntry), f3687d);
            }
        }
    }
}
