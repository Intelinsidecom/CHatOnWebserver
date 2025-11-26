package com.samsung.samm.common;

import android.util.Log;
import com.samsung.samm.lib.engine.p004a.C0908a;

@Deprecated
/* loaded from: classes.dex */
public class SDataAudio {

    /* renamed from: a */
    private String f408a = null;

    @Deprecated
    public SDataAudio() {
    }

    @Deprecated
    public String getFilePath() {
        return this.f408a;
    }

    @Deprecated
    public void setFilePath(String str) {
        this.f408a = str;
    }

    @Deprecated
    public int getPlayTimeMilliSec() {
        if (this.f408a != null) {
            return C0908a.m641b(this.f408a);
        }
        Log.e("SAMMLibrary", "There is no audio resource");
        return 0;
    }
}
