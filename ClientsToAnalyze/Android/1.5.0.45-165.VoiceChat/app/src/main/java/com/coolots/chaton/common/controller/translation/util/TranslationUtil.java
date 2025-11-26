package com.coolots.chaton.common.controller.translation.util;

import com.infraware.office.evengine.InterfaceC0507E;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class TranslationUtil {
    public static final String LANGUAGE_VALUE_CHINESE = "zh-CN";
    public static final String LANGUAGE_VALUE_CHINESE_HK = "zh_HK";
    public static final String LANGUAGE_VALUE_FRENCH = "fr-FR";
    public static final String LANGUAGE_VALUE_GERMAN = "de-DE";
    public static final String LANGUAGE_VALUE_ITALIAN = "it-IT";
    public static final String LANGUAGE_VALUE_JPANESE = "ja-JP";
    public static final String LANGUAGE_VALUE_KOREAN = "ko-KR";
    public static final String LANGUAGE_VALUE_SPANISH = "es-ES";
    public static final String LANGUAGE_VALUE_UKENGLISH = "en-UK";
    public static final String LANGUAGE_VALUE_USENGLISH = "en-US";

    public static void logE(String message) {
        Log.m2958e("[TranslationUtil]" + message);
    }

    public static void logI(String message) {
        Log.m2954d("[TranslationUtil]" + message);
    }

    public static String getParamLanguage(int language) {
        switch (language) {
            case 10:
                return LANGUAGE_VALUE_KOREAN;
            case 20:
                return "en-US";
            case 21:
                return LANGUAGE_VALUE_UKENGLISH;
            case 30:
                return LANGUAGE_VALUE_CHINESE;
            case 31:
                return LANGUAGE_VALUE_CHINESE_HK;
            case 40:
                return LANGUAGE_VALUE_JPANESE;
            default:
                logE("getParamLanguage(" + language + "): not supported language");
                return null;
        }
    }

    public static int getLanguage(String paramLanguage) {
        if (LANGUAGE_VALUE_CHINESE.equals(paramLanguage)) {
            return 30;
        }
        if (LANGUAGE_VALUE_CHINESE_HK.equals(paramLanguage)) {
            return 31;
        }
        if ("en-US".equals(paramLanguage)) {
            return 20;
        }
        if (LANGUAGE_VALUE_UKENGLISH.equals(paramLanguage)) {
            return 21;
        }
        if (LANGUAGE_VALUE_JPANESE.equals(paramLanguage)) {
            return 40;
        }
        if (LANGUAGE_VALUE_KOREAN.equals(paramLanguage)) {
            return 10;
        }
        logE("getLanguage(" + paramLanguage + "): not supported language");
        return 0;
    }

    public static String toStringLanguage(int language) {
        switch (language) {
            case 10:
                return "Korea";
            case 20:
            case 21:
                return "English";
            case 30:
            case 31:
                return "Chinese";
            case 40:
                return "Japanese";
            default:
                logE("toStringLanguage(" + language + "): not = language");
                return "";
        }
    }

    public static int toConsentParamLanguage(int firstLanguage, int secondLanguage) {
        int param = firstLanguage << 16;
        return param | secondLanguage;
    }

    public static int get1stConsentParamLanguage(int consentParam) {
        int language = ((-65536) & consentParam) >> 16;
        logI("get1stConsentParamLanguage(): " + language);
        return language;
    }

    public static int get2ndConsentParamLanguage(int consentParam) {
        int language = consentParam & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        logI("get2ndConsentParamLanguage(): " + language);
        return language;
    }
}
