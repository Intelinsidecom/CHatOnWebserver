package com.sds.coolots.common.util;

import android.text.Html;
import android.text.Spanned;
import com.sds.coolots.MainApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class StrUtil {
    private StrUtil() {
    }

    public static boolean checkCPNum(String str) {
        return str.replaceAll("/-/gi", "").matches("^0(?:10|11|16|17|18|19)(?:\\d{3}|\\d{4})\\d{4}$");
    }

    public static String convertDateToyyyyMMddHHmmss(Date date) {
        return date == null ? "0" : new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }

    public static String getString(int i) {
        return MainApplication.mContext.getResources().getString(i);
    }

    public static String lTrim(String str, char c) {
        if (str == null) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != c) {
                return str.substring(i, str.length());
            }
        }
        return "";
    }

    public static String removeChatImoticon(CharSequence charSequence) {
        String string = Html.toHtml((Spanned) charSequence).toString();
        if (string == null || string.equals("")) {
            return "";
        }
        while (true) {
            int iIndexOf = string.indexOf("<img src=");
            if (iIndexOf < 0) {
                return Html.fromHtml(string.replace("<u>", "").replace("</u>", "")).toString().trim();
            }
            string = string.replaceAll(string.substring(iIndexOf, string.indexOf(62, iIndexOf) + 1), "");
        }
    }

    public static String replaceChatEmoticonFromMsg(String str, String str2) {
        int iIndexOf;
        if (str == null || str.equals("")) {
            return "";
        }
        while (true) {
            int iIndexOf2 = str.indexOf("<img src=");
            if (iIndexOf2 < 0 || (iIndexOf = str.indexOf(62, iIndexOf2)) < 0) {
                break;
            }
            str = str.replaceAll(str.substring(iIndexOf2, iIndexOf + 1), str2);
        }
        return str.replace("<u>", "").replace("</u>", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String substringDate(java.lang.String r2) {
        /*
            r1 = 11
            java.lang.String r0 = ""
            if (r2 == 0) goto L1d
            int r0 = r2.length()     // Catch: java.lang.Exception -> L28
            if (r0 < r1) goto L1d
            int r0 = r2.length()     // Catch: java.lang.Exception -> L28
            int r0 = r0 + (-11)
            int r1 = r2.length()     // Catch: java.lang.Exception -> L28
            int r1 = r1 + (-3)
            java.lang.String r2 = r2.substring(r0, r1)     // Catch: java.lang.Exception -> L28
        L1c:
            return r2
        L1d:
            if (r2 == 0) goto L25
            int r0 = r2.length()     // Catch: java.lang.Exception -> L28
            if (r0 < r1) goto L1c
        L25:
            java.lang.String r2 = ""
            goto L1c
        L28:
            r0 = move-exception
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sds.coolots.common.util.StrUtil.substringDate(java.lang.String):java.lang.String");
    }
}
