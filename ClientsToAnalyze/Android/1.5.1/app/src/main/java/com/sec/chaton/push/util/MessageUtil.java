package com.sec.chaton.push.util;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.exception.PushClientException;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MessageUtil {
    /* renamed from: a */
    public static String m3020a(MessageLite messageLite) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb = new StringBuilder();
        MsgFrontendCommon.getMessageType(messageLite);
        for (Method method : messageLite.getClass().getMethods()) {
            if (!method.getName().equals("getClass") && !method.getName().equals("getDefaultInstance") && !method.getName().equals("getDefaultInstanceForType") && !method.getName().equals("getSerializedSize") && method.getName().startsWith("get")) {
                try {
                    Object objInvoke = method.invoke(messageLite, null);
                    sb.append(method.getName());
                    sb.append("\t: ");
                    sb.append(objInvoke.toString());
                    sb.append("\n");
                } catch (Exception e) {
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m3021b(MessageLite messageLite) {
        switch (MsgFrontendCommon.getMessageType(messageLite)) {
            case 0:
            case 2:
            case 4:
            case 6:
            case MsgFrontendCommon.__NotiAcks__ /* 10 */:
            case 11:
                return true;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
            default:
                return false;
        }
    }

    /* renamed from: c */
    public static boolean m3022c(MessageLite messageLite) {
        switch (MsgFrontendCommon.getMessageType(messageLite)) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 12:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: d */
    public static boolean m3023d(MessageLite messageLite) {
        return MsgFrontendCommon.getMessageType(messageLite) == 9;
    }

    /* renamed from: e */
    public static int m3024e(MessageLite messageLite) throws PushClientException {
        try {
            try {
                return ((Integer) messageLite.getClass().getMethod("getAsyncId", null).invoke(messageLite, null)).intValue();
            } catch (Exception e) {
                throw new PushClientException(e);
            }
        } catch (NoSuchMethodException e2) {
            throw new PushClientException(e2);
        }
    }
}
