package com.sec.chaton.chat;

import com.sec.chaton.global.C2349a;
import com.sec.chaton.util.C4809aa;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ab */
/* loaded from: classes.dex */
class RunnableC1555ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1554aa f5956a;

    RunnableC1555ab(C1554aa c1554aa) {
        this.f5956a = c1554aa;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5956a.f5955b.f5624cN != null) {
            if (C2349a.m10301a("chatroom_draw_menu_feature")) {
                if (!C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue()) {
                    this.f5956a.f5955b.m8273r();
                    return;
                }
                return;
            }
            this.f5956a.f5955b.m8273r();
        }
    }
}
