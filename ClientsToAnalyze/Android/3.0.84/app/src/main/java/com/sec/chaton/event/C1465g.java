package com.sec.chaton.event;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p035io.entry.EventPageEntry;
import com.sec.chaton.p035io.entry.inner.Event;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: EventPageTask.java */
/* renamed from: com.sec.chaton.event.g */
/* loaded from: classes.dex */
public class C1465g extends AbstractC1145a {

    /* renamed from: b */
    private static final String f5443b = C1465g.class.getSimpleName();

    public C1465g(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            EventPageEntry eventPageEntry = (EventPageEntry) c0267d.m1354e();
            if (eventPageEntry == null) {
                C3250y.m11442a("Http result object is null.", f5443b);
                return;
            }
            for (Event event : eventPageEntry.event) {
                C3250y.m11450b("Event downloaded : eventid=" + event.eventid + " title=" + event.title, f5443b);
                C3159aa.m10962a().m10984b("new_event_count", (Integer) 0);
                if (!C1464f.m6390a(Long.valueOf(event.winnerenddate))) {
                    if (!C1464f.m6396c(event)) {
                        C1464f.m6388a(event);
                        LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_event_update"));
                    } else {
                        C1464f.m6392b(event);
                    }
                }
            }
            return;
        }
        if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
            C3250y.m11442a("Event downloaded : No Content ", f5443b);
        } else if (c0267d.m1351b() == EnumC1587o.ERROR) {
            C3250y.m11442a("Event downloaded : error", f5443b);
        }
    }
}
