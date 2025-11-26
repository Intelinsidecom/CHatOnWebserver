package com.sec.chaton.push.p054c.p055a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p050a.C2054k;
import com.sec.chaton.push.p051b.p052a.C2059c;
import com.sec.chaton.push.p054c.AbstractC2072a;
import com.sec.chaton.push.p054c.C2087h;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.p054c.InterfaceC2083d;
import com.sec.chaton.push.util.C2115g;
import com.sec.p013a.p014a.p015a.C0224ad;
import com.sec.p013a.p014a.p015a.C0227ag;
import com.sec.p013a.p014a.p015a.C0228ah;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: ProvMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.f */
/* loaded from: classes.dex */
public class C2078f extends AbstractC2072a implements InterfaceC2083d {

    /* renamed from: a */
    private static final String f7964a = C2078f.class.getSimpleName();

    /* renamed from: b */
    private static EnumC2079g f7965b = EnumC2079g.Primary;

    /* renamed from: c */
    private String f7966c;

    /* renamed from: d */
    private C2059c f7967d;

    /* renamed from: e */
    private InterfaceC2081b f7968e;

    public C2078f(Context context) {
        super(context, 0L);
        this.f7967d = PushClientApplication.m8156h().m8160k();
        this.f7968e = null;
    }

    /* renamed from: a */
    public static boolean m8209a(Context context) {
        return (C2099k.m8292b((String) null) == null || C2099k.m8297c((String) null) == null || C2099k.m8283a(0) == 0 || C2099k.m8301d(-1) == -1 || C2099k.m8305e(-1) == -1 || C2099k.m8308f(-1) == -1 || C2099k.m8311g(-1) == -1) ? false : true;
    }

    /* renamed from: b */
    public static String m8210b(Context context) {
        if (f7965b == EnumC2079g.Primary) {
            return C2099k.m8297c((String) null);
        }
        if (f7965b == EnumC2079g.Secondary) {
            return C2099k.m8302d((String) null);
        }
        throw new IllegalStateException("Shouldn't reach this code.");
    }

    /* renamed from: c */
    public static int m8211c(Context context) {
        if (f7965b == EnumC2079g.Primary) {
            return C2099k.m8283a(-1);
        }
        if (f7965b == EnumC2079g.Secondary) {
            return C2099k.m8291b(-1);
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: d */
    public static void m8212d() {
        if (f7965b == EnumC2079g.Primary) {
            f7965b = EnumC2079g.Secondary;
            if (C2115g.f8049b) {
                C2115g.m8362b(f7964a, String.format("Change server to %s.", f7965b));
                return;
            }
            return;
        }
        if (f7965b == EnumC2079g.Secondary) {
            f7965b = EnumC2079g.Primary;
            if (C2115g.f8049b) {
                C2115g.m8362b(f7964a, String.format("Change server to %s.", f7965b));
                return;
            }
            return;
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: e */
    public static EnumC2079g m8213e() {
        return f7965b;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: f_ */
    public Class<? extends GeneratedMessageLite> mo8197f_() {
        return C0224ad.class;
    }

    @Override // com.sec.chaton.push.p054c.AbstractC2072a
    /* renamed from: c */
    public C2087h mo8194c() {
        String strSubstring;
        String strSubstring2;
        if (C2115g.f8048a) {
            C2115g.m8359a(f7964a, "ProvMessageTask.onRequest().");
        }
        C2045b.m8162a().m8168c();
        if (m8209a(m8192a())) {
            if (C2115g.f8050c) {
                C2115g.m8363c(f7964a, "Provisioning data already exists.");
            }
            if (this.f7968e != null) {
                this.f7968e.mo8216a(-100);
            }
            return null;
        }
        if (C2115g.f8049b) {
            C2115g.m8362b(f7964a, "Connect to provisioning server(gld.push.samsungosp.com:5223).");
        }
        try {
            this.f7967d.mo8180a("gld.push.samsungosp.com", 5223, true);
            C0228ah c0228ahNewBuilder = C0227ag.newBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) m8192a().getSystemService("phone");
            String strM8285a = C2099k.m8285a((String) null);
            String strSubstring3 = "";
            String strSubstring4 = "";
            String str = "";
            String str2 = "";
            this.f7966c = telephonyManager.getNetworkOperator();
            if (this.f7966c != null && this.f7966c.length() != 0) {
                strSubstring3 = this.f7966c.substring(0, 3);
                strSubstring4 = this.f7966c.substring(3);
            } else if (C2115g.f8050c) {
                C2115g.m8363c(f7964a, "Use empty network mcc and mnc because couldn't retrieve network information.");
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
            } else if (C2115g.f8050c) {
                C2115g.m8363c(f7964a, "Use empty mcc and mnc because couldn't retrieve sim information.");
                C2115g.m8363c(f7964a, "SIM State: " + telephonyManager.getSimState());
            }
            String str3 = Build.MODEL;
            c0228ahNewBuilder.m703a("1");
            c0228ahNewBuilder.m707c("00000000");
            c0228ahNewBuilder.m705b(strM8285a);
            c0228ahNewBuilder.m711e("device.model=" + str3 + "&sim.mcc=" + str + "&sim.mnc=" + str2 + "&net.mcc=" + strSubstring3 + "&net.mnc=" + strSubstring4);
            if (C2115g.f8048a) {
                C2115g.m8359a(f7964a, "Device id: " + strM8285a);
                C2115g.m8359a(f7964a, "Network.MCC: " + strSubstring3);
                C2115g.m8359a(f7964a, "Network.MNC: " + strSubstring4);
                C2115g.m8359a(f7964a, "SIM.MCC: " + str);
                C2115g.m8359a(f7964a, "SIM.MNC: " + str2);
                C2115g.m8359a(f7964a, "Device model: " + str3);
            }
            String strM8292b = C2099k.m8292b((String) null);
            if (strM8292b != null && strM8292b.length() != 0) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7964a, String.format("This device has a device token(%s). Using it to provisioning.", strM8292b));
                }
                c0228ahNewBuilder.m709d(strM8292b);
            }
            return new C2087h().m8239a(this.f7967d).m8238a(c0228ahNewBuilder.build());
        } catch (C2054k e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7964a, "Can't connect to provisioning server hence network isn't avaliable.", e);
            }
            m8208a(-103);
            if (this.f7968e != null) {
                this.f7968e.mo8216a(-2);
            }
            return null;
        } catch (C2044a e2) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7964a, "Can't connect to provisioning server.", e2);
            }
            m8208a(-103);
            C2045b.m8162a().m8167b();
            if (this.f7968e != null) {
                this.f7968e.mo8216a(-2);
            }
            return null;
        } catch (NullPointerException e3) {
            if (C2115g.f8051d) {
                C2115g.m8360a(f7964a, "mConnectionManager isn't set up.", e3);
            }
            m8208a(-103);
            if (this.f7968e != null) {
                this.f7968e.mo8216a(-2);
            }
            return null;
        }
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2083d
    /* renamed from: a */
    public void mo8195a(int i, GeneratedMessageLite generatedMessageLite) throws NumberFormatException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (C2115g.f8048a) {
            C2115g.m8359a(f7964a, String.format("ProvMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        try {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7964a, "Disconnect provisioning connection.");
            }
            this.f7967d.mo8184b();
        } catch (C2044a e) {
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7964a, "Response message is null.");
                    return;
                }
                return;
            }
            C0224ad c0224ad = (C0224ad) generatedMessageLite;
            int iM630d = c0224ad.m630d();
            if (iM630d == 1000) {
                String strM632f = c0224ad.m632f();
                String strM634h = c0224ad.m634h();
                int iM636j = c0224ad.m636j();
                String strM638l = c0224ad.m638l();
                int iM640n = c0224ad.m640n();
                String strM644r = c0224ad.m644r();
                int i10 = -1;
                int i11 = -1;
                int i12 = -1;
                int i13 = -1;
                if (strM644r == null || strM644r.trim().equals("")) {
                    int i14 = i13;
                    i2 = i10;
                    i3 = i14;
                    int i15 = i11;
                    i4 = i12;
                    i5 = i15;
                } else {
                    try {
                        for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI("http://dummy.dummy?" + strM644r), "UTF-8")) {
                            if (nameValuePair.getName().equals("ping_min")) {
                                int i16 = i13;
                                i7 = i12;
                                i8 = i11;
                                i9 = Integer.parseInt(nameValuePair.getValue());
                                i6 = i16;
                            } else if (nameValuePair.getName().equals("ping_avg")) {
                                i9 = i10;
                                int i17 = i12;
                                i8 = Integer.parseInt(nameValuePair.getValue());
                                i6 = i13;
                                i7 = i17;
                            } else if (nameValuePair.getName().equals("ping_max")) {
                                i8 = i11;
                                i9 = i10;
                                int i18 = i13;
                                i7 = Integer.parseInt(nameValuePair.getValue());
                                i6 = i18;
                            } else if (nameValuePair.getName().equals("ping_inc")) {
                                i6 = Integer.parseInt(nameValuePair.getValue());
                                i7 = i12;
                                i8 = i11;
                                i9 = i10;
                            } else {
                                i6 = i13;
                                i7 = i12;
                                i8 = i11;
                                i9 = i10;
                            }
                            i10 = i9;
                            i11 = i8;
                            i12 = i7;
                            i13 = i6;
                        }
                        int i19 = i13;
                        i2 = i10;
                        i3 = i19;
                        int i20 = i11;
                        i4 = i12;
                        i5 = i20;
                    } catch (NumberFormatException e2) {
                        if (C2115g.f8051d) {
                            C2115g.m8360a(f7964a, e2.getMessage(), e2);
                        }
                    } catch (URISyntaxException e3) {
                        if (C2115g.f8051d) {
                            C2115g.m8360a(f7964a, e3.getMessage(), e3);
                        }
                        int i21 = i13;
                        i2 = i10;
                        i3 = i21;
                        int i22 = i11;
                        i4 = i12;
                        i5 = i22;
                    }
                }
                if (i2 == -1 || i5 == -1 || i4 == -1 || i3 == -1) {
                    i2 = 4;
                    i5 = 4;
                    i4 = 24;
                    i3 = 4;
                }
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7964a, "[Provisioning push information]");
                    C2115g.m8359a(f7964a, "\tMin Interval: " + i2);
                    C2115g.m8359a(f7964a, "\tAvg Interval: " + i5);
                    C2115g.m8359a(f7964a, "\tMax Interval: " + i4);
                    C2115g.m8359a(f7964a, "\tInc Interval: " + i3);
                }
                C2045b.m8162a().m8169d();
                C2099k.m8290a(this.f7966c, strM632f, strM634h, iM636j, strM638l, iM640n, i2, i5, i4, i3);
                try {
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f7964a, "Execute initialize.");
                    }
                    C2088i.m8241a().m8248a(new C2074b(m8192a()));
                } catch (InterruptedException e4) {
                    if (C2115g.f8051d) {
                        C2115g.m8360a(f7964a, e4.getMessage(), e4);
                    }
                }
                if (this.f7968e != null) {
                    this.f7968e.mo8215a();
                    return;
                }
                return;
            }
            if (C2115g.f8051d) {
                C2115g.m8364d(f7964a, String.format("Prov reply result code is error. ErrorCode: %d.", Integer.valueOf(iM630d)));
            }
            if (iM630d == 3001 || iM630d == 3000) {
                m8208a(-103);
                if (this.f7968e != null) {
                    this.f7968e.mo8216a(-103);
                }
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7964a, "Restart device.");
                    return;
                }
                return;
            }
            if (iM630d == 3002) {
                m8208a(-103);
                if (C2115g.f8051d) {
                    C2115g.m8364d(f7964a, "Execute reprovisioning.");
                }
                C2099k.m8293b();
                C2045b.m8162a().m8167b();
                if (this.f7968e != null) {
                    this.f7968e.mo8216a(-103);
                    return;
                }
                return;
            }
            m8208a(-103);
            if (this.f7968e != null) {
                this.f7968e.mo8216a(-103);
                return;
            }
            return;
        }
        m8208a(-103);
        if (i == -1) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7964a, "Internal error code is timeout.");
            }
            try {
                if (C2115g.f8048a) {
                    C2115g.m8359a(f7964a, "Disconnect connection.");
                }
                this.f7967d.mo8184b();
            } catch (C2044a e5) {
            }
            C2045b.m8162a().m8167b();
        }
        if (this.f7968e != null) {
            this.f7968e.mo8216a(-103);
        }
    }

    /* renamed from: a */
    private void m8208a(int i) {
        C2045b.m8162a().m8165a(i);
    }
}
