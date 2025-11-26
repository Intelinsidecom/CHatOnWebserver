package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetSSMServerAddress4;
import com.sec.chaton.p035io.entry.inner.Server;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.Iterator;

/* compiled from: GLDServer4Task.java */
/* renamed from: com.sec.chaton.d.a.ba */
/* loaded from: classes.dex */
public class C1173ba extends AbstractC1145a {
    public C1173ba(Handler handler, C1580h c1580h) {
        super(handler, c1580h, EnumC1172b.SYSTEM);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if ((!c0267d.m11704n() || c0267d.m1354e() == null || c0267d.m1351b() == EnumC1587o.ERROR) && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0501", c0267d);
        }
        if (c0267d.m1354e() != null) {
            GetSSMServerAddress4 getSSMServerAddress4 = (GetSSMServerAddress4) c0267d.m1354e();
            C3159aa.m10965a("expdate", getSSMServerAddress4.expdate);
            C3250y.m11453c("MSISDN From Server : " + getSSMServerAddress4.msisdn, getClass().getSimpleName());
            Iterator<Server> it = getSSMServerAddress4.primary.iterator();
            while (it.hasNext()) {
                Server next = it.next();
                if (next.name.equals("contact")) {
                    C3250y.m11453c("Primary Contact : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_contact_addrss", next.address);
                    C3159aa.m10964a("primary_contact_port", next.port);
                    C3159aa.m10966a("primary_region", next.region);
                } else if (next.name.equals("message")) {
                    C3250y.m11453c("Primary Message : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_message_addrss", next.address);
                    C3159aa.m10964a("primary_message_port", next.port);
                } else if (next.name.equals("file")) {
                    C3250y.m11453c("Primary File : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_file_addrss", next.address);
                    C3159aa.m10964a("primary_file_port", next.port);
                } else if (next.name.equals("sms")) {
                    C3250y.m11453c("Primary SMS : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_sms_address", next.address);
                    C3159aa.m10964a("primary_sms_port", next.port);
                } else if (next.name.equals("admin_mobileweb")) {
                    C3250y.m11453c("Primary ADMIN_MOBILEWEB : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_admin_mobileweb_address", next.address);
                    C3159aa.m10964a("primary_live_mobileweb_port", next.port);
                } else if (next.name.equals("live_mobileweb")) {
                    C3250y.m11453c("Primary LIVE_MOBILEWEB : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_live_mobileweb_address", next.address);
                    C3159aa.m10964a("primary_live_mobileweb_port", next.port);
                } else if (next.name.equals("message_wifi")) {
                    C3250y.m11453c("Primary Message_WIFI : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_message_wifi_addrss", next.address);
                    C3159aa.m10964a("primary_message_wifi_port", next.port);
                } else if (C1493a.m6463a("chatonv_feature") && next.name.equals("chaton_v")) {
                    C3250y.m11453c("Primary CHATON_V : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C3159aa.m10966a("primary_chaton_v_address", next.address);
                    C3159aa.m10964a("primary_chaton_v_port", next.port);
                }
            }
            Iterator<Server> it2 = getSSMServerAddress4.secondary.iterator();
            while (it2.hasNext()) {
                Server next2 = it2.next();
                if (next2.name.equals("contact")) {
                    C3250y.m11453c("Secondary Contact : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_contact_addrss", next2.address);
                    C3159aa.m10964a("secondary_contact_port", next2.port);
                } else if (next2.name.equals("message")) {
                    C3250y.m11453c("Secondary Message : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_message_addrss", next2.address);
                    C3159aa.m10964a("secondary_message_port", next2.port);
                } else if (next2.name.equals("file")) {
                    C3250y.m11453c("Secondary File : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_file_addrss", next2.address);
                    C3159aa.m10964a("secondary_file_port", next2.port);
                } else if (next2.name.equals("sms")) {
                    C3250y.m11453c("Secondary SMS : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_sms_addrss", next2.address);
                    C3159aa.m10964a("secondary_sms_port", next2.port);
                } else if (next2.name.equals("admin_mobileweb")) {
                    C3250y.m11453c("Secondary ADMIN_MOBILEWEB : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_admin_mobileweb_addrss", next2.address);
                    C3159aa.m10964a("secondary_live_mobileweb_port", next2.port);
                } else if (next2.name.equals("live_mobileweb")) {
                    C3250y.m11453c("Secondary LIVE_MOBILEWEB : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_live_mobileweb_addrss", next2.address);
                    C3159aa.m10964a("secondary_live_mobileweb_port", next2.port);
                } else if (next2.name.equals("message_wifi")) {
                    C3250y.m11453c("Secondary Message_WIFI : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_message_wifi_addrss", next2.address);
                    C3159aa.m10964a("secondary_message_wifi_port", next2.port);
                } else if (C1493a.m6463a("chatonv_feature") && next2.name.equals("chaton_v")) {
                    C3250y.m11453c("Secondary CHATON_V : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C3159aa.m10966a("secondary_chaton_v_address", next2.address);
                    C3159aa.m10964a("secondary_chaton_v_port", next2.port);
                }
            }
            C3216cd.m11278a();
            C3194bi.m11149a().m11153b();
            C3250y.m11438a();
        }
    }
}
