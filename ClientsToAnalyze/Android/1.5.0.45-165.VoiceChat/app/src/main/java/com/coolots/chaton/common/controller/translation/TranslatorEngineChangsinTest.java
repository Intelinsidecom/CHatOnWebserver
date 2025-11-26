package com.coolots.chaton.common.controller.translation;

import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.csli.eztalky.CSTranslator;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class TranslatorEngineChangsinTest extends TranslatorEngine {
    private TranslationHandler mHandler;

    public void logE(String message) {
        Log.m2958e("[TranslatorEngineChangsinTest]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[TranslatorEngineChangsinTest]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public void init() {
        super.init();
        this.mHandler = new TranslationHandler();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TranslatorEngine
    public Map<Integer, Set<Integer>> getSupportedLanguage() {
        return getSupportedLanguages();
    }

    public Map<Integer, Set<Integer>> getSupportedLanguages() {
        Map<Integer, Set<Integer>> language = new HashMap<>();
        Set<Integer> subLanguage1 = new HashSet<>();
        subLanguage1.add(20);
        subLanguage1.add(40);
        subLanguage1.add(30);
        subLanguage1.add(10);
        language.put(10, subLanguage1);
        Set<Integer> subLanguage2 = new HashSet<>();
        subLanguage2.add(10);
        subLanguage2.add(30);
        language.put(30, subLanguage2);
        Set<Integer> subLanguage3 = new HashSet<>();
        subLanguage3.add(10);
        subLanguage3.add(40);
        language.put(40, subLanguage3);
        Set<Integer> subLanguage4 = new HashSet<>();
        subLanguage4.add(10);
        subLanguage4.add(20);
        language.put(20, subLanguage4);
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

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!this.disposeFlag) {
                String translatedStr = null;
                String inLanguage = TranslationUtil.getParamLanguage(TranslatorEngineChangsinTest.this.mInLanguage);
                String outLanguage = TranslationUtil.getParamLanguage(TranslatorEngineChangsinTest.this.mOutLanguage);
                try {
                    translatedStr = TranslatorEngineChangsinTest.execute((String) msg.obj, inLanguage, outLanguage);
                } catch (Exception e) {
                    TranslatorEngineChangsinTest.this.logE("Translation error: " + e);
                }
                if (translatedStr != null) {
                    TranslatorEngineChangsinTest.this.logI("translated string: " + translatedStr);
                }
                TranslatorEngineChangsinTest.this.notifyTanslationEnd(translatedStr);
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.disposeFlag = true;
        }
    }

    public static String execute(String transText, String tranSourceLang, String tranTargetLang) {
        String result = null;
        try {
            CSTranslator tr = new CSTranslator();
            tr.setIp("14.63.223.243");
            int port = getTransServerPort(tranSourceLang, tranTargetLang);
            if (port > 0) {
                tr.setPort(port);
                result = tr.translate(transText);
            } else {
                result = "translation error occured. : unsupported language pair[" + tranSourceLang + "," + tranTargetLang + "]";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int getTransServerPort(String srcLang, String tarLang) {
        if (TranslationUtil.LANGUAGE_VALUE_KOREAN.equals(srcLang)) {
            if ("en-US".equals(tarLang)) {
                return 7702;
            }
            if (TranslationUtil.LANGUAGE_VALUE_JPANESE.equals(tarLang)) {
                return EventCode.EVENT_CALL_REMOTEROTATION;
            }
            if (!TranslationUtil.LANGUAGE_VALUE_CHINESE.equals(tarLang)) {
                return -1;
            }
            return 7704;
        }
        if (!TranslationUtil.LANGUAGE_VALUE_KOREAN.equals(tarLang)) {
            return -1;
        }
        if ("en-US".equals(srcLang)) {
            return 7703;
        }
        if (TranslationUtil.LANGUAGE_VALUE_JPANESE.equals(srcLang)) {
            return EventCode.EVENT_CALL_REMOTEROTATION_P2P_CONF;
        }
        if (!TranslationUtil.LANGUAGE_VALUE_CHINESE.equals(srcLang)) {
            return -1;
        }
        return 7705;
    }
}
