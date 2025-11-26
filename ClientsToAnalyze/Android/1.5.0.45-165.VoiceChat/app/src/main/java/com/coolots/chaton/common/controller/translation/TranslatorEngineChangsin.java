package com.coolots.chaton.common.controller.translation;

import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.voiceservice.translatelib.Translate;
import com.vlingo.sdk.internal.Strings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class TranslatorEngineChangsin extends TranslatorEngine {
    private static final String CID = "0";
    private static final boolean HASH_FLAG = false;
    private static final String OPTION = "1";
    private static final String SERVER = "US";
    private TranslationHandler mHandler;
    private String mRecognizedStr = null;

    public void logE(String message) {
        Log.m2958e("[TranslatorEngineChangsin]" + message);
    }

    public static void logI(String message) {
        Log.m2954d("[TranslatorEngineChangsin]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public void init() {
        super.init();
        this.mHandler = new TranslationHandler();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public Map<Integer, Set<Integer>> getSupportedLanguage() {
        logI("getSupportedLanguage()");
        Map<Integer, Set<Integer>> language = new HashMap<>();
        Set<Integer> subLanguage1 = new HashSet<>();
        subLanguage1.add(20);
        subLanguage1.add(40);
        subLanguage1.add(10);
        language.put(10, subLanguage1);
        Set<Integer> subLanguage3 = new HashSet<>();
        subLanguage3.add(10);
        subLanguage3.add(40);
        language.put(40, subLanguage3);
        Set<Integer> subLanguage4 = new HashSet<>();
        subLanguage4.add(10);
        subLanguage4.add(20);
        language.put(20, subLanguage4);
        logI("language: " + language.toString());
        return language;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public boolean isSupportedLanguage(int inLanguage, int outLanguage) {
        logI("isSupportedLanguage(" + inLanguage + ", " + outLanguage + ")");
        Map<Integer, Set<Integer>> language = getSupportedLanguage();
        Set<Integer> outLanguages = language.get(Integer.valueOf(inLanguage));
        return (outLanguages == null || outLanguages.isEmpty() || !outLanguages.contains(Integer.valueOf(outLanguage))) ? false : true;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public int getInLanguage() {
        return this.mInLanguage;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public int getOutLanguage() {
        return this.mOutLanguage;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public void start(String id, String userID, String recognizedText) {
        logI("start()++");
        super.start(id, userID, recognizedText);
        if (recognizedText == null || recognizedText.isEmpty()) {
            logI("start(): recognized text is null");
            return;
        }
        notifyTranslationStart();
        if (this.mInLanguage == this.mOutLanguage) {
            notifyTanslationEnd(recognizedText);
        } else if (this.mHandler != null) {
            Message msg = new Message();
            msg.what = 0;
            msg.obj = recognizedText;
            this.mHandler.sendMessage(msg);
        }
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public void stop() {
        Translate.cancel();
        super.stop();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public void dispose() {
        if (this.mHandler != null) {
            this.mHandler.dispose();
            this.mHandler = null;
        }
        super.dispose();
    }

    public class TranslationHandler extends Handler implements DisposeInterface {
        private boolean disposeFlag = false;

        public TranslationHandler() {
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.coolots.chaton.common.controller.translation.TranslatorEngineChangsin$TranslationHandler$1] */
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!this.disposeFlag) {
                TranslatorEngineChangsin.this.mRecognizedStr = (String) msg.obj;
                if (TranslatorEngineChangsin.this.mRecognizedStr == null) {
                    TranslatorEngineChangsin.this.logE("Recognized string is null");
                    TranslatorEngineChangsin.this.notifyTanslationEnd("Recognized string is null");
                } else {
                    new Thread() { // from class: com.coolots.chaton.common.controller.translation.TranslatorEngineChangsin.TranslationHandler.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            TranslatorEngineChangsin.logI("TranslateExecute: run() ++");
                            String[] translatedStr = (String[]) null;
                            String inLanguage = TranslationUtil.getParamLanguage(TranslatorEngineChangsin.this.mInLanguage);
                            String outLanguage = TranslationUtil.getParamLanguage(TranslatorEngineChangsin.this.mOutLanguage);
                            TranslatorEngineChangsin.logI("input string: " + TranslatorEngineChangsin.this.mRecognizedStr);
                            TranslatorEngineChangsin.logI("in language: " + inLanguage);
                            TranslatorEngineChangsin.logI("out language: " + outLanguage);
                            TranslatorEngineChangsin.logI("CID: 0");
                            TranslatorEngineChangsin.logI("OPTION: 1");
                            try {
                                TranslatorEngineChangsin.logI("Translate.execute()++");
                                translatedStr = Translate.execute(TranslatorEngineChangsin.this.mRecognizedStr, inLanguage, outLanguage, "0", "1", MainApplication.mContext);
                                TranslatorEngineChangsin.logI("Translate.execute()--");
                            } catch (Exception e) {
                                TranslatorEngineChangsin.this.logE("Translation error: " + e);
                            }
                            if (translatedStr == null) {
                                TranslatorEngineChangsin.this.logE("translatedStr is null");
                                TranslatorEngineChangsin.this.notifyTanslationEnd("translatedStr is null");
                                return;
                            }
                            if (translatedStr[2] == null) {
                                TranslatorEngineChangsin.logI("translated string: " + translatedStr[0]);
                                TranslatorEngineChangsin.this.notifyTanslationEnd(translatedStr[0]);
                            } else if (translatedStr[2].equals("1001")) {
                                TranslatorEngineChangsin.this.logE("Samsung account fail");
                                TranslatorEngineChangsin.this.notifyTanslationEnd("Samsung account fail");
                            } else if (translatedStr[2].equals("1002")) {
                                TranslatorEngineChangsin.this.logE("language is not supported");
                                TranslatorEngineChangsin.this.notifyTanslationEnd("language is not supported");
                            } else if (translatedStr[2].equals("1003")) {
                                TranslatorEngineChangsin.this.logE(Strings.client_core_network_error);
                                TranslatorEngineChangsin.this.notifyTanslationEnd(Strings.client_core_network_error);
                            } else if (translatedStr[2].equals("1004")) {
                                TranslatorEngineChangsin.this.logE("Server error");
                                TranslatorEngineChangsin.this.notifyTanslationEnd("Server error");
                            } else if (translatedStr[2].equals("1005")) {
                                TranslatorEngineChangsin.this.logE("Exception error");
                                TranslatorEngineChangsin.this.notifyTanslationEnd("Exception error");
                            } else {
                                TranslatorEngineChangsin.this.logE("Unexpected error");
                                TranslatorEngineChangsin.this.notifyTanslationEnd("Unexpected error");
                            }
                            TranslatorEngineChangsin.logI("TranslateExecute: run() --");
                        }
                    }.start();
                }
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.disposeFlag = true;
        }
    }
}
