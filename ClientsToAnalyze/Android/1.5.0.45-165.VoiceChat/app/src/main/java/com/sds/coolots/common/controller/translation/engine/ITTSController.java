package com.sds.coolots.common.controller.translation.engine;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;

/* loaded from: classes.dex */
public interface ITTSController {
    void dispose();

    void init();

    void play(TranslationDisplayData translationDisplayData);

    void stop();
}
