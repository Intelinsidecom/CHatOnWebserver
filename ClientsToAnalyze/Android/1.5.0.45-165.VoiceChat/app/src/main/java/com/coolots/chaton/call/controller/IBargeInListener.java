package com.coolots.chaton.call.controller;

/* loaded from: classes.dex */
public interface IBargeInListener {
    public static final int BARGE_IN_RESULT_ANSWER = 1;
    public static final int BARGE_IN_RESULT_REJECT = 2;

    void onResultBargeIn(int i);
}
