package com.sec.chaton.push.p094c.p095a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.protobuf.GeneratedMessageLite;
import com.p137vk.sdk.api.VKError;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p090a.C3054k;
import com.sec.chaton.push.p091b.p092a.C3059c;
import com.sec.chaton.push.p094c.AbstractC3072a;
import com.sec.chaton.push.p094c.C3087h;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.p094c.InterfaceC3083d;
import com.sec.chaton.push.util.C3115g;
import com.sec.p043a.p044a.p045a.C0737ad;
import com.sec.p043a.p044a.p045a.C0740ag;
import com.sec.p043a.p044a.p045a.C0741ah;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: ProvMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a.f */
/* loaded from: classes.dex */
public class C3078f extends AbstractC3072a implements InterfaceC3083d {

    /* renamed from: a */
    private static final String f11374a = C3078f.class.getSimpleName();

    /* renamed from: b */
    private static EnumC3079g f11375b = EnumC3079g.Primary;

    /* renamed from: c */
    private String f11376c;

    /* renamed from: d */
    private C3059c f11377d;

    /* renamed from: e */
    private InterfaceC3081b f11378e;

    public C3078f(Context context) {
        super(context, 0L);
        this.f11377d = PushClientApplication.m12499n().m12503q();
        this.f11378e = null;
    }

    /* renamed from: a */
    public static boolean m12552a(Context context) {
        return (C3099k.m12635b((String) null) == null || C3099k.m12640c((String) null) == null || C3099k.m12626a(0) == 0 || C3099k.m12644d(-1) == -1 || C3099k.m12647e(-1) == -1 || C3099k.m12650f(-1) == -1 || C3099k.m12653g(-1) == -1) ? false : true;
    }

    /* renamed from: b */
    public static String m12553b(Context context) {
        if (f11375b == EnumC3079g.Primary) {
            return C3099k.m12640c((String) null);
        }
        if (f11375b == EnumC3079g.Secondary) {
            return C3099k.m12645d((String) null);
        }
        throw new IllegalStateException("Shouldn't reach this code.");
    }

    /* renamed from: c */
    public static int m12554c(Context context) {
        if (f11375b == EnumC3079g.Primary) {
            return C3099k.m12626a(-1);
        }
        if (f11375b == EnumC3079g.Secondary) {
            return C3099k.m12634b(-1);
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: d */
    public static void m12555d() {
        if (f11375b == EnumC3079g.Primary) {
            f11375b = EnumC3079g.Secondary;
            if (C3115g.f11459b) {
                C3115g.m12704b(f11374a, String.format("Change server to %s.", f11375b));
                return;
            }
            return;
        }
        if (f11375b == EnumC3079g.Secondary) {
            f11375b = EnumC3079g.Primary;
            if (C3115g.f11459b) {
                C3115g.m12704b(f11374a, String.format("Change server to %s.", f11375b));
                return;
            }
            return;
        }
        throw new IllegalStateException("Sholudn't reach this code.");
    }

    /* renamed from: e */
    public static EnumC3079g m12556e() {
        return f11375b;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: n_ */
    public Class<? extends GeneratedMessageLite> mo12540n_() {
        return C0737ad.class;
    }

    @Override // com.sec.chaton.push.p094c.AbstractC3072a
    /* renamed from: c */
    public C3087h mo12537c() {
        String strSubstring;
        String strSubstring2;
        if (C3115g.f11458a) {
            C3115g.m12701a(f11374a, "ProvMessageTask.onRequest().");
        }
        C3045b.m12505a().m12511c();
        if (m12552a(m12535a())) {
            if (C3115g.f11460c) {
                C3115g.m12705c(f11374a, "Provisioning data already exists.");
            }
            if (this.f11378e != null) {
                this.f11378e.mo12559a(-100);
            }
            return null;
        }
        if (C3115g.f11459b) {
            C3115g.m12704b(f11374a, "Connect to provisioning server(gld.push.samsungosp.com:5223).");
        }
        try {
            this.f11377d.mo12523a("gld.push.samsungosp.com", 5223, true);
            C0741ah c0741ahNewBuilder = C0740ag.newBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) m12535a().getSystemService("phone");
            String strM12628a = C3099k.m12628a((String) null);
            String strSubstring3 = "";
            String strSubstring4 = "";
            String str = "";
            String str2 = "";
            this.f11376c = telephonyManager.getNetworkOperator();
            if (this.f11376c != null && this.f11376c.length() != 0) {
                strSubstring3 = this.f11376c.substring(0, 3);
                strSubstring4 = this.f11376c.substring(3);
            } else if (C3115g.f11460c) {
                C3115g.m12705c(f11374a, "Use empty network mcc and mnc because couldn't retrieve network information.");
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
            } else if (C3115g.f11460c) {
                C3115g.m12705c(f11374a, "Use empty mcc and mnc because couldn't retrieve sim information.");
                C3115g.m12705c(f11374a, "SIM State: " + telephonyManager.getSimState());
            }
            String str3 = Build.MODEL;
            c0741ahNewBuilder.m2435a(Spam.ACTIVITY_REPORT);
            c0741ahNewBuilder.m2439c("00000000");
            c0741ahNewBuilder.m2437b(strM12628a);
            c0741ahNewBuilder.m2443e("device.model=" + str3 + "&sim.mcc=" + str + "&sim.mnc=" + str2 + "&net.mcc=" + strSubstring3 + "&net.mnc=" + strSubstring4);
            if (C3115g.f11458a) {
                C3115g.m12701a(f11374a, "Device id: " + strM12628a);
                C3115g.m12701a(f11374a, "Network.MCC: " + strSubstring3);
                C3115g.m12701a(f11374a, "Network.MNC: " + strSubstring4);
                C3115g.m12701a(f11374a, "SIM.MCC: " + str);
                C3115g.m12701a(f11374a, "SIM.MNC: " + str2);
                C3115g.m12701a(f11374a, "Device model: " + str3);
            }
            String strM12635b = C3099k.m12635b((String) null);
            if (strM12635b != null && strM12635b.length() != 0) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11374a, String.format("This device has a device token(%s). Using it to provisioning.", strM12635b));
                }
                c0741ahNewBuilder.m2441d(strM12635b);
            }
            return new C3087h().m12582a(this.f11377d).m12581a(c0741ahNewBuilder.build());
        } catch (C3054k e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11374a, "Can't connect to provisioning server hence network isn't avaliable.", e);
            }
            m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
            if (this.f11378e != null) {
                this.f11378e.mo12559a(-2);
            }
            return null;
        } catch (C3044a e2) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11374a, "Can't connect to provisioning server.", e2);
            }
            m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
            C3045b.m12505a().m12510b();
            if (this.f11378e != null) {
                this.f11378e.mo12559a(-2);
            }
            return null;
        } catch (NullPointerException e3) {
            if (C3115g.f11461d) {
                C3115g.m12702a(f11374a, "mConnectionManager isn't set up.", e3);
            }
            m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
            if (this.f11378e != null) {
                this.f11378e.mo12559a(-2);
            }
            return null;
        }
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3083d
    /* renamed from: a */
    public void mo12538a(int i, GeneratedMessageLite generatedMessageLite) throws NumberFormatException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (C3115g.f11458a) {
            C3115g.m12701a(f11374a, String.format("ProvMessageTask.onResponse(). ErrorCode: %d.", Integer.valueOf(i)));
        }
        try {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11374a, "Disconnect provisioning connection.");
            }
            this.f11377d.mo12527b();
        } catch (C3044a e) {
        }
        if (i == 0) {
            if (generatedMessageLite == null) {
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11374a, "Response message is null.");
                    return;
                }
                return;
            }
            C0737ad c0737ad = (C0737ad) generatedMessageLite;
            int iM2362d = c0737ad.m2362d();
            if (iM2362d == 1000) {
                String strM2364f = c0737ad.m2364f();
                String strM2366h = c0737ad.m2366h();
                int iM2368j = c0737ad.m2368j();
                String strM2370l = c0737ad.m2370l();
                int iM2372n = c0737ad.m2372n();
                String strM2376r = c0737ad.m2376r();
                int i10 = -1;
                int i11 = -1;
                int i12 = -1;
                int i13 = -1;
                if (strM2376r == null || strM2376r.trim().equals("")) {
                    int i14 = i13;
                    i2 = i10;
                    i3 = i14;
                    int i15 = i11;
                    i4 = i12;
                    i5 = i15;
                } else {
                    try {
                        for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI("http://dummy.dummy?" + strM2376r), "UTF-8")) {
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
                        if (C3115g.f11461d) {
                            C3115g.m12702a(f11374a, e2.getMessage(), e2);
                        }
                    } catch (URISyntaxException e3) {
                        if (C3115g.f11461d) {
                            C3115g.m12702a(f11374a, e3.getMessage(), e3);
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
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11374a, "[Provisioning push information]");
                    C3115g.m12701a(f11374a, "\tMin Interval: " + i2);
                    C3115g.m12701a(f11374a, "\tAvg Interval: " + i5);
                    C3115g.m12701a(f11374a, "\tMax Interval: " + i4);
                    C3115g.m12701a(f11374a, "\tInc Interval: " + i3);
                }
                C3045b.m12505a().m12512d();
                C3099k.m12633a(this.f11376c, strM2364f, strM2366h, iM2368j, strM2370l, iM2372n, i2, i5, i4, i3);
                try {
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11374a, "Execute initialize.");
                    }
                    C3088i.m12584a().m12591a(new C3074b(m12535a()));
                } catch (InterruptedException e4) {
                    if (C3115g.f11461d) {
                        C3115g.m12702a(f11374a, e4.getMessage(), e4);
                    }
                }
                if (this.f11378e != null) {
                    this.f11378e.mo12558a();
                    return;
                }
                return;
            }
            if (C3115g.f11461d) {
                C3115g.m12706d(f11374a, String.format("Prov reply result code is error. ErrorCode: %d.", Integer.valueOf(iM2362d)));
            }
            if (iM2362d == 3001 || iM2362d == 3000) {
                m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
                if (this.f11378e != null) {
                    this.f11378e.mo12559a(VKError.VK_API_REQUEST_NOT_PREPARED);
                }
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11374a, "Restart device.");
                    return;
                }
                return;
            }
            if (iM2362d == 3002) {
                m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
                if (C3115g.f11461d) {
                    C3115g.m12706d(f11374a, "Execute reprovisioning.");
                }
                C3099k.m12636b();
                C3045b.m12505a().m12510b();
                if (this.f11378e != null) {
                    this.f11378e.mo12559a(VKError.VK_API_REQUEST_NOT_PREPARED);
                    return;
                }
                return;
            }
            m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
            if (this.f11378e != null) {
                this.f11378e.mo12559a(VKError.VK_API_REQUEST_NOT_PREPARED);
                return;
            }
            return;
        }
        m12551a(VKError.VK_API_REQUEST_NOT_PREPARED);
        if (i == -1) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11374a, "Internal error code is timeout.");
            }
            try {
                if (C3115g.f11458a) {
                    C3115g.m12701a(f11374a, "Disconnect connection.");
                }
                this.f11377d.mo12527b();
            } catch (C3044a e5) {
            }
            C3045b.m12505a().m12510b();
        }
        if (this.f11378e != null) {
            this.f11378e.mo12559a(VKError.VK_API_REQUEST_NOT_PREPARED);
        }
    }

    /* renamed from: a */
    private void m12551a(int i) {
        C3045b.m12505a().m12508a(i);
    }
}
