package com.sec.chaton.chat;

import com.sec.chaton.smsplugin.p112ui.C4108aq;
import java.util.Comparator;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.fx */
/* loaded from: classes.dex */
class C1724fx implements Comparator<C4108aq> {

    /* renamed from: a */
    final /* synthetic */ C1723fw f6373a;

    C1724fx(C1723fw c1723fw) {
        this.f6373a = c1723fw;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C4108aq c4108aq, C4108aq c4108aq2) {
        return this.f6373a.m8541a(c4108aq).compareTo(this.f6373a.m8541a(c4108aq2));
    }
}
