package com.coolots.chaton.call.util;

import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class BubbleTTSPlayer implements DisposeInterface {
    private AvailableState mAvailableState;
    private ChatOnTranslationDataController mDataController;
    private ITranslationTTSInterface mITranslationTTSInterface;
    private PlayerState mplayerState;
    private boolean mIsCompleteInit = false;
    private DisAvailableState mDisAvailableState = new DisAvailableState(this);
    private FinishState mFinishState = new FinishState();

    public BubbleTTSPlayer(ChatOnTranslationDataController DataController, ITranslationTTSInterface iTranslationTTSInterface) {
        this.mDataController = DataController;
        this.mITranslationTTSInterface = iTranslationTTSInterface;
        this.mAvailableState = new AvailableState(this.mDataController, this.mITranslationTTSInterface, this);
    }

    public void init() {
        this.mplayerState = this.mDisAvailableState;
        stop();
        this.mplayerState.FirstTTSplay();
    }

    public boolean IsComplete_init() {
        return this.mIsCompleteInit;
    }

    public void play() {
        this.mplayerState.TTSplay();
    }

    public void stop() {
        this.mplayerState.TTSstop();
    }

    public void finish() {
        changeState(this.mFinishState);
    }

    public void changeState(PlayerState playerState) {
        this.mplayerState = playerState;
    }

    public PlayerState getAvailableState() {
        return this.mAvailableState;
    }

    public PlayerState getDisavailableState() {
        return this.mDisAvailableState;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }
}
