package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.amsoma.AMSLibs;

/* compiled from: MsgFrontendCommon.java */
/* renamed from: com.sec.a.a.a.ab */
/* loaded from: classes.dex */
public class C0068ab {
    /* renamed from: a */
    public static byte m104a(Object obj) {
        if (obj instanceof C0092k) {
            return (byte) 0;
        }
        if (obj instanceof C0084c) {
            return (byte) 1;
        }
        if (obj instanceof C0066a) {
            return (byte) 2;
        }
        if (obj instanceof C0089h) {
            return (byte) 3;
        }
        if (obj instanceof C0074ah) {
            return (byte) 4;
        }
        if (obj instanceof C0090i) {
            return (byte) 5;
        }
        if (obj instanceof C0104w) {
            return (byte) 6;
        }
        if (obj instanceof C0094m) {
            return (byte) 7;
        }
        if (obj instanceof C0103v) {
            return (byte) 8;
        }
        if (obj instanceof C0077ak) {
            return (byte) 9;
        }
        if (obj instanceof C0076aj) {
            return (byte) 10;
        }
        if (obj instanceof C0096o) {
            return AMSLibs.ENUM_VIP_AMS_TEXT_OBJECT_NUM_FULL;
        }
        if (obj instanceof C0069ac) {
            return AMSLibs.ENUM_VIP_AMS_STAMP_OBJECT_NUM_FULL;
        }
        return (byte) -1;
    }

    /* renamed from: a */
    public static Object m105a(byte b, byte[] bArr) {
        Object objM110a = null;
        try {
            switch (b) {
                case 0:
                    objM110a = C0092k.m397a(bArr);
                    break;
                case 1:
                    objM110a = C0084c.m331a(bArr);
                    break;
                case 2:
                    objM110a = C0066a.m69a(bArr);
                    break;
                case 3:
                    objM110a = C0089h.m348a(bArr);
                    break;
                case 4:
                    objM110a = C0074ah.m214a(bArr);
                    break;
                case 5:
                    objM110a = C0090i.m374a(bArr);
                    break;
                case 6:
                    objM110a = C0104w.m549a(bArr);
                    break;
                case 7:
                    objM110a = C0094m.m429a(bArr);
                    break;
                case 8:
                    objM110a = C0103v.m510a(bArr);
                    break;
                case 9:
                    objM110a = C0077ak.m266a(bArr);
                    break;
                case 10:
                    objM110a = C0076aj.m254a(bArr);
                    break;
                case 11:
                    objM110a = C0096o.m459a(bArr);
                    break;
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                    objM110a = C0069ac.m110a(bArr);
                    break;
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return objM110a;
    }

    /* renamed from: a */
    public static String m106a(byte b) {
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
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                return "ProvisionReply";
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static String m107b(Object obj) {
        return m106a(m104a(obj));
    }
}
