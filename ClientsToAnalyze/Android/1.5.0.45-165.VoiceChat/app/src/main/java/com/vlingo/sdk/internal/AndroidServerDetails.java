package com.vlingo.sdk.internal;

import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.recognizer.SRServerDetails;

/* loaded from: classes.dex */
public class AndroidServerDetails implements SRServerDetails {
    public static final String DEFAULT_UTTSCOOP_ASR_SERVER_HOST = "uttscoop.vlingo.com";
    public static final String DEFAULT_ASR_SERVER_HOST = "androidasr.vlingo.com";
    private static final int DEFAULT_PORT = 80;
    private static final String PATH_SR = "/voicepad/sr";
    private static URL s_srURL = new URL(DEFAULT_ASR_SERVER_HOST, DEFAULT_PORT, PATH_SR);
    private static final String PATH_CANCEL = "/voicepad/srcancel";
    private static URL s_cancelURL = new URL(DEFAULT_ASR_SERVER_HOST, DEFAULT_PORT, PATH_CANCEL);
    private static final String PATH_STATS = "/voicepad/stats";
    private static URL s_statsURL = new URL(DEFAULT_ASR_SERVER_HOST, DEFAULT_PORT, PATH_STATS);
    private static final String PATH_LMTT = "/voicepad/lmtt";
    private static URL s_LMTTURL = new URL(DEFAULT_ASR_SERVER_HOST, DEFAULT_PORT, PATH_LMTT);
    private static final String PATH_ACTIVITY_LOG = "/voicepad/activitylog";
    private static URL s_userLoggingURL = new URL(DEFAULT_ASR_SERVER_HOST, DEFAULT_PORT, PATH_ACTIVITY_LOG);
    private static final String PATH_HELLO = "/voicepad/hello";
    private static URL s_helloURL = new URL(DEFAULT_ASR_SERVER_HOST, DEFAULT_PORT, PATH_HELLO);
    public static final String DEFAULT_TTS_SERVER_HOST = "tts.vlingo.com";
    private static final String PATH_TTS = "/tts/tts2";
    private static URL s_TTSServerURL = new URL(DEFAULT_TTS_SERVER_HOST, DEFAULT_PORT, PATH_TTS);
    public static final String DEFAULT_UTTSCOOP_LMDC_SERVER_HOST = "lmdcapps.vlingo.com";
    private static final String PATH_UTTSCOOP_LMDC = "/lmdc/go";
    private static URL s_uttscoopLMDCURL = new URL(DEFAULT_UTTSCOOP_LMDC_SERVER_HOST, DEFAULT_PORT, PATH_UTTSCOOP_LMDC);
    public static final String DEFAULT_UTTSCOOP_LIST_SERVER_HOST = "downloads.vlingo.com";
    private static final String PATH_UTTSCOOP_LISTS = "/lmdc/lists";
    private static URL s_uttscoopListURL = new URL(DEFAULT_UTTSCOOP_LIST_SERVER_HOST, DEFAULT_PORT, PATH_UTTSCOOP_LISTS);

    public static URL getHelloURL() {
        return s_helloURL;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRServerDetails
    public URL getASRCancelURL() {
        return s_cancelURL;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRServerDetails
    public URL getASRURL() {
        return s_srURL;
    }

    @Override // com.vlingo.sdk.internal.recognizer.SRServerDetails
    public URL getStatsURL() {
        return s_statsURL;
    }

    public static URL getLMTTURL() {
        return s_LMTTURL;
    }

    public static URL getUserLoggingURL() {
        return s_userLoggingURL;
    }

    public static URL getTTSURL() {
        return s_TTSServerURL;
    }

    public static URL getUttscoopLMDCURL() {
        return s_uttscoopLMDCURL;
    }

    public static URL getUttscoopListURL() {
        return s_uttscoopListURL;
    }

    public static void setTTSServerName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        s_TTSServerURL = new URL(String.valueOf(name) + PATH_TTS);
    }

    public static void setServerName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        s_srURL = new URL(String.valueOf(name) + PATH_SR);
        s_cancelURL = new URL(String.valueOf(name) + PATH_CANCEL);
        s_statsURL = new URL(String.valueOf(name) + PATH_STATS);
        s_LMTTURL = new URL(String.valueOf(name) + PATH_LMTT);
        s_userLoggingURL = new URL(String.valueOf(name) + PATH_ACTIVITY_LOG);
        s_helloURL = new URL(String.valueOf(name) + PATH_HELLO);
    }
}
