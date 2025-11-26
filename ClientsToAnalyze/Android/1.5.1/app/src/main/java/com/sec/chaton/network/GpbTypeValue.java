package com.sec.chaton.network;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.common.SSMGPB;
import com.sec.pns.msg.frontend.MsgFrontend;
import com.sec.pns.msg.frontend.MsgFrontendCommon;

/* loaded from: classes.dex */
public class GpbTypeValue {
    /* renamed from: a */
    public static long m2724a(int i, GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite == null) {
            return -1L;
        }
        switch (i) {
            case 0:
                if (((SSMGPB.InitChatRequest) generatedMessageLite).m1655c()) {
                    return ((SSMGPB.InitChatRequest) generatedMessageLite).m1656d();
                }
                break;
            case 1:
                if (((SSMGPB.InitChatReply) generatedMessageLite).m1597c()) {
                    return ((SSMGPB.InitChatReply) generatedMessageLite).m1598d();
                }
                break;
            case 2:
                if (((SSMGPB.AllowChatRequest) generatedMessageLite).m863c()) {
                    return ((SSMGPB.AllowChatRequest) generatedMessageLite).m864d();
                }
                break;
            case 3:
                if (((SSMGPB.AllowChatReply) generatedMessageLite).m821c()) {
                    return ((SSMGPB.AllowChatReply) generatedMessageLite).m822d();
                }
                break;
            case 4:
                if (((SSMGPB.ChatRequest) generatedMessageLite).m1185c()) {
                    return ((SSMGPB.ChatRequest) generatedMessageLite).m1186d();
                }
                break;
            case 5:
                if (((SSMGPB.ChatReply) generatedMessageLite).m1125c()) {
                    return ((SSMGPB.ChatReply) generatedMessageLite).m1126d();
                }
                break;
            case 8:
                if (((SSMGPB.EndChatRequest) generatedMessageLite).m1492c()) {
                    return ((SSMGPB.EndChatRequest) generatedMessageLite).m1493d();
                }
                break;
            case 9:
                if (((SSMGPB.EndChatReply) generatedMessageLite).m1452c()) {
                    return ((SSMGPB.EndChatReply) generatedMessageLite).m1453d();
                }
                break;
            case 12:
                if (((SSMGPB.InviteChatRequest) generatedMessageLite).m1754c()) {
                    return ((SSMGPB.InviteChatRequest) generatedMessageLite).m1755d();
                }
                break;
            case MsgFrontend.NotiElement.SESSION_INFO_FIELD_NUMBER /* 13 */:
                if (((SSMGPB.InviteChatReply) generatedMessageLite).m1714c()) {
                    return ((SSMGPB.InviteChatReply) generatedMessageLite).m1715d();
                }
                break;
            case 14:
                if (((SSMGPB.DisconnectRequest) generatedMessageLite).m1417c()) {
                    return ((SSMGPB.DisconnectRequest) generatedMessageLite).m1418d();
                }
                break;
            case 15:
                if (((SSMGPB.DisconnectReply) generatedMessageLite).m1378c()) {
                    return ((SSMGPB.DisconnectReply) generatedMessageLite).m1379d();
                }
                break;
            case 16:
                if (((SSMGPB.AnnounceChange) generatedMessageLite).m919c()) {
                    return ((SSMGPB.AnnounceChange) generatedMessageLite).m920d();
                }
                break;
            case 17:
                if (((SSMGPB.AnnounceChangeReply) generatedMessageLite).m958c()) {
                    return ((SSMGPB.AnnounceChangeReply) generatedMessageLite).m959d();
                }
                break;
            case 18:
                if (((SSMGPB.NicknameRequest) generatedMessageLite).m1867c()) {
                    return ((SSMGPB.NicknameRequest) generatedMessageLite).m1868d();
                }
                break;
            case 19:
                if (((SSMGPB.NicknameReply) generatedMessageLite).m1833c()) {
                    return ((SSMGPB.NicknameReply) generatedMessageLite).m1834d();
                }
                break;
        }
        return -1L;
    }

    /* renamed from: a */
    public static GeneratedMessageLite m2725a(int i, byte[] bArr) {
        GeneratedMessageLite generatedMessageLiteM1822a;
        try {
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
                generatedMessageLiteM1822a = SSMGPB.InitChatRequest.m1635a(bArr);
                break;
            case 1:
                generatedMessageLiteM1822a = SSMGPB.InitChatReply.m1582a(bArr);
                break;
            case 2:
                generatedMessageLiteM1822a = SSMGPB.AllowChatRequest.m846a(bArr);
                break;
            case 3:
                generatedMessageLiteM1822a = SSMGPB.AllowChatReply.m813a(bArr);
                break;
            case 4:
                generatedMessageLiteM1822a = SSMGPB.ChatRequest.m1162a(bArr);
                break;
            case 5:
                generatedMessageLiteM1822a = SSMGPB.ChatReply.m1110a(bArr);
                break;
            case 6:
                generatedMessageLiteM1822a = SSMGPB.DeliveryChat.m1243a(bArr);
                break;
            case 7:
                generatedMessageLiteM1822a = SSMGPB.DeliveryChatReply.m1287a(bArr);
                break;
            case 8:
                generatedMessageLiteM1822a = SSMGPB.EndChatRequest.m1478a(bArr);
                break;
            case 9:
                generatedMessageLiteM1822a = SSMGPB.EndChatReply.m1444a(bArr);
                break;
            case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                generatedMessageLiteM1822a = SSMGPB.AnswerBack.m983a(bArr);
                break;
            case 11:
                generatedMessageLiteM1822a = SSMGPB.AnswerBackReply.m1008a(bArr);
                break;
            case 12:
                generatedMessageLiteM1822a = SSMGPB.InviteChatRequest.m1739a(bArr);
                break;
            case MsgFrontend.NotiElement.SESSION_INFO_FIELD_NUMBER /* 13 */:
                generatedMessageLiteM1822a = SSMGPB.InviteChatReply.m1706a(bArr);
                break;
            case 14:
                generatedMessageLiteM1822a = SSMGPB.DisconnectRequest.m1408a(bArr);
                break;
            case 15:
                generatedMessageLiteM1822a = SSMGPB.DisconnectReply.m1369a(bArr);
                break;
            case 16:
                generatedMessageLiteM1822a = SSMGPB.AnnounceChange.m905a(bArr);
                break;
            case 17:
                generatedMessageLiteM1822a = SSMGPB.AnnounceChangeReply.m950a(bArr);
                break;
            case 18:
                generatedMessageLiteM1822a = SSMGPB.NicknameRequest.m1860a(bArr);
                break;
            case 19:
                generatedMessageLiteM1822a = SSMGPB.NicknameReply.m1822a(bArr);
                break;
            default:
                return null;
        }
        return generatedMessageLiteM1822a;
    }

    /* renamed from: a */
    public static boolean m2726a(int i) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
            case MsgFrontendCommon.__NotiAcks__ /* 10 */:
            case 12:
            case 14:
            case 16:
            case 18:
                return true;
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case MsgFrontend.NotiElement.SESSION_INFO_FIELD_NUMBER /* 13 */:
            case 15:
            case 17:
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static boolean m2727a(GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite instanceof SSMGPB.InitChatRequest) {
            if (((SSMGPB.InitChatRequest) generatedMessageLite).m1673u()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.InitChatReply) {
            if (((SSMGPB.InitChatReply) generatedMessageLite).m1607m()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.AllowChatRequest) {
            if (((SSMGPB.AllowChatRequest) generatedMessageLite).m877q()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.AllowChatReply) {
            if (((SSMGPB.AllowChatReply) generatedMessageLite).m825g()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.ChatRequest) {
            if (((SSMGPB.ChatRequest) generatedMessageLite).m1205w()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.ChatReply) {
            if (((SSMGPB.ChatReply) generatedMessageLite).m1135m()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.DeliveryChat) {
            if (((SSMGPB.DeliveryChat) generatedMessageLite).m1267m()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.DeliveryChatReply) {
            if (((SSMGPB.DeliveryChatReply) generatedMessageLite).m1305i()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.EndChatRequest) {
            if (((SSMGPB.EndChatRequest) generatedMessageLite).m1503n()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.EndChatReply) {
            if (((SSMGPB.EndChatReply) generatedMessageLite).m1456g()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.AnswerBack) {
            if (((SSMGPB.AnswerBack) generatedMessageLite).m992e()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.AnswerBackReply) {
            if (((SSMGPB.AnswerBackReply) generatedMessageLite).m1026i()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.InviteChatRequest) {
            if (((SSMGPB.InviteChatRequest) generatedMessageLite).m1766o()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.InviteChatReply) {
            if (((SSMGPB.InviteChatReply) generatedMessageLite).m1718g()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.DisconnectRequest) {
            if (((SSMGPB.DisconnectRequest) generatedMessageLite).m1423i()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.DisconnectReply) {
            if (((SSMGPB.DisconnectReply) generatedMessageLite).m1384i()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.AnnounceChange) {
            if (((SSMGPB.AnnounceChange) generatedMessageLite).m929m()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.AnnounceChangeReply) {
            if (((SSMGPB.AnnounceChangeReply) generatedMessageLite).m962g()) {
                return true;
            }
        } else if (generatedMessageLite instanceof SSMGPB.NicknameRequest) {
            if (((SSMGPB.NicknameRequest) generatedMessageLite).m1870f()) {
                return true;
            }
        } else if ((generatedMessageLite instanceof SSMGPB.NicknameReply) && ((SSMGPB.NicknameReply) generatedMessageLite).m1838h()) {
            return true;
        }
        return false;
    }
}
