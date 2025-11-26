package com.nuance.nmsp.client.sdk.common.oem.api;

import com.coolots.p2pmsg.model.ConfLimitPolicyInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.model.StoreNoteAsk;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.oem.LogFactoryOEM;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class LogFactory {

    public static abstract class Log {

        /* renamed from: a */
        private static String[] f63a = {"0", "1", "2", "3", SimpleUserInfo.STATE_MOVETO_CONFERENCE, "5", "6", "7", "8", "9", "A", StoreNoteAsk.TYPE_SEND_SUCCESS, StoreNoteAsk.TYPE_ADD_MEMBER, StoreNoteAsk.TYPE_REMOVE_MEMBER, "E", ConfLimitPolicyInfo.PAID_TYPE_FREE};

        public static String FormatUuid(byte[] bArr) {
            if (bArr == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 16; i++) {
                stringBuffer.append(m12a(bArr[i]));
                if (i == 3 || i == 5 || i == 7 || i == 9) {
                    stringBuffer.append("-");
                }
            }
            return stringBuffer.toString().toLowerCase();
        }

        /* renamed from: a */
        private static String m12a(byte b) {
            return f63a[(byte) (((byte) (((byte) (b & 240)) >>> 4)) & ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE)] + f63a[(byte) (b & ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE)];
        }

        public static String[] bufferStr(byte[] bArr) {
            String str;
            int length = bArr.length / 8;
            if (bArr.length % 8 != 0) {
                length++;
            }
            String[] strArr = new String[length];
            try {
                str = new String(bArr, "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                str = new String(bArr);
            }
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char[] cArr = new char[41];
                for (int i3 = 0; i3 < cArr.length; i3++) {
                    cArr[i3] = ' ';
                }
                for (int i4 = 0; i4 < 8 && i < bArr.length; i4++) {
                    String strM12a = m12a(bArr[i]);
                    cArr[i4 * 3] = strM12a.charAt(0);
                    cArr[(i4 * 3) + 1] = strM12a.charAt(1);
                    cArr[(i4 << 1) + 26] = str.charAt(i);
                    i++;
                }
                strArr[i2] = new String(cArr);
            }
            return strArr;
        }

        public abstract void debug(Object obj);

        public abstract void debug(Object obj, Throwable th);

        public abstract void error(Object obj);

        public abstract void error(Object obj, Throwable th);

        public abstract void fatal(Object obj);

        public abstract void fatal(Object obj, Throwable th);

        public abstract void info(Object obj);

        public abstract void info(Object obj, Throwable th);

        public abstract boolean isDebugEnabled();

        public abstract boolean isErrorEnabled();

        public abstract boolean isFatalEnabled();

        public abstract boolean isInfoEnabled();

        public abstract boolean isTraceEnabled();

        public abstract boolean isWarnEnabled();

        public abstract void setCurrentSession(String str);

        public abstract void trace(Object obj);

        public abstract void trace(Object obj, Throwable th);

        public void traceBuffer(byte[] bArr) {
            if (isTraceEnabled()) {
                trace("Buffer dump:");
                for (String str : bufferStr(bArr)) {
                    trace(str);
                }
            }
        }

        public abstract void unsetCurrentSession();

        public abstract void warn(Object obj);

        public abstract void warn(Object obj, Throwable th);
    }

    public static Log getLog(Class cls) {
        return LogFactoryOEM.getLog(cls);
    }
}
