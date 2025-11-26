package com.sec.chaton.userprofile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bp */
/* loaded from: classes.dex */
class C1666bp extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f6159a;

    C1666bp(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f6159a = relationshipRankFragment2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        if (intent.getAction().equals("com.sec.chaton.ACTION_DISPALY_WEEK") && (i = intent.getExtras().getInt("WEEK_DETAILS")) > 0 && i < 5) {
            this.f6159a.m5694a(i);
            this.f6159a.f6014w = i;
        }
    }
}
