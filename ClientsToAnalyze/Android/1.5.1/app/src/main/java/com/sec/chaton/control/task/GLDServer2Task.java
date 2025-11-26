package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.p000io.entry.GetSSMServerAddress2;
import com.sec.chaton.p000io.entry.inner.Server;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ServerAddressMgr;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GLDServer2Task extends AbstractHttpTask2 {
    public GLDServer2Task(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (httpEntry.m1955d() != null) {
            GetSSMServerAddress2 getSSMServerAddress2 = (GetSSMServerAddress2) httpEntry.m1955d();
            ChatONPref.m3522a("expdate", getSSMServerAddress2.expdate);
            ChatONLogWriter.m3508c("MSISDN From Server : " + getSSMServerAddress2.msisdn, getClass().getSimpleName());
            Iterator it = getSSMServerAddress2.primary.iterator();
            while (it.hasNext()) {
                Server server = (Server) it.next();
                if (server.name.equals("contact")) {
                    ChatONLogWriter.m3508c("Primary Contact : " + server.address + " : " + server.port, getClass().getSimpleName());
                    ChatONPref.m3523a("primary_contact_addrss", server.address);
                    ChatONPref.m3521a("primary_contact_port", server.port);
                    ChatONPref.m3523a("primary_region", server.region);
                } else if (server.name.equals("message")) {
                    ChatONLogWriter.m3508c("Primary Message : " + server.address + " : " + server.port, getClass().getSimpleName());
                    ChatONPref.m3523a("primary_message_addrss", server.address);
                    ChatONPref.m3521a("primary_message_port", server.port);
                } else if (server.name.equals("file")) {
                    ChatONLogWriter.m3508c("Primary File : " + server.address + " : " + server.port, getClass().getSimpleName());
                    ChatONPref.m3523a("primary_file_addrss", server.address);
                    ChatONPref.m3521a("primary_file_port", server.port);
                }
            }
            Iterator it2 = getSSMServerAddress2.secondary.iterator();
            while (it2.hasNext()) {
                Server server2 = (Server) it2.next();
                if (server2.name.equals("contact")) {
                    ChatONPref.m3523a("secondary_contact_addrss", server2.address);
                    ChatONPref.m3521a("secondary_contact_port", server2.port);
                } else if (server2.name.equals("message")) {
                    ChatONPref.m3523a("secondary_message_addrss", server2.address);
                    ChatONPref.m3521a("secondary_message_port", server2.port);
                } else if (server2.name.equals("file")) {
                    ChatONPref.m3523a("secondary_file_addrss", server2.address);
                    ChatONPref.m3521a("secondary_file_port", server2.port);
                }
            }
            ServerAddressMgr.m3629a();
            GlobalApplication.m2389g().m3600a();
            ChatONLogWriter.m3495a();
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
