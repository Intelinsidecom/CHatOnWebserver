package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import android.content.Intent;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2082c;
import com.sec.chaton.push.util.C2112d;
import com.sec.chaton.push.util.C2115g;
import com.sec.p013a.p014a.p015a.C0253r;
import com.sec.p013a.p014a.p015a.C0256u;
import com.sec.spp.push.Config;
import java.util.ArrayList;

/* compiled from: NotiGroupMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.d */
/* loaded from: classes.dex */
public class C2076d implements InterfaceC2082c {

    /* renamed from: a */
    private static final String f7957a = C2076d.class.getSimpleName();

    /* renamed from: b */
    private Context f7958b;

    /* renamed from: c */
    private C2060d f7959c = PushClientApplication.m8156h().m8159j();

    public C2076d(Context context) {
        this.f7958b = context;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2082c
    /* renamed from: a */
    public Class<? extends GeneratedMessageLite> mo8205a() {
        return C0256u.class;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2082c
    /* renamed from: a */
    public void mo8206a(GeneratedMessageLite generatedMessageLite) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7957a, "NotiGroupMessageTask.onEvent()");
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f7957a, "Rescheduling HeartBeat.");
        }
        HeartBeat.m8267e();
        C0256u c0256u = (C0256u) generatedMessageLite;
        if (C2115g.f8048a) {
            C2115g.m8362b(f7957a, "NotiGroup");
            C2115g.m8359a(f7957a, String.format("NotiElement count: %d.", Integer.valueOf(c0256u.m1041d())));
            C2115g.m8359a(f7957a, "==========================");
            C2115g.m8359a(f7957a, C2112d.m8342a((MessageLite) c0256u));
            C2115g.m8359a(f7957a, "==========================");
        }
        ArrayList arrayList = new ArrayList();
        for (C0253r c0253r : c0256u.m1040c()) {
            int iM996j = c0253r.m996j();
            int iM994h = c0253r.m994h();
            String strM992f = c0253r.m992f();
            String strM990d = c0253r.m990d();
            String strM8306e = C2099k.m8306e((String) null);
            if (iM996j == 2) {
                m8204a(this.f7958b, c0253r.m1000n());
            } else if (strM8306e == null || !strM8306e.equals(strM992f)) {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f7957a, "The application id of notification isn't registered in device.");
                }
            } else {
                if (iM994h == 2) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7957a, "This notification needs acknowledgement by application level.");
                    }
                } else if (iM994h == 1) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7957a, "This notification needs acknowledgement by system level.");
                    }
                    arrayList.add(strM990d);
                } else if (iM994h == 0 && C2115g.f8048a) {
                    C2115g.m8359a(f7957a, "This notification doesn't need acknowledgement");
                }
                if (iM996j != 1 && iM996j != 2) {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7957a, "Broadcast notification will be sent to application.");
                    }
                    m8203a(this.f7958b, c0253r);
                } else if (C2115g.f8048a) {
                    C2115g.m8359a(f7957a, "Broadcast notification will not be sent to application.");
                }
            }
        }
        if (arrayList.size() != 0) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7957a, "Send system level NotiAcks to push server.");
            }
            try {
                C2088i.m8241a().m8248a(new C2075c(this.f7958b, arrayList));
            } catch (InterruptedException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(f7957a, e.getMessage(), e);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8203a(Context context, C0253r c0253r) {
        Intent intent = new Intent("com.sec.chaton.push.NOTIFICATION_ACTION");
        boolean z = false;
        if (c0253r.m994h() == 2) {
            z = true;
        }
        intent.putExtra(Config.NOTIFICATION_INTENT_NOTIID, c0253r.m990d());
        intent.putExtra(Config.NOTIFICATION_INTENT_SENDER, c0253r.m998l());
        intent.putExtra(Config.NOTIFICATION_INTENT_MSG, c0253r.m1000n());
        intent.putExtra(Config.NOTIFICATION_INTENT_APP_DATA, c0253r.m1002p());
        intent.putExtra(Config.NOTIFICATION_INTENT_TIMESTAMP, c0253r.m1004r());
        intent.putExtra(Config.NOTIFICATION_INTENT_SESSION_INFO, c0253r.m1008v());
        intent.putExtra(Config.NOTIFICATION_INTENT_CONNECTION_TERM, c0253r.m1006t());
        intent.putExtra(Config.NOTIFICATION_INTENT_ACK, z);
        context.sendBroadcast(intent, "com.sec.chaton.push.BROADCAST_PUSH_MESSAGE");
    }

    /* renamed from: a */
    private void m8204a(Context context, String str) {
        String[] strArrSplit = str.split("#");
        if (C2115g.f8051d) {
            C2115g.m8364d(f7957a, String.format("ResultCode : %s.", strArrSplit[0]));
            C2115g.m8364d(f7957a, String.format("Message : %s.", strArrSplit[1]));
        }
        switch (Integer.parseInt(strArrSplit[0])) {
            case 2000:
            case 2001:
            case 4000:
                break;
            case 4005:
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7957a, "Server error: internal server error.");
                }
                if (C2078f.m8213e() == EnumC2079g.Primary) {
                    if (C2115g.f8051d) {
                        C2115g.m8364d(f7957a, "Close connection.");
                    }
                    try {
                        this.f7959c.mo8184b();
                    } catch (C2044a e) {
                    }
                    if (C2115g.f8051d) {
                        C2115g.m8364d(f7957a, "Change target server.");
                    }
                    C2078f.m8212d();
                    if (C2115g.f8051d) {
                        C2115g.m8364d(f7957a, "Execute initialize.");
                    }
                    C2045b.m8162a().m8170e();
                    break;
                } else if (C2078f.m8213e() == EnumC2079g.Secondary) {
                    if (C2115g.f8051d) {
                        C2115g.m8364d(f7957a, "Close connection.");
                    }
                    try {
                        this.f7959c.mo8184b();
                    } catch (C2044a e2) {
                    }
                    C2099k.m8293b();
                    if (C2115g.f8051d) {
                        C2115g.m8364d(f7957a, "Execute reprovisioning.");
                    }
                    C2045b.m8162a().m8170e();
                    break;
                }
                break;
            default:
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7957a, "Unknown ResultCode.");
                    break;
                }
                break;
        }
    }
}
