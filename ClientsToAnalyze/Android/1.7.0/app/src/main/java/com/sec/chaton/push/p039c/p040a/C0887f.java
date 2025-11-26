package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import android.content.Intent;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p035a.p037b.C0866d;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0879l;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0895g;
import com.sec.chaton.push.util.C0919e;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0077ak;
import com.sec.p004a.p005a.p006a.C0103v;
import com.sec.spp.push.Config;
import java.util.ArrayList;

/* compiled from: NotiGroupMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.f */
/* loaded from: classes.dex */
public class C0887f implements InterfaceC0895g {

    /* renamed from: a */
    private static final String f3041a = C0887f.class.getSimpleName();

    /* renamed from: b */
    private Context f3042b;

    /* renamed from: c */
    private C0866d f3043c = PushClientApplication.m3437b().m3440d();

    public C0887f(Context context) {
        this.f3042b = context;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0895g
    /* renamed from: a */
    public Class mo3493a() {
        return C0077ak.class;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0895g
    /* renamed from: a */
    public void mo3494a(GeneratedMessageLite generatedMessageLite) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3041a, "NotiGroupMessageTask.onEvent()");
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f3041a, "Rescheduling HeartBeat.");
        }
        HeartBeat.m3577e();
        C0077ak c0077ak = (C0077ak) generatedMessageLite;
        if (C0921g.f3116a) {
            C0921g.m3640b(f3041a, "NotiGroup");
            C0921g.m3637a(f3041a, String.format("NotiElement count: %d.", Integer.valueOf(c0077ak.m273d())));
            C0921g.m3637a(f3041a, "==========================");
            C0921g.m3637a(f3041a, C0919e.m3621a((MessageLite) c0077ak));
            C0921g.m3637a(f3041a, "==========================");
        }
        ArrayList arrayList = new ArrayList();
        for (C0103v c0103v : c0077ak.m272c()) {
            int iM530j = c0103v.m530j();
            int iM528h = c0103v.m528h();
            String strM526f = c0103v.m526f();
            String strM524d = c0103v.m524d();
            String strM3560e = C0904h.m3560e((String) null);
            if (iM530j == 2) {
                m3492a(this.f3042b, c0103v.m534n());
            } else if (strM3560e == null || !strM3560e.equals(strM526f)) {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3041a, "The application id of notification isn't registered in device.");
                }
            } else {
                if (iM528h == 2) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3041a, "This notification needs acknowledgement by application level.");
                    }
                } else if (iM528h == 1) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3041a, "This notification needs acknowledgement by system level.");
                    }
                    arrayList.add(strM524d);
                } else if (iM528h == 0 && C0921g.f3116a) {
                    C0921g.m3637a(f3041a, "This notification doesn't need acknowledgement");
                }
                if (iM530j != 1 && iM530j != 2) {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3041a, "Broadcast notification will be sent to application.");
                    }
                    m3491a(this.f3042b, c0103v);
                } else if (C0921g.f3116a) {
                    C0921g.m3637a(f3041a, "Broadcast notification will not be sent to application.");
                }
            }
        }
        if (arrayList.size() != 0) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3041a, "Send system level NotiAcks to push server.");
            }
            try {
                C0896h.m3520a().m3527a(new C0883b(this.f3042b, arrayList));
            } catch (InterruptedException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(f3041a, e.getMessage(), e);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3491a(Context context, C0103v c0103v) {
        Intent intent = new Intent("com.sec.chaton.push.NOTIFICATION_ACTION");
        boolean z = false;
        if (c0103v.m528h() == 2) {
            z = true;
        }
        intent.putExtra(Config.NOTIFICATION_INTENT_NOTIID, c0103v.m524d());
        intent.putExtra(Config.NOTIFICATION_INTENT_SENDER, c0103v.m532l());
        intent.putExtra(Config.NOTIFICATION_INTENT_MSG, c0103v.m534n());
        intent.putExtra(Config.NOTIFICATION_INTENT_APP_DATA, c0103v.m536p());
        intent.putExtra(Config.NOTIFICATION_INTENT_TIMESTAMP, c0103v.m538r());
        intent.putExtra(Config.NOTIFICATION_INTENT_SESSION_INFO, c0103v.m542v());
        intent.putExtra(Config.NOTIFICATION_INTENT_CONNECTION_TERM, c0103v.m540t());
        intent.putExtra(Config.NOTIFICATION_INTENT_ACK, z);
        context.sendBroadcast(intent, "com.sec.chaton.push.BROADCAST_PUSH_MESSAGE");
    }

    /* renamed from: a */
    private void m3492a(Context context, String str) {
        String[] strArrSplit = str.split("#");
        if (C0921g.f3119d) {
            C0921g.m3642d(f3041a, String.format("ResultCode : %s.", strArrSplit[0]));
            C0921g.m3642d(f3041a, String.format("Message : %s.", strArrSplit[1]));
        }
        switch (Integer.parseInt(strArrSplit[0])) {
            case 2000:
            case 2001:
            case 4000:
                break;
            case 4005:
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3041a, "Server error: internal server error.");
                }
                if (C0882a.m3483b() == EnumC0884c.Primary) {
                    if (C0921g.f3119d) {
                        C0921g.m3642d(f3041a, "Close connection.");
                    }
                    try {
                        this.f3043c.mo3457b();
                    } catch (C0872e e) {
                    }
                    if (C0921g.f3119d) {
                        C0921g.m3642d(f3041a, "Change target server.");
                    }
                    C0882a.m3480a();
                    if (C0921g.f3119d) {
                        C0921g.m3642d(f3041a, "Execute initialize.");
                    }
                    C0879l.m3463a().m3471e();
                    break;
                } else if (C0882a.m3483b() == EnumC0884c.Secondary) {
                    if (C0921g.f3119d) {
                        C0921g.m3642d(f3041a, "Close connection.");
                    }
                    try {
                        this.f3043c.mo3457b();
                    } catch (C0872e e2) {
                    }
                    C0904h.m3547b();
                    if (C0921g.f3119d) {
                        C0921g.m3642d(f3041a, "Execute reprovisioning.");
                    }
                    C0879l.m3463a().m3471e();
                    break;
                }
                break;
            default:
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3041a, "Unknown ResultCode.");
                    break;
                }
                break;
        }
    }
}
