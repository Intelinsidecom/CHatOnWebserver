package com.coolots.chaton.call.util;

import com.coolots.chaton.call.util.ChatOnTranslationDataController;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class AvailableState implements PlayerState {
    BubbleTTSPlayer mBubbleTTSPlayer;
    ChatOnTranslationDataController mDataController;
    ITranslationTTSInterface mTranslationTTSInterface;

    public AvailableState(ChatOnTranslationDataController DataController, ITranslationTTSInterface iTranslationTTSInterface, BubbleTTSPlayer bubbleTTSPlayer) {
        this.mDataController = DataController;
        this.mTranslationTTSInterface = iTranslationTTSInterface;
        this.mBubbleTTSPlayer = bubbleTTSPlayer;
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void FirstTTSplay() {
        ChatOnTranslationDataController.TranslationDisplayTTSData TTSData = this.mDataController.getFirstTranslationDisplayTTSData();
        if (TTSData != null) {
            TTSData.setTTSReadDone(2);
            this.mTranslationTTSInterface.TTS_Start(TTSData.getTranslationDisplayData());
            changeState();
        }
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void TTSplay() {
        ChatOnTranslationDataController.TranslationDisplayTTSData TTSData = this.mDataController.getNextTranslationDisplayTTSData();
        if (TTSData != null) {
            Log.m2963i("YKYU TTSplay TTSData = " + TTSData.getTranslationDisplayData().getTranslatedText());
            TTSData.setTTSReadDone(2);
            this.mTranslationTTSInterface.TTS_Start(TTSData.getTranslationDisplayData());
            changeState();
        }
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void TTSstop() {
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void changeState() {
        this.mBubbleTTSPlayer.changeState(this.mBubbleTTSPlayer.getDisavailableState());
    }
}
