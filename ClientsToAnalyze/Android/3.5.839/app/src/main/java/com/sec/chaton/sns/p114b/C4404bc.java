package com.sec.chaton.sns.p114b;

import com.p137vk.sdk.VKAccessToken;
import com.p137vk.sdk.VKSdkListener;
import com.p137vk.sdk.api.VKError;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.bc */
/* loaded from: classes.dex */
class C4404bc extends VKSdkListener {

    /* renamed from: a */
    final /* synthetic */ C4403bb f15946a;

    C4404bc(C4403bb c4403bb) {
        this.f15946a = c4403bb;
    }

    @Override // com.p137vk.sdk.VKSdkListener
    public void onTokenExpired(VKAccessToken vKAccessToken) {
    }

    @Override // com.p137vk.sdk.VKSdkListener
    public void onCaptchaError(VKError vKError) {
    }

    @Override // com.p137vk.sdk.VKSdkListener
    public void onAccessDenied(VKError vKError) {
    }
}
