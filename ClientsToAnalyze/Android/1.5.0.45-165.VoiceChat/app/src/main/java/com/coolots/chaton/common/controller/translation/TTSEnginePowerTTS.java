package com.coolots.chaton.common.controller.translation;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.TTSEngine;
import com.sds.coolots.common.util.Log;
import java.util.HashSet;
import java.util.Set;
import kr.p019co.hcilab.powertts.PowerTTS_Java;

/* loaded from: classes.dex */
public class TTSEnginePowerTTS extends TTSEngine {
    private static final String DbDir = "/sdcard/TTSDB120/KorDB.Yujin120/";
    private PowerTTS_Java myPowerTTS = null;

    public void logE(String message) {
        Log.m2958e("[TTSEnginePowerTTS]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[TTSEnginePowerTTS]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public void init() {
        super.init();
        if (this.myPowerTTS == null) {
            this.myPowerTTS = new PowerTTS_Java();
            this.myPowerTTS.PTTS_SetOemKey("TEMP");
            this.myPowerTTS.PTTS_Initialize();
        }
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public Set<Integer> getSupportedLanguage() {
        Set<Integer> language = new HashSet<>();
        language.add(10);
        return null;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public boolean play(TranslationDisplayData data) {
        super.play(data);
        notifyStart();
        logI("PowerTTS play start: " + data.getTranslatedText());
        this.myPowerTTS.PTTS_LoadEngine(0, DbDir, 0);
        this.myPowerTTS.PTTS_PlayTTS(data.getTranslatedText(), "", 0, 0);
        this.myPowerTTS.PTTS_UnLoadEngine(0);
        return true;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public void dispose() {
        if (this.myPowerTTS != null) {
            this.myPowerTTS.PTTS_UnInitialize();
            this.myPowerTTS = null;
        }
        super.dispose();
    }
}
