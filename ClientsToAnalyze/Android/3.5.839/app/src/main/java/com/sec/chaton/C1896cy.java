package com.sec.chaton;

import com.sec.chaton.account.C1002i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.cy */
/* loaded from: classes.dex */
class C1896cy implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7115a;

    C1896cy(TabActivity tabActivity) {
        this.f7115a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
        C1002i.m6073c("uploadAddress");
        C4865cc.m18447a(true);
        return true;
    }
}
