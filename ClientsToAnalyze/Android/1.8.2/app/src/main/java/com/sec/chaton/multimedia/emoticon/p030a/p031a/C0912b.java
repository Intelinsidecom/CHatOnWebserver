package com.sec.chaton.multimedia.emoticon.p030a.p031a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.entry.DownloadEmoticonEntry;
import com.sec.chaton.multimedia.emoticon.entry.inner.Anicon;
import com.sec.chaton.multimedia.emoticon.p032b.p033a.C0946a;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: DownloadEmoticonTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a.a.b */
/* loaded from: classes.dex */
public class C0912b extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f3379d = C0912b.class.getSimpleName();

    public C0912b(Handler handler, C0798h c0798h) {
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
        String value;
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            DownloadEmoticonEntry downloadEmoticonEntry = (DownloadEmoticonEntry) c0101b.m671d();
            if (downloadEmoticonEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null.", f3379d);
                    return;
                }
                return;
            }
            Iterator it = c0101b.m669c().m3396d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair nameValuePair = (NameValuePair) it.next();
                if (nameValuePair.getName().equals("packageid")) {
                    value = nameValuePair.getValue();
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (C1786r.f6452b) {
                C1786r.m6061b("Save emoticon package to database.", f3379d);
            }
            Anicon anicon = downloadEmoticonEntry.emoticon;
            if (anicon != null) {
                anicon.packageid = value;
                if (C1786r.f6452b) {
                    C1786r.m6061b(anicon.toString(), f3379d);
                }
                arrayList.add(C0946a.m3807a(anicon));
            }
            C0946a.m3813a(GlobalApplication.m3260b(), arrayList);
        }
    }
}
