package com.sec.p043a.p044a.p045a;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.amsoma.AMSLibs;

/* compiled from: MsgFrontendCommon.java */
/* renamed from: com.sec.a.a.a.ap */
/* loaded from: classes.dex */
public class C0749ap {
    /* renamed from: a */
    public static byte m2526a(Object obj) {
        if (obj instanceof C0760l) {
            return (byte) 0;
        }
        if (obj instanceof C0757i) {
            return (byte) 1;
        }
        if (obj instanceof C0746am) {
            return (byte) 2;
        }
        if (obj instanceof C0743aj) {
            return (byte) 3;
        }
        if (obj instanceof C0754f) {
            return (byte) 4;
        }
        if (obj instanceof C0751c) {
            return (byte) 5;
        }
        if (obj instanceof C0734aa) {
            return (byte) 6;
        }
        if (obj instanceof C0772x) {
            return (byte) 7;
        }
        if (obj instanceof C0766r) {
            return (byte) 8;
        }
        if (obj instanceof C0769u) {
            return (byte) 9;
        }
        if (obj instanceof C0763o) {
            return (byte) 10;
        }
        if (obj instanceof C0740ag) {
            return AMSLibs.ENUM_VIP_AMS_TEXT_OBJECT_NUM_FULL;
        }
        if (obj instanceof C0737ad) {
            return AMSLibs.ENUM_VIP_AMS_STAMP_OBJECT_NUM_FULL;
        }
        return (byte) -1;
    }

    /* renamed from: a */
    public static Object m2527a(byte b2, byte[] bArr) {
        Object objM2345a = null;
        try {
            switch (b2) {
                case 0:
                    objM2345a = C0760l.m2642a(bArr);
                    break;
                case 1:
                    objM2345a = C0757i.m2609a(bArr);
                    break;
                case 2:
                    objM2345a = C0746am.m2489a(bArr);
                    break;
                case 3:
                    objM2345a = C0743aj.m2446a(bArr);
                    break;
                case 4:
                    objM2345a = C0754f.m2570a(bArr);
                    break;
                case 5:
                    objM2345a = C0751c.m2532a(bArr);
                    break;
                case 6:
                    objM2345a = C0734aa.m2314a(bArr);
                    break;
                case 7:
                    objM2345a = C0772x.m2793a(bArr);
                    break;
                case 8:
                    objM2345a = C0766r.m2707a(bArr);
                    break;
                case 9:
                    objM2345a = C0769u.m2766a(bArr);
                    break;
                case 10:
                    objM2345a = C0763o.m2672a(bArr);
                    break;
                case 11:
                    objM2345a = C0740ag.m2401a(bArr);
                    break;
                case 12:
                    objM2345a = C0737ad.m2345a(bArr);
                    break;
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return objM2345a;
    }

    /* renamed from: a */
    public static String m2528a(byte b2) {
        switch (b2) {
            case 0:
                return "InitRequest";
            case 1:
                return "InitReply";
            case 2:
                return "RegistrationRequest";
            case 3:
                return "RegistrationReply";
            case 4:
                return "DeregistrationRequest";
            case 5:
                return "DeregistrationReply";
            case 6:
                return "PingRequest";
            case 7:
                return "PingReply";
            case 8:
                return "NotiElement";
            case 9:
                return "NotiGroup";
            case 10:
                return "NotiAcks";
            case 11:
                return "ProvisionRequest";
            case 12:
                return "ProvisionReply";
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static String m2529b(Object obj) {
        return m2528a(m2526a(obj));
    }
}
