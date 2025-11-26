package com.vlingo.client.phrasespotter;

import android.util.Log;

/* loaded from: classes.dex */
public class SensoryEngineWrapper {
    private static SensoryJNI uniqueInstance;

    private SensoryEngineWrapper() {
    }

    public static synchronized SensoryJNI getInstance() {
        if (uniqueInstance == null) {
            Log.e("SensoryEngineWrapper", "getInstance() : make new SensoryJNI");
            SensoryJNI.init();
            uniqueInstance = new SensoryJNI();
        } else {
            Log.e("SensoryEngineWrapper", "getInstance() : get existed SensoryJNI");
        }
        return uniqueInstance;
    }
}
