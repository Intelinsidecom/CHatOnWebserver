package com.sec.chaton.p055d.p056a;

import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetSSMServerAddress4;
import com.sec.chaton.p065io.entry.inner.Server;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4904y;
import java.util.Iterator;

/* compiled from: GLDServer4Task.java */
/* renamed from: com.sec.chaton.d.a.bd */
/* loaded from: classes.dex */
public class C1931bd extends AbstractC1900a {
    public C1931bd(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (!c0778b.m18954n() || c0778b.m3110e() == null || c0778b.m3107b() == EnumC2464o.ERROR) {
            C2404a.m10430a("01000002", "0501", c0778b);
        }
        if (c0778b.m3110e() != null) {
            GetSSMServerAddress4 getSSMServerAddress4 = (GetSSMServerAddress4) c0778b.m3110e();
            C4809aa.m18107a("expdate", getSSMServerAddress4.expdate);
            C4904y.m18641c("MSISDN From Server : " + getSSMServerAddress4.msisdn, getClass().getSimpleName());
            Iterator<Server> it = getSSMServerAddress4.primary.iterator();
            while (it.hasNext()) {
                Server next = it.next();
                if (next.name.equals("contact")) {
                    C4904y.m18641c("Primary Contact : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_contact_addrss", next.address);
                    C4809aa.m18106a("primary_contact_port", next.port);
                    C4809aa.m18108a("primary_region", next.region);
                } else if (next.name.equals(VKApiConst.MESSAGE)) {
                    C4904y.m18641c("Primary Message : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_message_addrss", next.address);
                    C4809aa.m18106a("primary_message_port", next.port);
                } else if (next.name.equals("file")) {
                    C4904y.m18641c("Primary File : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_file_addrss", next.address);
                    C4809aa.m18106a("primary_file_port", next.port);
                } else if (next.name.equals("sms")) {
                    C4904y.m18641c("Primary SMS : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_sms_address", next.address);
                    C4809aa.m18106a("primary_sms_port", next.port);
                } else if (next.name.equals("admin_mobileweb")) {
                    C4904y.m18641c("Primary ADMIN_MOBILEWEB : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_admin_mobileweb_address", next.address);
                    C4809aa.m18106a("primary_live_mobileweb_port", next.port);
                } else if (next.name.equals("live_mobileweb")) {
                    C4904y.m18641c("Primary LIVE_MOBILEWEB : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_live_mobileweb_address", next.address);
                    C4809aa.m18106a("primary_live_mobileweb_port", next.port);
                } else if (next.name.equals("message_wifi")) {
                    C4904y.m18641c("Primary Message_WIFI : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_message_wifi_addrss", next.address);
                    C4809aa.m18106a("primary_message_wifi_port", next.port);
                } else if (C2349a.m10301a("chatonv_feature") && next.name.equals("chaton_v")) {
                    C4904y.m18641c("Primary CHATON_V : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_chaton_v_address", next.address);
                    C4809aa.m18106a("primary_chaton_v_port", next.port);
                } else if (next.name.equals("item_shop")) {
                    C4904y.m18641c("Primary Shop : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_shop_address", next.address);
                    C4809aa.m18106a("primary_shop_port", next.port);
                } else if (next.name.equals("translation_auth")) {
                    C4904y.m18641c("Primary Translation_Auth : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_translation_auth_address", next.address);
                    C4809aa.m18106a("primary_translation_auth_port", next.port);
                } else if (next.name.equals("game_mobileweb")) {
                    C4904y.m18641c("Primary Game : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_game_address", next.address);
                    C4809aa.m18106a("primary_game_port", next.port);
                } else if (next.name.equals("auth")) {
                    C4904y.m18641c("Primary Auth : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_auth_address", next.address);
                    C4809aa.m18106a("primary_auth_port", next.port);
                } else if (next.name.equals("big_file")) {
                    C4904y.m18641c("Primary huge file : " + next.address + " : " + next.port, getClass().getSimpleName());
                    C4809aa.m18108a("primary_huge_file_address", next.address);
                    C4809aa.m18106a("primary_huge_file_port", next.port);
                }
            }
            Iterator<Server> it2 = getSSMServerAddress4.secondary.iterator();
            while (it2.hasNext()) {
                Server next2 = it2.next();
                if (next2.name.equals("contact")) {
                    C4904y.m18641c("Secondary Contact : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_contact_addrss", next2.address);
                    C4809aa.m18106a("secondary_contact_port", next2.port);
                } else if (next2.name.equals(VKApiConst.MESSAGE)) {
                    C4904y.m18641c("Secondary Message : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_message_addrss", next2.address);
                    C4809aa.m18106a("secondary_message_port", next2.port);
                } else if (next2.name.equals("file")) {
                    C4904y.m18641c("Secondary File : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_file_addrss", next2.address);
                    C4809aa.m18106a("secondary_file_port", next2.port);
                } else if (next2.name.equals("sms")) {
                    C4904y.m18641c("Secondary SMS : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_sms_addrss", next2.address);
                    C4809aa.m18106a("secondary_sms_port", next2.port);
                } else if (next2.name.equals("admin_mobileweb")) {
                    C4904y.m18641c("Secondary ADMIN_MOBILEWEB : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_admin_mobileweb_addrss", next2.address);
                    C4809aa.m18106a("secondary_live_mobileweb_port", next2.port);
                } else if (next2.name.equals("live_mobileweb")) {
                    C4904y.m18641c("Secondary LIVE_MOBILEWEB : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_live_mobileweb_addrss", next2.address);
                    C4809aa.m18106a("secondary_live_mobileweb_port", next2.port);
                } else if (next2.name.equals("message_wifi")) {
                    C4904y.m18641c("Secondary Message_WIFI : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_message_wifi_addrss", next2.address);
                    C4809aa.m18106a("secondary_message_wifi_port", next2.port);
                } else if (C2349a.m10301a("chatonv_feature") && next2.name.equals("chaton_v")) {
                    C4904y.m18641c("Secondary CHATON_V : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_chaton_v_address", next2.address);
                    C4809aa.m18106a("secondary_chaton_v_port", next2.port);
                } else if (next2.name.equals("item_shop")) {
                    C4904y.m18641c("Secondary Shop : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_shop_addrss", next2.address);
                    C4809aa.m18106a("secondary_shop_port", next2.port);
                } else if (next2.name.equals("translation_auth")) {
                    C4904y.m18641c("Secondary Translation_Auth : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_translation_auth_addrss", next2.address);
                    C4809aa.m18106a("secondary_translation_auth_port", next2.port);
                } else if (next2.name.equals("game_mobileweb")) {
                    C4904y.m18641c("Secondary Game : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_game_addrss", next2.address);
                    C4809aa.m18106a("secondary_game_port", next2.port);
                } else if (next2.name.equals("auth")) {
                    C4904y.m18641c("Secondary Auth : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_auth_addrss", next2.address);
                    C4809aa.m18106a("secondary_auth_port", next2.port);
                } else if (next2.name.equals("big_file")) {
                    C4904y.m18641c("Secondary huge file : " + next2.address + " : " + next2.port, getClass().getSimpleName());
                    C4809aa.m18108a("secondary_huge_file_addrss", next2.address);
                    C4809aa.m18106a("secondary_huge_file_port", next2.port);
                }
            }
            C4865cc.m18445a();
            C4844bi.m18323a().m18327b();
            C4904y.m18638b();
        }
    }
}
