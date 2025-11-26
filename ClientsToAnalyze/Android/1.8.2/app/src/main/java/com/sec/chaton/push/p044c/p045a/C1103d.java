package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import android.content.Intent;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p041b.p042a.C1087d;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1109c;
import com.sec.chaton.push.util.C1136d;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0089r;
import com.sec.p004a.p005a.p006a.C0092u;
import com.sec.spp.push.Config;
import java.util.ArrayList;

/* compiled from: NotiGroupMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.d */
/* loaded from: classes.dex */
public class C1103d implements InterfaceC1109c {

    /* renamed from: a */
    private static final String f4055a = C1103d.class.getSimpleName();

    /* renamed from: b */
    private Context f4056b;

    /* renamed from: c */
    private C1087d f4057c = PushClientApplication.m4112h().m4115j();

    public C1103d(Context context) {
        this.f4056b = context;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1109c
    /* renamed from: a */
    public Class mo4160a() {
        return C0092u.class;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1109c
    /* renamed from: a */
    public void mo4161a(GeneratedMessageLite generatedMessageLite) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4055a, "NotiGroupMessageTask.onEvent()");
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4055a, "Rescheduling HeartBeat.");
        }
        HeartBeat.m4221c();
        C0092u c0092u = (C0092u) generatedMessageLite;
        if (C1139g.f4142a) {
            C1139g.m4311b(f4055a, "NotiGroup");
            C1139g.m4308a(f4055a, String.format("NotiElement count: %d.", Integer.valueOf(c0092u.m529d())));
            C1139g.m4308a(f4055a, "==========================");
            C1139g.m4308a(f4055a, C1136d.m4291a((MessageLite) c0092u));
            C1139g.m4308a(f4055a, "==========================");
        }
        ArrayList arrayList = new ArrayList();
        for (C0089r c0089r : c0092u.m528c()) {
            int iM484j = c0089r.m484j();
            int iM482h = c0089r.m482h();
            String strM480f = c0089r.m480f();
            String strM478d = c0089r.m478d();
            String strM4262e = C1126j.m4262e((String) null);
            if (iM484j == 2) {
                m4159a(this.f4056b, c0089r.m488n());
            } else if (strM4262e == null || !strM4262e.equals(strM480f)) {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4055a, "The application id of notification isn't registered in device.");
                }
            } else {
                if (iM482h == 2) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4055a, "This notification needs acknowledgement by application level.");
                    }
                } else if (iM482h == 1) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4055a, "This notification needs acknowledgement by system level.");
                    }
                    arrayList.add(strM478d);
                } else if (iM482h == 0 && C1139g.f4142a) {
                    C1139g.m4308a(f4055a, "This notification doesn't need acknowledgement");
                }
                if (iM484j != 1 && iM484j != 2) {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4055a, "Broadcast notification will be sent to application.");
                    }
                    m4158a(this.f4056b, c0089r);
                } else if (C1139g.f4142a) {
                    C1139g.m4308a(f4055a, "Broadcast notification will not be sent to application.");
                }
            }
        }
        if (arrayList.size() != 0) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4055a, "Send system level NotiAcks to push server.");
            }
            try {
                C1115i.m4196a().m4203a(new C1102c(this.f4056b, arrayList));
            } catch (InterruptedException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(f4055a, e.getMessage(), e);
                }
            }
        }
    }

    /* renamed from: a */
    private void m4158a(Context context, C0089r c0089r) {
        Intent intent = new Intent("com.sec.chaton.push.NOTIFICATION_ACTION");
        boolean z = false;
        if (c0089r.m482h() == 2) {
            z = true;
        }
        intent.putExtra(Config.NOTIFICATION_INTENT_NOTIID, c0089r.m478d());
        intent.putExtra(Config.NOTIFICATION_INTENT_SENDER, c0089r.m486l());
        intent.putExtra(Config.NOTIFICATION_INTENT_MSG, c0089r.m488n());
        intent.putExtra(Config.NOTIFICATION_INTENT_APP_DATA, c0089r.m490p());
        intent.putExtra(Config.NOTIFICATION_INTENT_TIMESTAMP, c0089r.m492r());
        intent.putExtra(Config.NOTIFICATION_INTENT_SESSION_INFO, c0089r.m496v());
        intent.putExtra(Config.NOTIFICATION_INTENT_CONNECTION_TERM, c0089r.m494t());
        intent.putExtra(Config.NOTIFICATION_INTENT_ACK, z);
        context.sendBroadcast(intent, "com.sec.chaton.push.BROADCAST_PUSH_MESSAGE");
    }

    /* renamed from: a */
    private void m4159a(Context context, String str) {
        String[] strArrSplit = str.split("#");
        if (C1139g.f4145d) {
            C1139g.m4313d(f4055a, String.format("ResultCode : %s.", strArrSplit[0]));
            C1139g.m4313d(f4055a, String.format("Message : %s.", strArrSplit[1]));
        }
        switch (Integer.parseInt(strArrSplit[0])) {
            case 2000:
            case 2001:
            case 4000:
                break;
            case 4005:
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4055a, "Server error: internal server error.");
                }
                if (C1105f.m4168e() == EnumC1106g.Primary) {
                    if (C1139g.f4145d) {
                        C1139g.m4313d(f4055a, "Close connection.");
                    }
                    try {
                        this.f4057c.mo4140b();
                    } catch (C1071a e) {
                    }
                    if (C1139g.f4145d) {
                        C1139g.m4313d(f4055a, "Change target server.");
                    }
                    C1105f.m4167d();
                    if (C1139g.f4145d) {
                        C1139g.m4313d(f4055a, "Execute initialize.");
                    }
                    C1072b.m4118a().m4126e();
                    break;
                } else if (C1105f.m4168e() == EnumC1106g.Secondary) {
                    if (C1139g.f4145d) {
                        C1139g.m4313d(f4055a, "Close connection.");
                    }
                    try {
                        this.f4057c.mo4140b();
                    } catch (C1071a e2) {
                    }
                    C1126j.m4249b();
                    if (C1139g.f4145d) {
                        C1139g.m4313d(f4055a, "Execute reprovisioning.");
                    }
                    C1072b.m4118a().m4126e();
                    break;
                }
                break;
            default:
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4055a, "Unknown ResultCode.");
                    break;
                }
                break;
        }
    }
}
