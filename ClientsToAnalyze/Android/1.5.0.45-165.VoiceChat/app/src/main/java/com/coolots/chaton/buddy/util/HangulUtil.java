package com.coolots.chaton.buddy.util;

import com.sds.coolots.common.util.Log;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.util.Locale;

/* loaded from: classes.dex */
public final class HangulUtil {
    private static final char HANGUL_BASE_UNIT = 588;
    private static final char HANGUL_BEGIN_UNICODE = 44032;
    private static final char HANGUL_LAST_UNICODE = 55203;
    private static final char[] INITIAL_SOUND = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    private HangulUtil() {
    }

    private static boolean isInitialSound(char searchar) {
        for (char c : INITIAL_SOUND) {
            if (c == searchar) {
                return true;
            }
        }
        return false;
    }

    private static char getInitialSound(char cha) {
        int hanBegin = cha - HANGUL_BEGIN_UNICODE;
        int index = hanBegin / 588;
        return INITIAL_SOUND[index];
    }

    private static boolean isHangul(char cha) {
        return 44032 <= cha && cha <= 55203;
    }

    public static boolean matchString(String value, String search) {
        String copyOfvalue = value.toLowerCase(Locale.getDefault());
        String copyOfsearch = search.toLowerCase(Locale.getDefault());
        int seof = copyOfvalue.length() - copyOfsearch.length();
        int slen = copyOfsearch.length();
        if (seof < 0) {
            return false;
        }
        for (int i = 0; i <= seof; i++) {
            int temp = 0;
            while (temp < slen) {
                if (isInitialSound(copyOfsearch.charAt(temp)) && isHangul(copyOfvalue.charAt(i + temp))) {
                    if (getInitialSound(copyOfvalue.charAt(i + temp)) != copyOfsearch.charAt(temp)) {
                        break;
                    }
                    temp++;
                } else {
                    if (copyOfvalue.charAt(i + temp) != copyOfsearch.charAt(temp)) {
                        break;
                    }
                    temp++;
                }
            }
            if (temp == slen) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsHangul(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(cha);
            if (Character.UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock) || Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock) || Character.UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock)) {
                return true;
            }
        }
        return false;
    }

    public static int countByteForKSC5601(String source) {
        try {
            int count = source.getBytes("KSC5601").length;
            return count;
        } catch (UnsupportedEncodingException e) {
            Log.m2963i("countByteForKSC5601() count err");
            e.printStackTrace();
            return -1;
        }
    }

    public static String makeHighlightedString(String source, String searchString) {
        StringBuilder sRetString = new StringBuilder();
        String lowSource = source.toLowerCase(Locale.getDefault());
        String lowSearch = searchString.toLowerCase(Locale.getDefault());
        int index = -1;
        int linearIndex = 0;
        for (int i = 0; i < lowSource.length() && linearIndex < lowSearch.length(); i++) {
            if (matchString(String.valueOf(lowSource.charAt(i)), String.valueOf(lowSearch.charAt(linearIndex)))) {
                if (index == -1) {
                    index = i;
                }
                linearIndex++;
            } else {
                index = -1;
                linearIndex = 0;
            }
        }
        if (index < 0) {
            index = 0;
        }
        sRetString.append(source.substring(0, index));
        sRetString.append("<FONT color=#21CDFF><b>");
        sRetString.append(source.substring(index, searchString.length() + index));
        sRetString.append("</b></FONT>");
        sRetString.append(source.substring(searchString.length() + index, source.length()));
        return sRetString.toString();
    }
}
