package com.sec.chaton.sns.p114b;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.VKResponse;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.bf */
/* loaded from: classes.dex */
class C4407bf extends VKRequest.VKRequestListener {

    /* renamed from: a */
    final /* synthetic */ int f15951a;

    /* renamed from: b */
    final /* synthetic */ C4403bb f15952b;

    C4407bf(C4403bb c4403bb, int i) {
        this.f15952b = c4403bb;
        this.f15951a = i;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        this.f15952b.f15943e.mo16563a(this.f15951a, -1, null);
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        this.f15952b.m16719a(vKError, this.f15951a);
    }
}
