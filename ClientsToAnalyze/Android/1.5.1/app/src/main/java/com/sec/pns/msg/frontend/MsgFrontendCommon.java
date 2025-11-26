package com.sec.pns.msg.frontend;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.amsoma.AMSLibs;
import com.sec.pns.msg.frontend.MsgFrontend;

/* loaded from: classes.dex */
public class MsgFrontendCommon {
    public static final int HDR_SIZE = 4;
    public static final int __DeregistrationReply__ = 5;
    public static final int __DeregistrationRequest__ = 4;
    public static final int __InitReply__ = 1;
    public static final int __InitRequest__ = 0;
    public static final int __NotiAcks__ = 10;
    public static final int __NotiElement__ = 8;
    public static final int __NotiGroup__ = 9;
    public static final int __PingReply__ = 7;
    public static final int __PingRequest__ = 6;
    public static final int __ProvisionReply__ = 12;
    public static final int __ProvisionRequest__ = 11;
    public static final int __RegistrationReply__ = 3;
    public static final int __RegistrationRequest__ = 2;

    public static boolean checkMessageType(byte b) {
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case __NotiAcks__ /* 10 */:
            case 11:
            case 12:
                return true;
            default:
                return false;
        }
    }

    public static MsgFrontend.NotiGroup generateNotiGroupMsgForSystemError(int i, String str) {
        MsgFrontend.NotiGroup.Builder builderNewBuilder = MsgFrontend.NotiGroup.newBuilder();
        MsgFrontend.NotiElement.Builder builderNewBuilder2 = MsgFrontend.NotiElement.newBuilder();
        builderNewBuilder2.setType(2);
        builderNewBuilder2.setMessage("" + i + "#" + str);
        builderNewBuilder.addNotiElements(builderNewBuilder2);
        return builderNewBuilder.build();
    }

    public static String getMessageName(byte b) {
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
            case __NotiAcks__ /* 10 */:
                return "NotiAcks";
            case 11:
                return "ProvisionRequest";
            case 12:
                return "ProvisionReply";
            default:
                return null;
        }
    }

    public static String getMessageName(Object obj) {
        return getMessageName(getMessageType(obj));
    }

    public static byte getMessageType(Object obj) {
        if (obj instanceof MsgFrontend.InitRequest) {
            return (byte) 0;
        }
        if (obj instanceof MsgFrontend.InitReply) {
            return (byte) 1;
        }
        if (obj instanceof MsgFrontend.RegistrationRequest) {
            return (byte) 2;
        }
        if (obj instanceof MsgFrontend.RegistrationReply) {
            return (byte) 3;
        }
        if (obj instanceof MsgFrontend.DeregistrationRequest) {
            return (byte) 4;
        }
        if (obj instanceof MsgFrontend.DeregistrationReply) {
            return (byte) 5;
        }
        if (obj instanceof MsgFrontend.PingRequest) {
            return (byte) 6;
        }
        if (obj instanceof MsgFrontend.PingReply) {
            return (byte) 7;
        }
        if (obj instanceof MsgFrontend.NotiElement) {
            return (byte) 8;
        }
        if (obj instanceof MsgFrontend.NotiGroup) {
            return (byte) 9;
        }
        if (obj instanceof MsgFrontend.NotiAcks) {
            return (byte) 10;
        }
        if (obj instanceof MsgFrontend.ProvisionRequest) {
            return AMSLibs.ENUM_VIP_AMS_TEXT_OBJECT_NUM_FULL;
        }
        if (obj instanceof MsgFrontend.ProvisionReply) {
            return AMSLibs.ENUM_VIP_AMS_STAMP_OBJECT_NUM_FULL;
        }
        return (byte) -1;
    }

    public static Object newMessageClass(byte b, byte[] bArr) {
        Object from;
        try {
            switch (b) {
                case 0:
                    from = MsgFrontend.InitRequest.parseFrom(bArr);
                    break;
                case 1:
                    from = MsgFrontend.InitReply.parseFrom(bArr);
                    break;
                case 2:
                    from = MsgFrontend.RegistrationRequest.parseFrom(bArr);
                    break;
                case 3:
                    from = MsgFrontend.RegistrationReply.parseFrom(bArr);
                    break;
                case 4:
                    from = MsgFrontend.DeregistrationRequest.parseFrom(bArr);
                    break;
                case 5:
                    from = MsgFrontend.DeregistrationReply.parseFrom(bArr);
                    break;
                case 6:
                    from = MsgFrontend.PingRequest.parseFrom(bArr);
                    break;
                case 7:
                    from = MsgFrontend.PingReply.parseFrom(bArr);
                    break;
                case 8:
                    from = MsgFrontend.NotiElement.parseFrom(bArr);
                    break;
                case 9:
                    from = MsgFrontend.NotiGroup.parseFrom(bArr);
                    break;
                case __NotiAcks__ /* 10 */:
                    from = MsgFrontend.NotiAcks.parseFrom(bArr);
                    break;
                case 11:
                    from = MsgFrontend.ProvisionRequest.parseFrom(bArr);
                    break;
                case 12:
                    from = MsgFrontend.ProvisionReply.parseFrom(bArr);
                    break;
                default:
                    return null;
            }
            return from;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }
}
