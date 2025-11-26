package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p028io.entry.GetSSMServerAddress;
import com.sec.chaton.p028io.entry.inner.Server;
import com.sec.chaton.util.C1763bs;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.Iterator;

/* compiled from: GLDServerTask.java */
/* renamed from: com.sec.chaton.d.a.ag */
/* loaded from: classes.dex */
public class C0539ag extends AbstractRunnableC0532a {
    public C0539ag(Handler handler, C0798h c0798h) {
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
        if (c0101b.m671d() != null) {
            GetSSMServerAddress getSSMServerAddress = (GetSSMServerAddress) c0101b.m671d();
            C1789u.m6078a("expdate", getSSMServerAddress.expdate);
            Iterator it = getSSMServerAddress.primary.iterator();
            while (it.hasNext()) {
                Server server = (Server) it.next();
                if (server.name.equals("contact")) {
                    C1786r.m6063c("Primary Contact : " + server.address + " : " + server.port, getClass().getSimpleName());
                    C1789u.m6079a("primary_contact_addrss", server.address);
                    C1789u.m6077a("primary_contact_port", server.port);
                    C1789u.m6079a("primary_region", server.region);
                } else if (server.name.equals("message")) {
                    C1786r.m6063c("Primary Message : " + server.address + " : " + server.port, getClass().getSimpleName());
                    C1789u.m6079a("primary_message_addrss", server.address);
                    C1789u.m6077a("primary_message_port", server.port);
                } else if (server.name.equals("file")) {
                    C1786r.m6063c("Primary File : " + server.address + " : " + server.port, getClass().getSimpleName());
                    C1789u.m6079a("primary_file_addrss", server.address);
                    C1789u.m6077a("primary_file_port", server.port);
                }
            }
            Iterator it2 = getSSMServerAddress.secondary.iterator();
            while (it2.hasNext()) {
                Server server2 = (Server) it2.next();
                if (server2.name.equals("contact")) {
                    C1789u.m6079a("secondary_contact_addrss", server2.address);
                    C1789u.m6077a("secondary_contact_port", server2.port);
                } else if (server2.name.equals("message")) {
                    C1789u.m6079a("secondary_message_addrss", server2.address);
                    C1789u.m6077a("secondary_message_port", server2.port);
                } else if (server2.name.equals("file")) {
                    C1789u.m6079a("secondary_file_addrss", server2.address);
                    C1789u.m6077a("secondary_file_port", server2.port);
                }
            }
            C1763bs.m5970a();
            GlobalApplication.m3263d().m5920a();
            C1786r.m6050a();
        }
    }
}
