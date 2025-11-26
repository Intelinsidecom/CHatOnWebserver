package com.sec.chaton.push.p044c.p045a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p040a.C1081k;
import com.sec.chaton.push.p041b.p042a.C1086c;
import com.sec.chaton.push.p044c.AbstractC1099a;
import com.sec.chaton.push.p044c.C1114h;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.p044c.InterfaceC1110d;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0060ad;
import com.sec.p004a.p005a.p006a.C0063ag;
import com.sec.p004a.p005a.p006a.C0064ah;

/* compiled from: ProvMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.f */
/* loaded from: classes.dex */
public class C1105f extends AbstractC1099a implements InterfaceC1110d {

    /* renamed from: a */
    private static final String f4062a = C1105f.class.getSimpleName();

    /* renamed from: b */
    private static EnumC1106g f4063b = EnumC1106g.Primary;

    /* renamed from: c */
    private C1086c f4064c;

    /* renamed from: d */
    private InterfaceC1108b f4065d;

    public C1105f(Context context) {
        super(context, 0L);
        this.f4064c = PushClientApplication.m4112h().m4116k();
        this.f4065d = null;
    }

    /* renamed from: a */
    public static boolean m4164a(Context context) {
        return (C1126j.m4248b((String) null) == null || C1126j.m4254c((String) null) == null || C1126j.m4239a(0) == 0) ? false : true;
    }

    /* renamed from: b */
    public static String m4165b(Context context) {
        if (f4063b == EnumC1106g.Primary) {
            return C1126j.m4254c((String) null);
        }
        if (f4063b == EnumC1106g.Secondary) {
            return C1126j.m4258d((String) null);
        }
        throw new IllegalStateException("Shouldn't reach this code.");
    }

    /* renamed from: c */
    public static int m4166c(Context context) {
        if (f4063b == EnumC1106g.Primary) {
            return C1126j.m4239a(-1);
        }
        if (f4063b == EnumC1106g.Secondary) {
            return C1126j.m4247b(-1);
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: d */
    public static void m4167d() {
        if (f4063b == EnumC1106g.Primary) {
            f4063b = EnumC1106g.Secondary;
            if (C1139g.f4143b) {
                C1139g.m4311b(f4062a, String.format("Change server to %s.", f4063b));
                return;
            }
            return;
        }
        if (f4063b == EnumC1106g.Secondary) {
            f4063b = EnumC1106g.Primary;
            if (C1139g.f4143b) {
                C1139g.m4311b(f4062a, String.format("Change server to %s.", f4063b));
                return;
            }
            return;
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: e */
    public static EnumC1106g m4168e() {
        return f4063b;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a_ */
    public Class mo4153a_() {
        return C0060ad.class;
    }

    @Override // com.sec.chaton.push.p044c.AbstractC1099a
    /* renamed from: c */
    public C1114h mo4150c() {
        String strSubstring;
        String strSubstring2;
        if (C1139g.f4142a) {
            C1139g.m4308a(f4062a, "ProvMessageTask.onRequest().");
        }
        C1072b.m4118a().m4124c();
        if (m4164a(m4148a())) {
            if (C1139g.f4144c) {
                C1139g.m4312c(f4062a, "Provisioning data already exists.");
            }
            if (this.f4065d != null) {
                this.f4065d.mo4171a(-100);
            }
            return null;
        }
        if (C1139g.f4143b) {
            C1139g.m4311b(f4062a, "Connect to provisioning server(gld.push.samsungosp.com:5223).");
        }
        try {
            this.f4064c.mo4137a("gld.push.samsungosp.com", 5223, true);
            C0064ah c0064ahNewBuilder = C0063ag.newBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) m4148a().getSystemService("phone");
            String strM4241a = C1126j.m4241a((String) null);
            String strSubstring3 = "";
            String strSubstring4 = "";
            String str = "";
            String str2 = "";
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() != 0) {
                strSubstring3 = networkOperator.substring(0, 3);
                strSubstring4 = networkOperator.substring(3);
            } else if (C1139g.f4144c) {
                C1139g.m4312c(f4062a, "Use empty network mcc and mnc because couldn't retrieve network information.");
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
            } else if (C1139g.f4144c) {
                C1139g.m4312c(f4062a, "Use empty mcc and mnc because couldn't retrieve sim information.");
                C1139g.m4312c(f4062a, "SIM State: " + telephonyManager.getSimState());
            }
            String str3 = Build.MODEL;
            c0064ahNewBuilder.m191a("1");
            c0064ahNewBuilder.m195c("00000000");
            c0064ahNewBuilder.m193b(strM4241a);
            c0064ahNewBuilder.m199e("device.model=" + str3 + "&sim.mcc=" + str + "&sim.mnc=" + str2 + "&net.mcc=" + strSubstring3 + "&net.mnc=" + strSubstring4);
            if (C1139g.f4142a) {
                C1139g.m4308a(f4062a, "Device id: " + strM4241a);
                C1139g.m4308a(f4062a, "Network.MCC: " + strSubstring3);
                C1139g.m4308a(f4062a, "Network.MNC: " + strSubstring4);
                C1139g.m4308a(f4062a, "SIM.MCC: " + str);
                C1139g.m4308a(f4062a, "SIM.MNC: " + str2);
                C1139g.m4308a(f4062a, "Device model: " + str3);
            }
            String strM4248b = C1126j.m4248b((String) null);
            if (strM4248b != null && strM4248b.length() != 0) {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4062a, String.format("This device has a device token(%s). Using it to provisioning.", strM4248b));
                }
                c0064ahNewBuilder.m197d(strM4248b);
            }
            return new C1114h().m4194a(this.f4064c).m4193a(c0064ahNewBuilder.build());
        } catch (C1081k e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4062a, "Can't connect to provisioning server hence network isn't avaliable.", e);
            }
            m4163a(-103);
            if (this.f4065d != null) {
                this.f4065d.mo4171a(-2);
            }
            return null;
        } catch (C1071a e2) {
            if (C1139g.f4145d) {
                C1139g.m4309a(f4062a, "Can't connect to provisioning server.", e2);
            }
            m4163a(-103);
            C1072b.m4118a().m4123b();
            if (this.f4065d != null) {
                this.f4065d.mo4171a(-2);
            }
            return null;
        }
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1110d
    /* renamed from: a */
    public void mo4151a(int i, GeneratedMessageLite generatedMessageLite) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4062a, String.format("ProvMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        try {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4062a, "Disconnect provisioning connection.");
            }
            this.f4064c.mo4140b();
        } catch (C1071a e) {
        }
        if (i == 0) {
            C0060ad c0060ad = (C0060ad) generatedMessageLite;
            int iM118d = c0060ad.m118d();
            if (iM118d == 1000) {
                String strM120f = c0060ad.m120f();
                String strM122h = c0060ad.m122h();
                int iM124j = c0060ad.m124j();
                String strM126l = c0060ad.m126l();
                int iM128n = c0060ad.m128n();
                int iM130p = c0060ad.m130p();
                if (iM130p == 0) {
                    if (C1139g.f4144c) {
                        C1139g.m4312c(f4062a, "Server sent PingInterval to 0, rearrange this value to 8.");
                    }
                    iM130p = 8;
                }
                C1072b.m4118a().m4125d();
                C1126j.m4246a(strM120f, strM122h, iM124j, strM126l, iM128n, iM130p);
                try {
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4062a, "Execute initialize.");
                    }
                    C1115i.m4196a().m4203a(new C1101b(m4148a()));
                } catch (InterruptedException e2) {
                    if (C1139g.f4145d) {
                        C1139g.m4309a(f4062a, e2.getMessage(), e2);
                    }
                }
                if (this.f4065d != null) {
                    this.f4065d.mo4170a();
                    return;
                }
                return;
            }
            if (C1139g.f4145d) {
                C1139g.m4313d(f4062a, String.format("Prov reply result code is error. ErrorCode: %d.", Integer.valueOf(iM118d)));
            }
            if (iM118d == 3001 || iM118d == 3000) {
                m4163a(-103);
                if (this.f4065d != null) {
                    this.f4065d.mo4171a(-103);
                }
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4062a, "Restart device.");
                    return;
                }
                return;
            }
            if (iM118d == 3002) {
                m4163a(-103);
                if (C1139g.f4145d) {
                    C1139g.m4313d(f4062a, "Execute reprovisioning.");
                }
                C1126j.m4249b();
                C1072b.m4118a().m4123b();
                if (this.f4065d != null) {
                    this.f4065d.mo4171a(-103);
                    return;
                }
                return;
            }
            m4163a(-103);
            if (this.f4065d != null) {
                this.f4065d.mo4171a(-103);
                return;
            }
            return;
        }
        m4163a(-103);
        if (i == -1) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4062a, "Internal error code is timeout.");
            }
            try {
                if (C1139g.f4142a) {
                    C1139g.m4308a(f4062a, "Disconnect connection.");
                }
                this.f4064c.mo4140b();
            } catch (C1071a e3) {
            }
            C1072b.m4118a().m4123b();
        }
        if (this.f4065d != null) {
            this.f4065d.mo4171a(-103);
        }
    }

    /* renamed from: a */
    private void m4163a(int i) {
        C1072b.m4118a().m4121a(i);
    }
}
