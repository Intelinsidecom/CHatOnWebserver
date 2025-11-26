package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.HttpRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: HttpUtils.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.j */
/* loaded from: classes.dex */
public class C4074j {

    /* renamed from: a */
    private static final String f14680a = m15682a(Locale.getDefault());

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03ae A[Catch: URISyntaxException -> 0x045f, IllegalStateException -> 0x0531, IllegalArgumentException -> 0x0593, SocketException -> 0x059d, Exception -> 0x05a7, all -> 0x05b1, TryCatch #11 {Exception -> 0x05a7, blocks: (B:10:0x00c4, B:12:0x00ca, B:14:0x00d0, B:16:0x00e4, B:19:0x00ec, B:21:0x00f2, B:49:0x01fd, B:55:0x020b, B:57:0x0216, B:59:0x0221, B:27:0x0100, B:29:0x010b, B:31:0x0116, B:32:0x013f, B:34:0x014f, B:36:0x0155, B:37:0x0159, B:38:0x016a, B:39:0x016d, B:61:0x024c, B:62:0x0266, B:64:0x026c, B:65:0x0278, B:67:0x027e, B:73:0x028c, B:74:0x02ab, B:76:0x02c1, B:78:0x02cc, B:79:0x02e6, B:80:0x02e9, B:83:0x02f1, B:85:0x02f7, B:87:0x0301, B:88:0x0305, B:89:0x035e, B:91:0x0364, B:93:0x036d, B:94:0x0372, B:96:0x037b, B:98:0x0391, B:99:0x03a5, B:116:0x040a, B:100:0x03a8, B:102:0x03ae, B:104:0x03cb, B:106:0x03d9, B:108:0x03e9, B:109:0x03ed, B:111:0x03f3, B:113:0x03f9, B:114:0x03fc, B:117:0x0411, B:119:0x041f, B:120:0x0422, B:122:0x0432, B:123:0x045e, B:129:0x046d, B:153:0x051e, B:161:0x052d, B:162:0x0530, B:115:0x0400), top: B:213:0x00c4, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x041f A[Catch: URISyntaxException -> 0x045f, IllegalStateException -> 0x0531, IllegalArgumentException -> 0x0593, SocketException -> 0x059d, Exception -> 0x05a7, all -> 0x05b1, TryCatch #11 {Exception -> 0x05a7, blocks: (B:10:0x00c4, B:12:0x00ca, B:14:0x00d0, B:16:0x00e4, B:19:0x00ec, B:21:0x00f2, B:49:0x01fd, B:55:0x020b, B:57:0x0216, B:59:0x0221, B:27:0x0100, B:29:0x010b, B:31:0x0116, B:32:0x013f, B:34:0x014f, B:36:0x0155, B:37:0x0159, B:38:0x016a, B:39:0x016d, B:61:0x024c, B:62:0x0266, B:64:0x026c, B:65:0x0278, B:67:0x027e, B:73:0x028c, B:74:0x02ab, B:76:0x02c1, B:78:0x02cc, B:79:0x02e6, B:80:0x02e9, B:83:0x02f1, B:85:0x02f7, B:87:0x0301, B:88:0x0305, B:89:0x035e, B:91:0x0364, B:93:0x036d, B:94:0x0372, B:96:0x037b, B:98:0x0391, B:99:0x03a5, B:116:0x040a, B:100:0x03a8, B:102:0x03ae, B:104:0x03cb, B:106:0x03d9, B:108:0x03e9, B:109:0x03ed, B:111:0x03f3, B:113:0x03f9, B:114:0x03fc, B:117:0x0411, B:119:0x041f, B:120:0x0422, B:122:0x0432, B:123:0x045e, B:129:0x046d, B:153:0x051e, B:161:0x052d, B:162:0x0530, B:115:0x0400), top: B:213:0x00c4, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0432 A[Catch: URISyntaxException -> 0x045f, IllegalStateException -> 0x0531, IllegalArgumentException -> 0x0593, SocketException -> 0x059d, Exception -> 0x05a7, all -> 0x05b1, TryCatch #11 {Exception -> 0x05a7, blocks: (B:10:0x00c4, B:12:0x00ca, B:14:0x00d0, B:16:0x00e4, B:19:0x00ec, B:21:0x00f2, B:49:0x01fd, B:55:0x020b, B:57:0x0216, B:59:0x0221, B:27:0x0100, B:29:0x010b, B:31:0x0116, B:32:0x013f, B:34:0x014f, B:36:0x0155, B:37:0x0159, B:38:0x016a, B:39:0x016d, B:61:0x024c, B:62:0x0266, B:64:0x026c, B:65:0x0278, B:67:0x027e, B:73:0x028c, B:74:0x02ab, B:76:0x02c1, B:78:0x02cc, B:79:0x02e6, B:80:0x02e9, B:83:0x02f1, B:85:0x02f7, B:87:0x0301, B:88:0x0305, B:89:0x035e, B:91:0x0364, B:93:0x036d, B:94:0x0372, B:96:0x037b, B:98:0x0391, B:99:0x03a5, B:116:0x040a, B:100:0x03a8, B:102:0x03ae, B:104:0x03cb, B:106:0x03d9, B:108:0x03e9, B:109:0x03ed, B:111:0x03f3, B:113:0x03f9, B:114:0x03fc, B:117:0x0411, B:119:0x041f, B:120:0x0422, B:122:0x0432, B:123:0x045e, B:129:0x046d, B:153:0x051e, B:161:0x052d, B:162:0x0530, B:115:0x0400), top: B:213:0x00c4, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x046d A[Catch: URISyntaxException -> 0x045f, IllegalStateException -> 0x0531, IllegalArgumentException -> 0x0593, SocketException -> 0x059d, Exception -> 0x05a7, all -> 0x05b1, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x05a7, blocks: (B:10:0x00c4, B:12:0x00ca, B:14:0x00d0, B:16:0x00e4, B:19:0x00ec, B:21:0x00f2, B:49:0x01fd, B:55:0x020b, B:57:0x0216, B:59:0x0221, B:27:0x0100, B:29:0x010b, B:31:0x0116, B:32:0x013f, B:34:0x014f, B:36:0x0155, B:37:0x0159, B:38:0x016a, B:39:0x016d, B:61:0x024c, B:62:0x0266, B:64:0x026c, B:65:0x0278, B:67:0x027e, B:73:0x028c, B:74:0x02ab, B:76:0x02c1, B:78:0x02cc, B:79:0x02e6, B:80:0x02e9, B:83:0x02f1, B:85:0x02f7, B:87:0x0301, B:88:0x0305, B:89:0x035e, B:91:0x0364, B:93:0x036d, B:94:0x0372, B:96:0x037b, B:98:0x0391, B:99:0x03a5, B:116:0x040a, B:100:0x03a8, B:102:0x03ae, B:104:0x03cb, B:106:0x03d9, B:108:0x03e9, B:109:0x03ed, B:111:0x03f3, B:113:0x03f9, B:114:0x03fc, B:117:0x0411, B:119:0x041f, B:120:0x0422, B:122:0x0432, B:123:0x045e, B:129:0x046d, B:153:0x051e, B:161:0x052d, B:162:0x0530, B:115:0x0400), top: B:213:0x00c4, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0580 A[Catch: all -> 0x057b, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x057b, blocks: (B:141:0x04b5, B:150:0x04c8, B:174:0x0580, B:169:0x053d), top: B:214:0x04b5, outer: #9, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x026c A[Catch: URISyntaxException -> 0x045f, IllegalStateException -> 0x0531, IllegalArgumentException -> 0x0593, SocketException -> 0x059d, Exception -> 0x05a7, all -> 0x05b1, TryCatch #11 {Exception -> 0x05a7, blocks: (B:10:0x00c4, B:12:0x00ca, B:14:0x00d0, B:16:0x00e4, B:19:0x00ec, B:21:0x00f2, B:49:0x01fd, B:55:0x020b, B:57:0x0216, B:59:0x0221, B:27:0x0100, B:29:0x010b, B:31:0x0116, B:32:0x013f, B:34:0x014f, B:36:0x0155, B:37:0x0159, B:38:0x016a, B:39:0x016d, B:61:0x024c, B:62:0x0266, B:64:0x026c, B:65:0x0278, B:67:0x027e, B:73:0x028c, B:74:0x02ab, B:76:0x02c1, B:78:0x02cc, B:79:0x02e6, B:80:0x02e9, B:83:0x02f1, B:85:0x02f7, B:87:0x0301, B:88:0x0305, B:89:0x035e, B:91:0x0364, B:93:0x036d, B:94:0x0372, B:96:0x037b, B:98:0x0391, B:99:0x03a5, B:116:0x040a, B:100:0x03a8, B:102:0x03ae, B:104:0x03cb, B:106:0x03d9, B:108:0x03e9, B:109:0x03ed, B:111:0x03f3, B:113:0x03f9, B:114:0x03fc, B:117:0x0411, B:119:0x041f, B:120:0x0422, B:122:0x0432, B:123:0x045e, B:129:0x046d, B:153:0x051e, B:161:0x052d, B:162:0x0530, B:115:0x0400), top: B:213:0x00c4, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c1 A[Catch: URISyntaxException -> 0x045f, IllegalStateException -> 0x0531, IllegalArgumentException -> 0x0593, SocketException -> 0x059d, Exception -> 0x05a7, all -> 0x05b1, TryCatch #11 {Exception -> 0x05a7, blocks: (B:10:0x00c4, B:12:0x00ca, B:14:0x00d0, B:16:0x00e4, B:19:0x00ec, B:21:0x00f2, B:49:0x01fd, B:55:0x020b, B:57:0x0216, B:59:0x0221, B:27:0x0100, B:29:0x010b, B:31:0x0116, B:32:0x013f, B:34:0x014f, B:36:0x0155, B:37:0x0159, B:38:0x016a, B:39:0x016d, B:61:0x024c, B:62:0x0266, B:64:0x026c, B:65:0x0278, B:67:0x027e, B:73:0x028c, B:74:0x02ab, B:76:0x02c1, B:78:0x02cc, B:79:0x02e6, B:80:0x02e9, B:83:0x02f1, B:85:0x02f7, B:87:0x0301, B:88:0x0305, B:89:0x035e, B:91:0x0364, B:93:0x036d, B:94:0x0372, B:96:0x037b, B:98:0x0391, B:99:0x03a5, B:116:0x040a, B:100:0x03a8, B:102:0x03ae, B:104:0x03cb, B:106:0x03d9, B:108:0x03e9, B:109:0x03ed, B:111:0x03f3, B:113:0x03f9, B:114:0x03fc, B:117:0x0411, B:119:0x041f, B:120:0x0422, B:122:0x0432, B:123:0x045e, B:129:0x046d, B:153:0x051e, B:161:0x052d, B:162:0x0530, B:115:0x0400), top: B:213:0x00c4, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ef  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static byte[] m15686a(android.content.Context r15, long r16, java.lang.String r18, byte[] r19, int r20, boolean r21, java.lang.String r22, int r23) {
        /*
            Method dump skipped, instructions count: 1668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.C4074j.m15686a(android.content.Context, long, java.lang.String, byte[], int, boolean, java.lang.String, int):byte[]");
    }

    /* renamed from: a */
    private static void m15684a(Exception exc, String str) throws IOException {
        C3896s.m15041a("HttpConnection Exception url: " + str, "Mms:transaction");
        String message = null;
        if (exc.getCause() != null) {
            C3896s.m15044b("cause: " + exc.getCause().toString(), "Mms:transaction");
            message = exc.getCause().toString();
        }
        if (exc.getMessage() != null) {
            C3896s.m15044b("message: " + exc.getMessage(), "Mms:transaction");
            message = exc.getMessage();
        }
        IOException iOException = new IOException(message);
        iOException.initCause(exc);
        throw iOException;
    }

    /* renamed from: a */
    private static AndroidHttpClient m15680a(Context context) {
        String strM14700f = C3847e.m14700f();
        AndroidHttpClient androidHttpClientNewInstance = AndroidHttpClient.newInstance(strM14700f, context);
        HttpParams params = androidHttpClientNewInstance.getParams();
        HttpProtocolParams.setContentCharset(params, "UTF-8");
        int iM14712r = C3847e.m14712r();
        if (C3890m.m15000f("Mms:transaction", C3890m.f13992a)) {
            C3890m.m14996b("Mms:transaction", "[HttpUtils] createHttpClient w/ socket timeout " + iM14712r + " ms, , UA=" + strM14700f);
        }
        if (C3847e.m14657aH() && C3847e.m14717w()) {
            iM14712r = C3847e.m14619C();
        }
        C3896s.m15044b("[HttpUtils] createHttpClient w/ socket timeout " + iM14712r + " ms, , UA=" + strM14700f, "Mms:transaction");
        HttpConnectionParams.setSoTimeout(params, iM14712r);
        return androidHttpClientNewInstance;
    }

    /* renamed from: a */
    public static String m15682a(Locale locale) {
        StringBuilder sb = new StringBuilder();
        m15685a(sb, locale);
        if (!Locale.US.equals(locale)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("en-US");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m15681a(String str) {
        if (str == null) {
            return null;
        }
        if ("iw".equals(str)) {
            return "he";
        }
        if ("in".equals(str)) {
            return "id";
        }
        if ("ji".equals(str)) {
            return "yi";
        }
        return str;
    }

    /* renamed from: a */
    private static void m15685a(StringBuilder sb, Locale locale) {
        String strM15681a = m15681a(locale.getLanguage());
        if (strM15681a != null) {
            sb.append(strM15681a);
            String country = locale.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country);
            }
        }
    }

    /* renamed from: a */
    private static void m15683a(Context context, HttpRequest httpRequest) {
        String line1Number;
        String str;
        try {
            line1Number = ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        } catch (Exception e) {
            C3890m.m14999e("Mms:transaction", "[HttpUtils] " + e.toString());
            line1Number = "";
        }
        String[] strArr = {"+82", "082", "0082", "82"};
        if (TextUtils.isEmpty(line1Number)) {
            str = "";
        } else {
            for (String str2 : strArr) {
                if (line1Number.indexOf(str2) == 0) {
                    str = Spam.ACTIVITY_CANCEL + line1Number.substring(str2.length());
                    break;
                }
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            line1Number = str;
        }
        httpRequest.addHeader("x-pcs-mdn", line1Number);
        if (C2471v.m10684g(context)) {
            if (2 == TelephonyManager.getDefault().getCurrentPhoneType()) {
                String str3 = SystemProperties.get("ril.cdma.sid");
                if (str3 != null) {
                    httpRequest.addHeader("SID", str3);
                    return;
                }
                return;
            }
            String str4 = SystemProperties.get("gsm.operator.numeric");
            if (str4 != null) {
                httpRequest.addHeader("Device-MCC_MNC", str4);
            }
        }
    }
}
