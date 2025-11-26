package com.vlingo.sdk.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class Settings {
    public static final String ACOUSTIC_RAW_ZIP_FILENAME = "vlsdk_acoustic_raw.zip";
    public static final boolean ASR_KEEPALIVE = false;
    public static final boolean AUDIO_FILE_LOG_ENABLED = false;
    public static final String DEFAULT_LANGUAGE = "en-US";
    public static final boolean DETAILED_TIMINGS = true;
    public static final String KEY_ASR_MANAGER = "asr.manager";
    public static final String KEY_COOKIE_DATA = "cookie_data";
    public static final String KEY_SCREEN_MAG = "screen.mag";
    public static final String KEY_SCREEN_WIDTH = "screen.width";
    public static final String KEY_UUID = "uuid";
    public static final String LIB_PATH = "vlsdk_lib";
    public static final String LIB_ZIP_FILENAME = "vlsdk_lib.zip";
    public static final String LTS_RAW_ZIP_FILENAME = "vlsdk_lts_raw.zip";
    public static final String RAW_PATH = "vlsdk_raw";
    public static final boolean SERVERLOG_ENABLED = false;
    public static HashMap<String, String> SPOTTER_PRONUN_MODEL_FILENAME;
    public static String LANGUAGE = "en-US";
    public static String[] SUPPORTED_LANGUAGES = {"en-US", TTSRequestParams.LANG_EN_GB, TranslationUtil.LANGUAGE_VALUE_FRENCH, TranslationUtil.LANGUAGE_VALUE_ITALIAN, TranslationUtil.LANGUAGE_VALUE_GERMAN, TranslationUtil.LANGUAGE_VALUE_SPANISH, "v-es-LA", "v-es-NA", TranslationUtil.LANGUAGE_VALUE_CHINESE, TranslationUtil.LANGUAGE_VALUE_JPANESE, TranslationUtil.LANGUAGE_VALUE_KOREAN};
    public static HashMap<String, String> SPOTTER_ACOUSTIC_MODEL_FILENAME = new HashMap<>(11);

    static {
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put("en-US", "nn_en_us_mfcc_16k_15_big_250_v4_5.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TTSRequestParams.LANG_EN_GB, "nn_en_uk_mfcc_16k_15_big_250_v2_0.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_FRENCH, "nn_fr_mfcc_16k_15_big_250_v2_2.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_ITALIAN, "nn_it_mfcc_16k_15_big_250_v3_2.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_GERMAN, "nn_de_mfcc_16k_15_big_250_v3_0.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_SPANISH, "nn_es_mfcc_16k_15_big_250_v1_1.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put("v-es-LA", "nn_es_mfcc_16k_15_big_250_v1_1.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put("v-es-NA", "nn_es_mfcc_16k_15_big_250_v1_1.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_CHINESE, "nn_zh_mfcc_16k_15_big_250_v2_2.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_JPANESE, "nn_ja_mfcc_16k_15_big_250_v4_2.raw");
        SPOTTER_ACOUSTIC_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_KOREAN, "nn_ko_mfcc_16k_15_big_250_v2_1.raw");
        SPOTTER_PRONUN_MODEL_FILENAME = new HashMap<>(11);
        SPOTTER_PRONUN_MODEL_FILENAME.put("en-US", "lts_en_us_9.2.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TTSRequestParams.LANG_EN_GB, "lts_en_2.8.1.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_FRENCH, "lts_fr_3.12.1.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_ITALIAN, "lts_it_1.6.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_GERMAN, "lts_de_3.3.5.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_SPANISH, "lts_es_3.14.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put("v-es-LA", "lts_es_3.14.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put("v-es-NA", "lts_es_3.14.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_CHINESE, "lts_zh_3.2.5.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_JPANESE, "lts_jp_5.17.raw");
        SPOTTER_PRONUN_MODEL_FILENAME.put(TranslationUtil.LANGUAGE_VALUE_KOREAN, "lts_ko_1.0.raw");
    }

    public static String getPersistentString(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    public static int getPersistentInt(String key, int defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }

    public static float getPersistentFloat(String key, float defaultValue) {
        return getSharedPreferences().getFloat(key, defaultValue);
    }

    public static void setPersistentString(String key, String value) {
        SharedPreferences prefs = getSharedPreferences();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static boolean getPersistentBoolean(String key, boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    private static SharedPreferences getSharedPreferences() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
