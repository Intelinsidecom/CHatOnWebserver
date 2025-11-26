package com.sec.chaton.chat;

import android.view.WindowManager;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aq */
/* loaded from: classes.dex */
class RunnableC0541aq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0578br f1897a;

    RunnableC0541aq(C0578br c0578br) {
        this.f1897a = c0578br;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ChatActivity) this.f1897a.f1996b.getActivity()).m2598c(this.f1897a.f1996b.f1806ap);
        try {
            this.f1897a.f1996b.m2688a(((WindowManager) this.f1897a.f1996b.getActivity().getSystemService("window")).getDefaultDisplay());
        } catch (Exception e) {
            C1341p.m4653a(e, ChatFragment.f1725a);
        }
    }
}
