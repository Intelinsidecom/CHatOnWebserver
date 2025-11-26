package com.vlingo.sdk.internal.util;

import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class StringUtils {
    public static final String getWordAtCursor(String phrase, int cursorPosition) {
        if (cursorPosition < 0 || cursorPosition >= phrase.length()) {
            return "";
        }
        String[] words = split(phrase.toLowerCase(), ' ');
        int pos = words[0].length();
        int wordindex = 0;
        while (cursorPosition > pos && wordindex < words.length - 1) {
            wordindex++;
            pos += words[wordindex].length();
        }
        if (wordindex > words.length) {
            return "";
        }
        String word = words[wordindex];
        return word;
    }

    public static final String convertBytesToString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bytes);
        }
    }

    public static final byte[] convertStringToBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static final String[] removeTopChoice(String[] choices) {
        if (choices == null || choices.length == 0) {
            return null;
        }
        int size = choices.length - 1;
        String[] ret = new String[size];
        for (int i = 0; i < size; i++) {
            ret[i] = choices[i + 1];
        }
        return ret;
    }

    public static boolean isNullOrWhiteSpace(String s) {
        return s == null || "".equals(s.trim());
    }

    public static String replace(String _text, String _searchStr, String _replacementStr) {
        StringBuffer sb = new StringBuffer();
        int searchStringPos = _text.indexOf(_searchStr);
        int startPos = 0;
        int searchStringLength = _searchStr.length();
        while (searchStringPos != -1) {
            sb.append(_text.substring(startPos, searchStringPos)).append(_replacementStr);
            startPos = searchStringPos + searchStringLength;
            searchStringPos = _text.indexOf(_searchStr, startPos);
        }
        sb.append(_text.substring(startPos, _text.length()));
        return sb.toString();
    }

    public static String byteArrayToString(byte[] arr) {
        StringBuffer sb = new StringBuffer(arr.length);
        for (byte b : arr) {
            sb.append((int) b);
        }
        return sb.toString();
    }

    public static boolean isPhoneNumber(String str) {
        int len = str.length();
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if ((ch < '0' || ch > '9') && ch != ' ' && ch != '-' && ch != '+' && ch != '(' && ch != ')') {
                return false;
            }
        }
        return true;
    }

    public static String cleanPhoneNumber(String number) {
        StringBuffer cleaned = new StringBuffer(number.length());
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c >= '0' && c <= '9') {
                cleaned.append(c);
            }
        }
        return cleaned.toString();
    }

    public static boolean arePhoneNumbersTheSame(String n1, String n2) {
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.startsWith("+")) {
            n1 = n1.substring(1, n1.length());
        }
        if (n2.startsWith("+")) {
            n2 = n2.substring(1, n2.length());
        }
        if (n1.startsWith("1")) {
            n1 = n1.substring(1, n1.length());
        }
        if (n2.startsWith("1")) {
            n2 = n2.substring(1, n2.length());
        }
        return n1.equals(n2);
    }

    public static String formatPhoneNumber(String number) {
        return formatPhoneNumber(number, true);
    }

    public static String formatPhoneNumber(String number, boolean showParens) {
        String c;
        int clen;
        if (number == null || number.length() == 0 || (clen = (c = cleanPhoneNumber(number)).length()) == 0) {
            return "";
        }
        StringBuffer cleaned = new StringBuffer(clen + 16);
        boolean startsWithOne = c.charAt(0) == '1';
        if (number.startsWith("+")) {
            cleaned.append("+");
        }
        if (startsWithOne) {
            String c2 = c.substring(1);
            int clen2 = clen - 1;
            if (clen2 >= 3 && clen2 <= 6) {
                cleaned.append(showParens ? "1 (" : "1-");
                cleaned.append(c2.substring(0, 3));
                cleaned.append(showParens ? ") " : "-");
                cleaned.append(c2.substring(3, clen2));
                return cleaned.toString();
            }
            if (clen2 >= 7 && clen2 <= 10) {
                cleaned.append(showParens ? "1 (" : "1-");
                cleaned.append(c2.substring(0, 3));
                cleaned.append(showParens ? ") " : "-");
                cleaned.append(c2.substring(3, 6));
                cleaned.append("-");
                cleaned.append(c2.substring(6, clen2));
                return cleaned.toString();
            }
            if (clen2 > 10) {
                int cidx = clen2 - 10;
                cleaned.append(showParens ? "1 " : "1-");
                cleaned.append(c2.substring(0, cidx));
                cleaned.append(showParens ? " (" : "-");
                cleaned.append(c2.substring(cidx, cidx + 3));
                cleaned.append(showParens ? ") " : "-");
                cleaned.append(c2.substring(cidx + 3, cidx + 6));
                cleaned.append("-");
                cleaned.append(c2.substring(cidx + 6, clen2));
                return cleaned.toString();
            }
            return number;
        }
        if (clen >= 4 && clen <= 7) {
            cleaned.append(c.substring(0, 3));
            cleaned.append("-");
            cleaned.append(c.substring(3, clen));
            return cleaned.toString();
        }
        if (clen >= 8 && clen <= 10) {
            cleaned.append(showParens ? "(" : "");
            cleaned.append(c.substring(0, 3));
            cleaned.append(showParens ? ") " : "-");
            cleaned.append(c.substring(3, 6));
            cleaned.append("-");
            cleaned.append(c.substring(6, clen));
            return cleaned.toString();
        }
        if (clen > 10) {
            int cidx2 = clen - 10;
            cleaned.append(c.substring(0, cidx2));
            cleaned.append(showParens ? " (" : "-");
            cleaned.append(c.substring(cidx2, cidx2 + 3));
            cleaned.append(showParens ? ") " : "-");
            cleaned.append(c.substring(cidx2 + 3, cidx2 + 6));
            cleaned.append("-");
            cleaned.append(c.substring(cidx2 + 6, clen));
            return cleaned.toString();
        }
        return number;
    }

    public static String getHostname(String url) {
        int slashPos = url.indexOf("://");
        if (slashPos == -1) {
            return "";
        }
        int endSlashPos = url.indexOf("/", slashPos + 3);
        if (endSlashPos == -1 && (endSlashPos = url.indexOf(Config.KEYVALUE_SPLIT, slashPos + 3)) == -1) {
            endSlashPos = url.length();
        }
        return url.substring(slashPos + 3, endSlashPos);
    }

    public static String replaceHostname(String url, String newHostname) {
        int slashPos = url.indexOf("://");
        if (slashPos == -1) {
            return "";
        }
        int endSlashPos = url.indexOf("/", slashPos + 3);
        if (endSlashPos == -1 && (endSlashPos = url.indexOf(Config.KEYVALUE_SPLIT, slashPos + 3)) == -1) {
            endSlashPos = url.length();
        }
        StringBuffer buff = new StringBuffer(url);
        buff.delete(slashPos + 3, endSlashPos);
        buff.insert(slashPos + 3, newHostname);
        return buff.toString();
    }

    public static String[] split(String str, char delimiter) {
        if (str == null) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                count++;
            }
        }
        String[] arr = new String[count + 1];
        int index = 0;
        for (int i2 = 0; i2 < count; i2++) {
            int pos = str.indexOf(delimiter, index);
            arr[i2] = str.substring(index, pos);
            index = pos + 1;
        }
        arr[count] = str.substring(index);
        return arr;
    }

    public static boolean isVersionAtLeast(String version, String atLeast) {
        if (version == null || atLeast == null) {
            return false;
        }
        int res = compareVersions(version, atLeast);
        return res == 0 || res == 1;
    }

    public static int compareVersions(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] v1 = split(version1, '.');
        String[] v2 = split(version2, '.');
        int size = Math.max(v1.length, v2.length);
        int i = 0;
        while (i < size) {
            int vc1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int vc2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (vc1 > vc2) {
                return 1;
            }
            if (vc1 < vc2) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static String removeFromEnd(String str, String strToRemove) {
        String str2 = str.trim();
        if (str2.endsWith(strToRemove)) {
            str2 = str2.substring(0, str2.length() - strToRemove.length());
        }
        return str2.trim();
    }

    public static boolean isIPAddress(String s) {
        if (isNullOrWhiteSpace(s) || s.indexOf(46) == -1) {
            return false;
        }
        String s2 = s.trim();
        int dotCount = 0;
        int[] dotPos = new int[5];
        dotPos[0] = -1;
        dotPos[4] = s2.length();
        for (int index = 0; index < s2.length() && dotCount < 4; index++) {
            char ch = s2.charAt(index);
            if (!Character.isDigit(ch) && ch != '.') {
                return false;
            }
            if (ch == '.') {
                dotCount++;
                dotPos[dotCount] = index;
            }
        }
        if (dotCount != 3) {
            return false;
        }
        for (int dotCount2 = 1; dotCount2 < 5; dotCount2++) {
            try {
                int index2 = dotPos[dotCount2 - 1] + 1;
                String num = s2.substring(index2, dotPos[dotCount2]);
                int number = Integer.valueOf(num).intValue();
                if (number < 0 || number > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 != null && s2 == null) {
            return false;
        }
        if (s1 != null || s2 == null) {
            return s1.equals(s2);
        }
        return false;
    }

    public static String getSubstring(String str, String startDelimiter, String endDelimiter) {
        if (str == null) {
            return null;
        }
        int startIndex = 0;
        int endIndex = str.length();
        if (startDelimiter != null) {
            int startIndex2 = str.indexOf(startDelimiter);
            if (startIndex2 < 0) {
                return null;
            }
            startIndex = startIndex2 + startDelimiter.length();
        }
        if (endDelimiter == null || (endIndex = str.indexOf(endDelimiter, startIndex)) >= 0) {
            return str.substring(startIndex, endIndex);
        }
        return null;
    }
}
