package com.vlingo.sdk.recognition;

import java.util.List;

/* loaded from: classes.dex */
public interface VLRecognitionResult {
    List<VLAction> getActions();

    String getDialogGUID();

    byte[] getDialogState();

    int getDialogTurn();

    String getGUttId();

    NBestData getNBestData();

    String getResultString();
}
