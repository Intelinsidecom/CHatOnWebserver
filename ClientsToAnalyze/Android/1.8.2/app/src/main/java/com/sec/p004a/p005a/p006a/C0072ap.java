package com.sec.p004a.p005a.p006a;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontendCommon.java */
/* renamed from: com.sec.a.a.a.ap */
/* loaded from: classes.dex */
public class C0072ap {
    /* renamed from: a */
    public static byte m282a(Object obj) {
        if (obj instanceof C0083l) {
            return (byte) 0;
        }
        if (obj instanceof C0080i) {
            return (byte) 1;
        }
        if (obj instanceof C0069am) {
            return (byte) 2;
        }
        if (obj instanceof C0066aj) {
            return (byte) 3;
        }
        if (obj instanceof C0077f) {
            return (byte) 4;
        }
        if (obj instanceof C0074c) {
            return (byte) 5;
        }
        if (obj instanceof C0057aa) {
            return (byte) 6;
        }
        if (obj instanceof C0095x) {
            return (byte) 7;
        }
        if (obj instanceof C0089r) {
            return (byte) 8;
        }
        if (obj instanceof C0092u) {
            return (byte) 9;
        }
        if (obj instanceof C0086o) {
            return (byte) 10;
        }
        if (obj instanceof C0063ag) {
            return AMSLibs.ENUM_VIP_AMS_TEXT_OBJECT_NUM_FULL;
        }
        if (obj instanceof C0060ad) {
            return AMSLibs.ENUM_VIP_AMS_STAMP_OBJECT_NUM_FULL;
        }
        return (byte) -1;
    }

    /* renamed from: a */
    public static Object m283a(byte b, byte[] bArr) {
        Object objM101a = null;
        try {
            switch (b) {
                case 0:
                    objM101a = C0083l.m398a(bArr);
                    break;
                case 1:
                    objM101a = C0080i.m365a(bArr);
                    break;
                case 2:
                    objM101a = C0069am.m245a(bArr);
                    break;
                case 3:
                    objM101a = C0066aj.m202a(bArr);
                    break;
                case 4:
                    objM101a = C0077f.m326a(bArr);
                    break;
                case 5:
                    objM101a = C0074c.m288a(bArr);
                    break;
                case 6:
                    objM101a = C0057aa.m70a(bArr);
                    break;
                case 7:
                    objM101a = C0095x.m549a(bArr);
                    break;
                case 8:
                    objM101a = C0089r.m463a(bArr);
                    break;
                case 9:
                    objM101a = C0092u.m522a(bArr);
                    break;
                case 10:
                    objM101a = C0086o.m428a(bArr);
                    break;
                case 11:
                    objM101a = C0063ag.m157a(bArr);
                    break;
                case C0229at.HorizontalSrollView_android_background /* 12 */:
                    objM101a = C0060ad.m101a(bArr);
                    break;
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return objM101a;
    }

    /* renamed from: a */
    public static String m284a(byte b) {
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
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                return "ProvisionReply";
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static String m285b(Object obj) {
        return m284a(m282a(obj));
    }
}
