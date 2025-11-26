package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p033io.entry.GetSSMServerAddress;
import com.sec.chaton.p033io.entry.inner.Server;
import com.sec.chaton.util.C1296as;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;

/* compiled from: GLDServerTask.java */
/* renamed from: com.sec.chaton.a.a.ai */
/* loaded from: classes.dex */
public class C0133ai extends AbstractRunnableC0153bb {
    public C0133ai(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m932d() != null) {
            GetSSMServerAddress getSSMServerAddress = (GetSSMServerAddress) c0259g.m932d();
            C1323bs.m4578a("expdate", getSSMServerAddress.expdate);
            Iterator it = getSSMServerAddress.primary.iterator();
            while (it.hasNext()) {
                Server server = (Server) it.next();
                if (server.name.equals("contact")) {
                    C1341p.m4660c("Primary Contact : " + server.address + " : " + server.port, getClass().getSimpleName());
                    C1323bs.m4579a("primary_contact_addrss", server.address);
                    C1323bs.m4577a("primary_contact_port", server.port);
                    C1323bs.m4579a("primary_region", server.region);
                } else if (server.name.equals("message")) {
                    C1341p.m4660c("Primary Message : " + server.address + " : " + server.port, getClass().getSimpleName());
                    C1323bs.m4579a("primary_message_addrss", server.address);
                    C1323bs.m4577a("primary_message_port", server.port);
                } else if (server.name.equals("file")) {
                    C1341p.m4660c("Primary File : " + server.address + " : " + server.port, getClass().getSimpleName());
                    C1323bs.m4579a("primary_file_addrss", server.address);
                    C1323bs.m4577a("primary_file_port", server.port);
                }
            }
            Iterator it2 = getSSMServerAddress.secondary.iterator();
            while (it2.hasNext()) {
                Server server2 = (Server) it2.next();
                if (server2.name.equals("contact")) {
                    C1323bs.m4579a("secondary_contact_addrss", server2.address);
                    C1323bs.m4577a("secondary_contact_port", server2.port);
                } else if (server2.name.equals("message")) {
                    C1323bs.m4579a("secondary_message_addrss", server2.address);
                    C1323bs.m4577a("secondary_message_port", server2.port);
                } else if (server2.name.equals("file")) {
                    C1323bs.m4579a("secondary_file_addrss", server2.address);
                    C1323bs.m4577a("secondary_file_port", server2.port);
                }
            }
            C1296as.m4518a();
            GlobalApplication.m3107h().m4486a();
            C1341p.m4647a();
        }
    }
}
