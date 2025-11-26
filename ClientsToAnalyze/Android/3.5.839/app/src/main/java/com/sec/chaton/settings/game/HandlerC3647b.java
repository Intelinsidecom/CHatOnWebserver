package com.sec.chaton.settings.game;

import android.os.Handler;
import android.os.Message;

/* compiled from: GameMobileWebFragment.java */
/* renamed from: com.sec.chaton.settings.game.b */
/* loaded from: classes.dex */
class HandlerC3647b extends Handler {

    /* renamed from: a */
    final /* synthetic */ GameMobileWebFragment f13219a;

    HandlerC3647b(GameMobileWebFragment gameMobileWebFragment) {
        this.f13219a = gameMobileWebFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f13219a.loadUrl((String) message.obj);
    }
}
