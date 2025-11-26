package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import android.content.Intent;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3082c;
import com.sec.chaton.push.util.C3112d;
import com.sec.chaton.push.util.C3115g;
import com.sec.p043a.p044a.p045a.C0766r;
import com.sec.p043a.p044a.p045a.C0769u;
import com.sec.spp.push.Config;
import java.util.ArrayList;

/* compiled from: NotiGroupMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.d */
/* loaded from: classes.dex */
public class C3076d implements InterfaceC3082c {

    /* renamed from: a */
    private static final String f11367a = C3076d.class.getSimpleName();

    /* renamed from: b */
    private Context f11368b;

    /* renamed from: c */
    private C3060d f11369c = PushClientApplication.m12499n().m12502p();

    public C3076d(Context context) {
        this.f11368b = context;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3082c
    /* renamed from: a */
    public Class<? extends GeneratedMessageLite> mo12548a() {
        return C0769u.class;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3082c
    /* renamed from: a */
    public void mo12549a(GeneratedMessageLite generatedMessageLite) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11367a, "NotiGroupMessageTask.onEvent()");
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11367a, "Rescheduling HeartBeat.");
        }
        HeartBeat.m12610e();
        C0769u c0769u = (C0769u) generatedMessageLite;
        if (C3115g.f11458a) {
            C3115g.m12704b(f11367a, "NotiGroup");
            C3115g.m12701a(f11367a, String.format("NotiElement count: %d.", Integer.valueOf(c0769u.m2773d())));
            C3115g.m12701a(f11367a, "==========================");
            C3115g.m12701a(f11367a, C3112d.m12684a((MessageLite) c0769u));
            C3115g.m12701a(f11367a, "==========================");
        }
        ArrayList arrayList = new ArrayList();
        for (C0766r c0766r : c0769u.m2772c()) {
            int iM2728j = c0766r.m2728j();
            int iM2726h = c0766r.m2726h();
            String strM2724f = c0766r.m2724f();
            String strM2722d = c0766r.m2722d();
            String strM12648e = C3099k.m12648e((String) null);
            if (iM2728j == 2) {
                m12547a(this.f11368b, c0766r.m2732n());
            } else if (strM12648e == null || !strM12648e.equals(strM2724f)) {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11367a, "The application id of notification isn't registered in device.");
                }
            } else {
                if (iM2726h == 2) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11367a, "This notification needs acknowledgement by application level.");
                    }
                } else if (iM2726h == 1) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11367a, "This notification needs acknowledgement by system level.");
                    }
                    arrayList.add(strM2722d);
                } else if (iM2726h == 0 && C3115g.f11458a) {
                    C3115g.m12701a(f11367a, "This notification doesn't need acknowledgement");
                }
                if (iM2728j != 1 && iM2728j != 2) {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11367a, "Broadcast notification will be sent to application.");
                    }
                    m12546a(this.f11368b, c0766r);
                } else if (C3115g.f11458a) {
                    C3115g.m12701a(f11367a, "Broadcast notification will not be sent to application.");
                }
            }
        }
        if (arrayList.size() != 0) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11367a, "Send system level NotiAcks to push server.");
            }
            try {
                C3088i.m12584a().m12591a(new C3075c(this.f11368b, arrayList));
            } catch (InterruptedException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(f11367a, e.getMessage(), e);
                }
            }
        }
    }

    /* renamed from: a */
    private void m12546a(Context context, C0766r c0766r) {
        Intent intent = new Intent("com.sec.chaton.push.NOTIFICATION_ACTION");
        boolean z = false;
        if (c0766r.m2726h() == 2) {
            z = true;
        }
        intent.putExtra(Config.NOTIFICATION_INTENT_NOTIID, c0766r.m2722d());
        intent.putExtra(Config.NOTIFICATION_INTENT_SENDER, c0766r.m2730l());
        intent.putExtra(Config.NOTIFICATION_INTENT_MSG, c0766r.m2732n());
        intent.putExtra(Config.NOTIFICATION_INTENT_APP_DATA, c0766r.m2734p());
        intent.putExtra(Config.NOTIFICATION_INTENT_TIMESTAMP, c0766r.m2736r());
        intent.putExtra(Config.NOTIFICATION_INTENT_SESSION_INFO, c0766r.m2740v());
        intent.putExtra(Config.NOTIFICATION_INTENT_CONNECTION_TERM, c0766r.m2738t());
        intent.putExtra(Config.NOTIFICATION_INTENT_ACK, z);
        context.sendBroadcast(intent, "com.sec.chaton.push.BROADCAST_PUSH_MESSAGE");
    }

    /* renamed from: a */
    private void m12547a(Context context, String str) {
        String[] strArrSplit = str.split("#");
        if (C3115g.f11461d) {
            C3115g.m12706d(f11367a, String.format("ResultCode : %s.", strArrSplit[0]));
            C3115g.m12706d(f11367a, String.format("Message : %s.", strArrSplit[1]));
        }
        switch (Integer.parseInt(strArrSplit[0])) {
            case 2000:
            case 2001:
            case 4000:
                break;
            case 4005:
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11367a, "Server error: internal server error.");
                }
                if (C3078f.m12556e() == EnumC3079g.Primary) {
                    if (C3115g.f11461d) {
                        C3115g.m12706d(f11367a, "Close connection.");
                    }
                    try {
                        this.f11369c.mo12527b();
                    } catch (C3044a e) {
                    }
                    if (C3115g.f11461d) {
                        C3115g.m12706d(f11367a, "Change target server.");
                    }
                    C3078f.m12555d();
                    if (C3115g.f11461d) {
                        C3115g.m12706d(f11367a, "Execute initialize.");
                    }
                    C3045b.m12505a().m12513e();
                    break;
                } else if (C3078f.m12556e() == EnumC3079g.Secondary) {
                    if (C3115g.f11461d) {
                        C3115g.m12706d(f11367a, "Close connection.");
                    }
                    try {
                        this.f11369c.mo12527b();
                    } catch (C3044a e2) {
                    }
                    C3099k.m12636b();
                    if (C3115g.f11461d) {
                        C3115g.m12706d(f11367a, "Execute reprovisioning.");
                    }
                    C3045b.m12505a().m12513e();
                    break;
                }
                break;
            default:
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11367a, "Unknown ResultCode.");
                    break;
                }
                break;
        }
    }
}
