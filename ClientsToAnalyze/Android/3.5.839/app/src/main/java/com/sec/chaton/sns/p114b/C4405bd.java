package com.sec.chaton.sns.p114b;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.VKResponse;
import com.p137vk.sdk.api.model.VKUsersArray;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.bd */
/* loaded from: classes.dex */
class C4405bd extends VKRequest.VKRequestListener {

    /* renamed from: a */
    final /* synthetic */ int f15947a;

    /* renamed from: b */
    final /* synthetic */ C4403bb f15948b;

    C4405bd(C4403bb c4403bb, int i) {
        this.f15948b = c4403bb;
        this.f15947a = i;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        if (vKResponse.parsedModel instanceof VKUsersArray) {
            this.f15948b.f15943e.mo16563a(this.f15947a, -1, vKResponse.parsedModel);
        } else {
            this.f15948b.f15943e.mo16563a(this.f15947a, DlcApi.RC_SVC_NOT_CONNECTED, null);
        }
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        C4904y.m18634a("error from VK getfriends error code is: " + vKError.errorCode + " error msg is: " + vKError.errorMessage + " error api error is :" + vKError.apiError, "[VkontakteManager]");
        this.f15948b.m16719a(vKError, this.f15947a);
    }
}
