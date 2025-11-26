package com.sec.chaton.userprofile;

import com.sec.chaton.C0062R;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.bb */
/* loaded from: classes.dex */
class C0575bb implements FacebookManager.OnResultListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRank2 f3557a;

    C0575bb(RelationshipRank2 relationshipRank2) {
        this.f3557a = relationshipRank2;
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onReady(int i, boolean z) {
        this.f3557a.showDialog(0);
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onResult(int i, int i2, String str) {
        this.f3557a.dismissDialog(0);
        if (i2 == -1) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Success : " + (str != null ? str : ""), getClass().getSimpleName());
            this.f3557a.m3333a(C0062R.string.facebook_post_completed);
        } else if (i2 == 0) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
        } else {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
            this.f3557a.m3333a(C0062R.string.facebook_post_failed);
        }
    }
}
