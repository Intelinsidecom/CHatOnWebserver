package com.sec.chaton.push.p039c.p040a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p035a.p037b.C0864b;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0874g;
import com.sec.chaton.push.p038b.C0879l;
import com.sec.chaton.push.p039c.AbstractC0894f;
import com.sec.chaton.push.p039c.C0881a;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.InterfaceC0890b;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0069ac;
import com.sec.p004a.p005a.p006a.C0083b;
import com.sec.p004a.p005a.p006a.C0096o;

/* compiled from: ProvMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.a */
/* loaded from: classes.dex */
public class C0882a extends AbstractC0894f implements InterfaceC0890b {

    /* renamed from: a */
    private static final String f3021a = C0882a.class.getSimpleName();

    /* renamed from: b */
    private static EnumC0884c f3022b = EnumC0884c.Primary;

    /* renamed from: c */
    private C0864b f3023c;

    /* renamed from: d */
    private InterfaceC0898j f3024d;

    public C0882a(Context context) {
        super(context, 0L);
        this.f3023c = PushClientApplication.m3437b().m3441e();
        this.f3024d = null;
    }

    /* renamed from: a */
    public static boolean m3482a(Context context) {
        return (C0904h.m3546b((String) null) == null || C0904h.m3552c((String) null) == null || C0904h.m3537a(0) == 0) ? false : true;
    }

    /* renamed from: b */
    public static String m3484b(Context context) {
        if (f3022b == EnumC0884c.Primary) {
            return C0904h.m3552c((String) null);
        }
        if (f3022b == EnumC0884c.Secondary) {
            return C0904h.m3556d((String) null);
        }
        throw new IllegalStateException("Shouldn't reach this code.");
    }

    /* renamed from: c */
    public static int m3485c(Context context) {
        if (f3022b == EnumC0884c.Primary) {
            return C0904h.m3537a(-1);
        }
        if (f3022b == EnumC0884c.Secondary) {
            return C0904h.m3545b(-1);
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: a */
    public static void m3480a() {
        if (f3022b == EnumC0884c.Primary) {
            f3022b = EnumC0884c.Secondary;
            if (C0921g.f3117b) {
                C0921g.m3640b(f3021a, String.format("Change server to %s.", f3022b));
                return;
            }
            return;
        }
        if (f3022b == EnumC0884c.Secondary) {
            f3022b = EnumC0884c.Primary;
            if (C0921g.f3117b) {
                C0921g.m3640b(f3021a, String.format("Change server to %s.", f3022b));
                return;
            }
            return;
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: b */
    public static EnumC0884c m3483b() {
        return f3022b;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: c */
    public Class mo3487c() {
        return C0069ac.class;
    }

    @Override // com.sec.chaton.push.p039c.AbstractC0894f
    /* renamed from: d */
    public C0881a mo3488d() {
        String strSubstring;
        String strSubstring2;
        if (C0921g.f3116a) {
            C0921g.m3637a(f3021a, "ProvMessageTask.onRequest().");
        }
        C0879l.m3463a().m3469c();
        if (m3482a(m3518e())) {
            if (C0921g.f3118c) {
                C0921g.m3641c(f3021a, "Provisioning data already exists.");
            }
            if (this.f3024d != null) {
                this.f3024d.mo3532a(-100);
            }
            return null;
        }
        if (C0921g.f3117b) {
            C0921g.m3640b(f3021a, "Connect to provisioning server(gld.push.samsungosp.com:5223).");
        }
        try {
            this.f3023c.mo3455a("gld.push.samsungosp.com", 5223, true);
            C0083b c0083bNewBuilder = C0096o.newBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) m3518e().getSystemService("phone");
            String strM3539a = C0904h.m3539a((String) null);
            String strSubstring3 = "";
            String strSubstring4 = "";
            String str = "";
            String str2 = "";
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() != 0) {
                strSubstring3 = networkOperator.substring(0, 3);
                strSubstring4 = networkOperator.substring(3);
            } else if (C0921g.f3118c) {
                C0921g.m3641c(f3021a, "Use empty network mcc and mnc because couldn't retrieve network information.");
            }
            if (telephonyManager.getSimState() == 5) {
                String simOperator = telephonyManager.getSimOperator();
                if (simOperator == null || simOperator.length() == 0) {
                    strSubstring = "";
                    strSubstring2 = "";
                } else {
                    strSubstring2 = simOperator.substring(0, 3);
                    strSubstring = simOperator.substring(3);
                }
                str = strSubstring2;
                str2 = strSubstring;
            } else if (C0921g.f3118c) {
                C0921g.m3641c(f3021a, "Use empty mcc and mnc because couldn't retrieve sim information.");
                C0921g.m3641c(f3021a, "SIM State: " + telephonyManager.getSimState());
            }
            String str3 = Build.MODEL;
            c0083bNewBuilder.m319a("1");
            c0083bNewBuilder.m322c("00000000");
            c0083bNewBuilder.m321b(strM3539a);
            c0083bNewBuilder.m326e("device.model=" + str3 + "&sim.mcc=" + str + "&sim.mnc=" + str2 + "&net.mcc=" + strSubstring3 + "&net.mnc=" + strSubstring4);
            if (C0921g.f3116a) {
                C0921g.m3637a(f3021a, "Device id: " + strM3539a);
                C0921g.m3637a(f3021a, "Network.MCC: " + strSubstring3);
                C0921g.m3637a(f3021a, "Network.MNC: " + strSubstring4);
                C0921g.m3637a(f3021a, "SIM.MCC: " + str);
                C0921g.m3637a(f3021a, "SIM.MNC: " + str2);
                C0921g.m3637a(f3021a, "Device model: " + str3);
            }
            String strM3546b = C0904h.m3546b((String) null);
            if (strM3546b != null && strM3546b.length() != 0) {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3021a, String.format("This device has a device token(%s). Using it to provisioning.", strM3546b));
                }
                c0083bNewBuilder.m324d(strM3546b);
            }
            return new C0881a().m3478a(this.f3023c).m3477a(c0083bNewBuilder.build());
        } catch (C0874g e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3021a, "Can't connect to provisioning server hence network isn't avaliable.", e);
            }
            m3481a(-103);
            if (this.f3024d != null) {
                this.f3024d.mo3532a(-2);
            }
            return null;
        } catch (C0872e e2) {
            if (C0921g.f3119d) {
                C0921g.m3638a(f3021a, "Can't connect to provisioning server.", e2);
            }
            m3481a(-103);
            C0879l.m3463a().m3468b();
            if (this.f3024d != null) {
                this.f3024d.mo3532a(-2);
            }
            return null;
        }
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0890b
    /* renamed from: a */
    public void mo3486a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3021a, String.format("ProvMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        try {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3021a, "Disconnect provisioning connection.");
            }
            this.f3023c.mo3457b();
        } catch (C0872e e) {
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3021a, "Response message is null.");
                    return;
                }
                return;
            }
            C0069ac c0069ac = (C0069ac) generatedMessageLite;
            int iM127d = c0069ac.m127d();
            if (iM127d == 1000) {
                String strM129f = c0069ac.m129f();
                String strM131h = c0069ac.m131h();
                int iM133j = c0069ac.m133j();
                String strM135l = c0069ac.m135l();
                int iM137n = c0069ac.m137n();
                int iM139p = c0069ac.m139p();
                if (iM139p == 0) {
                    if (C0921g.f3118c) {
                        C0921g.m3641c(f3021a, "Server sent PingInterval to 0, rearrange this value to 8.");
                    }
                    iM139p = 8;
                }
                C0879l.m3463a().m3470d();
                C0904h.m3544a(strM129f, strM131h, iM133j, strM135l, iM137n, iM139p);
                try {
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3021a, "Execute initialize.");
                    }
                    C0896h.m3520a().m3527a(new C0888g(m3518e()));
                } catch (InterruptedException e2) {
                    if (C0921g.f3119d) {
                        C0921g.m3638a(f3021a, e2.getMessage(), e2);
                    }
                }
                if (this.f3024d != null) {
                    this.f3024d.mo3531a();
                    return;
                }
                return;
            }
            if (C0921g.f3119d) {
                C0921g.m3642d(f3021a, String.format("Prov reply result code is error. ErrorCode: %d.", Integer.valueOf(iM127d)));
            }
            if (iM127d == 3001 || iM127d == 3000) {
                m3481a(-103);
                if (this.f3024d != null) {
                    this.f3024d.mo3532a(-103);
                }
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3021a, "Restart device.");
                    return;
                }
                return;
            }
            if (iM127d == 3002) {
                m3481a(-103);
                if (C0921g.f3119d) {
                    C0921g.m3642d(f3021a, "Execute reprovisioning.");
                }
                C0904h.m3547b();
                C0879l.m3463a().m3468b();
                if (this.f3024d != null) {
                    this.f3024d.mo3532a(-103);
                    return;
                }
                return;
            }
            m3481a(-103);
            if (this.f3024d != null) {
                this.f3024d.mo3532a(-103);
                return;
            }
            return;
        }
        m3481a(-103);
        if (i == -1) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3021a, "Internal error code is timeout.");
            }
            try {
                if (C0921g.f3116a) {
                    C0921g.m3637a(f3021a, "Disconnect connection.");
                }
                this.f3023c.mo3457b();
            } catch (C0872e e3) {
            }
            C0879l.m3463a().m3468b();
        }
        if (this.f3024d != null) {
            this.f3024d.mo3532a(-103);
        }
    }

    /* renamed from: a */
    private void m3481a(int i) {
        C0879l.m3463a().m3466a(i);
    }
}
