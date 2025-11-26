package com.coolots.chaton.call.util;

import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class DisAvailableState implements PlayerState {
    BubbleTTSPlayer mBubbleTTSPlayer;

    public DisAvailableState(BubbleTTSPlayer bubbleTTSPlayer) {
        this.mBubbleTTSPlayer = bubbleTTSPlayer;
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void FirstTTSplay() {
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void TTSplay() {
        Log.m2963i("YKYU TTSplay Not play state");
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void TTSstop() {
        changeState();
    }

    @Override // com.coolots.chaton.call.util.PlayerState
    public void changeState() {
        this.mBubbleTTSPlayer.changeState(this.mBubbleTTSPlayer.getAvailableState());
    }
}
