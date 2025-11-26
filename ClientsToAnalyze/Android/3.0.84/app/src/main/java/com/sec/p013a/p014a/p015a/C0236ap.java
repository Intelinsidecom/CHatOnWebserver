package com.sec.p013a.p014a.p015a;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.amsoma.AMSLibs;

/* compiled from: MsgFrontendCommon.java */
/* renamed from: com.sec.a.a.a.ap */
/* loaded from: classes.dex */
public class C0236ap {
    /* renamed from: a */
    public static byte m794a(Object obj) {
        if (obj instanceof C0247l) {
            return (byte) 0;
        }
        if (obj instanceof C0244i) {
            return (byte) 1;
        }
        if (obj instanceof C0233am) {
            return (byte) 2;
        }
        if (obj instanceof C0230aj) {
            return (byte) 3;
        }
        if (obj instanceof C0241f) {
            return (byte) 4;
        }
        if (obj instanceof C0238c) {
            return (byte) 5;
        }
        if (obj instanceof C0221aa) {
            return (byte) 6;
        }
        if (obj instanceof C0259x) {
            return (byte) 7;
        }
        if (obj instanceof C0253r) {
            return (byte) 8;
        }
        if (obj instanceof C0256u) {
            return (byte) 9;
        }
        if (obj instanceof C0250o) {
            return (byte) 10;
        }
        if (obj instanceof C0227ag) {
            return AMSLibs.ENUM_VIP_AMS_TEXT_OBJECT_NUM_FULL;
        }
        if (obj instanceof C0224ad) {
            return AMSLibs.ENUM_VIP_AMS_STAMP_OBJECT_NUM_FULL;
        }
        return (byte) -1;
    }

    /* renamed from: a */
    public static Object m795a(byte b, byte[] bArr) {
        Object objM613a = null;
        try {
            switch (b) {
                case 0:
                    objM613a = C0247l.m910a(bArr);
                    break;
                case 1:
                    objM613a = C0244i.m877a(bArr);
                    break;
                case 2:
                    objM613a = C0233am.m757a(bArr);
                    break;
                case 3:
                    objM613a = C0230aj.m714a(bArr);
                    break;
                case 4:
                    objM613a = C0241f.m838a(bArr);
                    break;
                case 5:
                    objM613a = C0238c.m800a(bArr);
                    break;
                case 6:
                    objM613a = C0221aa.m582a(bArr);
                    break;
                case 7:
                    objM613a = C0259x.m1061a(bArr);
                    break;
                case 8:
                    objM613a = C0253r.m975a(bArr);
                    break;
                case 9:
                    objM613a = C0256u.m1034a(bArr);
                    break;
                case 10:
                    objM613a = C0250o.m940a(bArr);
                    break;
                case 11:
                    objM613a = C0227ag.m669a(bArr);
                    break;
                case 12:
                    objM613a = C0224ad.m613a(bArr);
                    break;
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return objM613a;
    }

    /* renamed from: a */
    public static String m796a(byte b) {
        switch (b) {
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
    public static String m797b(Object obj) {
        return m796a(m794a(obj));
    }
}
