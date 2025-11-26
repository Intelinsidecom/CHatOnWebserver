package com.sec.chaton.interlocked;

import android.content.Intent;
import com.sec.chaton.HandleIntent;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.trunk.database.DatabaseConstant;

/* loaded from: classes.dex */
public class InterlockedText implements InterlockWithNative {

    /* renamed from: a */
    private Intent f1914a;

    public InterlockedText(Intent intent) {
        this.f1914a = intent;
    }

    @Override // com.sec.chaton.interlocked.InterlockWithNative
    /* renamed from: a */
    public HandleIntent.IntentDest mo2391a() {
        this.f1914a.putExtra("callForward", true);
        if (!this.f1914a.getExtras().containsKey("android.intent.extra.TEXT")) {
            return HandleIntent.IntentDest.HOME;
        }
        this.f1914a.putExtra("download_uri", this.f1914a.getExtras().getString("android.intent.extra.TEXT"));
        this.f1914a.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, ChatONContract.MessageTable.MsgContentType.TEXT.m2197a());
        return HandleIntent.IntentDest.FORWARD;
    }
}
